package application;

public class MillingCutter implements Runnable {
///////////
	private static double drivingSpeed;
	private static int cuttingSpeed;
	private static boolean millingCutterStatus = false;
////////////////////7
	private static double movingVelocity;
	private static int millingVelocity;
	private static boolean millingStatus = false;
/////////////////////
	private static double positionX;
	private static double positionY;
	
	//Constructor
	public MillingCutter() {
		positionX = 0;
		positionY = 0;
	}
	
	//Getter
/////////////////////
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
//////////////////////////
	public static double _getMovingVelocity() {
		return movingVelocity;
	}
	
	public static int _getMillingVelocity() {
		return millingVelocity;
	}
	
	public static boolean _getMillingStatus() {
		return millingStatus;
	}
	
	public static String statusToString() {
		if (millingStatus == false) {
			return "The mill is not running.";
		}
		else {
			return "The mill is running.";
		}
	}
	
	public static void _setMovingVelocity(double v) {
		movingVelocity = v;
	}

	public void _setMillingVelocity(boolean kuehlmittelStatus) {
		if (kuehlmittelStatus == true) {
			millingVelocity = 3;
		}
		else {
			millingVelocity = 2;
		}
	}
	
	public static double _getVelocity(boolean fraesenStatus) {
		if (fraesenStatus == true) {
			return _getMillingVelocity();
		}
		else {
			return _getMovingVelocity();
		}
	}
	
	public void startFraese() {
		if (millingStatus == false) {
			millingStatus = true;
////////////////////
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
	
	public static String _getVelocity() {
		if (millingStatus == true) {
			return (_getMillingVelocity() + " ");
		}
		else {
			return (_getMovingVelocity() + " ");
		}
	}
	
	public void run() {
		//TODO: Insert Thread Actions here
	}
}
//Joshua
