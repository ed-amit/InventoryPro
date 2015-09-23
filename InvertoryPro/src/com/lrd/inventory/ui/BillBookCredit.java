/*
 * Created by JFormDesigner on Mon Jun 01 21:49:55 IST 2015
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
import com.lrd.inventory.main.ValidationMSG;
import com.lrd.inventory.model.SalesBillDetailModel;
import com.lrd.inventory.model.SalesBillModel;
import com.lrd.inventory.model.CreditorModel;

/**
 * @author dharmendra singh
 */
public class BillBookCredit extends JFrame
		implements
			ActionListener,
			ItemListener {

	// Variables declaration
	private JComboBox<Object> comboBox1;
	private JPanel panel1;
	private JPanel panel2;
	private JLabel label1;
	private JPanel panel3;
	private JLabel label2;
	private JScrollPane scrollPane1;
	private DefaultTableModel tableModel1;
	private JTable table1;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JPanel panel4;
	private JLabel label3;
	private JScrollPane scrollPane2;
	private DefaultTableModel tableModel2;
	private JTable table2;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	private JButton button8;
	private JButton button9;
	private JPanel panel5;
	private JLabel label4;
	private JLabel label5;
	private JTextField textField1;
	private JScrollPane scrollPane3;
	private DefaultTableModel tableModel3;
	private JTable table3;
	private JLabel label6;
	private JLabel label7;
	private JTextField textField2;
	private JButton button10;
	private JButton button11;
	private JButton button12;
	// End of variables declaration

	Connection connection = null;
	SpecificFieldValue fieldName = null;
	GetDBValue dbvalue = null;
	TableId tableid = null;
	ArrayList<CreditorModel> creditorList = null;
	ArrayList<SalesBillModel> billList = null;
	ArrayList<SalesBillDetailModel> billDetailList = null;

	private static final long serialVersionUID = 1L;
	public BillBookCredit(Connection connection) {
		this.connection = connection;
		fieldName = new SpecificFieldValue(connection);
		dbvalue = new GetDBValue(connection);
		tableid = new TableId(connection);
		initComponents();
		storeName();
		creditorList = dbvalue.getCreditorDetail(tableid.getStoreId(comboBox1
				.getSelectedItem().toString()));
		loadTable1Data();
	}

	private void initComponents() {

		comboBox1 = new JComboBox<Object>();
		panel1 = new JPanel();
		panel2 = new JPanel();
		label1 = new JLabel();
		panel3 = new JPanel();
		label2 = new JLabel();
		scrollPane1 = new JScrollPane();
		tableModel1 = new DefaultTableModel();
		table1 = new JTable(tableModel1);
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		panel4 = new JPanel();
		label3 = new JLabel();
		scrollPane2 = new JScrollPane();
		tableModel2 = new DefaultTableModel();
		table2 = new JTable(tableModel2);
		button4 = new JButton();
		button5 = new JButton();
		button6 = new JButton();
		button7 = new JButton();
		button8 = new JButton();
		button9 = new JButton();
		panel5 = new JPanel();
		label4 = new JLabel();
		label5 = new JLabel();
		textField1 = new JTextField();
		scrollPane3 = new JScrollPane();
		tableModel3 = new DefaultTableModel();
		table3 = new JTable(tableModel3);
		label6 = new JLabel();
		label7 = new JLabel();
		textField2 = new JTextField();
		button10 = new JButton();
		button11 = new JButton();
		button12 = new JButton();

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
				label1.setText("Bill Book of Creditors");
				label1.setFont(label1.getFont().deriveFont(
						label1.getFont().getSize() + 15f));
				panel2.add(label1);
				label1.setBounds(new Rectangle(new Point(445, 10), label1
						.getPreferredSize()));

			}
			panel1.add(panel2);
			panel2.setBounds(0, 0, 1150, 60);

			// ======== panel3 ========
			{
				panel3.setBorder(UIManager.getBorder("TitledBorder.border"));
				panel3.setLayout(null);

				// ---- label7 ----
				label7.setText("Select Store");
				panel3.add(label7);
				label7.setBounds(new Rectangle(new Point(15, 15), label7
						.getPreferredSize()));
				// -------comboBox1---------
				panel3.add(comboBox1);
				comboBox1.setBounds(100, 15, 150, 20);
				comboBox1.addItemListener(this);

				// ---- label2 ----
				label2.setText("All Credit Customer");
				panel3.add(label2);
				label2.setBounds(new Rectangle(new Point(15, 45), label2
						.getPreferredSize()));

				tableModel1.addColumn("Sr. No.");
				tableModel1.addColumn("Name");
				tableModel1.addColumn("Credit");
				tableModel1.addColumn("Debit");
				// ======== scrollPane1 ========
				{
					scrollPane1.setViewportView(table1);
				}
				panel3.add(scrollPane1);
				scrollPane1.setBounds(20, 65, 320, 395);

				// ---- button1 ----
				button1.setText("View");
				panel3.add(button1);
				button1.setBounds(20, 480, 100, 40);
				button1.addActionListener(this);

				// ---- button2 ----
				button2.setText("Delete");
				panel3.add(button2);
				button2.setBounds(130, 480, 100, 40);
				button2.addActionListener(this);
				button2.setEnabled(false);

				// ---- button3 ----
				button3.setText("Print");
				panel3.add(button3);
				button3.setBounds(240, 480, 100, 40);
				button3.addActionListener(this);

			}
			panel1.add(panel3);
			panel3.setBounds(0, 60, 365, 540);

			// ======== panel4 ========
			{
				panel4.setBorder(UIManager.getBorder("TitledBorder.border"));
				panel4.setLayout(null);

				// ---- label3 ----
				label3.setText("Total bill of Selected Customer");
				panel4.add(label3);
				label3.setBounds(new Rectangle(new Point(15, 15), label3
						.getPreferredSize()));

				tableModel2.addColumn("Sr.");
				tableModel2.addColumn("Bill No");
				tableModel2.addColumn("Date");
				tableModel2.addColumn("Total Amt");
				// ======== scrollPane2 ========
				{
					scrollPane2.setViewportView(table2);
				}
				panel4.add(scrollPane2);
				scrollPane2.setBounds(25, 65, 305, 345);

				// ---- button4 ----
				button4.setText("View");
				panel4.add(button4);
				button4.setBounds(25, 425, 100, 40);
				button4.addActionListener(this);

				// ---- button5 ----
				button5.setText("Delete");
				panel4.add(button5);
				button5.setBounds(130, 425, 100, 40);
				button5.addActionListener(this);
				button5.setEnabled(false);

				// ---- button6 ----
				button6.setText("Print");
				panel4.add(button6);
				button6.setBounds(235, 425, 100, 40);
				button6.addActionListener(this);

				// ---- button7 ----
				button7.setText("Refresh");
				panel4.add(button7);
				button7.setBounds(25, 480, 100, 40);
				button7.addActionListener(this);

				// ---- button8 ----
				button8.setText("text");
				panel4.add(button8);
				button8.setBounds(130, 480, 100, 40);
				button8.setEnabled(false);

				// ---- button9 ----
				button9.setText("text");
				panel4.add(button9);
				button9.setBounds(235, 480, 100, 40);
				button9.setEnabled(false);

			}
			panel1.add(panel4);
			panel4.setBounds(365, 60, 350, 540);

			// ======== panel5 ========
			{
				panel5.setBorder(UIManager.getBorder("TitledBorder.border"));
				panel5.setLayout(null);

				// ---- label4 ----
				label4.setText("Detail of selected bill");
				panel5.add(label4);
				label4.setBounds(new Rectangle(new Point(15, 15), label4
						.getPreferredSize()));

				// ---- label5 ----
				label5.setText("Date");
				panel5.add(label5);
				label5.setBounds(new Rectangle(new Point(240, 15), label5
						.getPreferredSize()));
				panel5.add(textField1);
				textField1.setBounds(275, 15, 150,
						textField1.getPreferredSize().height);
				textField1.setEnabled(false);

				tableModel3.addColumn("Sr");
				tableModel3.addColumn("Product");
				tableModel3.addColumn("Qty");
				tableModel3.addColumn("Unit");
				tableModel3.addColumn("Vate %");
				tableModel3.addColumn("Discount");
				tableModel3.addColumn("Rate");
				tableModel3.addColumn("Sub Toatl");
				// tableModel3.addColumn("");
				// ======== scrollPane3 ========
				{
					scrollPane3.setViewportView(table3);
				}
				panel5.add(scrollPane3);
				scrollPane3.setBounds(20, 65, 395, 355);

				// ---- label6 ----
				label6.setText("Vat (%)");
				panel5.add(label6);
				label6.setBounds(new Rectangle(new Point(255, 440), label6
						.getPreferredSize()));
				panel5.add(textField2);
				textField2.setBounds(315, 440, 100,
						textField2.getPreferredSize().height);
				textField2.setEnabled(false);

				// ---- button10 ----
				button10.setText("Print");
				panel5.add(button10);
				button10.setBounds(50, 480, 100, 40);
				button10.addActionListener(this);

				// ---- button11 ----
				button11.setText("Refresh");
				panel5.add(button11);
				button11.setBounds(180, 480, 100, 40);
				button11.addActionListener(this);

				// ---- button12 ----
				button12.setText("Other Charges");
				panel5.add(button12);
				button12.setBounds(310, 480, 100, 40);
				button12.addActionListener(this);

			}
			panel1.add(panel5);
			panel5.setBounds(715, 60, 435, 540);

		}
		contentPane.add(panel1);
		panel1.setBounds(0, 0, 1150, 600);

		{ // compute preferred size
			Dimension preferredSize = new Dimension();
			for (int i = 0; i < contentPane.getComponentCount(); i++) {
				Rectangle bounds = contentPane.getComponent(i).getBounds();
				preferredSize.width = Math.max(bounds.x + bounds.width,
						preferredSize.width);
				preferredSize.height = Math.max(bounds.y + bounds.height,
						preferredSize.height);
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

	private void storeName() {
		ArrayList<String> storeNames = (ArrayList<String>) fieldName
				.getAllStoreName();
		for (String name : storeNames) {
			comboBox1.addItem(name);
		}
	}

	private void loadTable1Data() {
		// for removing all existing rows from table
		while (tableModel1.getRowCount() > 0) {
			tableModel1.removeRow(0);
		}
		while (tableModel2.getRowCount() > 0) {
			tableModel2.removeRow(0);
		}
		while (tableModel3.getRowCount() > 0) {
			tableModel3.removeRow(0);
		}
		textField1.setText("");
		textField2.setText("");

		int i = 1;
		// / inserting new rows to the table
		for (CreditorModel creditor : creditorList) {
			tableModel1.addRow(new Object[]{i, creditor.getName(),
					creditor.getCreditAmt(), creditor.getDebitAmt()});
			i++;
		}
	}

	private void loadTable2Data() {
		// for removing all existing rows from table
		while (tableModel2.getRowCount() > 0) {
			tableModel2.removeRow(0);
		}
		while (tableModel3.getRowCount() > 0) {
			tableModel3.removeRow(0);
		}

		textField1.setText("");
		textField2.setText("");

		// / inserting new rows to the table
		int i = 1;
		for (SalesBillModel bill : billList) {
			tableModel2.addRow(new Object[]{i, bill.getBillNo(),
					bill.getBillDate(), bill.getTotalAmt()});
			i++;
		}
	}

	private void loadTable3Data() {
		// for removing all existing rows from table
		while (tableModel3.getRowCount() > 0) {
			tableModel3.removeRow(0);
		}
		// / inserting new rows to the table
		int i = 1;
		for (SalesBillDetailModel tempbilldetail : billDetailList) {
			double subtotal = tempbilldetail.getProductQuantity()
					* tempbilldetail.getProductRate();
			tableModel3.addRow(new Object[]{i, tempbilldetail.getProductName(),
					tempbilldetail.getProductQuantity(),
					tempbilldetail.getProductUnit(),
					tempbilldetail.getVatPercent(),
					tempbilldetail.getDiscountAmt(),
					tempbilldetail.getProductRate(), subtotal});
		}
	}

	@Override
	public void itemStateChanged(ItemEvent event) {

		if (event.getSource() == comboBox1) {
			creditorList = dbvalue.getCreditorDetail(tableid
					.getStoreId(comboBox1.getSelectedItem().toString()));
			loadTable1Data();
		}

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if (event.getSource() == button1) {
			viewCreditorBill();
		}
		if (event.getSource() == button2) {

		}
		if (event.getSource() == button3) {

		}
		if (event.getSource() == button4) {
			viewBillDetail();
		}
		if (event.getSource() == button5) {

		}
		if (event.getSource() == button6) {
			
		}
		if (event.getSource() == button7) {
			billList = new ArrayList<>();
			billDetailList = new ArrayList<>();
			loadTable2Data();
			loadTable3Data();
		}
		if (event.getSource() == button8) {

		}
		if (event.getSource() == button9) {

		}
		if (event.getSource() == button10) {

		}
		if (event.getSource() == button11) {
			billDetailList = new ArrayList<>();
			loadTable3Data();
		}
		if (event.getSource() == button12) {

		}
	}

	private void viewBillDetail() {
		// TODO Auto-generated method stub
		boolean status = true;

		if (table2.getSelectedRowCount() != 1) {
			status = false;
			new ValidationMSG(this, "Please Select A Row from Table Then Click");
		}

		if (status) {
			int selectedBill = table2.getSelectedRow();
			int billId = billList.get(selectedBill).getBillId();
			billDetailList = dbvalue.getBillProductDetail(billId);
			textField1.setText(billList.get(selectedBill).getBillDate());
			textField2.setText(String.valueOf(billList.get(selectedBill)
					.getVatPercent()));
			loadTable3Data();
		}
	}

	private void viewCreditorBill() {
		// TODO Auto-generated method stub
		boolean status = true;

		if (table1.getSelectedRowCount() != 1) {
			status = false;
			new ValidationMSG(this, "Please Select A Row from Table Then Click");
		}

		if (status) {
			int selectedCreditor = table1.getSelectedRow();
			String creditorName = creditorList.get(selectedCreditor).getName();
			String contact = creditorList.get(selectedCreditor).getContactNo();
			int storeId = creditorList.get(selectedCreditor).getStoreId();
			billList = dbvalue.getCreditorBill(creditorName, contact, storeId);
			loadTable2Data();
		}
	}
}
