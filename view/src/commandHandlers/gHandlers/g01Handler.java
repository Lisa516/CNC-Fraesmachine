package commandHandlers.gHandlers;

import application.MillingShapes;
import application.UI;

public class g01Handler {
	//Geraden (Linear) Interpolation

	public static void execute(int x, int y) {
		/**if (test() == false) {
			return;
		}**/
		double neuX = x - UI.bohrer.getLayoutX();
		double neuY = y - UI.bohrer.getLayoutY();

		MillingShapes.fraesenLine(x, y, neuX / neuY / 2, 0.5);
	}
}
