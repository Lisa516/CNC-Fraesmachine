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
			dy = (neuY - 50) / (neuX - 50);
			dx = Math.signum(y);
		}
		
		else {
			dx = (neuX - 50) / (neuY - 50);
			dy = Math.signum(y);
		}
		double hypo = Math.sqrt(dx*dx + dy*dy);
		double temp = 3000/hypo;
		double temp2 = 60/temp;
		MillingShapes.fraesenLine(x, y, dx, dy, temp2);
		LogCommands.logCommands("G01", x, y);
	}
}


