package application;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class UI {
	static BorderPane root = new BorderPane();

	public static Circle bohrer = new Circle(50, 50, 7.5, Color.RED);

	static Label position = new Label("Position: " + MillingCutter._getPosition());
	static Label spindelStatus = new Label(Spindle.SpindelAusgabe());
	static Label kuehlmittelStatus = new Label("Kuehlmittelstatus: " + Kuehlmittel._getStatus());
	static Label geschwindigkeit = new Label("Geschwindigkeit: " + MillingCutter._getGeschwindigkeit() + "m/min");

	public static void refreshLabel() {
		position.setText("Position: " + MillingCutter._getPosition());
		spindelStatus.setText(Spindle.SpindelAusgabe());
		kuehlmittelStatus.setText("Kuehlmittelstatus: " + Kuehlmittel._getStatus());
		geschwindigkeit.setText("Geschwindigkeit: " + MillingCutter._getGeschwindigkeit() + "m/min");
	}

}
