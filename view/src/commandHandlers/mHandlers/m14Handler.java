package commandHandlers.mHandlers;

import application.Kuehlmittel;
import application.Spindle;

public class m14Handler {
	//Spindel ein, Linkslauf und Kuehlmittel ein 
	
	public static void execute() {
		Kuehlmittel._setKuehlmittelStatus(true);
		Spindle.spindelStart('l');
	}

}
