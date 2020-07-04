package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	public static void main(String[] args) {
		//launch(args);
		final String HOME;
		Thread t1 = new Kuehlmittel();
		Thread t2 = new Fraeskopf();
		t1.start();
		t2.start();
		run();
		
	}
	
public static Fraeskopf fraeskopf = new Fraeskopf();
public static Kuehlmittel kuehlmittel = new Kuehlmittel();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,1000,560);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			Label position = new Label(fraeskopf._getPosition());
		} catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public static void run() {
	}
}

//Lisa