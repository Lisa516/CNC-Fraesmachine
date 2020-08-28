package application;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainFX extends Application {

	/**
	 * public static Fraeskopf fraeskopf = new Fraeskopf(); public static
	 * Kuehlmittel kuehlmittel = new Kuehlmittel(); public static Spindel spindel =
	 * new Spindel(); public static ErrorHandling errorHandler = new
	 * ErrorHandling(); public static BefehlHandler befehlHandler = new
	 * BefehlHandler();
	 **/

	static BorderPane root = new BorderPane();

	public static Circle drill = new Circle(50, 50, 7.5, Color.RED);
	
	// war glaube ich zu viel durchs mergen bin mir aber unsicher ~ Joshua

//	Label position = new Label("Position: " + MillingCutter._getPosition());

//	Label spindleStatus = new Label(Spindle.SpindelAusgabe());

//	Label coolantStatus = new Label("Coolant status: " + Coolant._getStatus());

//	Label speed = new Label("Speed: " + MillingCutter._getGeschwindigkeit() + "m/min");

	Label logfile = new Label("Executed Commands");

	public String userInput;

	public static void drawCircle(double x, double y, double centerX, double centerY, double radius, double startAngle,
			double length) {
		// TODO
	}

	public static void moveLine(int x, int y, double dx, int dy) {
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {

			public void handle(ActionEvent t) {
				// move the ball
				if (UI.bohrer.getLayoutX() < x - 50 || UI.bohrer.getLayoutY() < y - 50) {
					if (UI.bohrer.getLayoutX() >= x) {
						final int dx = 0;
					} else if (UI.bohrer.getLayoutY() >= y) {
						final int dy = 0;
					}
					UI.bohrer.setLayoutX(UI.bohrer.getLayoutX() + dx);
					MillingCutter._setPositionX(UI.bohrer.getLayoutX());
					UI.bohrer.setLayoutY(UI.bohrer.getLayoutY() + dy);
					MillingCutter._setPositionY(UI.bohrer.getLayoutY());
					UI.refreshLabel();
				}
			}
		}));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}

	public static void fraesenLine(int x, int y, double dx, double dy) {
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {

			public void handle(ActionEvent t) {
				// move the ball
				if (UI.bohrer.getLayoutX() < x - 50 || UI.bohrer.getLayoutY() < y - 50) {
					if (UI.bohrer.getLayoutX() >= x) {
						final int dx = 0;
					}

					else if (UI.bohrer.getLayoutY() >= y) {
						final int dy = 0;
					}
					Circle circle = new Circle(UI.bohrer.getLayoutX() + 50, UI.bohrer.getLayoutY() + 50, 3.75,
							Color.BLACK);
					UI.root.getChildren().add(circle);
					UI.bohrer.setLayoutX(UI.bohrer.getLayoutX() + dx);
					MillingCutter._setPositionX(UI.bohrer.getLayoutX());
					UI.bohrer.setLayoutY(UI.bohrer.getLayoutY() + dy);
					MillingCutter._setPositionY(UI.bohrer.getLayoutY());
				}
				UI.refreshLabel();
			}
		}));

		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}

	public static void main(String[] args) throws FileNotFoundException {
		launch(args);
	}

//				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

	public void start(Stage primaryStage) throws SecurityException, IOException {

		primaryStage.setTitle("Milling machine");
		primaryStage.setResizable(false);
		// kein Resizen moeglich um Fehler zu vermeiden
		primaryStage.centerOnScreen();

		Scene scene = new Scene(UI.root, 1100, 725);

		Rectangle workingSurface = new Rectangle(1100, 725, Color.GREY);
		UI.root.getChildren().add(workingSurface);

		Rectangle info = new Rectangle(350, 725, Color.WHITE);
		info.setX(800);
		UI.root.getChildren().add(info);

		Rectangle borderO = new Rectangle(1100, 50, Color.WHITE);
		UI.root.getChildren().add(borderO);

		Rectangle borderU = new Rectangle(1100, 150, Color.WHITE);
		borderU.setY(625);
		UI.root.getChildren().add(borderU);

		Rectangle borderL = new Rectangle(50, 725, Color.WHITE);
		UI.root.getChildren().add(borderL);

		root.getChildren().add(drill);
		UI.root.getChildren().add(UI.bohrer);

		Circle home = new Circle(50, 50, 5, Color.GREEN);
		UI.root.getChildren().add(home);

		VBox infos = new VBox();

		HBox search = new HBox();

		Label command = new Label("Command: ");
		TextField textField = new TextField();

		Button go = new Button("Go");

		Log new_log = new Log("logDatei.txt");

		go.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent o) {

				try {
					userInput = textField.getText();

					new_log.logger.info("Executed commands: " + userInput);

					Label loginfos = new Label(userInput);
					infos.getChildren().add(loginfos);
					root.setRight(infos);
				} 
				catch (Exception e) {

				}
			}

		});

		search.getChildren().addAll(command, textField, go);
		search.setSpacing(5);

		UI.root.setRight(infos);
		infos.setSpacing(10);

		infos.getChildren().add(logfile);

		Label position = new Label("Position: " + MillingCutter._getPosition());
		Label spindleStatus = new Label(Spindle.SpindelAusgabe());
		Label coolantStatus = new Label("Coolant status: " + Coolant._getStatus());
		Label pace = new Label("Pace: " + MillingCutter._getSpeed() + "m/min");
		infos.getChildren().addAll(position, spindleStatus, coolantStatus, pace, search);

		HBox buttons = new HBox();

		Button resume = new Button("Continue");
		resume.setDisable(true);

		Button stop = new Button("Stop");
		stop.setDisable(true);

		Button quit = new Button("Quit");
		quit.setDisable(true);

		Button startJSON = new Button("Start JSON Programm");

		stop.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				stop.setDisable(true);
				resume.setDisable(false);
				MillingCutter.stopMillingCutter();
			}
		});

		quit.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				stop.setDisable(true);
				quit.setDisable(true);
				MillingCutter.stopMillingCutter();
				MillingCutter._setPositionX(0);
				MillingCutter._setPositionY(0);
			}
		});

		resume.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				stop.setDisable(false);
				quit.setDisable(false);
			}
		});

		buttons.getChildren().addAll(stop, resume, quit, startJSON);
		UI.root.setBottom(buttons);
		buttons.setSpacing(5);
		primaryStage.setScene(scene);
		primaryStage.show();

		startJSON.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			Task triggerJsonCommands = new Task<Void>() {
				@Override
				public Void call() throws FileNotFoundException {
					CommandsQueue.QueueFromJSON();
					return null;
				}
			};
			new Thread(triggerJsonCommands).start();
		});

	}
}

/**
 * startJSON.setDisable(true); stop.setDisable(false);
 * abbrechen.setDisable(false);
 **/

//Lisa
