package tmsfasdom.com.br.bluetoothtestprinter;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    //Constante de retorno da intent de ligar bluetooth
    private static final int REQUEST_ENABLE_BT = 1;
    //Constante de retorno da intent de permissoes
    private static final int REQUEST_COARSE_LOCATION = 1;
    Button mainBtn;
    //obtem o adapter de bluetooth do android
    BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    //socket de comunicacao
    BluetoothSocket socket;
    //impressora
    BluetoothDevice bluetoothDevice;
    //stream de escrita
    OutputStream outputStream;
    //boolean de controle da thread
    boolean continuaBusca = true;
    //string de auxilio dos toasts
    String value = "";
    //thread de buscaImpressora (para forcar a descoberta automatica dos dispositivos) no fim das contas praticamente inutil.
    Thread buscaImpressora = new Thread() {

        public void run() {
            while (continuaBusca) {
                if (bluetoothAdapter.enable()) {
                    bluetoothAdapter.startDiscovery();
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    };
    //receiver dos status do bluetooth
    final BroadcastReceiver blReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            //acao tomada quando encontra um device --> verifica se é a impressora, caso positivo para a busca e habilita o botao
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                if (device.getName().contentEquals("Mobile Printer")) {
                    bluetoothDevice = device;
                    mainBtn.setEnabled(true);
                    continuaBusca = false;
                }
            }
            //acao tomada nas mudancas de estado do bluetooth
            if (action.equals(bluetoothAdapter.ACTION_STATE_CHANGED)) {

                final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE,
                        BluetoothAdapter.ERROR);
                switch (state) {
                    case BluetoothAdapter.STATE_OFF: {
                        mainBtn.setEnabled(false);
                        if (!bluetoothAdapter.isEnabled()) {
                            Intent i = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                            startActivityForResult(i, REQUEST_ENABLE_BT);
                        }
                        break;
                    }
                    case BluetoothAdapter.STATE_TURNING_OFF: {
                        mainBtn.setEnabled(false);
                        break;
                    }
                    case BluetoothAdapter.STATE_ON: {
                        bluetoothAdapter.startDiscovery();
                        Toast.makeText(context, "Bluetooth Ativado", Toast.LENGTH_LONG).show();
                        break;
                    }
                    case BluetoothAdapter.STATE_TURNING_ON: {
                        Toast.makeText(context, "Ativando Bluetooth", Toast.LENGTH_LONG).show();
                        break;
                    }
                }
            }
        }
    };

    //handler de mensagens da thread com a UI -> não usei mais mas deixei ele ai
    Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 0) {
                mainBtn.setEnabled(true);
                bluetoothDevice = (BluetoothDevice) msg.obj;
            }

            if (msg.what == 1) {
            }
        }
    };

    //metodo de checagem de permissao dinamica de uso da localizacao (android 6 e superiores)
    protected void checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
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
            } else {
                if (!bluetoothAdapter.isEnabled()) {
                    Intent i = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(i, REQUEST_ENABLE_BT);
                }
            }
        }
    }

    //oncreate da activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //verifica permissao
        checkLocationPermission();
        //registra receivers do bluetooth
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BluetoothDevice.ACTION_FOUND);
        intentFilter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED);
        registerReceiver(blReceiver, intentFilter);

        setContentView(R.layout.activity_main);
        mainBtn = (Button) findViewById(R.id.BtnPrint);
        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainBtn.setEnabled(false);
                IntentPrint(ImpressaoBO.obterRegua());
                mainBtn.setEnabled(true);
            }
        });
        //desabilita o botao
        mainBtn.setEnabled(false);

        //checa se o bluetooth esta ativo
        if (!bluetoothAdapter.isEnabled()) {
            Intent i = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(i, REQUEST_ENABLE_BT);
        }
        //se o bluetooth esta ativo inicia a descoberta de devices
        if (bluetoothAdapter.isEnabled()) {
            bluetoothAdapter.startDiscovery();
        }
        //inicia a thread de loop
        buscaImpressora.start();
    }

    //metodos de impressao efetiva
    public void IntentPrint(byte[] bytesImpressao) {
        InitPrinter();
        try {
            outputStream.write(bytesImpressao);
            outputStream.close();
            socket.close();
        } catch (Exception ex) {
            value += ex.toString() + "\n" + "Erro na Impressao \n";
            Toast.makeText(this, value, Toast.LENGTH_LONG).show();
        }

    }

    //metodos de impressao efetiva
    public void InitPrinter() {

        try {
            UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"); //Standard SerialPortService ID
            Method m = bluetoothDevice.getClass().getMethod("createRfcommSocket", new Class[]{int.class});
            socket = (BluetoothSocket) m.invoke(bluetoothDevice, 1);
            bluetoothAdapter.cancelDiscovery();
            socket.connect();
            outputStream = socket.getOutputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}