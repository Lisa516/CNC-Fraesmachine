package application;

public class Spindel extends Thread{
	public boolean spindelStatus = false;
	// false = aus, true = ein
	
	public char spindelDrehrichtung = '0';
	// 0 = aus, r = im Uhrzeigersinn (Rechtslauf), l = gegen den Uhrzeigersinn (Linkslauf)	
	
	public void spindelStopp() {
		if (spindelStatus == true) {
			spindelStatus = false;
		}
		else {
			ErrorHandling.spindelStopped();
		}
	}
	
	public void spindelStart() {
		if (spindelStatus == false) {
			spindelStatus = true;
		}
		else {
			ErrorHandling.spindelRunning();
		}
	}
	
	public String toString() {
		String statusAusgabe;
		String drehrichtungAusgabe;
		if (spindelStatus == false) {
			statusAusgabe = "aus";
		}
		else {
			statusAusgabe = "ein";
		}
		if (spindelDrehrichtung == 0) {
			drehrichtungAusgabe = "Rechtslauf";
		}
		else {
			drehrichtungAusgabe = "Linkslauf";
		}
		return ("Spindelstatus: " + statusAusgabe + "\n" + "Drehrichtung: " + drehrichtungAusgabe);
	}
	
	public void _setSpindelDrehrichtung(char richtung) {
		if (spindelStatus == false) {
			spindelDrehrichtung = '0';
		}
		else if (richtung == 'r') {
			spindelDrehrichtung = 'r';
		}
		else if (richtung == 'l') {
			spindelDrehrichtung = 'l';
		}
	}
	
	public void run() {
		//TODO: Insert Thread Actions here
	}

}

//Lisa
