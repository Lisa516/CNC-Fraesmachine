package commandHandlers.mHandlers;

import application.Spindle;

public class m03Handler {
	//Spindel Ein: Im Uhrzeigersinn (Rechtslauf)
	
	
	public static void execute() {
		Spindle.spindelStart('r');
	}

}
