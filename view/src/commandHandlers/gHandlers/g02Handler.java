package commandHandlers.gHandlers;

import commandLogging.LogCommands;
import components.MillingCutter;
import errorHandler.ErrorHandling;
import ui.UI;

public class g02Handler {
	// Vorschub mit Kreisbogen, im Uhrzeigersinn (Kreis Interpolation)

	public static boolean test() {
		if (MillingCutter._getMillingStatus() == false) {
			ErrorHandling.commandImpossibleMillingMachineOff();
			return false;
		}
		return true;
	}

	public static void execute(double x, double y, double i, double j) {
		if (test() == false) {
			return;
		}
		//TODO
		double mittelpunktX = UI.drill.getLayoutX() + i;
		double mittelpunktY = UI.drill.getLayoutY() + j;
		double radius = Math.sqrt((i * i) + (j * j));
		double startAngle;
		if (x >= y) {
			startAngle = 45 * (x / y);
		} else {
			startAngle = 90 - 45 * (y / x);
		}
		LogCommands.logCommands("G02", x, y, i, j);
	}

}
