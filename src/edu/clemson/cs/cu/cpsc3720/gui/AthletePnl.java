package edu.clemson.cs.cu.cpsc3720.gui;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.databaseaccess.DatabaseAccessObject;
import edu.clemson.cs.cu.cpsc3720.gui.components.ClearButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.DeleteButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.NewButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.RegisterButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.SaveButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.UnregisterButton;
import edu.clemson.cs.cu.cpsc3720.gui.models.AthleteTableModel;
import edu.clemson.cs.cu.cpsc3720.gui.models.RegistrationTableModel;
import edu.clemson.cs.cu.cpsc3720.main.Athlete;
import edu.clemson.cs.cu.cpsc3720.main.Event;
import edu.clemson.cs.cu.cpsc3720.main.Registration;
import edu.clemson.cs.cu.cpsc3720.main.School;
import edu.clemson.cs.cu.cpsc3720.main.Teacher;
import edu.clemson.cs.cu.cpsc3720.main.interfaces.AdminPanelInterface;
import edu.clemson.cs.cu.cpsc3720.mediator.Mediator;
import edu.clemson.cs.cu.cpsc3720.mediator.MediatorActionListener;

/**
 * <h1>Athlete Panel</h1>
 * <p>
 * Responsible for maintaining Athletes and their registrations for events.
 * @author bbest
 * @author shiz
 * @author klinge2
 * @version $Revision: 1.0 $
 */
public class AthletePnl extends JPanel implements AdminPanelInterface {
	private static final long serialVersionUID = -3647303070052872171L;
	private static AthleteTableModel athleteTableModel;
	private static RegistrationTableModel registrationTableModel;
	private final JTextField athleteFirstNameTextBox;
	private final JTextField athleteLastNameTxtBox;
	private final ArrayList<Athlete> athletes;
	private ArrayList<Event> events;
	private final JTable registrationTable;
	private final Mediator mediator;
	private final JTable athleteTable;
	private double dividerLocation;
	private JComboBox<Integer> ageComboBox;
	private JComboBox<String> genderComboBox;
	private JComboBox<Teacher> groupLeaderComboBox;
	private JComboBox<Event> eventComboBox;
	private JComboBox<Integer> inchComboBox;
	private JComboBox<Integer> feetComboBox;
	private JComboBox<Integer> minComboBox;
	private JComboBox<Integer> secComboBox;
	private JComboBox<String> schoolGroupCodeComboBox;
	private JComboBox<School> schoolNameComboBox;
	private RegisterButton btnRegister;
	private UnregisterButton btnUnregister;
	private NewButton newBtn;
	private DeleteButton deleteBtn;
	private SaveButton saveBtn;
	private JSplitPane splitPane;
	private JScrollPane athleteScrollPane;
	private JScrollPane informationScrollPane;
	private JPanel panel;
	private JScrollPane eventsScrollPane;
	private JScrollPane heatsScrollPane;
	private ArrayList<Teacher> teacherList;
	private ArrayList<School> schoolList;
	private ArrayList<Event> eventList;
	private ArrayList<Registration> associatedRegistrations;
	private Athlete loadedAthlete;
	private ClearButton clearButton;

	/**
	 * Create the panel.
	 * @param mediator Mediator
	 */
	public AthletePnl(final Mediator mediator) {

		this.mediator = mediator;
		this.setName("AthletePanel");

		// ---------- Start Init --------------- //
		{
			athletes = DaoRepository.getAthletesDao().objects;
			events = DaoRepository.getEventsDao().objects;

			Collections.sort(athletes);
			athleteTableModel = new AthleteTableModel(athletes);
			registrationTableModel = new RegistrationTableModel(
					new ArrayList<Registration>());

		}
		// ------------ End Init ------------- //

		// --------- Start Panes and Panels --------- //
		{
			splitPane = new JSplitPane();
			splitPane.setDividerSize(1);
			dividerLocation = 0.8;
			splitPane.setDividerLocation(250);
			{
				athleteScrollPane = new JScrollPane();
				splitPane.setLeftComponent(athleteScrollPane);

				informationScrollPane = new JScrollPane();
				splitPane.setRightComponent(informationScrollPane);
			}

			panel = new JPanel();
			informationScrollPane.setViewportView(panel);
			panel.setLayout(null);
			{
				eventsScrollPane = new JScrollPane();
				eventsScrollPane.setBounds(361, 194, 309, 200);
				panel.add(eventsScrollPane);
			}
		}
		// --------- End Panes and Panels ----------- //

		// ----------- Start Text Boxes ------------ //
		{
			athleteFirstNameTextBox = new JTextField();
			athleteFirstNameTextBox.setBounds(16, 50, 291, 28);
			panel.add(athleteFirstNameTextBox);
			athleteFirstNameTextBox.setColumns(10);

			athleteLastNameTxtBox = new JTextField();
			athleteLastNameTxtBox.setColumns(10);
			athleteLastNameTxtBox.setBounds(16, 90, 291, 28);
			panel.add(athleteLastNameTxtBox);
		}
		// ------- End Text Boxes ------------- //

		// --------- Start Tables ------------ //
		{
			athleteTable = new JTable(athleteTableModel);
			athleteTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			athleteScrollPane.setViewportView(athleteTable);
			athleteTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			TableColumnAdjuster athleteTca = new TableColumnAdjuster(
					athleteTable);
			athleteTca.setDynamicAdjustment(true);
			athleteTca.adjustColumns();

			registrationTable = new JTable(AthletePnl.registrationTableModel);
			eventsScrollPane.setViewportView(registrationTable);
			TableColumnAdjuster regTca = new TableColumnAdjuster(
					registrationTable);
			regTca.setDynamicAdjustment(true);
			regTca.adjustColumns();

		}
		// --------- End Tables --------------- //

		// --------- Start Lables ------------ //
		{
			final JLabel lblFirstName = new JLabel("First Name");
			lblFirstName.setBounds(16, 34, 291, 16);
			panel.add(lblFirstName);

			final JLabel lblLastName = new JLabel("Last Name");
			lblLastName.setBounds(16, 75, 291, 16);
			panel.add(lblLastName);

			final JLabel lblSchoolName = new JLabel("School Name");
			lblSchoolName.setBounds(16, 262, 291, 16);
			panel.add(lblSchoolName);

			final JLabel lblGroupLeader = new JLabel("Group Leader");
			lblGroupLeader.setBounds(17, 302, 291, 16);
			panel.add(lblGroupLeader);

			final JLabel lblNewLabel = new JLabel("Athlete Information");
			lblNewLabel.setFont(new Font("Lucido Grande", Font.BOLD, 13));
			lblNewLabel.setBounds(56, 6, 251, 16);
			panel.add(lblNewLabel);

			final JLabel lblSchoolGroupCode = new JLabel("School / Group Code");
			lblSchoolGroupCode.setBounds(16, 345, 291, 16);
			panel.add(lblSchoolGroupCode);

			final JLabel lblAge = new JLabel("Age");
			lblAge.setBounds(16, 140, 85, 22);
			panel.add(lblAge);

			final JLabel lblGender = new JLabel("Gender");
			lblGender.setBounds(16, 168, 85, 16);
			panel.add(lblGender);

			final JLabel lblScore = new JLabel("Qualifing Score");
			lblScore.setBounds(361, 70, 117, 16);
			panel.add(lblScore);

			final JLabel lblAssociatedEvents = new JLabel("Registered Events");
			lblAssociatedEvents.setBounds(438, 170, 173, 16);
			lblAssociatedEvents
					.setFont(new Font("Lucido Grande", Font.BOLD, 13));
			panel.add(lblAssociatedEvents);

			final JLabel lblTeacherInformation = new JLabel(
					"Teacher Information");
			lblTeacherInformation.setBounds(56, 233, 251, 16);
			lblTeacherInformation.setFont(new Font("Lucido Grande", Font.BOLD,
					13));
			panel.add(lblTeacherInformation);

			final JLabel lblEvents = new JLabel("Add Event");
			lblEvents.setBounds(361, 38, 82, 16);
			panel.add(lblEvents);

			final JLabel lblFt = new JLabel("ft.");
			lblFt.setBounds(467, 70, 50, 16);
			panel.add(lblFt);

			final JLabel lblIn = new JLabel("In.");
			lblIn.setBounds(571, 70, 61, 16);
			panel.add(lblIn);

			final JLabel lblMin = new JLabel("min");
			lblMin.setBounds(467, 98, 61, 16);
			panel.add(lblMin);

			final JLabel lblSec = new JLabel("sec");
			lblSec.setBounds(571, 98, 50, 16);
			panel.add(lblSec);

			final JLabel lblRegisterForEvent = new JLabel("Register for Event");
			lblRegisterForEvent.setBounds(438, 6, 146, 16);
			lblRegisterForEvent
					.setFont(new Font("Lucido Grande", Font.BOLD, 13));
			panel.add(lblRegisterForEvent);

		}
		// --------- End Labels ------------ //

		// ------- Start Combo Boxes -------- //
		{

			// gender combo box
			String[] genders = { "", "Male", "Female" };
			genderComboBox = new JComboBox<String>();
			for (String gender : genders)
				genderComboBox.addItem(gender);
			genderComboBox.setBounds(66, 165, 98, 27);
			panel.add(genderComboBox);

			minComboBox = new JComboBox<Integer>();
			minComboBox.setBounds(490, 94, 80, 27);
			panel.add(minComboBox);
			minComboBox.setEnabled(false);

			secComboBox = new JComboBox<Integer>();
			secComboBox.setBounds(594, 94, 80, 27);
			panel.add(secComboBox);
			secComboBox.setEnabled(false);

			inchComboBox = new JComboBox<Integer>();
			inchComboBox.setBounds(594, 66, 80, 27);
			panel.add(inchComboBox);
			inchComboBox.setEnabled(false);

			feetComboBox = new JComboBox<Integer>();
			feetComboBox.setBounds(490, 66, 80, 27);
			panel.add(feetComboBox);
			feetComboBox.setEnabled(false);

			// events combo box
			eventList = new ArrayList<Event>();
			eventList.add(new Event("", "", "", 0, 0, 0));
			eventList.addAll(events);
			Collections.sort(eventList);
			Event[] listEvents = new Event[eventList.size()];
			listEvents = eventList.toArray(listEvents);
			eventComboBox = new JComboBox<Event>();
			for (Event event : listEvents)
				eventComboBox.addItem(event);
			eventComboBox.setBounds(430, 34, 240, 27);
			panel.add(eventComboBox);

			// school/group code combo box
			ArrayList<Teacher> teachers = DaoRepository.getTeachersDao().objects;
			ArrayList<String> groupCodes = new ArrayList<String>();
			groupCodes.add("");
			for (Teacher teacher : teachers) {
				String groupCode = teacher.getGroupCode();
				groupCodes.add(groupCode);
			}
			Collections.sort(groupCodes);
			String[] listCodes = new String[groupCodes.size()];
			listCodes = groupCodes.toArray(listCodes);
			schoolGroupCodeComboBox = new JComboBox<String>();
			for (String code : listCodes)
				schoolGroupCodeComboBox.addItem(code);
			schoolGroupCodeComboBox.setBounds(16, 359, 291, 27);
			schoolGroupCodeComboBox.setEnabled(false);
			panel.add(schoolGroupCodeComboBox);

			// age combo box
			ArrayList<Integer> ages = new ArrayList<>();
			for (int i = 6; i < 100; i++) {
				Integer val = new Integer(i);
				ages.add(val);
			}
			Integer[] listAges = new Integer[ages.size()];
			listAges = ages.toArray(listAges);
			ageComboBox = new JComboBox<>();
			for (Integer age : listAges)
				ageComboBox.addItem(age);
			ageComboBox.setBounds(66, 139, 75, 27);
			panel.add(ageComboBox);

			// teacher/group leader combo box
			teacherList = new ArrayList<>();
			teacherList.add(new Teacher("", "", ""));
			teacherList.addAll(teachers);
			Collections.sort(teacherList);
			Teacher[] listNames = new Teacher[teacherList.size()];
			listNames = teacherList.toArray(listNames);
			groupLeaderComboBox = new JComboBox<Teacher>();
			for (Teacher teacher : listNames)
				groupLeaderComboBox.addItem(teacher);
			groupLeaderComboBox.setBounds(17, 317, 291, 27);
			panel.add(groupLeaderComboBox);

			// schools combo box
			ArrayList<School> schools = DaoRepository.getSchoolsDao().objects;
			schoolList = new ArrayList<>();
			schoolList.add(new School(""));
			schoolList.addAll(schools);
			Collections.sort(schoolList);
			School[] listSchools = new School[schoolList.size()];
			listSchools = schoolList.toArray(listSchools);
			schoolNameComboBox = new JComboBox<School>();
			for (School school : listSchools)
				schoolNameComboBox.addItem(school);
			schoolNameComboBox.setBounds(16, 275, 291, 27);
			panel.add(schoolNameComboBox);
		}
		// ----------- End Combo Box -------- //

		// ----------- Start Buttons -------- //
		{

			// Register Button
			btnRegister = new RegisterButton(new MediatorActionListener(),
					mediator, this);
			btnRegister.setBounds(361, 133, 103, 29);
			panel.add(btnRegister);
			btnRegister.setEnabled(false);

			// Unregister Button
			btnUnregister = new UnregisterButton(new MediatorActionListener(),
					mediator, this);
			btnUnregister.setBounds(467, 133, 117, 29);
			panel.add(btnUnregister);
			btnUnregister.setEnabled(false);

			// Clear Button
			clearButton = new ClearButton(new MediatorActionListener(),
					mediator, this);
			clearButton.setBounds(586, 134, 88, 28);
			panel.add(clearButton);

			// New Button
			newBtn = new NewButton(new MediatorActionListener(), mediator, this);

			// Delete Button
			deleteBtn = new DeleteButton(new MediatorActionListener(),
					mediator, this);
			deleteBtn.setEnabled(false);

			// Save Button
			saveBtn = new SaveButton(new MediatorActionListener(), mediator,
					this);
		}
		// ------------- End Buttons -------------- //

		// ------------ Start Table Events ----------- //
		{
			athleteTable.getSelectionModel().addListSelectionListener(
					new ListSelectionListener() {
						@Override
						public void valueChanged(ListSelectionEvent e) {

							if (athleteTable.getSelectedRow() != -1) {
								deleteBtn.setEnabled(true);
								if (athleteTable.getRowCount() > 0) {
									fillPanel();

								}
							} else
								deleteBtn.setEnabled(false);

							if (registrationTable.getRowCount() > 0)
								fillPanel();
						}
					});

			registrationTable.getSelectionModel().addListSelectionListener(
					new ListSelectionListener() {
						@Override
						public void valueChanged(ListSelectionEvent e) {
							if (registrationTable.getSelectedRow() != -1
									&& athleteTable.getSelectedRow() != -1) {
								btnUnregister.setEnabled(true);
								if (registrationTable.getRowCount() > 0) {
									setRegistration(registrationTableModel
											.getRegistration(registrationTable
													.getSelectedRow()));
								}
							} else {
								btnUnregister.setEnabled(false);
								setRegistration(null);
							}
						}
					});
		}
		// ------------ End Table Events --------------- //

		// ------------ Start Combo Box Events ----------------- //
		{
			eventComboBox.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {

					if (e.getStateChange() == ItemEvent.SELECTED) {

						Event event = (Event) eventComboBox.getSelectedItem();

						setUnits(event);

						if (athleteTable.getSelectedRow() != -1
								&& event != null
								&& event.getEventName() != null
								&& event.getEventName().trim().length() != 0) {
							btnRegister.setEnabled(true);
							for (int row = 0; row < registrationTable
									.getRowCount(); row++) {
								Registration r = registrationTableModel
										.getRegistration(row);
								if (r.getEvent() != null
										&& r.getEvent().getDbId()
												.equals(event.getDbId())) {
									registrationTable.setRowSelectionInterval(
											row, row);
									break;
								}
							}
						} else {
							btnRegister.setEnabled(false);
						}
					}
				}
			});

			schoolNameComboBox.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {

					if (e.getStateChange() == ItemEvent.SELECTED) {

						School school = (School) schoolNameComboBox
								.getSelectedItem();
					}
				}
			});

			groupLeaderComboBox.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {

					if (e.getStateChange() == ItemEvent.SELECTED) {

						Teacher teacher = (Teacher) groupLeaderComboBox
								.getSelectedItem();
						schoolGroupCodeComboBox.setSelectedItem(teacher
								.getGroupCode());
					}
				}
			});
		}
		// ------------- End Combo Box Events ------------------ //

		// ---------------- Generated By Window Builder ---------------- //
		final GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																splitPane,
																GroupLayout.PREFERRED_SIZE,
																937,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				newBtn,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				deleteBtn,
																				GroupLayout.PREFERRED_SIZE,
																				100,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				saveBtn,
																				GroupLayout.PREFERRED_SIZE,
																				111,
																				GroupLayout.PREFERRED_SIZE)))
										.addGap(15)));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(splitPane,
												GroupLayout.PREFERRED_SIZE,
												457, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																deleteBtn,
																GroupLayout.PREFERRED_SIZE,
																31,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																saveBtn,
																GroupLayout.PREFERRED_SIZE,
																31,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																newBtn,
																GroupLayout.PREFERRED_SIZE,
																31,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap(23, Short.MAX_VALUE)));
		setLayout(groupLayout);

	}

	/**
	 * Method loadRegistrations.
	 * @param a Athlete
	 */
	public void loadRegistrations(Athlete a) {
		if (a.getDbId() != null)
			registrationTableModel.setRegistrations(a.getRegistrations());
		else
			registrationTableModel
					.setRegistrations(new ArrayList<Registration>());
		registrationTableModel.update();
	}

	private void fillPanel() {

		Athlete athlete = new Athlete("", "", "", new Integer(8), "", "",
				new ArrayList<String>());

		if (athleteTable.getSelectedRow() != -1) {
			athlete = athleteTableModel.getAthlete(athleteTable
					.getSelectedRow());
		}

		// refresh the events combo box
		updateEvents();

		// set name
		athleteFirstNameTextBox.setText(athlete.getFirstName());
		athleteLastNameTxtBox.setText(athlete.getLastName());

		// set age
		ageComboBox.setSelectedItem(athlete.getAge());

		// set gender
		String gender = athlete.getGender().toUpperCase();
		if (gender.equals("M"))
			gender = "Male";
		else if (gender.equals("F"))
			gender = "Female";
		genderComboBox.setSelectedItem(gender);

		// Set group leader
		DatabaseAccessObject<Teacher> daot = DaoRepository.getTeachersDao();
		Teacher t = daot.query(athlete.getTeacherRef());
		groupLeaderComboBox.setSelectedItem(t);

		// set group code
		if (t != null) {
			String groupCode = t.getGroupCode();
			schoolGroupCodeComboBox.setSelectedItem(groupCode);
		} else {
			schoolGroupCodeComboBox.setSelectedIndex(0);
		}

		// set school
		School s = athlete.getSchool();
		schoolNameComboBox.setSelectedItem(s);

		setRegistration(null);
		loadRegistrations(athlete);

	}

	/**
	 * Method getAthlete.
	 * @return Athlete
	 * @return Athlete
	 */
	public Athlete getAthlete() {
		Athlete athlete = new Athlete();
		Athlete loadedAthlete = getLoadedAthlete();
		if (loadedAthlete != null) {
			athlete.copy(loadedAthlete);
			athlete.setDbId(loadedAthlete.getDbId());
		}

		Teacher teacher = (Teacher) groupLeaderComboBox.getSelectedItem();
		String teacherRef = teacher.getDbId();

		String firstName = athleteFirstNameTextBox.getText();

		String lastName = athleteLastNameTxtBox.getText();

		Integer age = (Integer) ageComboBox.getSelectedItem();

		String gender = (String) genderComboBox.getSelectedItem();
		if (gender.equals("Male"))
			gender = "M";
		else if (gender.equals("Female"))
			gender = "F";

		School school = (School) schoolNameComboBox.getSelectedItem();
		String schoolRef = school.getDbId();

		ArrayList<String> regRefs = new ArrayList<>();
		ArrayList<Registration> regs = athlete.getRegistrations();
		for (Registration r : regs) {
			String ref = r.getDbId();
			regRefs.add(ref);
		}

		athlete.setFirstName(firstName);
		athlete.setLastName(lastName);
		athlete.setAge(age);
		athlete.setGender(gender);
		athlete.setRegRefs(regRefs);
		athlete.setTeacherRef(teacherRef);
		athlete.setSchoolRef(schoolRef);

		return athlete;
	}

	/**
	 * Method getRegistration.
	 * @return Registration
	 * @return Registration
	 */
	public Registration getRegistration() {
		// Get athlete from the table
		Athlete a = null;
		String athRef = null;
		int athIndex = athleteTable.getSelectedRow();
		if (athIndex != -1)
			a = athleteTableModel.getAthlete(athIndex);
		if (a != null)
			athRef = a.getDbId();

		// Get event from the table
		Event e = (Event) eventComboBox.getSelectedItem();
		String eventRef = null;
		if (e != null)
			eventRef = e.getDbId();

		Integer score = 0;
		if (e.getScoreUnit().equals("D")) {
			Integer feet = (Integer) feetComboBox.getSelectedItem();
			Integer inch = (Integer) inchComboBox.getSelectedItem();
			score = Event.combineMajorMinorScores(feet, inch);
		} else if (e.getScoreUnit().equals("T")) {
			Integer min = (Integer) minComboBox.getSelectedItem();
			Integer sec = (Integer) secComboBox.getSelectedItem();
			score = Event.combineMajorMinorScores(min, sec);
		}

		Registration r = new Registration();
		Registration loadedReg = getLoadedRegistration();
		if (loadedReg != null) {
			r.copy(loadedReg);
			r.setDbId(loadedReg.getDbId());
		}

		r.setEventRef(eventRef);
		r.setAthleteRef(athRef);
		r.setScore(score);

		return r;
	}

	/**
	 * Method setRegistration.
	 * @param r Registration
	 * @param r Registration
	 */
	public void setRegistration(Registration r) {
		if (r == null) {
			r = new Registration();
			registrationTable.clearSelection();
		} else {
			int index = registrationTableModel.indexOf(r);
			if (index == -1)
				registrationTable.clearSelection();
			else
				registrationTable.setRowSelectionInterval(index, index);
		}
		Event e = r.getEvent();
		if (e != null) {
			eventComboBox.setSelectedItem(e);
			setScore(e, r.getScore());
		} else {
			eventComboBox.setSelectedIndex(0);
		}
	}

	/**
	 * Method udpateEvents.
	 */
	private void updateEvents() {
		// reload the events list
		events = DaoRepository.getEventsDao().objects;

		// sort events
		Collections.sort(events);

		// refresh the combo box
		eventComboBox.removeAllItems();
		for (Event event : events)
			eventComboBox.addItem(event);
	}

	/**
	 * Method clearPanel.
	 */
	@Override
	public void clearPanel() {
		athleteTable.clearSelection();
		// unfocuses table cell by focusing on something else
		newBtn.requestFocusInWindow();
		fillPanel();
	}

	/**
	 * Method updateTables.
	 */
	public void updateTables() {
		athleteTableModel.update();
		registrationTableModel.update();
	}

	/**
	 * Method setScore.
	 * @param e Event
	 * @param score Integer
	 */
	private void setScore(Event e, Integer score) {
		Integer scoreMajor = Event.extractMajorScore(score);
		Integer scoreMinor = Event.extractMinorScore(score);

		if (e.getScoreUnit().equals("D")) {
			feetComboBox.setSelectedItem(scoreMajor);
			inchComboBox.setSelectedItem(scoreMinor);
		} else if (e.getScoreUnit().equals("T")) {
			minComboBox.setSelectedItem(scoreMajor);
			secComboBox.setSelectedItem(scoreMinor);
		}
	}

	/**
	 * Method setUnits.
	 * @param e Event
	 */
	private void setUnits(Event e) {
		feetComboBox.removeAllItems();
		inchComboBox.removeAllItems();
		minComboBox.removeAllItems();
		secComboBox.removeAllItems();
		feetComboBox.setEnabled(false);
		inchComboBox.setEnabled(false);
		minComboBox.setEnabled(false);
		secComboBox.setEnabled(false);

		if (e != null) {
			Integer maxMajor = Event.extractMajorScore(e.getScoreMax());

			if (e.getScoreUnit().equals("D")) {
				feetComboBox.setEnabled(true);
				inchComboBox.setEnabled(true);
				for (Integer i = 0; i <= maxMajor; i++)
					feetComboBox.addItem(i);
				for (Integer i = 0; i < 12; i++)
					inchComboBox.addItem(i);
			} else if (e.getScoreUnit().equals("T")) {
				minComboBox.setEnabled(true);
				secComboBox.setEnabled(true);
				for (Integer i = 0; i <= maxMajor; i++)
					minComboBox.addItem(i);
				for (Integer i = 0; i < 60; i++)
					secComboBox.addItem(i);
			}
		}
	}

	/**
	 * Method setRegEnabled.
	 * @param bool boolean
	 */
	public void setRegEnabled(boolean bool) {
		btnRegister.setEnabled(bool);
	}

	/**
	 * Method setUnregEnabled.
	 * @param bool boolean
	 */
	public void setUnregEnabled(boolean bool) {
		btnUnregister.setEnabled(bool);
	}

	/**
	 * Method getLoadedAthlete
	 * @return athlete Athlete
	 *         <p>
	 *         Returns the selected athlete from the panel. If no athlete is
	 *         selected, a new Athlete instance will be instantiated.
	 */
	public Athlete getLoadedAthlete() {
		Athlete ret = new Athlete();
		if (athleteTable.getSelectedRow() != -1)
			ret = athleteTableModel.getAthlete(athleteTable.getSelectedRow());
		return ret;
	}

	/**
	 * Method getLoadedRegistration
	 * @return registration Registration
	 *         <p>
	 *         Returns the selected registration from the panel. If none is
	 *         selected, a new Registration instance will be instantiated.
	 */
	public Registration getLoadedRegistration() {
		Registration ret = new Registration();
		if (registrationTable.getSelectedRow() != -1)
			ret = registrationTableModel.getRegistration(registrationTable
					.getSelectedRow());
		return ret;
	}

}