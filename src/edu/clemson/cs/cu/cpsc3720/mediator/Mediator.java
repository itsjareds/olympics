package edu.clemson.cs.cu.cpsc3720.mediator;

import java.awt.event.ActionEvent;

import javax.swing.JDialog;
import javax.swing.JPanel;

import edu.clemson.cs.cu.cpsc3720.controllers.MaintainAthleteController;
import edu.clemson.cs.cu.cpsc3720.controllers.MaintainEventController;
import edu.clemson.cs.cu.cpsc3720.controllers.MaintainHeatController;
import edu.clemson.cs.cu.cpsc3720.controllers.RegisterAthleteController;
import edu.clemson.cs.cu.cpsc3720.gui.AthletePnl;
import edu.clemson.cs.cu.cpsc3720.gui.EventsPnl;
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
import edu.clemson.cs.cu.cpsc3720.main.Athlete;
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
	private AddButton addButton;
	private RemoveButton removeButton;
	private ClearButton clearButton;

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
		dialog.dispose();
	}

	@Override
	public void registerNew(NewButton newButton) {
		this.newButton = newButton;
	}

	@Override
	public void newItem(ActionEvent arg0, JPanel panel) {
		if (panel.getName().equals("AthletePanel")) {
			AthletePnl apl = (AthletePnl) panel;
			apl.clearPanel();
		} else if (panel.getName().equals("EventPanel")) {
			EventsPnl epl = (EventsPnl) panel;
			epl.setEvent(null);
		}
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
		if (panel.getName().equals("AthletePanel")) {
			MaintainAthleteController mac = new MaintainAthleteController();
			AthletePnl apl = (AthletePnl) panel;
			mac.deleteAthlete(apl.getAthlete());
			apl.updateTables();
			apl.clearPanel();
		} else if (panel.getName().equals("EventPanel")) {
			MaintainEventController mec = new MaintainEventController();
			EventsPnl epl = (EventsPnl) panel;
			mec.deleteEvent(epl.getEvent());
			epl.getEventTableModel().update();
			epl.setEvent(null);
		}
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
		if (panel.getName().equals("AthletePanel")) {

			MaintainAthleteController mac = new MaintainAthleteController();
			AthletePnl apl = (AthletePnl) panel;
			Athlete a = apl.getAthlete();

			if (a.getFirstName().trim().length() > 0
					&& a.getFirstName().trim().length() > 0
					&& a.getGender().trim().length() >= 1
					&& a.getAge().toString().length() >= 1
					&& a.getSchoolRef().trim().length() >= 1
					&& a.getTeacherRef().trim().length() >= 1
					&& a.getRegRefs().size() <= 2) {

				mac.saveAthlete(apl.getAthlete());
				apl.updateTables();
				apl.clearPanel();
			}

		} else if (panel.getName().equals("EventPanel")) {
			MaintainEventController mec = new MaintainEventController();
			EventsPnl epl = (EventsPnl) panel;
			mec.saveEvent(epl.getEvent());
			epl.getEventTableModel().update();
			epl.setEvent(null);

		}
	}

	@Override
	public void registerAthlete(ActionEvent e, JPanel panel) {
		AthletePnl apl = (AthletePnl) panel;
		RegisterAthleteController rac = new RegisterAthleteController();
		rac.saveRegistration(apl.getRegistration());

	}

	@Override
	public void unregisterAthlete(ActionEvent e, JPanel panel) {
		AthletePnl apl = (AthletePnl) panel;

	}

	@Override
	public void add(ActionEvent arg0, JPanel panel) {
		if (panel.getName().equals("EventPanel")) {
			MaintainHeatController mhc = new MaintainHeatController();
			EventsPnl epl = (EventsPnl) panel;
			mhc.addHeat(epl.getHeat());
			epl.loadHeats(epl.getEvent());
			epl.setHeat(null);
		}
		System.out.println(panel.getName());
	}

	@Override
	public void remove(ActionEvent arg0, JPanel panel) {
		if (panel.getName().equals("EventPanel")) {
			MaintainHeatController mhc = new MaintainHeatController();
			EventsPnl epl = (EventsPnl) panel;
			mhc.removeHeat(epl.getHeat());
			epl.loadHeats(epl.getEvent());
			epl.setHeat(null);
		}
		System.out.println(panel.getName());
	}

	@Override
	public void registerAdd(AddButton addButton) {
		this.addButton = addButton;
	}

	@Override
	public void registerRemove(RemoveButton removeButton) {
		this.removeButton = removeButton;
	}

	@Override
	public void clear(ActionEvent arg0, JPanel panel) {
		if (panel.getName().equals("EventPanel")) {
			EventsPnl epl = (EventsPnl) panel;
			epl.setHeat(null);
		}
		System.out.println(panel.getName());
	}

	@Override
	public void registerClear(ClearButton clearButton) {
		this.clearButton = clearButton;
	}
}
