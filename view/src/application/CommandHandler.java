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

public class CommandHandler {
	
	//return I-value of command (Lisa)
	public static int _getI(int index) throws FileNotFoundException {
		String withI = FileReader._getCommand(index)[3];
		String withoutI = withI.substring(1);
		return (Integer.parseInt(withoutI) + 50);
	}
	
	//return J-value of command (Lisa)
	public static int _getJ(int index) throws FileNotFoundException {
		String withJ = FileReader._getCommand(index)[4];
		String withoutJ = withJ.substring(1);
		return (Integer.parseInt(withoutJ) + 50);
	}
	
	//Call a specific command (Lisa)
	public static void callCommand(int index) throws FileNotFoundException {
		String command = FileReader._getCommand(index)[1];
		if (command.startsWith("G")) {			
			if (command.contentEquals("G00") || command.contentEquals("G01")) {
				callLineCommand(index, command);
				return;
			}			
			if (command.contentEquals("G02") || command.contentEquals("G03")) {
				callCircleCommand(index, command);
				return;
			}

			else if (command.contentEquals("G28")) {
				g28Handler.execute();
				return;
			}
			else {
				ErrorHandling.invalidCommand(command);
			}
		}
		else if (command.startsWith("M")) {
			if (command.contentEquals("M00")) {
				m00Handler.execute();
				return;
			}
			else if (command.contentEquals("M02")) {
				m02Handler.execute();
				return;
			}
			else if (command.contentEquals("M03")) {
				m03Handler.execute();
				return;
			}
			else if (command.contentEquals("M04")) {
				m04Handler.execute();
				return;
			}
			else if (command.contentEquals("M05")) {
				m05Handler.execute();
				return;
			}
			else if (command.contentEquals("M08")) {
				m08Handler.execute();
				return;
			}
			else if (command.contentEquals("M09")) {
				m09Handler.execute();
				return;
			}
			else if (command.contentEquals("M13")) {
				m13Handler.execute();
				return;
			}
			else if (command.contentEquals("M14")) {
				m14Handler.execute();
				return;
			}
			else {
				ErrorHandling.invalidCommand(command);
			}
		}
		else {
			ErrorHandling.invalidCommand(command);
		}
	}
	
	//Move the Milling Head in a line (Lisa)
	public static void callLineCommand(int index, String command) throws FileNotFoundException {
		int x = FileReader._getX(index);
		int y = FileReader._getY(index);
		if (command.contentEquals("G00")) {
			g00Handler.execute(x, y);
		}
		else {
			g01Handler.execute(x, y);
		}
	}
	
	//Mill a Circle (Lisa)
	public static void callCircleCommand(int index, String command) throws FileNotFoundException {
		int x = FileReader._getX(index);
		int y = FileReader._getY(index);
		int i = _getI(index);
		int j = _getJ(index);
		if (command.contentEquals("G02")) {
			g02Handler.execute(x, y, i, j);
		}
		else {
			g03Handler.execute(x, y, i, j);
		}
	}
	
	//Constructor (Lisa)
	public void commandHandler() {
		
	}

	public void run() {
	
	}
	
	public static void main (String...args) throws FileNotFoundException {
		//System.out.println(_getX(2));
		//callCommand(0);
	}

}
