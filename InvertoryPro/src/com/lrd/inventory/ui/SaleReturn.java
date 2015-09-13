

package com.lrd.inventory.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.lrd.inventory.database.DatabaseInsert;
import com.lrd.inventory.database.GetDBValue;
import com.lrd.inventory.database.SpecificFieldValue;
import com.lrd.inventory.database.TableId;
import com.lrd.inventory.main.DatePicker;
import com.lrd.inventory.main.Validate;
import com.lrd.inventory.main.ValidationMSG;
import com.lrd.inventory.model.SalesBillDetailModel;
import com.lrd.inventory.model.SalesBillModel;
import com.lrd.inventory.model.SalesBillReturnModel;
import com.lrd.inventory.model.CreditorModel;
import com.lrd.inventory.model.ProductModel;

/**
 * @author dharmendra singh
 */
public class SaleReturn extends JFrame implements ActionListener , ItemListener, KeyListener , ListSelectionListener , FocusListener{



	private static final long serialVersionUID = 1L;
	//  Variables declaration 
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;


	private JLabel label1;
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
	private JLabel label12;
	private JLabel label13;
	private JLabel label14;
	private JLabel label15;
	private JLabel label16;
	private JLabel label17;
	private JLabel label18;

	private JTabbedPane tabbedPane1;


	private JScrollPane scrollPane1;
	private JScrollPane scrollPane2;
	private JScrollPane scrollPane3;
	private JScrollPane scrollPane4;


	private DefaultTableModel tableModel1;
	private JTable table1;
	private DefaultTableModel tableModel2;
	private JTable table2;
	private DefaultTableModel tableModel3;
	private JTable table3;


	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	private JButton button8;
	private JButton button9;
	private JButton button10;
	private ButtonGroup buttonGroup;


	private JComboBox<Object> comboBox1;
	private JComboBox<Object> comboBox2;
	private JComboBox<Object> comboBox3;
	private JComboBox<Object> comboBox4;
	private JComboBox<Object> comboBox5;


	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	private JTextField textField7;
	private JTextField textField8;
	private JTextField textField9;
	private JTextField textField10;
	private JTextField textField11;
	private JTextField textField12;


	private JRadioButton radioButton1;
	private JRadioButton radioButton2;

	private DefaultListModel<String> listModel;
	private JList<String> list1;

	//  End of variables declaration  

	Connection connection = null;
	SpecificFieldValue fieldName = null;
	TableId tableid = null;
	DatabaseInsert dbinsert = null;
	GetDBValue dbvalue = null;
	Validate valid = null;

	ArrayList<SalesBillModel> billList = null;
	ArrayList<SalesBillModel> billDisplayList = null;
	ArrayList<SalesBillDetailModel> billDetailList = null;

	ArrayList<ProductModel> productList1 = null;
	ArrayList<ProductModel> productList2 = null;
	ArrayList<ProductModel> productDisplayList1 = null;
	ArrayList<ProductModel> productDisplayList2 = null;

	ArrayList<SalesBillReturnModel> billReturnList = null;
	ArrayList<CreditorModel> creditors;

	public SaleReturn(Connection connection) {
		this.connection = connection;
		fieldName = new SpecificFieldValue(connection);
		tableid = new TableId(connection);
		dbinsert = new DatabaseInsert(connection);
		dbvalue = new GetDBValue(connection);
		valid = new Validate();
		initComponents();
		storeName();
		billReturnList = new ArrayList<>();
		productList1 = productList2 = dbvalue.getProductDetail(tableid.getStoreId(comboBox1.getSelectedItem().toString()));
		billList = dbvalue.getAllBill(tableid.getStoreId(comboBox1.getSelectedItem().toString()));

		creditors = dbvalue.getCreditorDetail(tableid.getStoreId(comboBox5.getSelectedItem().toString()));
		creditCustomerName();
	}

	private void initComponents() {
		//Component initialization 

		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();



		label1 = new JLabel();
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
		label12 = new JLabel();
		label13 = new JLabel();
		label14 = new JLabel();
		label15 = new JLabel();
		label16 = new JLabel();
		label17 = new JLabel();
		label18 = new JLabel();

		tabbedPane1 = new JTabbedPane();


		scrollPane1 = new JScrollPane();
		scrollPane2 = new JScrollPane();
		scrollPane3 = new JScrollPane();
		scrollPane4 = new JScrollPane();


		tableModel1 = new DefaultTableModel();
		table1 = new JTable(tableModel1);
		tableModel2 = new DefaultTableModel();
		table2 = new JTable(tableModel2);
		tableModel3 = new DefaultTableModel();
		table3 = new JTable(tableModel3);



		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		button5 = new JButton();
		button6 = new JButton();
		button7 = new JButton();
		button8 = new JButton();
		button9 = new JButton();
		button10 = new JButton();
		buttonGroup = new ButtonGroup();

		comboBox1 = new JComboBox<Object>();
		comboBox2 = new JComboBox<Object>();
		comboBox3 = new JComboBox<Object>();
		comboBox4 = new JComboBox<Object>();
		comboBox5 = new JComboBox<Object>();
		textField1 = new JTextField();
		textField2 = new JTextField();
		textField3 = new JTextField();
		textField4 = new JTextField();
		textField5 = new JTextField();
		textField6 = new JTextField();
		textField7 = new JTextField();
		textField8 = new JTextField();
		textField9 = new JTextField();
		textField10 = new JTextField();
		textField11 = new JTextField();
		textField12 = new JTextField();


		radioButton1 = new JRadioButton();
		radioButton2 = new JRadioButton();




		listModel = new DefaultListModel<>();
		list1 = new JList<String>(listModel);




		//======== this ========
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		//======== panel1 ========
		{

			panel1.setLayout(null);

			//======== panel2 ========
			{
				panel2.setLayout(null);

				//---- label18 ----
				label18.setText("Sale Returns");
				label18.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 30));
				panel2.add(label18);
				label18.setBounds(300, 10, 400, 50);
			}
			panel1.add(panel2);
			panel2.setBounds(0, 0, 800, 75);




			//======== tabbedPane1 ========
			{

				//======== panel3 ========
				{
					panel3.setLayout(null);

					//---- label1 ----
					label1.setText("Select Store");
					panel3.add(label1);
					label1.setBounds(20,10,100,20);

					panel3.add(comboBox1);
					comboBox1.setBounds(120,10,150,20);

					//---- label2 ----
					label2.setText("Bill No");
					panel3.add(label2);
					label2.setBounds(20,40,100,20);

					panel3.add(textField1);
					textField1.setBounds(120,40,150,20);
					textField1.addKeyListener(this);
					textField1.addFocusListener(this);

					//---- label3 ----
					label3.setText("Customer Name");
					panel3.add(label3);
					label3.setBounds(280,10,100,20);

					panel3.add(textField2);
					textField2.setBounds(380,10,150,20);
					textField2.addKeyListener(this);
					textField2.addFocusListener(this);

					//---- label4 ----
					label4.setText("Mobile no");
					panel3.add(label4);
					label4.setBounds(280,40,100,20);

					panel3.add(textField3);
					textField3.setBounds(380,40,150,20);
					textField3.addKeyListener(this);
					textField3.addFocusListener(this);

					//---- label5 ----
					label5.setText("Date");
					panel3.add(label5);
					label5.setBounds(570,10,40,20);

					panel3.add(textField4);
					textField4.setBounds(620,10,150,20);
					textField4.addKeyListener(this);
					textField4.addFocusListener(this);

					tableModel1.addColumn("Bill No");
					tableModel1.addColumn("Name");
					tableModel1.addColumn("Date");
					tableModel1.addColumn("Mobile No");
					tableModel1.addColumn("Amount");
					table1.getSelectionModel().addListSelectionListener(this);
					//======== scrollPane1 ========
					{
						scrollPane1.setViewportView(table1);
					}
					panel3.add(scrollPane1);
					scrollPane1.setBounds(10, 80, 760, 100);

					tableModel2.addColumn("Code");
					tableModel2.addColumn("Product");
					tableModel2.addColumn("Qty");
					tableModel2.addColumn("Unit");
					tableModel2.addColumn("Rate");
					tableModel2.addColumn("vat%");
					tableModel2.addColumn("Discount");
					tableModel2.addColumn("Sub total");
					table2.getSelectionModel().addListSelectionListener(this);
					//======== scrollPane2 ========
					{
						scrollPane2.setViewportView(table2);
					}
					panel3.add(scrollPane2);
					scrollPane2.setBounds(10, 200, 760, 100);

					//---- label6 ----
					label6.setText("Product");
					panel3.add(label6);
					label6.setBounds(10,320,60,20);

					panel3.add(textField5);
					textField5.setBounds(70,320,150,20);

					//---- label7 ----
					label7.setText("Unit");
					panel3.add(label7);
					label7.setBounds(10,350,60,20);

					panel3.add(comboBox2);
					comboBox2.setBounds(70,350,150,20);

					//---- label8 ----
					label8.setText("Quantity");
					panel3.add(label8);
					label8.setBounds(300,320,60,20);

					panel3.add(textField6);
					textField6.setBounds(360,320,150,20);

					//---- label9 ----
					label9.setText("Rate");
					panel3.add(label9);
					label9.setBounds(300,350,60,20);

					panel3.add(textField7);
					textField7.setBounds(360,350,150,20);

					//---- button6 ----
					button6.setText("Add");
					panel3.add(button6);
					button6.setBounds(550, 330, 100, 30);
					button6.addActionListener(this);


					tableModel3.addColumn("Sr.");
					tableModel3.addColumn("Product Name");
					tableModel3.addColumn("Quantity");
					tableModel3.addColumn("Rate");
					tableModel3.addColumn("Amount");
					tableModel3.addColumn("Discount");
					//======== scrollPane3 ========
					{
						scrollPane3.setViewportView(table3);
					}
					panel3.add(scrollPane3);
					scrollPane3.setBounds(10, 380, 760, 100);

					//---- button1 ----
					button1.setText("Remove");
					panel3.add(button1);
					button1.setBounds(20, 500, 100, 30);
					button1.addActionListener(this);

					//---- button2 ----
					button2.setText("Refresh");
					panel3.add(button2);
					button2.setBounds(180, 500, 100, 30);
					button2.addActionListener(this);

					//---- button3 ----
					button3.setText("Replace");
					panel3.add(button3);
					button3.setBounds(340, 500, 100, 30);
					button3.addActionListener(this);

					//---- button4 ----
					button4.setText("Return");
					panel3.add(button4);
					button4.setBounds(500, 500, 100, 30);
					button4.addActionListener(this);

					//---- button5 ----
					button5.setText("Cancel");
					panel3.add(button5);
					button5.setBounds(660, 500, 100, 30);
					button5.addActionListener(this);




				}
				tabbedPane1.addTab("Bill Returns", panel3);

				//======== panel4 ========
				{
					panel4.setLayout(null);

					//---- label10 ----
					label10.setText("Select Store");	
					panel4.add(label10);
					label10.setBounds(50, 20, 120, label10.getPreferredSize().height);

					panel4.add(comboBox5);
					comboBox5.setBounds(150, 20, 300, comboBox5.getPreferredSize().height);

					//---- label11 ----
					label11.setText("Customer");
					panel4.add(label11);
					label11.setBounds(new Rectangle(new Point(50, 60), label11.getPreferredSize()));

					//---- radioButton1 ----
					radioButton1.setText("General Customer");
					panel4.add(radioButton1);
					radioButton1.setBounds(150, 60, 150, radioButton1.getPreferredSize().height);
					buttonGroup.add(radioButton1);
					radioButton1.setSelected(true);
					radioButton1.addItemListener(this);

					//---- radioButton2 ----
					radioButton2.setText("Credit Customer");
					panel4.add(radioButton2);
					radioButton2.setBounds(150, 100, 150, radioButton2.getPreferredSize().height);
					buttonGroup.add(radioButton2);
					radioButton2.addItemListener(this);

					panel4.add(comboBox3);
					comboBox3.setBounds(300, 100, 160, comboBox3.getPreferredSize().height);
					comboBox3.setEnabled(false);

					//---- label12 ----
					label12.setText("Product");
					panel4.add(label12);
					label12.setBounds(new Rectangle(new Point(50, 140), label12.getPreferredSize()));

					panel4.add(textField8);
					textField8.setBounds(150, 140, 300, textField8.getPreferredSize().height);
					textField8.addKeyListener(this);


					list1.addListSelectionListener(this);
					//======== scrollPane4 ========
					{
						scrollPane4.setViewportView(list1);
					}
					panel4.add(scrollPane4);
					scrollPane4.setBounds(150, 180, 300, 100);

					//---- label13 ----
					label13.setText("Quantity");
					panel4.add(label13);
					label13.setBounds(new Rectangle(new Point(50, 300), label13.getPreferredSize()));

					panel4.add(textField9);
					textField9.setBounds(150, 300, 300, textField9.getPreferredSize().height);
					textField9.addKeyListener(this);

					//---- label14 ----
					label14.setText("Unit");
					panel4.add(label14);
					label14.setBounds(new Rectangle(new Point(50, 340), label14.getPreferredSize()));

					panel4.add(comboBox4);
					comboBox4.setBounds(150, 340, 300, comboBox4.getPreferredSize().height);

					//---- label15 ----
					label15.setText("Rate");
					panel4.add(label15);
					label15.setBounds(new Rectangle(new Point(50, 380), label15.getPreferredSize()));

					panel4.add(textField10);
					textField10.setBounds(150, 380, 300, textField10.getPreferredSize().height);

					//---- label16 ----
					label16.setText("Total");
					panel4.add(label16);
					label16.setBounds(new Rectangle(new Point(50, 420), label16.getPreferredSize()));

					panel4.add(textField11);
					textField11.setBounds(150, 420, 300, textField11.getPreferredSize().height);
					textField11.setEnabled(false);

					//---- label17 ----
					label17.setText("Date");
					panel4.add(label17);
					label17.setBounds(new Rectangle(new Point(550, 20), label17.getPreferredSize()));

					panel4.add(textField12);
					textField12.setBounds(600, 15, 150, textField12.getPreferredSize().height);
					textField12.setText(new DatePicker().getCurrentDate());
					textField12.setEnabled(false);


					//---- button7 ----
					button7.setText("Return");
					panel4.add(button7);
					button7.setBounds(50, 460, 100, 30);
					button7.addActionListener(this);

					//---- button8 ----
					button8.setText("Replace");
					panel4.add(button8);
					button8.setBounds(180, 460, 100, 30);
					button8.addActionListener(this);

					//---- button9 ----
					button9.setText("Refresh");
					panel4.add(button9);
					button9.setBounds(310, 460, 100, 30);
					button9.addActionListener(this);

					//---- button10 ----
					button10.setText("Cancel");
					panel4.add(button10);
					button10.setBounds(450, 460, 100, 30);
					button10.addActionListener(this);

				}
				tabbedPane1.addTab("Product Returns", panel4);
			}
			panel1.add(tabbedPane1);
			tabbedPane1.setBounds(0, 75, 800, 690);


		}
		contentPane.add(panel1);
		panel1.setBounds(0, 0, 800, 700);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
		setLocation(200, 10);
		setSize(800, 700);
	}

	public static void main(String[] args){
		//new SaleReturn();
	}

	private void storeName(){
		ArrayList<String> storeNames = (ArrayList<String>) fieldName.getAllStoreName();
		for (String name : storeNames){
			comboBox1.addItem(name);
			comboBox5.addItem(name);
		}
	}


	private void creditCustomerName(){
		comboBox3.addItem("--select--");
		for (CreditorModel creditor : creditors) {
			comboBox3.addItem(creditor.getName());
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent event) {
		if(!(event.getKeyChar()==27 || event.getKeyChar()==6)){

			/// this block is for searching bill according to bill no
			if(event.getSource()==textField1){
				billDisplayList = new ArrayList<>();
				String tempStr = textField1.getText();
				if(!valid.isEmpty(tempStr)){
					for(SalesBillModel tempBill : billList){
						if(tempBill.getBillNo().contains(tempStr.toUpperCase())){
							billDisplayList.add(tempBill);
						}
					}
				}
				//resetFirstTabField();
				loadTable1Data();
			}

			/// this block is for searching bill according to customer name
			if(event.getSource()==textField2){
				billDisplayList = new ArrayList<>();
				String tempStr = textField2.getText();
				if(!valid.isEmpty(tempStr)){
					for(SalesBillModel tempBill : billList){
						if(tempBill.getCustomerName().startsWith(tempStr)){
							billDisplayList.add(tempBill);
						}
					}
				}
				//resetFirstTabField();
				loadTable1Data();
			}

			/// this block is for searching bill according to customer mobile no
			if(event.getSource()==textField3){
				billDisplayList = new ArrayList<>();
				String tempStr = textField3.getText();
				if(!valid.isEmpty(tempStr)){
					for(SalesBillModel tempBill : billList){
						if(tempBill.getMobileNo().contains(tempStr)){
							billDisplayList.add(tempBill);
						}
					}
				}
				//resetFirstTabField();
				loadTable1Data();
			}

			/// this block is for searching bill according to bill Date
			if(event.getSource()==textField4){
				billDisplayList = new ArrayList<>();
				String tempStr = textField4.getText();
				if(!valid.isEmpty(tempStr)){
					for(SalesBillModel tempBill : billList){
						if(tempBill.getBillDate().contains(tempStr)){
							billDisplayList.add(tempBill);
						}
					}
				}
				//resetFirstTabField();
				loadTable1Data();
			}


			/// this block is for searching product according to product Name
			if(event.getSource()==textField8){
				productDisplayList2 = new ArrayList<>();
				String tempStr = textField8.getText();
				if(!valid.isEmpty(tempStr)){
					for(ProductModel tempProduct1 : productList2){
						if(tempProduct1.getProductName().contains(tempStr)){
							productDisplayList2.add(tempProduct1);
						}
					}
				}
				loadListData(productDisplayList2);
			}

			/// this block is for calculating total amount of product return
			if(event.getSource()==textField9){
				double tempQuantity= 0;
				if(!valid.isEmpty(textField9.getText()))
					tempQuantity=Double.parseDouble(textField9.getText());
				double tempRate = 0;
				if(!valid.isEmpty(textField10.getText()))
					tempRate=Double.parseDouble(textField10.getText());
				double total=tempRate*tempQuantity;
				textField11.setText(String.valueOf(total));
			}
			
			if(event.getSource() == textField10){
				double tempQuantity= 0;
				if(!valid.isEmpty(textField9.getText()))
					tempQuantity=Double.parseDouble(textField9.getText());
				double tempRate = 0;
				if(!valid.isEmpty(textField10.getText()))
					tempRate=Double.parseDouble(textField10.getText());
				double total=tempRate*tempQuantity;
				textField11.setText(String.valueOf(total));
			}
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void itemStateChanged(ItemEvent event) {
		if(event.getStateChange()== ItemEvent.SELECTED){
			if(event.getSource()==radioButton2){
				comboBox3.setEnabled(true);
			}
			if(event.getSource()==radioButton1){
				comboBox3.setEnabled(false);
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent event) {

		// For cilck on add button of bill return
		if(event.getSource()==button6){
			if(valid.isEmpty(textField6.getText())){
				new ValidationMSG(this, "Please Insert Quantity");
			}else if(Double.parseDouble(textField6.getText()) <= billDetailList.get(table2.getSelectedRow()).getProductQuantity()){
				setBillReturnModel();
				loadTable3Data();
			}else{
				new ValidationMSG(this, "Quantity must be less Then bill product Quantity");
			}
		}


		// for click on replace button of bill return
		if(event.getSource()==button3){
			if(billReturnList.size()>0){
				for(SalesBillReturnModel billReturn : billReturnList){
					billReturn.setStatus(SalesBillReturnModel.REPLACE);
					dbinsert.insertBillReturn(billReturn);
				}
			}else{
				new ValidationMSG(this, "Please Add A Product to the list to Replace");
			}
		}

		// for click on return button of bill return
		if(event.getSource()==button4){
			if(billReturnList.size()>0){
				for(SalesBillReturnModel billReturn : billReturnList){
					billReturn.setStatus(SalesBillReturnModel.RETURN);
					dbinsert.insertBillReturn(billReturn);
					for(ProductModel product : productList1){
						if(product.getProductCode().equals(billReturn.getProductCode())){
							double newqty = product.getQuantity()+billReturn.getProductQuantity();
							int id = product.getProductId();
							dbinsert.updateProduct(id, newqty);
						}
					}
				}
			}else{
				new ValidationMSG(this, "Please Add A Product to the list to Return");
			}
		}

		// for click on Refresh button of bill return
		if(event.getSource()==button2){
			resetFirstTabField();
			billDisplayList = new ArrayList<>();
			loadTable1Data();
			textField1.setText("");
			textField2.setText("");
			textField3.setText("");
			textField4.setText("");
		}

		//for click on Remove button of bill return
		if(event.getSource()==button1 && table3.getRowCount()>0 && table3.getSelectedRowCount()>0){
			billReturnList.remove(table3.getSelectedRow());
			tableModel3.removeRow(table3.getSelectedRow());

		}

		//for click on Return button of product return
		if(event.getSource()==button7){
			SalesBillReturnModel billReturn = new SalesBillReturnModel();

			billReturn.setCategoryName(fieldName.getCategoryName(productDisplayList2.get(list1.getSelectedIndex()).getProductName()));
			billReturn.setProductCode(productDisplayList2.get(list1.getSelectedIndex()).getProductCode());
			billReturn.setProductName(productDisplayList2.get(list1.getSelectedIndex()).getProductName());
			billReturn.setProductQuantity(Double.parseDouble(textField9.getText()));
			billReturn.setProductRate(Double.parseDouble(textField10.getText()));
			billReturn.setProductUnit(comboBox4.getSelectedItem().toString());
			billReturn.setReturnDate(textField12.getText());
			billReturn.setFirmId(1);
			billReturn.setStoreId(tableid.getStoreId(comboBox5.getSelectedItem().toString()));
			int startYear = Calendar.getInstance().get(Calendar.YEAR);
			billReturn.setYearId(tableid.getYearId(startYear, startYear+1));
			billReturn.setStatus(SalesBillReturnModel.RETURN);
			billReturn.setSubTotal(billReturn.getProductQuantity()*billReturn.getProductRate());
			dbinsert.insertBillReturn(billReturn);
			for(ProductModel product : productDisplayList2){
				if(product.getProductCode().equals(billReturn.getProductCode())){
					double newqty = product.getQuantity()+billReturn.getProductQuantity();
					int id = product.getProductId();
					dbinsert.updateProduct(id, newqty);
				}
			}
		}

		//for click on Replace button of product return
		if(event.getSource()==button8){
			SalesBillReturnModel billReturn = new SalesBillReturnModel();

			billReturn.setCategoryName(fieldName.getCategoryName(productDisplayList2.get(list1.getSelectedIndex()).getProductName()));
			billReturn.setProductCode(productDisplayList2.get(list1.getSelectedIndex()).getProductCode());
			billReturn.setProductName(productDisplayList2.get(list1.getSelectedIndex()).getProductName());
			billReturn.setProductQuantity(Double.parseDouble(textField9.getText()));
			billReturn.setProductRate(Double.parseDouble(textField10.getText()));
			billReturn.setProductUnit(comboBox4.getSelectedItem().toString());
			billReturn.setReturnDate(textField12.getText());
			billReturn.setFirmId(1);
			billReturn.setStoreId(tableid.getStoreId(comboBox5.getSelectedItem().toString()));
			int startYear = Calendar.getInstance().get(Calendar.YEAR);
			billReturn.setYearId(tableid.getYearId(startYear, startYear+1));
			billReturn.setStatus(SalesBillReturnModel.REPLACE);
			billReturn.setSubTotal(billReturn.getProductQuantity()*billReturn.getProductRate());
			dbinsert.insertBillReturn(billReturn);
		}

		//for click on Refresh button of product return
		if(event.getSource()==button9){
			listModel.removeAllElements();

		}

		//for click on cancel button of bill return & product return
		if(event.getSource()==button10 || event.getSource()==button5){
			this.dispose();
		}
	}




	public void resetFirstTabField(){

		billReturnList = new ArrayList<>();
		loadTable3Data();
		billDetailList = new ArrayList<>();
		loadTable2Data();

		textField5.setText("");
		textField6.setText("");
		textField7.setText("");
		comboBox2.removeAllItems();

	}


	/**
	 * this method is used to show product name in list
	 * @param productTempList
	 */
	private void loadListData(ArrayList<ProductModel> productTempList){

		listModel.removeAllElements();
		for(ProductModel tempProduct : productTempList){ 
			listModel.addElement(tempProduct.getProductName());
		}
		if(list1.getVisibleRowCount()>0){
			list1.setSelectedIndex(0);
		}
	}




	private void loadTable1Data(){
		// for removing all existing rows from table
		//table1.clearSelection();
		while (tableModel1.getRowCount()>0) {
			//System.out.println("row count  = "+tableModel1.getRowCount());
			tableModel1.removeRow(0);
		}

		/// inserting new rows to the table

		for(SalesBillModel bill : billDisplayList){ 
			tableModel1.addRow(new Object[] {bill.getBillNo(),bill.getCustomerName(),bill.getBillDate(),bill.getMobileNo(),bill.getTotalAmt()});

		}


	}

	private void loadTable2Data(){
		// for removing all existing rows from table
		while (tableModel2.getRowCount()>0) {
			tableModel2.removeRow(tableModel2.getRowCount()-1);
		}

		/// inserting new rows to the table

		for(SalesBillDetailModel billDetail : billDetailList){
			double subTotal = billDetail.getProductRate() * billDetail.getProductQuantity();
			tableModel2.addRow(new Object[] {billDetail.getProductCode(),billDetail.getProductName(),
					billDetail.getProductQuantity(),billDetail.getProductUnit(),billDetail.getProductRate(),
					billDetail.getVatPercent(),billDetail.getDiscountAmt(),subTotal});

		}

	}



	private void loadTable3Data(){
		// for removing all existing rows from table
		while (tableModel3.getRowCount()>0) {
			tableModel3.removeRow(0);
		}

		/// inserting new rows to the table
		int i=1;
		for(SalesBillReturnModel billReturn : billReturnList){
			double subTotal = billReturn.getProductRate() * billReturn.getProductQuantity();
			tableModel3.addRow(new Object[] {i,billReturn.getProductName(),billReturn.getProductQuantity(),
					billReturn.getProductRate(),subTotal,billReturn.getDiscountAmt()});
			i++;
		}

	}



	@Override
	public void valueChanged(ListSelectionEvent event) {
		//System.out.println(billDetailList.size()+"  billdet");
		if(event.getSource()==table1.getSelectionModel() && billDisplayList.size() >table1.getSelectedRow() && table1.getSelectedRow()>=0){
			if(table1.getRowCount()>0){
				billDetailList = dbvalue.getBillProductDetail(billDisplayList.get(table1.getSelectedRow()).getBillId());
				loadTable2Data();
			}
		}


		if(event.getSource()==table2.getSelectionModel()){
			if(table2.getRowCount()>0 && table2.getSelectedRow()>=0){
				textField5.setText(billDetailList.get(table2.getSelectedRow()).getProductName());
				textField7.setText(String.valueOf(billDetailList.get(table2.getSelectedRow()).getProductRate()));
				comboBox2.addItem(String.valueOf(billDetailList.get(table2.getSelectedRow()).getVatPercent()));
			}
		}



		if(event.getSource()==list1){
			//System.out.println("sjfhjdhfk");
			if(list1.getVisibleRowCount()>0 && list1.getSelectedIndex()>=0){
				comboBox4.removeAllItems();
				comboBox4.addItem(productDisplayList2.get(list1.getSelectedIndex()).getUnit());
				double rate = productDisplayList2.get(list1.getSelectedIndex()).getSaleRate();
				textField10.setText(String.valueOf(rate));
				double quantity = 0;
				if(!valid.isEmpty(textField9.getText()))
					quantity = Double.parseDouble(textField9.getText());
				textField11.setText(String.valueOf(quantity*rate));
			}
		}

	}




	private void setBillReturnModel(){
		String returnDate = new DatePicker().getCurrentDate();
		SalesBillDetailModel billDetail = billDetailList.get(table2.getSelectedRow());
		for(SalesBillReturnModel billReturn : billReturnList){
			if(billReturn.getProductCode().equals(billDetail.getProductCode()) &&
					billReturn.getProductName().equals(billDetail.getProductName())){
				return;
			}
		}
		SalesBillReturnModel billReturn = new SalesBillReturnModel();

		billReturn.setReturnId(0);
		billReturn.setBillDate(billList.get(table1.getSelectedRow()).getBillDate());
		billReturn.setBillDetailId(billDetail.getBillDetailId());
		billReturn.setBillId(billDetail.getBillId());
		billReturn.setBillNo(billList.get(table1.getSelectedRow()).getBillNo());
		billReturn.setProductCode(billDetail.getProductCode());
		billReturn.setProductName(billDetail.getProductName());
		billReturn.setProductRate(billDetail.getProductRate());
		billReturn.setStatus(SalesBillReturnModel.RETURN);
		billReturn.setProductType(billDetail.getProductType());
		billReturn.setProductQuantity(Double.parseDouble(textField6.getText()));
		billReturn.setReason("");
		billReturn.setReturnDate(returnDate);


		billReturn.setVatPercent(billDetail.getVatPercent());
		billReturn.setVatAmt(billDetail.getVatAmt());
		billReturn.setDiscountPercent(billDetail.getVatPercent());
		billReturn.setDiscountAmt(billDetail.getDiscountAmt());
		billReturn.setBatchNo(billDetail.getBatchNo());
		billReturn.setCategoryName(billDetail.getCategoryName());


		billReturn.setProductUnit(billDetail.getProductUnit());
		billReturn.setSubTotal(billReturn.getProductQuantity()*billReturn.getProductRate());
		billReturn.setFirmId(1);
		billReturn.setStoreId(tableid.getStoreId(comboBox1.getSelectedItem().toString()));
		int startYear = Calendar.getInstance().get(Calendar.YEAR);
		billReturn.setYearId(tableid.getYearId(startYear, startYear+1));
		billReturnList.add(billReturn);
	}

	@Override
	public void focusGained(FocusEvent event) {
		if(event.getSource()==textField1 || event.getSource()==textField2 || event.getSource()==textField3 || event.getSource()==textField4){
			billDisplayList = new ArrayList<>();
			resetFirstTabField();

		}

	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub

	}

}
