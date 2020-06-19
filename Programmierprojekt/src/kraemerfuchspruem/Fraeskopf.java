package kraemerfuchspruem;

public class Fraeskopf
{
	public double fahrGeschwindigkeit;
	public int schnittGeschwindigkeit;
	public boolean fraesenStatus = false;
	//
	public double positionX;
	public double positionY;
	
	
	public double _getFahrGeschwindigkeit() {
		return fahrGeschwindigkeit;
	}
	
	public void _setFahrGeschwindigkeit(double v) {
		fahrGeschwindigkeit = v;
	}
	
	public int _getSchnittGeschwindigkeit() {
		return schnittGeschwindigkeit;
	}
	
	public void _setSchnittGeschwindigkeit(boolean kuehlmittelStatus) {
		if (kuehlmittelStatus == true) {
			schnittGeschwindigkeit = 3;
		}
		else {
			schnittGeschwindigkeit = 2;
		}
	}
	
	public String _getFraesenStatus() {
		if (fraesenStatus == false) {
			return "Die Fräse ist aus";
		}
		else {
			return "Die Fräse ist an";
		}
	}
	
	public void startFraese() {
		if (fraesenStatus == false) {
			fraesenStatus = true;
		}
		else {
			//TODO: Fehlermeldung, wenn Fraese bereits angeschaltet
		}
	}
	
	public void stoppFraese() {
		if (fraesenStatus == true) {
			fraesenStatus = false;
		}
		else {
			//TODO: Fehlermeldung, wenn Fraese gar nicht an war
		}
	}
	
	public void _setPositionX(double x) {
		//TODO: Grenzen festlegen
		positionX = x;
	}
	
	public void _setPositionY(double y) {
		//TODO: Grenzen festlegen
		positionY = y;
	}
	
	public void fraeskopfPositionieren(double x, double y) {
		this._setPositionX(x);
		this._setPositionY(y);
	}
	
	public double _getPositionX() {
		return positionX;
	}
	
	public double _getPositionY() {
		return positionY;
	}
	
	public String _getPosition(double x, double y) {
		return "(" + this._getPositionX() + ";" + this._getPositionY() + ")";
	}
}
//Joshua
