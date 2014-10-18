package edu.clemson.cs.cu.cpsc3720.mediator;

import java.awt.event.ActionEvent;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
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
 * @author Darrell Best - bbest
 * @version 1.0
 * @since 2014-09-22
 */
@SuppressWarnings("unused")
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
	 * @param cancelButton
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.MediatorInterface#registerCancel(CancelButton)
	 */
	@Override
	public void registerCancel(CancelButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	/**
	 * This method gives the cancel button functionality to close the selected
	 * window.
	 * @param arg0 {@link java.awt.event.ActionEvent ActionEvent}
	 * @param dialog - JDialog
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.MediatorInterface#cancel(ActionEvent,
	 *      JDialog)
	 */
	@Override
	public void cancel(ActionEvent arg0, JDialog dialog) {
		dialog.dispose();
	}

	/**
	 * Method registerNew.
	 * @param newButton NewButton
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.MediatorInterface#registerNew(NewButton)
	 */
	@Override
	public void registerNew(NewButton newButton) {
		this.newButton = newButton;
	}

	/**
	 * Method newItem.
	 * @param arg0 ActionEvent
	 * @param panel JPanel
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.MediatorInterface#newItem(ActionEvent,
	 *      JPanel)
	 */
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

	/**
	 * Method registerUnregister.
	 * @param unregisterButton UnregisterButton
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.MediatorInterface#registerUnregister(UnregisterButton)
	 */
	@Override
	public void registerUnregister(UnregisterButton unregisterButton) {
		this.unregisterButton = unregisterButton;

	}

	/**
	 * Method registerRegister.
	 * @param registerButton RegisterButton
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.MediatorInterface#registerRegister(RegisterButton)
	 */
	@Override
	public void registerRegister(RegisterButton registerButton) {
		this.registerButton = registerButton;
	}

	/**
	 * Method registerDelete.
	 * @param deleteButton DeleteButton
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.MediatorInterface#registerDelete(DeleteButton)
	 */
	@Override
	public void registerDelete(DeleteButton deleteButton) {
		this.deleteButton = deleteButton;
	}

	/**
	 * Method delete.
	 * @param arg0 ActionEvent
	 * @param panel JPanel
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.MediatorInterface#delete(ActionEvent,
	 *      JPanel)
	 */
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

	/**
	 * Method registerSearch.
	 * @param searchButton SearchButton
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.MediatorInterface#registerSearch(SearchButton)
	 */
	@Override
	public void registerSearch(SearchButton searchButton) {
		this.searchButton = searchButton;
	}

	/**
	 * Method search.
	 * @param arg0 ActionEvent
	 * @param panel JPanel
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.MediatorInterface#search(ActionEvent,
	 *      JPanel)
	 */
	@Override
	public void search(ActionEvent arg0, JPanel panel) {
		this.searchButton.setEnabled(true);
	}

	/**
	 * Method registerSave.
	 * @param saveButton SaveButton
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.MediatorInterface#registerSave(SaveButton)
	 */
	@Override
	public void registerSave(SaveButton saveButton) {
		this.saveButton = saveButton;
	}

	/**
	 * Method save.
	 * @param arg0 ActionEvent
	 * @param panel JPanel
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.MediatorInterface#save(ActionEvent,
	 *      JPanel)
	 */
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

	/**
	 * Method registerAthlete.
	 * @param e ActionEvent
	 * @param panel JPanel
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.MediatorInterface#registerAthlete(ActionEvent,
	 *      JPanel)
	 */
	@Override
	public void registerAthlete(ActionEvent e, JPanel panel) {
		if (panel.getName().equals("AthletePanel")) {
			RegisterAthleteController rac = new RegisterAthleteController();
			AthletePnl apl = (AthletePnl) panel;
			boolean saved = rac.saveRegistration(apl.getRegistration());
			if (saved) {
				System.out.println("Correctly added athlete "
						+ apl.getAthlete());
				apl.loadRegistrations(apl.getAthlete());
				apl.setRegistration(null);
			} else {
				JOptionPane
						.showMessageDialog(null,
								"Could not add registration. Save your athlete before editing registrations.");
			}
		}
		System.out.println(panel.getName());
	}

	/**
	 * Method unregisterAthlete.
	 * @param e ActionEvent
	 * @param panel JPanel
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.MediatorInterface#unregisterAthlete(ActionEvent,
	 *      JPanel)
	 */
	@Override
	public void unregisterAthlete(ActionEvent e, JPanel panel) {
		if (panel.getName().equals("AthletePanel")) {
			RegisterAthleteController rac = new RegisterAthleteController();
			AthletePnl apl = (AthletePnl) panel;
			rac.deleteRegistration(apl.getRegistration());
			apl.loadRegistrations(apl.getAthlete());
			apl.setRegistration(null);
		}
		System.out.println(panel.getName());
	}

	/**
	 * Method add.
	 * @param arg0 ActionEvent
	 * @param panel JPanel
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.MediatorInterface#add(ActionEvent,
	 *      JPanel)
	 */
	@Override
	public void add(ActionEvent arg0, JPanel panel) {
		if (panel.getName().equals("EventPanel")) {
			MaintainHeatController mhc = new MaintainHeatController();
			EventsPnl epl = (EventsPnl) panel;
			boolean added = mhc.addHeat(epl.getHeat());
			if (added) {
				epl.loadHeats(epl.getEvent());
				epl.setHeat(null);
			} else {
				JOptionPane
						.showMessageDialog(null,
								"Could not add heat. Save your event before editing heats.");
			}
		}
		System.out.println(panel.getName());
	}

	/**
	 * Method remove.
	 * @param arg0 ActionEvent
	 * @param panel JPanel
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.MediatorInterface#remove(ActionEvent,
	 *      JPanel)
	 */
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

	/**
	 * Method registerAdd.
	 * @param addButton AddButton
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.MediatorInterface#registerAdd(AddButton)
	 */
	@Override
	public void registerAdd(AddButton addButton) {
		this.addButton = addButton;
	}

	/**
	 * Method registerRemove.
	 * @param removeButton RemoveButton
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.MediatorInterface#registerRemove(RemoveButton)
	 */
	@Override
	public void registerRemove(RemoveButton removeButton) {
		this.removeButton = removeButton;
	}

	/**
	 * Method clear.
	 * @param arg0 ActionEvent
	 * @param panel JPanel
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.MediatorInterface#clear(ActionEvent,
	 *      JPanel)
	 */
	@Override
	public void clear(ActionEvent arg0, JPanel panel) {
		if (panel.getName().equals("EventPanel")) {
			EventsPnl epl = (EventsPnl) panel;
			epl.setHeat(null);
		}
		System.out.println(panel.getName());
	}

	/**
	 * Method registerClear.
	 * @param clearButton ClearButton
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.MediatorInterface#registerClear(ClearButton)
	 */
	@Override
	public void registerClear(ClearButton clearButton) {
		this.clearButton = clearButton;
	}
}
