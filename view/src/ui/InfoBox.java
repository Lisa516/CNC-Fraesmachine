package ui;

import components.Coolant;
import components.MillingCutter;
import components.Spindle;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/*
 * @author Lisa
 * 
 * In this class, everything concerning the Infobox on the very right of the UI is managed
 */

public class InfoBox {

	static Rectangle info = new Rectangle(350, 725, Color.WHITE);

	//Position of the Milling cutter
	static Label position = new Label("Position: " + MillingCutter._getPosition());

	static Label spindelStatus = new Label(Spindle.SpindelAusgabe());

	static Label coolantStatus = new Label("Status coolant: " + Coolant._getStatus());

	static Label velocity = new Label("Velocity: " + MillingCutter._getVelocity() + "m/min");

	static Label logdatei = new Label("Ausgefuehrte Befehle:");

	public static String commandsList = "";

	public static Text commandsText = new Text(commandsList);

	//Eingabefelder
	static HBox befehlZeile = new HBox();
	static Label befehl = new Label("Command: ");
	static TextField befehlFeld = new TextField();

	static HBox xZeile = new HBox();
	static Label xParameter = new Label("               X: ");
	static TextField xParameterField = new TextField();

	static HBox yZeile = new HBox();
	static Label yParameter = new Label("               Y: ");
	static TextField yParameterField = new TextField();

	static HBox iZeile = new HBox();
	static Label iParameter = new Label("                I: ");
	static TextField iParameterField = new TextField();

	static HBox jZeile = new HBox();
	static Label jParameter = new Label("                J: ");
	static TextField jParameterField = new TextField();

	static HBox goClear = new HBox();
	static Button go = new Button("Go");
	static Button clear = new Button("Clear");

	public static VBox infos = new VBox();

}
