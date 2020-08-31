package errorHandler;

@SuppressWarnings("serial")
public class InvalidFile extends Exception{
	
	private String filename;
	public InvalidFile(String filename) {
		super();
		this.filename = filename;
	}
	
	public String getMessage() {
		return "The name of the file you put in (" + filename + ") is invalid. Please check for spelling mistakes. The type has to be .json.";
	}

}

