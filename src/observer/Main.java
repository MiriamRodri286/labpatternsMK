package observer;

import java.util.Observable;

import domain.Covid19Pacient;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Covid19Pacient pacient1 = new Covid19Pacient("aitor", 35);
		new PacientObserverGUI(pacient1);
		new PacientSymptomGUI(pacient1);
		new PacientThermometerGUI(pacient1);
		new SemaphorGUI(pacient1);
		/**
		// Bigarren pazientea
		Covid19Pacient pacient2 = new Covid19Pacient("maria", 40);
		new PacientObserverGUI(pacient2);
		new PacientSymptomGUI(pacient2);
		new PacientThermometerGUI(pacient2);
		
		// Hirugarren pazientea
		Covid19Pacient pacient3 = new Covid19Pacient("kepa", 20);
		new PacientObserverGUI(pacient3);
		new PacientSymptomGUI(pacient3);
		new PacientThermometerGUI(pacient3);
		**/
	}


}
