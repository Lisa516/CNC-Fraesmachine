package application;

public class Kuehlmittel implements Runnable {
	
public static boolean kuehlmittelStatus = false;
	// false -> Kuehlmittel aus; true -> Kuehlmittel an
	
	public static String _getStatus() {
		String statusAusgabe;
		if (kuehlmittelStatus == false)
		{
		statusAusgabe = "aus";
		}
		else
		{
		statusAusgabe = "ein";	
		}
	return statusAusgabe;	
	}	
	
	public boolean _getKuehlmittelStatus() {
		if (kuehlmittelStatus == false) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public static void _setKuehlmittelStatus(boolean status) {
		if (status == true) {
			kuehlmittelStatus = true;
		}
		else {
			kuehlmittelStatus = false;
		}
	}
	
	public void run() {
		//TODO: Insert Thread Actions here
	}
	
}
//Elias
//Joshi
