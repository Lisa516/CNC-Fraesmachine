package application;

import java.io.FileNotFoundException;

public class CommandsQueue {
	
	public static boolean testQueueFromJson() throws FileNotFoundException {
		for (int i = 0; i < FileReader.befehleAlsStringArray().length; i++) {
			TestHandler.aufrufenTest(i);
		}
		return true;
	}
	
	public static void QueueFromJSON() throws FileNotFoundException {
		for (int i = 0; i < FileReader.befehleAlsStringArray().length; i++) {
			BefehlHandler.befehlAufrufen(i);
		}
	}

}
