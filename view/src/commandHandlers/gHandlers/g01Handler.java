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

		MillingShapes.fraesenLine(x, y, (neuX - 50) / (neuY - 50) / 2, 0.5);
	}
}
