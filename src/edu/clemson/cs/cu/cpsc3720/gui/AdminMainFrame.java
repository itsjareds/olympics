package edu.clemson.cs.cu.cpsc3720.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import edu.clemson.cs.cu.cpsc3720.main.interfaces.AdminPanelInterface;
import edu.clemson.cs.cu.cpsc3720.mediator.Mediator;

/**
 * <h1>Admin Main Frame</h1>
 * <p>
 * Responsible for holding the AthletePnl, EventsPnl, SchoolsPnl, and UsersPnl
 * in a series of tabs.
 * @author bbest
 * @author shiz
 * @author klinge2
 * @version $Revision: 1.0 $
 */
public class AdminMainFrame extends JFrame {

	private static final long serialVersionUID = 1788257087454523343L;
	private JPanel contentPane;
	private Mediator mediator;

	/**
	 * Create the frame and load panels.
	 * @param mediator Mediator
	 */
	public AdminMainFrame(Mediator mediator) {
		this.mediator = mediator;

		setTitle("Administrator View T-J 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 600);
		this.setResizable(false);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);

		JMenu mnGenerate = new JMenu("Generate");
		menuBar.add(mnGenerate);

		JMenuItem mntmGenerateNametags = new JMenuItem("Nametags");
		mnGenerate.add(mntmGenerateNametags);

		JMenuItem mntmGenerateGroupSheets = new JMenuItem("Group Sheets");
		mnGenerate.add(mntmGenerateGroupSheets);

		JMenuItem mntmGenerateHeatSheets = new JMenuItem("Heat Sheets");
		mnGenerate.add(mntmGenerateHeatSheets);

		JMenu mnAbout = new JMenu("Help");
		menuBar.add(mnAbout);

		JMenuItem mntmAbout = new JMenuItem("About");
		mnAbout.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);

		AthletePnl athletePnl = new AthletePnl(this.mediator);
		tabbedPane.addTab("Athletes", null, athletePnl, null);

		EventsPnl eventsPnl = new EventsPnl(this.mediator);
		tabbedPane.addTab("Events", null, eventsPnl, null);

		UsersPnl userPnl = new UsersPnl();
		tabbedPane.addTab("Users", null, userPnl, null);

		SchoolsPnl schoolPnl = new SchoolsPnl();
		tabbedPane.addTab("Schools", null, schoolPnl, null);

		tabbedPane.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				Component c = tabbedPane.getSelectedComponent();
				if (c instanceof AdminPanelInterface) {
					AdminPanelInterface pnl = (AdminPanelInterface) c;
					pnl.clearPanel();
				}
			}
		});
	}
}
