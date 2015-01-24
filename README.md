# GAClient
GamingAnywhere client for Android

### Attension
Remember add bluetooth permission in AndroidManifest.xml
`<!-- Bluetooth permission -->  
<uses-permission android:name="android.permission.BLUETOOTH" />  
<uses-permission android:name="android.permission.BLUETOOTH_ADMIN" />`  
If not add permission, app will crash when require bluetooth.  
  
### Class BluetoothController:
ControlSense() - judge what control type that bluetooth receive and then 
                 send via GAClient
                 
  
Add virtual method "createBluetooth()" at GAController.java, in order to let 
(GAController)BluetoothController to implement and use subclass's method.
 Because BluetoothController extends GAController.
 



