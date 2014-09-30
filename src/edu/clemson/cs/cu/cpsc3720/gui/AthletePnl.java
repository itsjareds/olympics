package edu.clemson.cs.cu.cpsc3720.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import edu.clemson.cs.cu.cpsc3720.gui.components.DeleteButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.NewButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.SaveButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.SearchButton;
import edu.clemson.cs.cu.cpsc3720.gui.models.AthleteTableModel;
import edu.clemson.cs.cu.cpsc3720.gui.models.EventTableModel;
import edu.clemson.cs.cu.cpsc3720.gui.models.HeatTableModel;
import edu.clemson.cs.cu.cpsc3720.main.Athlete;
import edu.clemson.cs.cu.cpsc3720.main.Event;
import edu.clemson.cs.cu.cpsc3720.main.Heat;
import edu.clemson.cs.cu.cpsc3720.main.Registration;
import edu.clemson.cs.cu.cpsc3720.main.School;
import edu.clemson.cs.cu.cpsc3720.main.Teacher;
import edu.clemson.cs.cu.cpsc3720.mediator.Mediator;
import edu.clemson.cs.cu.cpsc3720.mediator.MediatorActionListener;

public class AthletePnl extends JPanel {

	private static final long serialVersionUID = 2209017935088133557L;
	private Mediator mediator;
	private JTextField athleteFirstNameTextBox;
	private JTextField athleteLastNameTxtBox;
	private JTextField schoolNameTxtBox;
	private JTable table;
	private static AthleteTableModel athleteTableModel;
	private static EventTableModel eventTableModel;
	private static HeatTableModel heatTableModel;
	private ArrayList<Athlete> athletes;
	private ArrayList<Event> events;
	private ArrayList<Heat> heats;
	private JTextField groupCodeTxtBox;
	private JTextField searchTxtBox;
	private JTextField qualifingScoreTxtBox;
	private JTable eventsTable;
	private JTable heatsTable;
	private JTextField ageTextField;
	private JComboBox<String> genderComboBox;
	private JComboBox<String> groupLeaderComboBox;
	private JComboBox<String> filterComboBox;

	/**
	 * Create the panel.
	 */
	public AthletePnl(Mediator mediator) {
		this.mediator = mediator;
		this.setName("AthletePanel");

		athletes = new ArrayList<Athlete>();
		events = new ArrayList<Event>();
		heats = new ArrayList<Heat>();

		// create some fake athletes to put in the table
		Athlete athlete;
		Event event;
		Heat heat;
		for (int i = 0; i < 100; i++) {
			event = new Event("E" + i, "Some Event", "N D T", new Integer(0),
					new Integer(999), new Integer(i),
					new ArrayList<Registration>(), new ArrayList<Heat>());

			athlete = new Athlete(new Teacher("Jim", "Stanton", "G0" + i),
					"Bob", "Clemmings", new Integer(21), "Male", new School(
							"Some School"), new ArrayList<Registration>());

			heat = new Heat(event, athlete.getGender(), new Integer(8),
					new Integer(12), new Time(12, 45, 00));

			athletes.add(athlete);
			events.add(event);
			heats.add(heat);
		}

		athleteTableModel = new AthleteTableModel(athletes);
		eventTableModel = new EventTableModel(events);
		heatTableModel = new HeatTableModel(heats);

		// Panes and Panels
		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(1);
		splitPane.setDividerLocation(160);

		JScrollPane athleteScrollPane = new JScrollPane();
		splitPane.setLeftComponent(athleteScrollPane);

		JScrollPane informationScrollPane = new JScrollPane();
		splitPane.setRightComponent(informationScrollPane);

		JPanel panel = new JPanel();
		informationScrollPane.setViewportView(panel);
		panel.setLayout(null);

		JScrollPane eventsScrollPane = new JScrollPane();
		eventsScrollPane.setBounds(369, 34, 317, 103);
		panel.add(eventsScrollPane);

		JScrollPane heatsScrollPane = new JScrollPane();
		heatsScrollPane.setBounds(369, 261, 317, 114);
		panel.add(heatsScrollPane);

		// JLables
		JLabel lblFilter = new JLabel("Filter by: ");

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(6, 53, 101, 16);
		panel.add(lblFirstName);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(6, 81, 101, 16);
		panel.add(lblLastName);

		JLabel lblSchoolName = new JLabel("School Name");
		lblSchoolName.setBounds(6, 308, 101, 16);
		panel.add(lblSchoolName);

		JLabel lblGroupLeader = new JLabel("Group Leader");
		lblGroupLeader.setBounds(6, 274, 101, 16);
		panel.add(lblGroupLeader);

		JLabel lblNewLabel = new JLabel("Athlete Information");
		lblNewLabel.setBounds(6, 6, 265, 16);
		panel.add(lblNewLabel);

		JLabel lblGroupCode = new JLabel("Group Code");
		lblGroupCode.setBounds(6, 342, 101, 16);
		panel.add(lblGroupCode);

		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(6, 109, 61, 16);
		panel.add(lblAge);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(6, 149, 61, 16);
		panel.add(lblGender);

		JLabel lblScore = new JLabel("Qualifing Score");
		lblScore.setBounds(369, 149, 133, 16);
		panel.add(lblScore);

		JLabel lblAssociatedEvents = new JLabel("Associated Events");
		lblAssociatedEvents.setBounds(369, 6, 173, 16);
		panel.add(lblAssociatedEvents);

		JLabel lblAssociatedHeats = new JLabel("Associated Heats");
		lblAssociatedHeats.setBounds(369, 233, 146, 16);
		panel.add(lblAssociatedHeats);

		JLabel lblTeacherInformation = new JLabel("Teacher Information");
		lblTeacherInformation.setBounds(6, 233, 157, 16);
		panel.add(lblTeacherInformation);

		// JButtons
		JButton searchBtn = new SearchButton(new MediatorActionListener(),
				mediator, this);
		searchBtn.setText("Search");

		JButton newBtn = new NewButton(new MediatorActionListener(), mediator,
				this);
		newBtn.setText("New");

		final JButton deleteBtn = new DeleteButton(
				new MediatorActionListener(), mediator, this);
		deleteBtn.setText("Delete");

		JButton saveBtn = new SaveButton(new MediatorActionListener(),
				mediator, this);
		saveBtn.setText("Save");

		// JTextFields
		searchTxtBox = new JTextField();
		searchTxtBox.setColumns(10);

		ageTextField = new JTextField();
		ageTextField.setBounds(119, 103, 152, 28);
		panel.add(ageTextField);
		ageTextField.setColumns(10);

		athleteFirstNameTextBox = new JTextField();
		athleteFirstNameTextBox.setBounds(119, 47, 152, 28);
		panel.add(athleteFirstNameTextBox);
		athleteFirstNameTextBox.setColumns(10);

		athleteLastNameTxtBox = new JTextField();
		athleteLastNameTxtBox.setColumns(10);
		athleteLastNameTxtBox.setBounds(119, 75, 152, 28);
		panel.add(athleteLastNameTxtBox);

		schoolNameTxtBox = new JTextField();
		schoolNameTxtBox.setColumns(10);
		schoolNameTxtBox.setBounds(119, 302, 152, 28);
		panel.add(schoolNameTxtBox);

		groupCodeTxtBox = new JTextField();
		groupCodeTxtBox.setColumns(10);
		groupCodeTxtBox.setBounds(119, 336, 152, 28);
		panel.add(groupCodeTxtBox);

		// JComboBoxes
		String[] teachers = { " ", "Jim Stanton", "Bob Uptown" };
		groupLeaderComboBox = new JComboBox<String>(teachers);
		groupLeaderComboBox.setBounds(119, 270, 152, 27);
		panel.add(groupLeaderComboBox);

		String[] genders = { " ", "Male", "Female" };
		genderComboBox = new JComboBox<String>(genders);
		genderComboBox.setBounds(119, 145, 121, 27);
		panel.add(genderComboBox);

		String[] filters = { " ", "First Name", "Last Name", "School",
				"Group Leader", "Event", "Heat", };
		filterComboBox = new JComboBox<String>(filters);

		// JTables
		heatsTable = new JTable(AthletePnl.heatTableModel);
		heatsScrollPane.setViewportView(heatsTable);

		eventsTable = new JTable(AthletePnl.eventTableModel);
		eventsScrollPane.setViewportView(eventsTable);
		eventsTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent mevt) {
				if (eventsTable.getSelectedRow() != -1) {
					deleteBtn.setEnabled(true);
				}
				if (eventsTable.getRowCount() > 0)

					if (mevt.getClickCount() == 2) {
						// on double click, open the events panel
					}
			}
		});

		table = new JTable(athleteTableModel);
		athleteScrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent mevt) {
				if (table.getSelectedRow() != -1) {
					deleteBtn.setEnabled(true);
				}
				if (table.getRowCount() > 0)

					if (mevt.getClickCount() == 1) {
						AthleteTableModel atm = (AthleteTableModel) table
								.getModel();
						Athlete a = atm.getAthlete(table.getSelectedRow());
						athleteFirstNameTextBox.setText(a.getFirstName());
						athleteLastNameTxtBox.setText(a.getLastName());
						schoolNameTxtBox.setText(a.getSchool().getSchoolName());
						groupCodeTxtBox.setText(a.getGroupLeader()
								.getGroupCode());
						genderComboBox.setSelectedItem(a.getGender());
						ageTextField.setText(a.getAge().toString());
						groupLeaderComboBox.setSelectedItem(a.getGroupLeader()
								.getFirstName()
								+ " "
								+ a.getGroupLeader().getLastName());
					}
			}
		});

		GroupLayout groupLayout = new GroupLayout(this);
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
																Alignment.TRAILING,
																GroupLayout.DEFAULT_SIZE,
																886,
																Short.MAX_VALUE)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				newBtn,
																				GroupLayout.PREFERRED_SIZE,
																				64,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				deleteBtn,
																				GroupLayout.PREFERRED_SIZE,
																				92,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				saveBtn,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				lblFilter)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				filterComboBox,
																				GroupLayout.PREFERRED_SIZE,
																				117,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				searchTxtBox,
																				GroupLayout.DEFAULT_SIZE,
																				196,
																				Short.MAX_VALUE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				searchBtn,
																				GroupLayout.DEFAULT_SIZE,
																				124,
																				Short.MAX_VALUE)
																		.addGap(372)))
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
																Alignment.BASELINE)
														.addComponent(
																filterComboBox,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																searchTxtBox,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																searchBtn,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblFilter))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(splitPane)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING,
																false)
														.addComponent(saveBtn,
																0, 0,
																Short.MAX_VALUE)
														.addComponent(
																newBtn,
																GroupLayout.PREFERRED_SIZE,
																60,
																Short.MAX_VALUE)
														.addComponent(
																deleteBtn,
																GroupLayout.PREFERRED_SIZE,
																60,
																Short.MAX_VALUE))
										.addContainerGap()));
		setLayout(groupLayout);

	}
}
