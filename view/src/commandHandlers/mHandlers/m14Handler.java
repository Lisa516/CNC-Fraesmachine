package commandHandlers.mHandlers;

import application.Kuehlmittel;
import application.Spindel;

public class m14Handler {
	//Spindel ein, Linkslauf und Kuehlmittel ein 
	
	public static void ausfuehren() {
		Kuehlmittel._setKuehlmittelStatus(true);
		Spindel.spindelStart('l');
	}

}
