/*
 * Created by JFormDesigner on Sat May 30 11:55:00 IST 2015
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
import com.lrd.inventory.model.DistributorModel;

/**
 * @author dharmendra singh
 */
public class ManageDistributor extends JFrame implements ActionListener , ItemListener{

	private static final long serialVersionUID = 1L;
	// Variables declaration 
	private JLabel label1;
	private JComboBox<Object> comboBox1;
	private JButton button3;
	private JButton button4;
	private JLabel label5;
	private JScrollPane scrollPane1;
	private DefaultTableModel tableModel;
	private JTable table1;
	private JSeparator separator1;
	private JButton button1;
	private JButton button2;
	private JButton button5;
	private JButton button6;
	private JScrollPane scrollPane3;
	private JPanel panel1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label6;
	private JLabel label7;
	private JLabel label8;
	private JLabel label9;
	private JLabel label10;
	private JComboBox<Object> comboBox2;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JScrollPane scrollPane4;
	private JTextArea textArea1;
	private JLabel label11;
	private JLabel label12;
	private JLabel label13;
	private JLabel label14;
	private JLabel label15;
	private JTextField textField5;
	private JTextField textField6;
	private JTextField textField7;
	private JTextField textField8;
	private JTextField textField9;
	private JComboBox<Object> comboBox3;
	private JComboBox<Object> comboBox4;
	private JLabel label16;
	private JLabel label17;
	private JLabel label18;
	private JLabel label19;
	private JComboBox<Object> comboBox5;
	private JTextField textField10;
	private JScrollPane scrollPane5;
	private JTextArea textArea2;
	private JScrollPane scrollPane6;
	private JTextArea textArea3;
	//  End of variables declaration

	Connection connection=null;
	SpecificFieldValue fieldName = null;
	TableId tableid = null;
	DatabaseInsert dbinsert = null;
	DistributorModel distributor = null;
	Validate valid = null;
	GetDBValue dbValue = null;
	ArrayList<DistributorModel> distributorList = null;

	public ManageDistributor(Connection connection) {
		this.connection=connection;
		this.fieldName = new SpecificFieldValue(this.connection);
		tableid = new TableId(this.connection);
		dbinsert = new DatabaseInsert(this.connection);
		distributor = new DistributorModel();
		dbValue = new GetDBValue(connection);
		valid = new Validate();
		initComponents();
		storeName();
		loadTableData();
	}

	private void initComponents() {

		label1 = new JLabel();
		comboBox1 = new JComboBox<Object>();
		button3 = new JButton();
		button4 = new JButton();
		label5 = new JLabel();
		scrollPane1 = new JScrollPane();
		tableModel = new DefaultTableModel();
		table1 = new JTable(tableModel);
		separator1 = new JSeparator();
		button1 = new JButton();
		button2 = new JButton();
		button5 = new JButton();
		button6 = new JButton();
		scrollPane3 = new JScrollPane();
		panel1 = new JPanel();
		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		label6 = new JLabel();
		label7 = new JLabel();
		label8 = new JLabel();
		label9 = new JLabel();
		label10 = new JLabel();
		comboBox2 = new JComboBox<Object>();
		textField1 = new JTextField();
		textField2 = new JTextField();
		textField3 = new JTextField();
		textField4 = new JTextField();
		scrollPane4 = new JScrollPane();
		textArea1 = new JTextArea();
		label11 = new JLabel();
		label12 = new JLabel();
		label13 = new JLabel();
		label14 = new JLabel();
		label15 = new JLabel();
		textField5 = new JTextField();
		textField6 = new JTextField();
		textField7 = new JTextField();
		textField8 = new JTextField();
		textField9 = new JTextField();
		comboBox3 = new JComboBox<Object>();
		comboBox4 = new JComboBox<Object>();
		label16 = new JLabel();
		label17 = new JLabel();
		label18 = new JLabel();
		label19 = new JLabel();
		comboBox5 = new JComboBox<Object>();
		textField10 = new JTextField();
		scrollPane5 = new JScrollPane();
		textArea2 = new JTextArea();
		scrollPane6 = new JScrollPane();
		textArea3 = new JTextArea();

		//======== this ========
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		//---- label5 ----
		label5.setText("Manage Distributor");
		label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 15f));
		contentPane.add(label5);
		label5.setBounds(new Rectangle(new Point(265, 15), label5.getPreferredSize()));

		contentPane.add(separator1);
		separator1.setBounds(45, 60, 665, 7);

		//---- label1 ----
		label1.setText("Store Name");
		contentPane.add(label1);
		label1.setBounds(new Rectangle(new Point(30, 100), label1.getPreferredSize()));

		contentPane.add(comboBox1);
		comboBox1.setBounds(150, 100, 150, comboBox1.getPreferredSize().height);
		comboBox1.addItemListener(this);


		//======== scrollPane3 ========
		{
			scrollPane3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

			//======== panel1 ========
			{

				panel1.setLayout(null);

				//---- label2 ----
				label2.setText("Status");
				panel1.add(label2);
				label2.setBounds(new Rectangle(new Point(15, 10), label2.getPreferredSize()));

				panel1.add(comboBox2);
				comboBox2.setBounds(120, 10, 150, comboBox2.getPreferredSize().height);
				comboBox2.addItem("Active");
				comboBox2.addItem("Non Active");

				//---- label3 ----
				label3.setText("Contact Person");
				panel1.add(label3);
				label3.setBounds(new Rectangle(new Point(15, 50), label3.getPreferredSize()));

				panel1.add(textField1);
				textField1.setBounds(120, 50, 150, textField1.getPreferredSize().height);

				//---- label4 ----
				label4.setText("<html>Agency Name <font color='red'><b>*</b></font></html>");
				panel1.add(label4);
				label4.setBounds(new Rectangle(new Point(15, 90), label4.getPreferredSize()));

				panel1.add(textField2);
				textField2.setBounds(120, 90, 150, textField2.getPreferredSize().height);

				//---- label6 ----
				label6.setText("Pan No");
				panel1.add(label6);
				label6.setBounds(new Rectangle(new Point(15, 130), label6.getPreferredSize()));

				panel1.add(textField3);
				textField3.setBounds(120, 130, 150, textField3.getPreferredSize().height);

				//---- label7 ----
				label7.setText("<html>Vat / Tin No <font color='red'><b>*</b></font></html>");
				panel1.add(label7);
				label7.setBounds(new Rectangle(new Point(15, 170), label7.getPreferredSize()));

				panel1.add(textField4);
				textField4.setBounds(120, 170, 150, textField4.getPreferredSize().height);

				//---- label8 ----
				label8.setText("<html>Address <font color='red'><b>*</b></font></html>");
				panel1.add(label8);
				label8.setBounds(new Rectangle(new Point(15, 210), label8.getPreferredSize()));

				//======== scrollPane4 ========
				{
					//textArea1.setText("area1");
					scrollPane4.setViewportView(textArea1);
				}
				panel1.add(scrollPane4);
				scrollPane4.setBounds(120, 210, 150, 70);

				//---- label9 ----
				label9.setText("City ");
				panel1.add(label9);
				label9.setBounds(new Rectangle(new Point(15, 290), label9.getPreferredSize()));

				panel1.add(textField5);
				textField5.setBounds(120, 290, 150, textField5.getPreferredSize().height);
				//				textField5.setText("field 5");

				//---- label10 ----
				label10.setText("Pin Code");
				panel1.add(label10);
				label10.setBounds(new Rectangle(new Point(15, 330), label10.getPreferredSize()));

				panel1.add(textField6);
				textField6.setBounds(120, 330, 150, textField6.getPreferredSize().height);
				//				textField6.setText("field 6");

				//---- label11 ----
				label11.setText("Office No");
				panel1.add(label11);
				label11.setBounds(new Rectangle(new Point(15, 370), label11.getPreferredSize()));

				panel1.add(textField7);
				textField7.setBounds(120, 370, 150, textField7.getPreferredSize().height);
				//				textField7.setText("field 7");


				//---- label12 ----
				label12.setText("Fax No");
				panel1.add(label12);
				label12.setBounds(new Rectangle(new Point(15, 410), label12.getPreferredSize()));

				panel1.add(textField8);
				textField8.setBounds(120, 410, 150, textField8.getPreferredSize().height);
				//				textField8.setText("field 8");

				//---- label13 ----
				label13.setText("<html>Mobile No <font color='red'><b>*</b></font></html>");
				panel1.add(label13);
				label13.setBounds(new Rectangle(new Point(15, 450), label13.getPreferredSize()));

				panel1.add(textField9);
				textField9.setBounds(120, 450, 150, textField9.getPreferredSize().height);
				//				textField9.setText("field 9");

				//---- label14 ----
				label14.setText("Buying Type");
				panel1.add(label14);
				label14.setBounds(new Rectangle(new Point(15, 490), label14.getPreferredSize()));

				panel1.add(comboBox3);
				comboBox3.setBounds(120, 490, 150, comboBox3.getPreferredSize().height);
				comboBox3.addItem("select");
				comboBox3.setEnabled(false);


				//---- label15 ----
				label15.setText("Location Type");
				panel1.add(label15);
				label15.setBounds(new Rectangle(new Point(15, 530), label15.getPreferredSize()));

				panel1.add(comboBox4);
				comboBox4.setBounds(120, 530, 150, comboBox4.getPreferredSize().height);
				comboBox4.addItem("select");
				comboBox4.setEnabled(false);


				//---- label16 ----
				label16.setText("Purchase Type");
				panel1.add(label16);
				label16.setBounds(new Rectangle(new Point(15, 570), label16.getPreferredSize()));

				panel1.add(comboBox5);
				comboBox5.setBounds(120, 570, 150, comboBox5.getPreferredSize().height);
				comboBox5.addItem("select");
				comboBox5.setEnabled(false);

				//---- label17 ----
				label17.setText("Drug Lic No");
				panel1.add(label17);
				label17.setBounds(new Rectangle(new Point(15, 610), label17.getPreferredSize()));

				panel1.add(textField10);
				textField10.setBounds(120, 610, 150, textField10.getPreferredSize().height);

				//---- label18 ----
				label18.setText("Terms & Cond.");
				panel1.add(label18);
				label18.setBounds(new Rectangle(new Point(15, 650), label18.getPreferredSize()));

				//======== scrollPane5 ========
				{
					scrollPane5.setViewportView(textArea2);
				}
				panel1.add(scrollPane5);
				scrollPane5.setBounds(120, 650, 150, 70);

				//---- label19 ----
				label19.setText("Remark");
				panel1.add(label19);
				label19.setBounds(new Rectangle(new Point(15, 730), label19.getPreferredSize()));


				//======== scrollPane6 ========
				{
					scrollPane6.setViewportView(textArea3);
				}
				panel1.add(scrollPane6);
				scrollPane6.setBounds(120, 730, 150, 70);

				{ // compute preferred size
					Dimension preferredSize = new Dimension();
					for(int i = 0; i < panel1.getComponentCount(); i++) {
						Rectangle bounds = panel1.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = panel1.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					panel1.setMinimumSize(preferredSize);
					panel1.setPreferredSize(preferredSize);
				}
			}
			scrollPane3.setViewportView(panel1);
		}




		tableModel.addColumn("Sr. No.");
		tableModel.addColumn("Contact Person");
		tableModel.addColumn("Agency Name");
		tableModel.addColumn("Status");
		//======== scrollPane1 ========
		{
			scrollPane1.setViewportView(table1);
		}
		contentPane.add(scrollPane1);
		scrollPane1.setBounds(335, 100, 395, 365);

		//---- button1 ----
		button1.setText("Update");
		contentPane.add(button1);
		button1.setBounds(25, 480, 100, 40);
		button1.addActionListener(this);

		//---- button2 ----
		button2.setText("Save");
		contentPane.add(button2);
		button2.setBounds(145, 480, 100, 40);
		button2.addActionListener(this);

		//---- button3 ----
		button3.setText("Refresh");
		contentPane.add(button3);
		button3.setBounds(270, 480, 100, 40);
		button3.addActionListener(this);

		//---- button4 ----
		button4.setText("View");
		contentPane.add(button4);
		button4.setBounds(390, 480, 100, 40);
		button4.addActionListener(this);

		//---- button5 ----
		button5.setText("Delete");
		contentPane.add(button5);
		button5.setBounds(510, 480, 100, 40);
		button5.addActionListener(this);

		//---- button6 ----
		button6.setText("Exit");
		contentPane.add(button6);
		button6.setBounds(630, 480, 100, 40);
		button6.addActionListener(this);


		contentPane.add(scrollPane3);
		scrollPane3.setBounds(25, 130, 295, 335);


		pack();
		setVisible(true);
		setLocation(200, 10);
		setSize(800, 600);
	}


	private void storeName(){
		ArrayList<String> storeNames = (ArrayList<String>) fieldName
				.getAllStoreName();
		for (String name : storeNames) {
			comboBox1.addItem(name);
		}
	}


	private void loadTableData(){
		int j = 0;
		while (j < tableModel.getRowCount()) {
			tableModel.removeRow(j);
		}
		distributorList = dbValue.getDistributorDetail(tableid.getStoreId(comboBox1.getSelectedItem().toString()));
		for (int i = 0; i < distributorList.size(); i++) {
			distributor = distributorList.get(i);
			tableModel.addRow(new Object[] { (i+1), distributor.getName(),
					distributor.getAgencyName(),
					distributor.getStatus() });
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


	private void save(){
		boolean status=true;
		if( valid.isEmpty(textField2.getText())){
			status=false;
			new ValidationMSG(this, "Please Insert Agency Name");
		}else if( valid.isEmpty(textField4.getText())){
			status=false;
			new ValidationMSG(this, "Please Insert Tin No");
		}else if( valid.isEmpty(textField4.getText())){
			status=false;
			new ValidationMSG(this, "Please Insert Address");
		}else if( valid.isEmpty(textField9.getText())){
			status=false;
			new ValidationMSG(this, "Please Insert Contact No");
		}



		if(status){
			distributor=null;
			DistributorModel distributor = new DistributorModel();
			distributor.setDistributorId(0);
			distributor.setStoreId(tableid.getStoreId(comboBox1.getSelectedItem().toString()));
			distributor.setStatus(comboBox2.getSelectedItem().toString());
			if(!valid.isEmpty(textField1.getText()))
				distributor.setName(textField1.getText());
			distributor.setAgencyName(textField2.getText());
			if(!valid.isEmpty(textField3.getText()))
				distributor.setPanNo(textField3.getText());
			distributor.setTinNo(textField4.getText());
			distributor.setAddress(textArea1.getText());
			if(!valid.isEmpty(textField5.getText()))
				distributor.setCity(textField5.getText());
			if(!valid.isEmpty(textField6.getText()))
				distributor.setPinCode(textField6.getText());
			if(!valid.isEmpty(textField7.getText()))
				distributor.setOfficeNo(textField7.getText());
			if(!valid.isEmpty(textField8.getText()))
				distributor.setFaxNo(textField8.getText());
			distributor.setMobileNo(textField9.getText());
			distributor.setBuyingType(comboBox3.getSelectedItem().toString());
			distributor.setLocationType(comboBox4.getSelectedItem().toString());
			distributor.setPurchaseType(comboBox5.getSelectedItem().toString());
			if(!valid.isEmpty(textField10.getText()))
			distributor.setDrugLicenceNo(textField10.getText());
			if(!valid.isEmpty(textArea2.getText()))
			distributor.setTerms(textArea2.getText());
			if(!valid.isEmpty(textArea3.getText()))
			distributor.setRemark(textArea3.getText());

			new DatabaseInsert(connection).insertDistributor(distributor);
			reset();
		}

	}


	private void reFresh(){
		reset();
	}


	private void exit(){
		this.dispose();
	}


	private void view(){
		boolean status=true;

		if(table1.getSelectedRowCount()<1){
			status=false;
			new ValidationMSG(this, "Please Select A Row from Table Then Click");
		}

		if(status){
			
			distributor = distributorList.get(table1.getSelectedRow());
			comboBox2.setSelectedItem(distributor.getStatus());
			textField1.setText(distributor.getName());
			textField2.setText(distributor.getAgencyName());
			textField3.setText(distributor.getPanNo());
			textField4.setText(distributor.getTinNo());
			textField5.setText(distributor.getCity());
			textField6.setText(distributor.getPincode());
			textField7.setText(distributor.getOfficeNo());
			textField8.setText(distributor.getFaxNo());
			textField9.setText(distributor.getMobileNo());
			textField10.setText(distributor.getDrugLicenceNo());
			
			textArea1.setText(distributor.getAddress());
			textArea2.setText(distributor.getTerms());
			textArea3.setText(distributor.getRemark());
		}
	}


	private void update(){
		boolean status=true;
		if(distributor==null){
			status=false;
			new ValidationMSG(this, "Please Select A Row from Table Then Click on View to Update Rack Details");
		}else if( valid.isEmpty(textField2.getText())){
			status=false;
			new ValidationMSG(this, "Please Insert Agency Name");
		}else if( valid.isEmpty(textField4.getText())){
			status=false;
			new ValidationMSG(this, "Please Insert Tin No");
		}else if( valid.isEmpty(textArea1.getText())){
			status=false;
			new ValidationMSG(this, "Please Insert Address");
		}else if( valid.isEmpty(textField9.getText())){
			status=false;
			new ValidationMSG(this, "Please Insert Contact No");
		}
		
		
		if(status){
			
			
			distributor.setStatus(comboBox2.getSelectedItem().toString());
			if(!valid.isEmpty(textField1.getText()))
				distributor.setName(textField1.getText());
			distributor.setAgencyName(textField2.getText());
			if(!valid.isEmpty(textField3.getText()))
				distributor.setPanNo(textField3.getText());
			distributor.setTinNo(textField4.getText());
			distributor.setAddress(textArea1.getText());
			if(!valid.isEmpty(textField5.getText()))
				distributor.setCity(textField5.getText());
			if(!valid.isEmpty(textField6.getText()))
				distributor.setPinCode(textField6.getText());
			if(!valid.isEmpty(textField7.getText()))
				distributor.setOfficeNo(textField7.getText());
			if(!valid.isEmpty(textField8.getText()))
				distributor.setFaxNo(textField8.getText());
			distributor.setMobileNo(textField9.getText());
			distributor.setBuyingType(comboBox3.getSelectedItem().toString());
			distributor.setLocationType(comboBox4.getSelectedItem().toString());
			distributor.setPurchaseType(comboBox5.getSelectedItem().toString());
			if(!valid.isEmpty(textField10.getText()))
			distributor.setDrugLicenceNo(textField10.getText());
			if(!valid.isEmpty(textArea2.getText()))
			distributor.setTerms(textArea2.getText());
			if(!valid.isEmpty(textArea3.getText()))
			distributor.setRemark(textArea3.getText());
			
			new DatabaseUpdate(connection).updateDistributor(distributor);
			distributor=null;
			reset();
		}
	}




	private void delete(){
		boolean status=true;

		if(table1.getSelectedRowCount()<1){
			status=false;
			new ValidationMSG(this, "Please Select A Row from Table Then Click");
		}

		if(status){
			int id = distributorList.get(table1.getSelectedRow()).getDistributorId();
			new DatabaseDelete(connection).deleteDistributor(id);
			reset();
		}
	}
	
	
	
	private void reset(){
		comboBox2.setSelectedIndex(0);
		textField1.setText("");
		textField2.setText("");
		textField3.setText("");
		textField4.setText("");
		textField5.setText("");
		textField6.setText("");
		textField7.setText("");
		textField8.setText("");
		textField9.setText("");
		textField10.setText("");
		
		textArea1.setText("");
		textArea2.setText("");
		textArea3.setText("");
		loadTableData();
	}

	@Override
	public void itemStateChanged(ItemEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource()==comboBox1){
			loadTableData();
			reset();
		}
	}

}
