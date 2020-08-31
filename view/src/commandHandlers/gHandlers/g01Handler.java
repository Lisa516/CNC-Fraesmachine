package commandHandlers.gHandlers;

import commandLogging.LogCommands;
import ui.MillingShapes;
import ui.UI;

/*
 * @author Lisa
 */

public class g01Handler {
	//This g-code is supposed to trigger a straight interpolation

	public static void execute(double x, double y) {
		double difX = x - UI.drill.getLayoutX();
		double difY = y - UI.drill.getLayoutY();
		
		double dx, dy;
		
		double amountX = Math.abs(difX);
		double amountY = Math.abs(difY);
		
		if (amountX > amountY) {
			dy = amountX / amountY * Math.signum(difY);
			dx = Math.signum(difX);
		}
		
		else {
			dx = amountX / amountY * Math.signum(difX);
			dy = Math.signum(difY);
		}
		
		MillingShapes.fraesenLine(x, y, dx, dy, UI.velocity(Math.sqrt(dx*dx + dy*dy), true));
		LogCommands.logCommands("G01", x, y);
	}
}


