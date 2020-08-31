package components;

import errorHandler.ErrorHandling;

public class Spindle implements Runnable {
	private static boolean spindleStatus = false;
	// false = aus, true = ein
	
	private static char spindleRotDirection = '0';
	//0 = aus, r = im Uhrzeigersinn (Rechtslauf), l = gegen den Uhrzeigersinn (Linkslauf)	
	
	
	//Getter Methoden
	public static boolean _getSpindleStatus() {
		return spindleStatus;
	}
	
	public static char _getSpindleDirectionOfRotation() {
		return spindleRotDirection;
	}
	
	//Setter
	public static void _setSpindleStatus(boolean status) {
		spindleStatus = status;
	}
	
	public static void _setSpindleDirectionOfRotation(char direction) {
		spindleRotDirection = direction;
	}
	
	//Spindel stoppen
	public static void stopSpindle() {
		if (spindleStatus == true) {
			spindleStatus = false;
			spindleRotDirection = '0';
		}
		else {
			ErrorHandling.spindleStopped();
		}
	}
	
	public static void startSpindle(char direction) {
		if (spindleStatus == false) {
			spindleStatus = true;
			if (direction == 'r') {
				spindleRotDirection = 'r';

			}
			else if (direction == 'l') {
				spindleRotDirection = 'l';
			}
			else {
				ErrorHandling.invalidDirectionOfRotation(direction);
			}
		}
		else {
			ErrorHandling.spindleRunning();
		}
	}
	
	public static void startSpindle() {
		if (spindleStatus == false) {
			spindleStatus = true;
			spindleRotDirection = 'r';

			//Drehen im Uhrzeigersinn falls nichts übergeben
		}
		else {
			ErrorHandling.spindleRunning();
		}
	}
	
	public static void changeDrehrichtung(char richtung) {
		if (spindleStatus == true) {
			if (richtung == 'r') {
				spindleRotDirection = 'r';
			}
			else if (richtung == 'l') {
				spindleRotDirection = 'l';
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
			if (spindleRotDirection == 'r') {
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
