package application;

import java.io.FileNotFoundException;

import commandHandlers.gHandlers.g00Handler;
import commandHandlers.gHandlers.g01Handler;
import commandHandlers.gHandlers.g02Handler;
import commandHandlers.gHandlers.g03Handler;
import commandHandlers.gHandlers.g28Handler;

import commandHandlers.mHandlers.m00Handler;
import commandHandlers.mHandlers.m02Handler;
import commandHandlers.mHandlers.m03Handler;
import commandHandlers.mHandlers.m04Handler;
import commandHandlers.mHandlers.m05Handler;
import commandHandlers.mHandlers.m08Handler;
import commandHandlers.mHandlers.m09Handler;
import commandHandlers.mHandlers.m13Handler;
import commandHandlers.mHandlers.m14Handler;

public class BefehlHandler {
	
	public static boolean testX(int x) {
		return (x < 1401);
	}
	
	public static boolean testY(int y) {
		return (y < 1051);
	}
	
	public static int _getI(int stelle) throws FileNotFoundException {
		String withI = FileReader._getBefehl(stelle)[3];
		String withoutI = withI.substring(1);
		return (Integer.parseInt(withoutI) + 50);
	}
	
	public static int _getJ(int stelle) throws FileNotFoundException {
		String withJ = FileReader._getBefehl(stelle)[4];
		String withoutJ = withJ.substring(1);
		return (Integer.parseInt(withoutJ) + 50);
	}
	
	public static void befehlAufrufen(int stelle) throws FileNotFoundException {
		String befehl = FileReader._getBefehl(stelle)[1];
		if (befehl.startsWith("G")) {			
			if (befehl.contentEquals("G00") || befehl.contentEquals("G01")) {
				linienBefehlAufrufen(stelle, befehl);
				return;
			}			
			if (befehl.contentEquals("G02") || befehl.contentEquals("G03")) {
				kreisBefehlAufrufen(stelle, befehl);
				return;
			}

			else if (befehl.contentEquals("G28")) {
				g28Handler.ausfuehren();
				return;
			}
			else {
				ErrorHandling.ungueltigerBefehl(befehl);
			}
		}
		else if (befehl.startsWith("M")) {
			if (befehl.contentEquals("M00")) {
				m00Handler.ausfuehren();
				return;
			}
			else if (befehl.contentEquals("M02")) {
				m02Handler.ausfuehren();
				return;
			}
			else if (befehl.contentEquals("M03")) {
				m03Handler.ausfuehren();
				return;
			}
			else if (befehl.contentEquals("M04")) {
				m04Handler.ausfuehren();
				return;
			}
			else if (befehl.contentEquals("M05")) {
				m05Handler.ausfuehren();
				return;
			}
			else if (befehl.contentEquals("M08")) {
				m08Handler.ausfuehren();
				return;
			}
			else if (befehl.contentEquals("M09")) {
				m09Handler.ausfuehren();
				return;
			}
			else if (befehl.contentEquals("M13")) {
				m13Handler.ausfuehren();
				return;
			}
			else if (befehl.contentEquals("M14")) {
				m14Handler.ausfuehren();
				return;
			}
			else {
				ErrorHandling.ungueltigerBefehl(befehl);
			}
		}
		else {
			ErrorHandling.ungueltigerBefehl(befehl);
		}
	}
	
	public static void linienBefehlAufrufen(int stelle, String befehl) throws FileNotFoundException {
		int x = FileReader._getX(stelle);
		int y = FileReader._getY(stelle);
		if (befehl.contentEquals("G00")) {
			g00Handler.ausfuehren(x, y);
		}
		else {
			g01Handler.ausfuehren(x, y);
		}
	}
	
	public static void kreisBefehlAufrufen(int stelle, String befehl) throws FileNotFoundException {
		int x = FileReader._getX(stelle);
		int y = FileReader._getY(stelle);
		int i = _getI(stelle);
		int j = _getJ(stelle);
		if (befehl.contentEquals("G02")) {
			g02Handler.ausfuehren(x, y, i, j);
		}
		else {
			g03Handler.ausfuehren(x, y, i, j);
		}
	}
	
	public void befehlHandler() {
		
	}

	public void run() {
	
	}
	
	public static void main (String...args) throws FileNotFoundException {
		//System.out.println(_getX(2));
		befehlAufrufen(0);
	}

}
