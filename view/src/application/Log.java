package application;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {
	
	public Logger logger;
	
	public Log(String file_name)throws SecurityException, IOException {
	
		deletePreviousFile(file_name);
		
		File f = new File(file_name);
		
		if(!f.exists()){
			
			f.createNewFile();
			
		}
		
		FileHandler fh = new FileHandler(file_name, true);
		logger = Logger.getLogger("test");
		logger.addHandler(fh);
		SimpleFormatter formatter = new SimpleFormatter();
		fh.setFormatter(formatter);
		
		
	}
	
	public static void deletePreviousFile(String file_name)
	{
		File f = new File(file_name);
		f.delete();
	}

}
