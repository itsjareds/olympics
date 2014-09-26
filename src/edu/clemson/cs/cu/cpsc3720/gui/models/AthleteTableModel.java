package edu.clemson.cs.cu.cpsc3720.gui.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import edu.clemson.cs.cu.cpsc3720.main.Athlete;

public class AthleteTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 8932721969724439783L;
	private List<Athlete> athletes = new ArrayList<>();
	String[] colNames = { "First Name", "Last Name" };

	public AthleteTableModel(List<Athlete> athletes) {
		this.athletes = athletes;
		update();
	}

	public void addRow(final Athlete a) {
		athletes.add(a);
		update();
	}

	public void deleteRow(final int row) {
		athletes.remove(row);
		update();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public String getColumnName(final int col) {
		return colNames[col];
	}

	@Override
	public int getRowCount() {
		return athletes.size();
	}

	@Override
	public Object getValueAt(final int row, final int col) {
		switch (col) {
		case 0:
			return athletes.get(row).getFirstName();
		case 1:
			return athletes.get(row).getLastName();
		default:
			return null;
		}
	}

	@Override
	public boolean isCellEditable(final int row, final int col) {
		return false;
	}

	public void setColumns(final String[] colNames) {
		this.colNames = colNames;
	}

	public void update() {
		fireTableDataChanged();
	}

}
