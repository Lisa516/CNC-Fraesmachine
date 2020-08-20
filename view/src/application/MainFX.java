package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainFX extends Application {
	
	public static Fraeskopf fraeskopf = new Fraeskopf();
	public static Kuehlmittel kuehlmittel = new Kuehlmittel();
	//ErrorHandling??
	
	public static void main(String[] args) {
		launch(args);
		final String HOME;
		Thread t1 = new Kuehlmittel();
		Thread t2 = new Fraeskopf();
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
			Scene scene = new Scene(root, 800, 400, Color.GREY);
			
			Rectangle info = new Rectangle(200, 400, Color.WHITE);
			info.setX(600);
			root.getChildren().add(info);
			
			Circle bohrer = new Circle(0, 0, 5, Color.RED);
			root.getChildren().add(bohrer);
			
			Circle gefraesteFlaeche = new Circle(0,0,0,Color.BLACK);
			gefraesteFlaeche.setRadius(5.0);
			
			Circle home = new Circle(0,0,5,Color.GREEN);
			root.getChildren().add(home);
			
			Text position = new Text(620, 25, "Position: " + fraeskopf._getPosition());
			root.getChildren().add(position);
			
			Text spindelStatus = new Text(620, 75, "Spindelstatus: ");
			root.getChildren().add(spindelStatus);
			
			Text kuehlmittelStatus = new Text(620, 125, "Kuehlmittelstatus: " + kuehlmittel.toString());
			root.getChildren().add(kuehlmittelStatus);
			
			Text geschwindigkeit = new Text(620, 175, "Geschwindigkeit: " + fraeskopf._getGeschwindigkeit() + "m/s");
			root.getChildren().add(geschwindigkeit);
			
			/**Text feldLabel = new Text(620, 225, "Befehl: ");
			TextField befehlFeld = new TextField();
			root.getChildren().add(befehlFeld);
			root.getChildren().add(feldLabel);**/
			
			
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
