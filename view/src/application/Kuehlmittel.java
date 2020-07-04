package application;

public class Kuehlmittel extends Thread {
	
public boolean kuehlmittelStatus = false;
	// false -> Kuehlmittel aus; true -> Kuehlmittel an
	
	public String toString()
	{
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
	
	public void _setKuehlmittelStatus(boolean status) {
		if (status == true) {
			kuehlmittelStatus = true;
		}
		else {
			kuehlmittelStatus = false;
		}
	}
	
}
//Elias
//Joshi
