package iterator;

import java.util.List;
import java.util.Set;
import java.util.Vector;
import adapter.InvertedIterator;
import domain.Symptom;

public class Covid19PacientAdapter implements InvertedIterator {
    private List<Symptom> symptoms;
    private int position;

    public Covid19PacientAdapter(Set<Symptom> symptomSet) {
        this.symptoms = new Vector<>(symptomSet);
        this.position = symptoms.size();
    }

    @Override
    public Symptom previous() {
        if (!hasPrevious()) {
            throw new IndexOutOfBoundsException("No hay elementos anteriores");
        }
        position--;
        return symptoms.get(position);
    }

    @Override
    public boolean hasPrevious() {
        return position > 0;
    }

    @Override
    public void goLast() {
        this.position = symptoms.size();
    }

    public boolean hasNext() {
        return position < symptoms.size();
    }

    public Symptom next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException("No hay elementos siguientes");
        }
        return symptoms.get(position++);
    }
}
