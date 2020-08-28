package application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class InfoBox {
	static Rectangle info = new Rectangle(350, 725, Color.WHITE);
	
	static Label position = new Label("Position: " + MillingCutter._getPosition());

	static Label spindelStatus = new Label(Spindle.SpindelAusgabe());

	static Label coolantStatus = new Label("Status coolant: " + Coolant._getStatus());

	static Label velocity = new Label("Velocity: " + MillingCutter._getVelocity() + "m/min");

	static Label logdatei = new Label("Ausgefuehrte Befehle:");
	
	static Button go = new Button("Go");
	
	static Label befehl = new Label("Befehl: ");
	
	static TextField textField = new TextField();
	
	static VBox infos = new VBox();

	static HBox suchen = new HBox();

}
