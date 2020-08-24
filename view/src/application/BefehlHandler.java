package application;

import java.io.FileNotFoundException;

import commandHandlers.gHandlers.g00Handler;
import commandHandlers.gHandlers.g01Handler;
import commandHandlers.gHandlers.g02Handler;
import commandHandlers.gHandlers.g03Handler;
import commandHandlers.gHandlers.g28Handler;

import commandHandlers.mHandlers.m00Handler;
import commandHandlers.mHandlers.m02Handler;

public class BefehlHandler {
	
	public static boolean testX(int x) {
		return (x < 1401);
	}
	
	public static boolean testY(int y) {
		return (y < 1051);
	}
	
	public static int _getX(int stelle) throws FileNotFoundException {
		String withX = FileReader._getBefehl(stelle)[2];
		String withoutX = withX.substring(1);
		int x = Integer.parseInt(withoutX);
		return x;
	}
	
	public static int _getY(int stelle) throws FileNotFoundException {
		String withY = FileReader._getBefehl(stelle)[3];
		String withoutY = withY.substring(1); 
		return Integer.parseInt(withoutY);
	}
	
	public static void befehlAufrufen(int stelle) throws FileNotFoundException {
		String befehl = FileReader._getBefehl(stelle)[1];
		int x = _getX(stelle);
		int y = _getY(stelle);
		if (befehl.startsWith("G")) {
			if (testX(x) == false || testY(y) == false) {
				ErrorHandling.OutOfRange();
				return;
			}
			if (befehl == "G00") {
				g00Handler.ausfuehren(x, y);
				return;
			}
			if (befehl == "G01") {
				g01Handler.ausfuehren(x, y);
				return;
			}
			if (befehl == "G02") {
				g02Handler.ausfuehren(x, y);
				return;
			}
			if (befehl == "G03") {
				g03Handler.ausfuehren(x, y);
				return;
			}
			if (befehl == "G28") {
				g28Handler.ausfuehren(x, y);
				return;
			}
		}
		else {
			if (befehl == "M00") {
				m00Handler.ausfuehren();
				return;
			}
			if (befehl == "M02") {
				m02Handler.ausfuehren();
				return;
			}
		}
	}
	
	public void befehlHandler() {
		
	}

	public void run() {
	
	}
	
	public static void main (String...args) throws FileNotFoundException {
		//System.out.println(_getX(2));
	}

}
