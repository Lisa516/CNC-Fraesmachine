public class Fraeskopf
{
	private double _geschwindigkeit;
	
	public double Geschwindigkeit
	{
		get {return _geschwindigkeit;}
		set {_geschwindigkeit = value;}
	}
	
	private boolean _fraesenAktiv;
	
	public boolean fraesenAktiv
	{
		get {return _bohrenAktiv;}
		set {_bohrenAktiv = value;}
	}
	
	public String toString()
	{
		String statusAusgabe;
		
		if (fraesestatus == 0)
		{
			statusAusgabe = "aus";
		}
		
		else
		{
			statusAusgabe = "ein";
		}
	}
	
	public Fraeskopf ()
	{
		
	}
}
