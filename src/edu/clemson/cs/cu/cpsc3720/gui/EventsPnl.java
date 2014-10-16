package edu.clemson.cs.cu.cpsc3720.gui;

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
import edu.clemson.cs.cu.cpsc3720.gui.components.SaveButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.SearchButton;
import edu.clemson.cs.cu.cpsc3720.gui.models.AthleteTableModel;
import edu.clemson.cs.cu.cpsc3720.gui.models.EventTableModel;
import edu.clemson.cs.cu.cpsc3720.gui.models.HeatTableModel;
import edu.clemson.cs.cu.cpsc3720.main.Event;
import edu.clemson.cs.cu.cpsc3720.mediator.Mediator;
import edu.clemson.cs.cu.cpsc3720.mediator.MediatorActionListener;

public class EventsPnl extends JPanel {

	private static AthleteTableModel athleteTableModel;
	private static EventTableModel eventTableModel;
	private static HeatTableModel heatTableModel;
	private final JTextField eventCodeTextBox;
	private final JTextField eventNameTextBox;
	private final JComboBox<String> genderCombo;
	private final JComboBox<String> scoreUnitCombo;
	private final JComboBox<Integer> minFtCombo;
	private final JComboBox<Integer> minInCombo;
	private final JComboBox<Integer> minMinCombo;
	private final JComboBox<Integer> minSecCombo;
	private final JComboBox<Integer> maxFtCombo;
	private final JComboBox<Integer> maxInCombo;
	private final JComboBox<Integer> maxMinCombo;
	private final JComboBox<Integer> maxSecCombo;

	private final JTable heatsTable;
	private final Mediator mediator;
	private final JTextField searchTxtBox;
	private final JTable table;
	private double dividerLocation;
	private Event loadedEvent;

	/**
	 * Create the panel.
	 */
	public EventsPnl(final Mediator mediator) {
		this.mediator = mediator;
		this.setName("EventPanel");

		loadedEvent = new Event("", "", "", 0, 0, 0);

		ArrayList<Event> associatedEvents = new ArrayList<Event>();
		associatedEvents.addAll(DaoRepository.getEvents().objects);
		eventTableModel = new EventTableModel(DaoRepository.getEvents().objects);

		final JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(1);
		dividerLocation = 1.8;
		splitPane.setDividerLocation(250);

		final JScrollPane scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);

		table = new JTable(eventTableModel);
		scrollPane.setViewportView(table);

		final JScrollPane informationScrollPane = new JScrollPane();
		splitPane.setRightComponent(informationScrollPane);

		final JPanel panel = new JPanel();
		informationScrollPane.setViewportView(panel);
		panel.setLayout(null);

		final JLabel lblFirstName = new JLabel("Event Code");
		lblFirstName.setBounds(16, 34, 291, 16);
		panel.add(lblFirstName);

		eventCodeTextBox = new JTextField();
		eventCodeTextBox.setBounds(16, 50, 291, 28);
		panel.add(eventCodeTextBox);
		eventCodeTextBox.setColumns(10);

		final JLabel lblLastName = new JLabel("Event Name");
		lblLastName.setBounds(16, 75, 291, 16);
		panel.add(lblLastName);

		eventNameTextBox = new JTextField();
		eventNameTextBox.setColumns(10);
		eventNameTextBox.setBounds(16, 90, 291, 28);
		panel.add(eventNameTextBox);

		final JLabel lblNewLabel = new JLabel("Event Information");
		lblNewLabel.setBounds(56, 6, 251, 16);
		panel.add(lblNewLabel);

		final JLabel lblScore = new JLabel("Minimum Score");
		lblScore.setBounds(16, 198, 117, 16);
		panel.add(lblScore);

		final JLabel lblAssociatedHeats = new JLabel("Associated Heats");
		lblAssociatedHeats.setBounds(372, 6, 146, 16);
		panel.add(lblAssociatedHeats);

		final JScrollPane heatsScrollPane = new JScrollPane();
		heatsScrollPane.setBounds(343, 34, 309, 107);
		panel.add(heatsScrollPane);

		heatsTable = new JTable(EventsPnl.heatTableModel);
		heatsScrollPane.setViewportView(heatsTable);

		final JLabel lblFt = new JLabel("ft.");
		lblFt.setBounds(108, 234, 50, 16);
		panel.add(lblFt);

		final JLabel lblIn = new JLabel("In.");
		lblIn.setBounds(265, 234, 61, 16);
		panel.add(lblIn);

		minInCombo = new JComboBox<Integer>();
		minInCombo.setBounds(173, 230, 80, 27);
		panel.add(minInCombo);

		minFtCombo = new JComboBox<Integer>();
		minFtCombo.setBounds(16, 229, 80, 27);
		panel.add(minFtCombo);

		final JLabel lblMin = new JLabel("min");
		lblMin.setBounds(108, 276, 61, 16);
		panel.add(lblMin);

		final JLabel lblSec = new JLabel("sec");
		lblSec.setBounds(265, 276, 50, 16);
		panel.add(lblSec);

		minMinCombo = new JComboBox<Integer>();
		minMinCombo.setBounds(16, 271, 80, 27);
		panel.add(minMinCombo);

		minSecCombo = new JComboBox<Integer>();
		minSecCombo.setBounds(173, 272, 80, 27);
		panel.add(minSecCombo);

		JLabel lblScoringUnit = new JLabel("Score Unit");
		lblScoringUnit.setBounds(16, 167, 89, 14);
		panel.add(lblScoringUnit);

		scoreUnitCombo = new JComboBox<String>();
		scoreUnitCombo.setBounds(97, 161, 128, 26);
		panel.add(scoreUnitCombo);

		JLabel lblMaximumScore = new JLabel("Maximum Score");
		lblMaximumScore.setBounds(343, 199, 105, 14);
		panel.add(lblMaximumScore);

		maxFtCombo = new JComboBox<Integer>();
		maxFtCombo.setBounds(340, 229, 80, 27);
		panel.add(maxFtCombo);

		maxMinCombo = new JComboBox<Integer>();
		maxMinCombo.setBounds(340, 271, 80, 27);
		panel.add(maxMinCombo);

		JLabel lblFt_1 = new JLabel("ft.");
		lblFt_1.setBounds(432, 235, 46, 14);
		panel.add(lblFt_1);

		JLabel lblMin_1 = new JLabel("min");
		lblMin_1.setBounds(432, 277, 46, 14);
		panel.add(lblMin_1);

		maxInCombo = new JComboBox<Integer>();
		maxInCombo.setBounds(490, 230, 80, 27);
		panel.add(maxInCombo);

		maxSecCombo = new JComboBox<Integer>();
		maxSecCombo.setBounds(490, 272, 80, 26);
		panel.add(maxSecCombo);

		JLabel lblIn_1 = new JLabel("In.");
		lblIn_1.setBounds(580, 235, 46, 14);
		panel.add(lblIn_1);

		JLabel lblSec_1 = new JLabel("sec");
		lblSec_1.setBounds(580, 277, 46, 14);
		panel.add(lblSec_1);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(16, 129, 46, 14);
		panel.add(lblGender);

		genderCombo = new JComboBox<String>();
		genderCombo.setBounds(97, 123, 128, 27);
		panel.add(genderCombo);

		searchTxtBox = new JTextField();
		searchTxtBox.setColumns(10);

		final JButton searchBtn = new SearchButton(
				new MediatorActionListener(), mediator, this);

		final JButton newBtn = new NewButton(new MediatorActionListener(),
				mediator, this);

		final JButton deleteBtn = new DeleteButton(
				new MediatorActionListener(), mediator, this);
		deleteBtn.setEnabled(false);

		final JButton saveBtn = new SaveButton(new MediatorActionListener(),
				mediator, this);

		/* Load initial values */
		{
			genderCombo.addItem("Male");
			genderCombo.addItem("Female");
			genderCombo.setSelectedItem(null);

			scoreUnitCombo.addItem("D");
			scoreUnitCombo.addItem("T");
			scoreUnitCombo.addItem("N");
			scoreUnitCombo.setSelectedItem(null);

			for (Integer i = 0; i <= 9999; i++) {
				minFtCombo.addItem(i);
				maxFtCombo.addItem(i);
			}
			for (Integer i = 0; i <= 99; i++) {
				minInCombo.addItem(i);
				maxInCombo.addItem(i);
			}
			for (Integer i = 0; i <= 9999; i++) {
				minMinCombo.addItem(i);
				maxMinCombo.addItem(i);
			}
			for (Integer i = 0; i <= 99; i++) {
				minSecCombo.addItem(i);
				maxSecCombo.addItem(i);
			}
		}

		/* Click events */
		{
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent mevt) {
					if (table.getSelectedRow() != -1) {
						deleteBtn.setEnabled(true);
					}
					if (table.getRowCount() > 0)
						if (mevt.getClickCount() == 2) {
							setEvent(eventTableModel.getEvent(table
									.getSelectedRow()));
						}
				}
			});
		}

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
																Alignment.TRAILING)
														.addGroup(
																Alignment.LEADING,
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
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.TRAILING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								groupLayout
										.createParallelGroup(Alignment.LEADING)
										.addComponent(searchTxtBox,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(searchBtn,
												GroupLayout.PREFERRED_SIZE, 23,
												GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(splitPane, GroupLayout.PREFERRED_SIZE,
								417, GroupLayout.PREFERRED_SIZE)
						.addGap(6)
						.addGroup(
								groupLayout
										.createParallelGroup(Alignment.LEADING)
										.addComponent(deleteBtn,
												GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(newBtn,
												GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(saveBtn,
												GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE))
						.addGap(88)));
		setLayout(groupLayout);

	}

	public void setEvent(Event e) {
		if (e == null) {
			e = new Event("", "", "", 0, 0, 0);
			table.clearSelection();
		} else {
			int index = DaoRepository.getEvents().objects.indexOf(e);
			if (index == -1)
				table.clearSelection();
			else
				table.setRowSelectionInterval(index, index);
		}
		loadedEvent = e;
		eventCodeTextBox.setText(e.getEventCode());
		eventNameTextBox.setText(e.getEventName());
		scoreUnitCombo.setSelectedItem(e.getScoreUnit());
		minFtCombo.setSelectedIndex(0);
		minFtCombo.setEnabled(false);
		minInCombo.setSelectedIndex(0);
		minInCombo.setEnabled(false);
		minMinCombo.setSelectedIndex(0);
		minMinCombo.setEnabled(false);
		minSecCombo.setSelectedIndex(0);
		minSecCombo.setEnabled(false);
		maxFtCombo.setSelectedIndex(0);
		maxFtCombo.setEnabled(false);
		maxInCombo.setSelectedIndex(0);
		maxInCombo.setEnabled(false);
		maxMinCombo.setSelectedIndex(0);
		maxMinCombo.setEnabled(false);
		maxSecCombo.setSelectedIndex(0);
		maxSecCombo.setEnabled(false);
		if (e.getScoreUnit().equals("D")) {
			minFtCombo
					.setSelectedItem(Event.extractMajorScore(e.getScoreMin()));
			minInCombo
					.setSelectedItem(Event.extractMinorScore(e.getScoreMin()));
			maxFtCombo
					.setSelectedItem(Event.extractMajorScore(e.getScoreMax()));
			maxInCombo
					.setSelectedItem(Event.extractMinorScore(e.getScoreMax()));

			minFtCombo.setEnabled(true);
			minInCombo.setEnabled(true);
			maxFtCombo.setEnabled(true);
			maxInCombo.setEnabled(true);
		} else if (e.getScoreUnit().equals("T")) {
			minMinCombo
					.setSelectedItem(Event.extractMajorScore(e.getScoreMin()));
			minSecCombo
					.setSelectedItem(Event.extractMinorScore(e.getScoreMin()));
			maxMinCombo
					.setSelectedItem(Event.extractMajorScore(e.getScoreMax()));
			maxSecCombo
					.setSelectedItem(Event.extractMinorScore(e.getScoreMax()));

			minMinCombo.setEnabled(true);
			minSecCombo.setEnabled(true);
			maxMinCombo.setEnabled(true);
			maxSecCombo.setEnabled(true);
		}
	}

	public Event getEvent() {
		String eventCode = eventCodeTextBox.getText();
		String eventName = eventNameTextBox.getText();
		String scoreUnit = (String) scoreUnitCombo.getSelectedItem();
		Integer scoreMin = 0;
		Integer scoreMax = 0;
		Integer sortSeq = 0;
		if (scoreUnitCombo.getSelectedItem() != null) {
			if (scoreUnit.equals("D")) {
				if (minFtCombo.getSelectedItem() != null
						&& minInCombo.getSelectedItem() != null) {
					scoreMin = ((Integer) minFtCombo.getSelectedItem()) * 100
							+ (Integer) minInCombo.getSelectedItem();
				}
				if (maxFtCombo.getSelectedItem() != null
						&& maxInCombo.getSelectedItem() != null) {
					scoreMin = ((Integer) maxFtCombo.getSelectedItem()) * 100
							+ (Integer) maxInCombo.getSelectedItem();
				}
			} else if (scoreUnit.equals("T")) {
				if (minMinCombo.getSelectedItem() != null
						&& minSecCombo.getSelectedItem() != null) {
					scoreMin = ((Integer) minMinCombo.getSelectedItem()) * 100
							+ (Integer) minSecCombo.getSelectedItem();
				}
				if (maxMinCombo.getSelectedItem() != null
						&& maxSecCombo.getSelectedItem() != null) {
					scoreMin = ((Integer) maxMinCombo.getSelectedItem()) * 100
							+ (Integer) maxSecCombo.getSelectedItem();
				}
			}
		}
		loadedEvent.setEventCode(eventCode);
		loadedEvent.setEventName(eventName);
		loadedEvent.setScoreUnit(scoreUnit);
		loadedEvent.setScoreMin(scoreMin);
		loadedEvent.setScoreMax(scoreMax);
		loadedEvent.setSortSeq(sortSeq);
		return loadedEvent;
	}
}
