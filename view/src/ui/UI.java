package ui;

import components.Coolant;
import components.MillingCutter;
import components.Spindle;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class UI {

	static BorderPane root = new BorderPane();

	static Scene scene = new Scene(root, 1100, 725);

	static Rectangle borderO = new Rectangle(1100, 50, Color.WHITE);
	static Rectangle borderU = new Rectangle(1100, 150, Color.WHITE);
	static Rectangle borderL = new Rectangle(50, 725, Color.WHITE);

	public static Circle drill = new Circle(50, 50, 0);

	public static Circle home = new Circle(5);

	public static Rectangle workingSurface = new Rectangle(1100, 725);

	public static double velocityWithCoolantMM;

	public static double velocityWithoutCoolantMM;
	
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

	public static double velocity(double lengthStep, boolean milling) {
		if (milling) {
			return 60 / (velocityMilling() / lengthStep) / 2;
		}
		return 60 / (velocityNotMilling / lengthStep) / 2;
		// the equation divides by 2 because 1 unit on the UI refers to 2mm on the
		// actual working surface
	}
}
