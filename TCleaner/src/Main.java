import java.awt.EventQueue;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;

public class Main {

	private JFrame TClear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.TClear.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection=null;
	

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
		connection=dbconfig.dbConnection();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		TClear = new JFrame();
		TClear.setResizable(false);
		TClear.setTitle("TClear");
		TClear.setBounds(100, 100, 416, 359);
		TClear.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TClear.getContentPane().setLayout(null);
		
		JList listMainProjects = new JList();
		listMainProjects.setToolTipText("Projects");
		listMainProjects.setBounds(190, 10, 200, 280);
		TClear.getContentPane().add(listMainProjects);
		
		JButton btnMainClearCache = new JButton("Clear Cache");
		btnMainClearCache.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnMainClearCache.setBounds(10, 115, 170, 30);
		TClear.getContentPane().add(btnMainClearCache);
		
		JButton btnMainEditProjects = new JButton("Configure Projects");
		btnMainEditProjects.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ConfProjects confProj=new ConfProjects();
				confProj.setVisible(true);
				
			}
		});
		btnMainEditProjects.setBounds(10, 155, 170, 30);
		TClear.getContentPane().add(btnMainEditProjects);
		
		JLabel lblMainBackground = new JLabel("");
		lblMainBackground.setBounds(0, 0, 410, 310);
		TClear.getContentPane().add(lblMainBackground);
		
		JMenuBar menuBarMain = new JMenuBar();
		TClear.setJMenuBar(menuBarMain);
	}
}
