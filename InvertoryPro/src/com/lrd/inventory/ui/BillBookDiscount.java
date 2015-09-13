/*
 * Created by JFormDesigner on Mon Jun 01 23:58:17 IST 2015
 */

package com.lrd.inventory.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.util.ArrayList;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.lrd.inventory.database.GetDBValue;
import com.lrd.inventory.database.SpecificFieldValue;
import com.lrd.inventory.database.TableId;
import com.lrd.inventory.main.DatePicker;
import com.lrd.inventory.main.Validate;
import com.lrd.inventory.main.ValidationMSG;
import com.lrd.inventory.model.SalesBillModel;


/**
 * @author dharmendra singh
 */
public class BillBookDiscount extends JFrame
		implements
			ActionListener,
			ItemListener {

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
	private DefaultTableModel tableModel1;
	private JTable table1;
	private JLabel label7;
	private JTextField textField4;
	private JButton button5;
	private JButton button6;
	private JLabel totalAmountLabel;
	private JLabel totalDiscountLabel;
	// End of variables declaration

	Connection connection = null;

	SpecificFieldValue fieldName = null;
	GetDBValue dbvalue = null;
	TableId tableid = null;
	Validate valid = null;

	

	ArrayList<SalesBillModel> saleBillList = null;

	public BillBookDiscount(Connection connection) {
		this.connection = connection;
		fieldName = new SpecificFieldValue(connection);
		dbvalue = new GetDBValue(connection);
		tableid = new TableId(connection);
		valid = new Validate();
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
		tableModel1 = new DefaultTableModel();
		table1 = new JTable(tableModel1);
		label7 = new JLabel();
		textField4 = new JTextField();
		button5 = new JButton();
		button6 = new JButton();
		totalAmountLabel = new JLabel("");
		totalDiscountLabel = new JLabel("");
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
				label1.setText("Discount Book");
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
				comboBox1.addItemListener(this);

				// ---- label3 ----
				label3.setText("Search Criteria");
				panel3.add(label3);
				label3.setBounds(new Rectangle(new Point(200, 70), label3
						.getPreferredSize()));

				panel3.add(comboBox2);
				comboBox2.setBounds(300, 70, 200,
						comboBox2.getPreferredSize().height);
				comboBox2.addItem("Date Wise");
				comboBox2.addItem("Bill No");
				comboBox2.addItem("Customer Name");
				comboBox2.addItemListener(this);

				// ---- label4 ----
				label4.setText("From Date");
				panel3.add(label4);
				label4.setBounds(new Rectangle(new Point(200, 110), label4
						.getPreferredSize()));

				panel3.add(textField1);
				textField1.setBounds(300, 110, 150,
						textField1.getPreferredSize().height);
				textField1.setEnabled(false);
				// ---- button5 ----
				button5.setText("...");
				panel3.add(button5);
				button5.setBounds(450, 110, 27, 20);
				button5.addActionListener(this);

				// ---- label7 ----
				label7.setText("To Date");
				panel3.add(label7);
				label7.setBounds(new Rectangle(new Point(490, 110), label7
						.getPreferredSize()));
				panel3.add(textField4);
				textField4.setBounds(565, 110, 150,
						textField4.getPreferredSize().height);
				textField4.setEnabled(false);
				// ---- button6 ----
				button6.setText("...");
				panel3.add(button6);
				button6.setBounds(715, 110, 27, 20);
				button6.addActionListener(this);

				// ---- label5 ----
				label5.setText("Bill No.");
				panel3.add(label5);
				label5.setBounds(new Rectangle(new Point(200, 150), label5
						.getPreferredSize()));

				panel3.add(textField2);
				textField2.setBounds(300, 150, 200,
						textField2.getPreferredSize().height);
				textField2.setEnabled(false);

				// ---- label6 ----
				label6.setText("Customer Name");
				panel3.add(label6);
				label6.setBounds(new Rectangle(new Point(200, 190), label6
						.getPreferredSize()));

				panel3.add(textField3);
				textField3.setBounds(300, 190, 200,
						textField3.getPreferredSize().height);
				textField3.setEnabled(false);

				// ---- button1 ----
				button1.setText("Search");
				panel3.add(button1);
				button1.setBounds(285, 230, 100, 30);
				button1.addActionListener(this);

				// ---- button2 ----
				button2.setText("Clear");
				panel3.add(button2);
				button2.setBounds(440, 230, 100, 30);
				button2.addActionListener(this);

				tableModel1.addColumn("Sr No");
				tableModel1.addColumn("Bill No");
				tableModel1.addColumn("Date");
				tableModel1.addColumn("Customer Name");
				// tableModel1.addColumn("Discount %");
				tableModel1.addColumn("Discount Rs");
				tableModel1.addColumn("Total Amt");
				// ======== scrollPane1 ========
				{
					scrollPane1.setViewportView(table1);
				}
				panel3.add(scrollPane1);
				scrollPane1.setBounds(30, 270, 865, 250);
				
				totalDiscountLabel.setBounds(600, 520, 100, 20);
				totalDiscountLabel.setForeground(Color.BLUE);
				panel3.add(totalDiscountLabel);
				
				totalAmountLabel.setBounds(750, 520, 100, 20);
				totalAmountLabel.setForeground(Color.BLUE);
				panel3.add(totalAmountLabel);

			}
			panel1.add(panel3);
			panel3.setBounds(0, 60, 925, 540);

		}
		contentPane.add(panel1);
		panel1.setBounds(0, 0, 925, 660);

		pack();
		setVisible(true);
		setSize(940, 660);
		setLocationRelativeTo(getOwner());

	}

	public static void main(String[] args) {
		// new BillBookDiscount();
	}

	private void storeName() {
		ArrayList<String> storeNames = (ArrayList<String>) fieldName
				.getAllStoreName();
		for (String name : storeNames) {
			comboBox1.addItem(name);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent event) {
		// TODO Auto-generated method stub
		if (event.getSource() == comboBox1) {

		}

		if (event.getSource() == comboBox2) {
			// System.out.println("sjdhgldfhgldfh");
			if (comboBox2.getSelectedItem().toString() == "Date Wise") {
				textField1.setText("");
				textField1.setEnabled(false);
				button5.setEnabled(true);
				button5.requestFocus();
				textField2.setText("");
				textField2.setEnabled(false);
				textField3.setText("");
				textField3.setEnabled(false);
				textField4.setText("");
				textField4.setEnabled(false);
				button6.setEnabled(true);
			} else if (comboBox2.getSelectedItem().toString() == "Bill No") {
				textField1.setText("");
				textField1.setEnabled(false);
				button5.setEnabled(false);
				textField2.setText("");
				textField2.setEnabled(true);
				textField2.requestFocus();
				textField3.setText("");
				textField3.setEnabled(false);
				textField4.setText("");
				textField4.setEnabled(false);
				button6.setEnabled(false);
			} else {
				textField1.setText("");
				textField1.setEnabled(false);
				button5.setEnabled(false);
				textField2.setText("");
				textField2.setEnabled(false);
				textField3.setText("");
				textField3.setEnabled(true);
				textField3.requestFocus();
				textField4.setText("");
				textField4.setEnabled(false);
				button6.setEnabled(false);
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if (event.getSource() == button1) {
			int storeId = tableid.getStoreId(comboBox1.getSelectedItem()
					.toString());
			if (comboBox2.getSelectedItem().toString() == "Date Wise") {
				String fromDate = textField1.getText();
				String toDate = textField4.getText();
				if (!valid.isEmpty(fromDate) && !valid.isEmpty(toDate)) {
					this.saleBillList = dbvalue.getAllBill(storeId, fromDate,
							toDate);
				} else {
					new ValidationMSG(this, "Please Select From And To Date");
				}
			} else if (comboBox2.getSelectedItem().toString() == "Bill No") {
				String billNo = textField2.getText();
				
				if (!valid.isEmpty(billNo)) {
					this.saleBillList = dbvalue.getAllBill(billNo, "billId",
							storeId);
					//System.out.println(saleBillList.size());
				}
			} else {
				String customerName = textField3.getText();
				if (!valid.isEmpty(customerName)) {
					this.saleBillList = dbvalue.getAllBill(customerName,
							"customerName", storeId);
				}
			}
			loadTable1Data(saleBillList);
		}

		if (event.getSource() == button2) {
			textField1.setText("");
			textField2.setText("");
			textField3.setText("");
			textField4.setText("");
		}

		if (event.getSource() == button5) {
			final JFrame f = new JFrame();
			textField1.setText(new DatePicker(f).setPickedDate());
		}

		if (event.getSource() == button6) {
			final JFrame f = new JFrame();
			textField4.setText(new DatePicker(f).setPickedDate());
		}

	}

	private void loadTable1Data(ArrayList<SalesBillModel> tempSaleBillList) {
		// TODO Auto-generated method stub
		while (tableModel1.getRowCount() > 0) {
			tableModel1.removeRow(0);
		}
		//System.out.println(tempSaleBillList.size());
		double totalAmt=0,totalDiscount=0;
		int i = 1;
		for (SalesBillModel saleBill : tempSaleBillList) {
			tableModel1.addRow(new Object[]{i, saleBill.getBillNo(),
					saleBill.getBillDate(), saleBill.getCustomerName(),
					saleBill.getDiscount(), saleBill.getTotalAmt()});
			totalAmt += saleBill.getTotalAmt();
			totalDiscount += saleBill.getDiscount();
			i++;
		}
		
		totalAmountLabel.setText(String.valueOf(totalAmt));
		totalDiscountLabel.setText(String.valueOf(totalDiscount));
	}
}
