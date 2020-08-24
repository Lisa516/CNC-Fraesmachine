package commandHandlers.mHandlers;

import application.Kuehlmittel;
import application.Spindel;

public class m13Handler {
	//Spindel Ein, Rechtslauf und Kuehlmittel Ein

	
	public static void ausfuehren() {
		Kuehlmittel._setKuehlmittelStatus(true);
		Spindel.spindelStart('r');
	}

}
