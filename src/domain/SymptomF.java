package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymptomF {
	private static Map<String, Symptom> symptomMap = new HashMap<>();

	public static Symptom getSymptom(String symptomName, int weight) {
        Symptom s = symptomMap.get(symptomName);
        if (s == null) {
            s = createSymptom(symptomName, weight);
            if (s != null) {
                symptomMap.put(symptomName, s);
            }
        }
        return s;
    }
    private static Symptom createSymptom(String symptomName, int weight) {
        List<String> impact5 = Arrays.asList("fiebre", "tos seca", "astenia","expectoracion");
        List<Double> index5 = Arrays.asList(87.9, 67.7, 38.1, 33.4);
        List<String> impact3 = Arrays.asList("disnea", "dolor de garganta", "cefalea","mialgia","escalofrios");
        List<Double> index3 = Arrays.asList(18.6, 13.9, 13.6, 14.8, 11.4);
        List<String> impact1 = Arrays.asList("mareos","nauseas", "vomitos", "congestion nasal","diarrea","hemoptisis","congestion conjuntival");
        List<Double> index1 = Arrays.asList(5.0, 4.8, 3.7, 0.9, 0.8);

        List<String> digestiveSymptom=Arrays.asList("nauseas", "vomitos","diarrea");
        List<String> neuroMuscularSymptom=Arrays.asList("fiebre", "astenia", "cefalea", "mialgia","escalofrios");
        List<String> respiratorySymptom=Arrays.asList("tos seca","expectoracion","disnea","dolor de garganta", "congestion nasal","hemoptisis","congestion conjuntival");
        List<String> movilitySymptom=Arrays.asList("mareos");
        int impact = 0;
        double index = 0;

        if (impact5.contains(symptomName)) { 
            impact = 5; 
            index = index5.get(impact5.indexOf(symptomName));
        } else if (impact3.contains(symptomName)) { 
            impact = 3; 
            index = index3.get(impact3.indexOf(symptomName));
        } else if (impact1.contains(symptomName)) { 
            impact = 1; 
            index = index1.get(impact1.indexOf(symptomName));
        }

        if (impact != 0) {
            if (digestiveSymptom.contains(symptomName)) {
                return new DigestiveSymptom(symptomName, (int)index, impact);
            }
            if (neuroMuscularSymptom.contains(symptomName)) {
                return new NeuroMuscularSymptom(symptomName, (int)index, impact);
            }
            if (respiratorySymptom.contains(symptomName)) {
                return new RespiratorySymptom(symptomName, (int)index, impact);
            }
            if (movilitySymptom.contains(symptomName)) {
                return new RespiratorySymptom(symptomName, (int)index, impact);
            }
        }

        return null;
    }
}