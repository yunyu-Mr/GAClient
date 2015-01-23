package org.gaminganywhere.gaclient.util;

import org.gaminganywhere.gaclient.util.Pad.PartitionEventListener;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import android.widget.RelativeLayout;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

import android.util.Log;

public class BluetoothController extends GAController{
	// Debugging
    private static final String TAG = "BluetoothController";
    private static final boolean D = true;

    // Message types sent from the BluetoothChatService Handler
    public static final int MESSAGE_STATE_CHANGE = 1;
    public static final int MESSAGE_READ = 2;
    public static final int MESSAGE_WRITE = 3;
    public static final int MESSAGE_DEVICE_NAME = 4;
    public static final int MESSAGE_TOAST = 5;

    // Key names received from the BluetoothChatService Handler
    public static final String DEVICE_NAME = "device_name";
    public static final String TOAST = "toast";

    // Intent request codes
    private static final int REQUEST_CONNECT_DEVICE_SECURE = 1;
    private static final int REQUEST_CONNECT_DEVICE_INSECURE = 2;
    private static final int REQUEST_ENABLE_BT = 3;
    
    // Name of the connected device
    private String mConnectedDeviceName = null;
    // String buffer for outgoing messages
    private StringBuffer mOutStringBuffer;
    // Local Bluetooth adapter
    private BluetoothAdapter mBluetoothAdapter = null;
    // Member object for the chat services
    private BluetoothService mBluetoothService = null;
    
    //Controller
    private Context context = null;
    private RelativeLayout relativeLayout = null;
    
    //Constructor
	public BluetoothController(Context context) {
		super(context);
	}

	public static String getName() {
		return "Bluetooth";
	}
	
	public static String getDescription() {
		return "Bluetooth";
	}
	
//	public Context getContext() {
//		return this.context;
//	}
	
	public void createBluetooth() {
		Log.i(TAG, "bt create");
        // Get local Bluetooth adapter
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        // If the adapter is null, then Bluetooth is not supported
        if (mBluetoothAdapter == null) {
            return;
        }
        if (!mBluetoothAdapter.isEnabled()){
        	Log.e(TAG, "bt");
        }
        Log.e(TAG, "bt");
        if (!mBluetoothAdapter.isEnabled()) {
        	Log.e(TAG, "bt is not enable");
            Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            Activity act = (Activity)context;
            act.startActivityForResult(enableIntent, REQUEST_ENABLE_BT);
        // Otherwise, setup
        } 
        else {
            if (mBluetoothService == null) 
            	mBluetoothService = new BluetoothService(mHandler);
            	
        }
        if (mBluetoothService != null) {
        	if (mBluetoothService.getState() == BluetoothService.STATE_NONE) {
        		mBluetoothService.start();
        	}
        }
	}
	
    /**
     * The Handler that gets information back from the BluetoothChatService
     * mHandler负责处理与后台BluetoothService的通信
 	 * 后台Service将msg发到这里来进行处理
     */
    private final Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
            case MESSAGE_STATE_CHANGE:
                if(D) Log.i(TAG, "MESSAGE_STATE_CHANGE: " + msg.arg1);
//                switch (msg.arg1) {
//                case BluetoothService.STATE_CONNECTED:
//                    setStatus(getString(R.string.title_connected_to, mConnectedDeviceName));
////                    mConversationArrayAdapter.clear();
//                    break;
//                case BluetoothService.STATE_CONNECTING:
//                    setStatus(R.string.title_connecting);
//                    break;
//                case BluetoothService.STATE_LISTEN:
//                case BluetoothService.STATE_NONE:
//                    setStatus(R.string.title_not_connected);
//                    break;
//                }
                break;
            case MESSAGE_WRITE:
                byte[] writeBuf = (byte[]) msg.obj;
                // construct a string from the buffer
                String writeMessage = new String(writeBuf);
//                mConversationArrayAdapter.add("Me:  " + writeMessage);
                break;
            case MESSAGE_READ:
                byte[] readBuf = (byte[]) msg.obj;
                // construct a string from the valid bytes in the buffer
                String readMessage = new String(readBuf, 0, msg.arg1);
//                mConversationArrayAdapter.add(mConnectedDeviceName+":  " + readMessage);
                break;
            case MESSAGE_DEVICE_NAME:
                // save the connected device's name
                mConnectedDeviceName = msg.getData().getString(DEVICE_NAME);
                Toast.makeText(getContext(), "Connected to "
                               + mConnectedDeviceName, Toast.LENGTH_SHORT).show();
                break;
            case MESSAGE_TOAST:
                Toast.makeText(getContext(), msg.getData().getString(TOAST),
                               Toast.LENGTH_SHORT).show();
                break;
            }
        }
    };
	
//	public void onActivityResult(int requestCode, int resultCode, Intent data){
//		switch (requestCode) {
//		case REQUEST_ENABLE_BT:
//			if (resultCode == Activity.RESULT_OK){
//				//setup
//			}
//		}
//	}


}
