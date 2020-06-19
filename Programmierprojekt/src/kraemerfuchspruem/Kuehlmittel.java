package kraemerfuchspruem;

public class Kuehlmittel {
	
private boolean kuehlmittelStatus = false;
	// false -> Kühlmittel aus; true -> Kühlmittel an
	
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
}
