package CommandLogging;

import javafx.scene.control.Label;
import ui.MainFX;

public class LogCommands {
	public static void logCommands(String befehl) {
	/**	Label loginfos = new Label(befehl);
		MainFX.addLogInfo(loginfos);**/
	}

	public static void logCommands(String befehl, double x, double y) {/**
		Label loginfos = new Label(befehl + ", X: " + x + ", Y: " + y);
		MainFX.addLogInfo(loginfos);**/
	}

	public static void logCommands(String befehl, double x, double y, double i, double j) {/**
		Label loginfos = new Label(befehl + ", X: " + x + ", Y: " + y + ", I: " + i);
		MainFX.addLogInfo(loginfos);**/
	}
}