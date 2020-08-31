package application;

import components.MillingCutter;
import components.Spindle;
import errorHandler.ErrorHandling;

public class Test implements Runnable{
//Tests concerning milling
	//Milling is supposed to be running. Test whether it is
	public static boolean testMillRunning() {
		if (MillingCutter._getMillingStatus() == true) {
			return true;
		}
		ErrorHandling.commandInvalidMillNotRunning();
		return false;
	}
	
	//Milling is supposed to not be running. Test whether it is
	public static boolean testFraeseAus() {
		if (MillingCutter._getMillingStatus() == false) {
			return true;
		}
		ErrorHandling.commandInvalidMillNotRunning();
		return false;
	}
	
//Tests concerning Spindle
	//Spindle is supposed to be running. Test whether it is
	public static boolean testSpindleRunning() {
		return Spindle._getSpindleStatus();
	}
	
	public static boolean testSpindleNotRunning() {
		if (Spindle._getSpindleStatus() == true) {
			return false;
		}
		return true;
	}
	
//Input Tests	
	//Test whether x-value is in range
	public static boolean testXInRange(double x) {
		if (x >= 0 && x <= 1400) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Test whether y-value is in range
	public static boolean testYInRange(double y) {
		if (y >= 0 && y <= 1050) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Text x- and y-value
	public static boolean testXYInRange(double x, double y) {
		if (testXInRange(x) == true && testYInRange(y) == true) {
			return true;
		}
		return false;
	}
	
	//TODO: I und J testen
	
	public void run() {
		
	}
}
