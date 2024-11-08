package adapter2;

import java.util.Iterator;
import java.util.Set;

import javax.swing.table.AbstractTableModel;

import domain.Covid19Pacient;
import domain.Symptom;

public class Covid19PacientTableModelAdapter extends AbstractTableModel {
	  protected Covid19Pacient pacient;
	  protected String[] columnNames =
	    new String[] {"Symptom", "Weight" };

	  public Covid19PacientTableModelAdapter(Covid19Pacient p) {
	    this.pacient=p;
	  }

	  public int getColumnCount() {
		  return columnNames.length;
	  }

	  public String getColumnName(int i) {
		  return columnNames[i];
	  }

	  public int getRowCount() {
		  return pacient.getSymptoms().size();
	  }

	  public Object getValueAt(int row, int col) {
		  Iterator <Symptom> it= pacient.getSymptoms().iterator();
		  Set<Symptom> symptomsSet = pacient.getSymptoms();
		  Symptom symptom= null;
		  for(int i= 0; i <= row && it.hasNext(); i++) {
			  symptom = it.next();
		  }
		  if (symptom != null) {
		        if (col == 0) {
		            return symptom.getName();
		        } else {
		            return pacient.getWeight(symptom);
		        }
		    }

		    return null;
	  }
	}
