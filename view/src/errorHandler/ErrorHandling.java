package errorHandler;

import java.io.IOException;

import CommandLogging.Log;
import application.MillingCutter;

public class ErrorHandling extends Thread {

	public ErrorHandling() {
	}
	
	public static void invalidInput() {
		outputString("The command and values you put in are not valid. Please try again or have a look at the User Documentation.");
	}

	//Error if x-value out of Range (Lisa)
	public static void OutOfRangeX(double value) {
		MillingCutter._setPositionX(0);
		MillingCutter._setPositionY(0);
		outputString(value + " The x-value is out of range. Now, the milling head is sent back to HOME position.");
	}

	//Error if y-value out of range (Lisa)
	public static void OutOfRangeY(double value) {
		MillingCutter._setPositionY(0);
		MillingCutter._setPositionX(0);
		outputString (value + " The y-value is out of range. Now, the milling head is sent back to HOME position.");
	}

	//Error if either x- or y-value is out of range (Lisa)
	public static void OutOfRange() {
		MillingCutter._setPositionY(0);
		MillingCutter._setPositionX(0);
		outputString("The x or y value is out of range. Now, the milling head is sent back to HOME position.");
	}

	//Error if the milling head was running while someone tried to turn it on.
	public static void millRunning() {
		outputString("The Milling head is already running and can therefore not be turned on.");
	}

	//Error if the milling head was not running while someone tried to turn it off.
	public static void millStopped() {
		outputString ("The Milling Cutter was tried to be shut off despite he was not running.");
	}

	
	public static void spindleStopped() {
		outputString ("The spindle was tried to be shut off despite she was not running.");
	}

	public static void spindleRunning() {
		outputString("The spindle was tried to be shut off despite she was not running");
	}

	public static void spindleOff() {
		outputString ("The direction of rotation can not be changed if the spindle is not running.");
	}

	public static void commandInvalidMillNotRunning() {
		outputString ("This command can not be executed because the milling cutter is running.");
	}

	public static void commandImpossibleMillingMachineOff() {
		outputString ("This command can not be executed because the milling cutter is not running.");
	}

	public static void invalidDirectionOfRotation(char eingabe) {
		outputString (eingabe + " is not a valid direction of rotation. A valid direction of rotation is r or l.");
	}

	public static void invalidCommand(String command) {
		outputString (command + " is not a valid command");
	}
	
	public static void outputString(String command)
	{
		Log new_log;
		try {
			new_log = new Log("logDatei.txt");
			new_log.logger.info("ERROR: " + command);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {

	}

}