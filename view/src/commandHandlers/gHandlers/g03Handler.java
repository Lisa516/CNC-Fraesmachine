package commandHandlers.gHandlers;

import application.ErrorHandling;
import application.Fraeskopf;

public class g03Handler {
	//Vorschub mit Kreisbogen, gegen den Uhrzeigersinn
	
	public static boolean test() {
		if (Fraeskopf.fraesenStatus == true) {
			return true;
		}
		ErrorHandling.befehlUnmoeglichFraeseAus();
		return false;
	}
	
	public static void ausfuehren(int x, int y) {
		if (test() == false) {
			return;
		}	
		//TODO
	}

}
