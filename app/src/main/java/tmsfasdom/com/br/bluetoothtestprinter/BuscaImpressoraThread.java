package tmsfasdom.com.br.bluetoothtestprinter;

import android.bluetooth.BluetoothAdapter;
import android.util.Log;

/**
 * Created by 22471279830 on 25/04/2017.
 */

public class BuscaImpressoraThread extends Thread {


    private boolean threadBuscaImpressoraRodando = true;
    private boolean continuaBusca = true;
    private BluetoothAdapter bluetoothAdapter;

    public BuscaImpressoraThread(BluetoothAdapter btAdpter) {
        this.bluetoothAdapter = btAdpter;
    }

    public void setThreadBuscaImpressoraRodando(boolean threadBuscaImpressoraRodando) {
        this.threadBuscaImpressoraRodando = threadBuscaImpressoraRodando;
    }

    public void setContinuaBusca(boolean continuaBusca) {
        this.continuaBusca = continuaBusca;
    }

    public boolean isThreadBuscaImpressoraRodando() {
        return threadBuscaImpressoraRodando;
    }

    public boolean isContinuaBusca() {
        return continuaBusca;
    }

    @Override
    public void run() {

        Log.e("BluetoothApp", "Iniciou a thread BuscaImpressora");
        int i = 0;
        while (continuaBusca) {
            Log.e("BluetoothApp", "na Thread de busca Impressora" + i);
            i++;
            if (bluetoothAdapter.enable()) {
                if (bluetoothAdapter.isDiscovering()) {
                    bluetoothAdapter.cancelDiscovery();
                }
                bluetoothAdapter.startDiscovery();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        Log.e("BluetoothApp", "Finalizou a thread BuscaImpressora");
        threadBuscaImpressoraRodando = false;
    }

}
