package application;

public class ErrorHandling {
	
	public static String OutOfRangeX(double value) {
		Fraeskopf._setPositionX(0);
		return value + "Dieser Wert ist horizontal au�erhalb der Arbeitsfl�che, geben Sie einen Wert unter 1400 ein.";
	}
	
	public static String OutOfRangeY(double value) {
		Fraeskopf._setPositionY(0);
		return value + "Dieser Wert ist horizontal au�erhalb der Arbeitsfl�che, geben Sie einen Wert unter 1050 ein.";
	}
	
	public void run() {
		
	}
}