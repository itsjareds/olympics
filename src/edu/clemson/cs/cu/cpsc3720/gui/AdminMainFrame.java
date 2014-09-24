package edu.clemson.cs.cu.cpsc3720.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AdminMainFrame extends JFrame {

	private static final long serialVersionUID = 1788257087454523343L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AdminMainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
