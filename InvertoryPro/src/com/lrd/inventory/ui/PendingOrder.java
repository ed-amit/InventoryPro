package com.lrd.inventory.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.lrd.inventory.database.GetDBValue;
import com.lrd.inventory.database.SpecificFieldValue;
import com.lrd.inventory.database.TableId;
import com.lrd.inventory.main.DatePicker;
import com.lrd.inventory.main.Validate;
import com.lrd.inventory.main.ValidationMSG;
import com.lrd.inventory.model.PurchaseOrderModel;
import com.lrd.inventory.model.SaleOrderModel;

/**
 * @author dharmendra singh
 */
public class PendingOrder extends JFrame
		implements
			ActionListener,
			ItemListener {

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
	private DefaultTableModel tableModel1;
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
	private DefaultTableModel tableModel2;
	private JTable table2;
	private JLabel label13;
	private JTextField textField8;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	private JButton button8;
	// End of variables declaration

	Connection connection = null;
	SpecificFieldValue fieldName = null;
	GetDBValue dbvalue = null;
	TableId tableid = null;
	Validate valid = null;

	java.text.SimpleDateFormat sdf;

	ArrayList<SaleOrderModel> PendingSaleOrderList = null;
	ArrayList<PurchaseOrderModel> pendingPurchaseOrderList = null;

	public PendingOrder(Connection connection) {
		this.connection = connection;
		fieldName = new SpecificFieldValue(connection);
		dbvalue = new GetDBValue(connection);
		tableid = new TableId(connection);
		valid = new Validate();
		sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		initComponents();
		storeName();
		comboBox2.setSelectedIndex(1);
		comboBox4.setSelectedIndex(1);
		textField2.requestFocus();

	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
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
		tableModel1 = new DefaultTableModel();
		table1 = new JTable(tableModel1);
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
		tableModel2 = new DefaultTableModel();
		table2 = new JTable(tableModel2);
		label13 = new JLabel();
		textField8 = new JTextField();
		button5 = new JButton();
		button6 = new JButton();
		button7 = new JButton();
		button8 = new JButton();

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
				label1.setText("Pending Order Book");
				label1.setFont(label1.getFont().deriveFont(
						label1.getFont().getSize() + 15f));
				panel2.add(label1);
				label1.setBounds(new Rectangle(new Point(385, 10), label1
						.getPreferredSize()));

			}
			panel1.add(panel2);
			panel2.setBounds(0, 0, 930, 60);

			// ======== tabbedPane1 ========
			{

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
					comboBox2.addItem("Date");
					comboBox2.addItem("Order No");
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
					// ---- button6 ----
					button6.setText("...");
					panel3.add(button6);
					button6.setBounds(715, 110, 27, 20);
					button6.addActionListener(this);

					// ---- label5 ----
					label5.setText("Order No");
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
					button1.addActionListener(this);

					// ---- button2 ----
					button2.setText("Clear");
					panel3.add(button2);
					button2.setBounds(440, 230, 100, 30);
					button2.addActionListener(this);

					tableModel1.addColumn("Sr. no");
					tableModel1.addColumn("Order No");
					tableModel1.addColumn("Order Date");
					tableModel1.addColumn("Cust. Name");
					tableModel1.addColumn("Days");
					tableModel1.addColumn("Remaning days");
					tableModel1.addColumn("Total Items");
					// ======== scrollPane1 ========
					{
						scrollPane1.setViewportView(table1);
					}
					panel3.add(scrollPane1);
					scrollPane1.setBounds(30, 280, 865, 280);

				}
				tabbedPane1.addTab("Customer Order", panel3);

				// ======== panel4 ========
				{
					panel4.setLayout(null);

					// ---- label8 ----
					label8.setText("Select Store");
					panel4.add(label8);
					label8.setBounds(new Rectangle(new Point(200, 30), label8
							.getPreferredSize()));

					panel4.add(comboBox3);
					comboBox3.setBounds(300, 30, 200,
							comboBox3.getPreferredSize().height);
					comboBox3.addItemListener(this);

					// ---- label9 ----
					label9.setText("Search Criteria");
					panel4.add(label9);
					label9.setBounds(new Rectangle(new Point(200, 70), label9
							.getPreferredSize()));

					panel4.add(comboBox4);
					comboBox4.setBounds(300, 70, 200,
							comboBox4.getPreferredSize().height);
					comboBox4.addItem("Date");
					comboBox4.addItem("Order No");
					comboBox4.addItem("Supplier Name");
					comboBox4.addItemListener(this);

					// ---- label10 ----
					label10.setText("From Date");
					panel4.add(label10);
					label10.setBounds(new Rectangle(new Point(200, 110),
							label10.getPreferredSize()));

					panel4.add(textField5);
					textField5.setBounds(300, 110, 150,
							textField5.getPreferredSize().height);
					// ---- button7 ----
					button7.setText("...");
					panel4.add(button7);
					button7.setBounds(450, 110, 27, 27);
					button7.addActionListener(this);

					// ---- label13 ----
					label13.setText("To Date");
					panel4.add(label13);
					label13.setBounds(new Rectangle(new Point(490, 110),
							label13.getPreferredSize()));

					panel4.add(textField8);
					textField8.setBounds(565, 110, 150,
							textField8.getPreferredSize().height);
					// ---- button8 ----
					button8.setText("...");
					panel4.add(button8);
					button8.setBounds(715, 110, 27, 27);
					button8.addActionListener(this);

					// ---- label11 ----
					label11.setText("Order No");
					panel4.add(label11);
					label11.setBounds(new Rectangle(new Point(200, 150),
							label11.getPreferredSize()));

					panel4.add(textField6);
					textField6.setBounds(300, 150, 200,
							textField6.getPreferredSize().height);

					// ---- label12 ----
					label12.setText("Customer Name");
					panel4.add(label12);
					label12.setBounds(new Rectangle(new Point(200, 190),
							label12.getPreferredSize()));

					panel4.add(textField7);
					textField7.setBounds(300, 190, 200,
							textField7.getPreferredSize().height);

					// ---- button3 ----
					button3.setText("Search");
					panel4.add(button3);
					button3.setBounds(285, 230, 100, 30);
					button3.addActionListener(this);

					// ---- button4 ----
					button4.setText("Clear");
					panel4.add(button4);
					button4.setBounds(440, 230, 100, 30);
					button4.addActionListener(this);

					tableModel2.addColumn("Sr. no");
					tableModel2.addColumn("Order No");
					tableModel2.addColumn("Dist. Name");
					tableModel2.addColumn("Est. Date");
					tableModel2.addColumn("Rem. Days");
					tableModel2.addColumn("Total amt");
					// ======== scrollPane2 ========
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

	public static void main(String[] args) {
		// new PendingOrder();
	}

	private void storeName() {
		ArrayList<String> storeNames = (ArrayList<String>) fieldName
				.getAllStoreName();
		for (String name : storeNames) {
			comboBox1.addItem(name);
			comboBox3.addItem(name);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent event) {
		// TODO Auto-generated method stub
		if (event.getStateChange() == ItemEvent.SELECTED) {
			if (event.getSource() == comboBox1) {
				PendingSaleOrderList = dbvalue.getAllPendingSaleOrder(tableid
						.getStoreId(comboBox1.getSelectedItem().toString()));
			}

			if (event.getSource() == comboBox2) {
				//System.out.println("sjdhgldfhgldfh");
				if (comboBox2.getSelectedItem().toString() == "Date") {
					textField1.setText("");
					textField1.setEnabled(true);
					button5.setEnabled(true);
					textField2.setText("");
					textField2.setEnabled(false);
					textField3.setText("");
					textField3.setEnabled(false);
					textField4.setText("");
					textField4.setEnabled(true);
					button6.setEnabled(true);
				} else if (comboBox2.getSelectedItem().toString() == "Order No") {
					textField1.setText("");
					textField1.setEnabled(false);
					button5.setEnabled(false);
					textField2.setText("");
					textField2.setEnabled(true);
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
					textField4.setText("");
					textField4.setEnabled(false);
					button6.setEnabled(false);
				}
			}

			if (event.getSource() == comboBox3) {
				pendingPurchaseOrderList = dbvalue
						.getAllPendingPurchaseOrder(tableid
								.getStoreId(comboBox3.getSelectedItem()
										.toString()));
			}

			if (event.getSource() == comboBox4) {
				if (comboBox4.getSelectedItem().toString() == "Date") {
					textField5.setText("");
					textField5.setEnabled(true);
					button7.setEnabled(true);
					textField6.setText("");
					textField6.setEnabled(false);
					textField7.setText("");
					textField7.setEnabled(false);
					textField8.setText("");
					textField8.setEnabled(true);
					button8.setEnabled(true);
				} else if (comboBox4.getSelectedItem().toString() == "Order No") {
					textField5.setText("");
					textField5.setEnabled(false);
					button7.setEnabled(false);
					textField6.setText("");
					textField6.setEnabled(true);
					textField7.setText("");
					textField7.setEnabled(false);
					textField8.setText("");
					textField8.setEnabled(false);
					button8.setEnabled(false);
				} else {
					textField5.setText("");
					textField5.setEnabled(false);
					button7.setEnabled(false);
					textField6.setText("");
					textField6.setEnabled(false);
					textField7.setText("");
					textField7.setEnabled(true);
					textField8.setText("");
					textField8.setEnabled(false);
					button8.setEnabled(false);
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if (event.getSource() == button1) {
			searchSaleOrder();
		}

		if (event.getSource() == button2) {
			textField1.setText("");
			textField2.setText("");
			textField3.setText("");
			textField4.setText("");
		}

		if (event.getSource() == button3) {
			searchPurchaseOrder();
		}

		if (event.getSource() == button4) {
			textField5.setText("");
			textField6.setText("");
			textField7.setText("");
			textField8.setText("");
		}

		if (event.getSource() == button5) {
			final JFrame f = new JFrame();
			textField1.setText(new DatePicker(f).setPickedDate());
		}

		if (event.getSource() == button6) {
			final JFrame f = new JFrame();
			textField4.setText(new DatePicker(f).setPickedDate());
		}

		if (event.getSource() == button7) {
			final JFrame f = new JFrame();
			textField5.setText(new DatePicker(f).setPickedDate());
		}

		if (event.getSource() == button8) {
			final JFrame f = new JFrame();
			textField8.setText(new DatePicker(f).setPickedDate());
		}

	}

	private void searchPurchaseOrder() {
		// TODO Auto-generated method stub
		boolean status = true;
		ArrayList<PurchaseOrderModel> tempPurchaseOrderList = new ArrayList<>();
		if (comboBox2.getSelectedItem().toString() == "Date") {
			String fromDateStr = textField5.getText();
			String toDateStr = textField8.getText();
			if (!valid.isEmpty(fromDateStr) && !valid.isEmpty(toDateStr)) {
				try {
					java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
							"yyyy-MM-dd");
					Date fromDate = sdf.parse(fromDateStr);
					Date toDate = sdf.parse(toDateStr);
					for (PurchaseOrderModel purchaseOrder : pendingPurchaseOrderList) {
						Date date = sdf.parse(purchaseOrder.getOrderDate());
						if (date.compareTo(fromDate) >= 0
								&& date.compareTo(toDate) <= 0) {
							tempPurchaseOrderList.add(purchaseOrder);
						}
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
			} else {
				status = false;
				new ValidationMSG(this, "Please Select From And To Date");
			}

		} else if (comboBox2.getSelectedItem().toString() == "Order No") {
			String orderNo = textField6.getText().toUpperCase();

			if (!valid.isEmpty(orderNo)) {

				for (PurchaseOrderModel purchaseOrder : pendingPurchaseOrderList) {
					// System.out.println(saleOrder.getOrderNo());
					if (String.valueOf(purchaseOrder.getOrderId()).contains(
							orderNo)) {
						tempPurchaseOrderList.add(purchaseOrder);
					}
					// System.out.println(tempSaleOrderList.size());
				}
			} else {
				status = false;
				new ValidationMSG(this, "please Insert Order No");
			}
		} else {
			String supplierName = textField7.getText();
			if (!valid.isEmpty(supplierName)) {
				for (PurchaseOrderModel purchaseOrder : pendingPurchaseOrderList) {
					if (purchaseOrder.getSupplierName().contains(supplierName)) {
						tempPurchaseOrderList.add(purchaseOrder);

					}
				}
			} else {
				status = false;
				new ValidationMSG(this, "please Insert Supplier Name");
			}
		}

		if (status) {
			loadTable2Data(tempPurchaseOrderList);
		}
	}

	private void searchSaleOrder() {
		// TODO Auto-generated method stub
		boolean status = true;
		ArrayList<SaleOrderModel> tempSaleOrderList = new ArrayList<>();
		if (comboBox2.getSelectedItem().toString() == "Date") {
			String fromDateStr = textField1.getText();
			String toDateStr = textField4.getText();
			if (!valid.isEmpty(fromDateStr) && !valid.isEmpty(toDateStr)) {
				try {
					java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
							"yyyy-MM-dd");
					Date fromDate = sdf.parse(fromDateStr);
					Date toDate = sdf.parse(toDateStr);
					for (SaleOrderModel saleOrder : PendingSaleOrderList) {
						Date date = sdf.parse(saleOrder.getOrderDate());
						if (date.compareTo(fromDate) >= 0
								&& date.compareTo(toDate) <= 0) {
							tempSaleOrderList.add(saleOrder);
						}
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
			} else {
				status = false;
				new ValidationMSG(this, "Please Select From And To Date");
			}

		} else if (comboBox2.getSelectedItem().toString() == "Order No") {
			String orderNo = textField2.getText().toUpperCase();

			if (!valid.isEmpty(orderNo)) {

				for (SaleOrderModel saleOrder : PendingSaleOrderList) {
					// System.out.println(saleOrder.getOrderNo());
					if (saleOrder.getOrderNo().contains(orderNo)) {
						tempSaleOrderList.add(saleOrder);
					}
					// System.out.println(tempSaleOrderList.size());
				}
			} else {
				status = false;
				new ValidationMSG(this, "please Insert Order No");
			}
		} else {
			String customerName = textField3.getText();
			if (!valid.isEmpty(customerName)) {
				for (SaleOrderModel saleOrder : PendingSaleOrderList) {
					if (saleOrder.getCustomerName().contains(customerName)) {
						tempSaleOrderList.add(saleOrder);

					}
				}
			} else {
				status = false;
				new ValidationMSG(this, "please Insert customer Name");
			}
		}

		if (status) {
			loadTable1Data(tempSaleOrderList);
		}
	}

	private void loadTable1Data(ArrayList<SaleOrderModel> tempSaleOrderList) {
		// TODO Auto-generated method stub
		while (tableModel1.getRowCount() > 0) {
			tableModel1.removeRow(0);
		}
		// System.out.println(tempSaleOrderList.size());
		int i = 1;
		for (SaleOrderModel saleOrder : tempSaleOrderList) {
			int MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
			int remaningDays = 0;
			Date currentDate, orderDate;
			try {
				currentDate = sdf.parse(sdf.format(Calendar.getInstance()
						.getTime()));
				orderDate = sdf.parse(saleOrder.getOrderDate());
				System.out.println(sdf.format(orderDate));
				remaningDays = saleOrder.getNumberOfDays()
						- (int) (Math.abs(currentDate.getTime()
								- orderDate.getTime()) / MILLIS_IN_DAY);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}

			tableModel1.addRow(new Object[]{i, saleOrder.getOrderNo(),
					saleOrder.getOrderDate(), saleOrder.getCustomerName(),
					saleOrder.getNumberOfDays(), remaningDays,
					saleOrder.getTotalAmt()});
			i++;
		}
	}

	private void loadTable2Data(
			ArrayList<PurchaseOrderModel> tempPurchaseOrderList) {
		// TODO Auto-generated method stub
		while (tableModel2.getRowCount() > 0) {
			tableModel2.removeRow(0);
		}
		// System.out.println(tempSaleOrderList.size());
		int i = 1;
		for (PurchaseOrderModel purchaseOrder : tempPurchaseOrderList) {
			int MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
			int remaningDays = 0;
			Date currentDate, expectedDate;
			try {
				currentDate = sdf.parse(sdf.format(Calendar.getInstance()
						.getTime()));
				expectedDate = sdf.parse(purchaseOrder.getExpectedDate());
				// System.out.println(sdf.format(expectedDate));
				remaningDays = (int) (Math.abs(expectedDate.getTime()
						- currentDate.getTime()) / MILLIS_IN_DAY);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}

			tableModel2.addRow(new Object[]{i, purchaseOrder.getOrderId(),
					purchaseOrder.getSupplierName(),
					purchaseOrder.getOrderDate(),
					purchaseOrder.getExpectedDate(), remaningDays,
					purchaseOrder.getTotalProduct()});
			i++;
		}
	}
}
