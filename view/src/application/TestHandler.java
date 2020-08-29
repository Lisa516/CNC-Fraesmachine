package application;

import java.io.FileNotFoundException;

public class TestHandler {
	public boolean ProgrammEnde = false;
	
	public static boolean callTest(int index, String file) throws FileNotFoundException {
		String command = CommandReader._getCommand(index, file)[1];
		if (command.contentEquals("G00") || command.contentEquals("G01") || command.contentEquals("G02") || command.contentEquals("G03")) {
			if (Test.testXYInRange(ParametersCommands._getX(index, file), ParametersCommands._getY(index, file)) == false) {
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
