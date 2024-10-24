package domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import iterator.Covid19PacientIterator;

public class Covid19Pacient extends Observable {
    private String name;
    private int age;
    private Map<Symptom, Integer> symptoms = new HashMap<>();

    public Covid19Pacient(String name, int years) {
        this.name = name;
        this.age = years;
    }

    public String getName() {
        return name; 
    }

    public void setName(String name) {
        this.name = name; 
    }

    public int getAge() {
        return age; 
    }

    public void setAge(int age) {
        this.age = age; 
    }

    public int getWeight(Symptom s) {
        return symptoms.get(s);
    }

    public Set<Symptom> getSymptoms() {
        return symptoms.keySet();
    }

    public Symptom getSymptomByName(String symptomName) {
        Iterator<Symptom> i = getSymptoms().iterator();
        Symptom s = null;
        while (i.hasNext()) {
            s = i.next();
            if (s != null && s.getName().equals(symptomName)) return s;
        }
        return null;
    }

    public void addSymptom(Symptom c, Integer w) {
        symptoms.put(c, w);
    }

    public Symptom addSymptomByName(String symptomName, Integer w) {
        Symptom s = getSymptomByName(symptomName);
        if (s == null) {
            s = SymptomF.getSymptom(symptomName, w); 
            if (s != null) {
                symptoms.put(s, w);
            }
        }
        setChanged();
        notifyObservers();
        return s;
    }

    public Symptom removeSymptomByName(String symptomName) {
        Symptom s = getSymptomByName(symptomName);
        System.out.println("Symptom to remove: " + s);
        if (s != null) {
        	symptoms.remove(s);
        	setChanged();
        	notifyObservers();
        }
        
        return s;
    }

    public Iterator iterator() {
        return new Covid19PacientIterator(this.symptoms.keySet());
    }

    public double covidImpact() {
        double afection = 0;
        double increment = 0;
        double impact = 0;

        for (Symptom c : symptoms.keySet()) {
            if (c != null)
                afection = afection + c.getSeverityIndex() * symptoms.get(c);
        }
        afection = afection / symptoms.size();

        if (getAge() > 65) increment = afection * 0.5;

        impact = afection + increment;
        return impact;
    }
}
