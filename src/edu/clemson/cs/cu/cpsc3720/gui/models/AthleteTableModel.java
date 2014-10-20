package edu.clemson.cs.cu.cpsc3720.gui.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import edu.clemson.cs.cu.cpsc3720.main.Athlete;

/**
 * <h1>Athlete Table Model</h1>
 * <p>
 * Table Model to be implemented by the JTable class. This model displays a list
 * of athletes by last and first name.
 * @author bbest
 * @author shiz
 * @author klinge2
 * @version $Revision: 1.0 $
 * @since 10/20/2014
 */
public class AthleteTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 8932721969724439783L;
	private List<Athlete> athletes = new ArrayList<>();
	String[] colNames = { "Last Name", "First Name" };

	/**
	 * Constructor for AthleteTableModel.
	 * @param athletes List<Athlete>
	 */
	public AthleteTableModel(List<Athlete> athletes) {
		this.athletes = athletes;
		update();
	}

	/**
	 * Method setAthletes.
	 * @param athletes List<Athlete>
	 */
	public void setAthletes(List<Athlete> athletes) {
		this.athletes = athletes;
		update();
	}

	/**
	 * Method getAthlete.
	 * @param row int
	 * @return Athlete
	 */
	public Athlete getAthlete(int row) {
		return athletes.get(row);
	}

	/**
	 * Method addRow.
	 * @param a Athlete
	 */
	public void addRow(final Athlete a) {
		athletes.add(a);
		update();
	}

	/**
	 * Method deleteRow.
	 * @param row int
	 */
	public void deleteRow(final int row) {
		athletes.remove(row);
		update();
	}

	/**
	 * Method getColumnCount.
	 * @return int
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		return 2;
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
		return athletes.size();
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
			return athletes.get(row).getLastName();
		case 1:
			return athletes.get(row).getFirstName();
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
		Collections.sort(athletes);
		fireTableDataChanged();
	}

}
