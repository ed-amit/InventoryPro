/*
 * Created by JFormDesigner on Mon Jun 01 23:42:05 IST 2015
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
public class BillBookPurchaseDue extends JFrame {
	


	private static final long serialVersionUID = 1L;
	// Variables declaration
	private JPanel panel1;
	private JPanel panel2;
	private JLabel label1;
	private JPanel panel3;
	private JLabel label2;
	private JScrollPane scrollPane1;
	private JTable table1;
	private JButton button1;
	private JPanel panel4;
	private JLabel label3;
	private JScrollPane scrollPane2;
	private JTable table2;
	private JButton button2;
	private JButton button3;
	private JPanel panel5;
	private JLabel label4;
	private JScrollPane scrollPane3;
	private JTable table3;
	private JLabel label5;
	private JTextField textField1;
	private JLabel label6;
	private JTextField textField2;
	private JLabel label7;
	private JLabel label8;
	private JLabel label9;
	private JLabel label10;
	private JLabel label11;
	private JLabel label12;
	private JLabel label13;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	private JTextField textField7;
	private JTextField textField8;
	private JTextField textField9;
	private JLabel label14;
	private JLabel label15;
	private JLabel label16;
	private JLabel label17;
	private JLabel label18;
	private JLabel label19;
	private JLabel label20;
	private JTextField textField10;
	private JTextField textField11;
	private JTextField textField12;
	private JTextField textField13;
	private JTextField textField14;
	private JTextField textField15;
	private JTextField textField16;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	private JLabel label21;
	private JComboBox<Object> comboBox1;

	// End of variables declaration

	Connection connection = null;
	
	public BillBookPurchaseDue(Connection connection) {
		this.connection = connection;
		initComponents();
		storeName();
	}

	private void initComponents() {

		panel1 = new JPanel();
		panel2 = new JPanel();
		label1 = new JLabel();
		panel3 = new JPanel();
		label2 = new JLabel();
		scrollPane1 = new JScrollPane();
		table1 = new JTable();
		button1 = new JButton();
		panel4 = new JPanel();
		label3 = new JLabel();
		scrollPane2 = new JScrollPane();
		table2 = new JTable();
		button2 = new JButton();
		button3 = new JButton();
		panel5 = new JPanel();
		label4 = new JLabel();
		scrollPane3 = new JScrollPane();
		table3 = new JTable();
		label5 = new JLabel();
		textField1 = new JTextField();
		label6 = new JLabel();
		textField2 = new JTextField();
		label7 = new JLabel();
		label8 = new JLabel();
		label9 = new JLabel();
		label10 = new JLabel();
		label11 = new JLabel();
		label12 = new JLabel();
		label13 = new JLabel();
		textField3 = new JTextField();
		textField4 = new JTextField();
		textField5 = new JTextField();
		textField6 = new JTextField();
		textField7 = new JTextField();
		textField8 = new JTextField();
		textField9 = new JTextField();
		label14 = new JLabel();
		label15 = new JLabel();
		label16 = new JLabel();
		label17 = new JLabel();
		label18 = new JLabel();
		label19 = new JLabel();
		label20 = new JLabel();
		textField10 = new JTextField();
		textField11 = new JTextField();
		textField12 = new JTextField();
		textField13 = new JTextField();
		textField14 = new JTextField();
		textField15 = new JTextField();
		textField16 = new JTextField();
		button4 = new JButton();
		button5 = new JButton();
		button6 = new JButton();
		button7 = new JButton();
		label21 = new JLabel();
		comboBox1 = new JComboBox<Object>();

		// ======== this ========
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		// ======== panel1 ========
		{

			panel1.setLayout(null);

			// ======== panel2 ========
			{
				panel2.setLayout(null);

				// ---- label1 ----
				label1.setText("Purchase Book");
				label1.setFont(label1.getFont().deriveFont(
						label1.getFont().getSize() + 15f));
				panel2.add(label1);
				label1.setBounds(new Rectangle(new Point(465, 10), label1
						.getPreferredSize()));

			}
			panel1.add(panel2);
			panel2.setBounds(0, 0, 1115, 60);

			// ======== panel3 ========
			{
				panel3.setBorder(UIManager.getBorder("TitledBorder.border"));
				panel3.setLayout(null);

				// ---- label2 ----
				label2.setText("Distributor Name");
				panel3.add(label2);
				label2.setBounds(new Rectangle(new Point(15, 15), label2
						.getPreferredSize()));

				// ======== scrollPane1 ========
				{
					scrollPane1.setViewportView(table1);
				}
				panel3.add(scrollPane1);
				scrollPane1.setBounds(10, 40, 200, 430);

				// ---- button1 ----
				button1.setText("Refresh");
				panel3.add(button1);
				button1.setBounds(40, 480, 100, 30);

			}
			panel1.add(panel3);
			panel3.setBounds(10, 90, 220, 520);

			// ======== panel4 ========
			{
				panel4.setBorder(UIManager.getBorder("TitledBorder.border"));
				panel4.setLayout(null);

				// ---- label3 ----
				label3.setText("All Bill Of Distributor");
				panel4.add(label3);
				label3.setBounds(new Rectangle(new Point(15, 15), label3
						.getPreferredSize()));

				// ======== scrollPane2 ========
				{
					scrollPane2.setViewportView(table2);
				}
				panel4.add(scrollPane2);
				scrollPane2.setBounds(10, 40, 200, 430);

				// ---- button2 ----
				button2.setText("Delete");
				panel4.add(button2);
				button2.setBounds(10, 480, 80, 30);

				// ---- button3 ----
				button3.setText("Refresh");
				panel4.add(button3);
				button3.setBounds(110, 480, 80, 30);

			}
			panel1.add(panel4);
			panel4.setBounds(240, 90, 220, 520);

			// ======== panel5 ========
			{
				panel5.setBorder(UIManager.getBorder("TitledBorder.border"));
				panel5.setLayout(null);

				// ---- label4 ----
				label4.setText("Perticular Bill Detail");
				panel5.add(label4);
				label4.setBounds(new Rectangle(new Point(15, 15), label4
						.getPreferredSize()));

				// ======== scrollPane3 ========
				{
					scrollPane3.setViewportView(table3);
				}
				panel5.add(scrollPane3);
				scrollPane3.setBounds(20, 50,
						scrollPane3.getPreferredSize().width, 120);

				// ---- label5 ----
				label5.setText("Total Product : ");
				panel5.add(label5);
				label5.setBounds(new Rectangle(new Point(25, 175), label5
						.getPreferredSize()));

				panel5.add(textField1);
				textField1.setBounds(130, 175, 50, 20);

				// ---- label6 ----
				label6.setText("Total Amount");
				panel5.add(label6);
				label6.setBounds(new Rectangle(new Point(250, 175), label6
						.getPreferredSize()));

				panel5.add(textField2);
				textField2.setBounds(370, 175, 100, 20);

				// ---- label14 ----
				label14.setText("Paid Amount");
				panel5.add(label14);
				label14.setBounds(new Rectangle(new Point(250, 205), label14
						.getPreferredSize()));

				panel5.add(textField16);
				textField16.setBounds(370, 205, 100, 20);

				// ---- label15 ----
				label15.setText("Remaining Amount");
				panel5.add(label15);
				label15.setBounds(new Rectangle(new Point(250, 235), label15
						.getPreferredSize()));

				panel5.add(textField15);
				textField15.setBounds(370, 235, 100, 20);

				// ---- label13 ----
				label13.setText("No Of Credit Days");
				panel5.add(label13);
				label13.setBounds(new Rectangle(new Point(25, 260), label13
						.getPreferredSize()));

				panel5.add(textField9);
				textField9.setBounds(145, 260, 100, 20);

				// ---- label12 ----
				label12.setText("Payment Type");
				panel5.add(label12);
				label12.setBounds(new Rectangle(new Point(25, 290), label12
						.getPreferredSize()));

				panel5.add(textField8);
				textField8.setBounds(145, 290, 100, 20);

				// ---- label11 ----
				label11.setText("LBT (%)");
				panel5.add(label11);
				label11.setBounds(new Rectangle(new Point(25, 320), label11
						.getPreferredSize()));

				panel5.add(textField7);
				textField7.setBounds(145, 320, 100, 20);

				// ---- label10 ----
				label10.setText("Transportation");
				panel5.add(label10);
				label10.setBounds(new Rectangle(new Point(25, 350), label10
						.getPreferredSize()));

				panel5.add(textField6);
				textField6.setBounds(145, 350, 100, 20);

				// ---- label9 ----
				label9.setText("Octria (%)");
				panel5.add(label9);
				label9.setBounds(new Rectangle(new Point(25, 380), label9
						.getPreferredSize()));

				panel5.add(textField5);
				textField5.setBounds(145, 380, 100, 20);

				// ---- label8 ----
				label8.setText("Hamali");
				panel5.add(label8);
				label8.setBounds(new Rectangle(new Point(25, 410), label8
						.getPreferredSize()));

				panel5.add(textField4);
				textField4.setBounds(145, 410, 100, 20);

				// ---- label7 ----
				label7.setText("Miscilaneous");
				panel5.add(label7);
				label7.setBounds(new Rectangle(new Point(25, 440), label7
						.getPreferredSize()));

				panel5.add(textField3);
				textField3.setBounds(145, 440, 100, 20);

				// ---- label16 ----
				label16.setText("Discount");
				panel5.add(label16);
				label16.setBounds(new Rectangle(new Point(270, 320), label16
						.getPreferredSize()));

				panel5.add(textField14);
				textField14.setBounds(370, 320, 100, 20);

				// ---- label17 ----
				label17.setText("Entry Tax (%)");
				panel5.add(label17);
				label17.setBounds(new Rectangle(new Point(270, 350), label17
						.getPreferredSize()));

				panel5.add(textField13);
				textField13.setBounds(370, 350, 100, 20);

				// ---- label18 ----
				label18.setText("Excise (%)");
				panel5.add(label18);
				label18.setBounds(new Rectangle(new Point(270, 380), label18
						.getPreferredSize()));

				panel5.add(textField12);
				textField12.setBounds(370, 380, 100, 20);

				// ---- label19 ----
				label19.setText("CST (%)");
				panel5.add(label19);
				label19.setBounds(new Rectangle(new Point(270, 410), label19
						.getPreferredSize()));

				panel5.add(textField11);
				textField11.setBounds(370, 410, 100, 20);

				// ---- label20 ----
				label20.setText("Vat (%)");
				panel5.add(label20);
				label20.setBounds(new Rectangle(new Point(270, 440), label20
						.getPreferredSize()));

				panel5.add(textField10);
				textField10.setBounds(370, 440, 100, 20);

				// ---- button4 ----
				button4.setText("Discounts");
				panel5.add(button4);
				button4.setBounds(25, 480, 100, 30);

				// ---- button5 ----
				button5.setText("Pay Amt");
				panel5.add(button5);
				button5.setBounds(140, 480, 100, 30);

				// ---- button6 ----
				button6.setText("Refresh");
				panel5.add(button6);
				button6.setBounds(255, 480, 100, 30);

				// ---- button7 ----
				button7.setText("Edit");
				panel5.add(button7);
				button7.setBounds(370, 480, 100, 30);

			}
			panel1.add(panel5);
			panel5.setBounds(470, 90, 490, 520);

			// ---- label21 ----
			label21.setText("Select Store");
			panel1.add(label21);
			label21.setBounds(new Rectangle(new Point(25, 60), label21
					.getPreferredSize()));

			panel1.add(comboBox1);
			comboBox1.setBounds(105, 60, 200, 20);

		}
		contentPane.add(panel1);
		panel1.setBounds(0, 0, 970, 630);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
		setSize(980, 650);
		setLocationRelativeTo(getOwner());

	}

	
	
	
	
	public static void main(String[] args){
		//new BillBookPurchaseDue();
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
