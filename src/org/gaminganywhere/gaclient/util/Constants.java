package org.gaminganywhere.gaclient.util;

public interface Constants {
	//Key
	public final String KEY_UP = "UP";
	public final String KEY_DOWN = "DOWN";
	public final String KEY_LEFT = "LEFT";
	public final String KEY_RIGHT = "RIGHT";
	
	//Bluetooth transmite data type
	public final int TEXT_DATA = 1;
	public final int CONTROL_DATA = 2;
	
	//Send event type
	public final int KEY_EVENT = 1;
	public final int MOUSE_KEY = 2;
	public final int MOUSE_MOTION = 3;
	public final int ARROW_KEY = 4;
	public final int ACCELERATION = 5;
	public final int GESTURE_EVENT = 6;
	
	//Gesture event type
	public final int GESTURE_HIT = 1;
	public final int GESTURE_PUSH = 2;
	public final int GESTURE_CHOP = 3;
	public final int GESTURE_CIRCLE = 4;
	public final int GESTURE_UP = 5;
	public final int GESTURE_PRESS = 6;
	public final int GESTURE_CUT = 7;
}
