/*
  * Created by JFormDesigner on Fri May 29 16:44:04 IST 2015
 */

package com.lrd.inventory.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.lrd.inventory.database.DatabaseDelete;
import com.lrd.inventory.database.DatabaseInsert;
import com.lrd.inventory.database.GetDBValue;
import com.lrd.inventory.database.SpecificFieldValue;
import com.lrd.inventory.database.TableId;
import com.lrd.inventory.main.Validate;
import com.lrd.inventory.main.ValidationMSG;
import com.lrd.inventory.model.FinancialYearModal;
import com.lrd.inventory.model.VatModel;

/**
 * @author dharmendra singh
 */
public class ManageVat extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	//  Variables declaration 
	private JPanel panel1;
	private JLabel label1;
	private JSeparator separator1;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JScrollPane scrollPane2;
	DefaultTableModel tableModel1;
	private JTable table1;
	private JPanel panel2;
	private JLabel label5;
	private JTextField textField1;
	private JLabel label2;
	private JLabel label3;
	private JTextField textField2;
	private JTextField textField3;
	private JButton button1;
	private JButton button2;
	//  End of variables declaration 

	Connection connection=null;
	SpecificFieldValue fieldName = null;
	TableId tableid = null;
	DatabaseInsert dbinsert = null;
	VatModel vatModel = null;
	FinancialYearModal yearModel = null;
	Validate valid = null;
	GetDBValue dbValue = null;
	ArrayList<VatModel> vatList = null;
	ArrayList<FinancialYearModal> yearList=null;

	public ManageVat(Connection connection) {
		this.connection=connection;
		this.fieldName = new SpecificFieldValue(this.connection);
		tableid = new TableId(this.connection);
		dbinsert = new DatabaseInsert(this.connection);
		vatModel = new VatModel();
		yearModel = new FinancialYearModal();
		dbValue = new GetDBValue(connection);
		valid = new Validate();
		initComponents();
		loadTableData();
	}

	private void initComponents() {

		panel1 = new JPanel();
		label1 = new JLabel();
		separator1 = new JSeparator();
		button3 = new JButton();
		button4 = new JButton();
		button5 = new JButton();
		scrollPane2 = new JScrollPane();
		tableModel1 = new DefaultTableModel();
		table1 = new JTable(tableModel1);
		panel2 = new JPanel();
		label5 = new JLabel();
		textField1 = new JTextField();
		label2 = new JLabel();
		label3 = new JLabel();
		textField2 = new JTextField();
		textField3 = new JTextField();
		button1 = new JButton();
		button2 = new JButton();

		//======== this ========
		setResizable(false);
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		//======== panel1 ========
		{
			panel1.setLayout(null);

			//---- label1 ----
			label1.setText("Manage Vat %");
			panel1.add(label1);
			label1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 30));
			label1.setBounds(200, 10, 400, 50);

			panel1.add(separator1);
			separator1.setBounds(0, 100, 600, 5);


			//======== panel2 ========
			{
				panel2.setBorder(UIManager.getBorder("TitledBorder.border"));
				panel2.setLayout(null);

				//---- label3 ----
				label3.setText("<html>Year    : <font color='red'><b>*</b></font></html>");
				panel2.add(label3);
				label3.setBounds(new Rectangle(new Point(25, 25), label3.getPreferredSize()));
				
				panel2.add(textField1);
				textField1.setBounds(95, 25, 100, textField1.getPreferredSize().height);



				//---- label5 ----
				label5.setText("<html>To  : <font color='red'><b>*</b></font></html>");
				panel2.add(label5);
				label5.setBounds(new Rectangle(new Point(250, 25), label5.getPreferredSize()));
				
				panel2.add(textField2);
				textField2.setBounds(310, 25, 100, textField2.getPreferredSize().height);


				//---- label2 ----
				label2.setText("<html>Vat %  : <font color='red'><b>*</b></font></html>");
				panel2.add(label2);
				label2.setBounds(new Rectangle(new Point(25, 85), label2.getPreferredSize()));
				
				panel2.add(textField3);
				textField3.setBounds(95, 85, 315, textField3.getPreferredSize().height);

				//---- button1 ----
				button1.setText("Add");
				panel2.add(button1);
				button1.setBounds(70, 150, 100, 30);
				button1.addActionListener(this);

				//---- button2 ----
				button2.setText("Clear");
				panel2.add(button2);
				button2.setBounds(280, 150, 100, 30);
				button2.addActionListener(this);

			}
			panel1.add(panel2);
			panel2.setBounds(50, 125, 500, 200);


			tableModel1.addColumn("Sr. No.");
			tableModel1.addColumn("vat %");
			tableModel1.addColumn("Year From");
			tableModel1.addColumn("Year To");

			//======== scrollPane2 ========
			{
				scrollPane2.setViewportView(table1);
			}
			panel1.add(scrollPane2);
			scrollPane2.setBounds(50, 340, 500, 250);

			//---- button3 ----
			button3.setText("Delete");
			panel1.add(button3);
			button3.setBounds(50, 610, 150, 30);
			button3.addActionListener(this);

			//---- button4 ----
			button4.setText("Update");
			panel1.add(button4);
			button4.setBounds(225, 610, 150, 30);
			button4.addActionListener(this);
			button4.setEnabled(false);

			//---- button5 ----
			button5.setText("Refresh");
			panel1.add(button5);
			button5.setBounds(400, 610, 150, 30);
			button5.addActionListener(this);





		}
		contentPane.add(panel1);
		panel1.setBounds(0, 0, 600, 700);


		pack();
		setVisible(true);
		setLocation(200, 10);
		setSize(600, 700);
	}


	public void loadTableData() {

		while (tableModel1.getRowCount()>0) {
			tableModel1.removeRow(0);
		}
		
		
		vatList = dbValue.getVatDetail();
		yearList = dbValue.getFinancialYearDetail();
		for (int i = 0; i < vatList.size(); i++) {
			int startYear=0,endYear=0;
			vatModel = vatList.get(i);
			for(FinancialYearModal yearModel : yearList){
				if(yearModel.getYearId()==vatModel.getYearId()){
					startYear=yearModel.getStartYear();
					endYear=yearModel.getEndYear();
				}
			}
			tableModel1.addRow(new Object[] { i+1, vatModel.getVatPercent(),startYear,endYear });
		}
	}



	@Override
	public void actionPerformed(ActionEvent event) {
		String temp = event.getActionCommand();

		switch (temp) {
		case "Add":
			save();
			break;
		case "Clear":
			reset();
			break;
		case "Delete":
			delete();
			reset();
			loadTableData();
			break;
		case "Update":
			update();
			reset();
			loadTableData();
			break;
		case "Refresh":
			reset();
			loadTableData();
			break;
		default:	
		}

	}

	private void save(){
		
		boolean status=true;
		if( valid.isEmpty(textField1.getText())){
			status=false;
			new ValidationMSG(this, "Please Insert Start Year");
		}else if( valid.isEmpty(textField2.getText())){
			status=false;
			new ValidationMSG(this, "Please Insert End Year");
		}else if( valid.isEmpty(textField3.getText())){
			status=false;
			new ValidationMSG(this, "Please Insert Vat %");
		}
		
		if(status){
			VatModel vatModel = new VatModel();
			vatModel.setVatId(0);
			vatModel.setVatPercent(Float.parseFloat(textField3.getText()));
			vatModel.setYearId(tableid.getYearId(Integer.parseInt(textField1.getText()), Integer.parseInt(textField2.getText())));
			vatModel.setFirmId(1);
			vatModel.setVatUpdated(0);
			dbinsert.insertVat(vatModel);
			vatModel.setDefault();
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
			int id=vatList.get(table1.getSelectedRow()).getVatId();
			new DatabaseDelete(connection).deleteVat(id);
			loadTableData();
		}
	}

	private void update(){

	}
	
	
	
	private void reset(){
		textField1.setText("");
		textField2.setText("");
		textField3.setText("");
		loadTableData();
	}
}
