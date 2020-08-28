package application;

import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class UI {
	static BorderPane root = new BorderPane();

	public static Circle bohrer = new Circle(50, 50, 7.5, Color.RED);

	public static void refreshLabel() {
		InfoBox.position.setText("Position: " + MillingCutter._getPosition());
		InfoBox.spindelStatus.setText(Spindle.SpindelAusgabe());
		InfoBox.coolantStatus.setText("Kuehlmittelstatus: " + Coolant._getStatus());
		InfoBox.velocity.setText("Geschwindigkeit: " + MillingCutter._getVelocity() + "m/min");
	}

}
