import java.awt.EventQueue;

import javax.swing.*;

import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;
import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;

public class Main {

	private JFrame TClear;
	
	private JList listMain;

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
	
	Connection connection;

	
	/**
	 * Create the application.
	 */
	
	public void loadtList(){
		try {
			
			String query="select * from datebases";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			
			DefaultListModel DLM=new DefaultListModel();
			while(rs.next()){
				DLM.addElement(rs.getString("Project"));
			}
			
			listMain.setModel(DLM);
			
			pst.close();
			rs.close();

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Main() {
		initialize();
		connection=dbconfig.dbConnection();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//		UIManager.put("Synthetica.table.useSynthHeaderRenderer", Boolean.TRUE);
		try {
//			UIManager.setLookAndFeel(SyntheticaAluOxideLookAndFeel.class.getName());
			UIManager.setLookAndFeel(SyntheticaBlackEyeLookAndFeel.class.getName());
		} catch (Exception lf) {
			lf.printStackTrace();
		}
		TClear = new JFrame();
		TClear.setResizable(false);
		TClear.setTitle("TClear");
		TClear.setBounds(100, 100, 416, 359);
		TClear.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TClear.getContentPane().setLayout(null);
		
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
		
		listMain.setBounds(230, 36, 170, 263);
		TClear.getContentPane().add(listMain);
				
		JMenuBar menuBarMain = new JMenuBar();
		TClear.setJMenuBar(menuBarMain);
		
		loadtList();
		
		
	}
}
