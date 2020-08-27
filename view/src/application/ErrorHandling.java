package application;

public class ErrorHandling extends Thread{
  
  public ErrorHandling() {
  }
	
	public static String OutOfRangeX(double value) {
		Fraeskopf._setPositionX(0);
		Fraeskopf._setPositionY(0);
		return value + "Dieser Wert ist horizontal ausserhalb der Arbeitsflaeche, geben Sie einen Wert unter 1400 ein.";
	}
	
	public static String OutOfRangeY(double value) {
		Fraeskopf._setPositionY(0);
		Fraeskopf._setPositionX(0);
		return value + "Dieser Wert ist horizontal ausserhalb der Arbeitsflaeche, geben Sie einen Wert unter 1050 ein.";
	}
	
	public static String OutOfRange() {
		Fraeskopf._setPositionY(0);
		Fraeskopf._setPositionX(0);
		return "Dieser Ort ist ausserhalb der Arbeitsflaeche";
	}

	
	public static String fraeskopfRunning() {
		return "Der Fraeskopf wurde versucht anzuschalten, obwohl er bereits laeuft.";
	}
	
	public static String fraeskopfStopped() {
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
	
	public static String befehlUnmoeglichFraeseAn() {
		return "Dieser Befehl kann nicht ausgefuehrt werden, da die Fraese an ist";
	}
	
	public static String befehlUnmoeglichFraeseAus() {
		return "Dieser Befehl kann nicht ausgefuehrt werden, da die Fraese aus ist";
	}
	
	public static String ungueltigeDrehrichtung(char eingabe) {
		return eingabe + "ist keine gueltige Drehrichtung. Erlaubt sind l oder r";
	}
	public static String ungueltigerBefehl(String befehl) {
		return befehl + "ist ein ungueltiger Befehl";
	}
	
	public void run() {
		
	}

}

