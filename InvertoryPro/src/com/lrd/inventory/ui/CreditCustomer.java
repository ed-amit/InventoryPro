
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
import com.lrd.inventory.model.CreditorModel;

/**
 * @author dharmendra singh
 */
public class CreditCustomer extends JFrame implements ActionListener , ItemListener{

	private static final long serialVersionUID = 1L;

	//  Variables declaration 
	private JLabel label1;
	private JLabel label2;
	private JPanel panel1;
	private JComboBox<Object> comboBox1;
	private JTextField textField1;
	private JButton button3;
	private JButton button4;
	private JLabel label5;
	private JScrollPane scrollPane1;
	private DefaultTableModel tableModel;
	private JTable table1;
	private JSeparator separator1;
	private JLabel label4;
	private JLabel label6;
	private JLabel label7;
	private JLabel label8;
	private JButton button1;
	private JButton button2;
	private JButton button5;
	private JButton button6;
	private JLabel label9;
	private JScrollPane scrollPane2;
	private JTextArea textArea1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	//  End of variables declaration 

	Connection connection=null;
	SpecificFieldValue fieldName = null;
	TableId tableid = null;
	
	CreditorModel creditor = null;
	Validate valid= null;
	GetDBValue dbValue = null;
	ArrayList<CreditorModel> creditorList = null;

	public CreditCustomer(Connection connection) {
		this.connection=connection;
		this.fieldName = new SpecificFieldValue(this.connection);
		tableid = new TableId(this.connection);
		
		dbValue = new GetDBValue(connection);
		creditor = new CreditorModel();
		valid = new Validate();
		initComponents();
		storeName();
		loadTableData();
	}

	private void initComponents() {
		
		label1 = new JLabel();
		label2 = new JLabel();
		panel1 = new JPanel();
		comboBox1 = new JComboBox<Object>();
		textField1 = new JTextField();
		button3 = new JButton();
		button4 = new JButton();
		label5 = new JLabel();
		scrollPane1 = new JScrollPane();
		tableModel = new DefaultTableModel();
		table1 = new JTable(tableModel);
		separator1 = new JSeparator();
		label4 = new JLabel();
		label6 = new JLabel();
		label7 = new JLabel();
		label8 = new JLabel();
		button1 = new JButton();
		button2 = new JButton();
		button5 = new JButton();
		button6 = new JButton();
		label9 = new JLabel();
		scrollPane2 = new JScrollPane();
		textArea1 = new JTextArea();
		textField2 = new JTextField();
		textField3 = new JTextField();
		textField4 = new JTextField();
		textField5 = new JTextField();

		//======== this ========
		Container contentPane = getContentPane();
		contentPane.setLayout(null);


		// ======== panel1 ========
		{
			panel1.setLayout(null);

			//---- label5 ----
			label5.setText("Add New Credit Customer");
			panel1.add(label5);
			label5.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 30));
			label5.setBounds(100, 10, 400, 50);
			
			panel1.add(separator1);
			separator1.setBounds(0, 100, 600, 5);



			//---- label1 ----
			label1.setText("Store Name");
			panel1.add(label1);
			label1.setBounds(30, 120, 100, 20);
			
			panel1.add(comboBox1);
			comboBox1.setBounds(150, 120, 150, 20);
			comboBox1.addItemListener(this);
			
			//---- label2 ----
			label2.setText("<html>Customer Name <font color='red'><b>*</b></font></html>");
			panel1.add(label2);
			label2.setBounds(30, 150, 100, 20);
			
			panel1.add(textField1);
			textField1.setBounds(150, 150, 150, 20);
			
			//---- label4 ----
			label4.setText("<html>Address <font color='red'><b>*</b></font></html>");
			panel1.add(label4);
			label4.setBounds(30, 180, 100, 20);

			//======== scrollPane2 ========
			{
				scrollPane2.setViewportView(textArea1);
			}
			panel1.add(scrollPane2);
			scrollPane2.setBounds(150, 180, 150, 50);
			
			
			//---- label6 ----
			label6.setText("<html>Contact No <font color='red'><b>*</b></font></html>");
			panel1.add(label6);
			label6.setBounds(30, 240, 100, 20);
			
			panel1.add(textField2);
			textField2.setBounds(150, 240, 150, 20);
			
			//---- label7 ----
			label7.setText("Credit Balance");
			panel1.add(label7);
			label7.setBounds(30, 270, 100, 20);
			
			panel1.add(textField3);
			textField3.setBounds(150, 270, 150, 20);
			textField3.setText("0");


			//---- label8 ----
			label8.setText("Debit Balance");
			panel1.add(label8);
			label8.setBounds(30, 310, 100, 20);
			
			panel1.add(textField4);
			textField4.setBounds(150, 310, 150, 20);
			textField4.setText("0");
			textField4.setEnabled(false);
			
			
			//---- label9 ----
			label9.setText("<html>Credit Limit <font color='red'><b>*</b></font></html>");
			panel1.add(label9);
			label9.setBounds(30, 340, 100, 20);
			
			panel1.add(textField5);
			textField5.setBounds(150, 340, 150, 20);
			textField5.setText("0");
			
			
			tableModel.addColumn("Sr.");
			tableModel.addColumn("Customer Name");
			//======== scrollPane1 ========
			{
				scrollPane1.setViewportView(table1);
			}
			panel1.add(scrollPane1);
			scrollPane1.setBounds(330, 120, 230, 240);
			

			//---- button1 ----
			button1.setText("Update");
			panel1.add(button1);
			button1.setBounds(30, 400, 80, 30);
			button1.addActionListener(this);

			//---- button2 ----
			button2.setText("Save");
			panel1.add(button2);
			button2.setBounds(145, 400, 80, 30);
			button2.addActionListener(this);
			
			//---- button3 ----
			button3.setText("Refresh");
			panel1.add(button3);
			button3.setBounds(260, 400, 80, 30);
			button3.addActionListener(this);
			
			//---- button4 ----
			button4.setText("View");
			panel1.add(button4);
			button4.setBounds(375, 400, 80, 30);
			button4.addActionListener(this);

			//---- button5 ----
			button5.setText("Delete");
			panel1.add(button5);
			button5.setBounds(490, 400, 80, 30);
			button5.addActionListener(this);
			
			//---- button6 ----
			button6.setText("Close");
			panel1.add(button6);
			button6.setBounds(610, 400, 80, 30);
			button6.addActionListener(this);
		}
		contentPane.add(panel1);
		panel1.setBounds(0, 0, 600, 500);


		pack();
		setVisible(true);
		setLocation(200, 10);
		setSize(600, 500);
	}

	private void storeName(){
		ArrayList<String> storeNames = (ArrayList<String>) fieldName.getAllStoreName();
		for (String name : storeNames){
			comboBox1.addItem(name);
		}
	}
	
	
	public void loadTableData(){
		
		while(tableModel.getRowCount()>0)
		{
			tableModel.removeRow(0);
		}
		
		creditorList = dbValue.getCreditorDetail(tableid.getStoreId(comboBox1.getSelectedItem().toString()));
		//System.out.println(creditorList.size());
		for( int i=0; i<creditorList.size() ; i++){
			creditor = creditorList.get(i);
			tableModel.addRow(new Object[] {(i+1),creditor.getName()});
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
	
	
	
	private void save(){
		boolean status=true;
		if( valid.isEmpty(textField1.getText())){
			status=false;
			new ValidationMSG(this, "Please Insert Customer Name");
		}else if( valid.isEmpty(textArea1.getText())){
			status=false;
			new ValidationMSG(this, "Please Insert Customer Address");
		}else if(valid.isEmpty(textField2.getText())){
			status=false;
			new ValidationMSG(this, "Please Insert Contact No");
		}else if(valid.isEmpty(textField5.getText()) || textField5.getText()=="0"){
			status=false;
			new ValidationMSG(this, "Please Insert Credit Limit");
		}
		
		
		if( status){
			CreditorModel creditor = new CreditorModel();
			creditor.setId(0);
			creditor.setName(textField1.getText());
			creditor.setAddress(textArea1.getText());
			creditor.setContactNo(textField2.getText());
			creditor.setCreditAmt(Double.parseDouble(textField3.getText()));
			creditor.setDebitAmt(Double.parseDouble(textField4.getText()));
			creditor.setCreditLimit(Double.parseDouble(textField5.getText()));
			creditor.setFirmId(1);
			creditor.setStoreId(tableid.getStoreId(comboBox1.getSelectedItem().toString()));
			new DatabaseInsert(this.connection).insertCreditor(creditor);
			creditor.setDefault();
			loadTableData();
		}
	}
	
	private void reFresh(){
		reset();
	}

	private void view(){
		boolean status=true;
		if(table1.getSelectedRowCount()!=1){
			status=false;
			new ValidationMSG(this, "Please Select A Row from Table Then Click");
		}
		
		
		if(status){
			creditor = creditorList.get(table1.getSelectedRow());
			textField1.setText(creditor.getName());
			textArea1.setText(creditor.getAddress());
			textField2.setText(creditor.getContactNo());
			textField3.setText(String.valueOf(creditor.getCreditAmt()));
			textField4.setText(String.valueOf(creditor.getDebitAmt()));
			textField5.setText(String.valueOf(creditor.getCreditLimit()));
			
		}
	}

	private void update(){
		boolean status=true;
		if(creditor==null){
			status=false;
			new ValidationMSG(this, "Please Select A Row from Table Then Click on View to Update Rack Details");
		}else if( valid.isEmpty(textField1.getText())){
			status=false;
			new ValidationMSG(this, "Please Insert Customer Name");
		}else if( valid.isEmpty(textArea1.getText())){
			status=false;
			new ValidationMSG(this, "Please Insert Customer Address");
		}else if(valid.isEmpty(textField2.getText())){
			status=false;
			new ValidationMSG(this, "Please Insert Contact No");
		}else if(valid.isEmpty(textField5.getText()) || textField5.getText()=="0"){
			status=false;
			new ValidationMSG(this, "Please Insert Credit Limit");
		}
		
		if( status){
			creditor.setName(textField1.getText());
			creditor.setAddress(textArea1.getText());
			creditor.setContactNo(textField2.getText());
			if(valid.isEmpty(textField2.getText()))
				creditor.setCreditAmt(Double.parseDouble(textField3.getText()));
			creditor.setCreditLimit(Double.parseDouble(textField5.getText()));
			
			new DatabaseUpdate(connection).updateCreditCustomer(creditor);
			creditor=null;
			reset();
		}
	}

	private void delete(){
		boolean status=true;
		if(table1.getSelectedRowCount()!=1){
			status=false;
			new ValidationMSG(this, "Please Select A Row from Table Then Click");
		}
		
		
		if(status){
			int id = creditorList.get(table1.getSelectedRow()).getId();
			new DatabaseDelete(connection).deleteCreditCustomer(id);
			loadTableData();
			
		}
	}
	
	
	
	public void reset(){
		textField1.setText("");
		textField2.setText("");
		textField3.setText("");
		textField4.setText("");
		textField5.setText("");
		textArea1.setText("");
		loadTableData();
		
	}

	@Override
	public void itemStateChanged(ItemEvent event) {
		if(event.getStateChange()== ItemEvent.SELECTED){
			loadTableData();
		}
		
	}
}
