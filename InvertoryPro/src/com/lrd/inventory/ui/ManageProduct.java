package com.lrd.inventory.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.lrd.inventory.database.DatabaseDelete;
import com.lrd.inventory.database.DatabaseInsert;
import com.lrd.inventory.database.DatabaseUpdate;
import com.lrd.inventory.database.GetDBValue;
import com.lrd.inventory.database.SpecificFieldValue;
import com.lrd.inventory.database.TableId;
import com.lrd.inventory.main.PromptDailog;
import com.lrd.inventory.main.Validate;
import com.lrd.inventory.main.ValidationMSG;
import com.lrd.inventory.model.ProductModel;

/**
 * @author dharmendra singh
 */
public class ManageProduct extends JFrame
		implements
			ActionListener,
			KeyListener,
			ItemListener {

	private static final long serialVersionUID = 1L;

	// Variables declaration
	private JPanel panel1;
	private JLabel label1;
	private JSeparator separator1;
	private JLabel label4;
	private JLabel label3;
	private JScrollPane scrollPane2;
	private DefaultTableModel tableModel;
	private JTable table1;
	private JLabel label2;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JLabel label10;
	private JLabel label11;
	private JLabel label12;
	private JLabel label13;
	private JLabel label14;
	private JLabel label15;
	private JLabel label16;
	private JLabel label17;
	private JLabel label18;
	private JLabel label19;
	private JLabel label20;
	private JComboBox<Object> comboBox1;
	private JComboBox<Object> comboBox2;
	private JComboBox<Object> comboBox3;
	private JComboBox<Object> comboBox4;
	private JComboBox<Object> comboBox5;
	private JComboBox<Object> comboBox6;
	private JComboBox<Object> comboBox7;
	private JTextField textField1;
	private JTextField textField2;
	private JScrollPane scrollPane1;
	private JTextArea textArea1;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	private JTextField textField7;
	private JTextField textField8;
	private JTextField textField9;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	private JTextField textField10;
	private JButton button8;
	private JButton button9;
	private JLabel label8;
	// End of variables declaration

	Connection connection = null;
	SpecificFieldValue fieldName = null;
	TableId tableid = null;
	DatabaseInsert dbinsert = null;
	ProductModel product = null;
	Validate valid = null;
	GetDBValue dbValue = null;
	ArrayList<ProductModel> productList = null;
	ArrayList<ProductModel> productDisplayList = null;

	public ManageProduct(Connection connection) {
		this.connection = connection;
		this.fieldName = new SpecificFieldValue(this.connection);
		tableid = new TableId(this.connection);
		dbinsert = new DatabaseInsert(this.connection);
		dbValue = new GetDBValue(connection);
		valid = new Validate();
		product = new ProductModel();
		initComponents();
		storeName();
		productList = dbValue.getProductDetail(tableid.getStoreId(comboBox6
				.getSelectedItem().toString()));
		unitName();
		vatPercent();

	}

	private void initComponents() {

		panel1 = new JPanel();
		label1 = new JLabel();
		separator1 = new JSeparator();
		label4 = new JLabel();
		label3 = new JLabel();
		scrollPane2 = new JScrollPane();
		tableModel = new DefaultTableModel();
		table1 = new JTable(tableModel);
		label2 = new JLabel();
		label5 = new JLabel();
		label6 = new JLabel();
		label7 = new JLabel();
		label10 = new JLabel();
		label11 = new JLabel();
		label12 = new JLabel();
		label13 = new JLabel();
		label14 = new JLabel();
		label15 = new JLabel();
		label16 = new JLabel();
		label17 = new JLabel();
		label18 = new JLabel();
		label19 = new JLabel();
		label20 = new JLabel();
		comboBox1 = new JComboBox<Object>();
		comboBox2 = new JComboBox<Object>();
		comboBox3 = new JComboBox<Object>();
		comboBox4 = new JComboBox<Object>();
		comboBox5 = new JComboBox<Object>();
		comboBox6 = new JComboBox<Object>();
		comboBox7 = new JComboBox<Object>();
		textField1 = new JTextField();
		textField2 = new JTextField();
		scrollPane1 = new JScrollPane();
		textArea1 = new JTextArea();
		textField3 = new JTextField();
		textField4 = new JTextField();
		textField5 = new JTextField();
		textField6 = new JTextField();
		textField7 = new JTextField();
		textField8 = new JTextField();
		textField9 = new JTextField();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		button5 = new JButton();
		button6 = new JButton();
		button7 = new JButton();
		textField10 = new JTextField();
		button8 = new JButton();
		button9 = new JButton();
		label8 = new JLabel();

		JLabel star = new JLabel("*");
		star.setForeground(Color.RED);

		// ======== this ========
		setResizable(false);
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		// ======== panel1 ========
		{

			panel1.setOpaque(false);
			panel1.setLayout(null);

			// ---- label1 ----
			label1.setText("Manage Product");
			label1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 30));
			panel1.add(label1);
			label1.setBounds(200, 10, 400, 50);
			panel1.add(separator1);
			separator1.setBounds(0, 60, 720, 5);

			// ===========left side
			// elements=============================================
			// ---- label2 ----
			label2.setText("<html>Product Code <font color='red'><b>*</b></font></html>");
			panel1.add(label2);
			label2.setBounds(30, 70, 150, 20);

			panel1.add(textField1);
			textField1.setBounds(180, 70, 200, 20);

			// ---- label3 ----
			label3.setText("<html>Product Name <font color='red'><b>*</b></font></html>");
			panel1.add(label3);
			label3.setBounds(30, 100, 150, 20);

			panel1.add(textField2);
			textField2.setBounds(180, 100, 200, 20);

			// ---- label4 ----
			label4.setText("Product Description");
			panel1.add(label4);
			label4.setBounds(30, 130, 150, 20);

			// ======== scrollPane1 ========
			{
				scrollPane1.setViewportView(textArea1);
			}
			panel1.add(scrollPane1);
			scrollPane1.setBounds(180, 130, 200, 50);

			// ---- label16 ----
			label16.setText("Rack");
			panel1.add(label16);
			label16.setBounds(30, 190, 150, 20);

			panel1.add(comboBox1);
			comboBox1.setBounds(180, 190, 200, 20);
			comboBox1.addItemListener(this);

			// ---- label15 ----
			label15.setText("Category");
			panel1.add(label15);
			label15.setBounds(30, 220, 150, 20);

			panel1.add(comboBox2);
			comboBox2.setBounds(180, 220, 200, 20);
			comboBox2.addItemListener(this);

			// ---- label12 ----
			label12.setText("Brand");
			panel1.add(label12);
			label12.setBounds(30, 250, 150, 20);

			panel1.add(comboBox3);
			comboBox3.setBounds(180, 250, 200, 20);

			// ---- label17 ----
			label17.setText("<html>Unit <font color='red'><b>*</b></font></html>");
			panel1.add(label17);
			label17.setBounds(30, 280, 150, 20);

			panel1.add(comboBox4);
			comboBox4.setBounds(180, 280, 200, 20);

			// ---- label13 ----
			label13.setText("<html>Quantity <font color='red'><b>*</b></font></html>");
			panel1.add(label13);
			label13.setBounds(30, 310, 150, 20);

			panel1.add(textField3);
			textField3.setBounds(180, 310, 200, 20);

			// ---- label20 ----
			label20.setText("<html>Purchase Rate <font color='red'><b>*</b></font></html>");
			panel1.add(label20);
			label20.setBounds(30, 340, 150, 20);

			panel1.add(textField4);
			textField4.setBounds(180, 340, 200, 20);

			// ---- label18 ----
			label18.setText("<html>MRP <font color='red'><b>*</b></font></html>");
			panel1.add(label18);
			label18.setBounds(30, 370, 150, 20);

			panel1.add(textField5);
			textField5.setBounds(180, 370, 200, 20);

			// ---- label14 ----
			label14.setText("<html>Sale Rate <font color='red'><b>*</b></font></html>");
			panel1.add(label14);
			label14.setBounds(30, 400, 150, 20);

			panel1.add(textField6);
			textField6.setBounds(180, 400, 200, 20);

			// ---- label19 ----
			label19.setText("Whole Sale Rate");
			panel1.add(label19);
			label19.setBounds(30, 430, 150, 20);

			panel1.add(textField7);
			textField7.setBounds(180, 430, 200, 20);

			// ---- label8 ----
			label8.setText("Online Sale Rate");
			panel1.add(label8);
			label8.setBounds(30, 460, 150, 20);

			panel1.add(textField8);
			textField8.setBounds(180, 460, 200, 20);

			// ---- label11 ----
			label11.setText("<html>Vat % <font color='red'><b>*</b></font></html>");
			panel1.add(label11);
			label11.setBounds(30, 490, 150, 20);

			panel1.add(comboBox5);
			comboBox5.setBounds(180, 490, 200, 20);

			// ---- label5 ----
			label5.setText("Low Level Quantity");
			panel1.add(label5);
			label5.setBounds(30, 520, 150, 20);

			panel1.add(textField9);
			textField9.setBounds(180, 520, 200, 20);
			// ========end of left side elements=========================

			// /==============right side elements===========================

			// ---- label6 ----
			label6.setText("Select Store");
			panel1.add(label6);
			label6.setBounds(400, 70, 100, 20);

			panel1.add(comboBox6);
			comboBox6.setBounds(500, 70, 200, 20);
			comboBox6.addItemListener(this);

			// ---- label7 ----
			label7.setText("Search By");
			panel1.add(label7);
			label7.setBounds(400, 100, 100, 20);

			panel1.add(comboBox7);
			comboBox7.setBounds(500, 100, 200, 20);
			comboBox7.addItem("By Product Name");
			comboBox7.addItem("By Product Code");

			panel1.add(textField10);
			textField10.setBounds(500, 130, 200, 20);
			textField10.addKeyListener(this);

			// ---- button8 ----
			button8.setText("Previous");
			button8.setBackground(new Color(51, 255, 51));
			panel1.add(button8);
			button8.setBounds(500, 160, 90, 15);
			button8.addActionListener(this);

			// ---- button9 ----
			button9.setText("next");
			button9.setBackground(new Color(51, 255, 51));
			panel1.add(button9);
			button9.setBounds(610, 160, 90, 15);
			button9.addActionListener(this);

			tableModel.addColumn("Sr.No.");
			tableModel.addColumn("Product Code");
			tableModel.addColumn("Product Name");

			// ======== scrollPane2 ========
			{
				scrollPane2.setViewportView(table1);
			}
			panel1.add(scrollPane2);
			scrollPane2.setBounds(400, 190, 300, 350);
			// =============end of right side
			// elements================================

			// ---- label10 ----
			label10.setText("(Note : Low level quantity indicates the low level quantity of product)");
			label10.setForeground(Color.red);
			panel1.add(label10);
			label10.setBounds(300, 540, 400, 20);

			// ---- button1 ----
			button1.setText("Save");
			button1.setOpaque(true);
			panel1.add(button1);
			button1.setBounds(20, 580, 90, 30);
			button1.addActionListener(this);

			// ---- button2 ----
			button2.setText("Update");
			panel1.add(button2);
			button2.setBounds(115, 580, 90, 30);
			button2.addActionListener(this);

			// ---- button3 ----
			button3.setText("Refresh");
			panel1.add(button3);
			button3.setBounds(210, 580, 90, 30);
			button3.addActionListener(this);

			// ---- button4 ----
			button4.setText("View");
			panel1.add(button4);
			button4.setBounds(310, 580, 90, 30);
			button4.addActionListener(this);

			// ---- button5 ----
			button5.setText("Delete");
			panel1.add(button5);
			button5.setBounds(410, 580, 90, 30);
			button5.addActionListener(this);

			// ---- button6 ----
			button6.setText("Import");
			panel1.add(button6);
			button6.setBounds(510, 580, 90, 30);
			button6.addActionListener(this);
			button6.setEnabled(false);

			// ---- button7 ----
			button7.setText("Clear");
			panel1.add(button7);
			button7.setBounds(610, 580, 90, 30);
			button7.addActionListener(this);

		}
		contentPane.add(panel1);
		panel1.setBounds(0, 0, 720, 770);

		pack();
		setVisible(true);
		setLocation(200, 10);
		setSize(720, 700);
	}

	private void loadTableData(ArrayList<ProductModel> productTempList) {

		while (tableModel.getRowCount() > 0) {
			tableModel.removeRow(0);
		}

		int i = 1;
		for (ProductModel tempProduct : productTempList) {
			tableModel.addRow(new Object[]{i, tempProduct.getProductCode(),
					tempProduct.getProductName()});
			i++;
		}
	}

	private void storeName() {
		ArrayList<String> storeNames = (ArrayList<String>) fieldName
				.getAllStoreName();
		for (String name : storeNames) {
			comboBox6.addItem(name);
		}
	}

	private void rackName() {
		comboBox1.removeAllItems();
		ArrayList<String> rackNames = (ArrayList<String>) fieldName
				.getAllRackName(tableid.getStoreId(comboBox6.getSelectedItem()
						.toString()));
		for (String name : rackNames) {
			comboBox1.addItem(name);
		}
	}

	private void categoryName() {
		comboBox2.removeAllItems();
		if (comboBox1.getSelectedItem() != null) {
			ArrayList<String> categoryNames = (ArrayList<String>) fieldName
					.getCategoryName(tableid.getRackId(comboBox1
							.getSelectedItem().toString()));
			for (String name : categoryNames) {
				comboBox2.addItem(name);
			}
		}
	}

	private void brandName() {
		comboBox3.removeAllItems();
		if (comboBox2.getSelectedItem() != null) {
			ArrayList<String> brandNames = (ArrayList<String>) fieldName
					.getBrandName(tableid.getCategoryId(comboBox2
							.getSelectedItem().toString()));
			for (String name : brandNames) {
				comboBox3.addItem(name);
			}
		}
	}

	private void unitName() {
		ArrayList<String> unitNames = (ArrayList<String>) fieldName
				.getUnitName();
		for (String name : unitNames) {
			comboBox4.addItem(name);
		}
	}

	private void vatPercent() {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		// System.out.println(year);
		ArrayList<Float> vatPercents = (ArrayList<Float>) fieldName
				.getVatByStartYear(year);
		comboBox5.addItem("0.0");
		for (float vat : vatPercents) {
			comboBox5.addItem(String.valueOf(vat));
			// System.out.println(vat);
		}
	}

	@Override
	public void keyPressed(KeyEvent event) {
	}

	@Override
	public void keyReleased(KeyEvent event) {
		if (!(event.getKeyChar() == 27 || event.getKeyChar() == 6)) {
			String tempStr = textField10.getText().toLowerCase();

			productDisplayList = new ArrayList<>();
			if (comboBox7.getSelectedItem().toString()
					.equals("By Product Name")) {
				for (ProductModel tempProduct1 : productList) {
					if (tempProduct1.getProductName().toLowerCase().contains(tempStr)) {
						productDisplayList.add(tempProduct1);
					}
				}
			}
			if (comboBox7.getSelectedItem().toString()
					.equals("By Product Code")) {
				for (ProductModel tempProduct1 : productList) {
					if (tempProduct1.getProductCode().toLowerCase().contains(tempStr)) {
						productDisplayList.add(tempProduct1);
					}
				}
			}

			loadTableData(productDisplayList);
		}
	}
	@Override
	public void keyTyped(KeyEvent event) {

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String temp = event.getActionCommand();

		switch (temp) {
			case "Save" :
				save();
				break;
			case "Refresh" :
				reFresh();
				break;
			case "Clear" :
				reset();
				break;
			case "View" :
				view();
				break;
			case "Update" :
				update();
				break;
			case "Delete" :
				delete();
				break;
			case "Previous" :
				if (table1.getSelectedRow() > 0) {
					int selection = table1.getSelectedRow();
					table1.setRowSelectionInterval(selection - 1, selection - 1);
				} else {
					table1.setRowSelectionInterval(0, 0);
				}
				break;
			case "next" :
				if (table1.getSelectedRow() < table1.getRowCount() - 1) {
					int selection = table1.getSelectedRow();
					table1.setRowSelectionInterval(selection + 1, selection + 1);
				} else {
					int max = table1.getRowCount();
					table1.setRowSelectionInterval(max - 1, max - 1);
				}
				break;
			default :

		}

	}
	private void save() {
		product = null;
		boolean status = true;
		if (valid.isEmpty(textField1.getText())) {
			status = false;
			new ValidationMSG(this, "Please Insert Product Code");
		} else if (valid.isEmpty(textField2.getText())) {
			status = false;
			new ValidationMSG(this, "Please Insert Product Name");
		} else if (comboBox4.getSelectedIndex() < 0) {
			status = false;
			new ValidationMSG(this, "Please Select Unit");
		} else if (valid.isEmpty(textField3.getText())) {
			status = false;
			new ValidationMSG(this, "Please Insert Quantity");
		} else if (valid.isEmpty(textField4.getText())) {
			status = false;
			new ValidationMSG(this, "Please Insert Purchase Price");
		} else if (valid.isEmpty(textField5.getText())) {
			status = false;
			new ValidationMSG(this, "Please Insert MRP");
		} else if (valid.isEmpty(textField6.getText())) {
			status = false;
			new ValidationMSG(this, "Please Insert Sale Price");
		} else if (Integer.parseInt(textField6.getText())>Integer.parseInt(textField5.getText())) {
			status = false;
			new ValidationMSG(this, "Sale Price must be equal or less then MRP");
		} else if (Integer.parseInt(textField4.getText())>Integer.parseInt(textField5.getText())) {
			status = false;
			new ValidationMSG(this, "Please Purchase Price must be less then MRP");
		} else if (comboBox5.getSelectedIndex() < 0) {
			status = false;
			new ValidationMSG(this, "Please Select Vat %");
		}

		if (status) {
			ProductModel product = new ProductModel();
			product.setProductId(0);
			product.setProductCode(textField1.getText());
			product.setProductName(textField2.getText());
			if (!valid.isEmpty(textArea1.getText()))
				product.setProductDesc(textArea1.getText());
			if (comboBox1.getSelectedItem() != null)
				product.setRackId(tableid.getRackId(comboBox1.getSelectedItem()
						.toString()));
			if (comboBox2.getSelectedItem() != null)
				product.setCategoryId(tableid.getCategoryId(comboBox2
						.getSelectedItem().toString()));
			if (comboBox3.getSelectedItem() != null)
				product.setBrandId(tableid.getBrandId(comboBox3
						.getSelectedItem().toString()));
			product.setUnit(comboBox4.getSelectedItem().toString());

			product.setQuantity(Float.parseFloat(textField3.getText()));
			product.setPurchaseRate(Float.parseFloat(textField4.getText()));
			product.setMRP(Float.parseFloat(textField5.getText()));
			product.setSaleRate(Float.parseFloat(textField6.getText()));
			if (!valid.isEmpty(textField7.getText()))
				product.setWholesaleRate(Float.parseFloat(textField7.getText()));
			if (!valid.isEmpty(textField8.getText()))
				product.setOnlineRate(Float.parseFloat(textField8.getText()));
			product.setVatPercent(Float.parseFloat(comboBox5.getSelectedItem()
					.toString()));
			if (!valid.isEmpty(textField9.getText()))
				product.setLowQuantity(Float.parseFloat(textField9.getText()));

			product.setFirmId(1);
			product.setStoreId(tableid.getStoreId(comboBox6.getSelectedItem()
					.toString()));
			int year = Calendar.getInstance().get(Calendar.YEAR);
			product.setYearId(tableid.getYearId(year, year + 1));

			if (dbinsert.insertProduct(product)) {
				reset();
				loadTableData(productDisplayList);
			} else {
				new ValidationMSG(this,
						"Product With this name is Already in list.");
			}
		}
	}

	private void reFresh() {
		reset();
		loadTableData(productDisplayList);
	}

	private void exit() {
		this.dispose();
	}

	private void view() {
		boolean status = true;
		if (table1.getSelectedRowCount() != 1) {
			status = false;
			new ValidationMSG(this, "Please Select A Row from Table Then Click");
		}

		if (status) {
			product = productDisplayList.get(table1.getSelectedRow());
			textField1.setText(product.getProductCode());
			textField2.setText(product.getProductName());
			textArea1.setText(product.getProductDesc());
			comboBox1
					.setSelectedItem(fieldName.getRackName(product.getRackId()));
			comboBox2.setSelectedItem(fieldName.getCategoryNameByID(product
					.getCategoryId()));
			comboBox3.setSelectedItem(fieldName.getBrandNameById(product
					.getBrandId()));
			comboBox4.setSelectedItem(product.getUnit());
			textField3.setText(String.valueOf(product.getQuantity()));
			textField4.setText(String.valueOf(product.getPurchaseRate()));
			textField5.setText(String.valueOf(product.getMRP()));
			textField6.setText(String.valueOf(product.getSaleRate()));
			textField7.setText(String.valueOf(product.getWholesaleRate()));
			textField8.setText(String.valueOf(product.getOnlineRate()));
			comboBox5.setSelectedItem(String.valueOf(product.getVatPercent()));
			textField9.setText(String.valueOf(product.getLowQuantity()));

		}
	}

	private void update() {
		boolean status = true;
		if (valid.isEmpty(textField1.getText())) {
			status = false;
			new ValidationMSG(this, "Please Insert Product Code");
		} else if (valid.isEmpty(textField2.getText())) {
			status = false;
			new ValidationMSG(this, "Please Insert Product Name");
		} else if (comboBox4.getSelectedIndex() < 0) {
			status = false;
			new ValidationMSG(this, "Please Select Unit");
		} else if (valid.isEmpty(textField3.getText())) {
			status = false;
			new ValidationMSG(this, "Please Insert Quantity");
		} else if (valid.isEmpty(textField4.getText())) {
			status = false;
			new ValidationMSG(this, "Please Insert Purchase Price");
		} else if (valid.isEmpty(textField5.getText())) {
			status = false;
			new ValidationMSG(this, "Please Insert MRP");
		} else if (valid.isEmpty(textField6.getText())) {
			status = false;
			new ValidationMSG(this, "Please Insert Sale Price");
		} else if (Integer.parseInt(textField6.getText())>Integer.parseInt(textField5.getText())) {
			status = false;
			new ValidationMSG(this, "Sale Price must be equal or less then MRP");
		} else if (Integer.parseInt(textField4.getText())>Integer.parseInt(textField5.getText())) {
			status = false;
			new ValidationMSG(this, "Please Purchase Price must be less then MRP");
		} else if (comboBox5.getSelectedIndex() < 0) {
			status = false;
			new ValidationMSG(this, "Please Select Vat %");
		}

		if (status) {
			// ProductModel product = new ProductModel();
			// product.setProductId(0);
			product.setProductCode(textField1.getText());
			product.setProductName(textField2.getText());
			if (!valid.isEmpty(textArea1.getText()))
				product.setProductDesc(textArea1.getText());
			if (comboBox1.getSelectedItem() != null)
				product.setRackId(tableid.getRackId(comboBox1.getSelectedItem()
						.toString()));
			if (comboBox2.getSelectedItem() != null)
				product.setCategoryId(tableid.getCategoryId(comboBox2
						.getSelectedItem().toString()));
			if (comboBox3.getSelectedItem() != null)
				product.setBrandId(tableid.getBrandId(comboBox3
						.getSelectedItem().toString()));
			product.setUnit(comboBox4.getSelectedItem().toString());

			product.setQuantity(Float.parseFloat(textField3.getText()));
			product.setPurchaseRate(Float.parseFloat(textField4.getText()));
			product.setMRP(Float.parseFloat(textField5.getText()));
			product.setSaleRate(Float.parseFloat(textField6.getText()));
			if (!valid.isEmpty(textField7.getText()))
				product.setWholesaleRate(Float.parseFloat(textField7.getText()));
			if (!valid.isEmpty(textField8.getText()))
				product.setOnlineRate(Float.parseFloat(textField8.getText()));
			product.setVatPercent(Float.parseFloat(comboBox5.getSelectedItem()
					.toString()));
			if (!valid.isEmpty(textField9.getText()))
				product.setLowQuantity(Float.parseFloat(textField9.getText()));

			// product.setFirmId(1);
			product.setStoreId(tableid.getStoreId(comboBox6.getSelectedItem()
					.toString()));
			// int year=Calendar.getInstance().get(Calendar.YEAR);
			// product.setYearId(tableid.getYearId(year, year+1));

			new DatabaseUpdate(connection).updateProduct(product);
			reset();
			loadTableData(productDisplayList);
		}
	}

	private void delete() {
		boolean status = true;
		if (table1.getSelectedRowCount() != 1) {
			status = false;
			new ValidationMSG(this, "Please Select A Row from Table Then Click");
		}

		if (status) {
			if (new PromptDailog().getUserResponse()) {
				int id = productDisplayList.get(table1.getSelectedRow())
						.getProductId();
				new DatabaseDelete(connection).deleteProductVat(id);
				new DatabaseDelete(connection).deleteProduct(id);
				productDisplayList.remove(table1.getSelectedRow());
				loadTableData(productDisplayList);
				productList = dbValue.getProductDetail(tableid
						.getStoreId(comboBox6.getSelectedItem().toString()));
			}
		}
	}

	@Override
	public void itemStateChanged(ItemEvent event) {
		// TODO Auto-generated method stub
		if (event.getSource() == comboBox6) {
			rackName();
			productList = dbValue.getProductDetail(tableid
					.getStoreId(comboBox6.getSelectedItem().toString()));
			productDisplayList = productList;
			loadTableData(productDisplayList);
		}
		if (event.getSource() == comboBox1) {
			categoryName();
		}
		if (event.getSource() == comboBox2) {
			brandName();
		}

	}

	public void reset() {
		textField1.setText("");
		textField2.setText("");
		textArea1.setText("");
		// comboBox6.setSelectedIndex(0);
		if (comboBox1.getItemCount() > 0)
			comboBox1.setSelectedItem(0);
		if (comboBox2.getItemCount() > 0)
			comboBox2.setSelectedItem(0);
		if (comboBox3.getItemCount() > 0)
			comboBox3.setSelectedItem(0);
		textField3.setText("");
		textField4.setText("");
		textField5.setText("");
		textField6.setText("");
		textField7.setText("");
		textField8.setText("");
		comboBox5.setSelectedIndex(0);
		textField9.setText("");
		product = null;
		productList = dbValue.getProductDetail(tableid.getStoreId(comboBox6
				.getSelectedItem().toString()));
		productDisplayList = new ArrayList<>();
	}

}
