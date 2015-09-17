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
import com.lrd.inventory.model.RackModel;

/**
 * @author dharmendra singh
 * @see this is a ui class which is used to manage rack for a perticular store .
 */
public class ManageRack extends JFrame implements ActionListener, ItemListener {

	private static final long serialVersionUID = 1L;

	// Declaration of all UI elements
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

	// /declaration of all supported objects
	Connection connection = null;
	SpecificFieldValue fieldName = null;
	TableId tableid = null;
	DatabaseInsert dbinsert = null;
	RackModel rack = null;
	Validate valid = null;
	GetDBValue dbValue = null;
	DatabaseUpdate dbupdate = null;
	DatabaseDelete dbdelete = null;
	ArrayList<RackModel> rackList = null;

	// End of variables declaration

	/**
	 * @param connection
	 *            object of java.sql.Connection class
	 */
	public ManageRack(Connection connection) {
		this.connection = connection;
		this.fieldName = new SpecificFieldValue(this.connection);
		tableid = new TableId(this.connection);
		dbinsert = new DatabaseInsert(this.connection);
		rack = new RackModel();
		dbValue = new GetDBValue(connection);
		dbupdate = new DatabaseUpdate(connection);
		dbdelete = new DatabaseDelete(connection);
		valid = new Validate();
		initComponents();
		storeName();
		loadTableData();
	}

	/**
	 * this method is used to design Main UI of Rack manager
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

		// ======== this ========
		setResizable(false);
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		// ======== panel1 ========
		{
			panel1.setLayout(null);

			// ---- label1 ----
			label1.setText("Manage Rack");
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
			label3.setText("<html>Rack Name <font color='red'><b>*</b></font></html>");
			panel1.add(label3);
			label3.setBounds(100, 160, 160, 20);

			panel1.add(textField1);
			textField1.setBounds(250, 160, 200, 20);

			// ---- label4 ----
			label4.setText("Description");
			panel1.add(label4);
			label4.setBounds(100, 200, 150, 20);

			// ======== scrollPane1 ========
			{
				scrollPane1.setViewportView(textArea1);
			}
			panel1.add(scrollPane1);
			scrollPane1.setBounds(250, 200, 200, 100);

			// ---- button1 ----
			button1.setText("Save");
			panel1.add(button1);
			button1.setBounds(100, 350, 100, 30);
			button1.addActionListener(this);

			// ---- button2 ----
			button2.setText("Refresh");
			panel1.add(button2);
			button2.setBounds(250, 350, 100, 30);
			button2.addActionListener(this);

			// ---- button3 ----
			button3.setText("Exit");
			panel1.add(button3);
			button3.setBounds(400, 350, 100, 30);
			button3.addActionListener(this);

			// ---- button4 ----
			button4.setText("View");
			panel1.add(button4);
			button4.setBounds(100, 400, 100, 30);
			button4.addActionListener(this);

			// ---- button5 ----
			button5.setText("Update");
			panel1.add(button5);
			button5.setBounds(250, 400, 100, 30);
			button5.addActionListener(this);

			// ---- button6 ----
			button6.setText("Delete");
			panel1.add(button6);
			button6.setBounds(400, 400, 100, 30);
			button6.addActionListener(this);

			tableModel.addColumn("Sr. No.");
			tableModel.addColumn("Rack Name");

			// ======== scrollPane2 ========
			{
				scrollPane2.setViewportView(table1);
			}
			panel1.add(scrollPane2);
			scrollPane2.setBounds(50, 460, 500, 170);
		}
		contentPane.add(panel1);
		panel1.setBounds(0, 0, 600, 700);

		setTitle("Rack Manager");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
		// setLocationRelativeTo(getOwner());
		setLocation(100, 10);
		setSize(600, 700);
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

	// used to save a new record
	private void save() {
		// check validation for empty field
		boolean status = true;
		if (valid.isEmpty(textField1.getText())) {
			status = false;
			new ValidationMSG(this, "Please Insert Rack Name");
		}

		// /insert rack when all inputs are valid
		if (status) {
			RackModel rack = new RackModel();
			rack.setRackId(0);
			rack.setRackName(textField1.getText());
			if (!valid.isEmpty(textArea1.getText()))
				rack.setRackDesc(textArea1.getText());
			rack.setFirmId(1);
			rack.setStoreId(tableid.getStoreId(comboBox1.getSelectedItem()
					.toString()));
			dbinsert.insertRack(rack);
			rack.setDefault();

			loadTableData();
			reset();
		}

	}

	// refresh whole UI and used Object
	private void reFresh() {
		rack = null;
		reset();
		comboBox1.setSelectedIndex(0);
		// loadTableData();
	}

	// /close the UI
	private void exit() {
		this.dispose();
	}

	// for viewing the selected element details in table
	private void view() {
		boolean status = true;
		if (table1.getSelectedRowCount() != 1) {
			status = false;
			new ValidationMSG(this, "Please Select A Row from Table Then Click");
		}
		if (status) {
			rack = rackList.get(table1.getSelectedRow());
			textField1.setText(rack.getRackName());
			textArea1.setText(rack.getRackDesc());
			comboBox1
					.setSelectedItem(fieldName.getStoreName(rack.getStoreId()));
		}
	}

	// for update a record
	private void update() {
		boolean status = true;
		if (rack == null) {
			status = false;
			new ValidationMSG(this,
					"Please Select A Row from Table Then Click on View to Update Rack Details");
		} else if (valid.isEmpty(textField1.getText())) {
			status = false;
			new ValidationMSG(this, "Please Insert Rack Name");
		}
		if (status) {
			rack.setRackName(textField1.getText());
			if (!valid.isEmpty(textArea1.getText()))
				rack.setRackDesc(textArea1.getText());
			dbupdate.updateRack(rack);
			reset();
			loadTableData();
			rack = null;
		}
	}

	// delete a rack form database
	private void delete() {
		boolean status = true;
		if (table1.getSelectedRowCount() != 1) {
			status = false;
			new ValidationMSG(this, "Please Select A Row from Table Then Click");
		}
		if (status) {
			if (new PromptDailog().getUserResponse()) {
				int id = rackList.get(table1.getSelectedRow()).getRackId();
				dbdelete.deleteRack(id);
				loadTableData();
			}
		}
	}

	// this method every time load the rackList from database and then display
	// it in table
	public void loadTableData() {
		int j = 0;
		while (j < tableModel.getRowCount()) {
			tableModel.removeRow(j);
		}
		rackList = dbValue.getRackDetail(tableid.getStoreId(comboBox1
				.getSelectedItem().toString()));
		for (int i = 0; i < rackList.size(); i++) {
			RackModel rack = rackList.get(i);
			tableModel.addRow(new Object[]{i + 1, rack.getRackName()});
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

	// for reset all field of UI
	private void reset() {
		// comboBox1.setSelectedIndex(0);
		textField1.setText("");
		textArea1.setText("");
		loadTableData();
	}

	@Override
	public void itemStateChanged(ItemEvent event) {
		// TODO Auto-generated method stub
		if (event.getSource() == comboBox1) {
			// rackList=
			// dbValue.getRackDetail(tableid.getStoreId(comboBox1.getSelectedItem().toString()));
			// loadTableData();
			reset();
		}
	}

}
