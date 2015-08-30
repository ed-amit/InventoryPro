/*
 * Created by JFormDesigner on Sun May 31 09:40:57 IST 2015
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

import com.lrd.inventory.database.DatabaseInsert;
import com.lrd.inventory.database.GetDBValue;
import com.lrd.inventory.database.SpecificFieldValue;
import com.lrd.inventory.database.TableId;
import com.lrd.inventory.main.Validate;
import com.lrd.inventory.model.BillDetailModel;
import com.lrd.inventory.model.BillModel;
import com.lrd.inventory.model.BillPaymentModel;

/**
 * @author dharmendra singh
 */
public class DueBillPayment extends JFrame implements ActionListener,ItemListener,KeyListener {


	private static final long serialVersionUID = 1L;
	//  Variables declaration 
	private JPanel panel1;
	private JPanel panel2;
	private JLabel label1;
	private JPanel panel3;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JLabel label5;
	private JScrollPane scrollPane1;
	private DefaultTableModel tableModel1;
	private JTable table1;
	private JLabel label6;
	private JLabel label7;
	private JLabel label8;
	private JLabel label9;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	private JLabel label14;
	private JLabel label10;
	private JPanel panel4;
	private JLabel label11;
	private JComboBox<Object> comboBox1;
	private JLabel label12;
	private JComboBox<String> comboBox2;
	private JTextField textField7;
	private JScrollPane scrollPane2;
	private DefaultTableModel tableModel2;
	private JTable table2;
	private JButton button4;
	private JButton button5;
	private JLabel label13;
	//  End of variables declaration 
	
	int billId;

	Connection connection =null;
	SpecificFieldValue fieldName = null;
	BillDetailModel billDetail = null;
	DatabaseInsert dbinsert = null;
	GetDBValue dbvalue = null;
	TableId tableid = null;
	Validate valid = null;

	ArrayList<BillModel> billList = null;
	ArrayList<BillDetailModel> billDetailList = null;
	ArrayList<BillModel> billTempList = null;


	public DueBillPayment(Connection connection) {
		this.connection= connection;
		this.fieldName = new SpecificFieldValue(this.connection);
		dbinsert = new DatabaseInsert(connection);
		dbvalue = new GetDBValue(connection);
		tableid = new TableId(connection);
		valid = new Validate();
		initComponents();
		storeName();
		billList = dbvalue.getDueBillDetail(tableid.getStoreId(comboBox1.getSelectedItem().toString()));
		System.out.println(billList.size());
	}





	private void initComponents() {


		panel1 = new JPanel();
		panel2 = new JPanel();
		label1 = new JLabel();
		panel3 = new JPanel();
		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		textField1 = new JTextField();
		textField2 = new JTextField();
		textField3 = new JTextField();
		label5 = new JLabel();
		scrollPane1 = new JScrollPane();
		tableModel1 = new DefaultTableModel();
		table1 = new JTable(tableModel1);
		label6 = new JLabel();
		label7 = new JLabel();
		label8 = new JLabel();
		label9 = new JLabel();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		textField4 = new JTextField();
		textField5 = new JTextField();
		textField6 = new JTextField();
		label14 = new JLabel();
		label10 = new JLabel();
		panel4 = new JPanel();
		label11 = new JLabel();
		comboBox1 = new JComboBox<Object>();
		label12 = new JLabel();
		comboBox2 = new JComboBox<>();
		textField7 = new JTextField();
		scrollPane2 = new JScrollPane();
		tableModel2 = new DefaultTableModel();
		table2 = new JTable(tableModel2);
		button4 = new JButton();
		button5 = new JButton();
		label13 = new JLabel();

		//======== this ========
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		//======== panel1 ========
		{

			panel1.setLayout(null);

			//======== panel2 ========
			{
				panel2.setBorder(UIManager.getBorder("TitledBorder.border"));
				panel2.setLayout(null);

				//---- label1 ----
				label1.setText("Due Bill Payment");
				label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 15f));
				panel2.add(label1);
				label1.setBounds(new Rectangle(new Point(395, 20), label1.getPreferredSize()));


			}
			panel1.add(panel2);
			panel2.setBounds(0, 0, 1000, 80);

			//======== panel3 ========
			{
				panel3.setBorder(UIManager.getBorder("TitledBorder.border"));
				panel3.setLayout(null);

				//---- label2 ----
				label2.setText("Bill / Challan No");
				panel3.add(label2);
				label2.setBounds(20,50,100,20);

				panel3.add(textField1);
				textField1.setBounds(125, 50, 100, 20);

				//---- label3 ----
				label3.setText("Customer Name");
				panel3.add(label3);
				label3.setBounds(235, 50 ,100 , 20);

				panel3.add(textField2);
				textField2.setBounds(355, 50, 150, 20);

				//---- label4 ----
				label4.setText("Date");
				panel3.add(label4);
				label4.setBounds(520, 50,50,20);

				panel3.add(textField3);
				textField3.setBounds(555, 50, 70, 20);

				//---- label5 ----
				label5.setText("Product Details");
				panel3.add(label5);
				label5.setBounds(new Rectangle(new Point(20, 100), label5.getPreferredSize()));

				tableModel1.addColumn("Code");
				tableModel1.addColumn("Name");
				tableModel1.addColumn("Quantity");
				tableModel1.addColumn("Unit");
				tableModel1.addColumn("Rate");
				tableModel1.addColumn("Vat %");
				tableModel1.addColumn("Vat Amt");
				tableModel1.addColumn("Discount");
				tableModel1.addColumn("Sub Total");
				//======== scrollPane1 ========
				{
					scrollPane1.setViewportView(table1);
				}
				panel3.add(scrollPane1);
				scrollPane1.setBounds(20, 120, 590, 240);

				//---- label6 ----
				label6.setText("Total Products");
				panel3.add(label6);
				label6.setBounds(new Rectangle(new Point(20, 360), label6.getPreferredSize()));

				//---- label7 ----
				label7.setText("Count");
				label7.setForeground(new Color(0, 0, 204));
				panel3.add(label7);
				label7.setBounds(new Rectangle(new Point(130, 360), label7.getPreferredSize()));

				//---- label8 ----
				label8.setText("Total Amount");
				panel3.add(label8);
				label8.setBounds(170, 390,100,20);

				panel3.add(textField4);
				textField4.setBounds(320, 390, 200, 20);

				//---- label9 ----
				label9.setText("Received Amount");
				panel3.add(label9);
				label9.setBounds(170,420,100,20);

				panel3.add(textField5);
				textField5.setBounds(320, 420, 200, 20);

				//---- label10 ----
				label10.setText("Remaining Amount");
				panel3.add(label10);
				label10.setBounds(170, 450, 110, 20);

				panel3.add(textField6);
				textField6.setBounds(320, 450, 200, 20);

				//---- button1 ----
				button1.setText("Pay Amount");
				panel3.add(button1);
				button1.setBounds(115, 480, 100, 30);
				button1.addActionListener(this);

				//---- button2 ----
				button2.setText("Refresh");
				panel3.add(button2);
				button2.setBounds(265, 480, 100, 30);
				button2.addActionListener(this);

				//---- button3 ----
				button3.setText("Close");
				panel3.add(button3);
				button3.setBounds(410, 480, 100, 30);
				button3.addActionListener(this);





				//---- label14 ----
				label14.setText("Particular Bill / Challan Of Customer");
				label14.setFont(label14.getFont().deriveFont(label14.getFont().getStyle() | Font.BOLD, label14.getFont().getSize() + 5f));
				panel3.add(label14);
				label14.setBounds(new Rectangle(new Point(10, 10), label14.getPreferredSize()));



			}
			panel1.add(panel3);
			panel3.setBounds(360, 90, 630, 520);

			//======== panel4 ========
			{
				panel4.setBorder(UIManager.getBorder("TitledBorder.border"));
				panel4.setLayout(null);

				//---- label11 ----
				label11.setText("Store Name");
				panel4.add(label11);
				label11.setBounds(20,50,100,20);

				panel4.add(comboBox1);
				comboBox1.setBounds(120, 50, 200, 20);

				//---- label12 ----
				label12.setText("Search By");
				panel4.add(label12);
				label12.setBounds(20,80,100,20);

				//---- comboBox2 ----
				comboBox2.addItem("Name");
				comboBox2.addItem("Bill Id");
				comboBox2.addItem("Date");
				//comboBox2.addItem("Batch No");
				panel4.add(comboBox2);
				comboBox2.setBounds(120, 80, 200, 20);

				panel4.add(textField7);
				textField7.setBounds(120, 110, 200, 20);
				textField7.addKeyListener(this);

				tableModel2.addColumn("Name");
				tableModel2.addColumn("Bill No");
				tableModel2.addColumn("Date");
				table2.setRowSelectionAllowed(true);
				//======== scrollPane2 ========
				{
					scrollPane2.setViewportView(table2);
				}
				panel4.add(scrollPane2);
				scrollPane2.setBounds(20, 150, 300, 300);

				//---- button4 ----
				button4.setText("View");
				panel4.add(button4);
				button4.setBounds(45, 470, 100, 30);
				button4.addActionListener(this);

				//---- button5 ----
				button5.setText("Delete");
				panel4.add(button5);
				button5.setBounds(195, 470, 100, 30);

				//---- label13 ----
				label13.setText("Total Bills / Challan Of Customer");
				label13.setFont(label13.getFont().deriveFont(label13.getFont().getStyle() | Font.BOLD, label13.getFont().getSize() + 5f));
				panel4.add(label13);
				label13.setBounds(new Rectangle(new Point(10, 10), label13.getPreferredSize()));


			}
			panel1.add(panel4);
			panel4.setBounds(10, 90, 340, 520);


		}
		contentPane.add(panel1);
		panel1.setBounds(0, 0, 1000, 650);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
		setSize(1000, 660);
	}

	public static void main(String[] args){
		//new DueBillPayment();
	}

	private void storeName(){
		ArrayList<String> storeNames = (ArrayList<String>) fieldName.getAllStoreName();
		for (String name : storeNames){
			comboBox1.addItem(name);
		}
	}


	
	
	private void loadTable1Data(ArrayList<BillDetailModel> billdetails){
		// for removing all existing rows from table
				while (tableModel1.getRowCount()>0) {
					tableModel1.removeRow(0);
				}

				/// inserting new rows to the table

				for(BillDetailModel tempbilldetail : billdetails){
					double subtotal=tempbilldetail.getProductQuantity()*tempbilldetail.getProductRate();
					tableModel1.addRow(new Object[] {tempbilldetail.getProductCode(),tempbilldetail.getProductName(),
							tempbilldetail.getProductQuantity(),tempbilldetail.getProductUnit(),
							tempbilldetail.getProductRate(),tempbilldetail.getVatPercent(),
							tempbilldetail.getVatAmt(),tempbilldetail.getDiscountAmt(),subtotal});
				}
				label7.setText(String.valueOf(billdetails.size()));
	}
	
	
	
	
	//for loading table2 data
	private void loadTable2Data(ArrayList<BillModel> bills){
		// for removing all existing rows from table
		while (tableModel2.getRowCount()>0) {
			tableModel2.removeRow(0);
		}

		/// inserting new rows to the table

		for(BillModel bill : bills){ 
			tableModel2.addRow(new Object[] {bill.getCustomerName(),bill.getBillNo(),bill.getBillDate()});
		}
	}





	@Override
	public void keyPressed(KeyEvent arg0) {	}


	@Override
	public void keyTyped(KeyEvent arg0) {	}



	@Override
	public void keyReleased(KeyEvent event) {
		if(!(event.getKeyChar()==27 || event.getKeyChar()==6)){
			if(event.getSource()==textField7){
				searchMethod();
			}
		}
	}


	private void searchMethod(){
		billTempList = new ArrayList<>();
		String tempStr = textField7.getText();
		if(!(valid.isEmpty(tempStr))){
			if(comboBox2.getSelectedItem().toString()=="Name"){
				for(BillModel tempbill : billList){
					if(tempbill.getCustomerName().contains(tempStr)){
						billTempList.add(tempbill);
					}
				}
			}else if(comboBox2.getSelectedItem().toString()=="Bill Id"){
				tempStr=tempStr.toUpperCase();
				for(BillModel tempbill : billList){
					if(tempbill.getBillNo().contains(tempStr)){
						billTempList.add(tempbill);
					}
				}
			}else if(comboBox2.getSelectedItem().toString()=="Date"){
				for(BillModel tempbill : billList){
					if(tempbill.getBillDate().contains(tempStr)){
						billTempList.add(tempbill);
					}
				}
			}
		}
		loadTable2Data(billTempList);
	}
	
	

	public void insertBillPaymentModel(){
		BillPaymentModel billPay = new BillPaymentModel();
		billPay.setBillId(billId);
		billPay.setPaidAmt(Double.parseDouble(textField6.getText()));
		billPay.setPaymentDate(String.valueOf(Calendar.getInstance().get(Calendar.DATE))+
				"/"+(String.valueOf(Calendar.getInstance().get(Calendar.MONTH)+1))+"/"+
				String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		billPay.setPaymentMode("Cash");
		
		dbinsert.insertBillPayment(billPay);
	}







	@Override
	public void itemStateChanged(ItemEvent event) {

		if(event.getSource()==comboBox1){
			billList=dbvalue.getDueBillDetail(tableid.getStoreId(comboBox1.getSelectedItem().toString()));
		}
	}





	@Override
	public void actionPerformed(ActionEvent event) {
		String temp = event.getActionCommand();

		switch (temp) {
		case "View":
		{
			int selectedBill = table2.getSelectedRow();
			billId=billTempList.get(selectedBill).getBillId();
			billDetailList  = dbvalue.getBillProductDetail(billId);
			loadTable1Data(billDetailList);
			
			textField1.setText(billTempList.get(selectedBill).getBillNo());
			textField2.setText(billTempList.get(selectedBill).getCustomerName());
			textField3.setText(billTempList.get(selectedBill).getBillDate());
			
			double paidAmount = fieldName.getPaidAmount(billId);
			double totalAmount = billTempList.get(selectedBill).getTotalAmt();
			textField4.setText(String.valueOf(totalAmount));
			textField5.setText(String.valueOf(paidAmount));
			textField6.setText(String.valueOf(totalAmount-paidAmount));
			
			
			break;
		}
		case "Pay Amount":
			insertBillPaymentModel();
			
			double totalAmount = Double.parseDouble(textField4.getText());
			double paidAmount = Double.parseDouble(textField5.getText());
			double remAmount = Double.parseDouble(textField6.getText());
			for(BillModel billModel : billList){
				if(billModel.getBillId()==billId && 
						(totalAmount-paidAmount)==remAmount){
					billList.remove(billModel);
				}
			}
			resetLeftPanel();
			searchMethod();
			
			break;
		case "Refresh":
			resetLeftPanel();
			break;
		case "Close":
			this.dispose();
			break;
		default:
		}


	}
	
	
	
	private void resetLeftPanel(){
		billDetailList = new ArrayList<>();
		loadTable1Data(billDetailList);
		label7.setText("0");
		
		textField1.setText("");
		textField2.setText("");
		textField3.setText("");
		textField4.setText("");
		textField5.setText("");
		textField6.setText("");
		
		
	}
}
