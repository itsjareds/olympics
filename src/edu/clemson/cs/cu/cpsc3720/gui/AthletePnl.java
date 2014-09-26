package edu.clemson.cs.cu.cpsc3720.gui;

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

import edu.clemson.cs.cu.cpsc3720.gui.models.AthleteTableModel;
import edu.clemson.cs.cu.cpsc3720.main.Athlete;

public class AthletePnl extends JPanel {
	private JTextField txtHarry;
	private JTextField txtPotter;
	private JTextField txtHogwarts;
	private JTextField txtProfDumbledore;
	private JTable table;
	private static AthleteTableModel athleteTableModel;
	private ArrayList<Athlete> athletes = new ArrayList<Athlete>();
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public AthletePnl() {

		// create some fake athletes to put in the table
		Athlete athlete;
		for (int i = 0; i < 10; i++) {
			athlete = new Athlete();
			athletes.add(athlete);
		}
		athleteTableModel = new AthleteTableModel(athletes);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(1);
		splitPane.setDividerLocation(160);

		JScrollPane athleteScrollPane = new JScrollPane();
		splitPane.setLeftComponent(athleteScrollPane);

		table = new JTable(athleteTableModel);
		// TableColumnModel columns = table.getColumnModel();
		// for (int i = 0; i < columns.getColumnCount(); i++) {
		// columns.getColumn(i).setMaxWidth(80);
		// columns.getColumn(i).setMinWidth(60);
		// }
		athleteScrollPane.setViewportView(table);

		JLabel lblNewLabel_1 = new JLabel("New label");
		athleteScrollPane.setColumnHeaderView(lblNewLabel_1);

		JScrollPane informationScrollPane = new JScrollPane();
		splitPane.setRightComponent(informationScrollPane);

		JPanel panel = new JPanel();
		informationScrollPane.setViewportView(panel);
		panel.setLayout(null);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(6, 53, 101, 16);
		panel.add(lblFirstName);

		txtHarry = new JTextField();
		txtHarry.setText("Harry");
		txtHarry.setBounds(119, 47, 152, 28);
		panel.add(txtHarry);
		txtHarry.setColumns(10);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(6, 87, 101, 16);
		panel.add(lblLastName);

		txtPotter = new JTextField();
		txtPotter.setText("Potter");
		txtPotter.setColumns(10);
		txtPotter.setBounds(119, 81, 152, 28);
		panel.add(txtPotter);

		JLabel lblSchoolName = new JLabel("School Name");
		lblSchoolName.setBounds(6, 217, 101, 16);
		panel.add(lblSchoolName);

		txtHogwarts = new JTextField();
		txtHogwarts.setText("Hogwarts");
		txtHogwarts.setColumns(10);
		txtHogwarts.setBounds(119, 211, 152, 28);
		panel.add(txtHogwarts);

		JLabel lblGroupLeader = new JLabel("Group Leader");
		lblGroupLeader.setBounds(6, 251, 101, 16);
		panel.add(lblGroupLeader);

		txtProfDumbledore = new JTextField();
		txtProfDumbledore.setText("Prof. Dumbledore");
		txtProfDumbledore.setColumns(10);
		txtProfDumbledore.setBounds(119, 245, 152, 28);
		panel.add(txtProfDumbledore);

		JLabel lblNewLabel = new JLabel("Athlete Information");
		lblNewLabel.setBounds(6, 6, 265, 16);
		panel.add(lblNewLabel);

		JLabel lblGroupCode = new JLabel("Group Code");
		lblGroupCode.setBounds(6, 285, 101, 16);
		panel.add(lblGroupCode);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(119, 279, 152, 28);
		panel.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(119, 313, 152, 28);
		panel.add(textField_2);

		JLabel lblEventCode = new JLabel("Event Name");
		lblEventCode.setBounds(6, 319, 101, 16);
		panel.add(lblEventCode);

		JLabel lblEventCode_1 = new JLabel("Event Code");
		lblEventCode_1.setBounds(6, 353, 101, 16);
		panel.add(lblEventCode_1);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(119, 347, 152, 28);
		panel.add(textField_3);

		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(6, 115, 61, 16);
		panel.add(lblAge);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(6, 149, 61, 16);
		panel.add(lblGender);

		JLabel lblScore = new JLabel("Score");
		lblScore.setBounds(6, 183, 61, 16);
		panel.add(lblScore);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(119, 111, 82, 27);
		panel.add(comboBox_1);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(119, 145, 82, 27);
		panel.add(comboBox_2);

		textField_4 = new JTextField();
		textField_4.setBounds(119, 177, 152, 28);
		panel.add(textField_4);
		textField_4.setColumns(10);

		JButton btnNewButton = new JButton("New");

		JButton btnEdit = new JButton("Edit");

		JButton btnDestroy = new JButton("Delete");

		textField = new JTextField();
		textField.setColumns(10);

		JButton btnNewButton_1 = new JButton("Search");

		JComboBox comboBox = new JComboBox();

		JLabel lblNewLabel_2 = new JLabel("Filter by: ");
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
																				btnNewButton,
																				GroupLayout.PREFERRED_SIZE,
																				64,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				btnEdit,
																				GroupLayout.PREFERRED_SIZE,
																				64,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				btnDestroy))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				lblNewLabel_2)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				comboBox,
																				GroupLayout.PREFERRED_SIZE,
																				117,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				textField,
																				GroupLayout.DEFAULT_SIZE,
																				196,
																				Short.MAX_VALUE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				btnNewButton_1,
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
																comboBox,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																textField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																btnNewButton_1)
														.addComponent(
																lblNewLabel_2))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(splitPane,
												GroupLayout.DEFAULT_SIZE, 461,
												Short.MAX_VALUE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																btnNewButton,
																GroupLayout.PREFERRED_SIZE,
																60,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																btnEdit,
																GroupLayout.PREFERRED_SIZE,
																60,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																btnDestroy,
																GroupLayout.PREFERRED_SIZE,
																60,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));
		setLayout(groupLayout);

	}
}
