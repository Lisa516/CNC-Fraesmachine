package application;

import java.io.FileNotFoundException;

public class TestHandler {
	public boolean ProgrammEnde = false;
	
	public static boolean callTest(int location) throws FileNotFoundException {
		String command = FileReader._getCommand(location)[1];
		if (command.contentEquals("G00") || command.contentEquals("G01") || command.contentEquals("G02") || command.contentEquals("G03")) {
			if (Test.testXYInRange(FileReader._getX(location), FileReader._getY(location)) == false) {
				return false;
			}
			if (command.contentEquals("G00") == false) {
				if (Test.testMillRunning() == false) {
					return false;
				}
				if (command.contentEquals("G01") == false) {
					//TODO I & J testen
				}
			}
		}
		if (command.contentEquals("G00") || command.contentEquals("G28")) {
			if (Test.testFraeseAus() == false) {
				return false;
			}
		}
		return true;
	}
	
}
