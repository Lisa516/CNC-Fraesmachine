package kraemerfuchspruem;
public class Spindel {
	public boolean spindelStatus = false;
	// false = aus, true = ein
	
	public char spindelDrehrichtung = '0';
	// 0 = aus, r = im Uhrzeigersinn (Rechtslauf), l = gegen den Uhrzeigersinn (Linkslauf)	
	
	public void spindelStopp() {
		if (spindelStatus == true) {
			spindelStatus = false;
		}
		else {
			//TODO: Fehlermeldung, dass Spindel nicht läuft
		}
	}
	
	public void spindelStart() {
		if (spindelStatus == false) {
			spindelStatus = true;
		}
		else {
			//TODO: Fehlermeldung, dass Spindel läuft 
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
		return ("Spindelstatus: " + statusAusgabe + "Drehrichtung" );
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

}
