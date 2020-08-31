package commandHandlers.gHandlers;

import CommandLogging.LogCommands;
import ui.MillingShapes;
import ui.UI;

public class g01Handler {
	//Geraden (Linear) Interpolation

	public static void execute(double x, double y) {
		double neuX = x - UI.drill.getLayoutX();
		double neuY = y - UI.drill.getLayoutY();
		
		double dx, dy;
		
		if (neuX > neuY) {
			dy = (neuY) / (neuX);
			dx = Math.signum(neuX);
		}
		
		else {
			dx = (neuX) / (neuY);
			dy = Math.signum(neuY);
		}
		double hypo = Math.sqrt(dx*dx + dy*dy);
		double temp = 3000/hypo;
		double temp2 = 60/temp;
		MillingShapes.fraesenLine(x, y, dx, dy, temp2);
		LogCommands.logCommands("G01", x, y);
	}
}


