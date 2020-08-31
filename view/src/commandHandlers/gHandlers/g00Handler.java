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
		System.out.println(neuX);
		double neuY = y - UI.drill.getLayoutY();
		System.out.println(neuY);
		System.out.println(x + " " + y);

		double dx, dy;

		if (Math.abs(neuX) > Math.abs(neuY)) {
			dy = (neuY) / (neuX);
			dx = Math.signum(neuX);
		}

		else {
			dx = (neuX) / (neuY);
			dy = Math.signum(neuY);
		}
		
		if (dx > 0) {
			if (dy > 0) {
				MainFX.moveLinePositive(x, y, dx, dy);
			}
			else {
				MainFX.moveLineXPositive(x, y, dx, dy);
			}
		}
		else {
			if (dy > 0) {
				System.out.println(dx);
				System.out.println(dy);
				MainFX.thisX = UI.drill.getLayoutX();
				MainFX.thisY = UI.drill.getLayoutY();
				MainFX.moveLineYPositive(x, y, dx, dy);
				System.out.println("fertig");
			}
			else {
				MainFX.moveLineNegative(x, y, dx, dy);
			}
		}
		LogCommands.logCommands("G00", x, y);
	}
}
