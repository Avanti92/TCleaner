import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import java.awt.Font;

public class EditProjects extends JFrame {

	private JPanel contentPane;
	private JTable tableEditProjects;
	private final JLabel lblEditProjectsBackground = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditProjects frame = new EditProjects();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection=null;
	/**
	 * Create the frame.
	 */
	public EditProjects() {
		
		connection=dbconfig.dbConnection();
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 806, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEditProjectNew = new JButton("Add New Project");
		btnEditProjectNew.setBounds(60, 20, 160, 30);
		contentPane.add(btnEditProjectNew);
		
		JButton btnEditProjectEdit = new JButton("Edit");
		btnEditProjectEdit.setBounds(230, 20, 160, 30);
		contentPane.add(btnEditProjectEdit);
		
		JButton btnEditProjectDelete = new JButton("Delete");
		btnEditProjectDelete.setBounds(410, 20, 160, 30);
		contentPane.add(btnEditProjectDelete);
		
		JButton btnEditProjectClose = new JButton("Close");
		btnEditProjectClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnEditProjectClose.setBounds(580, 20, 160, 30);
		contentPane.add(btnEditProjectClose);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(50, 70, 700, 510);
		contentPane.add(scrollPane);
		
		tableEditProjects = new JTable();
		tableEditProjects.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableEditProjects.setShowVerticalLines(false);
		tableEditProjects.setForeground(Color.BLACK);
		tableEditProjects.setBackground(Color.WHITE);
		scrollPane.setViewportView(tableEditProjects);
		lblEditProjectsBackground.setBounds(0, 0, 800, 600);
		contentPane.add(lblEditProjectsBackground);
		
		try {
			String query="select * from datebases";
//			String query="select Datebase from datebases";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			tableEditProjects.setModel(DbUtils.resultSetToTableModel(rs));
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
}
