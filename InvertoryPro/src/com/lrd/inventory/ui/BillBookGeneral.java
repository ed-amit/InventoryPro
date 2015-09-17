/*
 * Created by JFormDesigner on Mon Jun 01 15:11:14 IST 2015
 */

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
import com.lrd.inventory.database.DatabaseUpdate;
import com.lrd.inventory.database.GetDBValue;
import com.lrd.inventory.database.SpecificFieldValue;
import com.lrd.inventory.database.TableId;
import com.lrd.inventory.main.Validate;
import com.lrd.inventory.main.ValidationMSG;
import com.lrd.inventory.model.SalesBillDetailModel;
import com.lrd.inventory.model.SalesBillModel;

/**
 * @author dharmendra singh
 */
public class BillBookGeneral extends JFrame
		implements
			ActionListener,
			KeyListener,
			ItemListener {

	private static final long serialVersionUID = 1L;
	// Variables declaration
	private JPanel panel1;
	private JPanel panel2;
	private JLabel label1;
	private JPanel panel3;
	private JLabel label2;
	private JComboBox<Object> comboBox1;
	private JLabel label3;
	private JComboBox<Object> comboBox2;
	private JScrollPane scrollPane1;
	private DefaultTableModel tableModel1;
	private JTable table1;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JPanel panel4;
	private JLabel label4;
	private JLabel label6;
	private JLabel label7;
	private JLabel label8;
	private JTextField textField1;
	private JTextField textField2;
	private JScrollPane scrollPane2;
	private JTextArea textArea1;
	private JTextField textField3;
	private JLabel label9;
	private JLabel label10;
	private JLabel label11;
	private JLabel label12;
	private JTextField textField4;
	private JComboBox<Object> comboBox3;
	private JComboBox<Object> comboBox4;
	private JScrollPane scrollPane3;
	private DefaultTableModel tableModel2;
	private JTable table2;
	private JLabel label13;
	private JLabel label14;
	private JLabel label15;
	private JLabel label16;
	private JLabel label17;
	private JLabel label18;
	private JLabel label19;
	private JLabel label20;
	private JTextField textField6;
	private JTextField textField7;
	private JTextField textField8;
	private JTextField textField9;
	private JLabel label21;
	private JScrollPane scrollPane4;
	private JTextArea textArea2;
	private JLabel label22;
	private JTextField textField10;
	private JLabel label23;
	private JTextField textField11;
	private JLabel label24;
	private JTextField textField12;
	private JTextField textField13;
	private JTextField textField14;
	private JTextField textField15;
	private JSeparator separator1;
	private JSeparator separator2;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	private JButton button8;
	private JButton button9;
	// End of variables declaration

	int billId = 0;

	Connection connection = null;
	SpecificFieldValue fieldName = null;
	GetDBValue dbvalue = null;
	TableId tableid = null;
	Validate valid = null;

	ArrayList<SalesBillModel> billList = new ArrayList<>();
	ArrayList<SalesBillModel> tempBillList = new ArrayList<>();
	ArrayList<SalesBillDetailModel> billDetailList = new ArrayList<>();
	SalesBillDetailModel billDetail = null;

	public BillBookGeneral(Connection connection) {
		this.connection = connection;
		this.fieldName = new SpecificFieldValue(this.connection);
		dbvalue = new GetDBValue(connection);
		tableid = new TableId(connection);
		valid = new Validate();
		initComponents();
		storeName();
		billList = dbvalue.getGeneralCustomerBill(tableid.getStoreId(comboBox1
				.getSelectedItem().toString()));
		vatPercent();
		unitName();
	}

	private void initComponents() {

		panel1 = new JPanel();
		panel2 = new JPanel();
		label1 = new JLabel();
		panel3 = new JPanel();
		label2 = new JLabel();
		comboBox1 = new JComboBox<Object>();
		label3 = new JLabel();
		comboBox2 = new JComboBox<Object>();
		scrollPane1 = new JScrollPane();
		tableModel1 = new DefaultTableModel();
		table1 = new JTable(tableModel1);
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		panel4 = new JPanel();
		label4 = new JLabel();
		label6 = new JLabel();
		label7 = new JLabel();
		label8 = new JLabel();
		textField1 = new JTextField();
		textField2 = new JTextField();
		scrollPane2 = new JScrollPane();
		textArea1 = new JTextArea();
		textField3 = new JTextField();
		label9 = new JLabel();
		label10 = new JLabel();
		label11 = new JLabel();
		label12 = new JLabel();
		textField4 = new JTextField();
		comboBox3 = new JComboBox<Object>();
		comboBox4 = new JComboBox<Object>();
		scrollPane3 = new JScrollPane();
		tableModel2 = new DefaultTableModel();
		table2 = new JTable(tableModel2);
		label13 = new JLabel();
		label14 = new JLabel();
		label15 = new JLabel();
		label16 = new JLabel();
		label17 = new JLabel();
		label18 = new JLabel();
		label19 = new JLabel();
		label20 = new JLabel();
		textField6 = new JTextField();
		textField7 = new JTextField();
		textField8 = new JTextField();
		textField9 = new JTextField();
		label21 = new JLabel();
		scrollPane4 = new JScrollPane();
		textArea2 = new JTextArea();
		label22 = new JLabel();
		textField10 = new JTextField();
		label23 = new JLabel();
		textField11 = new JTextField();
		label24 = new JLabel();
		textField12 = new JTextField();
		textField13 = new JTextField();
		textField14 = new JTextField();
		textField15 = new JTextField();
		separator1 = new JSeparator();
		separator2 = new JSeparator();
		button4 = new JButton();
		button5 = new JButton();
		button6 = new JButton();
		button7 = new JButton();
		button8 = new JButton();
		button9 = new JButton();

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
				label1.setText("General Customer Bill Book");
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
				label2.setBounds(10, 10, 100, 20);
				panel3.add(comboBox1);
				comboBox1.setBounds(110, 10, 200, 20);
				comboBox1.addItemListener(this);

				// ---- label3 ----
				label3.setText("Search By");
				panel3.add(label3);
				label3.setBounds(10, 40, 100, 20);
				panel3.add(comboBox2);
				comboBox2.setBounds(110, 40, 100, 20);
				comboBox2.addItem("Name");
				comboBox2.addItem("Bill No");
				comboBox2.addItem("Date");
				comboBox2.addItemListener(this);

				panel3.add(textField15);
				textField15.setBounds(220, 40, 90, 20);
				textField15.addKeyListener(this);

				tableModel1.addColumn("Bill No");
				tableModel1.addColumn("Name");
				tableModel1.addColumn("Date");
				tableModel1.addColumn("Total Amt.");
				// ======== scrollPane1 ========
				{
					scrollPane1.setViewportView(table1);
				}
				panel3.add(scrollPane1);
				scrollPane1.setBounds(10, 70, 350, 415);

				// ---- button1 ----
				button1.setText("Print All");
				panel3.add(button1);
				button1.setBounds(20, 540, 100, 30);
				button1.addActionListener(this);

				// ---- button2 ----
				button2.setText("View");
				panel3.add(button2);
				button2.setBounds(145, 540, 100, 30);
				button2.addActionListener(this);

				// ---- button3 ----
				button3.setText("Delete");
				panel3.add(button3);
				button3.setBounds(270, 540, 100, 30);
				button3.setEnabled(false);
				button3.addActionListener(this);

			}
			panel1.add(panel3);
			panel3.setBounds(10, 70, 400, 605);

			// ======== panel4 ========
			{
				panel4.setLayout(null);

				// ---- label4 ----
				label4.setText("Bill No :");
				panel4.add(label4);
				label4.setBounds(new Rectangle(new Point(15, 10), label4
						.getPreferredSize()));

				panel4.add(textField2);
				textField2.setBounds(80, 10, 150,
						textField2.getPreferredSize().height);

				// ---- label6 ----
				label6.setText("Customer Name");
				panel4.add(label6);
				label6.setBounds(new Rectangle(new Point(240, 10), label6
						.getPreferredSize()));

				panel4.add(textField1);
				textField1.setBounds(350, 10, 150,
						textField1.getPreferredSize().height);

				// ---- label7 ----
				label7.setText("Address");
				panel4.add(label7);
				label7.setBounds(new Rectangle(new Point(15, 40), label7
						.getPreferredSize()));

				// ======== scrollPane2 ========
				{
					scrollPane2.setViewportView(textArea1);
				}
				panel4.add(scrollPane2);
				scrollPane2.setBounds(80, 40, 150, 70);

				// ---- label21 ----
				label21.setText("Narration");
				panel4.add(label21);
				label21.setBounds(new Rectangle(new Point(260, 40), label21
						.getPreferredSize()));

				// ======== scrollPane4 ========
				{
					scrollPane4.setViewportView(textArea2);
				}
				panel4.add(scrollPane4);
				scrollPane4.setBounds(350, 40, 150, 70);

				// ---- label23 ----
				label23.setText("Date");
				panel4.add(label23);
				label23.setBounds(new Rectangle(new Point(550, 10), label23
						.getPreferredSize()));
				panel4.add(textField11);
				textField11.setBounds(600, 10, 100,
						textField11.getPreferredSize().height);

				// ---- label24 ----
				label24.setText("Phone No");
				panel4.add(label24);
				label24.setBounds(new Rectangle(new Point(530, 40), label24
						.getPreferredSize()));

				panel4.add(textField12);
				textField12.setBounds(600, 40, 100,
						textField12.getPreferredSize().height);

				panel4.add(separator1);
				separator1.setBounds(15, 120, 725, 7);

				// ---- label8 ----
				label8.setText("Bank Name");
				panel4.add(label8);
				label8.setBounds(new Rectangle(new Point(15, 130), label8
						.getPreferredSize()));

				panel4.add(textField3);
				textField3.setBounds(100, 130, 200,
						textField3.getPreferredSize().height);

				// ---- label22 ----
				label22.setText("Cheque / Credit No");
				panel4.add(label22);
				label22.setBounds(new Rectangle(new Point(360, 130), label22
						.getPreferredSize()));
				panel4.add(textField10);
				textField10.setBounds(505, 130, 200,
						textField10.getPreferredSize().height);

				panel4.add(separator2);
				separator2.setBounds(15, 160, 725, 7);

				// ---- label9 ----
				label9.setText("Code");
				panel4.add(label9);
				label9.setBounds(new Rectangle(new Point(15, 170), label9
						.getPreferredSize()));

				panel4.add(textField4);
				textField4.setBounds(100, 170, 100, 20);

				// ---- label10 ----
				label10.setText("Unit");
				panel4.add(label10);
				label10.setBounds(new Rectangle(new Point(15, 200), label10
						.getPreferredSize()));

				panel4.add(comboBox3);
				comboBox3.setBounds(100, 200, 100, 20);

				// ---- label11 ----
				label11.setText("Vat");
				panel4.add(label11);
				label11.setBounds(new Rectangle(new Point(15, 230), label11
						.getPreferredSize()));

				panel4.add(comboBox4);
				comboBox4.setBounds(100, 230, 100, 20);

				// ---- label12 ----
				label12.setText("Product Details :");
				panel4.add(label12);
				label12.setBounds(new Rectangle(new Point(15, 260), label12
						.getPreferredSize()));

				// ---- label17 ----
				label17.setText("Product");
				panel4.add(label17);
				label17.setBounds(new Rectangle(new Point(250, 170), label17
						.getPreferredSize()));

				panel4.add(textField6);
				textField6.setBounds(350, 170, 100,
						textField6.getPreferredSize().height);

				// ---- label18 ----
				label18.setText("Quantity");
				panel4.add(label18);
				label18.setBounds(new Rectangle(new Point(250, 200), label18
						.getPreferredSize()));

				panel4.add(textField7);
				textField7.setBounds(350, 200, 100,
						textField7.getPreferredSize().height);

				// ---- label19 ----
				label19.setText("Rate Per Unit");
				panel4.add(label19);
				label19.setBounds(new Rectangle(new Point(250, 230), label19
						.getPreferredSize()));

				panel4.add(textField8);
				textField8.setBounds(350, 230, 100,
						textField8.getPreferredSize().height);

				// ---- label20 ----
				label20.setText("Discount");
				panel4.add(label20);
				label20.setBounds(new Rectangle(new Point(250, 260), label20
						.getPreferredSize()));

				panel4.add(textField9);
				textField9.setBounds(350, 260, 100,
						textField9.getPreferredSize().height);

				tableModel2.addColumn("Code");
				tableModel2.addColumn("Name");
				tableModel2.addColumn("Quantity");
				tableModel2.addColumn("Unit");
				tableModel2.addColumn("Rate");
				tableModel2.addColumn("Vat Amt");
				tableModel2.addColumn("Discount");
				tableModel2.addColumn("Sub Toatl");
				// ======== scrollPane3 ========
				{
					scrollPane3.setViewportView(table2);
				}
				panel4.add(scrollPane3);
				scrollPane3.setBounds(15, 290, 695, 200);

				// ---- label13 ----
				label13.setText("Total Product");
				panel4.add(label13);
				label13.setBounds(new Rectangle(new Point(15, 500), label13
						.getPreferredSize()));

				// ---- label14 ----
				label14.setText("0");
				label14.setForeground(new Color(0, 0, 204));
				panel4.add(label14);
				label14.setBounds(new Rectangle(new Point(115, 500), label14
						.getPreferredSize()));

				// ---- label15 ----
				label15.setText("Discount");
				panel4.add(label15);
				label15.setBounds(new Rectangle(new Point(350, 500), label15
						.getPreferredSize()));

				panel4.add(textField13);
				textField13.setBounds(425, 500, 105,
						textField13.getPreferredSize().height);

				// ---- label16 ----
				label16.setText("Vat (%)");
				panel4.add(label16);
				label16.setBounds(new Rectangle(new Point(580, 500), label16
						.getPreferredSize()));

				panel4.add(textField14);
				textField14.setBounds(635, 500, 70,
						textField14.getPreferredSize().height);

				// ---- button4 ----
				button4.setText("Edit");
				panel4.add(button4);
				button4.setBounds(30, 540, 100, 30);
				button4.addActionListener(this);

				// ---- button5 ----
				button5.setText("Print");
				panel4.add(button5);
				button5.setBounds(150, 540, 100, 30);
				button5.addActionListener(this);

				// ---- button6 ----
				button6.setText("Save");
				panel4.add(button6);
				button6.setBounds(275, 540, 100, 30);
				button6.addActionListener(this);

				// ---- button7 ----
				button7.setText("SaveAs Pdf");
				panel4.add(button7);
				button7.setBounds(400, 540, 100, 30);
				button7.addActionListener(this);

				// ---- button8 ----
				button8.setText("Delete");
				panel4.add(button8);
				button8.setBounds(520, 540, 100, 30);
				button8.addActionListener(this);

				// ---- button9 ----
				button9.setText("Refresh");
				panel4.add(button9);
				button9.setBounds(635, 540, 100, 30);
				button9.addActionListener(this);

			}
			panel1.add(panel4);
			panel4.setBounds(410, 70, 750, 615);

		}
		contentPane.add(panel1);
		panel1.setBounds(0, 0, 1160, 680);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
		setSize(1180, 700);
	}

	private void storeName() {
		ArrayList<String> storeNames = (ArrayList<String>) fieldName
				.getAllStoreName();
		for (String name : storeNames) {
			comboBox1.addItem(name);
		}
	}
	
	private void vatPercent(){
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		ArrayList<Float> vatList = (ArrayList<Float>) fieldName.getVatByStartYear(currentYear);
		for (Float vat : vatList) {
			comboBox4.addItem(String.valueOf(vat));
		}
	}
	
	private void unitName(){
		ArrayList<String> unitNames = (ArrayList<String>) fieldName
				.getUnitName();
		for (String unitname : unitNames) {
			comboBox3.addItem(unitname);
		}
	}

	// for loading table1 data
	private void loadTable1Data(ArrayList<SalesBillModel> bills) {
		// for removing all existing rows from table
		while (tableModel1.getRowCount() > 0) {
			tableModel1.removeRow(0);
		}

		// / inserting new rows to the table

		for (SalesBillModel bill : bills) {
			tableModel1.addRow(new Object[]{bill.getCustomerName(),
					bill.getBillNo(), bill.getBillDate(), bill.getTotalAmt()});
		}
	}

	private void loadTable2Data(ArrayList<SalesBillDetailModel> billdetails) {
		// for removing all existing rows from table
		while (tableModel2.getRowCount() > 0) {
			tableModel2.removeRow(0);
		}

		// / inserting new rows to the table

		for (SalesBillDetailModel tempbilldetail : billdetails) {
			double subtotal = (tempbilldetail.getProductQuantity() * tempbilldetail
					.getProductRate())
					+ tempbilldetail.getVatAmt()
					- tempbilldetail.getDiscountAmt();
			tableModel2.addRow(new Object[]{tempbilldetail.getProductCode(),
					tempbilldetail.getProductName(),
					tempbilldetail.getProductQuantity(),
					tempbilldetail.getProductUnit(),
					tempbilldetail.getProductRate(),
					tempbilldetail.getVatAmt(),
					tempbilldetail.getDiscountAmt(), subtotal});
		}
		label14.setText(String.valueOf(billdetails.size()));
	}

	@Override
	public void itemStateChanged(ItemEvent event) {
		if (event.getSource() == comboBox1) {
			billList = dbvalue.getGeneralCustomerBill(tableid
					.getStoreId(comboBox1.getSelectedItem().toString()));
		}

		if (event.getSource() == comboBox2) {
			textField15.setText("");

		}
		searchMethod();

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent event) {
		if (!(event.getKeyChar() == 27 || event.getKeyChar() == 6)) {
			if (event.getSource() == textField15) {
				searchMethod();
			}
		}

	}

	private void searchMethod() {
		tempBillList = new ArrayList<>();
		String tempStr = textField15.getText();

		if (!(valid.isEmpty(tempStr))) {
			if (comboBox2.getSelectedItem().toString() == "Name") {
				for (SalesBillModel tempbill : billList) {
					if (tempbill.getCustomerName().contains(tempStr)) {

						tempBillList.add(tempbill);
					}
				}
			} else if (comboBox2.getSelectedItem().toString() == "Bill No") {
				tempStr = tempStr.toUpperCase();
				for (SalesBillModel tempbill : billList) {
					if (tempbill.getBillNo().contains(tempStr)) {
						tempBillList.add(tempbill);
					}
				}
			} else if (comboBox2.getSelectedItem().toString() == "Date") {
				for (SalesBillModel tempbill : billList) {
					if (tempbill.getBillDate().contains(tempStr)) {
						tempBillList.add(tempbill);
					}
				}
			}
		}
		loadTable1Data(tempBillList);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String tempStr = event.getActionCommand();

		switch (tempStr) {
			case "Print All" :
				printGeneralCustomer();
				break;
			case "View" :
				viewBillDetail();
				break;
			case "Edit" :
				editBillDetail();
				break;
			case "Print" :
				printBill();
				break;
			case "Save" :
				saveBill();
				break;
			case "SaveAs Pdf" :
				saveBillAsPDF();
				break;
			case "Delete" :
				deleteProductFromBill();
				break;
			case "Refresh" :
				refresh();
				break;

		}

	}

	private void refresh() {
		// TODO Auto-generated method stub
		reset();
	}

	private void deleteProductFromBill() {
		// TODO Auto-generated method stub
		boolean status = true;

		if (table2.getSelectedRowCount() != 1) {
			status = false;
			new ValidationMSG(this, "Please Select A Row from Table Then Click");
		}

		if (status) {
			SalesBillModel bill = billList.get(table1.getSelectedRow());
			SalesBillDetailModel billDetail = billDetailList.get(table2.getSelectedRow());
			double subtotal = (billDetail.getProductQuantity() * billDetail
					.getProductRate())
					+ billDetail.getVatAmt()
					- billDetail.getDiscountAmt();
			
			bill.setTotalAmt(bill.getTotalAmt()-subtotal);
			new DatabaseUpdate(connection).updateSalesBillAmount(bill);
			new DatabaseDelete(connection).deleteProductFromSaleBill(billDetail.getBillDetailId());
			billDetailList.remove(table2.getSelectedRow());
			loadTable2Data(billDetailList);
		}
	}

	private void saveBillAsPDF() {
		// TODO Auto-generated method stub
		/*********************************************************************************/
	}

	private void saveBill() {
		// TODO Auto-generated method stub
		boolean status=true;
		if(billDetail==null){
			status=false;
			new ValidationMSG(this, "Please Select A Row from Table Then Click on View to Update Rack Details");
		}else if( comboBox3.getSelectedIndex()<0){
			status=false;
			new ValidationMSG(this, "Please Select Unit Name");
		}else if( comboBox4.getSelectedIndex()<0){
			status=false;
			new ValidationMSG(this, "Please Select vat Rate");
		}else if( valid.isEmpty(textField7.getText())){
			status=false;
			new ValidationMSG(this, "Please Insert Quantity");
		}
		
		if (status) {
			billDetail.setProductQuantity(Double.parseDouble(textField7.getText()));
			billDetail.setVatPercent(Double.parseDouble(comboBox4.getSelectedItem().toString()));
			billDetail.setProductUnit(comboBox3.getSelectedItem().toString());
			billDetail.setDiscountAmt(Double.parseDouble(textField9.getText()));
			double mrp,vatPercent,vatAmt,discountPer,discountAmt,rate;
			mrp=billDetail.getMrp();
			vatPercent=billDetail.getVatPercent();
			vatAmt=mrp*(vatPercent/100);
			discountAmt=billDetail.getDiscountAmt();
			discountPer=(discountAmt*100)/mrp;
			rate=mrp-discountAmt+vatAmt;
			billDetail.setVatAmt(vatAmt);
			billDetail.setDiscountPercent(discountPer);
			billDetail.setProductRate(rate);
			
			new DatabaseUpdate(connection).updateSalesBillProduct(billDetail);
			reset();
			billDetail=null;
		}
	}

	private void printBill() {
		// TODO Auto-generated method stub
		/************************************************************************/
	}

	private void editBillDetail() {
		// TODO Auto-generated method stub
		boolean status = true;

		if (table2.getSelectedRowCount() != 1) {
			status = false;
			new ValidationMSG(this, "Please Select A Row from Table Then Click");
		}

		if (status) {
			resetProductPanel();
			billDetail = billDetailList.get(table2.getSelectedRow());
			textField4.setText(billDetail.getProductCode());
			//comboBox3.removeAllItems();
			comboBox3.addItem(billDetail.getProductUnit());
			//comboBox4.addItem("0.0");
			comboBox4.setSelectedItem(String.valueOf(billDetail.getVatPercent()));
			textField6.setText(billDetail.getProductName());
			textField7.setText(String.valueOf(billDetail.getProductQuantity()));
			textField8.setText(String.valueOf(billDetail.getProductRate()));
			textField9.setText(String.valueOf(billDetail.getDiscountAmt()));
		}
	}

	private void viewBillDetail() {
		// TODO Auto-generated method stub
		boolean status = true;

		if (table1.getSelectedRowCount() < 1) {
			status = false;
			new ValidationMSG(this, "Please Select A Row from Table Then Click");
		}

		if (status) {
			//reset();
			resetProductPanel();
			int selectedBill = table1.getSelectedRow();
			billId = tempBillList.get(table1.getSelectedRow()).getBillId();
			billDetailList = dbvalue.getBillProductDetail(billId);
			loadTable2Data(billDetailList);

			textField2.setText(tempBillList.get(selectedBill).getBillNo());
			textField1
					.setText(tempBillList.get(selectedBill).getCustomerName());
			textField11.setText(tempBillList.get(selectedBill).getBillDate());
			textField12.setText(tempBillList.get(selectedBill).getMobileNo());
			textArea1.setText(tempBillList.get(selectedBill)
					.getCustomerAddress());
			textArea2.setText(tempBillList.get(selectedBill).getNarration());
			textField13.setText(String.valueOf(tempBillList.get(selectedBill)
					.getDiscount()));
			textField14.setText(String.valueOf(tempBillList.get(selectedBill)
					.getVatPercent()));
			
		}
	}

	private void printGeneralCustomer() {
		// TODO Auto-generated method stub
		/************************************************************************/
	}

	private void reset() {
		billDetailList = new ArrayList<>();
		loadTable2Data(billDetailList);
		textField2.setText("");
		textField1.setText("");
		textField11.setText("");
		textField12.setText("");
		textArea1.setText("");
		textArea2.setText("");
		textField13.setText("");
		textField14.setText("");
	}
	
	private void resetProductPanel(){
		textField4.setText("");
		textField6.setText("");
		textField7.setText("");
		textField8.setText("");
		textField9.setText("");
		comboBox3.setSelectedIndex(0);
		comboBox4.setSelectedIndex(0);
	}
}
