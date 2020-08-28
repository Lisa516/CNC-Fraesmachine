package commandHandlers.mHandlers;

import application.MillingCutter;
import application.Coolant;
import application.Spindle;

public class m02Handler {
	//Programm Ende
	
	public static void execute() {
		//TODO
		Spindle.spindelStopp();
		Coolant._setKuehlmittelStatus(false);
		if (MillingCutter._getMillingStatus() == true) {
			MillingCutter.stoppFraese();
		}
	}

}
