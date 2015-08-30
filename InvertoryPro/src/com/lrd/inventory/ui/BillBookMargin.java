/*
 * Created by JFormDesigner on Mon Jun 01 23:45:11 IST 2015
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
public class BillBookMargin extends JFrame {

	private static final long serialVersionUID = 1L;

	// Variables declaration
	private JPanel panel1;
	private JPanel panel2;
	private JLabel label1;
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

	// End of variables declaration
	
	Connection connection=null;

	public BillBookMargin(Connection connection) {
		this.connection=connection;
		initComponents();
		storeName();
	}

	private void initComponents() {

		panel1 = new JPanel();
		panel2 = new JPanel();
		label1 = new JLabel();
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
				label1.setText("Margin Book");
				label1.setFont(label1.getFont().deriveFont(
						label1.getFont().getSize() + 15f));
				panel2.add(label1);
				label1.setBounds(new Rectangle(new Point(385, 10), label1
						.getPreferredSize()));

			}
			panel1.add(panel2);
			panel2.setBounds(0, 0, 930, 60);

			// ======== panel3 ========
			{
				panel3.setLayout(null);

				// ---- label2 ----
				label2.setText("Select Store");
				panel3.add(label2);
				label2.setBounds(new Rectangle(new Point(200, 30), label2
						.getPreferredSize()));

				panel3.add(comboBox1);
				comboBox1.setBounds(300, 30, 200,
						comboBox1.getPreferredSize().height);

				// ---- label3 ----
				label3.setText("Search Criteria");
				panel3.add(label3);
				label3.setBounds(new Rectangle(new Point(200, 70), label3
						.getPreferredSize()));

				panel3.add(comboBox2);
				comboBox2.setBounds(300, 70, 200,
						comboBox2.getPreferredSize().height);

				// ---- label4 ----
				label4.setText("From Date");
				panel3.add(label4);
				label4.setBounds(new Rectangle(new Point(200, 110), label4
						.getPreferredSize()));

				panel3.add(textField1);
				textField1.setBounds(300, 110, 150,
						textField1.getPreferredSize().height);

				// ---- label7 ----
				label7.setText("To Date");
				panel3.add(label7);
				label7.setBounds(new Rectangle(new Point(490, 110), label7
						.getPreferredSize()));

				panel3.add(textField4);
				textField4.setBounds(565, 110, 150,
						textField4.getPreferredSize().height);

				// ---- label5 ----
				label5.setText("Bill No.");
				panel3.add(label5);
				label5.setBounds(new Rectangle(new Point(200, 150), label5
						.getPreferredSize()));

				panel3.add(textField2);
				textField2.setBounds(300, 150, 200,
						textField2.getPreferredSize().height);

				// ---- label6 ----
				label6.setText("Customer Name");
				panel3.add(label6);
				label6.setBounds(new Rectangle(new Point(200, 190), label6
						.getPreferredSize()));

				panel3.add(textField3);
				textField3.setBounds(300, 190, 200,
						textField3.getPreferredSize().height);

				// ---- button1 ----
				button1.setText("Search");
				panel3.add(button1);
				button1.setBounds(285, 230, 100, 30);

				// ---- button2 ----
				button2.setText("Clear");
				panel3.add(button2);
				button2.setBounds(440, 230, 100, 30);

				// ======== scrollPane1 ========
				{
					scrollPane1.setViewportView(table1);
				}
				panel3.add(scrollPane1);
				scrollPane1.setBounds(30, 295, 865, 280);

			}
			panel1.add(panel3);
			panel3.setBounds(0, 60, 925, 615);

		}
		contentPane.add(panel1);
		panel1.setBounds(0, 0, 925, 675);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
		setSize(940, 700);
		setLocationRelativeTo(getOwner());

	}

	public static void main(String[] args) {
		//new BillBookMargin();
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
