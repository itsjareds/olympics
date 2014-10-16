package edu.clemson.cs.cu.cpsc3720.gui.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import edu.clemson.cs.cu.cpsc3720.main.Heat;

public class HeatTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 8932721969724439783L;
	private List<Heat> heats = new ArrayList<>();
	String[] colNames = { "Minimum Age", "Maximum Age", "Gender", "Time",
			"Division" };

	public HeatTableModel(List<Heat> heats) {
		this.heats = heats;
		update();
	}

	public void setHeats(List<Heat> heats) {
		this.heats = heats;
		update();
	}

	public void addRow(final Heat a) {
		heats.add(a);
		update();
	}

	public void deleteRow(final int row) {
		heats.remove(row);
		update();
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public String getColumnName(final int col) {
		return colNames[col];
	}

	@Override
	public int getRowCount() {
		return heats.size();
	}

	@Override
	public Object getValueAt(final int row, final int col) {
		switch (col) {
		case 0:
			return heats.get(row).getMinAge();
		case 1:
			return heats.get(row).getMaxAge();
		case 2:
			return heats.get(row).getGender();
		case 3:
			return heats.get(row).getTime();
		case 4:
			return heats.get(row).getNumHeats();
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
