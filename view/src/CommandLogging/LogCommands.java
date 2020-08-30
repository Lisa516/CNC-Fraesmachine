package CommandLogging;

import javafx.scene.control.Label;
import ui.InfoBox;

public class LogCommands {
	public static void logCommands(String befehl) {
	Label loginfos = new Label(befehl);
	InfoBox.infos.getChildren().add(loginfos);
		}
	public static void logCommands(String befehl, double x, double y) {
		Label loginfos = new Label(befehl + ", X: " + x + ", Y: " + y);
		InfoBox.infos.getChildren().add(loginfos);
		}
	public static void logCommands(String befehl, double x, double y, double i, double j) {
		Label loginfos = new Label(befehl + ", X: " + x + ", Y: " + y + ", I: " + i);
		InfoBox.infos.getChildren().add(loginfos);
		}
}