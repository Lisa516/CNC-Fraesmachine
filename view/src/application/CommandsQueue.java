package application;

import java.io.FileNotFoundException;

public class CommandsQueue {
	public static void QueueFromJSON() throws FileNotFoundException {
		for (int i = 0; i < FileReader.befehleAlsStringArray().length; i++) {
			BefehlHandler.befehlAufrufen(i);
		}
		
	}

}
