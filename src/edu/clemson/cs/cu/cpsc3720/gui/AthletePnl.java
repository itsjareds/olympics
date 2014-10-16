package edu.clemson.cs.cu.cpsc3720.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.databaseaccess.DatabaseAccessObject;
import edu.clemson.cs.cu.cpsc3720.gui.components.DeleteButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.NewButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.RegisterButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.SaveButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.SearchButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.UnregisterButton;
import edu.clemson.cs.cu.cpsc3720.gui.models.AthleteTableModel;
import edu.clemson.cs.cu.cpsc3720.gui.models.EventTableModel;
import edu.clemson.cs.cu.cpsc3720.main.Athlete;
import edu.clemson.cs.cu.cpsc3720.main.Event;
import edu.clemson.cs.cu.cpsc3720.main.Registration;
import edu.clemson.cs.cu.cpsc3720.main.School;
import edu.clemson.cs.cu.cpsc3720.main.Teacher;
import edu.clemson.cs.cu.cpsc3720.mediator.Mediator;
import edu.clemson.cs.cu.cpsc3720.mediator.MediatorActionListener;

public class AthletePnl extends JPanel {
	private static final long serialVersionUID = -3647303070052872171L;
	private static AthleteTableModel athleteTableModel;
	private static EventTableModel eventTableModel;
	private final JTextField athleteFirstNameTextBox;
	private final JTextField athleteLastNameTxtBox;
	private final ArrayList<Athlete> athletes;
	private final ArrayList<Event> events;
	private final JTable eventsTable;
	private final Mediator mediator;
	private final JTextField searchTxtBox;
	private final JTable athleteTable;
	private double dividerLocation;
	private JComboBox<Integer> ageComboBox;
	private JComboBox<String> genderComboBox;
	private JComboBox<Teacher> groupLeaderComboBox;
	private JComboBox<Event> eventComboBox;
	private JComboBox<String> inchComboBox;
	private JComboBox<String> feetComboBox;
	private JComboBox<String> minComboBox;
	private JComboBox<String> secComboBox;
	private JComboBox<String> schoolGroupCodeComboBox;
	private JComboBox<School> schoolNameComboBox;
	private JComboBox<String> filterComboBox;
	private SearchButton searchBtn;
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
	private JLabel lblFilterBy;
	private ArrayList<Teacher> teacherList;
	private ArrayList<School> schoolList;
	private ArrayList<Event> eventList;
	private ArrayList<Event> associatedEvents;
	private Athlete loadedAthlete;

	/**
	 * Create the panel.
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
			eventTableModel = new EventTableModel(new ArrayList<Event>());

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

			searchTxtBox = new JTextField();
			searchTxtBox.setColumns(10);
		}
		// ------- End Text Boxes ------------- //

		// --------- Start Tables ------------ //
		{
			athleteTable = new JTable(athleteTableModel);
			athleteScrollPane.setViewportView(athleteTable);

			eventsTable = new JTable(AthletePnl.eventTableModel);
			eventsScrollPane.setViewportView(eventsTable);

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
			lblSchoolName.setBounds(16, 302, 291, 16);
			panel.add(lblSchoolName);

			final JLabel lblGroupLeader = new JLabel("Group Leader");
			lblGroupLeader.setBounds(16, 261, 291, 16);
			panel.add(lblGroupLeader);

			final JLabel lblNewLabel = new JLabel("Athlete Information");
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
			panel.add(lblAssociatedEvents);

			final JLabel lblTeacherInformation = new JLabel(
					"Teacher Information");
			lblTeacherInformation.setBounds(56, 233, 251, 16);
			panel.add(lblTeacherInformation);

			final JLabel lblEvents = new JLabel("Add Event");
			lblEvents.setBounds(361, 38, 82, 16);
			panel.add(lblEvents);

			final JLabel lblFt = new JLabel("ft.");
			lblFt.setBounds(481, 70, 50, 16);
			panel.add(lblFt);

			final JLabel lblIn = new JLabel("In.");
			lblIn.setBounds(586, 70, 61, 16);
			panel.add(lblIn);

			final JLabel lblMin = new JLabel("min");
			lblMin.setBounds(481, 98, 61, 16);
			panel.add(lblMin);

			final JLabel lblSec = new JLabel("sec");
			lblSec.setBounds(586, 98, 50, 16);
			panel.add(lblSec);

			final JLabel lblRegisterForEvent = new JLabel("Register for Event");
			lblRegisterForEvent.setBounds(438, 6, 146, 16);
			panel.add(lblRegisterForEvent);

			lblFilterBy = new JLabel("Filter by: ");

		}
		// --------- End Labels ------------ //

		// ------- Start Combo Boxes -------- //
		{
			// filter combo box
			String[] filters = { "First Name", "Last Name", "Age",
					"School Name", "Group Leader", "Group Code" };
			filterComboBox = new JComboBox<String>(filters);

			// gender combo box
			String[] genders = { "", "Male", "Female" };
			genderComboBox = new JComboBox<String>(genders);
			genderComboBox.setBounds(66, 165, 98, 27);
			panel.add(genderComboBox);

			minComboBox = new JComboBox<String>();
			minComboBox.setBounds(513, 97, 61, 27);
			panel.add(minComboBox);
			minComboBox.setEnabled(false);

			secComboBox = new JComboBox<String>();
			secComboBox.setBounds(609, 94, 61, 27);
			panel.add(secComboBox);
			secComboBox.setEnabled(false);

			inchComboBox = new JComboBox<String>();
			inchComboBox.setBounds(609, 66, 61, 27);
			panel.add(inchComboBox);
			inchComboBox.setEnabled(false);

			feetComboBox = new JComboBox<String>();
			feetComboBox.setBounds(513, 66, 61, 27);
			panel.add(feetComboBox);
			feetComboBox.setEnabled(false);

			// events combo box
			eventList = new ArrayList<Event>();
			eventList.add(new Event("", "", "", 0, 0, 0));
			eventList.addAll(events);
			Collections.sort(eventList);
			Event[] listEvents = new Event[eventList.size()];
			listEvents = eventList.toArray(listEvents);
			eventComboBox = new JComboBox<Event>(listEvents);
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
			schoolGroupCodeComboBox = new JComboBox<String>(listCodes);
			schoolGroupCodeComboBox.setBounds(16, 359, 291, 27);
			panel.add(schoolGroupCodeComboBox);

			// age combo box
			ArrayList<Integer> ages = new ArrayList<>();
			for (int i = 8; i < 100; i++) {
				Integer val = new Integer(i);
				ages.add(val);
			}
			Integer[] listAges = new Integer[ages.size()];
			listAges = ages.toArray(listAges);
			ageComboBox = new JComboBox<>(listAges);
			ageComboBox.setBounds(66, 139, 75, 27);
			panel.add(ageComboBox);

			// teacher/group leader combo box
			teacherList = new ArrayList<>();
			teacherList.add(new Teacher("", "", ""));
			teacherList.addAll(teachers);
			Collections.sort(teacherList);
			Teacher[] listNames = new Teacher[teacherList.size()];
			listNames = teacherList.toArray(listNames);
			groupLeaderComboBox = new JComboBox<Teacher>(listNames);
			groupLeaderComboBox.setBounds(16, 276, 291, 27);
			panel.add(groupLeaderComboBox);

			// schools combo box
			ArrayList<School> schools = DaoRepository.getSchoolsDao().objects;
			schoolList = new ArrayList<>();
			schoolList.add(new School(""));
			schoolList.addAll(schools);
			Collections.sort(schoolList);
			School[] listSchools = new School[schoolList.size()];
			listSchools = schoolList.toArray(listSchools);
			schoolNameComboBox = new JComboBox<School>(listSchools);
			schoolNameComboBox.setBounds(16, 315, 291, 27);
			panel.add(schoolNameComboBox);
		}
		// ----------- End Combo Box -------- //

		// ----------- Start Buttons -------- //
		{
			// Search Button
			searchBtn = new SearchButton(new MediatorActionListener(),
					mediator, this);

			// Register Button
			btnRegister = new RegisterButton(new MediatorActionListener(),
					mediator, this);
			btnRegister.setBounds(440, 131, 117, 29);
			panel.add(btnRegister);
			btnRegister.setEnabled(false);

			// Unregister Button
			btnUnregister = new UnregisterButton(new MediatorActionListener(),
					mediator, this);
			btnUnregister.setBounds(557, 131, 113, 29);
			panel.add(btnUnregister);
			btnUnregister.setEnabled(false);

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
			athleteTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent mevt) {
					if (athleteTable.getSelectedRow() != -1) {

						deleteBtn.setEnabled(true);
					}
					if (athleteTable.getRowCount() > 0)

						if (mevt.getClickCount() == 1) {

							fillPanel();
							btnRegister.setEnabled(true);
						}
				}
			});

			eventsTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent mevt) {
					if (eventsTable.getSelectedRow() != -1) {

						btnUnregister.setEnabled(true);
					}
					if (eventsTable.getRowCount() > 0)

						if (mevt.getClickCount() == 2) {

						}
				}
			});
		}
		// ------------ End Table Events --------------- //

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
																Alignment.LEADING,
																false)
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
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				lblFilterBy)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				filterComboBox,
																				GroupLayout.PREFERRED_SIZE,
																				148,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				338,
																				Short.MAX_VALUE)
																		.addComponent(
																				searchTxtBox,
																				GroupLayout.PREFERRED_SIZE,
																				194,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				searchBtn,
																				GroupLayout.PREFERRED_SIZE,
																				103,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																splitPane,
																GroupLayout.PREFERRED_SIZE,
																937,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createParallelGroup(
																				Alignment.BASELINE)
																		.addComponent(
																				filterComboBox,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				lblFilterBy)
																		.addComponent(
																				searchTxtBox,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																searchBtn,
																GroupLayout.PREFERRED_SIZE,
																23,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addComponent(splitPane,
												GroupLayout.PREFERRED_SIZE,
												417, GroupLayout.PREFERRED_SIZE)
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

	private void fillPanel() {
		Athlete athlete = athleteTableModel.getAthlete(athleteTable
				.getSelectedRow());
		associatedEvents = new ArrayList<Event>();
		ArrayList<String> arefs = athlete.getRegRefs();
		ArrayList<String> rrefs = new ArrayList<>();

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
		Teacher t = daot.query(Teacher.class, athlete.getTeacherRef());
		groupLeaderComboBox.setSelectedItem(t);

		// set group code
		String groupCode = t.getGroupCode();
		schoolGroupCodeComboBox.setSelectedItem(groupCode);

		// fill event list
		for (String ref : arefs) {
			DatabaseAccessObject<Registration> daor = DaoRepository
					.getRegistrationsDao();
			Registration r = daor.query(Registration.class, ref);
			rrefs.add(r.getEventRef());
		}
		for (String ref : rrefs) {
			DatabaseAccessObject<Event> daoe = DaoRepository.getEventsDao();
			Event e = daoe.query(Event.class, ref);
			if (e != null)
				associatedEvents.add(e);
		}
		eventTableModel.setEvents(associatedEvents);

		// set school
		DatabaseAccessObject<School> daos = DaoRepository.getSchoolsDao();
		School s = daos.query(School.class, athlete.getSchoolRef());
		schoolNameComboBox.setSelectedItem(s);

	}

	public Athlete getAthlete() {
		Athlete athlete = null;

		if (athleteTable.getSelectedRow() != -1) {
			athlete = athleteTableModel.getAthlete(athleteTable
					.getSelectedRow());

			Teacher teacher = (Teacher) groupLeaderComboBox.getSelectedItem();
			String teacherRef = teacher.getDbId();

			String firstName = athleteFirstNameTextBox.getText();

			String lastName = athleteLastNameTxtBox.getText();

			Integer age = (Integer) ageComboBox.getSelectedItem();

			String gender = (String) genderComboBox.getSelectedItem();
			gender = gender.substring(0, 0);

			School school = (School) schoolNameComboBox.getSelectedItem();
			String schoolRef = school.getDbId();

			ArrayList<String> regRefs = new ArrayList<>();
			for (Event e : associatedEvents) {
				regRefs.add(e.getDbId());
			}

			athlete.setTeacher(teacher);
			athlete.setTeacherRef(teacherRef);
			athlete.setFirstName(firstName);
			athlete.setLastName(lastName);
			athlete.setSchool(school);
			athlete.setSchoolRef(schoolRef);
			athlete.setAge(age);
			athlete.setGender(gender);
			athlete.setRegRefs(regRefs);
		}

		return athlete;
	}

	public void clearPanel() {

		athleteTable.clearSelection();

		// set name
		athleteFirstNameTextBox.setText("");
		athleteLastNameTxtBox.setText("");

		// set age
		ageComboBox.setSelectedIndex(0);

		// set gender
		genderComboBox.setSelectedIndex(0);

		// Set group leader
		groupLeaderComboBox.setSelectedIndex(0);

		// set group code
		schoolGroupCodeComboBox.setSelectedIndex(0);

		// fill event list
		eventTableModel.setEvents(new ArrayList<Event>());

		// set school
		schoolNameComboBox.setSelectedIndex(0);

	}

}
