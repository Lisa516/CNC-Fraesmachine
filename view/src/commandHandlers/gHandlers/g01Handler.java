package commandHandlers.gHandlers;

import commandLogging.LogCommands;
import ui.MillingShapes;
import ui.UI;

/*
 * @author Lisa
 */

public class g01Handler {
	// This g-code triggers a straight interpolation

	public static void execute(double x, double y) {
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
			}
			else {
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
			}
			else {
				dx = 0;
			}
			dy = Math.signum(neuY);
		}
		if (dy > 0) {
			MillingShapes.millingLineY(dx, dy, Math.abs(neuY), UI.velocity(Math.sqrt(dx*dx + dy*dy), true));
		}
		else {
			MillingShapes.millingLineX(dx, dy, Math.abs(neuX), UI.velocity(Math.sqrt(dx*dx + dy*dy), true));
		}
		
		LogCommands.logCommands("G01", x, y);
	}
}
