package edu.clemson.cs.cu.cpsc3720.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TeacherDlg extends JDialog {

	private static final long serialVersionUID = -725278211570691155L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public TeacherDlg() {
		setTitle("Teacher View T-J 1.0");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
	}

}
