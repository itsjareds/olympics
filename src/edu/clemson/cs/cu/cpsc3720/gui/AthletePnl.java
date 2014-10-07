package edu.clemson.cs.cu.cpsc3720.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
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
import edu.clemson.cs.cu.cpsc3720.main.Teacher;
import edu.clemson.cs.cu.cpsc3720.mediator.Mediator;
import edu.clemson.cs.cu.cpsc3720.mediator.MediatorActionListener;

public class AthletePnl extends JPanel {
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
	private JTextField broupCodeTxtBox;
	private JTextField searchTxtBox;
	private JTable eventsTable;
	private JTable heatsTable;

	/**
	 * Create the panel.
	 */
	public AthletePnl(Mediator mediator) {
		this.mediator = mediator;
		this.setName("AthletePanel");

		athletes = DaoRepository.getAthletes().objects;
		events = new ArrayList<Event>();
		ArrayList<Registration> regs = athletes.get(0).getRegistrations();
		for (Registration r : regs) {
			events.add(r.getEvent());
		}
		heats = new ArrayList<Heat>();

		athleteTableModel = new AthleteTableModel(athletes);
		eventTableModel = new EventTableModel(events);
		heatTableModel = new HeatTableModel(heats);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(1);
		splitPane.setDividerLocation(160);

		JScrollPane athleteScrollPane = new JScrollPane();
		splitPane.setLeftComponent(athleteScrollPane);

		table = new JTable(athleteTableModel);
		athleteScrollPane.setViewportView(table);

		JScrollPane informationScrollPane = new JScrollPane();
		splitPane.setRightComponent(informationScrollPane);

		JPanel panel = new JPanel();
		informationScrollPane.setViewportView(panel);
		panel.setLayout(null);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(67, 34, 222, 16);
		panel.add(lblFirstName);

		athleteFirstNameTextBox = new JTextField();
		athleteFirstNameTextBox.setBounds(67, 50, 242, 28);
		panel.add(athleteFirstNameTextBox);
		athleteFirstNameTextBox.setColumns(10);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(67, 75, 222, 16);
		panel.add(lblLastName);

		athleteLastNameTxtBox = new JTextField();
		athleteLastNameTxtBox.setColumns(10);
		athleteLastNameTxtBox.setBounds(67, 90, 242, 28);
		panel.add(athleteLastNameTxtBox);

		JLabel lblSchoolName = new JLabel("School Name");
		lblSchoolName.setBounds(67, 302, 101, 16);
		panel.add(lblSchoolName);

		schoolNameTxtBox = new JTextField();
		schoolNameTxtBox.setColumns(10);
		schoolNameTxtBox.setBounds(67, 318, 152, 28);
		panel.add(schoolNameTxtBox);

		JLabel lblGroupLeader = new JLabel("Group Leader");
		lblGroupLeader.setBounds(67, 261, 101, 16);
		panel.add(lblGroupLeader);

		JLabel lblNewLabel = new JLabel("Athlete Information");
		lblNewLabel.setBounds(107, 6, 265, 16);
		panel.add(lblNewLabel);

		JLabel lblGroupCode = new JLabel("Group Code");
		lblGroupCode.setBounds(67, 345, 101, 16);
		panel.add(lblGroupCode);

		broupCodeTxtBox = new JTextField();
		broupCodeTxtBox.setColumns(10);
		broupCodeTxtBox.setBounds(67, 358, 152, 28);
		panel.add(broupCodeTxtBox);

		JLabel lblBirthday = new JLabel("Birth Date");
		lblBirthday.setBounds(67, 118, 113, 22);
		panel.add(lblBirthday);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(67, 195, 61, 16);
		panel.add(lblGender);

		JLabel lblScore = new JLabel("Qualifing Score");
		lblScore.setBounds(361, 70, 117, 16);
		panel.add(lblScore);

		JComboBox<Integer> monthComboBox = new JComboBox<Integer>();
		monthComboBox.setBounds(117, 139, 82, 27);
		panel.add(monthComboBox);

		JComboBox<String> genderComboBox = new JComboBox<String>();
		genderComboBox.setBounds(117, 191, 82, 27);
		panel.add(genderComboBox);

		JLabel lblAssociatedEvents = new JLabel("Registered Events");
		lblAssociatedEvents.setBounds(438, 170, 173, 16);
		panel.add(lblAssociatedEvents);

		JLabel lblAssociatedHeats = new JLabel("Associated Heats");
		lblAssociatedHeats.setBounds(438, 256, 146, 16);
		panel.add(lblAssociatedHeats);

		JScrollPane eventsScrollPane = new JScrollPane();
		eventsScrollPane.setBounds(361, 194, 309, 56);
		panel.add(eventsScrollPane);

		eventsTable = new JTable(AthletePnl.eventTableModel);
		eventsScrollPane.setViewportView(eventsTable);

		JScrollPane heatsScrollPane = new JScrollPane();
		heatsScrollPane.setBounds(361, 279, 309, 107);
		panel.add(heatsScrollPane);

		heatsTable = new JTable(AthletePnl.heatTableModel);
		heatsScrollPane.setViewportView(heatsTable);

		JComboBox<Teacher> groupLeaderComboBox = new JComboBox<Teacher>();
		groupLeaderComboBox.setBounds(67, 276, 152, 27);
		panel.add(groupLeaderComboBox);

		JLabel lblTeacherInformation = new JLabel("Teacher Information");
		lblTeacherInformation.setBounds(107, 233, 157, 16);
		panel.add(lblTeacherInformation);

		JComboBox<Integer> dayComboBox = new JComboBox<Integer>();
		dayComboBox.setBounds(227, 139, 82, 27);
		panel.add(dayComboBox);

		JComboBox<Integer> yearComboBox = new JComboBox<Integer>();
		yearComboBox.setBounds(117, 166, 82, 27);
		panel.add(yearComboBox);

		JLabel lblMonth = new JLabel("Month");
		lblMonth.setBounds(67, 143, 61, 16);
		panel.add(lblMonth);

		JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(203, 143, 61, 16);
		panel.add(lblDay);

		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(67, 170, 61, 16);
		panel.add(lblYear);

		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(440, 131, 117, 29);
		panel.add(btnRegister);

		JButton btnUnregister = new JButton("Unregister");
		btnUnregister.setBounds(557, 131, 113, 29);
		panel.add(btnUnregister);

		JLabel lblEvents = new JLabel("Add Event");
		lblEvents.setBounds(361, 38, 82, 16);
		panel.add(lblEvents);

		JComboBox<Integer> comboBox = new JComboBox<Integer>();
		comboBox.setBounds(430, 34, 240, 27);
		panel.add(comboBox);

		JLabel lblFt = new JLabel("ft.");
		lblFt.setBounds(481, 70, 50, 16);
		panel.add(lblFt);

		JLabel lblIn = new JLabel("In.");
		lblIn.setBounds(586, 70, 61, 16);
		panel.add(lblIn);

		JComboBox<Integer> inchComboBox = new JComboBox<Integer>();
		inchComboBox.setBounds(609, 66, 61, 27);
		panel.add(inchComboBox);

		JComboBox<Integer> feetComboBox = new JComboBox<Integer>();
		feetComboBox.setBounds(513, 66, 61, 27);
		panel.add(feetComboBox);

		JLabel lblMin = new JLabel("min");
		lblMin.setBounds(481, 98, 61, 16);
		panel.add(lblMin);

		JLabel lblSec = new JLabel("sec");
		lblSec.setBounds(586, 98, 50, 16);
		panel.add(lblSec);

		JComboBox<Integer> minComboBox = new JComboBox<Integer>();
		minComboBox.setBounds(513, 97, 61, 27);
		panel.add(minComboBox);

		JComboBox<Integer> secComboBox = new JComboBox<Integer>();
		secComboBox.setBounds(609, 94, 61, 27);
		panel.add(secComboBox);

		JLabel lblRegisterForEvent = new JLabel("Register for Event");
		lblRegisterForEvent.setBounds(438, 6, 146, 16);
		panel.add(lblRegisterForEvent);

		searchTxtBox = new JTextField();
		searchTxtBox.setColumns(10);

		JComboBox<String> filterComboBox = new JComboBox<String>();

		JLabel lblNewLabel_2 = new JLabel("Filter by: ");

		JButton searchBtn = new SearchButton(new MediatorActionListener(),
				mediator, this);
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JButton newBtn = new NewButton(new MediatorActionListener(), mediator,
				this);
		newBtn.setText("New");

		JButton deleteBtn = new DeleteButton(new MediatorActionListener(),
				mediator, this);
		deleteBtn.setText("Delete");

		JButton saveBtn = new SaveButton(new MediatorActionListener(),
				mediator, this);

		saveBtn.setText("Save");
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
																Alignment.LEADING,
																false)
														.addComponent(
																splitPane,
																GroupLayout.PREFERRED_SIZE,
																851,
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
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				lblNewLabel_2)
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
																				GroupLayout.PREFERRED_SIZE)))
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
																				lblNewLabel_2)
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
										.addContainerGap(29, Short.MAX_VALUE)));
		setLayout(groupLayout);

	}
}
