package commandHandlers.mHandlers;

import application.Kuehlmittel;
import application.Spindle;

public class m13Handler {
	//Spindel Ein, Rechtslauf und Kuehlmittel Ein

	
	public static void execute() {
		Kuehlmittel._setKuehlmittelStatus(true);
		Spindle.spindelStart('r');
	}

}
