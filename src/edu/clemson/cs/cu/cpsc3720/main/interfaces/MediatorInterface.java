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

	public void add(ActionEvent arg0, JPanel panel);

	public void remove(ActionEvent arg0, JPanel panel);

	public void clear(ActionEvent arg0, JPanel panel);

	public void registerUnregister(UnregisterButton unregisterButton);

	public void registerRegister(RegisterButton registerButton);

	public void registerAthlete(ActionEvent e, JPanel thisPanel);

	public void unregisterAthlete(ActionEvent e, JPanel thisPanel);

	public void registerAdd(AddButton addButton);

	public void registerRemove(RemoveButton removeButton);

	public void registerClear(ClearButton clearButton);

}
