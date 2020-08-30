package commandHandlers.gHandlers;

import ui.MillingShapes;
import ui.UI;

public class g01Handler {
	//Geraden (Linear) Interpolation

	public static void execute(double x, double y) {
		/**if (test() == false) {
			return;
		}**/
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
		MillingShapes.fraesenLine(x, y, dx, dy);
	}
}
