package commandHandlers.mHandlers;

import application.Coolant;
import application.Spindle;

public class m14Handler {
	//Spindel ein, Linkslauf und Kuehlmittel ein 
	
	public static void execute() {
		Coolant._setKuehlmittelStatus(true);
		Spindle.spindelStart('l');
	}

}
