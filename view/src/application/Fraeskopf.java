package application;

public class Fraeskopf implements Runnable {
	private static double fahrGeschwindigkeit;
	private static int schnittGeschwindigkeit;
	private static boolean fraesenStatus = false;
	private static double positionX;
	private static double positionY;
	
	//Konstruktor
	public Fraeskopf() {
		positionX = 0;
		positionY = 0;
	}
	
	//Getter
	public static double _getFahrGeschwindigkeit() {
		return fahrGeschwindigkeit;
	}
	
	public static int _getSchnittGeschwindigkeit() {
		return schnittGeschwindigkeit;
	}
	
	public static boolean _getFraesenStatus() {
		return fraesenStatus;
	}
	
	public static String statusToString() {
		if (fraesenStatus == false) {
			return "Die Fräse ist aus";
		}
		else {
			return "Die Fräse ist an";
		}
	}
	
	public static void _setFahrGeschwindigkeit(double v) {
		fahrGeschwindigkeit = v;
	}

	public void _setSchnittGeschwindigkeit(boolean kuehlmittelStatus) {
		if (kuehlmittelStatus == true) {
			schnittGeschwindigkeit = 3;
		}
		else {
			schnittGeschwindigkeit = 2;
		}
	}
	
	public static double _getGeschwindigkeit(boolean fraesenStatus) {
		if (fraesenStatus == true) {
			return _getSchnittGeschwindigkeit();
		}
		else {
			return _getFahrGeschwindigkeit();
		}
	}
	
	public void startFraese() {
		if (fraesenStatus == false) {
			fraesenStatus = true;
		}
		else {
			ErrorHandling.fraeskopfRunning();
		}
	}
	
	public static void stoppFraese() {
		if (fraesenStatus == true) {
			fraesenStatus = false;
		}
		else {
			ErrorHandling.fraeskopfStopped();
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
	
	public void fraeskopfPositionieren(double x, double y) {
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
	
	public static String _getGeschwindigkeit() {
		if (fraesenStatus == true) {
			return (_getSchnittGeschwindigkeit() + " ");
		}
		else {
			return (_getFahrGeschwindigkeit() + " ");
		}
	}
	
	public void run() {
		//TODO: Insert Thread Actions here
	}
}
//Joshua
