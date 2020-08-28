package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class MillingShapes {
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
}
