package commandHandlers.gHandlers;

import application.ErrorHandling;
import application.Fraeskopf;
import application.MainFX;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class g01Handler {
	//Geraden (Linear) Interpolation

	public static void ausfuehren(int x, int y) {
		/**if (test() == false) {
			return;
		}**/
		double neuX = x - MainFX.bohrer.getLayoutX();
		double neuY = y - MainFX.bohrer.getLayoutY();

		MainFX.fraesenLine(x, y, neuX / neuY / 2, 0.5);
	}
}
