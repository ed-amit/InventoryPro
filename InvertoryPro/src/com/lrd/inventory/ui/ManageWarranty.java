/*
 * Created by JFormDesigner on Sat May 30 10:00:14 IST 2015
 */

package com.lrd.inventory.ui;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.*;

/**
 * @author dharmendra singh
 */
public class ManageWarranty extends JFrame {
	

	private static final long serialVersionUID = 1L;
	//  Variables declaration 
	private JLabel label1;
	private JSeparator separator1;
	private JLabel label2;
	private JComboBox<Object> comboBox1;
	private JPanel panel1;
	private JTextField textField1;
	private JScrollPane scrollPane1;
	private JList<Object> list1;
	private JPanel panel2;
	private JScrollPane scrollPane2;
	private JList<Object> list2;
	private JPanel panel3;
	private JScrollPane scrollPane3;
	private JList<Object> list3;
	private JPanel panel4;
	private JScrollPane scrollPane4;
	private JList<Object> list4;
	private JLabel label3;
	private JTextField textField2;
	private JSeparator separator2;
	private JLabel label4;
	private JRadioButton radioButton1;
	private JRadioButton radioButton2;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JPanel panel5;
	private JTextField textField3;
	private JButton button4;
	private JPanel panel6;
	private JTextField textField4;
	private JButton button5;
	private JPanel panel7;
	private JTextField textField5;
	private JButton button6;
	//  End of variables declaration
	
	Connection connection = null;
	
	public ManageWarranty(Connection connection) {
		this.connection = connection;
		initComponents();
		storeName();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - dharmendra singh
		label1 = new JLabel();
		separator1 = new JSeparator();
		label2 = new JLabel();
		comboBox1 = new JComboBox<Object>();
		panel1 = new JPanel();
		textField1 = new JTextField();
		scrollPane1 = new JScrollPane();
		list1 = new JList<Object>();
		panel2 = new JPanel();
		scrollPane2 = new JScrollPane();
		list2 = new JList<Object>();
		panel3 = new JPanel();
		scrollPane3 = new JScrollPane();
		list3 = new JList<Object>();
		panel4 = new JPanel();
		scrollPane4 = new JScrollPane();
		list4 = new JList<Object>();
		label3 = new JLabel();
		textField2 = new JTextField();
		separator2 = new JSeparator();
		label4 = new JLabel();
		radioButton1 = new JRadioButton();
		radioButton2 = new JRadioButton();
		label5 = new JLabel();
		label6 = new JLabel();
		label7 = new JLabel();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		panel5 = new JPanel();
		textField3 = new JTextField();
		button4 = new JButton();
		panel6 = new JPanel();
		textField4 = new JTextField();
		button5 = new JButton();
		panel7 = new JPanel();
		textField5 = new JTextField();
		button6 = new JButton();

		//======== this ========
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		//---- label1 ----
		label1.setText("Manage Warranty ");
		label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 15f));
		contentPane.add(label1);
		label1.setBounds(new Rectangle(new Point(395, 15), label1.getPreferredSize()));
		contentPane.add(separator1);
		separator1.setBounds(30, 60, 1055, 7);

		//---- label2 ----
		label2.setText("Select Store");
		contentPane.add(label2);
		label2.setBounds(new Rectangle(new Point(50, 90), label2.getPreferredSize()));
		contentPane.add(comboBox1);
		comboBox1.setBounds(150, 90, 200, comboBox1.getPreferredSize().height);

		//======== panel1 ========
		{
			panel1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, Color.white, null), "Select Supplier", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("sansserif", Font.PLAIN, 16), Color.black));

			panel1.setLayout(null);
			panel1.add(textField1);
			textField1.setBounds(15, 25, 170, 30);

			//======== scrollPane1 ========
			{
				scrollPane1.setViewportView(list1);
			}
			panel1.add(scrollPane1);
			scrollPane1.setBounds(15, 60, 170, 180);

			
		}
		contentPane.add(panel1);
		panel1.setBounds(50, 140, 200, 250);

		//======== panel2 ========
		{
			panel2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Select Bill", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("sansserif", Font.PLAIN, 16)));
			panel2.setLayout(null);

			//======== scrollPane2 ========
			{
				scrollPane2.setViewportView(list2);
			}
			panel2.add(scrollPane2);
			scrollPane2.setBounds(15, 25, 170, 215);

			
		}
		contentPane.add(panel2);
		panel2.setBounds(320, 140, 200, 250);

		//======== panel3 ========
		{
			panel3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Select Product", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("sansserif", Font.PLAIN, 16)));
			panel3.setLayout(null);

			//======== scrollPane3 ========
			{
				scrollPane3.setViewportView(list3);
			}
			panel3.add(scrollPane3);
			scrollPane3.setBounds(15, 25, 170, 215);

			
		}
		contentPane.add(panel3);
		panel3.setBounds(580, 140, 200, 250);

		//======== panel4 ========
		{
			panel4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Batch No", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("sansserif", Font.PLAIN, 16)));
			panel4.setLayout(null);

			//======== scrollPane4 ========
			{
				scrollPane4.setViewportView(list4);
			}
			panel4.add(scrollPane4);
			scrollPane4.setBounds(15, 25, 170, 215);

			
		}
		contentPane.add(panel4);
		panel4.setBounds(850, 140, 200, 250);

		//---- label3 ----
		label3.setText("Narrations");
		contentPane.add(label3);
		label3.setBounds(new Rectangle(new Point(670, 400), label3.getPreferredSize()));
		contentPane.add(textField2);
		textField2.setBounds(750, 400, 300, textField2.getPreferredSize().height);
		contentPane.add(separator2);
		separator2.setBounds(40, 445, 1000, 7);

		//---- label4 ----
		label4.setText("Select Mode");
		contentPane.add(label4);
		label4.setBounds(new Rectangle(new Point(50, 460), label4.getPreferredSize()));

		//---- radioButton1 ----
		radioButton1.setText("Warranty");
		contentPane.add(radioButton1);
		radioButton1.setBounds(new Rectangle(new Point(140, 460), radioButton1.getPreferredSize()));

		//---- radioButton2 ----
		radioButton2.setText("Expiry");
		contentPane.add(radioButton2);
		radioButton2.setBounds(new Rectangle(new Point(235, 460), radioButton2.getPreferredSize()));

		//---- label5 ----
		label5.setText("From");
		contentPane.add(label5);
		label5.setBounds(new Rectangle(new Point(50, 500), label5.getPreferredSize()));

		//---- label6 ----
		label6.setText("To");
		contentPane.add(label6);
		label6.setBounds(new Rectangle(new Point(280, 500), label6.getPreferredSize()));

		//---- label7 ----
		label7.setText("Purchase Date");
		contentPane.add(label7);
		label7.setBounds(new Rectangle(new Point(500, 500), label7.getPreferredSize()));

		//---- button1 ----
		button1.setText("Reset");
		contentPane.add(button1);
		button1.setBounds(250, 550, 100, 30);

		//---- button2 ----
		button2.setText("Save");
		contentPane.add(button2);
		button2.setBounds(400, 550, 100, 30);

		//---- button3 ----
		button3.setText("Cancel");
		contentPane.add(button3);
		button3.setBounds(550, 550, 100, 30);

		//======== panel5 ========
		{
			panel5.setBackground(Color.white);
			panel5.setLayout(null);
			panel5.add(textField3);
			textField3.setBounds(0, 0, 110, 20);

			//---- button4 ----
			button4.setText("Date");
			panel5.add(button4);
			button4.setBounds(110, 0, 30, 20);

			
		}
		contentPane.add(panel5);
		panel5.setBounds(100, 500, 140, 20);

		//======== panel6 ========
		{
			panel6.setBackground(Color.white);
			panel6.setLayout(null);
			panel6.add(textField4);
			textField4.setBounds(0, 0, 110, 20);

			//---- button5 ----
			button5.setText("Date");
			panel6.add(button5);
			button5.setBounds(110, 0, 30, 20);

			
		}
		contentPane.add(panel6);
		panel6.setBounds(300, 500, 140, 20);

		//======== panel7 ========
		{
			panel7.setBackground(Color.white);
			panel7.setLayout(null);
			panel7.add(textField5);
			textField5.setBounds(0, 0, 110, 20);

			//---- button6 ----
			button6.setText("Date");
			panel7.add(button6);
			button6.setBounds(110, 0, 30, 20);

			
		}
		contentPane.add(panel7);
		panel7.setBounds(600, 500, 140, 20);

		
		
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
		setSize(1100, 630);
		setLocationRelativeTo(getOwner());
	
	}

	
	
	public static void main (String[] args){
		//new ManageWarranty();
	}
	
	
	private void storeName(){
		try {
			Statement stmt=connection.createStatement();
			ResultSet result=stmt.executeQuery("select * from store_details");
			while(result.next()){
				comboBox1.addItem(result.getString("store_name"));
			}
			result.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
