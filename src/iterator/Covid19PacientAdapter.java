package iterator;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import adapter.InvertedIterator;
import domain.Symptom;

public class Covid19PacientAdapter implements Iterator<Symptom>, InvertedIterator{
	List<Symptom> symptoms=new Vector<Symptom>();
	int position=0;

	public Covid19PacientAdapter(Set<Symptom> symptomSet) {
        this.symptoms.addAll(symptomSet);
        this.goLast();
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

	@Override
	public boolean hasNext() {
		return position < symptoms.size();
	}

	@Override
	public Symptom next() {
		Symptom symptom = symptoms.get(position);
        position++;
        return symptom;
	}

}
