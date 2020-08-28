package application;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainFX extends Application {

	static BorderPane root = new BorderPane();

	public static Circle drill = new Circle(50, 50, 7.5, Color.RED);

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

//				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

	public void start(Stage primaryStage) throws SecurityException, IOException {
		
		Buttons.weiter.setDisable(true);
		
		Buttons.stop.setDisable(true);
		
		Buttons.abbrechen.setDisable(true);
		
		Buttons.stop.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				Buttons.stop.setDisable(true);
				Buttons.weiter.setDisable(false);
				MillingCutter.stopMilling();
			}
		});
		
		Buttons.abbrechen.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				Buttons.stop.setDisable(true);
				Buttons.abbrechen.setDisable(true);
				MillingCutter.stopMilling();
				MillingCutter._setPositionX(0);
				MillingCutter._setPositionY(0);
			}
		});
		
		Buttons.weiter.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				Buttons.stop.setDisable(false);
				Buttons.abbrechen.setDisable(false);
			}
		});
		
		Buttons.startJSON.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			Task triggerJsonCommands = new Task<Void>() {
				@Override
				public Void call() throws FileNotFoundException {
					CommandsQueue.QueueFromJSON();
					Buttons.startJSON.setDisable(true);
					Buttons.stop.setDisable(false);
					Buttons.abbrechen.setDisable(false);
					return null;
				}
			};
			new Thread(triggerJsonCommands).start();
		});

		primaryStage.setTitle("Milling machine");

		primaryStage.setResizable(false);
		// kein Resizen moeglich um Fehler zu vermeiden
		primaryStage.centerOnScreen();

		Scene scene = new Scene(UI.root, 1100, 725);

		Rectangle workingSurface = new Rectangle(1100, 725, Color.GREY);
		UI.root.getChildren().add(workingSurface);

		InfoBox.info.setX(800);
		UI.root.getChildren().add(InfoBox.info);

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

		Log new_log = new Log("logDatei.txt");

		InfoBox.go.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent o) {

				try {
					String eingabeUser = InfoBox.textField.getText();

					new_log.logger.info("Ausgefuehrter Befehl: " + eingabeUser);

					Label loginfos = new Label(eingabeUser);
					InfoBox.infos.getChildren().add(loginfos);
					root.setRight(InfoBox.infos);
				} catch (Exception e) {
					// TODO
				}
			}
		});

		InfoBox.suchen.getChildren().addAll(InfoBox.befehl, InfoBox.textField, InfoBox.go);
		InfoBox.suchen.setSpacing(5);

		UI.root.setRight(InfoBox.infos);
		InfoBox.infos.setSpacing(10);

		InfoBox.infos.getChildren().addAll(InfoBox.position, InfoBox.spindelStatus, InfoBox.coolantStatus, InfoBox.velocity, InfoBox.suchen, InfoBox.logdatei);

		Buttons.buttons.getChildren().addAll(Buttons.stop, Buttons.weiter, Buttons.abbrechen, Buttons.startJSON, Buttons.loadSettings);
		
		UI.root.setBottom(Buttons.buttons);
		Buttons.buttons.setSpacing(5);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) throws FileNotFoundException {
		launch(args);
	}
};

//Lisa
