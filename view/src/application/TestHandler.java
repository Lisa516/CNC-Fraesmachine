package application;

import java.io.FileNotFoundException;

public class TestHandler {
	public boolean ProgrammEnde = false;
	
	public static boolean aufrufenTest(int stelle) throws FileNotFoundException {
		String befehl = FileReader._getCommand(stelle)[1];
		if (befehl.contentEquals("G00") || befehl.contentEquals("G01") || befehl.contentEquals("G02") || befehl.contentEquals("G03")) {
			if (Test.testXYInRange(FileReader._getX(stelle), FileReader._getY(stelle)) == false) {
				return false;
			}
			if (befehl.contentEquals("G00") == false) {
				if (Test.testMillRunning() == false) {
					return false;
				}
				if (befehl.contentEquals("G01") == false) {
					//TODO I & J testen
				}
			}
		}
		if (befehl.contentEquals("G00") || befehl.contentEquals("G28")) {
			if (Test.testFraeseAus() == false) {
				return false;
			}
		}
		return true;
	}
	
}
