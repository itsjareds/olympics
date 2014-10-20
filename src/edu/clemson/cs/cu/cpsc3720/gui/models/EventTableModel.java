package edu.clemson.cs.cu.cpsc3720.gui.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import edu.clemson.cs.cu.cpsc3720.main.Event;

/**
 * <h1>Event Table Model</h1>
 * <p>
 * Table Model to be implemented by the JTable class. This model displays a list
 * of Events by code, name, and score unit.
 * @author bbest
 * @author shiz
 * @author klinge2
 * @version $Revision: 1.0 $
 * @since 10/20/2014
 */
public class EventTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 8932721969724439783L;
	private List<Event> events = new ArrayList<>();
	String[] colNames = { "Code", "Event Name", "Score Unit" };

	/**
	 * Constructor for EventTableModel.
	 * @param events List<Event>
	 */
	public EventTableModel(List<Event> events) {
		this.events = events;
		update();
	}

	/**
	 * Method setEvents.
	 * @param events List<Event>
	 */
	public void setEvents(List<Event> events) {
		this.events = events;
		update();
	}

	/**
	 * Method getEvent.
	 * @param row int
	 * @return Event
	 */
	public Event getEvent(int row) {
		return events.get(row);
	}

	/**
	 * Method indexOf.
	 * @param e Event
	 * @return Integer
	 */
	public Integer indexOf(Event e) {
		return events.indexOf(e);
	}

	/**
	 * Method addRow.
	 * @param a Event
	 */
	public void addRow(final Event a) {
		events.add(a);
		update();
	}

	/**
	 * Method deleteRow.
	 * @param row int
	 */
	public void deleteRow(final int row) {
		events.remove(row);
		update();
	}

	/**
	 * Method getColumnCount.
	 * @return int
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		return 3;
	}

	/**
	 * Method getColumnName.
	 * @param col int
	 * @return String
	 * @see javax.swing.table.TableModel#getColumnName(int)
	 */
	@Override
	public String getColumnName(final int col) {
		return colNames[col];
	}

	/**
	 * Method getRowCount.
	 * @return int
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		return events.size();
	}

	/**
	 * Method getValueAt.
	 * @param row int
	 * @param col int
	 * @return Object
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(final int row, final int col) {
		switch (col) {
		case 0:
			return events.get(row).getEventCode();
		case 1:
			return events.get(row).getEventName();
		case 2:
			return events.get(row).getScoreUnit();
		default:
			return null;
		}
	}

	/**
	 * Method isCellEditable.
	 * @param row int
	 * @param col int
	 * @return boolean
	 * @see javax.swing.table.TableModel#isCellEditable(int, int)
	 */
	@Override
	public boolean isCellEditable(final int row, final int col) {
		return false;
	}

	/**
	 * Method setColumns.
	 * @param colNames String[]
	 */
	public void setColumns(final String[] colNames) {
		this.colNames = colNames;
	}

	/**
	 * Method update sorts the list and updates the table.
	 */
	public void update() {
		Collections.sort(events);
		fireTableDataChanged();
	}

}
