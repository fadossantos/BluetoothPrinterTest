package tmsfasdom.com.br.bluetoothtestprinter;

import android.Manifest;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_ENABLE_BT = 1;
    public static final int REQUEST_COARSE_LOCATION = 10;
    public static final int ATIVAR_BOTAO = 100;
    public static final int DESATIVAR_BOTAO = 101;
    public static final int INICIAR_BUSCA_IMPRESSORA = 111;

    Button mainBtn;
    //obtem o adapter de bluetooth do android
    BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    //socket de comunicacao
    BluetoothSocket btSocket;
    //impressora
    BluetoothDevice bluetoothDevice;
    //stream de escrita
    OutputStream outputStream;
    String value = "";
    BuscaImpressoraThread buscaImpressoraThread;
    BluetoothBroadcastReceiver blReceiver;

    Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == ATIVAR_BOTAO) {
                mainBtn.setEnabled(true);
                buscaImpressoraThread.setContinuaBusca(false);
                bluetoothDevice = (BluetoothDevice)msg.obj;
                Log.e("BluetoothApp", "mudou continua busca para false no handler");
            }

            if (msg.what == INICIAR_BUSCA_IMPRESSORA) {
                if(buscaImpressoraThread == null || buscaImpressoraThread.isThreadBuscaImpressoraRodando() == false)
                {
                    buscaImpressoraThread = new BuscaImpressoraThread(bluetoothAdapter);
                    buscaImpressoraThread.start();
                    Log.e("BluetoothApp", "Chamou a thread do busca impressora no handler");
                }
            }

            if (msg.what == DESATIVAR_BOTAO) {
                mainBtn.setEnabled(false);
                if (!bluetoothAdapter.isEnabled()) {
                    Intent i = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(i, REQUEST_ENABLE_BT);
                }
            }
        }
    };

    //metodo de checagem de permissao dinamica de uso da localizacao (android 6 e superiores)
    protected void checkLocationPermission() {
        if ((ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED)
                || (ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH)
                != PackageManager.PERMISSION_GRANTED)
                || (ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_ADMIN)
                != PackageManager.PERMISSION_GRANTED)
                || (ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_PRIVILEGED)
                != PackageManager.PERMISSION_GRANTED))
        {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.BLUETOOTH, Manifest.permission.BLUETOOTH_ADMIN, Manifest.permission.BLUETOOTH_PRIVILEGED},
                    REQUEST_COARSE_LOCATION);
        }
    }

    //retorno da intent de checagem de permissao
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_COARSE_LOCATION: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permissoes Concedidas", Toast.LENGTH_LONG).show();
                } else {
                    //forca perguntar denovo quando o user clica nao
                    checkLocationPermission();
                }
                break;
            }
        }
    }

    //retorno da intent de ligar o bluetooth
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_ENABLE_BT) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Bluetooth Ativado", Toast.LENGTH_LONG).show();
                if(buscaImpressoraThread == null || buscaImpressoraThread.isThreadBuscaImpressoraRodando() == false)
                {
                    buscaImpressoraThread = new BuscaImpressoraThread(bluetoothAdapter);
                    buscaImpressoraThread.start();
                    Log.e("BluetoothApp", "Chamou a thread do busca impressora no resultado positivo de ligar bluetooth");
                }
            } else {
                if (!bluetoothAdapter.isEnabled()) {
                    Intent i = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(i, REQUEST_ENABLE_BT);
                }
                else{
                    if(buscaImpressoraThread == null || buscaImpressoraThread.isThreadBuscaImpressoraRodando() == false)
                    {
                        buscaImpressoraThread = new BuscaImpressoraThread(bluetoothAdapter);
                        buscaImpressoraThread.start();
                        Log.e("BluetoothApp", "Chamou a thread do busca impressora no resultado negativo de ligar bluetooth");
                    }
                }
            }
        }
    }

    //oncreate da activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("BluetoothApp", "Entrou no onCreate");
        //verifica permissao
        checkLocationPermission();
        //registra receivers do bluetooth
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BluetoothDevice.ACTION_FOUND);
        intentFilter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED);
        blReceiver = new BluetoothBroadcastReceiver(this.getApplicationContext(), this.getIntent(), this.mHandler);
        registerReceiver(blReceiver, intentFilter);

        setContentView(R.layout.activity_main);
        mainBtn = (Button) findViewById(R.id.BtnPrint);
        //desabilita o botao
        mainBtn.setEnabled(false);

        //checa se o bluetooth esta ativo
        if (!bluetoothAdapter.isEnabled()) {
            Intent i = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(i, REQUEST_ENABLE_BT);
        }
        if(buscaImpressoraThread == null || buscaImpressoraThread.isThreadBuscaImpressoraRodando() == false)
        {
            buscaImpressoraThread = new BuscaImpressoraThread(bluetoothAdapter);
            buscaImpressoraThread.start();
            Log.e("BluetoothApp", "Chamou a thread do busca impressora no oncreate");
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        buscaImpressoraThread.setContinuaBusca(false);
        Log.e("BluetoothApp", "Entrou no onPause");
        Log.e("BluetoothApp", "Setou false no continua busca do onpause");
    }

    @Override
    public void onStop() {
        super.onStop();
        buscaImpressoraThread.setContinuaBusca(false);
        Log.e("BluetoothApp", "Entrou no onStop");
        Log.e("BluetoothApp", "Setou false no continua busca do onstop");
    }

    @Override
    public void onDestroy() {
        buscaImpressoraThread.setContinuaBusca(false);
        Log.e("BluetoothApp", "Entrou no onDestroy");
        unregisterReceiver(blReceiver);
        super.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("BluetoothApp", "Entrou no onResume");
        if(buscaImpressoraThread == null || buscaImpressoraThread.isThreadBuscaImpressoraRodando() == false)
        {
            buscaImpressoraThread = new BuscaImpressoraThread(bluetoothAdapter);
            buscaImpressoraThread.start();
            Log.e("BluetoothApp", "Chamou a thread do busca impressora no onresume");
        }
}

    public void onClickBtnPrint(View v) {

        //IntentPrint(ImpressaoBO.obterRequisicaoPericialLesao(null, null, null, null, null, null, null, null));
        //IntentPrint(ImpressaoBO.obterTermoCompromisso("2014522112", "24/04/2017", "FERNANDO ANDRADE DOS SANTOS - RG 44308344", "DANILO MARCELO CALLEGARI - RG 34334434", "SAO PAULO", "RUA RAFAEL IORIO 1200, CAMPO BELO - SAO PAULO/SP - CEP 01222001", "24/05/2017 18:00:00"));
        //IntentPrint(ImpressaoBO.obterTermoCompromisso("2014522112", "24/04/2017", "FERNANDO ANDRADE DOS SANTOS - RG 44308344", "DANILO MARCELO CALLEGARI - RG 34334434", "SAO PAULO", "RUA RAFAEL IORIO 1200, CAMPO BELO - SAO PAULO/SP - CEP 01222001", null));
        //IntentPrint(ImpressaoBO.obterTermoManifestacaoOfendido("2014522112", "24/04/2017", "FERNANDO ANDRADE DOS SANTOS - RG 44308344", "DANILO MARCELO CALLEGARI - RG 34334434", "SAO PAULO", "em exercer o direito de representacao ou queixa contra o autor do fato.", "RUA RAFAEL IORIO 1200, CAMPO BELO - SAO PAULO/SP - CEP 01222001", "24/05/2017 18:00:00"));
        //IntentPrint(ImpressaoBO.obterTermoCompromisso("", "", "", "", "", "", ""));
        //IntentPrint(ImpressaoBO.obterRequisicaoPericialLesao(null, null, null, null, null, null, null, null));
        byte[] param = ImpressaoBO.obterTermoCompromisso("2014522112", "24/04/2017", "FERNANDO ANDRADE DOS SANTOS - RG 44308344", "DANILO MARCELO CALLEGARI - RG 34334434", "SAO PAULO", "RUA RAFAEL IORIO 1200, CAMPO BELO - SAO PAULO/SP - CEP 01222001", "24/05/2017 18:00:00");
        AsyncTaskRunner runner = new AsyncTaskRunner();
        runner.execute(param);
    }

    //metodos de impressao efetiva
    public void IntentPrint(byte[] bytesImpressao) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InterruptedException {
        InitPrinter();
        outputStream.write(bytesImpressao);
        Thread.sleep(10000);
        outputStream.close();
        btSocket.close();
    }

    //metodos de impressao efetiva
    public void InitPrinter() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException {

        UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"); //Standard SerialPortService ID
        btSocket = bluetoothDevice.createRfcommSocketToServiceRecord(uuid);
        bluetoothAdapter.cancelDiscovery();
        btSocket.connect();
        outputStream = btSocket.getOutputStream();
    }

    private class AsyncTaskRunner extends AsyncTask<byte[], String, String> {

        ProgressDialog progressDialog;

        @Override
        protected String doInBackground(byte[]... params) {
            try {
                IntentPrint(params[0]);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Termino da impressao";
        }


        @Override
        protected void onPostExecute(String result) {
            progressDialog.dismiss();
            mainBtn.setEnabled(true);
        }


        @Override
        protected void onPreExecute() {
            mainBtn.setEnabled(false);
            progressDialog = ProgressDialog.show(MainActivity.this,
                    "Impressão",
                    "Por Favor aguarde... ");
        }


        @Override
        protected void onProgressUpdate(String... text) {
        }
    }
}