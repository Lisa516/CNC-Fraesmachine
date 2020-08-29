package commandHandlers.gHandlers;

import application.Test;
import errorHandler.ErrorHandling;
import ui.MainFX;

public class g00Handler {
	// Verfahrbewegung im Eilgang (nur ohne Bohren/Fraesen moeglich)

	public static void execute(int x, int y) {
		if (Test.testFraeseAus() == false) {
			ErrorHandling.commandInvalidMillNotRunning();
			return;
		}
		System.out.println(x + " " + y + " " + x / y);
		MainFX.moveLine(x, y, x / y, 1);
	}

}