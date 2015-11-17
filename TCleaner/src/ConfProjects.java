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
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ConfProjects extends JFrame {

	private JPanel contentPane;
	private JTable tableConfProjects;
	private JComboBox comboBoxConfProjects;

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

	
	Connection connection;
	private JTextField textFieldProject;
	private JTextField textFieldServer;
	private JTextField textFieldDB;
	private JTextField textFieldUser;
	private JPasswordField passwordField;
	private JTextField SearchFieldConfProjects;
	/**
	 * Create the frame.
	 */
	public void refreshTable() {
		try {
			
			String query="select * from datebases";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			tableConfProjects.setModel(DbUtils.resultSetToTableModel(rs));
			
			pst.close();
			rs.close();

			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
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
		
		final JButton btnConfProjectEdit = new JButton("Edit");
		btnConfProjectEdit.setEnabled(false);
		btnConfProjectEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditProject editProj=new EditProject();
				editProj.setVisible(true);
			}
		});
		btnConfProjectEdit.setBounds(230, 20, 160, 30);
		contentPane.add(btnConfProjectEdit);
		
		final JButton btnConfProjectDelete = new JButton("Delete");
		btnConfProjectDelete.setEnabled(false);
		btnConfProjectDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int action = JOptionPane.showConfirmDialog(null, "Do you want to delete?", "Save",JOptionPane.YES_NO_OPTION);
				if(action==0){
					int row = tableConfProjects.getSelectedRow();
					String Project_ = (tableConfProjects.getModel() .getValueAt(row, 0)) .toString();
					
					try {
						
						String query="delete from datebases where Project='"+Project_+"' ";
						PreparedStatement pst=connection.prepareStatement(query);
						
						pst.execute();
						JOptionPane.showMessageDialog(null, "Project Deleted");
						pst.close();
	
						
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
					
					refreshTable();		
				}
			}
		});
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
		scrollPane.setBounds(50, 120, 700, 410);
		contentPane.add(scrollPane);
		
		tableConfProjects = new JTable();
		tableConfProjects.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				btnConfProjectEdit.setEnabled(true);
				btnConfProjectDelete.setEnabled(true);
				
				int row = tableConfProjects.getSelectedRow();
				String Project_ = (tableConfProjects.getModel() .getValueAt(row, 0)) .toString();
				
				try {					
					String query="select * from datebases where Project='"+Project_+"' ";
					PreparedStatement pst=connection.prepareStatement(query);
					
					ResultSet rs=pst.executeQuery();			
					
					while (rs.next()) {
						textFieldProject.setText(rs.getString("Project"));
						textFieldServer.setText(rs.getString("Server"));
						textFieldDB.setText(rs.getString("Datebase"));
						textFieldUser.setText(rs.getString("Username"));
						passwordField.setText(rs.getString("Password"));
						
					}

					pst.close();
							
				} catch (Exception ez) {
					ez.printStackTrace();
				}
				
				refreshTable();
				
			}
		});
		tableConfProjects.setFillsViewportHeight(true);
		tableConfProjects.setSurrendersFocusOnKeystroke(true);
		tableConfProjects.setShowVerticalLines(false);
		tableConfProjects.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableConfProjects.setForeground(Color.BLACK);
		tableConfProjects.setBackground(Color.WHITE);
		scrollPane.setViewportView(tableConfProjects);
		
		SearchFieldConfProjects = new JTextField();
		SearchFieldConfProjects.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {				
					String selection=(String)comboBoxConfProjects.getSelectedItem();				
					String query="select Project,Server,Datebase,Username from datebases where '"+selection+"'=? ";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, SearchFieldConfProjects.getText());
					ResultSet rs=pst.executeQuery();			
					
					tableConfProjects.setModel(DbUtils.resultSetToTableModel(rs));
//					while (rs.next()) {
//						
//					}

					pst.close();
							
				} catch (Exception ez) {
					ez.printStackTrace();
				}
				
			}
		});
		SearchFieldConfProjects.setBounds(540, 70, 200, 30);
		contentPane.add(SearchFieldConfProjects);
		SearchFieldConfProjects.setColumns(10);
		
		textFieldProject = new JTextField();
		textFieldProject.setBounds(10, 580, 86, 20);
		contentPane.add(textFieldProject);
		textFieldProject.setColumns(10);
		
		textFieldServer = new JTextField();
		textFieldServer.setColumns(10);
		textFieldServer.setBounds(134, 580, 86, 20);
		contentPane.add(textFieldServer);
		
		textFieldDB = new JTextField();
		textFieldDB.setColumns(10);
		textFieldDB.setBounds(270, 580, 86, 20);
		contentPane.add(textFieldDB);
		
		textFieldUser = new JTextField();
		textFieldUser.setColumns(10);
		textFieldUser.setBounds(410, 580, 86, 20);
		contentPane.add(textFieldUser);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(560, 580, 86, 20);
		contentPane.add(passwordField);
		
		comboBoxConfProjects = new JComboBox();
		comboBoxConfProjects.setToolTipText("Filter for Search Criterias");
		comboBoxConfProjects.setModel(new DefaultComboBoxModel(new String[] {"Project", "Server", "Datebase", "Table"}));
		comboBoxConfProjects.setBounds(400, 70, 130, 30);
		contentPane.add(comboBoxConfProjects);
		
		refreshTable();
		
	}
}
