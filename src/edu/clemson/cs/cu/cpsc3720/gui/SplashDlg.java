package edu.clemson.cs.cu.cpsc3720.gui;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

/**
 * <h1>Splash Dialog</h1>
 * <p>
 * Responsible for displaying a loading bar when the application runs at start
 * up.
 * @author bbest
 * @author shiz
 * @author klinge2
 * @version $Revision: 1.0 $
 */
public class SplashDlg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JProgressBar progressBar;
	private JLabel lblLoadingDatabase;

	/**
	 * Create the dialog.
	 * @param MAX_PROGRESS int
	 */
	public SplashDlg(final int MAX_PROGRESS) {
		setTitle("JT - 1.0");
		setBounds(100, 100, 450, 108);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		progressBar = new JProgressBar(0, MAX_PROGRESS);
		progressBar.setStringPainted(true);
		progressBar.setBounds(6, 34, 438, 43);
		contentPanel.add(progressBar);

		lblLoadingDatabase = new JLabel("Loading database...");
		lblLoadingDatabase.setBounds(6, 17, 179, 16);
		contentPanel.add(lblLoadingDatabase);
	}

	/**
	 * Method setProgress.
	 * @param val int
	 * @param message String
	 */
	public void setProgress(int val, String message) {
		progressBar.setValue(val);
		lblLoadingDatabase.setText(message);
	}
}
