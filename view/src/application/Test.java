package application;

public class Test implements Runnable{
	
	//Fraese sollte an sein. Test, ob dem so ist
	public static boolean testFraeseAn() {
		if (Fraeskopf._getFraesenStatus() == true) {
			return true;
		}
		ErrorHandling.befehlUnmoeglichFraeseAus();
		return false;
	}
	
	//Fraese sollte aus sein. Test, ob dem so ist
	public static boolean testFraeseAus() {
		if (Fraeskopf._getFraesenStatus() == false) {
			return true;
		}
		ErrorHandling.befehlUnmoeglichFraeseAn();
		return false;
	}
	
	//X-Wert muss auf der Arbeitsflaeche liegen
	public static boolean testXInRange(double x) {
		if (x >= 0 && x <= 1400) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Y-Wert muss auf der Arbeitsflaeche liegen
	public static boolean testYInRange(double y) {
		if (y >= 0 && y <= 1050) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//X- & Y-Wert testen, ob beide auf Arbeitsflaeche liegen
	public static boolean testXYInRange(double x, double y) {
		if (testXInRange(x) == true && testYInRange(y) == true) {
			return true;
		}
		return false;
	}
	
	//TODO: I und J testen
	
	public void run() {
		
	}
}
