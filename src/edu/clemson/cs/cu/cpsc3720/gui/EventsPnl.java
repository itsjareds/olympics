package edu.clemson.cs.cu.cpsc3720.gui;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.gui.components.AddButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.ClearButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.DeleteButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.NewButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.RemoveButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.SaveButton;
import edu.clemson.cs.cu.cpsc3720.gui.models.EventTableModel;
import edu.clemson.cs.cu.cpsc3720.gui.models.HeatTableModel;
import edu.clemson.cs.cu.cpsc3720.main.Event;
import edu.clemson.cs.cu.cpsc3720.main.Heat;
import edu.clemson.cs.cu.cpsc3720.mediator.Mediator;
import edu.clemson.cs.cu.cpsc3720.mediator.MediatorActionListener;

/**
 */
@SuppressWarnings("serial")
public class EventsPnl extends JPanel {

	private final JTextField eventCodeTextBox;
	private final JTextField eventNameTextBox;
	private final JComboBox<String> scoreUnitCombo;
	private final JComboBox<Integer> minFtCombo;
	private final JComboBox<Integer> minInCombo;
	private final JComboBox<Integer> minMinCombo;
	private final JComboBox<Integer> minSecCombo;
	private final JComboBox<Integer> maxFtCombo;
	private final JComboBox<Integer> maxInCombo;
	private final JComboBox<Integer> maxMinCombo;
	private final JComboBox<Integer> maxSecCombo;

	private final JComboBox<Integer> minAgeCombo;
	private final JComboBox<Integer> maxAgeCombo;
	private final JComboBox<String> genderCombo;
	private final JComboBox<Integer> hourCombo;
	private final JComboBox<Integer> minCombo;
	private final JComboBox<Integer> divisionCombo;

	private final JButton newBtn;
	private final JButton saveBtn;
	private final JButton deleteBtn;
	private final JButton addBtn;
	private final JButton removeBtn;
	private final JButton clearBtn;

	private final Mediator mediator;
	private final JSplitPane splitPane;

	private EventTableModel eventTableModel;
	private HeatTableModel heatTableModel;
	private final JTable heatsTable;
	private final JTable eventsTable;
	private Event loadedEvent;
	private Heat loadedHeat;

	/**
	 * Create the panel.
	 * @param mediator Mediator
	 */
	public EventsPnl(final Mediator mediator) {
		this.mediator = mediator;
		this.setName("EventPanel");

		loadedEvent = new Event("", "", "", 0, 0, 0);

		eventTableModel = new EventTableModel(
				DaoRepository.getEventsDao().objects);
		heatTableModel = new HeatTableModel(new ArrayList<Heat>());

		/* Add components */
		{
			splitPane = new JSplitPane();
			splitPane.setDividerSize(1);
			double dividerLocation = 1.8;
			splitPane.setDividerLocation(250);

			final JScrollPane scrollPane = new JScrollPane();
			splitPane.setLeftComponent(scrollPane);

			eventsTable = new JTable(eventTableModel);
			scrollPane.setViewportView(eventsTable);

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
			lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
			lblNewLabel.setBounds(56, 6, 251, 16);
			panel.add(lblNewLabel);

			final JLabel lblScore = new JLabel("Minimum Score");
			lblScore.setBounds(16, 181, 117, 16);
			panel.add(lblScore);

			final JLabel lblAssociatedHeats = new JLabel("Associated Heats");
			lblAssociatedHeats
					.setFont(new Font("Lucida Grande", Font.BOLD, 13));
			lblAssociatedHeats.setBounds(473, 214, 146, 16);
			panel.add(lblAssociatedHeats);

			final JScrollPane heatsScrollPane = new JScrollPane();
			heatsScrollPane.setBounds(331, 236, 343, 167);
			panel.add(heatsScrollPane);

			heatsTable = new JTable(heatTableModel);
			heatsScrollPane.setViewportView(heatsTable);

			final JLabel lblFt = new JLabel("ft.");
			lblFt.setBounds(108, 214, 50, 16);
			panel.add(lblFt);

			final JLabel lblIn = new JLabel("In.");
			lblIn.setBounds(265, 214, 61, 16);
			panel.add(lblIn);

			minInCombo = new JComboBox<Integer>();
			minInCombo.setBounds(173, 210, 80, 27);
			panel.add(minInCombo);

			minFtCombo = new JComboBox<Integer>();
			minFtCombo.setBounds(16, 209, 80, 27);
			panel.add(minFtCombo);

			final JLabel lblMin = new JLabel("min");
			lblMin.setBounds(108, 256, 61, 16);
			panel.add(lblMin);

			final JLabel lblSec = new JLabel("sec");
			lblSec.setBounds(265, 256, 50, 16);
			panel.add(lblSec);

			minMinCombo = new JComboBox<Integer>();
			minMinCombo.setBounds(16, 251, 80, 27);
			panel.add(minMinCombo);

			minSecCombo = new JComboBox<Integer>();
			minSecCombo.setBounds(173, 252, 80, 27);
			panel.add(minSecCombo);

			JLabel lblScoringUnit = new JLabel("Score Unit");
			lblScoringUnit.setBounds(16, 148, 89, 14);
			panel.add(lblScoringUnit);

			scoreUnitCombo = new JComboBox<String>();
			scoreUnitCombo.setBounds(98, 143, 128, 26);
			panel.add(scoreUnitCombo);

			JLabel lblMaximumScore = new JLabel("Maximum Score");
			lblMaximumScore.setBounds(19, 291, 105, 14);
			panel.add(lblMaximumScore);

			maxFtCombo = new JComboBox<Integer>();
			maxFtCombo.setBounds(16, 321, 80, 27);
			panel.add(maxFtCombo);

			maxMinCombo = new JComboBox<Integer>();
			maxMinCombo.setBounds(16, 363, 80, 27);
			panel.add(maxMinCombo);

			JLabel lblFt_1 = new JLabel("ft.");
			lblFt_1.setBounds(108, 327, 46, 14);
			panel.add(lblFt_1);

			JLabel lblMin_1 = new JLabel("min");
			lblMin_1.setBounds(108, 369, 46, 14);
			panel.add(lblMin_1);

			maxInCombo = new JComboBox<Integer>();
			maxInCombo.setBounds(173, 321, 80, 27);
			panel.add(maxInCombo);

			maxSecCombo = new JComboBox<Integer>();
			maxSecCombo.setBounds(173, 363, 80, 26);
			panel.add(maxSecCombo);

			JLabel lblIn_1 = new JLabel("In.");
			lblIn_1.setBounds(261, 327, 46, 14);
			panel.add(lblIn_1);

			JLabel lblSec_1 = new JLabel("sec");
			lblSec_1.setBounds(261, 369, 46, 14);
			panel.add(lblSec_1);

			JLabel lblAddNewEvent = new JLabel("Add New Heat");
			lblAddNewEvent.setFont(new Font("Lucida Grande", Font.BOLD, 13));
			lblAddNewEvent.setBounds(486, 6, 105, 16);
			panel.add(lblAddNewEvent);

			JLabel lblMinimumAge = new JLabel("Minimum Age");
			lblMinimumAge.setBounds(364, 40, 97, 16);
			panel.add(lblMinimumAge);

			JLabel lblMaximumAge = new JLabel("Maximum Age");
			lblMaximumAge.setBounds(364, 68, 97, 16);
			panel.add(lblMaximumAge);

			JLabel lblGender = new JLabel("Gender");
			lblGender.setBounds(364, 94, 61, 16);
			panel.add(lblGender);

			minAgeCombo = new JComboBox<Integer>();
			minAgeCombo.setBounds(565, 37, 80, 26);
			panel.add(minAgeCombo);

			maxAgeCombo = new JComboBox<Integer>();
			maxAgeCombo.setBounds(565, 63, 80, 26);
			panel.add(maxAgeCombo);

			genderCombo = new JComboBox<String>();
			genderCombo.setBounds(473, 89, 172, 26);
			panel.add(genderCombo);

			JLabel lblTime = new JLabel("Time");
			lblTime.setBounds(364, 120, 61, 16);
			panel.add(lblTime);

			hourCombo = new JComboBox<Integer>();
			hourCombo.setBounds(473, 104, 80, 50);
			panel.add(hourCombo);

			JLabel lblH = new JLabel("h");
			lblH.setBounds(551, 121, 13, 16);
			panel.add(lblH);

			minCombo = new JComboBox<Integer>();
			minCombo.setBounds(565, 115, 80, 26);
			panel.add(minCombo);

			JLabel lblM = new JLabel("m");
			lblM.setBounds(643, 121, 19, 16);
			panel.add(lblM);

			JLabel lblDivision = new JLabel("Division");
			lblDivision.setBounds(364, 146, 61, 16);
			panel.add(lblDivision);

			divisionCombo = new JComboBox<Integer>();
			divisionCombo.setBounds(565, 141, 80, 26);
			panel.add(divisionCombo);

			newBtn = new NewButton(new MediatorActionListener(), mediator, this);

			deleteBtn = new DeleteButton(new MediatorActionListener(),
					mediator, this);
			deleteBtn.setEnabled(false);

			saveBtn = new SaveButton(new MediatorActionListener(), mediator,
					this);

			addBtn = new AddButton(new MediatorActionListener(), mediator, this);
			addBtn.setBounds(395, 173, 80, 29);
			addBtn.setEnabled(false);
			panel.add(addBtn);

			clearBtn = new ClearButton(new MediatorActionListener(), mediator,
					this);
			clearBtn.setBounds(481, 173, 80, 29);
			clearBtn.setEnabled(false);
			panel.add(clearBtn);

			removeBtn = new RemoveButton(new MediatorActionListener(),
					mediator, this);
			removeBtn.setEnabled(false);
			removeBtn.setBounds(565, 173, 80, 29);
			panel.add(removeBtn);
		}

		/* Load initial values */
		{
			scoreUnitCombo.addItem("N");
			scoreUnitCombo.addItem("D");
			scoreUnitCombo.addItem("T");
			scoreUnitCombo.setSelectedItem(null);

			// Feet
			for (Integer i = 0; i <= 9999; i++) {
				minFtCombo.addItem(i);
				maxFtCombo.addItem(i);
			}
			// Inches
			for (Integer i = 0; i <= 99; i++) {
				minInCombo.addItem(i);
				maxInCombo.addItem(i);
			}
			// Hours
			for (Integer i = 0; i <= 24; i++) {
				hourCombo.addItem(i);
			}
			// Minutes
			for (Integer i = 0; i <= 9999; i++) {
				minMinCombo.addItem(i);
				maxMinCombo.addItem(i);
				minCombo.addItem(i);
			}
			// Seconds
			for (Integer i = 0; i <= 99; i++) {
				minSecCombo.addItem(i);
				maxSecCombo.addItem(i);
			}
			// Age
			for (Integer i = 1; i <= 99; i++) {
				minAgeCombo.addItem(i);
				maxAgeCombo.addItem(i);
			}
			// Gender
			genderCombo.addItem("Both");
			genderCombo.addItem("Male");
			genderCombo.addItem("Female");
			// Division
			for (Integer i = 1; i <= 10; i++) {
				divisionCombo.addItem(i);
			}
		}

		/* EventsTable selection listener */
		{
			eventsTable.getSelectionModel().addListSelectionListener(
					new ListSelectionListener() {
						@Override
						public void valueChanged(ListSelectionEvent e) {
							if (eventsTable.getSelectedRow() != -1) {
								deleteBtn.setEnabled(true);
								addBtn.setEnabled(true);
								clearBtn.setEnabled(true);
								if (eventsTable.getRowCount() > 0) {
									setEvent(eventTableModel
											.getEvent(eventsTable
													.getSelectedRow()));
								}
							} else {
								deleteBtn.setEnabled(false);
								addBtn.setEnabled(false);
								clearBtn.setEnabled(false);
							}
						}
					});
		}

		/* HeatTable selection listener */
		{
			heatsTable.getSelectionModel().addListSelectionListener(
					new ListSelectionListener() {
						@Override
						public void valueChanged(ListSelectionEvent e) {
							if (heatsTable.getSelectedRow() != -1) {
								removeBtn.setEnabled(true);
								if (heatsTable.getRowCount() > 0) {
									setHeat(heatTableModel.getHeat(heatsTable
											.getSelectedRow()));
								}
							} else {
								removeBtn.setEnabled(false);
								setHeat(null);
							}
						}
					});
		}

		/* Score unit combo change listener */
		{
			scoreUnitCombo.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED)
						setUnits();
				}
			});
		}

		/* Set initially loaded event to empty */
		setEvent(null);
		setHeat(null);

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
										.addContainerGap(19, Short.MAX_VALUE)));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(splitPane,
												GroupLayout.DEFAULT_SIZE, 505,
												Short.MAX_VALUE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																newBtn,
																GroupLayout.PREFERRED_SIZE,
																31,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																deleteBtn,
																GroupLayout.PREFERRED_SIZE,
																31,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																saveBtn,
																GroupLayout.PREFERRED_SIZE,
																31,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));
		setLayout(groupLayout);
	}

	private void setUnits() {
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

		if (scoreUnitCombo.getSelectedItem().equals("D")) {
			minFtCombo.setSelectedItem(Event.extractMajorScore(loadedEvent
					.getScoreMin()));
			minInCombo.setSelectedItem(Event.extractMinorScore(loadedEvent
					.getScoreMin()));
			maxFtCombo.setSelectedItem(Event.extractMajorScore(loadedEvent
					.getScoreMax()));
			maxInCombo.setSelectedItem(Event.extractMinorScore(loadedEvent
					.getScoreMax()));

			minFtCombo.setEnabled(true);
			minInCombo.setEnabled(true);
			maxFtCombo.setEnabled(true);
			maxInCombo.setEnabled(true);
		} else if (scoreUnitCombo.getSelectedItem().equals("T")) {
			minMinCombo.setSelectedItem(Event.extractMajorScore(loadedEvent
					.getScoreMin()));
			minSecCombo.setSelectedItem(Event.extractMinorScore(loadedEvent
					.getScoreMin()));
			maxMinCombo.setSelectedItem(Event.extractMajorScore(loadedEvent
					.getScoreMax()));
			maxSecCombo.setSelectedItem(Event.extractMinorScore(loadedEvent
					.getScoreMax()));

			minMinCombo.setEnabled(true);
			minSecCombo.setEnabled(true);
			maxMinCombo.setEnabled(true);
			maxSecCombo.setEnabled(true);
		}
	}

	/**
	 * Method setEvent.
	 * @param e Event
	 */
	public void setEvent(Event e) {
		/* Fill event form */
		if (e == null) {
			e = new Event("", "", "N", 0, 0, 0);
			eventsTable.clearSelection();
		} else {
			int index = eventTableModel.indexOf(e);
			if (index == -1)
				eventsTable.clearSelection();
			else
				eventsTable.setRowSelectionInterval(index, index);
		}
		loadedEvent = e;
		eventCodeTextBox.setText(e.getEventCode());
		eventNameTextBox.setText(e.getEventName());
		scoreUnitCombo.setSelectedItem(e.getScoreUnit());

		setHeat(null);
		loadHeats(e);
	}

	/**
	 * Method getEvent.
	 * @return Event
	 */
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
					scoreMax = ((Integer) maxFtCombo.getSelectedItem()) * 100
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
					scoreMax = ((Integer) maxMinCombo.getSelectedItem()) * 100
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

	/**
	 * Method setHeat.
	 * @param h Heat
	 */
	public void setHeat(Heat h) {
		/* Fill heat form */
		if (h == null) {
			h = new Heat(loadedEvent.getDbId(), "", 1, 1, "", 1);
			heatsTable.clearSelection();
		} else {
			int index = heatTableModel.indexOf(h);
			if (index == -1)
				heatsTable.clearSelection();
			else
				heatsTable.setRowSelectionInterval(index, index);
		}
		loadedHeat = h;
		minAgeCombo.setSelectedItem(h.getMinAge());
		maxAgeCombo.setSelectedItem(h.getMaxAge());
		if (h.getGender().equals("M"))
			genderCombo.setSelectedItem("Male");
		else if (h.getGender().equals("F"))
			genderCombo.setSelectedItem("Female");
		else if (h.getGender().equals("B"))
			genderCombo.setSelectedItem("Both");
		hourCombo.setSelectedItem(Heat.extractHour(h.getTime()));
		minCombo.setSelectedItem(Heat.extractMinute(h.getTime()));
		divisionCombo.setSelectedItem(h.getNumHeats());
	}

	/**
	 * Method getHeat.
	 * @return Heat
	 */
	public Heat getHeat() {
		Integer minAge = (Integer) minAgeCombo.getSelectedItem();
		Integer maxAge = (Integer) maxAgeCombo.getSelectedItem();
		String gender = (String) genderCombo.getSelectedItem();
		String time = Heat.createTimeString(
				(Integer) hourCombo.getSelectedItem(),
				(Integer) minCombo.getSelectedItem(), 0);
		Integer division = (Integer) divisionCombo.getSelectedItem();
		loadedHeat.setMinAge(minAge);
		loadedHeat.setMaxAge(maxAge);
		if (gender.equals("Male"))
			loadedHeat.setGender("M");
		else if (gender.equals("Female"))
			loadedHeat.setGender("F");
		else if (gender.equals("Both"))
			loadedHeat.setGender("B");
		loadedHeat.setTime(time);
		loadedHeat.setNumHeats(division);
		return loadedHeat;
	}

	/**
	 * Method loadHeats.
	 * @param e Event
	 */
	public void loadHeats(Event e) {
		/* Fill heats table */
		ArrayList<Heat> heats = new ArrayList<Heat>();
		if (e.getDbId() != null) {
			for (Heat h : DaoRepository.getHeatsDao().objects) {
				if (h.getEventRef() != null
						&& h.getEventRef().equals(e.getDbId()))
					heats.add(h);
			}
		}
		heatTableModel.setHeats(heats);
	}

	/**
	 * Method getEventTableModel.
	 * @return EventTableModel
	 */
	public EventTableModel getEventTableModel() {
		return eventTableModel;
	}

	/**
	 * Method getHeatTableModel.
	 * @return HeatTableModel
	 */
	public HeatTableModel getHeatTableModel() {
		return heatTableModel;
	}

}
