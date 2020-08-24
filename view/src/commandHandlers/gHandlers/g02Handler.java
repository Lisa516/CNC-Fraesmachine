package commandHandlers.gHandlers;

import application.ErrorHandling;
import application.Fraeskopf;
import application.PathClass;

public class g02Handler extends PathClass {
	//Vorschub mit Kreisbogen, im Uhrzeigersinn (Kreis Interpolation)
	
	public static boolean test() {
		if (Fraeskopf.fraesenStatus == false) {
			ErrorHandling.befehlUnmoeglichFraeseAus();
			return false;
		}
		return true;
	}

	public static void ausfuehren(int x, int y) {
		if (test() == false) {
			return;
		}
		//TODO
	}
	
}
