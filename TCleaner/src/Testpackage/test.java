package Testpackage;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

public class test {

	private JFrame frmBurgerOrder;
	private JTextField textFieldMyOrder;
	private JPanel panelMenu;
	private JPanel panelBurger;
	private JPanel panelChicken;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.frmBurgerOrder.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBurgerOrder = new JFrame();
		frmBurgerOrder.setTitle("Burger Order");
		frmBurgerOrder.getContentPane().setBackground(Color.DARK_GRAY);
		frmBurgerOrder.setBounds(100, 100, 450, 300);
		frmBurgerOrder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBurgerOrder.getContentPane().setLayout(new CardLayout(0, 0));
		
		final JPanel panelMenu = new JPanel();
		panelMenu.setBackground(Color.DARK_GRAY);
		frmBurgerOrder.getContentPane().add(panelMenu, "name_16233615300430");
		panelMenu.setLayout(null);	
		panelMenu.setVisible(true);
		
		final JPanel panelBurger = new JPanel();
		panelBurger.setBackground(Color.DARK_GRAY);
		frmBurgerOrder.getContentPane().add(panelBurger, "name_16215076533872");
		panelBurger.setLayout(null);
		panelMenu.setVisible(false);
			
		final JPanel panelChicken = new JPanel();
		panelChicken.setBackground(Color.DARK_GRAY);
		frmBurgerOrder.getContentPane().add(panelChicken, "name_16231315472319");
		panelChicken.setLayout(null);
		panelMenu.setVisible(false);
		
		final JButton btnBurger = new JButton("Burger Meal");
		btnBurger.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBurger.setForeground(Color.WHITE);
		btnBurger.setBackground(Color.DARK_GRAY);
		btnBurger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelBurger.setVisible(true);
				panelMenu.setVisible(false);
			}
		});
		btnBurger.setBounds(77, 89, 122, 47);
		panelMenu.add(btnBurger);
		
		final JButton btnChicken = new JButton("Chicken Meal");
		btnChicken.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnChicken.setForeground(Color.WHITE);
		btnChicken.setBackground(Color.DARK_GRAY);
		btnChicken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelChicken.setVisible(true);
				panelMenu.setVisible(false);
			}
		});
		btnChicken.setBounds(209, 89, 122, 47);
		panelMenu.add(btnChicken);
		
		textFieldMyOrder = new JTextField();
		textFieldMyOrder.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldMyOrder.setEditable(false);
		textFieldMyOrder.setForeground(Color.WHITE);
		textFieldMyOrder.setBackground(Color.DARK_GRAY);
		textFieldMyOrder.setBounds(77, 182, 259, 20);
		panelMenu.add(textFieldMyOrder);
		textFieldMyOrder.setColumns(10);
		
		final JLabel lblMyOrder = new JLabel("My Order");
		lblMyOrder.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMyOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyOrder.setForeground(Color.WHITE);
		lblMyOrder.setBounds(77, 147, 254, 24);
		panelMenu.add(lblMyOrder);
		
		final JCheckBox chckbBurger = new JCheckBox("Burger");
		chckbBurger.setForeground(Color.WHITE);
		chckbBurger.setBackground(Color.DARK_GRAY);
		chckbBurger.setBounds(124, 69, 153, 23);
		panelBurger.add(chckbBurger);
		
		final JCheckBox chckbChicken = new JCheckBox("Chicken");
		chckbChicken.setForeground(Color.WHITE);
		chckbChicken.setBackground(Color.DARK_GRAY);
		chckbChicken.setBounds(124, 69, 97, 23);
		panelChicken.add(chckbChicken);
		
		final JCheckBox checkBox_1 = new JCheckBox("Fries");
		checkBox_1.setBackground(Color.DARK_GRAY);
		checkBox_1.setForeground(Color.WHITE);
		checkBox_1.setBounds(124, 95, 153, 23);
		panelBurger.add(checkBox_1);
		
		final JCheckBox checkBox_2 = new JCheckBox("Drink");
		checkBox_2.setForeground(Color.WHITE);
		checkBox_2.setBackground(Color.DARK_GRAY);
		checkBox_2.setBounds(124, 121, 153, 23);
		panelBurger.add(checkBox_2);	
		
		final JCheckBox checkBox_3 = new JCheckBox("Fries");
		checkBox_3.setForeground(Color.WHITE);
		checkBox_3.setBackground(Color.DARK_GRAY);
		checkBox_3.setBounds(124, 95, 97, 23);
		panelChicken.add(checkBox_3);
		
		final JCheckBox checkBox_4 = new JCheckBox("Drink");
		checkBox_4.setForeground(Color.WHITE);
		checkBox_4.setBackground(Color.DARK_GRAY);
		checkBox_4.setBounds(124, 121, 97, 23);
		panelChicken.add(checkBox_4);
		
		final JButton btnBurgerDone = new JButton("Order");
		btnBurgerDone.setBackground(Color.DARK_GRAY);
		btnBurgerDone.setForeground(Color.WHITE);
		btnBurgerDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = new String();
				
				if(chckbBurger.isSelected()){
					s = "Burger, ";
				}
				if(checkBox_1.isSelected()){
					s = s + "Fries, ";
				}
				if(checkBox_2.isSelected()){
					s = s + "Drink";
				}
				
				textFieldMyOrder.setText(s);
				panelBurger.setVisible(false);
				panelMenu.setVisible(true);
			}
		});
		
		final JButton btnChickenDone = new JButton("Order");
		btnChickenDone.setForeground(Color.WHITE);
		btnChickenDone.setBackground(Color.DARK_GRAY);
		btnChickenDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String s = new String();
				
				if(chckbChicken.isSelected()){
					s = "Chicken, ";
				}
				if(checkBox_3.isSelected()){
					s = s + "Fries, ";
				}
				if(checkBox_4.isSelected()){
					s = s + "Drink";
				}
				
				textFieldMyOrder.setText(s);
				panelChicken.setVisible(false);
				panelMenu.setVisible(true);
			}
		});
		btnChickenDone.setBounds(124, 166, 153, 46);
		panelChicken.add(btnChickenDone);
		
		btnBurgerDone.setBounds(124, 166, 153, 46);
		panelBurger.add(btnBurgerDone);

	}
}
