package components;

/*
 * @author Elias
 */

public class Coolant {

	// false -> Coolant turned off; true -> Coolant turned off
	private static boolean coolantStatus = false;

	// Getter

	// Getter that returns a String for the UI
	public static String _getStatus() {
		String statusOutput;
		if (coolantStatus == false) {
			statusOutput = "off";
		} else {
			statusOutput = "on";
		}
		return statusOutput;
	}

	public static boolean _getCoolantStatus() {
		if (coolantStatus == false) {
			return false;
		} else {
			return true;
		}
	}

	// Setter

	public static void _setCoolantStatus(boolean status) {
		if (status == true) {
			coolantStatus = true;
		} else {
			coolantStatus = false;
		}
	}

}