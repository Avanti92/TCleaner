import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Image;

import javax.swing.*;

import java.sql.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frmLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null;
	private JTextField textFieldUsername;
	private JPasswordField passwordField;
	
	
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		connection = SqliteConnect.dbConnection();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setBackground(Color.BLACK);
		frmLogin.getContentPane().setFont(new Font("Verdana", Font.BOLD, 20));
		frmLogin.setTitle("Login");
		frmLogin.getContentPane().setBackground(Color.DARK_GRAY);
		frmLogin.getContentPane().setLayout(null);
		frmLogin.setResizable(false);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(360, 253, 240, 75);
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Verdana", Font.BOLD, 30));
		lblUsername.setBackground(Color.GRAY);
		frmLogin.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(360, 334, 240, 75);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Verdana", Font.BOLD, 30));
		lblPassword.setBackground(Color.GRAY);
		frmLogin.getContentPane().add(lblPassword);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(564, 253, 240, 75);
		textFieldUsername.setForeground(Color.WHITE);
		textFieldUsername.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 40));
		textFieldUsername.setBackground(Color.DARK_GRAY);
		frmLogin.getContentPane().add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		JButton btnLogin = new JButton("Log In");
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBounds(564, 419, 240, 75);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="select * from sql_table where username=? and password=?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textFieldUsername.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs = pst.executeQuery();
					int count = 0;
					while(rs.next()){
						count++;
					}
					if(count == 1){
						JOptionPane.showMessageDialog(null, "Username and password is correct");
					} else if(count>1){
						JOptionPane.showMessageDialog(null, "Duplicate Username and password");
					} else {
						JOptionPane.showMessageDialog(null, "Invalid Username and password");
					}
					
					rs.close();
					pst.close();
					
				} catch (Exception e) {
					
					JOptionPane.showMessageDialog(null, e);
					
				}
			}
		});
		btnLogin.setBackground(Color.BLACK);
		btnLogin.setFont(new Font("Verdana", Font.BOLD, 30));
		frmLogin.getContentPane().add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(564, 334, 240, 75);
		passwordField.setForeground(Color.WHITE);
		passwordField.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 40));
		passwordField.setBackground(Color.DARK_GRAY);
		frmLogin.getContentPane().add(passwordField);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/background.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 1274, 760);
		frmLogin.getContentPane().add(lblNewLabel);
		frmLogin.setBounds(100, 100, 1280, 800);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
