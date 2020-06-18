public class Spindel {
	public boolean spindelStatus = 0;
	// 0 = aus, 1 = ein
	
	public char spindelDrehrichtung = '0';
	// 0 = aus, r = im Uhrzeigersinn (Rechtslauf), l = gegen den Uhrzeigersinn (Linkslauf)	
	
	public void spindelStopp() {
		if (status == 1) {
			status == 0;
		}
		else {
			//TODO: Fehlermeldung, dass Spindel nicht läuft
		}
	}
	
	public void spindelStart() {
		if (status == 0) {
			status == 0;
		}
		else {
			//TODO: Fehlermeldung, dass Spindel läuft 
		}
	}
	
	public String toString() {
		String statusAusgabe;
		String drehrichtungAusgabe;
		if (spindelStatus == 0) {
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
		return (Spindelstatus)
	}
	
	public _setSpindelDrehrichtung(char richtung) {
		if (spindelStatus == 0) {
			spindelDrehrichtung = '0'
		}
		else if (richtung == 'r') {
			spindelDrehrichtung = 'r';
		}
		else if (richtung == 'l') {
			spindelDrehrichtung = 'l'
		}
	}

}
