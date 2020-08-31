package ui;

import java.io.FileNotFoundException;
import java.io.IOException;

import application.CommandsQueue;
import application.SettingsReader;
import commandLogging.Log;
import components.MillingCutter;
import inputHandlers.InputReader;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/*
 * @author Lisa
 */

@SuppressWarnings({ "rawtypes", "unused" })
public class MainFX extends Application {

	static BorderPane root = new BorderPane();

	Label logfile = new Label("Executed Commands");

	public String userInput;

	public static void drawCircle(double x, double y, double centerX, double centerY, double radius, double startAngle,
			double length) {
		// TODO
	}

	// Move milling head without milling
	/**
	 * public static void moveLinePositive(double x, double y, double dx, double dy)
	 * { Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20), new
	 * EventHandler<ActionEvent>() { public void handle(ActionEvent t) { if
	 * (UI.drill.getLayoutX() < x || UI.drill.getLayoutY() < y) { if
	 * (UI.drill.getLayoutX() >= x) { final int dx = 0; } else if
	 * (UI.drill.getLayoutY() >= y) { final int dy = 0; }
	 * UI.drill.setLayoutX(UI.drill.getLayoutX() + dx);
	 * MillingCutter._setPositionX(UI.drill.getLayoutX());
	 * UI.drill.setLayoutY(UI.drill.getLayoutY() + dy);
	 * MillingCutter._setPositionY(UI.drill.getLayoutY()); UI.refreshLabel(); } }
	 * })); timeline.setCycleCount(Timeline.INDEFINITE); timeline.play(); }
	 **/

	// Thread which moves the milling head
	public static void moveLineX(double dx, double dy, double absNeuX, double speed) {
		new Thread(() -> {
			for (double i = 0; i < Math.round(absNeuX); i = i + Math.abs(dx)) {
				try {
					Thread.sleep((long) speed);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Platform.runLater(() -> {

					UI.drill.setLayoutX(UI.drill.getLayoutX() + dx);
					MillingCutter._setPositionX(UI.drill.getLayoutX());
					UI.drill.setLayoutY(UI.drill.getLayoutY() + dy);
					MillingCutter._setPositionY(UI.drill.getLayoutY());

					UI.refreshLabel();
				});
			}
			if (Thread.interrupted()) {
				return;
			}
		}).start();
	}
	
	public static void moveLineY(double dx, double dy, double absNeuY, double speed) {
		new Thread(() -> {
			for (double i = 0; i < Math.round(absNeuY); i = i + Math.abs(dy)) {
				try {
					Thread.sleep((long) speed);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Platform.runLater(() -> {

					UI.drill.setLayoutX(UI.drill.getLayoutX() + dx);
					MillingCutter._setPositionX(UI.drill.getLayoutX());
					UI.drill.setLayoutY(UI.drill.getLayoutY() + dy);
					MillingCutter._setPositionY(UI.drill.getLayoutY());

					UI.refreshLabel();
				});
			}
			if (Thread.interrupted()) {
				return;
			}
		}).start();

	}

	public void start(Stage primaryStage) throws SecurityException, IOException {

		Buttons.buttonContinue.setDisable(true);

		Buttons.stop.setDisable(true);

		Buttons.abort.setDisable(true);

		Buttons.startJSON.setDisable(true);

		// Stop the milling process when the stop-button is pressed
		Buttons.stop.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				Buttons.stop.setDisable(true);
				Buttons.buttonContinue.setDisable(false);
				MillingCutter.stopMilling();
			}
		});

		// Abort the milling process when the abort-button is pressed
		Buttons.abort.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				Buttons.stop.setDisable(true);
				Buttons.abort.setDisable(true);
				MillingCutter.stopMilling();
				MillingCutter._setPositionX(0);
				MillingCutter._setPositionY(0);
				System.exit(0);
			}
		});

		// Continue the program after stopping it when the continue-button is pressed
		Buttons.buttonContinue.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				Buttons.stop.setDisable(false);
				Buttons.abort.setDisable(false);
			}
		});

		// Start controlling, then executing the commands listed on the Befehlscode.json
		Buttons.startJSON.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			Task triggerJsonCommands = new Task<Void>() {
				@Override
				public Void call() throws FileNotFoundException {
					CommandsQueue.QueueFromJSON("Befehlscode.json");
					Buttons.startJSON.setDisable(true);
					Buttons.stop.setDisable(false);
					Buttons.abort.setDisable(false);
					return null;
				}
			};
			new Thread(triggerJsonCommands).start();
		});

		// Load the Settings specified on Settings.json
		Buttons.loadSettings.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			try {
				SettingsReader.setSettings();
			} catch (FileNotFoundException e1) {
				// TODO
				e1.printStackTrace();
			}
			Buttons.startJSON.setDisable(false);
			Buttons.loadSettings.setDisable(true);
		});

		primaryStage.setTitle("Milling machine");

		primaryStage.setResizable(false);
		// kein Resizen moeglich um Fehler zu vermeiden
		primaryStage.centerOnScreen();

		UI.root.getChildren().add(UI.workingSurface);

		InfoBox.info.setX(800);
		UI.root.getChildren().add(InfoBox.info);

		UI.root.getChildren().add(UI.borderO);

		UI.borderU.setY(625);
		UI.root.getChildren().add(UI.borderU);

		UI.root.getChildren().add(UI.borderL);

		root.getChildren().add(UI.drill);

		UI.root.getChildren().add(UI.drill);

		UI.root.getChildren().add(UI.home);

		Log new_log = new Log("logDatei.txt");

		InfoBox.befehlZeile.getChildren().addAll(InfoBox.befehl, InfoBox.befehlFeld);
		InfoBox.befehlFeld.setMaxWidth(50);

		InfoBox.xZeile.getChildren().addAll(InfoBox.xParameter, InfoBox.xParameterField);
		InfoBox.xParameterField.setMaxWidth(50);
		// force the field to be numeric only
		InfoBox.xParameterField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					InfoBox.xParameterField.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});

		InfoBox.yParameterField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					InfoBox.yParameterField.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});

		InfoBox.iParameterField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					InfoBox.iParameterField.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});

		InfoBox.jParameterField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					InfoBox.jParameterField.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});

		InfoBox.yZeile.getChildren().addAll(InfoBox.yParameter, InfoBox.yParameterField);
		InfoBox.yParameterField.setMaxWidth(50);

		InfoBox.iZeile.getChildren().addAll(InfoBox.iParameter, InfoBox.iParameterField);
		InfoBox.iParameterField.setMaxWidth(50);

		InfoBox.jZeile.getChildren().addAll(InfoBox.jParameter, InfoBox.jParameterField);
		InfoBox.jParameterField.setMaxWidth(50);

		InfoBox.goClear.getChildren().addAll(InfoBox.clear, InfoBox.go);
		InfoBox.goClear.setSpacing(34);

		InfoBox.go.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String command = "";
				double x = -1;
				double y = -1;
				double i = -1;
				double j = -1;
				if (InfoBox.befehlFeld.getText() != null && !InfoBox.befehlFeld.getText().isEmpty()) {
					command = InfoBox.befehlFeld.getText();
				}
				if (InfoBox.xParameterField.getText() != null && !InfoBox.xParameterField.getText().isEmpty()) {
					x = Double.parseDouble(InfoBox.xParameterField.getText());
				}
				if (InfoBox.yParameterField.getText() != null && !InfoBox.yParameterField.getText().isEmpty()) {
					y = Double.parseDouble(InfoBox.yParameterField.getText());
				}
				if (InfoBox.iParameterField.getText() != null && !InfoBox.iParameterField.getText().isEmpty()) {
					i = Double.parseDouble(InfoBox.iParameterField.getText());
				}
				if (InfoBox.jParameterField.getText() != null && !InfoBox.jParameterField.getText().isEmpty()) {
					j = Double.parseDouble(InfoBox.jParameterField.getText());
				}
				InputReader._getInputAsStrings(command, x, y, i, j);
			}
		});

		UI.root.setRight(InfoBox.infos);
		InfoBox.infos.setSpacing(10);

		InfoBox.infos.getChildren().addAll(InfoBox.position, InfoBox.spindelStatus, InfoBox.coolantStatus,
				InfoBox.velocity, InfoBox.befehlZeile, InfoBox.xZeile, InfoBox.yZeile, InfoBox.iZeile, InfoBox.jZeile,
				InfoBox.goClear, InfoBox.logdatei, InfoBox.commandsText);

		Buttons.buttonsBox.getChildren().addAll(Buttons.stop, Buttons.buttonContinue, Buttons.abort, Buttons.startJSON,
				Buttons.loadSettings);

		UI.root.setBottom(Buttons.buttonsBox);
		Buttons.buttonsBox.setSpacing(5);

		primaryStage.setScene(UI.scene);
		primaryStage.show();
	}

	public static void main(String[] args) throws FileNotFoundException {
		launch(args);
	}
};
