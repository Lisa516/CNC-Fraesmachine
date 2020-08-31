package application;

import java.io.FileNotFoundException;

public class ParametersCommands {
	
	public static int _getX(int index, String file) throws FileNotFoundException {
		String withX = CommandReader._getCommand(index, file)[2];
		String withoutX = withX.substring(1);
		int x = Integer.parseInt(withoutX);
		return (x);
	}

	public static int _getY(int index, String file) throws FileNotFoundException {
		String withY = CommandReader._getCommand(index, file)[3];
		String withoutY = withY.substring(1);
		return (Integer.parseInt(withoutY));
	}

	// return I-value of command (Lisa)
	public static int _getI(int index, String file) throws FileNotFoundException {
		String withI = CommandReader._getCommand(index, file)[3];
		String withoutI = withI.substring(1);
		return (Integer.parseInt(withoutI));
	}

	// return J-value of command (Lisa)
	public static int _getJ(int index, String file) throws FileNotFoundException {
		String withJ = CommandReader._getCommand(index, file)[4];
		String withoutJ = withJ.substring(1);
		return (Integer.parseInt(withoutJ));
	}

}
