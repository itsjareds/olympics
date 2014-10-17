package edu.clemson.cs.cu.cpsc3720.gui.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import edu.clemson.cs.cu.cpsc3720.main.Athlete;

/**
 */
public class ExtendedAthleteTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 8932721969724439783L;
	private List<Athlete> athletes = new ArrayList<>();
	String[] colNames = { "Rank", "Last Name", "First Name", "Age", "Sex",
			"Time", "Group", "Supervisor" };

	/**
	 * Constructor for ExtendedAthleteTableModel.
	 * @param athletes List<Athlete>
	 */
	public ExtendedAthleteTableModel(List<Athlete> athletes) {
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
		return 8;
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
			return row + 1;
		case 1:
			return athletes.get(row).getLastName();
		case 2:
			return athletes.get(row).getFirstName();
		case 3:
			return athletes.get(row).getAge();
		case 4:
			return athletes.get(row).getGender();
		case 5:
			return 0;
		case 6:
			return athletes.get(row).getGroupLeader().getGroupCode() + " "
					+ athletes.get(row).getSchool().getSchoolName();
		case 7:
			return athletes.get(row).getGroupLeader().getFirstName() + " "
					+ athletes.get(row).getGroupLeader().getLastName();
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

	public void update() {
		fireTableDataChanged();
	}

}
