/*
 * Created by JFormDesigner on Mon Jun 01 22:31:06 IST 2015
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
import com.lrd.inventory.model.ChallanDetailModel;
import com.lrd.inventory.model.ChallanModel;

/**
 * @author dharmendra singh
 */
public class BillBookChallan extends JFrame
		implements
			ActionListener,
			ItemListener {

	private static final long serialVersionUID = 1L;
	// Variables declaration
	private JPanel panel1;
	private JPanel panel2;
	private JLabel label1;
	private JPanel panel3;
	private JLabel label2;
	private JComboBox<Object> comboBox1;
	private JScrollPane scrollPane1;
	private DefaultTableModel tableModel1;
	private JTable table1;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JLabel label3;
	private JPanel panel4;
	private JLabel label4;
	private JLabel label6;
	private JLabel label7;
	private JTextField textField1;
	private JTextField textField2;
	private JScrollPane scrollPane2;
	private JTextArea textArea1;
	private JLabel label12;
	private JScrollPane scrollPane3;
	private DefaultTableModel tableModel2;
	private JTable table2;
	private JLabel label13;
	private JLabel label14;
	private JLabel label15;
	private JLabel label16;
	private JLabel label21;
	private JScrollPane scrollPane4;
	private JTextArea textArea2;
	private JLabel label23;
	private JTextField textField11;
	private JLabel label24;
	private JTextField textField12;
	private JTextField textField13;
	private JTextField textField14;
	private JSeparator separator1;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	// End of variables declaration

	Connection connection = null;
	SpecificFieldValue fieldName = null;
	GetDBValue dbvalue = null;
	TableId tableid = null;

	ArrayList<ChallanModel> challanList = new ArrayList<>();
	ArrayList<ChallanDetailModel> challanDetailList = new ArrayList<>();

	public BillBookChallan(Connection connection) {
		this.connection = connection;
		fieldName = new SpecificFieldValue(connection);
		dbvalue = new GetDBValue(connection);
		tableid = new TableId(connection);
		initComponents();
		storeName();
		challanList = dbvalue.getChallanDetail(tableid.getStoreId(comboBox1
				.getSelectedItem().toString()));
		loadTable1Data();
	}

	private void initComponents() {

		panel1 = new JPanel();
		panel2 = new JPanel();
		label1 = new JLabel();
		panel3 = new JPanel();
		label2 = new JLabel();
		comboBox1 = new JComboBox<Object>();
		scrollPane1 = new JScrollPane();
		tableModel1 = new DefaultTableModel();
		table1 = new JTable(tableModel1);
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		label3 = new JLabel();
		panel4 = new JPanel();
		label4 = new JLabel();
		label6 = new JLabel();
		label7 = new JLabel();
		textField1 = new JTextField();
		textField2 = new JTextField();
		scrollPane2 = new JScrollPane();
		textArea1 = new JTextArea();
		label12 = new JLabel();
		scrollPane3 = new JScrollPane();
		tableModel2 = new DefaultTableModel();
		table2 = new JTable(tableModel2);
		label13 = new JLabel();
		label14 = new JLabel();
		label15 = new JLabel();
		label16 = new JLabel();
		label21 = new JLabel();
		scrollPane4 = new JScrollPane();
		textArea2 = new JTextArea();
		label23 = new JLabel();
		textField11 = new JTextField();
		label24 = new JLabel();
		textField12 = new JTextField();
		textField13 = new JTextField();
		textField14 = new JTextField();
		separator1 = new JSeparator();
		button5 = new JButton();
		button6 = new JButton();
		button7 = new JButton();

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
				label1.setText("Challan Bill Book");
				label1.setFont(label1.getFont().deriveFont(
						label1.getFont().getSize() + 15f));
				panel2.add(label1);
				label1.setBounds(new Rectangle(new Point(410, 15), label1
						.getPreferredSize()));

			}
			panel1.add(panel2);
			panel2.setBounds(0, 0, 1160, 60);

			// ======== panel3 ========
			{
				panel3.setLayout(null);

				// ---- label2 ----
				label2.setText("Select Store");
				panel3.add(label2);
				label2.setBounds(new Rectangle(new Point(25, 70), label2
						.getPreferredSize()));
				panel3.add(comboBox1);
				comboBox1.setBounds(165, 70, 200,
						comboBox1.getPreferredSize().height);
				comboBox1.addItemListener(this);

				tableModel1.addColumn("No");
				tableModel1.addColumn("Name");
				tableModel1.addColumn("Date");
				tableModel1.addColumn("Total Amount");
				// ======== scrollPane1 ========
				{
					scrollPane1.setViewportView(table1);
				}
				panel3.add(scrollPane1);
				scrollPane1.setBounds(20, 105, 350, 415);

				// ---- button1 ----
				button1.setText("Print");
				panel3.add(button1);
				button1.setBounds(20, 540, 100, 40);
				button1.addActionListener(this);

				// ---- button2 ----
				button2.setText("View");
				panel3.add(button2);
				button2.setBounds(145, 540, 100, 40);
				button2.addActionListener(this);

				// ---- button3 ----
				button3.setText("Delete");
				panel3.add(button3);
				button3.setBounds(270, 540, 100, 40);
				button3.addActionListener(this);
				button3.setEnabled(false);

				// ---- label3 ----
				label3.setText("Total challan Of Customers");
				panel3.add(label3);
				label3.setBounds(new Rectangle(new Point(25, 20), label3
						.getPreferredSize()));

			}
			panel1.add(panel3);
			panel3.setBounds(10, 75, 400, 605);

			// ======== panel4 ========
			{
				panel4.setLayout(null);

				// ---- label4 ----
				label4.setText("Challan No");
				panel4.add(label4);
				label4.setBounds(new Rectangle(new Point(15, 50), label4
						.getPreferredSize()));

				panel4.add(textField2);
				textField2.setBounds(90, 50, 150,
						textField2.getPreferredSize().height);

				// ---- label6 ----
				label6.setText("Customer Name");
				panel4.add(label6);
				label6.setBounds(new Rectangle(new Point(240, 50), label6
						.getPreferredSize()));

				panel4.add(textField1);
				textField1.setBounds(350, 50, 150,
						textField1.getPreferredSize().height);

				// ---- label7 ----
				label7.setText("Address");
				panel4.add(label7);
				label7.setBounds(new Rectangle(new Point(15, 90), label7
						.getPreferredSize()));

				// ======== scrollPane2 ========
				{
					scrollPane2.setViewportView(textArea1);
				}
				panel4.add(scrollPane2);
				scrollPane2.setBounds(90, 90, 150, 70);

				// ---- label12 ----
				label12.setText("Product Details :");
				panel4.add(label12);
				label12.setBounds(new Rectangle(new Point(15, 180), label12
						.getPreferredSize()));

				tableModel2.addColumn("Code");
				tableModel2.addColumn("Product");
				tableModel2.addColumn("Qty");
				tableModel2.addColumn("Unit");
				tableModel2.addColumn("Vate %");
				tableModel2.addColumn("Discount");
				tableModel2.addColumn("Rate");
				tableModel2.addColumn("Sub Toatl");
				// ======== scrollPane3 ========
				{
					scrollPane3.setViewportView(table2);
				}
				panel4.add(scrollPane3);
				scrollPane3.setBounds(15, 210, 695, 308);

				// ---- label13 ----
				label13.setText("Total Product");
				panel4.add(label13);
				label13.setBounds(new Rectangle(new Point(15, 520), label13
						.getPreferredSize()));

				// ---- label14 ----
				label14.setText("0");
				label14.setForeground(new Color(0, 0, 204));
				panel4.add(label14);
				label14.setBounds(new Rectangle(new Point(115, 520), label14
						.getPreferredSize()));

				// ---- label15 ----
				label15.setText("Discount");
				panel4.add(label15);
				label15.setBounds(new Rectangle(new Point(350, 520), label15
						.getPreferredSize()));

				panel4.add(textField13);
				textField13.setBounds(425, 520, 105,
						textField13.getPreferredSize().height);

				// ---- label16 ----
				label16.setText("Vat (%)");
				panel4.add(label16);
				label16.setBounds(new Rectangle(new Point(580, 520), label16
						.getPreferredSize()));

				panel4.add(textField14);
				textField14.setBounds(635, 520, 70,
						textField14.getPreferredSize().height);

				// ---- label21 ----
				label21.setText("Narration");
				panel4.add(label21);
				label21.setBounds(new Rectangle(new Point(260, 90), label21
						.getPreferredSize()));

				// ======== scrollPane4 ========
				{
					scrollPane4.setViewportView(textArea2);
				}
				panel4.add(scrollPane4);
				scrollPane4.setBounds(350, 90, 150, 70);

				// ---- label23 ----
				label23.setText("Date");
				panel4.add(label23);
				label23.setBounds(new Rectangle(new Point(550, 50), label23
						.getPreferredSize()));
				panel4.add(textField11);
				textField11.setBounds(600, 50, 100,
						textField11.getPreferredSize().height);

				// ---- label24 ----
				label24.setText("Phone No");
				panel4.add(label24);
				label24.setBounds(new Rectangle(new Point(530, 90), label24
						.getPreferredSize()));
				panel4.add(textField12);
				textField12.setBounds(600, 90, 100,
						textField12.getPreferredSize().height);

				panel4.add(separator1);
				separator1.setBounds(15, 160, 725, 7);

				// ---- button5 ----
				button5.setText("Print");
				panel4.add(button5);
				button5.setBounds(150, 560, 100, 40);
				button5.addActionListener(this);

				// ---- button6 ----
				button6.setText("Refresh");
				panel4.add(button6);
				button6.setBounds(275, 560, 100, 40);
				button6.addActionListener(this);

				// ---- button7 ----
				button7.setText("Other Charges");
				panel4.add(button7);
				button7.setBounds(400, 560, 100, 40);
				button7.addActionListener(this);

			}
			panel1.add(panel4);
			panel4.setBounds(410, 75, 750, 615);

		}
		contentPane.add(panel1);
		panel1.setBounds(0, 0, 1160, 690);

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

		// / inserting new rows to the table
		for (ChallanModel challan : challanList) {
			tableModel1.addRow(new Object[]{challan.getchallanNo(),
					challan.getCustomerName(), challan.getChallanDate(),
					challan.getTotalAmt()});
		}
	}

	private void loadTable2Data() {
		while (tableModel2.getRowCount() > 0) {
			tableModel2.removeRow(0);
		}

		for (ChallanDetailModel challanDetail : challanDetailList) {
			double subTotal = challanDetail.getProductQuantity()
					* challanDetail.getProductRate();
			tableModel2.addRow(new Object[]{challanDetail.getProductCode(),
					challanDetail.getProductName(),
					challanDetail.getProductQuantity(),
					challanDetail.getProductUnit(),
					challanDetail.getVatPercent(),
					challanDetail.getDiscountAmt(),
					challanDetail.getProductRate(), subTotal});
		}
	}

	@Override
	public void itemStateChanged(ItemEvent event) {
		if (event.getSource() == comboBox1) {
			resetAll();
		}

	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == button1) {

		}

		if (event.getSource() == button2) {
			int selectedChallan = table1.getSelectedRow();
			int challanId = challanList.get(selectedChallan).getChallanId();
			challanDetailList = dbvalue.getChallanProductDetail(challanId);
			loadTable2Data();
			textField1.setText(challanList.get(selectedChallan)
					.getCustomerName());
			textField2.setText(challanList.get(selectedChallan).getchallanNo());
			textField11.setText(challanList.get(selectedChallan)
					.getChallanDate());
			textField12.setText(challanList.get(selectedChallan).getMobileNo());
			textField13.setText(String.valueOf(challanList.get(selectedChallan)
					.getDiscount()));
			textField14.setText(String.valueOf(challanList.get(selectedChallan)
					.getVatPercent()));
			textArea1.setText(challanList.get(selectedChallan)
					.getCustomerAddress());
			textArea2.setText(challanList.get(selectedChallan).getNarration());
			label14.setText(String.valueOf(challanDetailList.size()));
		}

		if (event.getSource() == button3) {

		}

		if (event.getSource() == button5) {

		}

		if (event.getSource() == button6) {
			resetAll();
		}

		if (event.getSource() == button7) {

		}

	}

	private void resetAll() {
		// TODO Auto-generated method stub
		challanList = dbvalue.getChallanDetail(tableid.getStoreId(comboBox1
				.getSelectedItem().toString()));
		loadTable1Data();

		textField1.setText("");
		textField2.setText("");
		textField11.setText("");
		textField12.setText("");
		textField13.setText("");
		textField14.setText("");
		textArea1.setText("");
		textArea2.setText("");
		label14.setText("0");

		while (tableModel2.getRowCount() > 0) {
			tableModel2.removeRow(0);
		}
	}
}
