package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	public static Fraeskopf fraeskopf = new Fraeskopf();
	public static Kuehlmittel kuehlmittel = new Kuehlmittel();
	public static ErrorHandling errorHandling = new ErrorHandling();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,1000,560);
			
			Label position = new Label("Position: " + fraeskopf._getPosition());
			Label kuehlmittelStatus = new Label("Kuehlmittelstatus: " + kuehlmittel.toString());
			
			root.setTop(position);
			root.setTop(kuehlmittelStatus);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			//kein Resizen möglich machen, um Fehler zu verhindern
			primaryStage.centerOnScreen();
			primaryStage.setTitle("Fraesmaschinenapplikation");
			primaryStage.show();
			
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
		
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
}

//Lisa