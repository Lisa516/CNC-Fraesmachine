package application;

public class MillingCutter implements Runnable {
	private static double drivingSpeed;
	private static int cuttingSpeed;
	private static boolean millingCutterStatus = false;
	private static double positionX;
	private static double positionY;
	
	//Constructor
	public MillingCutter() {
		positionX = 0;
		positionY = 0;
	}
	
	//Getter
	public static double _getDrivingSpeed() {
		return drivingSpeed;
	}
	
	public static int _getCuttingSpeed() {
		return cuttingSpeed;
	}
	
	public static boolean _getMillingStatus() {
		return millingCutterStatus;
	}
	
	public static String statusToString() {
		if (millingCutterStatus == false) {
			return "The milling cutter is on";
		}
		else {
			return "The milling cutter is off";
		}
	}
	
	public static void _setDrivingSpeed(double v) {
		drivingSpeed = v;
	}

	public void _setCuttingSpeed(boolean coolantStatus) {
		if (coolantStatus == true) {
			cuttingSpeed = 3;
		}
		else {
			cuttingSpeed = 2;
		}
	}
	
	public static double _getDrivingSpeed(boolean millingCutterStatus) {
		if (millingCutterStatus == true) {
			return _getCuttingSpeed();
		}
		else {
			return _getDrivingSpeed();
		}
	}
	
	public void startMillingCutter() {
		if (millingCutterStatus == false) {
			millingCutterStatus = true;
		}
		else {
			ErrorHandling.millRunning();
		}
	}
	
	public static void stopMillingCutter() {
		if (millingCutterStatus == true) {
			millingCutterStatus = false;
		}
		else {
			ErrorHandling.millStopped();
		}
	}
	
	public static void _setPositionX(double x) {
		if(x > 0 && x < 1400) {
			positionX = x;
		}
		else {
			ErrorHandling.OutOfRangeX(x);
		}
	}
	
	public static void _setPositionY(double y) {
		if(y > 0 && y < 1050) {
			positionY = y;
		}
		else {
			ErrorHandling.OutOfRangeY(y);
		}
	}
	
	public void positionMillingCutter(double x, double y) {
		_setPositionX(x);
		_setPositionY(y);
	}
	
	public static double _getPositionX() {
		return positionX;
	}
	
	public static double _getPositionY() {
		return positionY;
	}
	
	public static String _getPosition() {
		return "(" + _getPositionX() + ";" + _getPositionY() + ")";
	}
	
	public static String _getSpeed() {
		if (millingCutterStatus == true) {
			return (_getCuttingSpeed() + " ");
		}
		else {
			return (_getDrivingSpeed() + " ");
		}
	}
	
	public void run() {
		//TODO: Insert Thread Actions here
	}
}
//Joshua
