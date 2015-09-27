package com.lrd.inventory.ui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.lrd.inventory.database.DatabaseInsert;
import com.lrd.inventory.database.DatabaseUpdate;
import com.lrd.inventory.database.GetDBValue;
import com.lrd.inventory.main.Validate;
import com.lrd.inventory.main.ValidationMSG;
import com.lrd.inventory.model.StoreModel;

public class StoreRegistration extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JScrollPane scrollPane1;

	private DefaultTableModel tableModel1;
	private JTable table1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JLabel label8;
	private JLabel label9;
	private JLabel label10;
	private JLabel label11;

	private JButton button2;
	private JButton button3;
	private JButton button1;
	private JButton button4;
	private JButton button5;
	private JTextField textField1;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	private JTextField textField7;
	private JTextField textField8;
	private JTextField textField9;
	private JTextField textField10;

	private JScrollPane scrollPane2;
	private JTextArea textArea1;

	Connection connection = null;

	StoreModel store = null;
	ArrayList<StoreModel> storeList;
	Validate valid;

	public StoreRegistration(Connection connection) {
		// TODO Auto-generated constructor stub
		this.connection = connection;
		valid = new Validate();
		initComponents();
		storeList = new GetDBValue(connection).getStoreDetail();
		loadTableData();
	}
	// creating UI for Frame
	private void initComponents() {
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		scrollPane1 = new JScrollPane();
		scrollPane2 = new JScrollPane();
		textField1 = new JTextField();
		textField3 = new JTextField();
		textField4 = new JTextField();
		textField5 = new JTextField();
		textField6 = new JTextField();
		textField7 = new JTextField();
		textField8 = new JTextField();
		textField9 = new JTextField();
		textField10 = new JTextField();
		textArea1 = new JTextArea();

		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		label5 = new JLabel();
		label6 = new JLabel();
		label7 = new JLabel();
		label8 = new JLabel();
		label9 = new JLabel();
		label10 = new JLabel();
		label11 = new JLabel();

		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		button5 = new JButton();

		tableModel1 = new DefaultTableModel();
		table1 = new JTable(tableModel1);

		// ======== this ========
		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		// ======== panel1 ========
		{
			panel1.setLayout(null);
			// ======== panel2 ========
			{
				panel2.setLayout(null);
				JLabel label4 = new JLabel("Store Registration");
				panel2.add(label4);
				label4.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
				label4.setBounds(250, 10, 300, 30);
				panel2.setLayout(null);

			}
			panel1.add(panel2);
			panel2.setBounds(0, 0, 500, 70);

			// ======== panel3 ========
			{
				panel3.setLayout(null);
				// ---- label27 ----

				tableModel1.addColumn("Sr");
				tableModel1.addColumn("Store Name");
				tableModel1.addColumn("Manager");
				tableModel1.addColumn("Contact");
				tableModel1.addColumn("City");
				tableModel1.addColumn("State");
				// ======== scrollPane1 ========
				{
					scrollPane1.setViewportView(table1);
				}
				panel3.add(scrollPane1);
				scrollPane1.setBounds(370, 10, 440, 380);

				label2.setText("Store Name");
				panel3.add(label2);
				label2.setBounds(50, 20, 100, 20);

				panel3.add(textField1);
				textField1.setBounds(150, 20, 200, 20);

				label3.setText("Address");
				panel3.add(label3);
				label3.setBounds(50, 50, 100, 20);

				// ======== scrollPane1 ========
				{
					scrollPane2.setViewportView(textArea1);
				}
				panel3.add(scrollPane2);
				scrollPane2.setBounds(150, 50, 200, 100);

				label4.setText("Pin No.");
				panel3.add(label4);
				label4.setBounds(50, 160, 100, 20);

				panel3.add(textField3);
				textField3.setBounds(150, 160, 200, 20);

				label5.setText("City");
				panel3.add(label5);
				label5.setBounds(50, 190, 100, 20);

				panel3.add(textField4);
				textField4.setBounds(150, 190, 200, 20);

				label6.setText("State");
				panel3.add(label6);
				label6.setBounds(50, 220, 100, 20);

				panel3.add(textField5);
				textField5.setBounds(150, 220, 200, 20);

				label7.setText("Contact");
				panel3.add(label7);
				label7.setBounds(50, 250, 100, 20);

				panel3.add(textField6);
				textField6.setBounds(150, 250, 200, 20);

				label8.setText("Email");
				panel3.add(label8);
				label8.setBounds(50, 280, 100, 20);

				panel3.add(textField7);
				textField7.setBounds(150, 280, 200, 20);

				label9.setText("Manager Name");
				panel3.add(label9);
				label9.setBounds(50, 310, 100, 20);

				panel3.add(textField8);
				textField8.setBounds(150, 310, 200, 20);

				label10.setText("Reg. No.");
				panel3.add(label10);
				label10.setBounds(50, 340, 100, 20);

				panel3.add(textField9);
				textField9.setBounds(150, 340, 200, 20);

				label11.setText("PAN No.");
				panel3.add(label11);
				label11.setBounds(50, 370, 100, 20);

				panel3.add(textField10);
				textField10.setBounds(150, 370, 200, 20);

			}// end panel3---
			panel1.add(panel3);
			panel3.setBounds(0, 70, 850, 400);

			// -------panel4 ------
			{
				panel4.setLayout(null);
				// ---- button1 ----
				button1.setText("Save");
				panel4.add(button1);
				button1.setBounds(100, 0, 80, 30);
				button1.addActionListener(this);

				// ---- button2 ----
				button2.setText("View");
				panel4.add(button2);
				button2.setBounds(200, 0, 80, 30);
				button2.addActionListener(this);

				// ---- button3 ----
				button3.setText("Update");
				panel4.add(button3);
				button3.setBounds(300, 0, 80, 30);
				button3.addActionListener(this);

				// ---- button4 ----
				button4.setText("Delete");
				panel4.add(button4);
				button4.setBounds(400, 0, 80, 30);
				button4.addActionListener(this);
				button4.setEnabled(false);

				// ---- button5 ----
				button5.setText("Refresh");
				panel4.add(button5);
				button5.setBounds(500, 0, 80, 30);
				button5.addActionListener(this);

			}// end panel 4

			panel1.add(panel4);
			panel4.setBounds(0, 500, 700, 40);
		}// end panel 1

		add(panel1);
		panel1.setBounds(0, 0, 850, 600);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setSize(850, 650);

	}

	private void loadTableData() {
		while (tableModel1.getRowCount() > 0) {
			tableModel1.removeRow(0);
		}
		for (int i = 0; i < storeList.size(); i++) {
			StoreModel store = storeList.get(i);
			tableModel1.addRow(new Object[]{i + 1, store.getStoreName(),
					store.getManagerName(), store.getContactNo(),
					store.getCityName(), store.getStateName()});
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub

		String source = event.getActionCommand();

		switch (source) {
			case "Save" :
				saveStore();
				break;
			case "View" :
				viewStore();
				break;
			case "Update" :
				updateStore();
				break;
			case "Refresh" :
				refresh();
				break;
			default :
				break;
		}
	}

	private void refresh() {
		// TODO Auto-generated method stub
		textField1.setText("");
		textArea1.setText("");
		textField3.setText("");
		textField4.setText("");
		textField5.setText("");
		textField6.setText("");
		textField7.setText("");
		textField8.setText("");
		textField9.setText("");
		textField10.setText("");
		storeList = new GetDBValue(connection).getStoreDetail();
		loadTableData();
	}
	private void updateStore() {
		// TODO Auto-generated method stub
		if (store == null) {
			new ValidationMSG(this, "Please select a row from table then view it and update it");
		} else if (valid.isEmpty(textField1.getText())) {
			new ValidationMSG(this, "Please insert store Name");
		} else if (valid.isEmpty(textArea1.getText())) {
			new ValidationMSG(this, "Please insert store Address");
		} else if (valid.isEmpty(textField6.getText())) {
			new ValidationMSG(this, "Please insert Contact no");
		} else if (valid.isEmpty(textField8.getText())) {
			new ValidationMSG(this, "Please insert Manager Name");
		} else {
			

			store.setStoreName(textField1.getText());
			store.setAddress(textArea1.getText());
			if (!valid.isEmpty(textField3.getText()))
				store.setPinNo(Integer.parseInt(textField3.getText()));
			if (!valid.isEmpty(textField4.getText()))
				store.setCity(textField4.getText());
			if (!valid.isEmpty(textField5.getText()))
				store.setState(textField5.getText());
			store.setContactNo(textField6.getText());
			if (!valid.isEmpty(textField7.getText()))
				store.setEmailId(textField7.getText());
			store.setManagerName(textField8.getText());
			if (!valid.isEmpty(textField9.getText()))
				store.setRegistrationNo(textField9.getText());
			if (!valid.isEmpty(textField3.getText()))
				store.setPanNo(textField10.getText());

			new DatabaseUpdate(connection).updateStoreDetails(store);
			//storeList = new GetDBValue(connection).getStoreDetail();
			//loadTableData();
			refresh();
			store=null;
		}

	}
	private void viewStore() {
		// TODO Auto-generated method stub
		if (table1.getSelectedRowCount() == 1) {
			store = storeList.get(table1.getSelectedRow());

			textField1.setText(store.getStoreName());
			textArea1.setText(store.getAddress());
			textField3.setText(String.valueOf(store.getPinNo()));
			textField4.setText(store.getCityName());
			textField5.setText(store.getStateName());
			textField6.setText(store.getContactNo());
			textField7.setText(store.getEmailId());
			textField8.setText(store.getManagerName());
			textField9.setText(store.getRegistrationNo());
			textField10.setText(store.getPanNo());
		} else {
			new ValidationMSG(this,
					"Please select a row from Table then Click View");
		}

	}
	private void saveStore() {
		// TODO Auto-generated method stub
		if (valid.isEmpty(textField1.getText())) {
			new ValidationMSG(this, "Please insert store Name");
		} else if (valid.isEmpty(textArea1.getText())) {
			new ValidationMSG(this, "Please insert store Address");
		} else if (valid.isEmpty(textField6.getText())) {
			new ValidationMSG(this, "Please insert Contact no");
		} else if (valid.isEmpty(textField8.getText())) {
			new ValidationMSG(this, "Please insert Manager Name");
		} else {
			StoreModel store = new StoreModel();

			store.setStoreName(textField1.getText());
			store.setAddress(textArea1.getText());
			if (!valid.isEmpty(textField3.getText()))
				store.setPinNo(Integer.parseInt(textField3.getText()));
			if (!valid.isEmpty(textField4.getText()))
				store.setCity(textField4.getText());
			if (!valid.isEmpty(textField5.getText()))
				store.setState(textField5.getText());
			store.setContactNo(textField6.getText());
			if (!valid.isEmpty(textField7.getText()))
				store.setEmailId(textField7.getText());
			store.setManagerName(textField8.getText());
			if (!valid.isEmpty(textField9.getText()))
				store.setRegistrationNo(textField9.getText());
			if (!valid.isEmpty(textField3.getText()))
				store.setPanNo(textField10.getText());

			new DatabaseInsert(connection).insertStoreDetail(store);
			refresh();
			//storeList = new GetDBValue(connection).getStoreDetail();
			//loadTableData();
		}
	}

}
