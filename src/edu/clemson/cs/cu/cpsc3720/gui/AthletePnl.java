package edu.clemson.cs.cu.cpsc3720.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import edu.clemson.cs.cu.cpsc3720.gui.components.RegisterButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.SaveButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.SearchButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.UnregisterButton;
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
	private static AthleteTableModel athleteTableModel;
	private static EventTableModel eventTableModel;
	private static HeatTableModel heatTableModel;
	private final JTextField athleteFirstNameTextBox;
	private final JTextField athleteLastNameTxtBox;
	private final ArrayList<Athlete> athletes;
	private final ArrayList<Event> events;
	private final JTable eventsTable;
	private final ArrayList<Heat> heats;
	private final JTable heatsTable;
	private final Mediator mediator;
	private final JTextField searchTxtBox;
	private double dividerLocation;
	private final JTable athleteTable;

	/**
	 * Create the panel.
	 */
	public AthletePnl(final Mediator mediator) {
		this.mediator = mediator;
		this.setName("AthletePanel");

		athletes = DaoRepository.getAthletes().objects;
		events = new ArrayList<Event>();
		final ArrayList<Registration> regs = athletes.get(0).getRegistrations();
		for (final Registration r : regs) {
			events.add(r.getEvent());
		}
		heats = new ArrayList<Heat>();

		athleteTableModel = new AthleteTableModel(athletes);
		eventTableModel = new EventTableModel(events);
		heatTableModel = new HeatTableModel(heats);

		final JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(1);
		dividerLocation = 0.8;
		splitPane.setDividerLocation(250);

		final JScrollPane athleteScrollPane = new JScrollPane();
		splitPane.setLeftComponent(athleteScrollPane);

		athleteTable = new JTable(athleteTableModel);
		athleteScrollPane.setViewportView(athleteTable);

		final JScrollPane informationScrollPane = new JScrollPane();
		splitPane.setRightComponent(informationScrollPane);

		final JPanel panel = new JPanel();
		informationScrollPane.setViewportView(panel);
		panel.setLayout(null);

		final JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(16, 34, 291, 16);
		panel.add(lblFirstName);

		athleteFirstNameTextBox = new JTextField();
		athleteFirstNameTextBox.setBounds(16, 50, 291, 28);
		panel.add(athleteFirstNameTextBox);
		athleteFirstNameTextBox.setColumns(10);

		final JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(16, 75, 291, 16);
		panel.add(lblLastName);

		athleteLastNameTxtBox = new JTextField();
		athleteLastNameTxtBox.setColumns(10);
		athleteLastNameTxtBox.setBounds(16, 90, 291, 28);
		panel.add(athleteLastNameTxtBox);

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

		final JLabel lblBirthday = new JLabel("Birth Date");
		lblBirthday.setBounds(16, 118, 85, 22);
		panel.add(lblBirthday);

		final JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(16, 195, 85, 16);
		panel.add(lblGender);

		final JLabel lblScore = new JLabel("Qualifing Score");
		lblScore.setBounds(361, 70, 117, 16);
		panel.add(lblScore);

		final JComboBox<Integer> monthComboBox = new JComboBox<Integer>();
		monthComboBox.setBounds(66, 139, 75, 27);
		panel.add(monthComboBox);

		final JComboBox<String> genderComboBox = new JComboBox<String>();
		genderComboBox.setBounds(66, 191, 98, 27);
		panel.add(genderComboBox);

		final JLabel lblAssociatedEvents = new JLabel("Registered Events");
		lblAssociatedEvents.setBounds(438, 170, 173, 16);
		panel.add(lblAssociatedEvents);

		final JLabel lblAssociatedHeats = new JLabel("Associated Heats");
		lblAssociatedHeats.setBounds(438, 256, 146, 16);
		panel.add(lblAssociatedHeats);

		final JScrollPane eventsScrollPane = new JScrollPane();
		eventsScrollPane.setBounds(361, 194, 309, 56);
		panel.add(eventsScrollPane);

		eventsTable = new JTable(AthletePnl.eventTableModel);
		eventsScrollPane.setViewportView(eventsTable);

		final JScrollPane heatsScrollPane = new JScrollPane();
		heatsScrollPane.setBounds(361, 279, 309, 107);
		panel.add(heatsScrollPane);

		heatsTable = new JTable(AthletePnl.heatTableModel);
		heatsScrollPane.setViewportView(heatsTable);

		final JComboBox<Teacher> groupLeaderComboBox = new JComboBox<Teacher>();
		groupLeaderComboBox.setBounds(16, 276, 291, 27);
		panel.add(groupLeaderComboBox);

		final JLabel lblTeacherInformation = new JLabel("Teacher Information");
		lblTeacherInformation.setBounds(56, 233, 251, 16);
		panel.add(lblTeacherInformation);

		final JComboBox<Integer> dayComboBox = new JComboBox<Integer>();
		dayComboBox.setBounds(176, 139, 131, 27);
		panel.add(dayComboBox);

		final JComboBox<Integer> yearComboBox = new JComboBox<Integer>();
		yearComboBox.setBounds(66, 166, 98, 27);
		panel.add(yearComboBox);

		final JLabel lblMonth = new JLabel("Month");
		lblMonth.setBounds(16, 143, 85, 16);
		panel.add(lblMonth);

		final JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(152, 143, 155, 16);
		panel.add(lblDay);

		final JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(16, 170, 85, 16);
		panel.add(lblYear);

		final JLabel lblEvents = new JLabel("Add Event");
		lblEvents.setBounds(361, 38, 82, 16);
		panel.add(lblEvents);

		final JComboBox<Integer> comboBox = new JComboBox<Integer>();
		comboBox.setBounds(430, 34, 240, 27);
		panel.add(comboBox);

		final JLabel lblFt = new JLabel("ft.");
		lblFt.setBounds(481, 70, 50, 16);
		panel.add(lblFt);

		final JLabel lblIn = new JLabel("In.");
		lblIn.setBounds(586, 70, 61, 16);
		panel.add(lblIn);

		final JComboBox<Integer> inchComboBox = new JComboBox<Integer>();
		inchComboBox.setBounds(609, 66, 61, 27);
		panel.add(inchComboBox);

		final JComboBox<Integer> feetComboBox = new JComboBox<Integer>();
		feetComboBox.setBounds(513, 66, 61, 27);
		panel.add(feetComboBox);

		final JLabel lblMin = new JLabel("min");
		lblMin.setBounds(481, 98, 61, 16);
		panel.add(lblMin);

		final JLabel lblSec = new JLabel("sec");
		lblSec.setBounds(586, 98, 50, 16);
		panel.add(lblSec);

		final JComboBox<Integer> minComboBox = new JComboBox<Integer>();
		minComboBox.setBounds(513, 97, 61, 27);
		panel.add(minComboBox);

		final JComboBox<Integer> secComboBox = new JComboBox<Integer>();
		secComboBox.setBounds(609, 94, 61, 27);
		panel.add(secComboBox);

		final JLabel lblRegisterForEvent = new JLabel("Register for Event");
		lblRegisterForEvent.setBounds(438, 6, 146, 16);
		panel.add(lblRegisterForEvent);

		JComboBox<Teacher> schoolGroupCodeComboBox = new JComboBox<Teacher>();
		schoolGroupCodeComboBox.setBounds(16, 359, 291, 27);
		panel.add(schoolGroupCodeComboBox);

		JComboBox<Teacher> schoolNameComboBox = new JComboBox<Teacher>();
		schoolNameComboBox.setBounds(16, 315, 291, 27);
		panel.add(schoolNameComboBox);

		searchTxtBox = new JTextField();
		searchTxtBox.setColumns(10);

		final JComboBox<String> filterComboBox = new JComboBox<String>();

		final JLabel lblFilterBy = new JLabel("Filter by: ");

		final JButton searchBtn = new SearchButton(
				new MediatorActionListener(), mediator, this);
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
			}
		});

		final JButton btnRegister = new RegisterButton(
				new MediatorActionListener(), mediator, this);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegister.setBounds(440, 131, 117, 29);
		panel.add(btnRegister);
		btnRegister.setText("Register");

		final JButton btnUnregister = new UnregisterButton(
				new MediatorActionListener(), mediator, this);
		btnUnregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUnregister.setBounds(557, 131, 113, 29);
		panel.add(btnUnregister);
		btnUnregister.setText("Unregister");

		final JButton newBtn = new NewButton(new MediatorActionListener(),
				mediator, this);
		newBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		newBtn.setText("New");

		final JButton deleteBtn = new DeleteButton(
				new MediatorActionListener(), mediator, this);
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		deleteBtn.setText("Delete");
		deleteBtn.setEnabled(false);

		final JButton saveBtn = new SaveButton(new MediatorActionListener(),
				mediator, this);
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		saveBtn.setText("Save");

		athleteTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent mevt) {
				if (athleteTable.getSelectedRow() != -1) {
					deleteBtn.setEnabled(true);
				}
				if (athleteTable.getRowCount() > 0)

					if (mevt.getClickCount() == 2) {
						//
						//
					}
			}
		});

		// ************ Generated By Window Builder ************* //
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
}
