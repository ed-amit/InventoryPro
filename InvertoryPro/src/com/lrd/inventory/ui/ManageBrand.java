/*
 * Created by JFormDesigner on Fri May 29 16:39:18 IST 2015
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

import com.lrd.inventory.database.DatabaseDelete;
import com.lrd.inventory.database.DatabaseInsert;
import com.lrd.inventory.database.DatabaseUpdate;
import com.lrd.inventory.database.GetDBValue;
import com.lrd.inventory.database.SpecificFieldValue;
import com.lrd.inventory.database.TableId;
import com.lrd.inventory.main.Validate;
import com.lrd.inventory.main.ValidationMSG;
import com.lrd.inventory.model.BrandModel;

/**
 * @author dharmendra singh
 */
public class ManageBrand extends JFrame implements ActionListener, ItemListener {

	private static final long serialVersionUID = 1L;
	// Variables declaration
	private JLabel label2;
	private JPanel panel1;
	private JLabel label1;
	private JSeparator separator1;
	private JComboBox<Object> comboBox1;
	private JTextField textField1;
	private JLabel label4;
	private JLabel label3;
	private JScrollPane scrollPane1;
	private JTextArea textArea1;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JScrollPane scrollPane2;
	private DefaultTableModel tableModel;
	private JTable table1;
	private JLabel label5;
	private JComboBox<Object> comboBox2;
	private JLabel label6;
	private JComboBox<Object> comboBox3;

	// End of variables declaration

	Connection connection = null;
	SpecificFieldValue fieldName = null;
	TableId tableid = null;
	DatabaseInsert dbinsert = null;
	BrandModel brand = null;
	Validate valid = null;
	GetDBValue dbValue = null;
	ArrayList<BrandModel> brandList = null;

	public ManageBrand(Connection connection) {
		this.connection = connection;
		this.fieldName = new SpecificFieldValue(this.connection);
		tableid = new TableId(this.connection);
		dbinsert = new DatabaseInsert(this.connection);
		brand = new BrandModel();
		dbValue = new GetDBValue(connection);
		valid = new Validate();
		initComponents();
		storeName();
		//rackName();

		loadTableData();
	}

	private void initComponents() {

		label2 = new JLabel();
		panel1 = new JPanel();
		label1 = new JLabel();
		separator1 = new JSeparator();
		comboBox1 = new JComboBox<Object>();
		textField1 = new JTextField();
		label4 = new JLabel();
		label3 = new JLabel();
		scrollPane1 = new JScrollPane();
		textArea1 = new JTextArea();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		button5 = new JButton();
		button6 = new JButton();
		scrollPane2 = new JScrollPane();
		tableModel = new DefaultTableModel();
		table1 = new JTable(tableModel);
		label5 = new JLabel();
		comboBox2 = new JComboBox<Object>();
		label6 = new JLabel();
		comboBox3 = new JComboBox<Object>();

		// ======== this ========
		setResizable(false);
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		// ======== panel1 ========
		{
			panel1.setLayout(null);

			// ---- label1 ----
			label1.setText("Manage Brand");
			panel1.add(label1);
			label1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 30));
			label1.setBounds(200, 10, 400, 50);

			panel1.add(separator1);
			separator1.setBounds(0, 100, 600, 5);

			// ---- label2 ----
			label2.setText("Select Store");
			panel1.add(label2);
			label2.setBounds(100, 120, 150, 20);

			panel1.add(comboBox1);
			comboBox1.setBounds(250, 120, 200, 20);
			comboBox1.addItemListener(this);

			// ---- label3 ----
			label3.setText("<html>Brand Name <font color='red'><b>*</b></font></html>");
			panel1.add(label3);
			label3.setBounds(100, 160, 160, 20);

			panel1.add(textField1);
			textField1.setBounds(250, 160, 200, 20);

			// ---- label5 ----
			label5.setText("<html>Rack <font color='red'><b>*</b></font></html>");
			panel1.add(label5);
			label5.setBounds(100, 200, 150, 20);

			panel1.add(comboBox2);
			comboBox2.setBounds(250, 200, 200, 20);
			comboBox2.addItemListener(this);

			// ---- label6 ----
			label6.setText("<html>Category <font color='red'><b>*</b></font></html>");
			panel1.add(label6);
			label6.setBounds(100, 240, 150, 20);
			panel1.add(comboBox3);
			comboBox3.setBounds(250, 240, 200, 20);

			// ---- label4 ----
			label4.setText("Description");
			panel1.add(label4);
			label4.setBounds(100, 280, 150, 20);

			// ======== scrollPane1 ========
			{
				scrollPane1.setViewportView(textArea1);
			}
			panel1.add(scrollPane1);
			scrollPane1.setBounds(250, 280, 200, 100);

			// ---- button1 ----
			button1.setText("Save");
			panel1.add(button1);
			button1.setBounds(100, 410, 100, 30);
			button1.addActionListener(this);

			// ---- button2 ----
			button2.setText("Refresh");
			panel1.add(button2);
			button2.setBounds(250, 410, 100, 30);
			button2.addActionListener(this);

			// ---- button3 ----
			button3.setText("Exit");
			panel1.add(button3);
			button3.setBounds(400, 410, 100, 30);
			button3.addActionListener(this);

			// ---- button4 ----
			button4.setText("View");
			panel1.add(button4);
			button4.setBounds(100, 460, 100, 30);
			button4.addActionListener(this);

			// ---- button5 ----
			button5.setText("Update");
			panel1.add(button5);
			button5.setBounds(250, 460, 100, 30);
			button5.addActionListener(this);

			// ---- button6 ----
			button6.setText("Delete");
			panel1.add(button6);
			button6.setBounds(400, 460, 100, 30);
			button6.addActionListener(this);

			tableModel.addColumn("Sr. No.");
			tableModel.addColumn("Brand Name");
			tableModel.addColumn("Category Name");
			tableModel.addColumn("Rack Name");

			// ======== scrollPane2 ========
			{
				scrollPane2.setViewportView(table1);
			}
			panel1.add(scrollPane2);
			scrollPane2.setBounds(50, 520, 500, 150);

		}
		contentPane.add(panel1);
		panel1.setBounds(0, 0, 600, 700);

		pack();
		setVisible(true);
		setLocation(200, 10);
		setSize(600, 720);
	}

	public void loadTableData() {
		int j = 0;
		while (j < tableModel.getRowCount()) {
			tableModel.removeRow(j);
		}
		brandList = dbValue.getBrandDetail(tableid.getStoreId(comboBox1.getSelectedItem().toString()));
		for (int i = 0; i < brandList.size(); i++) {
			BrandModel brand = brandList.get(i);
			tableModel.addRow(new Object[] { i, brand.getBrandName(),
					fieldName.getCategoryNameByID(brand.getCategoryId()),
					fieldName.getRackName(brand.getRackId()) });
		}
	}

	private void storeName() {
		ArrayList<String> storeNames = (ArrayList<String>) fieldName
				.getAllStoreName();
		for (String name : storeNames) {
			comboBox1.addItem(name);
		}
	}

	private void rackName() {
		comboBox2.removeAllItems();
		//System.out.println(comboBox1.getSelectedItem().toString()==null);
		//comboBox2.addItem("----Select Rack---");
		ArrayList<String> rackNames = (ArrayList<String>) fieldName
				.getAllRackName(tableid.getStoreId(comboBox1.getSelectedItem().toString()));
		for (String name : rackNames) {
			comboBox2.addItem(name);
		}
		//categoryName();
	}

	private void categoryName() {
		comboBox3.removeAllItems();
		//System.out.println(comboBox2.getSelectedItem()==null);
		//comboBox3.addItem("---Select Category---");
		if(comboBox2.getSelectedItem()!=null){
			ArrayList<String> categoryNames = (ArrayList<String>) fieldName
					.getCategoryName(tableid.getRackId(comboBox2.getSelectedItem().toString()));
			for (String name : categoryNames) {
				comboBox3.addItem(name);
			}
		}
	}



	@Override
	public void actionPerformed(ActionEvent event) {
		String temp = event.getActionCommand();

		switch (temp) {
			case "Save":
				save();
				break;
			case "Refresh":
				reFresh();
				break;
			case "Exit":
				exit();
				break;
			case "View":
				view();
				break;
			case "Update":
				update();
				break;
			case "Delete":
				delete();
				break;
			default:

		}

	}

	private void save() {
		//check validation for empty field
		boolean status=true;
		if( valid.isEmpty(textField1.getText())){
			status=false;
			new ValidationMSG(this, "Please Insert Brand Name");
		}else if( comboBox2.getSelectedIndex()<0){
			status=false;
			new ValidationMSG(this, "Please Select Rack Name");
		}else if( comboBox3.getSelectedIndex()<0){
			status=false;
			new ValidationMSG(this, "Please Select Category Name");
		}
		if(status){
			BrandModel brand=new BrandModel();
			brand.setBrandId(0);
			brand.setBrandName(textField1.getText());
			if(!valid.isEmpty(textArea1.getText()))
				brand.setBrandDesc(textArea1.getText());
			brand.setCategoryId(tableid.getCategoryId(comboBox3
					.getSelectedItem().toString()));
			brand.setRackId(tableid.getRackId(comboBox2.getSelectedItem()
					.toString()));
			brand.setFirmId(1);
			brand.setStoreId(tableid.getStoreId(comboBox1.getSelectedItem()
					.toString()));
			dbinsert.insertBrand(brand);
			brand.setDefault();
			reset();
		}

	}

	private void reFresh() {
		reset();
		comboBox2.setSelectedIndex(0);
	}

	private void exit() {
		this.dispose();
	}

	private void view() {
		boolean status=true;

		if(table1.getSelectedRowCount()<1){
			status=false;
			new ValidationMSG(this, "Please Select A Row from Table Then Click");
		}

		if(status){
			/*int row=table1.getSelectedRow();
			System.out.println("row = "+row);
			int id = brandList.get(row).getBrandId();
			System.out.println("id = "+id);*/
			brand = brandList.get(table1.getSelectedRow());
			textField1.setText(brand.getBrandName());
			comboBox2.setSelectedItem(fieldName.getRackName(brand.getRackId()));
			comboBox3.setSelectedItem(fieldName.getCategoryNameByID(brand.getCategoryId()));
			textArea1.setText(brand.getBrandDesc());
		}
	}

	private void update() {
		boolean status=true;
		if(brand==null){
			status=false;
			new ValidationMSG(this, "Please Select A Row from Table Then Click on View to Update Rack Details");
		}else if( valid.isEmpty(textField1.getText())){
			status=false;
			new ValidationMSG(this, "Please Insert Brand Name");
		}else if( comboBox2.getSelectedIndex()<0){
			status=false;
			new ValidationMSG(this, "Please Select Rack Name");
		}else if( comboBox3.getSelectedIndex()<0){
			status=false;
			new ValidationMSG(this, "Please Select Category Name");
		}


		if(status){
			brand.setBrandName(textField1.getText());
			if(!valid.isEmpty(textArea1.getText()))
				brand.setBrandDesc(textArea1.getText());
			brand.setRackId(tableid.getRackId(comboBox2.getSelectedItem().toString()));
			brand.setCategoryId(tableid.getCategoryId(comboBox3.getSelectedItem().toString()));
			new DatabaseUpdate(connection).updateBrand(brand);
			reset();
			brand=null;
		}
	}

	private void delete() {
		boolean status=true;
		if(table1.getSelectedRowCount()!=1){
			status=false;
			new ValidationMSG(this, "Please Select A Row from Table Then Click");
		}
		if(status){
			int id = brandList.get(table1.getSelectedRow()).getBrandId();
			new DatabaseDelete(connection).deleteBrand(id);
			loadTableData();
			reset();
		}
	}

	private void reset() {
		//comboBox1.setSelectedIndex(0);
		//comboBox2.setSelectedIndex(0);
		//comboBox3.setSelectedIndex(0);

		textField1.setText("");
		textArea1.setText("");
		loadTableData();
	}

	@Override
	public void itemStateChanged(ItemEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource()==comboBox1){
			rackName();
			reset();
		}

		if (event.getSource()==comboBox2){
			categoryName();
			loadTableData();
		}
	}

}
