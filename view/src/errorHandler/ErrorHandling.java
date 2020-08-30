package errorHandler;

import application.MillingCutter;

public class ErrorHandling extends Thread {

	public ErrorHandling() {
	}
	
	public static String invalidInput() {
		return "The command and values you put in are not valid. Please try again or have a look at the User Documentation.";
	}

	//Error if x-value out of Range (Lisa)
	public static String OutOfRangeX(double value) {
		MillingCutter._setPositionX(0);
		MillingCutter._setPositionY(0);
		return value + "The x-value is out of range. Now, the milling head is sent back to HOME position.";
	}

	//Error if y-value out of range (Lisa)
	public static String OutOfRangeY(double value) {
		MillingCutter._setPositionY(0);
		MillingCutter._setPositionX(0);
		return value + "The y-value is out of range. Now, the milling head is sent back to HOME position.";
	}

	//Error if either x- or y-value is out of range (Lisa)
	public static String OutOfRange() {
		MillingCutter._setPositionY(0);
		MillingCutter._setPositionX(0);
		return "The x or y value is out of range. Now, the milling head is sent back to HOME position.";
	}

	//Error if the milling head was running while someone tried to turn it on.
	public static String millRunning() {
		return "The Milling head is already running and can therefore not be turned on.";
	}

	//Error if the milling head was not running while someone tried to turn it off.
	public static String millStopped() {
		return "The Milling Cutter was tried to be shut off despite he was not running.";
	}

	
	public static String spindleStopped() {
		return "The spindle was tried to be shut off despite she was not running.";
	}

	public static String spindleRunning() {
		return "The spindle was tried to be shut off despite she was not running";
	}

	public static String spindleOff() {
		return "The direction of rotation can not be changed if the spindle is not running.";
	}

	public static String commandInvalidMillNotRunning() {
		return "This command can not be executed because the milling cutter is running.";
	}

	public static String commandImpossibleMillingMachineOff() {
		return "This command can not be executed because the milling cutter is not running.";
	}

	public static String invalidDirectionOfRotation(char eingabe) {
		return eingabe + "is not a valid direction of rotation. A valid direction of rotation is r or l.";
	}

	public static String invalidCommand(String command) {
		return command + "is not a valid command";
	}

	public void run() {

	}

}
