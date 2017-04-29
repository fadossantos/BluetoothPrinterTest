package tmsfasdom.com.br.bluetoothtestprinter;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

/**
 * Created by 22471279830 on 25/04/2017.
 */

public class BluetoothBroadcastReceiver extends BroadcastReceiver {
    Context context;
    Intent intent;
    Handler mhandler;

    public BluetoothBroadcastReceiver(Context context, Intent intent, Handler mhandler) {
        this.context = context;
        this.intent = intent;
        this.mhandler = mhandler;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        //acao tomada quando encontra um device --> verifica se é a impressora, caso positivo para a busca e habilita o botao
        if (BluetoothDevice.ACTION_FOUND.equals(action)) {
            BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            if (device.getName() != null && device.getName().contentEquals("Mobile Printer")) {
                mhandler.obtainMessage(MainActivity.ATIVAR_BOTAO,device).sendToTarget();
            }
        }
        //acao tomada nas mudancas de estado do bluetooth
        if (action.equals(BluetoothAdapter.ACTION_STATE_CHANGED)) {

            final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE,
                    BluetoothAdapter.ERROR);
            switch (state) {
                case BluetoothAdapter.STATE_OFF: {
                    mhandler.obtainMessage(MainActivity.DESATIVAR_BOTAO).sendToTarget();
                    break;
                }
                case BluetoothAdapter.STATE_TURNING_OFF: {
                    break;
                }
                case BluetoothAdapter.STATE_ON: {
                    mhandler.obtainMessage(MainActivity.INICIAR_BUSCA_IMPRESSORA).sendToTarget();
                    break;
                }
                case BluetoothAdapter.STATE_TURNING_ON: {
                    break;
                }
            }
        }
    }
}
