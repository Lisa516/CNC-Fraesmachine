public class Spindel {
	public boolean spindelStatus;
	// 0 = aus, 1 = ein
	public boolean SpindelDrehrichtung;
	// 0 = im Uhrzeigersinn (Rechtslauf), 1 = gegen den Uhrzeigersinn (Linkslauf)
	
	
	public void spindelStopp() {
		if (status == 1) {
			status == 0;
		}
		else {
			//TODO: Fehlermeldung, dass Spindel nicht läuft
		}
	}
	
	public void spindelStart() {
		if (status == 0) {
			status == 0;
		}
		else {
			//TODO: Fehlermeldung, dass Spindel läuft 
		}
	}

}
