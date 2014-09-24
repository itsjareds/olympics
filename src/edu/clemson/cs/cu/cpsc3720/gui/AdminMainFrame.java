package edu.clemson.cs.cu.cpsc3720.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class AdminMainFrame extends JFrame {

	private static final long serialVersionUID = 1788257087454523343L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AdminMainFrame() {
		setTitle("Administrator View T-J 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 804, 587);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		AthletePnl athletePnl = new AthletePnl();
		tabbedPane.addTab("Athletes", null, athletePnl, null);

		EventsPnl eventsPnl = new EventsPnl();
		tabbedPane.addTab("Events", null, eventsPnl, null);

		HeatPnl heatPnl = new HeatPnl();
		tabbedPane.addTab("Heats", null, heatPnl, null);

		NameTagPnl nameTagPnl = new NameTagPnl();
		tabbedPane.addTab("Name Tags", null, nameTagPnl, null);
	}

}
