package application;

import java.io.FileNotFoundException;

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

	public String eingabeUser;

	public static void drawCircle(double x, double y, double centerX, double centerY, double radius, double startAngle,
			double length) {
		// TODO
	}

	public static void moveLine(int x, int y, double dx, int dy) {
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {

			public void handle(ActionEvent t) {
				// move the ball
				if (bohrer.getLayoutX() < x - 50 || bohrer.getLayoutY() < y - 50) {
					if (bohrer.getLayoutX() >= x) {
						final int dx = 0;
					} else if (bohrer.getLayoutY() >= y) {
						final int dy = 0;
					}
					bohrer.setLayoutX(bohrer.getLayoutX() + dx);
					MillingCutter._setPositionX(bohrer.getLayoutX());
					bohrer.setLayoutY(bohrer.getLayoutY() + dy);
					MillingCutter._setPositionY(bohrer.getLayoutY());
					refreshLabel();
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
				if (bohrer.getLayoutX() < x - 50 || bohrer.getLayoutY() < y - 50) {
					if (bohrer.getLayoutX() >= x) {
						final int dx = 0;
					}

					else if (bohrer.getLayoutY() >= y) {
						final int dy = 0;
					}
					Circle circle = new Circle(bohrer.getLayoutX() + 50, bohrer.getLayoutY() + 50, 3.75, Color.BLACK);
					root.getChildren().add(circle);
					bohrer.setLayoutX(bohrer.getLayoutX() + dx);
					MillingCutter._setPositionX(bohrer.getLayoutX());
					bohrer.setLayoutY(bohrer.getLayoutY() + dy);
					MillingCutter._setPositionY(bohrer.getLayoutY());
				}
				refreshLabel();
			}
		}));

		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}

	public static void main(String[] args) throws FileNotFoundException {
		launch(args);
	}

	public static void run() {

	}

	@Override
//				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

	public void start(Stage primaryStage) {
		primaryStage.setTitle("Fraesmaschine");
		primaryStage.setResizable(false);
		// kein Resizen möglich um Fehler zu vermeiden
		primaryStage.centerOnScreen();

		Scene scene = new Scene(root, 1100, 725);

		Rectangle arbeitsflaeche = new Rectangle(1100, 725, Color.GREY);
		root.getChildren().add(arbeitsflaeche);

		Rectangle info = new Rectangle(350, 725, Color.WHITE);
		info.setX(800);
		root.getChildren().add(info);

		Rectangle borderO = new Rectangle(1100, 50, Color.WHITE);
		root.getChildren().add(borderO);

		Rectangle borderU = new Rectangle(1100, 150, Color.WHITE);
		borderU.setY(625);
		root.getChildren().add(borderU);

		Rectangle borderL = new Rectangle(50, 725, Color.WHITE);
		root.getChildren().add(borderL);

		root.getChildren().add(bohrer);

		Circle home = new Circle(50, 50, 5, Color.GREEN);
		root.getChildren().add(home);

		VBox infos = new VBox();

		HBox suchen = new HBox();

		Label befehl = new Label("Befehl: ");
		TextField textField = new TextField();

		Button go = new Button("Go");

		go.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent AE) {
				eingabeUser = textField.getText();
			}
		});

		try {
			Log new_log = new Log("logDatei.txt");
			new_log.logger.info("Ausgeführter Befehl: " + eingabeUser);

		} catch (Exception e) {
			// TODO
		}

		suchen.getChildren().addAll(befehl, textField, go);
		suchen.setSpacing(5);

		root.setRight(infos);
		infos.setSpacing(10);

		Label position = new Label("Position: " + MillingCutter._getPosition());
		Label spindelStatus = new Label(Spindle.SpindelAusgabe());
		Label kuehlmittelStatus = new Label("Kuehlmittelstatus: " + Kuehlmittel._getStatus());
		Label geschwindigkeit = new Label("Geschwindigkeit: " + MillingCutter._getGeschwindigkeit() + "m/min");
		infos.getChildren().addAll(position, spindelStatus, kuehlmittelStatus, geschwindigkeit, suchen);

		HBox buttons = new HBox();

		Button weiter = new Button("Weiter");
		weiter.setDisable(true);

		Button stop = new Button("Stop");
		stop.setDisable(true);

		Button abbrechen = new Button("Abbrechen");
		abbrechen.setDisable(true);

		Button startJSON = new Button("Start JSON Programm");

		stop.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				stop.setDisable(true);
				weiter.setDisable(false);
				MillingCutter.stoppFraese();
			}
		});

		abbrechen.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				stop.setDisable(true);
				abbrechen.setDisable(true);
				MillingCutter.stoppFraese();
				MillingCutter._setPositionX(0);
				MillingCutter._setPositionY(0);
			}
		});

		weiter.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				stop.setDisable(false);
				abbrechen.setDisable(false);
			}
		});

		startJSON.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				Task triggerJsonCommands = new Task<Void>() {
					@Override
					public Void call() throws FileNotFoundException {
						CommandsQueue.QueueFromJSON();
						return null;
					}
				};
				new Thread(triggerJsonCommands).start();
				startJSON.setDisable(true);
				stop.setDisable(false);
				abbrechen.setDisable(false);
			}
		});

		buttons.getChildren().addAll(stop, weiter, abbrechen, startJSON);
		root.setBottom(buttons);
		buttons.setSpacing(5);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
//Lisa
