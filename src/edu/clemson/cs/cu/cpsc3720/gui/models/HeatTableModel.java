package edu.clemson.cs.cu.cpsc3720.gui.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import edu.clemson.cs.cu.cpsc3720.main.Heat;

/**
 * <h1>Heat Table Model</h1>
 * <p>
 * Table Model to be implemented by the JTable class. This model displays a list
 * of heats by age, gender, time, and division.
 * @author bbest
 * @author shiz
 * @author klinge2
 * @version $Revision: 1.0 $
 * @since 10/20/2014
 */
public class HeatTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 8932721969724439783L;
	private List<Heat> heats = new ArrayList<>();
	String[] colNames = { "Min Age", "Max Age", "Gender", "Time", "Division" };

	/**
	 * Constructor for HeatTableModel.
	 * @param heats List<Heat>
	 */
	public HeatTableModel(List<Heat> heats) {
		this.heats = heats;
		update();
	}

	/**
	 * Method setHeats.
	 * @param heats List<Heat>
	 */
	public void setHeats(List<Heat> heats) {
		this.heats = heats;
		update();
	}

	/**
	 * Method addRow.
	 * @param h Heat
	 */
	public void addRow(final Heat h) {
		heats.add(h);
		update();
	}

	/**
	 * Method deleteRow.
	 * @param row int
	 */
	public void deleteRow(final int row) {
		heats.remove(row);
		update();
	}

	/**
	 * Method deleteHeat.
	 * @param h Heat
	 */
	public void deleteHeat(final Heat h) {
		heats.remove(h);
		update();
	}

	/**
	 * Method getColumnCount.
	 * @return int
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		return 5;
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
		return heats.size();
	}

	/**
	 * Method getHeat.
	 * @param row int
	 * @return Heat
	 */
	public Heat getHeat(int row) {
		return heats.get(row);
	}

	/**
	 * Method indexOf.
	 * @param h Heat
	 * @return Integer
	 */
	public Integer indexOf(Heat h) {
		return heats.indexOf(h);
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
			return heats.get(row).getMinAge();
		case 1:
			return heats.get(row).getMaxAge();
		case 2:
			return heats.get(row).getGender();
		case 3:
			return heats.get(row).getTime();
		case 4:
			return heats.get(row).getDivision();
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
		Collections.sort(heats);
		fireTableDataChanged();
	}

}
