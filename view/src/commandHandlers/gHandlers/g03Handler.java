package commandHandlers.gHandlers;

import application.ErrorHandling;
import application.MillingCutter;

public class g03Handler {
	//Vorschub mit Kreisbogen, gegen den Uhrzeigersinn
	
	public static boolean test() {
		if (MillingCutter._getMillingStatus() == true) {
			return true;
		}
		ErrorHandling.befehlUnmoeglichFraeseAus();
		return false;
	}
	
	public static void execute(int x, int y, int i, int j) {
		if (test() == false) {
			return;
		}	
		//TODO
	}

}
