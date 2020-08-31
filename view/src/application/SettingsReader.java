package application;

import java.io.FileNotFoundException;

import javafx.scene.paint.Color;
import ui.MillingShapes;
import ui.UI;

public class SettingsReader extends FileReader {

	public static void setSettings() throws FileNotFoundException {
		double velocityWithCoolant = readIn("Settings.json").get("velocityWithCoolant").getAsInt();
		double velocityWithoutCoolant = readIn("Settings.json").get("velocityWithoutCoolant").getAsInt();
		double velocityMillNotRunning = readIn("Settings.json").get("velocityMillNotRunning").getAsInt();

		// TODO: Geschwindigkeit
		
		UI.velocityWithCoolantMM = readIn("Settings.json").get("velocityWithCoolant").getAsInt() * 1000;

		UI.home.setCenterX(readIn("Settings.json").get("homePositionX").getAsInt() + 50);

		UI.home.setCenterY(readIn("Settings.json").get("homePositionY").getAsInt() + 50);

		UI.home.setFill(Color.valueOf(readIn("Settings.json").get("colorHomePosition").getAsString()));

		UI.drill.setRadius(readIn("Settings.json").get("diameterDrill").getAsInt() / 2);

		UI.workingSurface.setFill(Color.valueOf(readIn("Settings.json").get("colorSurface").getAsString()));

		MillingShapes.colorMilledSurface = Color
				.valueOf(readIn("Settings.json").get("colorMilledSurface").getAsString());

		UI.drill.setFill(Color.valueOf(readIn("Settings.json").get("colorMillhead").getAsString()));
	}
}