package ui;

import application.Coolant;
import application.MillingCutter;
import application.Spindle;
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

	public static void refreshLabel() {
		InfoBox.position.setText("Position: " + MillingCutter._getPosition());
		InfoBox.spindelStatus.setText(Spindle.SpindelAusgabe());
		InfoBox.coolantStatus.setText("Kuehlmittelstatus: " + Coolant._getStatus());
		InfoBox.velocity.setText("Geschwindigkeit: " + MillingCutter._getVelocity() + "m/min");
	}

}
