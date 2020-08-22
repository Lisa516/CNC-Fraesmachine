package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainFX extends Application {
	
	public static Fraeskopf fraeskopf = new Fraeskopf();
	public static Kuehlmittel kuehlmittel = new Kuehlmittel();
	public static Spindel spindel = new Spindel();
	//ErrorHandling??
	
	public static void main(String[] args) {
		launch(args);
		Thread t1 = new Thread (new Fraeskopf());
		Thread t2 = new Thread (new Kuehlmittel());
		t1.start();
		t2.start();
		run();
	}
	
	public static void run() {
		
	}
	
	@Override
//				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Fraesmaschine");
			primaryStage.setResizable(false);
			//kein Resizen möglich um Fehler zu vermeiden
			primaryStage.centerOnScreen();
			
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 1100, 725);
			
			Rectangle info = new Rectangle(200, 725, Color.WHITE);
			info.setX(800);
			root.getChildren().add(info);
			
			Rectangle borderO = new Rectangle(1100, 100, Color.WHITE);
			root.getChildren().add(borderO);
			
			Rectangle borderR = new Rectangle(100, 725, Color.WHITE);
			borderR.setX(1000);
			root.getChildren().add(borderR);
			
			Rectangle borderU = new Rectangle(1100, 100, Color.WHITE);
			borderU.setY(625);
			root.getChildren().add(borderU);
			
			Rectangle borderL = new Rectangle(100, 725, Color.WHITE);
			root.getChildren().add(borderL);
			
			Circle bohrer = new Circle(100, 100, 5, Color.RED);
			root.getChildren().add(bohrer);
			
			Circle gefraesteFlaeche = new Circle(0,0,0,Color.BLACK);
			gefraesteFlaeche.setRadius(5.0);
			
			Circle home = new Circle(100,100,5,Color.GREEN);
			root.getChildren().add(home);
			
			VBox infos = new VBox();
			
			Label position = new Label("Position: " + fraeskopf._getPosition());
			
			Label spindelStatus = new Label(spindel.toString());
			
			Label kuehlmittelStatus = new Label("Kuehlmittelstatus: " + kuehlmittel.toString());
			
			Label geschwindigkeit = new Label("Geschwindigkeit: " + fraeskopf._getGeschwindigkeit() + "m/s");
			
			infos.getChildren().addAll(position, spindelStatus, kuehlmittelStatus, geschwindigkeit);
			root.setRight(infos);
			
			/**Text position = new Text(820, 125, "Position: " + fraeskopf._getPosition());
			root.getChildren().add(position);
			
			Text spindelStatus = new Text(820, 175, spindel.toString());
			root.getChildren().add(spindelStatus);
			
			Text kuehlmittelStatus = new Text(820, 225, "Kuehlmittelstatus: " + kuehlmittel.toString());
			root.getChildren().add(kuehlmittelStatus);
			
			Text geschwindigkeit = new Text(820, 275, "Geschwindigkeit: " + fraeskopf._getGeschwindigkeit() + "m/s");
			root.getChildren().add(geschwindigkeit);**/
			
			/**Text feldLabel = new Text(620, 225, "Befehl: ");
			TextField befehlFeld = new TextField();
			root.getChildren().add(befehlFeld);
			root.getChildren().add(feldLabel);**/
			
			HBox buttons = new HBox();
			
			Button weiter = new Button("Weiter");
			weiter.setDisable(true);
			
			Button stop = new Button("Stop");
			stop.setDisable(true);
			stop.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					stop.setDisable(true);
					weiter.setDisable(false);
				}
			});
			
			Button abbrechen = new Button("Abbrechen");
			abbrechen.setDisable(true);
			
			buttons.getChildren().addAll(stop, weiter, abbrechen);
			root.setBottom(buttons);			
			
		/**	Text arbeitsflaeche = new Text(25, 25, "Arbeitsflaeche");
			arbeitsflaeche.setFill(Color.CHOCOLATE);
			arbeitsflaeche.setFont(Font.font(java.awt.Font.SERIF, 25));
			root.getChildren().add(arbeitsflaeche); **/
        
			primaryStage.setScene(scene);
			primaryStage.show();
			
		}	
			catch (Exception e) {
			e.printStackTrace();
		}
	}
}

//Lisa
