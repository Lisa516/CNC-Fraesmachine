package commandHandlers.gHandlers;

import application.ErrorHandling;
import application.Fraeskopf;
import application.MainFX;
import application.Test;

public class g00Handler{
	//Verfahrbewegung im Eilgang (nur ohne Bohren/Fraesen moeglich)
	
	
	
	public static void ausfuehren(int x, int y) {
		if (Test.testFraeseAus() == false) {
			ErrorHandling.befehlUnmoeglichFraeseAn();
			return;
		}	
		System.out.println(x + " " + y + " " + x/y);
		MainFX.moveLine(x, y, x / y, 1);
	}

}