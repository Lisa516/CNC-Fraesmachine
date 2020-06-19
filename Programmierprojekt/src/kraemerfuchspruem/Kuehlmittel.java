package kraemerfuchspruem;

public class Kuehlmittel {
	
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
}
