package application;

public class ErrorHandling extends Thread{
	public ErrorHandling() {
	}
	
	public static String fraeskopfRunning() {
		//TODO: Rephrase following
		return "Der Fraeskopf wurde versucht anzuschalten, obwohl er bereits l�uft.";
	}
	
	public static String fraeskopfStopped() {
		//TODO: Rephrase following
		return "Der Fraeskopf wurde versucht auszuschalten, obwohl er nicht lief.";
	}
	
	public static String spindelStopped() {
		//TODO: Rephrase following
		return "Die Spindel wurde versucht auszuschalten, obwohl sie nicht lief.";
	}
	
	public static String spindelRunning() {
		//TODO: Rephrase following
		return "Die Spindel wurde versucht anzuschalten, obwohl sie l�uft.";
	}
	
	public void run() {
		
	}
}
