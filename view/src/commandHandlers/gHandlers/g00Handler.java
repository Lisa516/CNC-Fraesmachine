package commandHandlers.gHandlers;

import application.ErrorHandling;
import application.Fraeskopf;
import application.MainFX;
import javafx.scene.shape.Circle;
import application.PathClass;

public class g00Handler extends PathClass {
	//Verfahrbewegung im Eilgang (nur ohne Bohren/Fraesen moeglich)
	
	public static boolean test() {
		if (Fraeskopf.fraesenStatus == false) {
			return true;
		}
		ErrorHandling.befehlUnmoeglichFraeseAn();
		return false;
	}
	
	public static void ausfuehren(int x, int y, Circle bohrer) {
		if (test() == false) {
			return;
		}	
		MainFX.move(200, 700);
	}

}



