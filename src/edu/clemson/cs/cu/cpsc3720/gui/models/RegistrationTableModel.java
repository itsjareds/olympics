package edu.clemson.cs.cu.cpsc3720.gui.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import edu.clemson.cs.cu.cpsc3720.main.Registration;

public class RegistrationTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 8113600134820832784L;
	private List<Registration> regs = new ArrayList<>();
	String[] colNames = { "Event", "Score" };

	public RegistrationTableModel(List<Registration> regs) {
		this.regs = regs;
		update();
	}

	public void setRegistrations(List<Registration> regs) {
		this.regs = regs;
		update();
	}

	public Registration getRegistrition(int row) {
		return regs.get(row);
	}

	public Integer indexOf(Registration r) {
		return regs.indexOf(r);
	}

	public void addRow(final Registration r) {
		regs.add(r);
		update();
	}

	public void deleteRow(int row) {
		regs.remove(row);
		update();
	}

	@Override
	public String getColumnName(final int col) {
		return colNames[col];
	}

	@Override
	public boolean isCellEditable(final int row, final int col) {
		return false;
	}

	@Override
	public int getRowCount() {
		return regs.size();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public Object getValueAt(int row, int col) {
		switch (col) {
		case 0:
			return regs.get(row).getEvent().getEventName();
		case 1:
			return regs.get(row).getScore();
		}
		return null;
	}

	public void update() {
		this.fireTableDataChanged();
	}

}
