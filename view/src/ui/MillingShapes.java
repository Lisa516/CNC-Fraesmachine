package ui;

import application.MillingCutter;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

@SuppressWarnings("unused")
public class MillingShapes extends MillingCutter {
	
	public static Color colorMilledSurface;
	
	public static void fraesenLine(int x, int y, double dx, double dy) {
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {

			public void handle(ActionEvent t) {
				if (UI.drill.getLayoutX() < (x - 50) || UI.drill.getLayoutY() < (y - 50)) {
					if (UI.drill.getLayoutX() >= x) {
						final int dx = 0;
					}

					else if (UI.drill.getLayoutY() >= y) {
						final int dy = 0;
					}
					Circle circle = new Circle(UI.drill.getLayoutX() + 50, UI.drill.getLayoutY() + 50, 3.75, colorMilledSurface);
					UI.root.getChildren().add(circle);
					UI.drill.setLayoutX(UI.drill.getLayoutX() + dx);
					_setPositionX(UI.drill.getLayoutX());
					UI.drill.setLayoutY(UI.drill.getLayoutY() + dy);
					_setPositionY(UI.drill.getLayoutY());
				}
				UI.refreshLabel();
			}
		}));

		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}
}
