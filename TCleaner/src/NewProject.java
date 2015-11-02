import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewProject extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewProject frame = new NewProject();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null;
	private JTextField textFieldNewProjectName;
	private JTextField textFieldNewProjectServer;
	private JTextField textFieldNewProjectDatebase;
	private JTextField textFieldNewProjectUsername;
	private JPasswordField passwordFieldNewProject;
	
	//

	/**
	 * Create the frame.
	 */
	public NewProject() {
		dbconfig.dbConnection();
		setResizable(false);		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 406, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldNewProjectName = new JTextField();
		textFieldNewProjectName.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNewProjectName.setBounds(170, 20, 210, 30);
		contentPane.add(textFieldNewProjectName);
		textFieldNewProjectName.setColumns(10);
		
		textFieldNewProjectServer = new JTextField();
		textFieldNewProjectServer.setText("localhost");
		textFieldNewProjectServer.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNewProjectServer.setColumns(10);
		textFieldNewProjectServer.setBounds(170, 65, 210, 30);
		contentPane.add(textFieldNewProjectServer);
		
		textFieldNewProjectDatebase = new JTextField();
		textFieldNewProjectDatebase.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNewProjectDatebase.setColumns(10);
		textFieldNewProjectDatebase.setBounds(170, 110, 210, 30);
		contentPane.add(textFieldNewProjectDatebase);
		
		textFieldNewProjectUsername = new JTextField();
		textFieldNewProjectUsername.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNewProjectUsername.setColumns(10);
		textFieldNewProjectUsername.setBounds(170, 155, 210, 30);
		contentPane.add(textFieldNewProjectUsername);
		
		JLabel lblNewProjectName = new JLabel("Project Name");
		lblNewProjectName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewProjectName.setBounds(20, 20, 115, 30);
		contentPane.add(lblNewProjectName);
		
		JLabel lblNewProjectServer = new JLabel("DB Server");
		lblNewProjectServer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewProjectServer.setBounds(20, 65, 115, 30);
		contentPane.add(lblNewProjectServer);
		
		JLabel lblNewProjectDatebase = new JLabel("Datebase");
		lblNewProjectDatebase.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewProjectDatebase.setBounds(20, 110, 115, 30);
		contentPane.add(lblNewProjectDatebase);
		
		JLabel lblNewProjectUsername = new JLabel("DB Username");
		lblNewProjectUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewProjectUsername.setBounds(20, 155, 115, 30);
		contentPane.add(lblNewProjectUsername);
		
		JLabel lblNewProjectPassword = new JLabel("DB Password");
		lblNewProjectPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewProjectPassword.setBounds(20, 200, 115, 30);
		contentPane.add(lblNewProjectPassword);
		
		JButton btnNewProjectSave = new JButton("Save");
//		btnNewProjectSave.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//					String query="insert into datebases (Project,Server,Datebase,Username,Password) values (?,?,?,?)";
//					PreparedStatement pst=connection.prepareStatement(query);
//					pst.setString(1,textFieldNewProjectName.getText() );
//					pst.setString(2,textFieldNewProjectServer.getText() );
//					pst.setString(3,textFieldNewProjectDatebase.getText() );
//					pst.setString(4,textFieldNewProjectUsername.getText() );
//					
//					pst.execute();
//					
//					JOptionPane.showMessageDialog(null, "Data has been saved.");
//					pst.close();
//					
//					
//					
//				} catch (Exception e2) {
//					JOptionPane.showMessageDialog(null, e2);
//				}
//			}
//		});
		btnNewProjectSave.setBounds(20, 250, 175, 30);
		contentPane.add(btnNewProjectSave);
		
		JButton btnNewProjectCancel = new JButton("Cancel");
		btnNewProjectCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewProjectCancel.setBounds(205, 250, 175, 30);
		contentPane.add(btnNewProjectCancel);
		
		passwordFieldNewProject = new JPasswordField();
		passwordFieldNewProject.setHorizontalAlignment(SwingConstants.CENTER);
		passwordFieldNewProject.setBounds(170, 200, 210, 30);
		contentPane.add(passwordFieldNewProject);
		
		JLabel lblNewProjectBackground = new JLabel("");
		lblNewProjectBackground.setBounds(0, 0, 400, 300);
		contentPane.add(lblNewProjectBackground);
	}
}
