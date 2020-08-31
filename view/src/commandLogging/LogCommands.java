package commandLogging;

import ui.InfoBox;

/*
 * @author Lisa
 */

//Overloading method so it fits for all of the commands
public class LogCommands {
	public static void logCommands(String befehl) {
		InfoBox.commandsList += "\n" + befehl;
		InfoBox.commandsText.setText(InfoBox.commandsList);
	}

	public static void logCommands(String befehl, double x, double y) {
		InfoBox.commandsList += "\n" + befehl + " X: " + x + " Y: " + y;
		InfoBox.commandsText.setText(InfoBox.commandsList);
	}

	public static void logCommands(String befehl, double x, double y, double i, double j) {
		InfoBox.commandsList += "\n" + befehl + " X: " + x + " Y: " + y + " I: " + i + " J: " + j;
		InfoBox.commandsText.setText(InfoBox.commandsList);
	}
}