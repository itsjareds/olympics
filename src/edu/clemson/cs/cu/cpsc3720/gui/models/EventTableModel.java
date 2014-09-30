package edu.clemson.cs.cu.cpsc3720.gui.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import edu.clemson.cs.cu.cpsc3720.main.Event;

public class EventTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 8932721969724439783L;
	private List<Event> events = new ArrayList<>();
	String[] colNames = { "Event Code", "Event Name" };

	public EventTableModel(List<Event> events) {
		this.events = events;
		update();
	}

	public Event getEvent(int row) {
		return events.get(row);
	}

	public void addRow(final Event a) {
		events.add(a);
		update();
	}

	public void deleteRow(final int row) {
		events.remove(row);
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
		return events.size();
	}

	@Override
	public Object getValueAt(final int row, final int col) {
		switch (col) {
		case 0:
			return events.get(row).getEventCode();
		case 1:
			return events.get(row).getEventName();
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
