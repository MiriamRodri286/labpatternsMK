package factory;

import domain.Covid19Pacient;
import domain.Medicament;

public class Main {

	public static void main(String[] args) {
		Medicament m=new Medicament("Ibuprofeno");
		MedicalGUI mgui=new MedicalGUI(m);
	}

}
