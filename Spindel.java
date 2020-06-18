public class Spindel {
	public boolean status;
	// 0 = aus, 1 = ein
	public boolean drehrichtung;
	// 0 = im Uhrzeigersinn (Rechtslauf), 1 = gegen den Uhrzeigersinn (Linkslauf)
	
	
	public void stopp() {
		if (status == 1) {
			status == 0;
		}
		else {
			//TODO: Fehlermeldung, dass Spindel nicht läuft
		}
	}
	
	public void start() {
		if (status == 0) {
			status == 0;
		}
		else {
			//TODO: Fehlermeldung, dass Spindel läuft 
		}
	}

}
