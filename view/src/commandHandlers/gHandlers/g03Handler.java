package commandHandlers.gHandlers;

import application.ErrorHandling;
import application.Fraeskopf;
import application.PathClass;

public class g03Handler extends PathClass {
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
