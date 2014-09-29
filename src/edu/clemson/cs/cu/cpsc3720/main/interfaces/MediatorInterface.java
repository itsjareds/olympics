package edu.clemson.cs.cu.cpsc3720.main.interfaces;

import java.awt.event.ActionEvent;

import javax.swing.JDialog;
import javax.swing.JPanel;

import edu.clemson.cs.cu.cpsc3720.gui.components.CancelButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.DeleteButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.NewButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.SaveButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.SearchButton;

/**
 * <h1>Mediator Interface</h1>
 * <p>
 * This interface is the base of the mediator pattern that provides
 * functionality to buttons.
 * 
 * @author Darrell Best - bbest
 * @version 1.0
 * @since 2014-09-22
 */
public interface MediatorInterface {

	/**
	 * This method is intended to
	 * 
	 * @param arg0
	 *            - {@link java.awt.event.ActionEvent Action Event}
	 */
	public void registerCancel(CancelButton cancelButton);

	public void cancel(ActionEvent arg0, JDialog dialog);

	public void registerNew(NewButton newButton);

	public void newItem(ActionEvent arg0, JPanel panel);

	public void registerDelete(DeleteButton deleteButton);

	public void delete(ActionEvent arg0, JPanel panel);

	public void search(ActionEvent arg0, JPanel panel);

	public void registerSearch(SearchButton searchButton);

	public void registerSave(SaveButton saveButton);

	public void save(ActionEvent arg0, JPanel panel);
}
