package commandHandlers.mHandlers;

import application.Fraeskopf;
import application.Kuehlmittel;
import application.Spindel;

public class m02Handler {
	//Programm Ende
	
	public static void ausfuehren() {
		//TODO
		Spindel.spindelStopp();
		Kuehlmittel._setKuehlmittelStatus(false);
		if (Fraeskopf._getFraesenStatus() == true) {
			Fraeskopf.stoppFraese();
		}
	}

}
