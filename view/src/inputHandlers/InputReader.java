package inputHandlers;

import application.CommandHandler;

/*
 * @author Lisa
 */

public class InputReader extends CommandHandler {
	public static void _getInputAsStrings(String command, double x, double y, double i, double j) {
		callCommand(command, x, y, i, j);
		return;
	}

}
