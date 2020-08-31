package CommandLogging;

import ui.InfoBox;

public class LogCommands {
	public static void logCommands(String befehl) {
		InfoBox.commandsList += befehl;
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