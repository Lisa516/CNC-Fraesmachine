
public class Student {
	String name;
	int matrikelnummer;
	String adresse;
	double kontostand;
	int semester;
	
	public Student(String name, int matrikelnummer, String adresse, double kontostand, int semester) {
		this.name = name;
		this.matrikelnummer = matrikelnummer;
		this.adresse = adresse;
		this.kontostand = kontostand;
		this.semester = semester;
		System.out.println("Der Student" + name + "(" + matrikelnummer + ") wohnt in" + adresse + "und hat einen Kontostand von" + kontostand + "und ist im" + semester + ". Semester");
	}
	
	public void zinsen(double kontostand, int n) {
		if (n>0) {
			zinsen(kontostand *= 1.017, n -1);
		}
		else {
			System.out.println(kontostand);
		}
	}
	
	public double zinsenite(double kontostand, int n) {
		while (n > 0) {
			kontostand = kontostand * 1.017;
			n = n- 1;
		}
		return kontostand;
	}
	
	public static void main(String[] args) {
		Student Lisa = new Student("Lisa", 1234, "In der Winn", 13.5, 2);
		System.out.println(Lisa);
		Lisa.zinsen(12.5, 5);
		System.out.println(Lisa.zinsenite(12.5, 5));
		
	}


}
