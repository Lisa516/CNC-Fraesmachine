package commandHandlers.gHandlers;

import CommandLogging.LogCommands;
import application.Test;
import errorHandler.ErrorHandling;
import ui.MainFX;
import ui.UI;

public class g00Handler {
	// Verfahrbewegung im Eilgang (nur ohne Bohren/Fraesen moeglich)

	public static void execute(double x, double y) {
		if (Test.testFraeseAus() == false) {
			ErrorHandling.commandInvalidMillNotRunning();
			return;
		}
		
		double neuX = x - UI.drill.getLayoutX();
		double neuY = y - UI.drill.getLayoutY();

		double dx, dy;

		if (neuX > neuY) {
			dy = (neuY - 50) / (neuX - 50);
			dx = Math.signum(y);
		}

		else {
			dx = (neuX - 50) / (neuY - 50);
			dy = Math.signum(y);
		}
		MainFX.moveLine(x, y, dx, dy);
		LogCommands.logCommands("G00", x, y);
		
	}
}
