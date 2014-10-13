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
import edu.clemson.cs.cu.cpsc3720.mediator.Mediator;
import edu.clemson.cs.cu.cpsc3720.mediator.MediatorActionListener;

public class HeatPnl extends JPanel {

	private static AthleteTableModel athleteTableModel;
	private static EventTableModel eventTableModel;
	private static HeatTableModel heatTableModel;
	private final JTextField athleteLastNameTxtBox;
	private final ArrayList<Athlete> athletes;
	private final ArrayList<Event> events;
	private final ArrayList<Heat> heats;
	private final Mediator mediator;
	private final JTextField searchTxtBox;
	private final JTable table;
	private double dividerLocation;

	/**
	 * Create the panel.
	 */
	public HeatPnl(final Mediator mediator) {
		this.mediator = mediator;
		this.setName("HeatPanel");

		events = DaoRepository.getEvents().objects;
		athletes = DaoRepository.getAthletes().objects;
		final ArrayList<Registration> regs = athletes.get(0).getRegistrations();
		for (final Registration r : regs) {
			events.add(r.getEvent());
		}
		heats = DaoRepository.getHeats().objects;
		
		athleteTableModel = new AthleteTableModel(athletes);
		eventTableModel = new EventTableModel(events);
		heatTableModel = new HeatTableModel(heats);

		final JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(1);
		dividerLocation = 0.8;
		splitPane.setDividerLocation(250);

		final JScrollPane athleteScrollPane = new JScrollPane();
		splitPane.setLeftComponent(athleteScrollPane);

		table = new JTable(heatTableModel);
		athleteScrollPane.setViewportView(table);

		final JScrollPane informationScrollPane = new JScrollPane();
		splitPane.setRightComponent(informationScrollPane);

		final JPanel panel = new JPanel();
		informationScrollPane.setViewportView(panel);
		panel.setLayout(null);

		final JLabel lblFirstName = new JLabel("Event Code");
		lblFirstName.setBounds(16, 109, 291, 16);
		panel.add(lblFirstName);

		final JLabel lblLastName = new JLabel("Event Name");
		lblLastName.setBounds(16, 33, 291, 16);
		panel.add(lblLastName);

		athleteLastNameTxtBox = new JTextField();
		athleteLastNameTxtBox.setColumns(10);
		athleteLastNameTxtBox.setBounds(103, 103, 78, 28);
		panel.add(athleteLastNameTxtBox);

		final JLabel lblNewLabel = new JLabel("Heat Information");
		lblNewLabel.setBounds(56, 6, 251, 16);
		panel.add(lblNewLabel);

		final JLabel lblScore = new JLabel("Minimum Age");
		lblScore.setBounds(16, 198, 117, 16);
		panel.add(lblScore);

		final JComboBox<Integer> feetComboBox = new JComboBox<Integer>();
		feetComboBox.setBounds(110, 193, 61, 27);
		panel.add(feetComboBox);
		
		JLabel lblScoringUnit = new JLabel("Gender");
		lblScoringUnit.setBounds(16, 151, 89, 14);
		panel.add(lblScoringUnit);
		
		JLabel lblMaximumScore = new JLabel("Maximum Age");
		lblMaximumScore.setBounds(16, 257, 105, 14);
		panel.add(lblMaximumScore);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(110, 251, 61, 27);
		panel.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(110, 145, 61, 27);
		panel.add(comboBox_2);
		
		JLabel lblFt_1 = new JLabel("Time");
		lblFt_1.setBounds(331, 151, 46, 14);
		panel.add(lblFt_1);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(378, 145, 89, 27);
		panel.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(331, 54, 68, 27);
		panel.add(comboBox_4);
		
		JLabel lblIn_1 = new JLabel("Heat Number");
		lblIn_1.setBounds(331, 34, 89, 14);
		panel.add(lblIn_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(16, 53, 251, 28);
		panel.add(comboBox);

		searchTxtBox = new JTextField();
		searchTxtBox.setColumns(10);

		final JButton searchBtn = new SearchButton(
				new MediatorActionListener(), mediator, this);
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
			}
		});

		final JButton newBtn = new NewButton(new MediatorActionListener(),
				mediator, this);
		newBtn.setText("New");

		final JButton deleteBtn = new DeleteButton(
				new MediatorActionListener(), mediator, this);
		deleteBtn.setText("Delete");

		final JButton saveBtn = new SaveButton(new MediatorActionListener(),
				mediator, this);
		saveBtn.setText("Save");

		// ************ Generated By Window Builder ************* //
		final GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(newBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(deleteBtn, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(saveBtn, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(searchTxtBox, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchBtn, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
						.addComponent(splitPane, GroupLayout.PREFERRED_SIZE, 937, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(searchTxtBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchBtn, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(splitPane, GroupLayout.PREFERRED_SIZE, 417, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(deleteBtn, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(saveBtn, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(newBtn, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}

