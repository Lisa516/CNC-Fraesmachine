package application;

public class Spindle implements Runnable {
	private static boolean spindleStatus = false;
	// false = aus, true = ein
	
	private static char spindleDirectionOfRotation = '0';
	//0 = aus, r = im Uhrzeigersinn (Rechtslauf), l = gegen den Uhrzeigersinn (Linkslauf)	
	
	
	//Getter Methoden
	public static boolean _getSpindleStatus() {
		return spindleStatus;
	}
	
	public static char _getSpindleDirectionOfRotation() {
		return spindleDirectionOfRotation;
	}
	
	//Setter
	public static void _setSpindleStatus(boolean status) {
		spindleStatus = status;
	}
	
	public static void _setSpindleDirectionOfRotation(char direction) {
		spindleDirectionOfRotation = direction;
	}
	
	//Spindel stoppen
	public static void spindleStop() {
		if (spindleStatus == true) {
			spindleStatus = false;
			spindleDirectionOfRotation = '0';
		}
		else {
			ErrorHandling.spindleStopped();
		}
	}
	
	public static void spindleStart(char direction) {
		if (spindleStatus == false) {
			spindleStatus = true;
			if (direction == 'r') {
				spindleDirectionOfRotation = 'r';
			}
			else if (direction == 'l') {
				spindleDirectionOfRotation = 'l';
			}
			else {
				ErrorHandling.invalidDirectionOfRotation(direction);
			}
		}
		else {
			ErrorHandling.spindleRunning();
		}
	}
	
	public static void spindelStart() {
		if (spindleStatus == false) {
			spindleStatus = true;
			spindleDirectionOfRotation = 'r';
			//Drehen im Uhrzeigersinn falls nichts übergeben
		}
		else {
			ErrorHandling.spindleRunning();
		}
	}
	
	public static void changeDrehrichtung(char richtung) {
		if (spindleStatus == true) {
			if (richtung == 'r') {
				spindleDirectionOfRotation = 'r';
			}
			else if (richtung == 'l') {
				spindleDirectionOfRotation = 'l';
			}
			else {
				ErrorHandling.invalidDirectionOfRotation(richtung);
			}
		}
		else {
			ErrorHandling.spindleOff();
		}
	}
	
	public static String SpindelAusgabe() {
		String statusOutput;
		String directionOfRotationOutput;
		if (spindleStatus == false) {
			statusOutput = "aus";
			directionOfRotationOutput = "aus";
		}
		else {
			statusOutput = "ein";
			if (spindleDirectionOfRotation == 'r') {
				directionOfRotationOutput = "Rechtslauf";
			}
			else {
				directionOfRotationOutput = "Linkslauf";
			}
		}
		return ("Spindelstatus: " + statusOutput + "\n" + "Drehrichtung: " + directionOfRotationOutput);
	}
	
	public void run() {
		//TODO: Insert Thread Actions here
	}

}

//Lisa
