package application;

public class ErrorHandling extends Thread {

	public ErrorHandling() {
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
		return "Der Fraeskopf wurde versucht auszuschalten, obwohl er nicht lief.";
	}

	
	public static String spindelStopped() {
		return "Die Spindel wurde versucht auszuschalten, obwohl sie nicht lief.";
	}

	public static String spindelRunning() {
		return "Die Spindel wurde versucht anzuschalten, obwohl sie laeuft.";
	}

	public static String spindelAus() {
		return "Die Drehrichtung kann nicht geaendert werden, wenn die Spindel aus ist.";
	}

	public static String commandInvalidMillNotRunning() {
		return "Dieser Befehl kann nicht ausgefuehrt werden, da die Fraese an ist";
	}

	public static String befehlUnmoeglichFraeseAus() {
		return "Dieser Befehl kann nicht ausgefuehrt werden, da die Fraese aus ist";
	}

	public static String ungueltigeDrehrichtung(char eingabe) {
		return eingabe + "ist keine gueltige Drehrichtung. Erlaubt sind l oder r";
	}

	public static String invalidCommand(String command) {
		return command + "is not a valid command";
	}

	public void run() {

	}

}
