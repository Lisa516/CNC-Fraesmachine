package application;

import java.io.FileNotFoundException;

public class SettingsReader extends FileReader{
		
public static void setSettings() throws FileNotFoundException{
		String colorHomePosition = readIn("Settings.json").get("colorHomePosition").getAsString();
		int homePositionX = readIn("Settings.json").get("homePositionX").getAsInt();
		int homePositionY = readIn("Settings.json").get("homePositionY").getAsInt();
		int velocityWithCoolant = readIn("Settings.json").get("veloityWithCoolant").getAsInt();
		int velocityWithoutCoolant = readIn("Settings.json").get("velocityWithoutCoolant").getAsInt();
		int velocityMillNotRunning = readIn("Settings.json").get("velocitMillNotRunning").getAsInt();
		int diameterDrill = readIn("Settings.json").get("diameterDrill").getAsInt();
		String colorSurface = readIn("Settings.json").get("colorSurface").getAsString();
		String colorMilledSurface = readIn("Settings.json").get("colorMilledSurface").getAsString();
		String colorMillhead = readIn("Settings.json").get("homePositionX").getAsString();
}
}
