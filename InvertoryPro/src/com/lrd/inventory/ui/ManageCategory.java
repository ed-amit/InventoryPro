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
import com.lrd.inventory.main.PromptDailog;
import com.lrd.inventory.main.Validate;
import com.lrd.inventory.main.ValidationMSG;
import com.lrd.inventory.model.CategoryModel;

/**
 * @author dharmendra singh
 * @see this is a ui class which is used to manage Categories of a rack for a
 *      perticular store .
 */
public class ManageCategory extends JFrame
		implements
			ActionListener,
			ItemListener {

	private static final long serialVersionUID = 1L;

	// UI Variables declaration -
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
	private JTable table1;
	private DefaultTableModel tableModel;
	private JLabel label5;
	private JComboBox<Object> comboBox2;
	// End of UI variables declaration

	// Supported Objects
	Connection connection = null;
	SpecificFieldValue fieldName = null;
	TableId tableid = null;
	DatabaseInsert dbinsert = null;
	CategoryModel category = null;
	Validate valid = null;
	GetDBValue dbValue = null;
	ArrayList<CategoryModel> categoryList = null;

	/**
	 * 
	 * @param connection
	 *            object of java.sql.Connection class
	 */
	public ManageCategory(Connection connection) {
		this.connection = connection;
		this.fieldName = new SpecificFieldValue(this.connection);
		tableid = new TableId(this.connection);
		dbinsert = new DatabaseInsert(this.connection);
		category = new CategoryModel();
		dbValue = new GetDBValue(connection);
		valid = new Validate();
		initComponents();

		storeName();
		rackName();
		loadTableData();
	}

	/**
	 * this method is used to design Main UI of Category manager
	 */
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

		// ======== this ========
		setResizable(false);
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		// ======== panel1 ========
		{
			panel1.setLayout(null);

			// ---- label1 ----
			label1.setText("Manage Category");
			label1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 30));
			panel1.add(label1);
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
			label3.setText("<html>Category Name <font color='red'><b>*</b></font></html>");
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

			// ---- label4 ----
			label4.setText("Description");
			panel1.add(label4);
			label4.setBounds(100, 240, 150, 20);

			// ======== scrollPane1 ========
			{
				scrollPane1.setViewportView(textArea1);
			}
			panel1.add(scrollPane1);
			scrollPane1.setBounds(250, 240, 200, 100);

			// ---- button1 ----
			button1.setText("Save");
			panel1.add(button1);
			button1.setBounds(100, 380, 100, 30);
			button1.addActionListener(this);

			// ---- button2 ----
			button2.setText("Refresh");
			panel1.add(button2);
			button2.setBounds(250, 380, 100, 30);
			button2.addActionListener(this);

			// ---- button3 ----
			button3.setText("Exit");
			panel1.add(button3);
			button3.setBounds(400, 380, 100, 30);
			button3.addActionListener(this);

			// ---- button4 ----
			button4.setText("View");
			panel1.add(button4);
			button4.setBounds(100, 430, 100, 30);
			button4.addActionListener(this);

			// ---- button5 ----
			button5.setText("Update");
			panel1.add(button5);
			button5.setBounds(250, 430, 100, 30);
			button5.addActionListener(this);

			// ---- button6 ----
			button6.setText("Delete");
			panel1.add(button6);
			button6.setBounds(400, 430, 100, 30);
			button6.addActionListener(this);

			tableModel.addColumn("Sr. No.");
			tableModel.addColumn("Category Name");
			tableModel.addColumn("Rack Name");

			// ======== scrollPane2 ========
			{
				scrollPane2.setViewportView(table1);
			}
			panel1.add(scrollPane2);
			scrollPane2.setBounds(50, 490, 500, 170);

		}
		contentPane.add(panel1);
		panel1.setBounds(0, 0, 600, 700);

		setTitle("Category Manager");
		pack();
		setVisible(true);
		setLocation(200, 10);
		setSize(600, 700);
	}

	// this method every time load the rackList from database and then display
	// it in table
	public void loadTableData() {
		int j = 0;
		while (j < tableModel.getRowCount()) {
			tableModel.removeRow(j);
		}
		categoryList = dbValue.getCategoryDetail(tableid.getStoreId(comboBox1
				.getSelectedItem().toString()));
		for (int i = 0; i < categoryList.size(); i++) {
			CategoryModel category = categoryList.get(i);
			tableModel.addRow(new Object[]{i + 1, category.getCategoryName(),
					fieldName.getRackName(category.getRackId())});
		}
	}

	// this method show all store name
	private void storeName() {
		ArrayList<String> storeNames = (ArrayList<String>) fieldName
				.getAllStoreName();
		for (String name : storeNames) {
			comboBox1.addItem(name);
		}
	}

	// this method show all Rack name
	private void rackName() {
		comboBox2.removeAllItems();
		comboBox2.addItem("----Select Rack----");
		ArrayList<String> rackNames = (ArrayList<String>) fieldName
				.getAllRackName(tableid.getStoreId(comboBox1.getSelectedItem()
						.toString()));
		for (String name : rackNames) {
			comboBox2.addItem(name);
		}
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
			case "Exit" :
				exit();
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
			default :

		}

	}

	private void save() {
		// check validation for empty field
		boolean status = true;
		if (valid.isEmpty(textField1.getText())) {
			status = false;
			new ValidationMSG(this, "Please Insert category Name");
		} else if (comboBox2.getSelectedIndex() <= 0) {
			status = false;
			new ValidationMSG(this, "Please Select Rack Name");
		}

		if (status) {
			CategoryModel category = new CategoryModel();
			// check validation for empty field
			category.setCategoryId(0);
			category.setCategoryName(textField1.getText());
			if (!valid.isEmpty(textArea1.getText()))
				category.setCategoryDesc(textArea1.getText());
			category.setRackId(tableid.getRackId(comboBox2.getSelectedItem()
					.toString()));
			category.setFirmId(1);
			category.setStoreId(tableid.getStoreId(comboBox1.getSelectedItem()
					.toString()));
			if (!dbinsert.insertCategory(category)) {
				new ValidationMSG(this,
						"Category already exists in the same Rack.");
			}
			reset();
		}

	}

	private void reFresh() {
		reset();
		comboBox1.setSelectedIndex(0);
	}

	private void exit() {
		this.dispose();
	}

	private void view() {
		boolean status = true;

		if (table1.getSelectedRowCount() < 1) {
			status = false;
			new ValidationMSG(this, "Please Select A Row from Table Then Click");
		}

		if (status) {
			category = categoryList.get(table1.getSelectedRow());
			textField1.setText(category.getCategoryName());
			comboBox2.setSelectedItem(fieldName.getRackName(category
					.getRackId()));
			textArea1.setText(category.getCategoryDesc());

		}
	}

	private void update() {
		boolean status = true;
		if (category == null) {
			status = false;
			new ValidationMSG(this,
					"Please Select A Row from Table Then Click on View to Update Rack Details");
		} else if (valid.isEmpty(textField1.getText())) {
			status = false;
			new ValidationMSG(this, "Please Insert category Name");
		} else if (comboBox2.getSelectedIndex() <= 0) {
			status = false;
			new ValidationMSG(this, "Please Select Rack Name");
		}

		if (status) {
			category.setCategoryName(textField1.getText());
			if (!valid.isEmpty(textArea1.getText()))
				category.setCategoryDesc(textArea1.getText());
			category.setRackId(tableid.getRackId(comboBox2.getSelectedItem()
					.toString()));
			if (!new DatabaseUpdate(connection).updateCategory(category)) {
				new ValidationMSG(this,
						"Category already exists in the same Rack.");
			} else {
				reset();
				category = null;
			}

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
				int id = categoryList.get(table1.getSelectedRow())
						.getCategoryId();
				new DatabaseDelete(connection).deleteCategory(id);
				loadTableData();
			}
		}
	}

	// for reset all field of UI
	private void reset() {
		// comboBox1.setSelectedIndex(0);
		if (comboBox2.getItemCount() > 0) {
			comboBox2.setSelectedIndex(0);
		}
		textField1.setText("");
		textArea1.setText("");
		loadTableData();
	}

	@Override
	public void itemStateChanged(ItemEvent event) {
		// TODO Auto-generated method stub
		if (event.getSource() == comboBox1) {
			// loadTableData();
			rackName();
			reset();
		}
	}

}
