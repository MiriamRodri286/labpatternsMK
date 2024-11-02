package iterator;

import adapter.SymptomNameComparator;
import adapter.SeveretyIndexComparator;
import adapter.Sorting;
import domain.Covid19Pacient;
import domain.Symptom;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // Crear paciente con 5 s�ntomas
        Covid19Pacient pacient = new Covid19Pacient("Ane", 29);
        pacient.addSymptom(new Symptom("s1", 10, 13), 1);
        pacient.addSymptom(new Symptom("s2", 10, 3), 2);
        pacient.addSymptom(new Symptom("s3", 10, 10), 3);
        pacient.addSymptom(new Symptom("s4", 10, 10), 4); 
        pacient.addSymptom(new Symptom("s5", 10, 10), 5);

        // Adaptador para el paciente
        Covid19PacientAdapter adapter = new Covid19PacientAdapter(pacient.getSymptoms());

        // Ordenar por nombre usando SymptomNameComparator
        System.out.println("SymptomNameComparator:");
        Iterator<Object> sortedByName = Sorting.sortedIterator(adapter, new SymptomNameComparator());
        while (sortedByName.hasNext()) {
            System.out.println(sortedByName.next());
        }

        // Ordenar por  indice de severidad usando SeverityIndexComparator
        System.out.println("\nSeveretyIndexComparator:");
        Iterator<Object> sortedBySeverity = Sorting.sortedIterator(adapter, new SeveretyIndexComparator());
        while (sortedBySeverity.hasNext()) {
            System.out.println(sortedBySeverity.next());
        }
    }
}
