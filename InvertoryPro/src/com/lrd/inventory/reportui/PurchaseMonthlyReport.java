package com.lrd.inventory.reportui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.lrd.inventory.database.DatabaseReport;
import com.lrd.inventory.database.SpecificFieldValue;
import com.lrd.inventory.database.TableId;
import com.lrd.inventory.model.ProductModel;
import com.lrd.inventory.model.StoreModel;

public class PurchaseMonthlyReport extends JFrame
		implements
			ItemListener,
			ActionListener {

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
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JButton button2;
	private JButton button3;
	private JButton button1;
	private JComboBox<String> comboBox1;
	private JComboBox<String> comboBox2;
	private JComboBox<String> comboBox3;

	Connection connection = null;
	ArrayList<ProductModel> productList = null;

	public PurchaseMonthlyReport(Connection connection) {
		this.connection = connection;

		initComponents();
		setYear();
		storeName();
		
	}

	// creating UI for Frame
	private void initComponents() {
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		scrollPane1 = new JScrollPane();

		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel("Select Month");
		button1 = new JButton("Search");
		button2 = new JButton("Cancel");
		button3 = new JButton("Print");
		comboBox1 = new JComboBox<String>();
		comboBox2 = new JComboBox<String>();
		comboBox3 = new JComboBox<String>();
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
				label4 = new JLabel("Monthly Report");
				panel2.add(label4);
				label4.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
				label4.setBounds(200, 10, 300, 30);
				panel2.setLayout(null);

				// ---- label27 ----
				label1.setText("Select Store");
				// label1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC,
				// 20));
				panel2.add(label1);
				label1.setBounds(20, 50, 80, 20);

				panel2.add(comboBox3);
				comboBox3.setBounds(100, 50, 200, 20);
				comboBox3.addItemListener(this);
				// comboBox3.addItem("Select Store");

			}
			panel1.add(panel2);
			panel2.setBounds(0, 0, 600, 70);
			// ======== panel3 ========
			{
				panel3.setLayout(null);
				// ---- label27 ----

				label2.setText("Select Month");
				panel3.add(label2);
				label2.setBounds(20, 20, 80, 20);

				panel3.add(comboBox1);
				comboBox1.setBounds(100, 20, 100, 20);
				//comboBox1.addItem("--Select Month--");
				comboBox1.addItem("January");
				comboBox1.addItem("Feburary");
				comboBox1.addItem("March");
				comboBox1.addItem("April");
				comboBox1.addItem("May");
				comboBox1.addItem("June");
				comboBox1.addItem("July");
				comboBox1.addItem("August");
				comboBox1.addItem("September");
				comboBox1.addItem("October");
				comboBox1.addItem("November");
				comboBox1.addItem("December");

				label3.setText("Select Year");
				panel3.add(label3);
				label3.setBounds(20, 50, 80, 20);

				panel3.add(comboBox2);
				comboBox2.setBounds(100, 50, 100, 20);
				//comboBox2.addItem("Select Year");

				// ---- button2 ----
				button1.setText("Search");
				panel3.add(button1);
				button1.setBounds(250, 20, 80, 20);
				button1.addActionListener(this);

				// ---- button2 ----
				button2.setText("Refresh");
				panel3.add(button2);
				button2.setBounds(250, 50, 80, 20);
				button2.addActionListener(this);

				tableModel1.addColumn("Sr.");
				tableModel1.addColumn("Code");
				tableModel1.addColumn("Name");
				tableModel1.addColumn("Unit");
				tableModel1.addColumn("MRP");
				tableModel1.addColumn("Qty");
				// ======== scrollPane1 ========
				{
					scrollPane1.setViewportView(table1);
				}
				panel3.add(scrollPane1);
				scrollPane1.setBounds(10, 90, 570, 390);

			}// end panel 3
			panel1.add(panel3);
			panel3.setBounds(0, 70, 600, 485);
			// ======== panel4 ========
			{

				panel4.setLayout(null);

				// ---- button2 ----
				button3.setText("Print");
				panel4.add(button3);
				button3.setBounds(200, 0, 100, 20);
				button3.addActionListener(this);
			}// end panel 4

			panel1.add(panel4);
			panel4.setBounds(0, 560, 600, 30);
		}// end panel 1

		add(panel1);
		panel1.setBounds(0, 0, 600, 600);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// pack();
		setVisible(true);
		// setLocation(-5, 0);
		setSize(610, 630);

	}

	// this method show all store name
	private void storeName() {
		ArrayList<String> storeNames = (ArrayList<String>) new SpecificFieldValue(
				connection).getAllStoreName();
		for (String name : storeNames) {
			comboBox3.addItem(name);
		}
	}

	private void setYear() {
		comboBox2.addItem("2015");
		comboBox2.addItem("2016");
		comboBox2.addItem("2017");
		comboBox2.addItem("2018");
		comboBox2.addItem("2019");
		comboBox2.addItem("2020");
	}

	private void loadTableData() {
		while (tableModel1.getRowCount() > 0) {
			tableModel1.removeRow(0);
		}
		for (int i = 0; i < productList.size(); i++) {
			ProductModel product = productList.get(i);
			tableModel1.addRow(new Object[]{i + 1, product.getProductCode(),
					product.getProductName(), product.getUnit(),
					product.getMRP(), product.getQuantity()});
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == button1) {
			viewReport();
		}

		if (event.getSource() == button2) {
			reset();
		}

		if (event.getSource() == button3) {
			print();
		}

	}
	private void print() {

	}
	private void reset() {
		comboBox1.setSelectedIndex(0);
		comboBox2.setSelectedIndex(0);
		productList = new ArrayList<>();
		loadTableData();
	}
	private void viewReport() {
		int storeId = new TableId(connection).getStoreId(comboBox3
				.getSelectedItem().toString());

		int month = comboBox1.getSelectedIndex();
		int year = Integer.parseInt(comboBox2.getSelectedItem().toString());

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.set(year, month, 1);
		int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
		String startDate = sdf.format(cal.getTime());
		cal.set(year, month, daysInMonth);
		String endDate = sdf.format(cal.getTime());
		
		productList = new DatabaseReport(connection).getPurchaseReport(startDate, endDate, storeId);
		loadTableData();

	}
	@Override
	public void itemStateChanged(ItemEvent event) {
		if(event.getStateChange()==ItemEvent.SELECTED){
			if(event.getSource()==comboBox3){
				reset();
			}
		}
	}

}
