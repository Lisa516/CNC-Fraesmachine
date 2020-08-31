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

	/*
	 * @author Lisa
	 */

	// get the G/M-code of a specific command from a json-file
	public static String getCommand(int index, String file) throws FileNotFoundException {
		String command = CommandReader._getCommand(index, file)[1];
		return command;
	}

	// Call the right handler for a given command
	public static void callCommand(String command, int index, String file) throws FileNotFoundException {
		switch (command) {
		case "G00":
		case "G01":
			callLineCommand(index, command, file);
			break;
		case "G02":
		case "G03":
			callCircleCommand(index, command, file);
			break;
		case "G28":
			g28Handler.execute();
			break;
		case "M00":
			m00Handler.execute();
			break;
		case "M02":
			m02Handler.execute();
			break;
		case "M03":
			m03Handler.execute();
			break;
		case "M04":
			m04Handler.execute();
			break;
		case "M05":
			m05Handler.execute();
			break;
		case "M08":
			m08Handler.execute();
			break;
		case "M09":
			m09Handler.execute();
			break;
		case "M13":
			m13Handler.execute();
			break;
		case "M14":
			m14Handler.execute();
			break;
		default:
			ErrorHandling.invalidCommand(command);
		}
	}

	// Call the right handler for a given command (overload to make it work for UI
	// Input)
	public static void callCommand(String command, double x, double y, double i, double j) {
		switch (command) {
		case "G00":
		case "G01":
			if (x > -1 && y > -1) {
				callLineCommand(command, x, y);
			} else {
				ErrorHandling.invalidInput();
			}
			break;
		case "G02":
		case "G03":
			if (x > -1 && y > -1 && i > -1 && j > -1) {
				callCircleCommand(command, x, y, i, j);
			} else {
				ErrorHandling.invalidInput();
			}
			break;
		case "G28":
			g28Handler.execute();
			break;
		case "M00":
			m00Handler.execute();
			break;
		case "M02":
			m02Handler.execute();
			break;
		case "M03":
			m03Handler.execute();
			break;
		case "M04":
			m04Handler.execute();
			break;
		case "M05":
			m05Handler.execute();
			break;
		case "M08":
			m08Handler.execute();
			break;
		case "M09":
			m09Handler.execute();
			break;
		case "M13":
			m13Handler.execute();
			break;
		case "M14":
			m14Handler.execute();
			break;
		default:
			ErrorHandling.invalidCommand(command);
		}
	}

	// Move the Milling Head in a line
	public static void callLineCommand(int index, String command, String file) throws FileNotFoundException {
		int x = ParametersCommands._getX(index, file);
		int y = ParametersCommands._getY(index, file);
		if (command.contentEquals("G00")) {
			g00Handler.execute(x, y);
		} else {
			g01Handler.execute(x, y);
		}
	}

	// Move the Milling Head in a line overloaded to work for Input on UI
	public static void callLineCommand(String command, double x, double y) {
		if (command.contentEquals("G00")) {
			g00Handler.execute(x, y);
		} 
		else {
			g01Handler.execute(x, y);
		}
	}

	// Mill a Circle
	public static void callCircleCommand(int index, String command, String file) throws FileNotFoundException {
		int x = ParametersCommands._getX(index, file);
		int y = ParametersCommands._getY(index, file);
		int i = ParametersCommands._getI(index, file);
		int j = ParametersCommands._getJ(index, file);
		if (command.contentEquals("G02")) {
			g02Handler.execute(x, y, i, j);
		} else {
			g03Handler.execute(x, y, i, j);
		}
	}

	// Mill a Circle overloaded to work for Input on UI
	public static void callCircleCommand(String command, double x, double y, double i, double j) {
		if (command.contentEquals("G02")) {
			g02Handler.execute(x, y, i, j);
		} else {
			g03Handler.execute(x, y, i, j);
		}
	}

	// Constructor
	public void commandHandler() {

	}

	public void run() {

	}

	public static void main(String... args) throws FileNotFoundException {

	}

}
