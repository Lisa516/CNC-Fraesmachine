package application;

public class Spindel implements Runnable {
	public static boolean spindelStatus = false;
	// false = aus, true = ein
	
	public static char spindelDrehrichtung = '0';
	//0 = aus, r = im Uhrzeigersinn (Rechtslauf), l = gegen den Uhrzeigersinn (Linkslauf)	
	
	public static boolean _getSpindelStatus() {
		return spindelStatus;
	}
	
	public static void spindelStopp() {
		if (spindelStatus == true) {
			spindelStatus = false;
			spindelDrehrichtung = '0';
		}
		else {
			ErrorHandling.spindelStopped();
		}
	}
	
	public static void spindelStart(char richtung) {
		if (spindelStatus == false) {
			spindelStatus = true;
			if (richtung == 'r') {
				spindelDrehrichtung = 'r';
			}
			else if (richtung == 'l') {
				spindelDrehrichtung = 'l';
			}
			else {
				ErrorHandling.ungueltigeDrehrichtung(richtung);
			}
		}
		else {
			ErrorHandling.spindelRunning();
		}
	}
	
	public static void spindelStart() {
		if (spindelStatus == false) {
			spindelStatus = true;
			spindelDrehrichtung = 'r';
			//Drehen im Uhrzeigersinn falls nichts übergeben
		}
		else {
			ErrorHandling.spindelRunning();
		}
	}
	
	public static void changeDrehrichtung(char richtung) {
		if (spindelStatus == true) {
			if (richtung == 'r') {
				spindelDrehrichtung = 'r';
			}
			else if (richtung == 'l') {
				spindelDrehrichtung = 'l';
			}
			else {
				ErrorHandling.ungueltigeDrehrichtung(richtung);
			}
		}
		else {
			ErrorHandling.spindelAus();
		}
	}
	
	public static String SpindelAusgabe() {
		String statusAusgabe;
		String drehrichtungAusgabe;
		if (spindelStatus == false) {
			statusAusgabe = "aus";
			drehrichtungAusgabe = "aus";
		}
		else {
			statusAusgabe = "ein";
			if (spindelDrehrichtung == 'r') {
				drehrichtungAusgabe = "Rechtslauf";
			}
			else {
				drehrichtungAusgabe = "Linkslauf";
			}
		}
		return ("Spindelstatus: " + statusAusgabe + "\n" + "Drehrichtung: " + drehrichtungAusgabe);
	}
	
	public void run() {
		//TODO: Insert Thread Actions here
	}

}

//Lisa
