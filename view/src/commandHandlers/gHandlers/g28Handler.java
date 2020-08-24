package commandHandlers.gHandlers;

import application.ErrorHandling;
import application.Fraeskopf;

public class g28Handler {
	//HOME Position anfahren
	
	public static boolean test() {
		if (Fraeskopf.fraesenStatus == false) {
			return true;
		}
		ErrorHandling.befehlUnmoeglichFraeseAn();
		return false;
	}
	
	public static void ausfuehren(int x, int y) {
		if (test() == false) {
			return;
		}	
		//TODO
	}

}
