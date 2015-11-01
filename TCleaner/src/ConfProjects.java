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

public class ConfProjects extends JFrame {

	private JPanel contentPane;
	private JTable tableConfProjects;
	private final JLabel lblConfProjectsBackground = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfProjects frame = new ConfProjects();
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
	public ConfProjects() {
		
		connection=dbconfig.dbConnection();
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 806, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConfProjectNew = new JButton("Add New Project");
		btnConfProjectNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewProject newProj=new NewProject();
				newProj.setVisible(true);
			}
		});
		btnConfProjectNew.setBounds(60, 20, 160, 30);
		contentPane.add(btnConfProjectNew);
		
		JButton btnConfProjectEdit = new JButton("Edit");
		btnConfProjectEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditProject editProj=new EditProject();
				editProj.setVisible(true);
			}
		});
		btnConfProjectEdit.setBounds(230, 20, 160, 30);
		contentPane.add(btnConfProjectEdit);
		
		JButton btnConfProjectDelete = new JButton("Delete");
		btnConfProjectDelete.setBounds(410, 20, 160, 30);
		contentPane.add(btnConfProjectDelete);
		
		JButton btnConfProjectClose = new JButton("Close");
		btnConfProjectClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnConfProjectClose.setBounds(580, 20, 160, 30);
		contentPane.add(btnConfProjectClose);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(50, 70, 700, 510);
		contentPane.add(scrollPane);
		
		tableConfProjects = new JTable();
		tableConfProjects.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableConfProjects.setShowVerticalLines(false);
		tableConfProjects.setForeground(Color.BLACK);
		tableConfProjects.setBackground(Color.WHITE);
		scrollPane.setViewportView(tableConfProjects);
		lblConfProjectsBackground.setBounds(0, 0, 800, 600);
		contentPane.add(lblConfProjectsBackground);
		
		try {
			String query="select * from datebases";
//			String query="select Datebase from datebases";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			tableConfProjects.setModel(DbUtils.resultSetToTableModel(rs));
			
			pst.close();
			rs.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
}
