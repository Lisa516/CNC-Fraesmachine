package commandHandlers.gHandlers;

import commandLogging.LogCommands;
import components.MillingCutter;
import errorHandler.ErrorHandling;
import ui.MainFX;
import ui.UI;

/*
 * @author Lisa
 */

public class g28Handler {
	//move to home position

	public static boolean test() {
		if (MillingCutter._getMillingStatus() == false) {
			return true;
		}
		ErrorHandling.commandInvalidMillNotRunning();
		return false;
	}

	public static void execute() {
		double x = UI.home.getCenterX();
		double y = UI.home.getCenterY();

		double neuX = x - UI.drill.getLayoutX();
		System.out.println(neuX);
		double neuY = y - UI.drill.getLayoutY();
		System.out.println(neuY);
		System.out.println(x + " " + y);

		double dx, dy;

		if (neuX == 0 && neuY == 0) {
			dx = 0;
			dy = 0;
		}

		else if (Math.abs(neuX) > Math.abs(neuY)) {
			if (neuY != 0) {
				dy = (neuY) / (neuX);
			} else {
				dy = 0;
			}
			dx = Math.signum(neuX);
		}

		else if (Math.abs(neuX) == Math.abs(neuY)) {
			dx = 1;
			dy = 1;
		}

		else {
			if (neuX != 0) {
				dx = (neuX) / (neuY);
			} else {
				dx = 0;
			}
			dy = Math.signum(neuY);
		}

		if (dx > 0) {
			MainFX.moveLineX(dx, dy, Math.abs(neuX), UI.velocity(Math.sqrt(dx * dx + dy * dy), false));
		} else {
			MainFX.moveLineY(dx, dy, Math.abs(neuY), UI.velocity(Math.sqrt(dx * dx + dy * dy), false));
		}

		LogCommands.logCommands("G28");
	}

}
