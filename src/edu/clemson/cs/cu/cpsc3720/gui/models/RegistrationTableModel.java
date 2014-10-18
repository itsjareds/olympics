package edu.clemson.cs.cu.cpsc3720.gui.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import edu.clemson.cs.cu.cpsc3720.main.Registration;

/**
 */
public class RegistrationTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 8113600134820832784L;
	private List<Registration> regs = new ArrayList<>();
	String[] colNames = { "Event", "Score" };

	/**
	 * Constructor for RegistrationTableModel.
	 * @param regs List<Registration>
	 */
	public RegistrationTableModel(List<Registration> regs) {
		this.regs = regs;
		update();
	}

	/**
	 * Method setRegistrations.
	 * @param regs List<Registration>
	 */
	public void setRegistrations(List<Registration> regs) {
		this.regs = regs;
		update();
	}

	/**
	 * Method getRegistrition.
	 * @param row int
	 * @return Registration
	 */
	public Registration getRegistration(int row) {
		return regs.get(row);
	}

	/**
	 * Method indexOf.
	 * @param r Registration
	 * @return Integer
	 */
	public Integer indexOf(Registration r) {
		return regs.indexOf(r);
	}

	/**
	 * Method addRow.
	 * @param r Registration
	 */
	public void addRow(final Registration r) {
		regs.add(r);
		update();
	}

	/**
	 * Method deleteRow.
	 * @param row int
	 */
	public void deleteRow(int row) {
		regs.remove(row);
		update();
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
	 * Method getRowCount.
	 * @return int
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		return regs.size();
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
	 * Method getValueAt.
	 * @param row int
	 * @param col int
	 * @return Object
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
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
