package application;

public class Fraeskopf implements Runnable {
	public static double fahrGeschwindigkeit;
	public static int schnittGeschwindigkeit;
	public static boolean fraesenStatus = false;
	//
	public static double positionX;
	public static double positionY;
	
	public Fraeskopf() {
		positionX = 0;
		positionY = 0;
	}
	
	public static double _getFahrGeschwindigkeit() {
		return fahrGeschwindigkeit;
	}
	
	public static void _setFahrGeschwindigkeit(double v) {
		fahrGeschwindigkeit = v;
	}
	
	public static int _getSchnittGeschwindigkeit() {
		return schnittGeschwindigkeit;
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
	
	public static String _getFraesenStatus() {
		if (fraesenStatus == false) {
			return "Die Fräse ist aus";
		}
		else {
			return "Die Fräse ist an";
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
	
	public static void _setPositionX(int x) {
		if(x > 0 && x < 1400) {
			positionX = x;
		}
		else {
			ErrorHandling.OutOfRangeX(x);
		}
	}
	
	public static void _setPositionY(int y) {
		if(y > 0 && y < 1050) {
			positionY = y;
		}
		else {
			ErrorHandling.OutOfRangeY(y);
		}
	}
	
	public void fraeskopfPositionieren(int x, int y) {
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
