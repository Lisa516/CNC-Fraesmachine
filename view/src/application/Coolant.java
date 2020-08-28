package application;

public class Coolant implements Runnable {
		
	private static boolean coolantStatus = false;
	// false -> Coolant turned off; true -> Coolant turned off
  
	public static String _getStatus() {
		String statusOutput;
		if (coolantStatus == false)
		{
		statusOutput = "off";
		}
		else
		{
		statusOutput = "on";	
		}
	return statusOutput;	
	}	
	
	public boolean _getCoolantStatus() {
		if (coolantStatus == false) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public static void _setCoolantStatus(boolean status) {
		if (status == true) {
			coolantStatus = true;
		}
		else {
			coolantStatus = false;
		}
	}
	
	public void run() {
		//TODO: Insert Thread Actions here
	}

}
//Elias
//Joshi
