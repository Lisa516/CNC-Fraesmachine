package commandHandlers.mHandlers;

import application.Coolant;
import application.Spindle;

public class m13Handler {
	//Spindel Ein, Rechtslauf und Kuehlmittel Ein

	
	public static void execute() {
		Coolant._setKuehlmittelStatus(true);
		Spindle.spindelStart('r');
	}

}
