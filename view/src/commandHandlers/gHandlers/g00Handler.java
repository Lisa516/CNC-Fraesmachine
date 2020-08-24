package commandHandlers.gHandlers;

import application.ErrorHandling;
import application.Fraeskopf;

public class g00Handler {
	//Verfahrbewegung im Eilgang (nur ohne Bohren/Fraesen moeglich)
	
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
