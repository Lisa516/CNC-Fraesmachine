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
		Fraeskopf fraeskopf = new Fraeskopf();
		Kuehlmittel kuehlmittel = new Kuehlmittel();
		int test;
	}
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,1000,560);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			Label position = new Label("test");
		} catch(Exception e) {
			e.printStackTrace();
		}
	
	}
}

//Lisa