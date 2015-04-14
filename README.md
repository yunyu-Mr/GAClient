# GAClient
GamingAnywhere client for Android  
Add bluetooth reciever so that users can control cloud gaming 
via bluetooth devices such as mobile phone.  
Saoming

### Instructions
1.Open bluetooth  
2.Open GAClient and choose "Bluetooth"  
3.Open BluetoothClient(BluetoothChat), click play  
4.Choose the device that you want to connect  
5.Ok, Enjoy gaming!  
  
### BluetoothController
1.Accelerometer(Gravity sensor)  
2.Pad  
3.Key: SPACE, ESC  
4.Mouse: LeftClick, RightClick  
  

### Attension
Remember add bluetooth permission in AndroidManifest.xml  
`<!-- Bluetooth permission -->  
<uses-permission android:name="android.permission.BLUETOOTH" />  
<uses-permission android:name="android.permission.BLUETOOTH_ADMIN" />`  
If not add permission, app will crash when require bluetooth.  
  
### About code
### Class BluetoothController:
ControlSense() - judge what control type that bluetooth receive and then 
                 send via GAClient
                 
  
Add virtual method "createBluetooth()" at GAController.java, in order to let 
(GAController)BluetoothController to implement and use subclass's method.
 Because BluetoothController extends GAController.
  
  


