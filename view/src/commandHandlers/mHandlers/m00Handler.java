package commandHandlers.mHandlers;

import application.MillingCutter;
import application.Coolant;
import application.Spindle;

public class m00Handler {
	//Programmhalt (Spindel, Kuehlmittel, Vorschub aus)
	
	public static void test() {
		
	}
	
	public static void execute() {
		Spindle.spindelStopp();
		Coolant._setCoolantStatus(false);
		MillingCutter.stoppFraese();
	}

}
