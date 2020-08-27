package commandHandlers.gHandlers;

import application.ErrorHandling;
import application.MillingCutter;
import application.MainFX;

public class g02Handler {
	//Vorschub mit Kreisbogen, im Uhrzeigersinn (Kreis Interpolation)
	
	public static boolean test() {
		if (MillingCutter._getMillingStatus() == false) {
			ErrorHandling.befehlUnmoeglichFraeseAus();
			return false;
		}
		return true;
	}

	public static void execute(int x, int y, int i, int j) {
		if (test() == false) {
			return;
		}
		double mittelpunktX = MainFX.bohrer.getLayoutX() + i;
		double mittelpunktY = MainFX.bohrer.getLayoutY() + j;
		double radius = Math.sqrt((i*i) + (j*j));
		double startAngle;
		if (x >= y) {
			startAngle = 45 * (x / y); 
		}
		else {
			startAngle = 90 - 45 * (y / x);
		}
	}
	
}
