package iterator;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import adapter.InvertedIterator;
import domain.Symptom;

public class Covid19PacientAdapter implements InvertedIterator{
	private Covid19PacientIterator normalIterator;
	List<Symptom> symptoms;
	int position=0;

	public Covid19PacientAdapter(Set<Symptom> symptomSet) {
        this.symptoms = new Vector<>(symptomSet); // Crea una lista a partir del conjunto
        this.normalIterator = new Covid19PacientIterator(symptomSet);
        this.position = symptoms.size(); // Inicializa en la posición final
    }

	@Override
    public Object previous() {
        Symptom symptom = symptoms.get(position);
        position--;
        return symptom;
    }

    @Override
    public boolean hasPrevious() {
        return position >= 0;
    }

    @Override
    public void goLast() {
        this.position = symptoms.size() - 1;
    }

}
