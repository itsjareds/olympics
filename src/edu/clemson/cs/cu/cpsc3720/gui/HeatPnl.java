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
import edu.clemson.cs.cu.cpsc3720.mediator.Mediator;
import edu.clemson.cs.cu.cpsc3720.mediator.MediatorActionListener;

public class HeatPnl extends JPanel {
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

	/**
	 * Create the panel.
	 */
	public HeatPnl(Mediator mediator) {
		athletes = new ArrayList<Athlete>();
		events = new ArrayList<Event>();
		heats = new ArrayList<Heat>();
		this.mediator = mediator;
		this.setName("HeatPanel");

		athletes = DaoRepository.getAthletes().objects;
		events = DaoRepository.getEvents().objects;
		heats = DaoRepository.getHeats().objects;

		athleteTableModel = new AthleteTableModel(athletes);
		eventTableModel = new EventTableModel(events);
		heatTableModel = new HeatTableModel(heats);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(1);
		splitPane.setDividerLocation(160);

		JScrollPane eventScrollPane = new JScrollPane();
		splitPane.setLeftComponent(eventScrollPane);

		table = new JTable(heatTableModel);
		eventScrollPane.setViewportView(table);

		JScrollPane informationScrollPane = new JScrollPane();
		splitPane.setRightComponent(informationScrollPane);

		JPanel panel = new JPanel();
		informationScrollPane.setViewportView(panel);
		panel.setLayout(null);

		JLabel lblFirstName = new JLabel("Event Name");
		lblFirstName.setBounds(6, 54, 101, 16);
		panel.add(lblFirstName);

		athleteFirstNameTextBox = new JTextField();
		athleteFirstNameTextBox.setBounds(105, 48, 152, 28);
		panel.add(athleteFirstNameTextBox);
		athleteFirstNameTextBox.setColumns(10);

		JLabel lblLastName = new JLabel("Event Code");
		lblLastName.setBounds(6, 104, 101, 16);
		panel.add(lblLastName);

		athleteLastNameTxtBox = new JTextField();
		athleteLastNameTxtBox.setColumns(10);
		athleteLastNameTxtBox.setBounds(105, 98, 152, 28);
		panel.add(athleteLastNameTxtBox);

		JLabel lblSchoolName = new JLabel("Minimum Age");
		lblSchoolName.setBounds(6, 279, 101, 22);
		panel.add(lblSchoolName);

		schoolNameTxtBox = new JTextField();
		schoolNameTxtBox.setColumns(10);
		schoolNameTxtBox.setBounds(105, 319, 52, 28);
		panel.add(schoolNameTxtBox);

		JLabel lblNewLabel = new JLabel("Heat Information");
		lblNewLabel.setBounds(6, 11, 265, 16);
		panel.add(lblNewLabel);

		JLabel lblGroupCode = new JLabel("Maximum Age");
		lblGroupCode.setBounds(6, 325, 101, 16);
		panel.add(lblGroupCode);

		broupCodeTxtBox = new JTextField();
		broupCodeTxtBox.setColumns(10);
		broupCodeTxtBox.setBounds(105, 276, 52, 28);
		panel.add(broupCodeTxtBox);

		JLabel lblAge = new JLabel("Gender");
		lblAge.setBounds(6, 170, 61, 16);
		panel.add(lblAge);

		JComboBox<Integer> ageComboBox = new JComboBox<Integer>();
		ageComboBox.setToolTipText("B");
		ageComboBox.setBounds(105, 165, 61, 27);
		panel.add(ageComboBox);

		JLabel lblNewLabel_1 = new JLabel("Time");
		lblNewLabel_1.setBounds(6, 228, 46, 14);
		panel.add(lblNewLabel_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(103, 221, 87, 28);
		panel.add(comboBox);

		searchTxtBox = new JTextField();
		searchTxtBox.setColumns(10);

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
