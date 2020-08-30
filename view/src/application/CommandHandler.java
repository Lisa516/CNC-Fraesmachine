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
import errorHandler.ErrorHandling;

public class CommandHandler {
	
	//get the code of a specific command
	public static String getCommand(int index, String file) throws FileNotFoundException {
		String command = CommandReader._getCommand(index, file)[1];
		return command;
	}
	
	//Call the right handler for a given command
	public static void callCommand(String command, int index, String file) throws FileNotFoundException {
		if (command.startsWith("G")) {			
			if (command.contentEquals("G00") || command.contentEquals("G01")) {
				callLineCommand(index, command, file);
				return;
			}			
			if (command.contentEquals("G02") || command.contentEquals("G03")) {
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
	
	public static void callCommand(String command, double x, double y, double i, double j) {
		if (command.startsWith("G")) {			
			if (command.contentEquals("G00") || command.contentEquals("G01")) {
				if (x > -1) {
					callLineCommand(command, x, y);
				}
				else {
					ErrorHandling.invalidInput();
				}
				return;
			}			
			if (command.contentEquals("G02") || command.contentEquals("G03")) {
				if (x > -1) {
					callCircleCommand(command, x, y, i, j);
				}
				else {
					ErrorHandling.invalidInput();
				}
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
	public static void callLineCommand(int index, String command, String file) throws FileNotFoundException {
		int x = ParametersCommands._getX(index, file);
		int y = ParametersCommands._getY(index, file);
		if (command.contentEquals("G00")) {
			g00Handler.execute(x, y);
		}
		else {
			g01Handler.execute(x, y);
		}
	}
	
	//Move the Milling Head in a line (Lisa)
	public static void callLineCommand(String command, double x, double y) {
		if (command.contentEquals("G00")) {
			g00Handler.execute(x, y);
		}
		else {
			g01Handler.execute(x, y);
		}
	}
	
	//Mill a Circle (Lisa)
	public static void callCircleCommand(int index, String command, String file) throws FileNotFoundException {
		int x = ParametersCommands._getX(index, file);
		int y = ParametersCommands._getY(index, file);
		int i = ParametersCommands._getI(index, file);
		int j = ParametersCommands._getJ(index, file);
		if (command.contentEquals("G02")) {
			g02Handler.execute(x, y, i, j);
		}
		else {
			g03Handler.execute(x, y, i, j);
		}
	}
	
	//Mill a Circle (Lisa)
	public static void callCircleCommand(String command, double x, double y, double i, double j) {
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
