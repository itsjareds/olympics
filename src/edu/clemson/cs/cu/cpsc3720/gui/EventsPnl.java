package edu.clemson.cs.cu.cpsc3720.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class EventsPnl extends JPanel {

	private static final long serialVersionUID = -3288904051405366982L;
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
	private JTable heatTable;

	/**
	 * Create the panel.
	 */
	public EventsPnl(Mediator mediator) {
		athletes = new ArrayList<Athlete>();
		events = new ArrayList<Event>();
		heats = new ArrayList<Heat>();
		this.mediator = mediator;
		this.setName("EventPanel");
		// create some fake athletes to put in the table
		Athlete athlete;
		Event event;
		Heat heat;
		for (int i = 0; i < 100; i++) {
			event = new Event("E" + i, "Some Event", "N D T", new Integer(0),
					new Integer(999), new Integer(i),
					new ArrayList<Registration>(), new ArrayList<Heat>());

			athlete = new Athlete(new Teacher("G0" + i, "Jimmy", "Tim"), "Bob",
					"Clemmings", new Integer(21), "Male", new School(
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

		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(1);
		splitPane.setDividerLocation(160);

		JScrollPane eventScrollPane = new JScrollPane();
		splitPane.setLeftComponent(eventScrollPane);

		table = new JTable(eventTableModel);
		eventScrollPane.setViewportView(table);

		JScrollPane informationScrollPane = new JScrollPane();
		splitPane.setRightComponent(informationScrollPane);

		JPanel panel = new JPanel();
		informationScrollPane.setViewportView(panel);
		panel.setLayout(null);

		JLabel lblFirstName = new JLabel("Event Name");
		lblFirstName.setBounds(6, 53, 101, 16);
		panel.add(lblFirstName);

		athleteFirstNameTextBox = new JTextField();
		athleteFirstNameTextBox.setBounds(119, 47, 152, 28);
		panel.add(athleteFirstNameTextBox);
		athleteFirstNameTextBox.setColumns(10);

		JLabel lblLastName = new JLabel("Event Code");
		lblLastName.setBounds(6, 93, 101, 16);
		panel.add(lblLastName);

		athleteLastNameTxtBox = new JTextField();
		athleteLastNameTxtBox.setColumns(10);
		athleteLastNameTxtBox.setBounds(119, 87, 152, 28);
		panel.add(athleteLastNameTxtBox);

		JLabel lblSchoolName = new JLabel("Minimum Score");
		lblSchoolName.setBounds(6, 208, 101, 16);
		panel.add(lblSchoolName);

		schoolNameTxtBox = new JTextField();
		schoolNameTxtBox.setColumns(10);
		schoolNameTxtBox.setBounds(119, 202, 152, 28);
		panel.add(schoolNameTxtBox);

		JLabel lblNewLabel = new JLabel("Event Information");
		lblNewLabel.setBounds(6, 6, 265, 16);
		panel.add(lblNewLabel);

		JLabel lblGroupCode = new JLabel("Maximum Score");
		lblGroupCode.setBounds(6, 275, 101, 16);
		panel.add(lblGroupCode);

		broupCodeTxtBox = new JTextField();
		broupCodeTxtBox.setColumns(10);
		broupCodeTxtBox.setBounds(119, 269, 152, 28);
		panel.add(broupCodeTxtBox);

		JLabel lblAge = new JLabel("Score Unit");
		lblAge.setBounds(6, 150, 61, 16);
		panel.add(lblAge);

		JComboBox<Integer> ageComboBox = new JComboBox<Integer>();
		ageComboBox.setBounds(122, 145, 82, 27);
		panel.add(ageComboBox);

		JLabel lblNewLabel_3 = new JLabel("Associated Heats");
		lblNewLabel_3.setBounds(366, 26, 146, 16);
		panel.add(lblNewLabel_3);

		JScrollPane heatsScrollPane = new JScrollPane();
		heatsScrollPane.setBounds(362, 53, 195, 208);
		panel.add(heatsScrollPane);

		heatTable = new JTable(new HeatTableModel(heats));
		heatsScrollPane.setViewportView(heatTable);

		JButton btnAdd = new NewButton(new MediatorActionListener(), mediator,
				this);
		btnAdd.setText("Add");
		btnAdd.setBounds(366, 272, 87, 23);
		panel.add(btnAdd);

		JButton btnDelete = new DeleteButton(new MediatorActionListener(),
				mediator, this);
		btnDelete.setText("Delete");
		btnDelete.setBounds(463, 272, 89, 23);
		panel.add(btnDelete);

		JButton newBtn = new NewButton(new MediatorActionListener(), mediator,
				this);
		newBtn.setText("New");

		JButton deleteBtn = new DeleteButton(new MediatorActionListener(),
				mediator, this);
		deleteBtn.setText("Delete");

		searchTxtBox = new JTextField();
		searchTxtBox.setColumns(10);

		JButton searchBtn = new SearchButton(new MediatorActionListener(),
				mediator, this);
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
																Alignment.LEADING)
														.addComponent(
																splitPane,
																Alignment.TRAILING,
																GroupLayout.DEFAULT_SIZE,
																660,
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
																				searchTxtBox,
																				GroupLayout.PREFERRED_SIZE,
																				96,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				searchBtn)))
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
																searchTxtBox,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(searchBtn))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(splitPane)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(saveBtn,
																0, 0,
																Short.MAX_VALUE)
														.addComponent(
																newBtn,
																GroupLayout.PREFERRED_SIZE,
																60,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																deleteBtn,
																GroupLayout.PREFERRED_SIZE,
																60,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));
		setLayout(groupLayout);

	}
}
