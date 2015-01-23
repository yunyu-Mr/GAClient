package org.gaminganywhere.gaclient.util;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.RelativeLayout;
import android.widget.Toast;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class BluetoothController{
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
    private BluetoothService mChatService = null;
    
    //Controller
    private Context context = null;
    private RelativeLayout relativeLayout = null;
    
    //Constructor
	public BluetoothController(Context context) {
		this.context = context;
		relativeLayout = new RelativeLayout(getContext());
	}

	public static String getName() {
		return "Bluetooth";
	}
	
	public static String getDescription() {
		return "Bluetooth";
	}
	
	public Context getContext() {
		return this.context;
	}
	
	public void CreateBluetooth() {
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
        Log.i(TAG, "bt enable");
//        else {
//            if (mChatService == null) 
//            	setupChat();
//        }
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent data){
		switch (requestCode) {
		case REQUEST_ENABLE_BT:
			if (resultCode == Activity.RESULT_OK){
				//setup
			}
		}
	}
	
	


}
