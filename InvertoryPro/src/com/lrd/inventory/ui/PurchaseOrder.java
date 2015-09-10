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

import com.lrd.inventory.database.DatabaseDelete;
import com.lrd.inventory.database.DatabaseInsert;
import com.lrd.inventory.database.DatabaseUpdate;
import com.lrd.inventory.database.GetDBValue;
import com.lrd.inventory.database.SpecificFieldValue;
import com.lrd.inventory.database.TableId;
import com.lrd.inventory.main.DatePicker;
import com.lrd.inventory.main.PromptDailog;
import com.lrd.inventory.main.Validate;
import com.lrd.inventory.main.ValidationMSG;
import com.lrd.inventory.model.ProductModel;
import com.lrd.inventory.model.PurchaseOrderDetailModel;
import com.lrd.inventory.model.PurchaseOrderModel;

/**
 * @author dharmendra singh
 */
public class PurchaseOrder extends JFrame
		implements
			ActionListener,
			ItemListener,
			KeyListener,
			ListSelectionListener,
			FocusListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Variables declaration

	private JPanel panel1;
	private JPanel panel2;
	private JLabel label1;
	private JLabel label11;
	private JComboBox<Object> comboBox3;
	private JTabbedPane tabbedPane1;
	private JPanel panel3;
	private JPanel panel5;
	private JLabel label4;
	private JLabel label5;
	private JTextField textField1;
	private JComboBox<Object> comboBox5;
	private JLabel label6;
	private JLabel label7;
	private JTextField textField3;
	private JTextField textField4;
	private JButton button6;
	private JButton button7;
	private JPanel panel6;
	private JLabel label8;
	private JTextField textField5;
	private JLabel label9;
	private JTextField textField6;
	private JButton button8;
	private JButton button9;
	private JButton button10;
	private JLabel label10;
	private JComboBox<Object> comboBox2;
	private JScrollPane scrollPane1;
	private DefaultTableModel tableModel1;
	private JTable table1;
	private JLabel label2;
	private JLabel label3;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JComboBox<Object> comboBox1;
	private JLabel label12;
	private JPanel panel4;
	private JLabel label13;
	private JLabel label14;
	private JLabel label15;
	private JLabel label16;
	private JLabel label17;
	private JButton button11;
	private JButton button12;
	private JButton button13;
	private JScrollPane scrollPane2;
	private DefaultTableModel tableModel2;
	private JTable table2;
	private JComboBox<Object> comboBox4;
	private JTextField textField7;
	private JTextField textField8;
	private JTextField textField9;
	private JTextField textField10;
	private JButton button14;
	private JButton button15;
	private JButton button16;
	private JScrollPane scrollPane3;
	private DefaultListModel<String> listModel;
	private JList<String> list1;
	// End of variables declaration

	Connection connection = null;
	SpecificFieldValue fieldName;
	TableId tableid = null;
	DatabaseInsert dbinsert = null;
	Validate valid = null;
	GetDBValue dbValue = null;

	ProductModel product = null;
	PurchaseOrderModel purchaseOrderModel = null;
	ArrayList<ProductModel> productList = null;
	ArrayList<ProductModel> productDisplayList = null;
	ArrayList<PurchaseOrderDetailModel> purchaseOrderDetailList = null;
	ArrayList<PurchaseOrderModel> purchaseOrderList = null;

	int itemCount = 0;
	String tempProductCode = null;

	public PurchaseOrder(Connection connection) {
		this.connection = connection;
		fieldName = new SpecificFieldValue(connection);
		tableid = new TableId(connection);
		dbinsert = new DatabaseInsert(connection);
		valid = new Validate();
		dbValue = new GetDBValue(connection);
		initComponents();
		storeName();
		supplierName();
		orderId();
		productList = dbValue.getProductDetail(tableid.getStoreId(comboBox3
				.getSelectedItem().toString()));
		purchaseOrderDetailList = new ArrayList<>();
	}

	private void initComponents() {
		panel1 = new JPanel();
		panel2 = new JPanel();
		label1 = new JLabel();
		label11 = new JLabel();
		comboBox3 = new JComboBox<Object>();
		tabbedPane1 = new JTabbedPane();
		panel3 = new JPanel();
		panel5 = new JPanel();
		label4 = new JLabel();
		label5 = new JLabel();
		textField1 = new JTextField();
		comboBox5 = new JComboBox<Object>();
		label6 = new JLabel();
		label7 = new JLabel();
		textField3 = new JTextField();
		textField4 = new JTextField();
		button6 = new JButton();
		button7 = new JButton();
		panel6 = new JPanel();
		label8 = new JLabel();
		textField5 = new JTextField();
		label9 = new JLabel();
		textField6 = new JTextField();
		button8 = new JButton();
		button9 = new JButton();
		button10 = new JButton();
		label10 = new JLabel();
		comboBox2 = new JComboBox<Object>();
		scrollPane1 = new JScrollPane();
		tableModel1 = new DefaultTableModel();
		table1 = new JTable(tableModel1);
		label2 = new JLabel();
		label3 = new JLabel();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		button5 = new JButton();
		comboBox1 = new JComboBox<Object>();
		label12 = new JLabel();
		panel4 = new JPanel();
		label13 = new JLabel();
		label14 = new JLabel();
		label15 = new JLabel();
		label16 = new JLabel();
		label17 = new JLabel();
		button11 = new JButton();
		button12 = new JButton();
		button13 = new JButton();
		scrollPane2 = new JScrollPane();
		tableModel2 = new DefaultTableModel();
		table2 = new JTable(tableModel2);
		comboBox4 = new JComboBox<Object>();
		textField7 = new JTextField();
		textField8 = new JTextField();
		textField9 = new JTextField();
		textField10 = new JTextField();
		button14 = new JButton();
		button15 = new JButton();
		button16 = new JButton();
		scrollPane3 = new JScrollPane();
		listModel = new DefaultListModel<>();
		list1 = new JList<>(listModel);

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
				label1.setText("Purchase Order");
				label1.setFont(label1.getFont().deriveFont(
						label1.getFont().getSize() + 15f));
				panel2.add(label1);
				label1.setBounds(new Rectangle(new Point(390, 20), label1
						.getPreferredSize()));

				// ---- label11 ----
				label11.setText("Select Store");

				panel2.add(label11);
				label11.setBounds(new Rectangle(new Point(620, 50), label11
						.getPreferredSize()));
				panel2.add(comboBox3);
				comboBox3.setBounds(720, 45, 200,
						comboBox3.getPreferredSize().height);

			}
			panel1.add(panel2);
			panel2.setBounds(0, 0, 975, 70);

			// ======== tabbedPane1 ========
			{

				// ======== panel3 ========
				{
					panel3.setLayout(null);

					// ======== panel5 ========
					{
						panel5.setBorder(UIManager
								.getBorder("TitledBorder.border"));
						panel5.setLayout(null);

						// ---- label4 ----
						label4.setText("Order Id");
						panel5.add(label4);
						label4.setBounds(new Rectangle(new Point(25, 10),
								label4.getPreferredSize()));

						panel5.add(textField1);
						textField1.setBounds(130, 10, 200,
								textField1.getPreferredSize().height);
						textField1.setEnabled(false);

						// ---- label5 ----
						label5.setText("Supplier Name");
						panel5.add(label5);
						label5.setBounds(new Rectangle(new Point(25, 65),
								label5.getPreferredSize()));

						panel5.add(comboBox5);
						comboBox5.setBounds(130, 65, 200,
								comboBox5.getPreferredSize().height);

						// ---- label6 ----
						label6.setText("Order Date");
						panel5.add(label6);
						label6.setBounds(new Rectangle(new Point(600, 10),
								label6.getPreferredSize()));

						panel5.add(textField3);
						textField3.setBounds(700, 10, 150,
								textField3.getPreferredSize().height);

						// ---- label7 ----
						label7.setText("Expected Date");
						panel5.add(label7);
						label7.setBounds(new Rectangle(new Point(600, 65),
								label7.getPreferredSize()));

						panel5.add(textField4);
						textField4.setBounds(700, 60, 150,
								textField4.getPreferredSize().height);

						// ---- button6 ----
						button6.setText("text");
						panel5.add(button6);
						button6.setBounds(850, 10, 20, 20);
						button6.addActionListener(this);

						// ---- button7 ----
						button7.setText("text");
						panel5.add(button7);
						button7.setBounds(850, 60, 20, 20);
						button7.addActionListener(this);

					}
					panel3.add(panel5);
					panel5.setBounds(15, 10, 945, 120);

					// ======== panel6 ========
					{
						panel6.setBorder(UIManager
								.getBorder("TitledBorder.border"));
						panel6.setLayout(null);

						// ---- label8 ----
						label8.setText("Product Name");
						panel6.add(label8);
						label8.setBounds(new Rectangle(new Point(25, 10),
								label8.getPreferredSize()));

						panel6.add(textField5);
						textField5.setBounds(130, 10, 200,
								textField5.getPreferredSize().height);
						textField5.addKeyListener(this);
						textField5.addFocusListener(this);

						list1.addListSelectionListener(this);
						list1.addFocusListener(this);
						// ------scrollPane 3 --------
						{
							scrollPane3.setViewportView(list1);
						}
						panel6.add(scrollPane3);
						scrollPane3.setBounds(350, 10, 200, 70);

						// ---- label9 ----
						label9.setText("Quantity");
						panel6.add(label9);
						label9.setBounds(new Rectangle(new Point(25, 50),
								label9.getPreferredSize()));

						panel6.add(textField6);
						textField6.setBounds(130, 50, 200,
								textField6.getPreferredSize().height);

						// ---- label10 ----
						label10.setText("Unit");
						panel6.add(label10);
						label10.setBounds(new Rectangle(new Point(645, 15),
								label10.getPreferredSize()));

						panel6.add(comboBox2);
						comboBox2.setBounds(700, 10, 200,
								comboBox2.getPreferredSize().height);

						// ---- button8 ----
						button8.setText("Add");
						panel6.add(button8);
						button8.setBounds(300, 90, 100, 30);
						button8.addActionListener(this);

						// ---- button9 ----
						button9.setText("Delete");
						panel6.add(button9);
						button9.setBounds(425, 90, 100, 30);
						button9.addActionListener(this);

						// ---- button10 ----
						button10.setText("Clear");
						panel6.add(button10);
						button10.setBounds(555, 90, 100, 30);
						button10.addActionListener(this);

					}
					panel3.add(panel6);
					panel6.setBounds(15, 130, 945, 140);

					tableModel1.addColumn("Sr. No.");
					tableModel1.addColumn("Product Name");
					tableModel1.addColumn("Unit");
					tableModel1.addColumn("Quantity");
					table1.getSelectionModel().addListSelectionListener(this);
					// ======== scrollPane1 ========
					{
						scrollPane1.setViewportView(table1);
					}
					panel3.add(scrollPane1);
					scrollPane1.setBounds(15, 275, 940, 150);

					// ---- label2 ----
					label2.setText("Total Products");
					panel3.add(label2);
					label2.setBounds(new Rectangle(new Point(20, 430), label2
							.getPreferredSize()));

					// ---- label12 ----
					label12.setText("0");
					label12.setForeground(new Color(0, 0, 204));
					panel3.add(label12);
					label12.setBounds(new Rectangle(new Point(130, 430),
							label12.getPreferredSize()));

					// ---- label3 ----
					label3.setText("Select Status");
					panel3.add(label3);
					label3.setBounds(new Rectangle(new Point(545, 430), label3
							.getPreferredSize()));

					panel3.add(comboBox1);
					comboBox1.setBounds(655, 430, 250,
							comboBox1.getPreferredSize().height);
					comboBox1.addItem("Pending");
					comboBox1.addItem("Completed");

					// ---- button1 ----
					button1.setText("Generate");
					panel3.add(button1);
					button1.setBounds(145, 500, 100, 30);
					button1.addActionListener(this);

					// ---- button2 ----
					button2.setText("Save");
					panel3.add(button2);
					button2.setBounds(280, 500, 100, 30);
					button2.addActionListener(this);

					// ---- button3 ----
					button3.setText("Save As PDF");
					panel3.add(button3);
					button3.setBounds(415, 500, 100, 30);
					button3.addActionListener(this);

					// ---- button4 ----
					button4.setText("Update");
					panel3.add(button4);
					button4.setBounds(550, 500, 100, 30);
					button4.addActionListener(this);
					button4.setEnabled(false);

					// ---- button5 ----
					button5.setText("Clear All");
					panel3.add(button5);
					button5.setBounds(685, 500, 100, 30);
					button5.addActionListener(this);

				}
				tabbedPane1.addTab("New Purchase Order", panel3);

				// ======== panel4 ========
				{
					panel4.setLayout(null);

					// ---- label13 ----
					label13.setText("Search Criteria");
					panel4.add(label13);
					label13.setBounds(new Rectangle(new Point(150, 75), label13
							.getPreferredSize()));

					panel4.add(comboBox4);
					comboBox4.setBounds(270, 70, 300,
							comboBox4.getPreferredSize().height);
					comboBox4.addItem("----Select Criteria----");
					comboBox4.addItem("Date Wise");
					comboBox4.addItem("Order Id");
					comboBox4.addItem("Supplier Name");
					comboBox4.addItemListener(this);

					// ---- label14 ----
					label14.setText("From Date");
					panel4.add(label14);
					label14.setBounds(new Rectangle(new Point(150, 115),
							label14.getPreferredSize()));

					panel4.add(textField7);
					textField7.setBounds(250, 115, 100,
							textField7.getPreferredSize().height);
					textField7.setEnabled(false);

					// ---- button14 ----
					button14.setText("text");
					panel4.add(button14);
					button14.setBounds(350, 115, 20, 20);
					button14.setEnabled(false);
					button14.addActionListener(this);

					// ---- label15 ----
					label15.setText("To Date");
					panel4.add(label15);
					label15.setBounds(new Rectangle(new Point(400, 115),
							label15.getPreferredSize()));

					panel4.add(textField8);
					textField8.setBounds(455, 115, 100,
							textField8.getPreferredSize().height);
					textField8.setEnabled(false);

					// ---- button15 ----
					button15.setText("text");
					panel4.add(button15);
					button15.setBounds(560, 115, 20, 20);
					button15.setEnabled(false);
					button15.addActionListener(this);

					// ---- label16 ----
					label16.setText("Order Id");
					panel4.add(label16);
					label16.setBounds(new Rectangle(new Point(150, 145),
							label16.getPreferredSize()));

					panel4.add(textField9);
					textField9.setBounds(250, 145, 300,
							textField9.getPreferredSize().height);
					textField9.setEnabled(false);

					// ---- label17 ----
					label17.setText("Supplier Name");
					panel4.add(label17);
					label17.setBounds(new Rectangle(new Point(150, 175),
							label17.getPreferredSize()));

					panel4.add(textField10);
					textField10.setBounds(250, 175, 300,
							textField10.getPreferredSize().height);
					textField10.setEnabled(false);

					// ---- button11 ----
					button11.setText("Search");
					panel4.add(button11);
					button11.setBounds(180, 240, 100, 30);
					button11.addActionListener(this);

					// ---- button12 ----
					button12.setText("Delete");
					panel4.add(button12);
					button12.setBounds(395, 240, 100, 30);
					button12.addActionListener(this);

					// ---- button13 ----
					button13.setText("Clear");
					panel4.add(button13);
					button13.setBounds(600, 235, 100, 30);
					button13.addActionListener(this);

					// ---- button16 ----
					button16.setText("Set Completed");
					panel4.add(button16);
					button16.setBounds(800, 235, 100, 30);
					button16.addActionListener(this);

					tableModel2.addColumn("Order Id");
					tableModel2.addColumn("Supplier Name");
					tableModel2.addColumn("Order Date");
					tableModel2.addColumn("Excepted Date");
					tableModel2.addColumn("Total Item");
					tableModel2.addColumn("Status");
					// ======== scrollPane2 ========
					{
						scrollPane2.setViewportView(table2);
					}
					panel4.add(scrollPane2);
					scrollPane2.setBounds(70, 295, 845, 233);

				}
				tabbedPane1.addTab("Search Purchase Order", panel4);
			}
			panel1.add(tabbedPane1);
			tabbedPane1.setBounds(0, 70, 975, 585);

		}
		contentPane.add(panel1);
		panel1.setBounds(0, 0, 975, 655);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
		setSize(980, 680);
	}

	public static void main(String[] args) {
		// new PurchaseOrder();
	}

	private void storeName() {
		ArrayList<String> storeNames = (ArrayList<String>) fieldName
				.getAllStoreName();
		for (String name : storeNames) {
			comboBox3.addItem(name);
		}
	}

	private void supplierName() {
		ArrayList<String> supplierNames = (ArrayList<String>) fieldName
				.getAllSupplierName();
		comboBox5.addItem("---Select Supplier--");
		for (String name : supplierNames) {
			comboBox5.addItem(name);
		}
	}

	private void orderId() {
		int id = tableid.getNewPurchaseOrderId();
		textField1.setText(String.valueOf(id));
	}

	@Override
	public void itemStateChanged(ItemEvent event) {
		if (event.getStateChange() == ItemEvent.SELECTED) {
			if (event.getSource() == comboBox3) {
				productList = dbValue.getProductDetail(tableid
						.getStoreId(comboBox3.getSelectedItem().toString()));
			}
			if (event.getSource() == comboBox4) {
				switch (comboBox4.getSelectedIndex()) {
					case 1 :
						button14.setEnabled(true);
						button15.setEnabled(true);
						textField9.setEnabled(false);
						textField10.setEnabled(false);
						break;
					case 2 :
						button14.setEnabled(false);
						button15.setEnabled(false);
						textField9.setEnabled(true);
						textField10.setEnabled(false);
						break;
					case 3 :
						button14.setEnabled(false);
						button15.setEnabled(false);
						textField9.setEnabled(false);
						textField10.setEnabled(true);
						break;
					case 0 :
					default :
						button14.setEnabled(false);
						button15.setEnabled(false);
						textField9.setEnabled(false);
						textField10.setEnabled(false);

				}
			}
		}

	}

	private void loadTableData() {
		// for removing all existing rows from table
		while (tableModel1.getRowCount() > 0) {
			tableModel1.removeRow(0);
		}

		// / inserting new rows to the table
		int i = 1;
		for (PurchaseOrderDetailModel purchaseOrderDetail : purchaseOrderDetailList) {
			tableModel1.addRow(new Object[]{i,
					purchaseOrderDetail.getProductName(),
					purchaseOrderDetail.getUnit(),
					purchaseOrderDetail.getQuantity()});
			label12.setText(String.valueOf(i));
			i++;
		}

	}

	private void loadTableData2(ArrayList<PurchaseOrderModel> purchaseOrderList) {
		// for removing all existing rows from table
		while (tableModel2.getRowCount() > 0) {
			tableModel2.removeRow(0);
		}

		// / inserting new rows to the table
		for (PurchaseOrderModel purchaseOrder : purchaseOrderList) {
			tableModel2
					.addRow(new Object[]{purchaseOrder.getOrderId(),
							purchaseOrder.getSupplierName(),
							purchaseOrder.getOrderDate(),
							purchaseOrder.getExpectedDate(),
							purchaseOrder.getTotalProduct(),
							purchaseOrder.getStatus()});
		}

	}

	/**
	 * this method is used to show product name in list
	 * 
	 * @param productTempList
	 */
	private void loadListData() {

		listModel.removeAllElements();
		for (ProductModel tempProduct : productDisplayList) {
			listModel.addElement(tempProduct.getProductName());
		}
		/*
		 * if(list1.getVisibleRowCount()>0){ list1.setSelectedIndex(0); }
		 */
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		// /date picker block for date chosing button
		if (event.getSource() == button6) {
			final JFrame f = new JFrame();
			textField3.setText(new DatePicker(f).setPickedDate());
		}
		if (event.getSource() == button7) {
			final JFrame f = new JFrame();
			textField4.setText(new DatePicker(f).setPickedDate());
		}
		if (event.getSource() == button14) {
			final JFrame f = new JFrame();
			textField7.setText(new DatePicker(f).setPickedDate());
		}
		if (event.getSource() == button15) {
			final JFrame f = new JFrame();
			textField8.setText(new DatePicker(f).setPickedDate());
		}

		// ///button for add a product to purchase order
		if (event.getSource() == button8) {
			addProduct();
			itemCount++;
			loadTableData();
			tempProductCode = null;
			resetProductField();
			textField5.requestFocus();
		}
		if (event.getSource() == button9) {
			DeleteProduct();
			itemCount--;
			loadTableData();
		}
		if (event.getSource() == button10) {
			resetProductField();
		}

		// //end button of tabbed pane first
		if (event.getSource() == button1) {

			if (valid.isEmpty(textField3.getText())) {
				new ValidationMSG(this, "Please Select order Date");
			} else if (valid.isEmpty(textField4.getText())) {
				new ValidationMSG(this, "Please Select Excepted Date");
			} else if (comboBox5.getSelectedIndex() < 1) {
				new ValidationMSG(this, "Please Select Supplier Name");
			} else if (comboBox5.getSelectedIndex() < 1) {
				new ValidationMSG(this, "Please Select Supplier Name");
			} else if (itemCount <= 0) {
				new ValidationMSG(this, "Please Add Some element to the table");
			} else {
				// printPurchaseOrder();
				savePurchaseOrder();
			}
		}
		if (event.getSource() == button2) {
			if (valid.isEmpty(textField3.getText())) {
				new ValidationMSG(this, "Please Select order Date");
			} else if (valid.isEmpty(textField4.getText())) {
				new ValidationMSG(this, "Please Select Excepted Date");
			} else if (comboBox5.getSelectedIndex() < 1) {
				new ValidationMSG(this, "Please Select Supplier Name");
			} else if (comboBox5.getSelectedIndex() < 1) {
				new ValidationMSG(this, "Please Select Supplier Name");
			} else if (itemCount <= 0) {
				new ValidationMSG(this, "Please Add Some element to the table");
			} else {
				savePurchaseOrder();
			}
		}
		if (event.getSource() == button3) {
			if (valid.isEmpty(textField3.getText())) {
				new ValidationMSG(this, "Please Select order Date");
			} else if (valid.isEmpty(textField4.getText())) {
				new ValidationMSG(this, "Please Select Excepted Date");
			} else if (comboBox5.getSelectedIndex() < 1) {
				new ValidationMSG(this, "Please Select Supplier Name");
			} else if (comboBox5.getSelectedIndex() < 1) {
				new ValidationMSG(this, "Please Select Supplier Name");
			} else if (itemCount <= 0) {
				new ValidationMSG(this, "Please Add Some element to the table");
			} else {
				// savePurchaseOrderAsPdf();
				savePurchaseOrder();
			}
		}
		if (event.getSource() == button4) {

		}
		if (event.getSource() == button5) {
			resetAll();
			
		}

		// /button of tabbed pane second
		if (event.getSource() == button11) {
			searchPurchaseOrder();
		}
		if (event.getSource() == button12) {
			deletePurchaseOrder();
		}
		if (event.getSource() == button13) {
			textField7.setText("");
			textField8.setText("");
			textField9.setText("");
			textField10.setText("");
		}
		if (event.getSource() == button16) {
			if (table2.getSelectedRowCount() != 1) {
				new ValidationMSG(this,
						"Please Select a row from table then click");
			} else {
				changeStatus("completed");
				loadTableData2(purchaseOrderList);
			}
		}

	}
	private void resetAll() {
		// TODO Auto-generated method stub
		textField3.setText("");
		textField4.setText("");
		comboBox5.setSelectedIndex(0);
		comboBox3.setSelectedIndex(0);
		itemCount=0;
		tempProductCode=null;
		purchaseOrderDetailList = new ArrayList<>();
	}

	private void setPurchaseOrderModel() {
		purchaseOrderModel = new PurchaseOrderModel();

		purchaseOrderModel.setExceptedDate(textField4.getText());
		purchaseOrderModel.setOrderDate(textField3.getText());
		purchaseOrderModel.setStatus(comboBox1.getSelectedItem().toString());
		purchaseOrderModel.setSupplierName(comboBox5.getSelectedItem()
				.toString());
		purchaseOrderModel.setTotalProduct(itemCount);
		purchaseOrderModel.setReceiptId(0);
		purchaseOrderModel.setStoreId(tableid.getStoreId(comboBox3
				.getSelectedItem().toString()));
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		purchaseOrderModel.setYearId(tableid.getYearId(currentYear,
				currentYear + 1));
	}

	private void savePurchaseOrder() {

		setPurchaseOrderModel();
		int orderId = dbinsert.insertPurchaseOrder(purchaseOrderModel);
		System.out.println(orderId);
		for (PurchaseOrderDetailModel purchaseOrderDetailModel : purchaseOrderDetailList) {
			purchaseOrderDetailModel.setOrderId(orderId);
			dbinsert.insertPurchaseOrderDetail(purchaseOrderDetailModel);
		}
		purchaseOrderDetailList = new ArrayList<>();
		loadTableData();
		textField5.requestFocus();

	}

	private void addProduct() {
		// /add product to purchseOrderDetail
		boolean status = true;

		if (valid.isEmpty(tempProductCode)) {
			status = false;
			new ValidationMSG(this, "please select product name from list");
		} else if (valid.isEmpty(textField5.getText())) {
			status = false;
			new ValidationMSG(this, "please insert product name");
		} else if (comboBox2.getSelectedIndex() < 0) {
			status = false;
			new ValidationMSG(this, "please select Unit");
		} else if (valid.isEmpty(textField6.getText())) {
			status = false;
			new ValidationMSG(this, "please insert product Quantity");
		}

		if (status) {
			PurchaseOrderDetailModel purchaseOrderDetail = new PurchaseOrderDetailModel();

			purchaseOrderDetail.setOrederDeatilId(0);
			purchaseOrderDetail.setOrderId(0);
			purchaseOrderDetail.setProductCode(tempProductCode);
			purchaseOrderDetail.setProductName(textField5.getText());
			purchaseOrderDetail.setUnit(comboBox2.getSelectedItem().toString());
			purchaseOrderDetail.setQuantity(Double.parseDouble(textField6
					.getText()));
			tempProductCode = null;
			purchaseOrderDetailList.add(purchaseOrderDetail);
		}

	}
	private void DeleteProduct() {
		if (table1.getSelectedRow() >= 0) {
			if (new PromptDailog().getUserResponse()) {
				purchaseOrderDetailList.remove(table1.getSelectedRow());
			}
		} else {
			new ValidationMSG(this, "please select a row from table");
		}
	}

	private void resetProductField() {
		productDisplayList = new ArrayList<>();
		loadListData();
		textField5.setText("");
		textField6.setText("");
		comboBox2.removeAllItems();
	}

	private void searchPurchaseOrder() {
		switch (comboBox4.getSelectedIndex()) {
			case 1 :
				if (valid.isEmpty(textField7.getText())) {
					new ValidationMSG(this, "Please Select from date");
				} else if (valid.isEmpty(textField8.getText())) {
					new ValidationMSG(this, "Please Select to date");
				} else {
					String startDate = textField7.getText();
					String endDate = textField8.getText();
					purchaseOrderList = dbValue.getPurchaseOrder(startDate,
							endDate);
				}
				break;
			case 2 :
				if (valid.isEmpty(textField9.getText())) {
					new ValidationMSG(this, "Please Insert Order No");
				} else {
					purchaseOrderList = dbValue.getPurchaseOrder(Integer
							.parseInt(textField9.getText()));
				}
				break;
			case 3 :
				if (valid.isEmpty(textField9.getText())) {
					new ValidationMSG(this, "Please Insert supplier Name");
				} else {
					purchaseOrderList = dbValue.getPurchaseOrder(textField10
							.getText());
				}
				break;
			default :

		}
		loadTableData2(purchaseOrderList);
	}

	private void deletePurchaseOrder() {
		boolean response = new PromptDailog().getUserResponse();
		if (response == true) {
			int id = purchaseOrderList.get(table2.getSelectedRow())
					.getOrderId();
			new DatabaseDelete(connection).deletePurchaseOrder(id);
		}
	}

	private void changeStatus(String Status) {
		boolean response = new PromptDailog().getUserResponse();
		if (response == true) {
			int id = purchaseOrderList.get(table2.getSelectedRow())
					.getOrderId();
			new DatabaseUpdate(connection).updatePurchaseOrderStatus(id,
					"Completed");

		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

	@Override
	public void keyReleased(KeyEvent event) {
		if (event.getSource() == textField5
				&& !valid.isEmpty(textField5.getText())) {
			String tempStr = textField5.getText();
			productDisplayList = new ArrayList<>();
			for (ProductModel product : productList) {
				if (product.getProductName().contains(tempStr)) {
					productDisplayList.add(product);
				}
			}
			loadListData();
		}

	}

	@Override
	public void valueChanged(ListSelectionEvent event) {
		if (event.getSource() == list1) {
			if (list1.getVisibleRowCount() > 0 && list1.getSelectedIndex() >= 0) {
				comboBox2.removeAllItems();
				comboBox2.addItem(productDisplayList.get(
						list1.getSelectedIndex()).getUnit());
				textField5.setText(productDisplayList.get(
						list1.getSelectedIndex()).getProductName());
				tempProductCode = productDisplayList.get(
						list1.getSelectedIndex()).getProductName();
			}
		}
		if (event.getSource() == table1.getSelectionModel()) {
			if (table1.getSelectedRowCount() > 0) {
				button9.setEnabled(true);
			} else {
				button9.setEnabled(false);
			}

		}

	}

	@Override
	public void focusGained(FocusEvent event) {
		if (event.getSource() == list1) {
			if (list1.getVisibleRowCount() >= 0) {
				list1.setSelectedIndex(0);
			}
		}

		if (event.getSource() == textField5) {
			textField5.setSelectionStart(0);
			textField5.setSelectionEnd(textField5.getText().length());
		}

	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub

	}

}
