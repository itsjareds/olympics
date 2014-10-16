package edu.clemson.cs.cu.cpsc3720.mediator;

import java.awt.event.ActionEvent;

import javax.swing.JDialog;
import javax.swing.JPanel;

import edu.clemson.cs.cu.cpsc3720.controllers.MaintainAthleteController;
import edu.clemson.cs.cu.cpsc3720.controllers.MaintainEventController;
import edu.clemson.cs.cu.cpsc3720.gui.EventsPnl;
import edu.clemson.cs.cu.cpsc3720.gui.components.CancelButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.DeleteButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.NewButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.RegisterButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.SaveButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.SearchButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.UnregisterButton;
import edu.clemson.cs.cu.cpsc3720.main.interfaces.MediatorInterface;

/**
 * <h1>Mediator</h1>
 * <p>
 * The Mediator class implements the MediatorInterface and executes the various
 * actions assigned to its respective button.
 * 
 * @author Darrell Best - bbest
 * @version 1.0
 * @since 2014-09-22
 */
public class Mediator implements MediatorInterface {

	private CancelButton cancelButton;
	private NewButton newButton;
	private DeleteButton deleteButton;
	private SearchButton searchButton;
	private SaveButton saveButton;
	private UnregisterButton unregisterButton;
	private RegisterButton registerButton;

	/**
	 * This method stores an instance of the static class
	 * {@link edu.clemson.cs.cu.cpsc3720.gui.components.CancelButton
	 * CancelButton} so action can be executed.
	 * 
	 * @param cancelButton
	 */
	@Override
	public void registerCancel(CancelButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	/**
	 * This method gives the cancel button functionality to close the selected
	 * window.
	 * 
	 * @param arg0
	 *            {@link java.awt.event.ActionEvent ActionEvent}
	 * @param dialog
	 *            - JDialog
	 */
	@Override
	public void cancel(ActionEvent arg0, JDialog dialog) {
		cancelButton.setEnabled(true);
		dialog.dispose();
	}

	@Override
	public void registerNew(NewButton newButton) {
		this.newButton = newButton;
	}

	@Override
	public void newItem(ActionEvent arg0, JPanel panel) {
		this.newButton.setEnabled(true);
		if (panel.getName().equals("AthletePanel")) {
			MaintainAthleteController mac = new MaintainAthleteController();
		} else if (panel.getName().equals("EventPanel")) {
			EventsPnl epl = (EventsPnl) panel;
			epl.setEvent(null);
		} else if (panel.getName().equals("HeatPanel")) {
			// MaintainHeatController mhc = new MaintainHeatController();
			// Heat h = new Heat();
			// mhc.createHeat(h);
		}
		System.out.println(panel.getName());
	}

	@Override
	public void registerUnregister(UnregisterButton unregisterButton) {
		this.unregisterButton = unregisterButton;

	}

	@Override
	public void registerRegister(RegisterButton registerButton) {
		this.registerButton = registerButton;
	}

	@Override
	public void registerDelete(DeleteButton deleteButton) {
		this.deleteButton = deleteButton;
	}

	@Override
	public void delete(ActionEvent arg0, JPanel panel) {
		this.deleteButton.setEnabled(true);
		if (panel.getName().equals("AthletePanel")) {
			MaintainAthleteController mac = new MaintainAthleteController();
		} else if (panel.getName().equals("EventPanel")) {
			MaintainEventController mec = new MaintainEventController();
			EventsPnl epl = (EventsPnl) panel;
			mec.deleteEvent(epl.getEvent());
			epl.updateTable();
			epl.setEvent(null);
		} else if (panel.getName().equals("HeatPanel")) {
			// MaintainHeatController mhc = new MaintainHeatController();
			// Heat h = new Heat();
			// mhc.createHeat(h);
		}
		System.out.println(panel.getName());
	}

	@Override
	public void registerSearch(SearchButton searchButton) {
		this.searchButton = searchButton;
	}

	@Override
	public void search(ActionEvent arg0, JPanel panel) {
		this.searchButton.setEnabled(true);
	}

	@Override
	public void registerSave(SaveButton saveButton) {
		this.saveButton = saveButton;
	}

	@Override
	public void save(ActionEvent arg0, JPanel panel) {
		saveButton.setVisible(true);
		if (panel.getName().equals("AthletePanel")) {
			MaintainAthleteController mac = new MaintainAthleteController();
			mac.saveAthlete(panel);
		} else if (panel.getName().equals("EventPanel")) {
			MaintainEventController mec = new MaintainEventController();
			EventsPnl epl = (EventsPnl) panel;
			mec.saveEvent(epl.getEvent());
			epl.updateTable();
			epl.setEvent(null);
		} else if (panel.getName().equals("HeatPanel")) {
			// MaintainHeatController mhc = new MaintainHeatController();
			// Heat h = new Heat();
			// mhc.createHeat(h);
		}
		System.out.println(panel.getName());
	}

	@Override
	public void registerAthlete(ActionEvent e, JPanel thisPanel) {

	}

	@Override
	public void unregisterAthlete(ActionEvent e, JPanel thisPanel) {

	}
}
