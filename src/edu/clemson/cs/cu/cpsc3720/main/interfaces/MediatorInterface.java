package edu.clemson.cs.cu.cpsc3720.main.interfaces;

import java.awt.event.ActionEvent;

import javax.swing.JDialog;
import javax.swing.JPanel;

import edu.clemson.cs.cu.cpsc3720.gui.components.AddButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.CancelButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.ClearButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.DeleteButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.NewButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.RegisterButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.RemoveButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.SaveButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.SearchButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.UnregisterButton;

/**
 * <h1>Mediator Interface</h1>
 * <p>
 * This interface is the base of the mediator pattern that provides
 * functionality to buttons.
 * @author Darrell Best - bbest
 * @version 1.0
 * @since 2014-09-22
 */
public interface MediatorInterface {

	/**
	 * This method is intended to
	 * @param cancelButton CancelButton
	 */
	public void registerCancel(CancelButton cancelButton);

	/**
	 * Method cancel.
	 * @param arg0 ActionEvent
	 * @param dialog JDialog
	 */
	public void cancel(ActionEvent arg0, JDialog dialog);

	/**
	 * Method registerNew.
	 * @param newButton NewButton
	 */
	public void registerNew(NewButton newButton);

	/**
	 * Method newItem.
	 * @param arg0 ActionEvent
	 * @param panel JPanel
	 */
	public void newItem(ActionEvent arg0, JPanel panel);

	/**
	 * Method registerDelete.
	 * @param deleteButton DeleteButton
	 */
	public void registerDelete(DeleteButton deleteButton);

	/**
	 * Method delete.
	 * @param arg0 ActionEvent
	 * @param panel JPanel
	 */
	public void delete(ActionEvent arg0, JPanel panel);

	/**
	 * Method search.
	 * @param arg0 ActionEvent
	 * @param panel JPanel
	 */
	public void search(ActionEvent arg0, JPanel panel);

	/**
	 * Method registerSearch.
	 * @param searchButton SearchButton
	 */
	public void registerSearch(SearchButton searchButton);

	/**
	 * Method registerSave.
	 * @param saveButton SaveButton
	 */
	public void registerSave(SaveButton saveButton);

	/**
	 * Method save.
	 * @param arg0 ActionEvent
	 * @param panel JPanel
	 */
	public void save(ActionEvent arg0, JPanel panel);

	/**
	 * Method add.
	 * @param arg0 ActionEvent
	 * @param panel JPanel
	 */
	public void add(ActionEvent arg0, JPanel panel);

	/**
	 * Method remove.
	 * @param arg0 ActionEvent
	 * @param panel JPanel
	 */
	public void remove(ActionEvent arg0, JPanel panel);

	/**
	 * Method clear.
	 * @param arg0 ActionEvent
	 * @param panel JPanel
	 */
	public void clear(ActionEvent arg0, JPanel panel);

	/**
	 * Method registerUnregister.
	 * @param unregisterButton UnregisterButton
	 */
	public void registerUnregister(UnregisterButton unregisterButton);

	/**
	 * Method registerRegister.
	 * @param registerButton RegisterButton
	 */
	public void registerRegister(RegisterButton registerButton);

	/**
	 * Method registerAthlete.
	 * @param e ActionEvent
	 * @param thisPanel JPanel
	 */
	public void registerAthlete(ActionEvent e, JPanel thisPanel);

	/**
	 * Method unregisterAthlete.
	 * @param e ActionEvent
	 * @param thisPanel JPanel
	 */
	public void unregisterAthlete(ActionEvent e, JPanel thisPanel);

	/**
	 * Method registerAdd.
	 * @param addButton AddButton
	 */
	public void registerAdd(AddButton addButton);

	/**
	 * Method registerRemove.
	 * @param removeButton RemoveButton
	 */
	public void registerRemove(RemoveButton removeButton);

	/**
	 * Method registerClear.
	 * @param clearButton ClearButton
	 */
	public void registerClear(ClearButton clearButton);

}
