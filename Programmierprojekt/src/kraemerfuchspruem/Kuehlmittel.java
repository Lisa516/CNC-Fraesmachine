public class Kuehlmittel {
	
private boolean kuehlmittelstatus = 0;
	// 0-> Kühlmittel aus; 1-> Kühlmittel an
	
	public String toString()
	{
		String statusAusgabe;
		if (kuehlmittelstatus == 0)
		{
		statusAusgabe = "aus";
		}
		else
		{
		statusAusgabe = "ein";	
		}
		
	}		
}
