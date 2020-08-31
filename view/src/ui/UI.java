package ui;

import components.Coolant;
import components.MillingCutter;
import components.Spindle;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/*
 * @author Lisa
 */

public class UI {
	
	static BorderPane root = new BorderPane();

	static Scene scene = new Scene(root, 1100, 725);

	//add borders so the drill is still fully visible if it is at the side of the screen
	static Rectangle borderO = new Rectangle(1100, 50, Color.WHITE);
	static Rectangle borderU = new Rectangle(1100, 150, Color.WHITE);
	static Rectangle borderL = new Rectangle(50, 725, Color.WHITE);

	//radius and color of the drill are defined in the Settings.json
	public static Circle drill = new Circle(50, 50, 0);

	//HOME position is set in the Settings.json
	public static Circle home = new Circle(5);

	//size of the working surface: 1unit = 2mm
	public static Rectangle workingSurface = new Rectangle(1100, 725);

	//how many milimeters the drill moves during one minute if the coolant is turned on and the mill is running
	public static double velocityWithCoolantMM;

	//how many milimeters the drill moves during one minute if the coolant is turned off and the mill is running
	public static double velocityWithoutCoolantMM;
	
	//how many milimeters the drill moves during one minute if the mill is not running
	public static double velocityNotMilling;

	public static double velocityMilling() {
		if (Coolant._getCoolantStatus()) {
			return velocityWithCoolantMM;
		} else {
			return velocityWithoutCoolantMM;
		}
	}

	public static void refreshLabel() {
		InfoBox.position.setText("Position: " + MillingCutter._getPosition());
		InfoBox.spindelStatus.setText(Spindle.SpindelAusgabe());
		InfoBox.coolantStatus.setText("Kuehlmittelstatus: " + Coolant._getStatus());
		InfoBox.velocity.setText("Geschwindigkeit: " + MillingCutter._getVelocity() + "m/min");
	}

	//returns the double of how long it takes the milling cutter to move one step in seconds
	public static double velocity(double lengthStep, boolean milling) {
		if (milling) {
			return 60 / (velocityMilling() / lengthStep) / 2 * 1000;
		}
		return 60 / (velocityNotMilling / lengthStep) / 2 * 1000;
		// the equation divides by 2 because 1 unit on the UI refers to 2mm on the
		// actual working surface	
	}
	
	
}
