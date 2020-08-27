package commandHandlers.mHandlers;

import application.Spindle;

public class m04Handler {
	//Spindel Ein: Gegen den Uhrzeigersinn (Linkslauf)
	
	public static void execute() {
		Spindle.spindelStart('l');
	}

}
