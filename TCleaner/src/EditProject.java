import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditProject extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditProject frame = new EditProject();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection;
	private JTextField textFieldEditProjectName;
	private JTextField textFieldEditProjectServer;
	private JTextField textFieldEditProjectDatebase;
	private JTextField textFieldEditProjectUsername;
	private JPasswordField passwordFieldEditProject;

	/**
	 * Create the frame.
	 */
	public EditProject() {
		connection=dbconfig.dbConnection();
		
		setResizable(false);		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 406, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldEditProjectName = new JTextField();
		textFieldEditProjectName.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldEditProjectName.setBounds(170, 20, 210, 30);
		contentPane.add(textFieldEditProjectName);
		textFieldEditProjectName.setColumns(10);
		
		textFieldEditProjectServer = new JTextField();
		textFieldEditProjectServer.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldEditProjectServer.setColumns(10);
		textFieldEditProjectServer.setBounds(170, 65, 210, 30);
		contentPane.add(textFieldEditProjectServer);
		
		textFieldEditProjectDatebase = new JTextField();
		textFieldEditProjectDatebase.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldEditProjectDatebase.setColumns(10);
		textFieldEditProjectDatebase.setBounds(170, 110, 210, 30);
		contentPane.add(textFieldEditProjectDatebase);
		
		textFieldEditProjectUsername = new JTextField();
		textFieldEditProjectUsername.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldEditProjectUsername.setColumns(10);
		textFieldEditProjectUsername.setBounds(170, 155, 210, 30);
		contentPane.add(textFieldEditProjectUsername);
		
		JLabel lblEditProjectName = new JLabel("Project Name");
		lblEditProjectName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEditProjectName.setBounds(20, 20, 115, 30);
		contentPane.add(lblEditProjectName);
		
		JLabel lblEditProjectServer = new JLabel("DB Server");
		lblEditProjectServer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEditProjectServer.setBounds(20, 65, 115, 30);
		contentPane.add(lblEditProjectServer);
		
		JLabel lblEditProjectDatebase = new JLabel("Datebase");
		lblEditProjectDatebase.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEditProjectDatebase.setBounds(20, 110, 115, 30);
		contentPane.add(lblEditProjectDatebase);
		
		JLabel lblEditProjectUsername = new JLabel("DB Username");
		lblEditProjectUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEditProjectUsername.setBounds(20, 155, 115, 30);
		contentPane.add(lblEditProjectUsername);
		
		JLabel lblEditProjectPassword = new JLabel("DB Password");
		lblEditProjectPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEditProjectPassword.setBounds(20, 200, 115, 30);
		contentPane.add(lblEditProjectPassword);
		
		JButton btnEditProjectSave = new JButton("Save");
		btnEditProjectSave.setBounds(20, 250, 175, 30);
		contentPane.add(btnEditProjectSave);
		
		JButton btnEditProjectCancel = new JButton("Cancel");
		btnEditProjectCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnEditProjectCancel.setBounds(205, 250, 175, 30);
		contentPane.add(btnEditProjectCancel);
		
		passwordFieldEditProject = new JPasswordField();
		passwordFieldEditProject.setHorizontalAlignment(SwingConstants.CENTER);
		passwordFieldEditProject.setBounds(170, 200, 210, 30);
		contentPane.add(passwordFieldEditProject);
		
		JLabel lblEditProjectBackground = new JLabel("");
		lblEditProjectBackground.setBounds(0, 0, 400, 300);
		contentPane.add(lblEditProjectBackground);
	}
}
