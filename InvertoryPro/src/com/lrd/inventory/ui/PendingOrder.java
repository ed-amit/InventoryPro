/*
 * Created by JFormDesigner on Tue Jun 02 00:00:56 IST 2015
 */

package com.lrd.inventory.ui;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

/**
 * @author dharmendra singh
 */
public class PendingOrder extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
		// Variables declaration 
		private JPanel panel1;
		private JPanel panel2;
		private JLabel label1;
		private JTabbedPane tabbedPane1;
		private JPanel panel3;
		private JLabel label2;
		private JLabel label3;
		private JLabel label4;
		private JLabel label5;
		private JLabel label6;
		private JButton button1;
		private JButton button2;
		private JComboBox<Object> comboBox1;
		private JComboBox<Object> comboBox2;
		private JTextField textField1;
		private JTextField textField2;
		private JTextField textField3;
		private JScrollPane scrollPane1;
		private JTable table1;
		private JLabel label7;
		private JTextField textField4;
		private JPanel panel4;
		private JLabel label8;
		private JLabel label9;
		private JLabel label10;
		private JLabel label11;
		private JLabel label12;
		private JButton button3;
		private JButton button4;
		private JComboBox<Object> comboBox3;
		private JComboBox<Object> comboBox4;
		private JTextField textField5;
		private JTextField textField6;
		private JTextField textField7;
		private JScrollPane scrollPane2;
		private JTable table2;
		private JLabel label13;
		private JTextField textField8;
		//  End of variables declaration  
		
		Connection connection = null;
	
	public PendingOrder(Connection connection) {
		this.connection= connection;
		initComponents();
		storeName();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - dharmendra singh
		panel1 = new JPanel();
		panel2 = new JPanel();
		label1 = new JLabel();
		tabbedPane1 = new JTabbedPane();
		panel3 = new JPanel();
		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		label5 = new JLabel();
		label6 = new JLabel();
		button1 = new JButton();
		button2 = new JButton();
		comboBox1 = new JComboBox<Object>();
		comboBox2 = new JComboBox<Object>();
		textField1 = new JTextField();
		textField2 = new JTextField();
		textField3 = new JTextField();
		scrollPane1 = new JScrollPane();
		table1 = new JTable();
		label7 = new JLabel();
		textField4 = new JTextField();
		panel4 = new JPanel();
		label8 = new JLabel();
		label9 = new JLabel();
		label10 = new JLabel();
		label11 = new JLabel();
		label12 = new JLabel();
		button3 = new JButton();
		button4 = new JButton();
		comboBox3 = new JComboBox<Object>();
		comboBox4 = new JComboBox<Object>();
		textField5 = new JTextField();
		textField6 = new JTextField();
		textField7 = new JTextField();
		scrollPane2 = new JScrollPane();
		table2 = new JTable();
		label13 = new JLabel();
		textField8 = new JTextField();

		//======== this ========
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		//======== panel1 ========
		{


			panel1.setLayout(null);

			//======== panel2 ========
			{
				panel2.setLayout(null);

				//---- label1 ----
				label1.setText("Pending Order Book");
				label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 15f));
				panel2.add(label1);
				label1.setBounds(new Rectangle(new Point(385, 10), label1.getPreferredSize()));

				
			}
			panel1.add(panel2);
			panel2.setBounds(0, 0, 930, 60);

			//======== tabbedPane1 ========
			{

				//======== panel3 ========
				{
					panel3.setLayout(null);

					//---- label2 ----
					label2.setText("Select Store");
					panel3.add(label2);
					label2.setBounds(new Rectangle(new Point(200, 30), label2.getPreferredSize()));
					
					panel3.add(comboBox1);
					comboBox1.setBounds(300, 30, 200, comboBox1.getPreferredSize().height);

					//---- label3 ----
					label3.setText("Search Criteria");
					panel3.add(label3);
					label3.setBounds(new Rectangle(new Point(200, 70), label3.getPreferredSize()));
					
					panel3.add(comboBox2);
					comboBox2.setBounds(300, 70, 200, comboBox2.getPreferredSize().height);

					//---- label4 ----
					label4.setText("From Date");
					panel3.add(label4);
					label4.setBounds(new Rectangle(new Point(200, 110), label4.getPreferredSize()));
					
					panel3.add(textField1);
					textField1.setBounds(300, 110, 150, textField1.getPreferredSize().height);
					
					//---- label7 ----
					label7.setText("To Date");
					panel3.add(label7);
					label7.setBounds(new Rectangle(new Point(490, 110), label7.getPreferredSize()));
					
					panel3.add(textField4);
					textField4.setBounds(565, 110, 150, textField4.getPreferredSize().height);

					//---- label5 ----
					label5.setText("Order No");
					panel3.add(label5);
					label5.setBounds(new Rectangle(new Point(200, 150), label5.getPreferredSize()));
					
					panel3.add(textField2);
					textField2.setBounds(300, 150, 200, textField2.getPreferredSize().height);

					//---- label6 ----
					label6.setText("Customer Name");
					panel3.add(label6);
					label6.setBounds(new Rectangle(new Point(200, 190), label6.getPreferredSize()));
					
					panel3.add(textField3);
					textField3.setBounds(300, 190, 200, textField3.getPreferredSize().height);

					//---- button1 ----
					button1.setText("Search");
					panel3.add(button1);
					button1.setBounds(285, 230, 100, 30);

					//---- button2 ----
					button2.setText("Clear");
					panel3.add(button2);
					button2.setBounds(440, 230, 100, 30);
					
					
					
					
					

					//======== scrollPane1 ========
					{
						scrollPane1.setViewportView(table1);
					}
					panel3.add(scrollPane1);
					scrollPane1.setBounds(30, 280, 865, 280);
	
				}
				tabbedPane1.addTab("Customer Order", panel3);

				//======== panel4 ========
				{
					panel4.setLayout(null);

					//---- label8 ----
					label8.setText("Select Store");
					panel4.add(label8);
					label8.setBounds(new Rectangle(new Point(200, 30), label8.getPreferredSize()));
					
					panel4.add(comboBox3);
					comboBox3.setBounds(300, 30, 200, comboBox3.getPreferredSize().height);

					//---- label9 ----
					label9.setText("Search Criteria");
					panel4.add(label9);
					label9.setBounds(new Rectangle(new Point(200, 70), label9.getPreferredSize()));
					
					panel4.add(comboBox4);
					comboBox4.setBounds(300, 70, 200, comboBox4.getPreferredSize().height);

					//---- label10 ----
					label10.setText("From Date");
					panel4.add(label10);
					label10.setBounds(new Rectangle(new Point(200, 110), label10.getPreferredSize()));
					
					panel4.add(textField5);
					textField5.setBounds(300, 110, 150, textField5.getPreferredSize().height);
					
					//---- label13 ----
					label13.setText("To Date");
					panel4.add(label13);
					label13.setBounds(new Rectangle(new Point(490, 110), label13.getPreferredSize()));
					
					panel4.add(textField8);
					textField8.setBounds(565, 110, 150, textField8.getPreferredSize().height);

					//---- label11 ----
					label11.setText("Order No");
					panel4.add(label11);
					label11.setBounds(new Rectangle(new Point(200, 150), label11.getPreferredSize()));
					
					panel4.add(textField6);
					textField6.setBounds(300, 150, 200, textField6.getPreferredSize().height);

					//---- label12 ----
					label12.setText("Customer Name");
					panel4.add(label12);
					label12.setBounds(new Rectangle(new Point(200, 190), label12.getPreferredSize()));
					
					panel4.add(textField7);
					textField7.setBounds(300, 190, 200, textField7.getPreferredSize().height);

					//---- button3 ----
					button3.setText("Search");
					panel4.add(button3);
					button3.setBounds(285, 230, 100, 30);

					//---- button4 ----
					button4.setText("Clear");
					panel4.add(button4);
					button4.setBounds(440, 230, 100, 30);
					
					

					//======== scrollPane2 ========
					{
						scrollPane2.setViewportView(table2);
					}
					panel4.add(scrollPane2);
					scrollPane2.setBounds(30, 280, 865, 280);

					

					
				}
				tabbedPane1.addTab("Supplier Order", panel4);
			}
			panel1.add(tabbedPane1);
			tabbedPane1.setBounds(0, 60, 925, 615);

			
		}
		contentPane.add(panel1);
		panel1.setBounds(0, 0, 925, 675);

		{ // compute preferred size
			Dimension preferredSize = new Dimension();
			for(int i = 0; i < contentPane.getComponentCount(); i++) {
				Rectangle bounds = contentPane.getComponent(i).getBounds();
				preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
				preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
			}
			Insets insets = contentPane.getInsets();
			preferredSize.width += insets.right;
			preferredSize.height += insets.bottom;
			contentPane.setMinimumSize(preferredSize);
			contentPane.setPreferredSize(preferredSize);
		}
		
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
		setLocationRelativeTo(getOwner());
		
	}

	public static void main (String[] args){
		//new PendingOrder();
	}
	
	
	private void storeName(){
		try {
			Statement stmt=connection.createStatement();
			ResultSet result=stmt.executeQuery("select * from store_details");
			while(result.next()){
				comboBox1.addItem(result.getString("store_name"));
				comboBox3.addItem(result.getString("store_name"));
			}
			result.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
