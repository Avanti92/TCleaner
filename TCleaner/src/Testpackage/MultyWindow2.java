package Testpackage;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JList;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;


public class MultyWindow2 {

	private JFrame frame;
	private JTextField textFieldAge;
	private JTextField textField_EID;
	private JTextField textFieldName;
	private JTextField textFieldSurname;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MultyWindow2 window = new MultyWindow2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MultyWindow2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		Image img = new ImageIcon(this.getClass().getResource("/background.jpg")).getImage();
		
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(Color.DARK_GRAY);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSave.setForeground(Color.WHITE);
		btnSave.setBounds(10, 11, 180, 30);
		frame.getContentPane().add(btnSave);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(Color.DARK_GRAY);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.setBounds(200, 11, 180, 30);
		frame.getContentPane().add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(Color.DARK_GRAY);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setBounds(404, 11, 180, 30);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnLoadTable = new JButton("Load Table");
		btnLoadTable.setBackground(Color.DARK_GRAY);
		btnLoadTable.setForeground(Color.WHITE);
		btnLoadTable.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLoadTable.setBounds(594, 11, 180, 30);
		frame.getContentPane().add(btnLoadTable);
		
		textFieldAge = new JTextField();
		textFieldAge.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAge.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldAge.setForeground(Color.WHITE);
		textFieldAge.setBackground(Color.DARK_GRAY);
		textFieldAge.setBounds(130, 196, 135, 30);
		frame.getContentPane().add(textFieldAge);
		textFieldAge.setColumns(10);
		
		textField_EID = new JTextField();
		textField_EID.setHorizontalAlignment(SwingConstants.CENTER);
		textField_EID.setForeground(Color.WHITE);
		textField_EID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_EID.setBackground(Color.DARK_GRAY);
		textField_EID.setBounds(130, 73, 135, 30);
		frame.getContentPane().add(textField_EID);
		textField_EID.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldName.setForeground(Color.WHITE);
		textFieldName.setBackground(Color.DARK_GRAY);
		textFieldName.setBounds(130, 114, 135, 30);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldSurname = new JTextField();
		textFieldSurname.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSurname.setForeground(Color.WHITE);
		textFieldSurname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldSurname.setBackground(Color.DARK_GRAY);
		textFieldSurname.setBounds(130, 155, 135, 30);
		frame.getContentPane().add(textFieldSurname);
		textFieldSurname.setColumns(10);
		
		JList list = new JList();
		list.setForeground(Color.WHITE);
		list.setFont(new Font("Tahoma", Font.BOLD, 15));
		list.setBackground(Color.DARK_GRAY);
		list.setBounds(10, 237, 270, 324);
		frame.getContentPane().add(list);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.DARK_GRAY);
		comboBox.setForeground(Color.WHITE);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox.setBounds(594, 52, 180, 30);
		frame.getContentPane().add(comboBox);
		
		JLabel lblEID = new JLabel("EID");
		lblEID.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEID.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEID.setForeground(Color.WHITE);
		lblEID.setBounds(10, 73, 95, 30);
		frame.getContentPane().add(lblEID);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(10, 114, 95, 30);
		frame.getContentPane().add(lblName);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSurname.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSurname.setForeground(Color.WHITE);
		lblSurname.setBounds(10, 155, 95, 30);
		frame.getContentPane().add(lblSurname);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAge.setForeground(Color.WHITE);
		lblAge.setBounds(10, 196, 95, 30);
		frame.getContentPane().add(lblAge);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(290, 93, 484, 468);
		frame.getContentPane().add(panel);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 784, 572);
		frame.getContentPane().add(lblBackground);
		lblBackground.setIcon(new ImageIcon(img));
	}
}
