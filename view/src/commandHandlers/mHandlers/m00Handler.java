package commandHandlers.mHandlers;

import application.Fraeskopf;
import application.Kuehlmittel;
import application.Spindel;

public class m00Handler {
	//Programmhalt (Spindel, Kuehlmittel, Vorschub aus)
	
	public static void test() {
		
	}
	
	public static void ausfuehren() {
		Spindel.spindelStopp();
		Kuehlmittel._setKuehlmittelStatus(false);
		Fraeskopf.stoppFraese();
	}

}
