package commandHandlers.mHandlers;

import application.MillingCutter;
import application.Kuehlmittel;
import application.Spindle;

public class m00Handler {
	//Programmhalt (Spindel, Kuehlmittel, Vorschub aus)
	
	public static void test() {
		
	}
	
	public static void execute() {
		Spindle.spindleStopp();
		Coolant._setKuehlmittelStatus(false);
		MillingCutter.stoppFraese();
	}

}
