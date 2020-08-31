package ui;

import components.MillingCutter;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/*
 * @author Lisa
 */

public class MillingShapes extends MillingCutter {

	public static Color colorMilledSurface;
	
	public static void millingLineX(double dx, double dy, double absNeuX, double speed) {
		new Thread(() -> {
			for (double i = 0; i < Math.round(absNeuX); i += Math.abs(dx)) {
				try {
					Thread.sleep((long) speed);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Platform.runLater(() -> {

					Circle circle = new Circle(MillingCutter._getPositionX() + 50, MillingCutter._getPositionY() + 50,
							UI.drill.getRadius(), MillingShapes.colorMilledSurface);
					UI.root.getChildren().add(circle);
					UI.drill.toFront();

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
	
	public static void millingLineY(double dx, double dy, double absNeuY, double speed) {
		new Thread(() -> {
			for (double i = 0; i < Math.round(absNeuY); i += Math.abs(dy)) {
				try {
					Thread.sleep((long) speed);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Platform.runLater(() -> {

					Circle circle = new Circle(MillingCutter._getPositionX() + 50, MillingCutter._getPositionY() + 50,
							UI.drill.getRadius(), MillingShapes.colorMilledSurface);
					UI.root.getChildren().add(circle);
					UI.drill.toFront();

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
}
