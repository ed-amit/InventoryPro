/*
 * Created by JFormDesigner on Sun May 31 11:39:07 IST 2015
 */

package com.lrd.inventory.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.lrd.inventory.database.DatabaseInsert;
import com.lrd.inventory.database.GetDBValue;
import com.lrd.inventory.database.SpecificFieldValue;
import com.lrd.inventory.database.TableId;
import com.lrd.inventory.main.Validate;
import com.lrd.inventory.model.PurchaseBillDetailModel;
import com.lrd.inventory.model.PurchaseBillModel;
import com.lrd.inventory.model.PurchaseReturnModel;

/**
 * @author dharmendra singh
 */
public class PurchaseReturn extends JFrame
		implements
			ActionListener,
			ItemListener,
			KeyListener,
			ListSelectionListener,
			FocusListener {

	private static final long serialVersionUID = 1L;
	// Variables declaration
	private JPanel panel1;
	private JPanel panel2;
	private JLabel label1;
	private JPanel panel3;
	private JLabel label2;
	private JComboBox<Object> comboBox1;
	private JPanel panel4;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JScrollPane scrollPane1;
	private JTable table1;
	private JScrollPane scrollPane2;
	private JTable table2;
	private JLabel label6;
	private JTextField textField4;
	private JLabel label7;
	private JComboBox<Object> comboBox2;
	private JLabel label8;
	private JTextField textField5;
	private JLabel label9;
	private JTextField textField6;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private DefaultTableModel tableModel1;
	private DefaultTableModel tableModel2;
	// End of variables declaration

	Connection connection = null;
	SpecificFieldValue fieldName;
	TableId tableid = null;
	DatabaseInsert dbinsert = null;
	Validate valid = null;
	GetDBValue dbValue = null;

	ArrayList<PurchaseBillModel> purchaseBillList = null;
	ArrayList<PurchaseBillModel> purchaseBillDisplayList = null;
	ArrayList<PurchaseBillDetailModel> PurchaseBillDetailList = null;

	public PurchaseReturn(Connection connection) {
		this.connection = connection;
		fieldName = new SpecificFieldValue(connection);
		tableid = new TableId(connection);
		dbinsert = new DatabaseInsert(connection);
		valid = new Validate();
		dbValue = new GetDBValue(connection);
		initComponents();
		storeName();
		purchaseBillList = dbValue.getPurchaseBill(tableid.getStoreId(comboBox1
				.getSelectedItem().toString()));
		purchaseBillDisplayList = new ArrayList<>();
	}

	private void initComponents() {

		panel1 = new JPanel();
		panel2 = new JPanel();
		label1 = new JLabel();
		panel3 = new JPanel();
		label2 = new JLabel();
		comboBox1 = new JComboBox<Object>();
		panel4 = new JPanel();
		label3 = new JLabel();
		label4 = new JLabel();
		label5 = new JLabel();
		textField1 = new JTextField();
		textField2 = new JTextField();
		textField3 = new JTextField();
		scrollPane1 = new JScrollPane();
		tableModel1 = new DefaultTableModel();
		table1 = new JTable(tableModel1);
		scrollPane2 = new JScrollPane();
		tableModel2 = new DefaultTableModel();
		table2 = new JTable(tableModel2);
		label6 = new JLabel();
		textField4 = new JTextField();
		label7 = new JLabel();
		comboBox2 = new JComboBox<Object>();
		label8 = new JLabel();
		textField5 = new JTextField();
		label9 = new JLabel();
		textField6 = new JTextField();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();

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
				label1.setText("Purchase Returns");
				label1.setFont(label1.getFont().deriveFont(
						label1.getFont().getSize() + 15f));
				panel2.add(label1);
				label1.setBounds(new Rectangle(new Point(270, 25), label1
						.getPreferredSize()));

			}
			panel1.add(panel2);
			panel2.setBounds(0, 0, 755, 85);

			// ======== panel3 ========
			{
				panel3.setLayout(null);

				// ---- label2 ----
				label2.setText("Store Name");
				panel3.add(label2);
				label2.setBounds(new Rectangle(new Point(40, 10), label2
						.getPreferredSize()));

				panel3.add(comboBox1);
				comboBox1.setBounds(140, 10, 200,
						comboBox1.getPreferredSize().height);
				comboBox1.addItemListener(this);

				// ======== panel4 ========
				{
					panel4.setBorder(UIManager.getBorder("TitledBorder.border"));
					panel4.setLayout(null);

					// ---- label3 ----
					label3.setText("Supplier Name");
					panel4.add(label3);
					label3.setBounds(new Rectangle(new Point(30, 10), label3
							.getPreferredSize()));

					panel4.add(textField1);
					textField1.setBounds(130, 10, 200, 20);
					textField1.addKeyListener(this);
					textField1.addFocusListener(this);

					// ---- label4 ----
					label4.setText("Bill No");
					panel4.add(label4);
					label4.setBounds(new Rectangle(new Point(30, 40), label4
							.getPreferredSize()));

					panel4.add(textField2);
					textField2.setBounds(130, 40, 200, 20);
					textField2.addKeyListener(this);
					textField2.addFocusListener(this);

					// ---- label5 ----
					label5.setText("Date");
					panel4.add(label5);
					label5.setBounds(new Rectangle(new Point(560, 10), label5
							.getPreferredSize()));

					panel4.add(textField3);
					textField3.setBounds(595, 10, 100,
							textField3.getPreferredSize().height);
					textField3.addKeyListener(this);
					textField3.addFocusListener(this);

					tableModel1.addColumn("Bill No");
					tableModel1.addColumn("Date");
					tableModel1.addColumn("Name");
					tableModel1.addColumn("Amount");
					table1.getSelectionModel().addListSelectionListener(this);
					// ======== scrollPane1 ========
					{
						scrollPane1.setViewportView(table1);
					}
					panel4.add(scrollPane1);
					scrollPane1.setBounds(30, 70, 665, 140);

					tableModel2.addColumn("Product Code");
					tableModel2.addColumn("Name");
					tableModel2.addColumn("Quantity");
					tableModel2.addColumn("Unit");
					tableModel2.addColumn("Rate");
					tableModel2.addColumn("Vat %");
					tableModel2.addColumn("Total");
					table2.getSelectionModel().addListSelectionListener(this);
					// ======== scrollPane2 ========
					{
						scrollPane2.setViewportView(table2);
					}
					panel4.add(scrollPane2);
					scrollPane2.setBounds(30, 220, 665, 140);

					// ---- label6 ----
					label6.setText("Product");
					panel4.add(label6);
					label6.setBounds(new Rectangle(new Point(30, 370), label6
							.getPreferredSize()));

					panel4.add(textField4);
					textField4.setBounds(100, 370, 150, 20);
					textField4.setEnabled(false);

					// ---- label7 ----
					label7.setText("Unit");
					panel4.add(label7);
					label7.setBounds(new Rectangle(new Point(30, 400), label7
							.getPreferredSize()));
					panel4.add(comboBox2);
					comboBox2.setBounds(100, 400, 150, 20);

					// ---- label8 ----
					label8.setText("Quantity");
					panel4.add(label8);
					label8.setBounds(new Rectangle(new Point(310, 370), label8
							.getPreferredSize()));
					panel4.add(textField5);
					textField5.setBounds(380, 370, 150, 20);

					// ---- label9 ----
					label9.setText("Rate");
					panel4.add(label9);
					label9.setBounds(new Rectangle(new Point(310, 400), label9
							.getPreferredSize()));
					panel4.add(textField6);
					textField6.setBounds(380, 400, 150, 20);
					textField6.setEnabled(false);

					// ---- button1 ----
					button1.setText("Return");
					panel4.add(button1);
					button1.setBounds(590, 370, 100, 20);
					button1.addActionListener(this);

					// ---- button2 ----
					button2.setText("Replace");
					panel4.add(button2);
					button2.setBounds(590, 400, 100, 20);
					button2.addActionListener(this);

					// ---- button3 ----
					button3.setText("Refresh");
					panel4.add(button3);
					button3.setBounds(230, 440, 100, 30);
					button3.addActionListener(this);

					// ---- button4 ----
					button4.setText("Cancel");
					panel4.add(button4);
					button4.setBounds(400, 440, 100, 30);
					button4.addActionListener(this);

				}
				panel3.add(panel4);
				panel4.setBounds(10, 45, 730, 490);

			}
			panel1.add(panel3);
			panel3.setBounds(0, 85, 755, 560);

		}
		contentPane.add(panel1);
		panel1.setBounds(0, 0, 755, 640);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
		setSize(760, 670);
	}

	public static void main(String[] args) {
		// new PurchaseReturn();
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

		// / inserting new rows to the table
		for (PurchaseBillModel purchaseBill : purchaseBillDisplayList) {
			tableModel1
					.addRow(new Object[]{purchaseBill.getBillNo(),
							purchaseBill.getPurchaseDate(),
							purchaseBill.getAgencyName(),
							purchaseBill.getGrandTotal()});
		}
	}

	private void loadTable2Data() {
		// for removing all existing rows from table
		while (tableModel2.getRowCount() > 0) {
			tableModel2.removeRow(0);
		}

		// / inserting new rows to the table
		for (PurchaseBillDetailModel purchaseBillDetail : PurchaseBillDetailList) {
			tableModel2.addRow(new Object[]{
					purchaseBillDetail.getProductCode(),
					purchaseBillDetail.getProductName(),
					purchaseBillDetail.getQuantity(),
					purchaseBillDetail.getUnit(),
					purchaseBillDetail.getPurchasePrice(),
					purchaseBillDetail.getVatPercent(),
					purchaseBillDetail.getTotalCost()});
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent event) {
		// TODO Auto-generated method stub
		if (event.getSource() == textField1) {
			if (valid.isEmpty(textField1.getText())) {
				purchaseBillDisplayList = new ArrayList<>();
			} else {
				String str = textField1.getText();
				for (PurchaseBillModel purchaseBill : purchaseBillList) {
					if (purchaseBill.getAgencyName().contains(str)) {
						purchaseBillDisplayList.add(purchaseBill);
					}
				}
			}
			loadTable1Data();
		}
		if (event.getSource() == textField2) {
			if (valid.isEmpty(textField2.getText())) {
				purchaseBillDisplayList = new ArrayList<>();
			} else {
				String str = textField2.getText();
				for (PurchaseBillModel purchaseBill : purchaseBillList) {
					if (purchaseBill.getBillNo().contains(str)) {
						purchaseBillDisplayList.add(purchaseBill);
					}
				}
			}
			loadTable1Data();
		}
		if (event.getSource() == textField3) {
			if (valid.isEmpty(textField3.getText())) {
				purchaseBillDisplayList = new ArrayList<>();
			} else {
				String str = textField3.getText();
				for (PurchaseBillModel purchaseBill : purchaseBillList) {
					if (purchaseBill.getPurchaseDate().contains(str)) {
						purchaseBillDisplayList.add(purchaseBill);
					}
				}
			}
			loadTable1Data();
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void itemStateChanged(ItemEvent event) {
		// TODO Auto-generated method stub
		if (event.getSource() == comboBox1) {
			purchaseBillList = dbValue.getPurchaseBill(tableid
					.getStoreId(comboBox1.getSelectedItem().toString()));
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		switch (event.getActionCommand().toUpperCase()) {
			case "RETURN" :
				saveReturnModel();
				UpdateProductStock();
				resetAllField();
				break;
			case "REPLACE" :
				saveReturnModel();
				resetAllField();
				break;
			case "REFRESH" :
				resetAllField();
				break;
			case "CANCEL" :
				this.dispose();
				break;
			default :
				this.dispose();
		}
	}

	private void saveReturnModel() {
		if (!valid.isEmpty(textField5.getText())
				&& !valid.isEmpty(textField4.getText())) {
			PurchaseReturnModel purchaseReturn = new PurchaseReturnModel();

			String currentDate = String.valueOf(Calendar.getInstance().get(
					Calendar.YEAR))
					+ "-"
					+ String.valueOf(Calendar.getInstance().get(Calendar.MONTH) + 1)
					+ "-"
					+ String.valueOf(Calendar.getInstance().get(Calendar.DATE));
			double qty = Double.parseDouble(textField5.getText());
			double purchasePrice = PurchaseBillDetailList.get(
					table2.getSelectedRow()).getPurchasePrice();
			double vatPercent = PurchaseBillDetailList.get(
					table2.getSelectedRow()).getVatPercent();
			double vatAmount = ((purchasePrice * qty) * vatPercent) / 100;

			purchaseReturn.setReturnId(0);
			purchaseReturn.setBillNumber(purchaseBillDisplayList.get(
					table1.getSelectedRow()).getBillNo());
			purchaseReturn.setBillDetailId(PurchaseBillDetailList.get(
					table2.getSelectedRow()).getPurchaseDetailId());
			purchaseReturn.setBillId(purchaseBillDisplayList.get(
					table1.getSelectedRow()).getBillId());
			purchaseReturn.setProductName(PurchaseBillDetailList.get(
					table2.getSelectedRow()).getProductName());
			purchaseReturn.setProductCode(PurchaseBillDetailList.get(
					table2.getSelectedRow()).getProductCode());
			purchaseReturn.setPurchasePrice(purchasePrice);
			purchaseReturn.setQuantity(qty);

			purchaseReturn.setReturnDate(currentDate);
			purchaseReturn.setTotalCost((purchasePrice * qty) + vatAmount);
			purchaseReturn.setUnit(comboBox2.getSelectedItem().toString());
			purchaseReturn.setVatAmount(vatAmount);
			purchaseReturn.setVatPercent(vatPercent);
			purchaseReturn.setStoreId(tableid.getStoreId(comboBox1
					.getSelectedItem().toString()));
			int startYear = Calendar.getInstance().get(Calendar.YEAR);
			purchaseReturn.setYearId(tableid
					.getYearId(startYear, startYear + 1));

			dbinsert.insertPurchaseReturn(purchaseReturn);
		} else {
			// /show dialog for requird field
		}
	}

	private void UpdateProductStock() {
		String productName = PurchaseBillDetailList
				.get(table2.getSelectedRow()).getProductName();
		String productCode = PurchaseBillDetailList
				.get(table2.getSelectedRow()).getProductCode();
		dbinsert.updateProduct(productName, productCode,
				Double.parseDouble(textField5.getText()));
	}

	private void resetAllField() {
		textField1.setText("");
		textField1.requestFocus();
		purchaseBillList = dbValue.getPurchaseBill(tableid.getStoreId(comboBox1
				.getSelectedItem().toString()));
		loadTable1Data();
	}

	@Override
	public void valueChanged(ListSelectionEvent event) {
		// TODO Auto-generated method stub
		if (event.getSource() == table1.getSelectionModel()) {
			if (table1.getRowCount() > 0 && table1.getSelectedRow() >= 0) {
				int billId = purchaseBillDisplayList.get(
						table1.getSelectedRow()).getBillId();
				PurchaseBillDetailList = dbValue.getPurchaseBillDetail(billId);
			} else {
				PurchaseBillDetailList = new ArrayList<>();
			}
			loadTable2Data();
		}

		if (event.getSource() == table2.getSelectionModel()) {
			if (table2.getRowCount() > 0 && table2.getSelectedRow() >= 0) {
				textField4.setText(PurchaseBillDetailList.get(
						table2.getSelectedRow()).getProductName());
				textField5.setText("");
				textField5.requestFocus();
				Double purchasePrice = PurchaseBillDetailList.get(
						table2.getSelectedRow()).getPurchasePrice();
				textField6.setText(String.valueOf(purchasePrice));
				comboBox2.removeAllItems();
				comboBox2.addItem(PurchaseBillDetailList.get(
						table2.getSelectedRow()).getUnit());
			} else {
				textField4.setText("");
				textField5.setText("");
				textField6.setText("");
				comboBox2.removeAllItems();
			}
		}
	}

	@Override
	public void focusGained(FocusEvent event) {
		// TODO Auto-generated method stub
		if (event.getSource() == textField1) {
			textField2.setText("");
			textField3.setText("");
			purchaseBillDisplayList = new ArrayList<>();
			loadTable1Data();
		}
		if (event.getSource() == textField2) {
			textField1.setText("");
			textField3.setText("");
			purchaseBillDisplayList = new ArrayList<>();
			loadTable1Data();
		}
		if (event.getSource() == textField3) {
			textField2.setText("");
			textField1.setText("");
			purchaseBillDisplayList = new ArrayList<>();
			loadTable1Data();
		}
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub

	}
}
