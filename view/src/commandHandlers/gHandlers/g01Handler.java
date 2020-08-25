package commandHandlers.gHandlers;

import application.ErrorHandling;
import application.Fraeskopf;
import application.MainFX;

public class g01Handler {
	//Geraden (Linear) Interpolation
	
	public static boolean test() {
		if (Fraeskopf.fraesenStatus == false) {
			ErrorHandling.befehlUnmoeglichFraeseAus();
			return false;
		}
		return true;
	}

	public static void ausfuehren(int x, int y) {
		/**if (test() == false) {
			return;
		}**/
		double neuX = x - MainFX.bohrer.getLayoutX();
		double neuY = y - MainFX.bohrer.getLayoutY();

		MainFX.fraesenLine(x, y, neuX / neuY, 1);
	}
}
