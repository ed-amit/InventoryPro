package com.lrd.inventory.ui;

import java.awt.Color;
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

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.lrd.inventory.database.DatabaseInsert;
import com.lrd.inventory.database.GetDBValue;
import com.lrd.inventory.database.SpecificFieldValue;
import com.lrd.inventory.database.TableId;
import com.lrd.inventory.main.DatePicker;
import com.lrd.inventory.main.Validate;
import com.lrd.inventory.model.DistributorModel;
import com.lrd.inventory.model.ProductModel;
import com.lrd.inventory.model.PurchaseBillDetailModel;
import com.lrd.inventory.model.PurchaseBillModel;


/**
 * @author Dharm
 *
 */

public class PurchaseBill extends JFrame
implements
ActionListener,
ListSelectionListener,
ItemListener,
KeyListener,
FocusListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel1;
	private JSeparator separator1;
	private JSeparator separator2;

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
	private JLabel label19;
	private JLabel label20;
	private JLabel label21;
	private JLabel label22;
	private JLabel label23;
	private JLabel label24;
	private JLabel label25;
	private JLabel label26;
	private JLabel label27;
	private JLabel label28;
	private JLabel label29;
	private JLabel label30;
	private JLabel label31;
	private JLabel label32;
	private JLabel label33;
	private JLabel label34;
	private JLabel label35;
	private JLabel label36;
	private JLabel label37;
	private JLabel label38;
	private JLabel label39;
	private JLabel label40;
	private JLabel label41;

	private JComboBox<Object> comboBox1;
	private JComboBox<Object> comboBox2;
	private JComboBox<Object> comboBox3;
	private JComboBox<Object> comboBox4;
	private JComboBox<Object> comboBox5;
	private JComboBox<Object> comboBox6;
	private JComboBox<Object> comboBox7;
	private JComboBox<Object> comboBox8;

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
	private JTextField textField13;
	private JTextField textField14;
	private JTextField textField15;
	private JTextField textField16;
	private JTextField textField17;
	private JTextField textField18;
	private JTextField textField19;
	private JTextField textField20;
	private JTextField textField21;
	private JTextField textField22;
	private JTextField textField23;
	private JTextField textField24;
	private JTextField textField25;
	private JTextField textField26;
	private JTextField textField27;
	private JTextField textField28;
	private JTextField textField29;
	private JTextField textField30;

	private JScrollPane scrollPane1;
	private JScrollPane scrollPane2;
	private JScrollPane scrollPane3;
	private JScrollPane scrollPane4;

	private JTextArea textArea1;

	private DefaultListModel<String> listModel1;
	private JList<String> list1;
	private DefaultListModel<String> listModel2;
	private JList<String> list2;

	private DefaultTableModel tableModel1;
	private JTable table1;

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

	Connection connection = null;
	SpecificFieldValue fieldName = null;
	TableId tableid = null;
	DatabaseInsert dbinsert = null;
	GetDBValue dbvalue = null;
	Validate valid = null;

	DistributorModel distributor = null;
	ArrayList<DistributorModel> distributorList = null;
	ArrayList<DistributorModel> distributorDisplayList = null;

	ProductModel product = null;
	ArrayList<ProductModel> productList = null;
	ArrayList<ProductModel> productDisplayList = null;

	PurchaseBillModel purchaseBill = null;
	ArrayList<PurchaseBillDetailModel> purchaseBillDetailList = null;

	public PurchaseBill(Connection connection) {
		this.connection = connection;
		fieldName = new SpecificFieldValue(connection);
		tableid = new TableId(connection);
		dbinsert = new DatabaseInsert(connection);
		dbvalue = new GetDBValue(connection);
		valid = new Validate();
		prepareGUI();
		setCurrentDate();
		newBillNo();
		storeName();
		vatPercent();
		// rackName();
		productList = dbvalue.getProductDetail(tableid.getStoreId(comboBox1
				.getSelectedItem().toString()));
		distributorList = dbvalue.getDistributorDetail(tableid
				.getStoreId(comboBox1.getSelectedItem().toString()));
		purchaseBill = new PurchaseBillModel();
		purchaseBillDetailList = new ArrayList<>();
		distributor = new DistributorModel();
	}

	@SuppressWarnings("deprecation")
	private void prepareGUI() {

		panel1 = new JPanel();

		separator1 = new JSeparator();

		separator2 = new JSeparator();

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
		label19 = new JLabel();
		label20 = new JLabel();
		label21 = new JLabel();
		label22 = new JLabel();
		label23 = new JLabel();
		label24 = new JLabel();
		label25 = new JLabel();
		label26 = new JLabel();
		label27 = new JLabel();
		label28 = new JLabel();
		label29 = new JLabel();
		label30 = new JLabel();
		label31 = new JLabel();
		label32 = new JLabel();
		label33 = new JLabel();
		label34 = new JLabel();
		label35 = new JLabel();
		label36 = new JLabel();
		label37 = new JLabel();
		label38 = new JLabel();
		label39 = new JLabel();
		label40 = new JLabel();
		label41 = new JLabel();

		comboBox1 = new JComboBox<>();
		comboBox2 = new JComboBox<>();
		comboBox3 = new JComboBox<>();
		comboBox4 = new JComboBox<>();
		comboBox5 = new JComboBox<>();
		comboBox6 = new JComboBox<>();
		comboBox7 = new JComboBox<>();
		comboBox8 = new JComboBox<>();

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
		textField13 = new JTextField();
		textField14 = new JTextField();
		textField15 = new JTextField();
		textField16 = new JTextField();
		textField17 = new JTextField();
		textField18 = new JTextField();
		textField19 = new JTextField();
		textField20 = new JTextField();
		textField21 = new JTextField();
		textField22 = new JTextField();
		textField23 = new JTextField();
		textField24 = new JTextField();
		textField25 = new JTextField();
		textField26 = new JTextField();
		textField27 = new JTextField();
		textField28 = new JTextField();
		textField29 = new JTextField();
		textField30 = new JTextField();

		scrollPane1 = new JScrollPane();
		scrollPane2 = new JScrollPane();
		scrollPane3 = new JScrollPane();
		scrollPane4 = new JScrollPane();

		textArea1 = new JTextArea();

		listModel1 = new DefaultListModel<>();
		list1 = new JList<>(listModel1);
		listModel2 = new DefaultListModel<>();
		list2 = new JList<>(listModel2);

		tableModel1 = new DefaultTableModel();
		table1 = new JTable(tableModel1);

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

		// ======== panel1 ========
		{
			panel1.setLayout(null);

			// ---- label1 ----
			label1.setText("Select Store");
			panel1.add(label1);
			label1.setBounds(25, 20, 90, 20);
			panel1.add(comboBox1);
			comboBox1.setBounds(125, 20, 150, 20);

			// ---- label2 ----
			label2.setText("Agency Name");
			panel1.add(label2);
			label2.setBounds(25, 50, 90, 20);
			panel1.add(textField1);
			textField1.setBounds(125, 50, 150, 20);
			textField1.addKeyListener(this);
			textField1.setNextFocusableComponent(list1);

			// ------scrollPane 1 --------
			{
				scrollPane1.setViewportView(list1);
				list1.addListSelectionListener(this);
				list1.setNextFocusableComponent(textField6);
			}
			panel1.add(scrollPane1);
			scrollPane1.setBounds(125, 80, 150, 90);

			// ---- label3 ----
			label3.setText("Bill No");
			panel1.add(label3);
			label3.setBounds(300, 50, 75, 20);
			panel1.add(textField2);
			textField2.setBounds(380, 50, 150, 20);

			// ---- label4 ----
			label4.setText("Tin No");
			panel1.add(label4);
			label4.setBounds(300, 80, 75, 20);
			panel1.add(textField3);
			textField3.setBounds(380, 80, 150, 20);

			// ---- label5 ----
			label5.setText("Address");
			panel1.add(label5);
			label5.setBounds(300, 110, 75, 20);
			// ------scrollPane 2 --------
			{
				scrollPane2.setViewportView(textArea1);
			}
			panel1.add(scrollPane2);
			scrollPane2.setBounds(380, 110, 150, 60);

			// ---- label6 ----
			label6.setText("Date");
			panel1.add(label6);
			label6.setBounds(550, 50, 75, 20);
			panel1.add(textField4);
			textField4.setBounds(630, 50, 100, 20);
			// ---- button1 ----
			button1.setText("...");
			panel1.add(button1);
			button1.setBounds(735, 50, 30, 20);
			button1.addActionListener(this);

			// ---- label7 ----
			label7.setText("Contact No");
			panel1.add(label7);
			label7.setBounds(550, 80, 75, 20);
			panel1.add(textField5);
			textField5.setBounds(630, 80, 135, 20);

			// ---- label8 ----
			label8.setText("Payment");
			panel1.add(label8);
			label8.setBounds(550, 110, 75, 20);
			panel1.add(comboBox2);
			comboBox2.setBounds(630, 110, 135, 20);
			comboBox2.addItem("Cash");
			comboBox2.addItem("Bank");
			comboBox2.addItemListener(this);

			// ---------Separator1-------
			panel1.add(separator1);
			separator1.setBounds(0, 180, 780, 5);

			// ---- label9 ----
			label9.setText("Rack");
			panel1.add(label9);
			label9.setBounds(20, 190, 80, 20);
			panel1.add(comboBox3);
			comboBox3.setBounds(20, 210, 80, 20);
			comboBox3.addItemListener(this);

			// ---- label10 ----
			label10.setText("Category");
			panel1.add(label10);
			label10.setBounds(120, 190, 80, 20);
			panel1.add(comboBox4);
			comboBox4.setBounds(120, 210, 80, 20);
			comboBox4.addItemListener(this);

			// ---- label11 ----
			label11.setText("Brand");
			panel1.add(label11);
			label11.setBounds(220, 190, 80, 20);
			panel1.add(comboBox5);
			comboBox5.setBounds(220, 210, 80, 20);
			comboBox5.addItemListener(this);

			// ---- label12 ----
			label12.setText("Product Code");
			panel1.add(label12);
			label12.setBounds(320, 190, 80, 20);
			panel1.add(textField6);
			textField6.setBounds(320, 210, 80, 20);
			textField6.addKeyListener(this);
			textField6.setNextFocusableComponent(list2);

			// ---- label13 ----
			label13.setText("Product");
			panel1.add(label13);
			label13.setBounds(420, 190, 80, 20);
			panel1.add(textField7);
			textField7.setBounds(420, 210, 80, 20);
			textField7.addKeyListener(this);
			textField7.setNextFocusableComponent(list2);

			// ---- label14 ----
			label14.setText("Unit");
			panel1.add(label14);
			label14.setBounds(520, 190, 80, 20);
			panel1.add(comboBox6);
			comboBox6.setBounds(520, 210, 80, 20);

			// ---- label15 ----
			label15.setText("Quantity");
			panel1.add(label15);
			label15.setBounds(620, 190, 80, 20);
			panel1.add(textField8);
			textField8.setBounds(620, 210, 80, 20);

			// ---- label16 ----
			label16.setText("Purchase Price");
			panel1.add(label16);
			label16.setBounds(20, 240, 80, 20);
			panel1.add(textField9);
			textField9.setBounds(20, 260, 80, 20);

			// ---- label17 ----
			label17.setText("MRP");
			panel1.add(label17);
			label17.setBounds(120, 240, 80, 20);
			panel1.add(textField10);
			textField10.setBounds(120, 260, 80, 20);

			// ---- label18 ----
			label18.setText("Discount");
			panel1.add(label18);
			label18.setBounds(220, 240, 80, 20);
			panel1.add(textField11);
			textField11.setBounds(220, 260, 80, 20);

			panel1.add(textField12);
			textField12.setBounds(310, 260, 40, 20);
			// ---- label41 ----
			label41.setText("%");
			panel1.add(label41);
			label41.setBounds(350, 260, 20, 20);

			// ---- label19 ----
			label19.setText("Total Cost");
			panel1.add(label19);
			label19.setBounds(380, 240, 80, 20);
			panel1.add(textField13);
			textField13.setBounds(380, 260, 80, 20);

			// ---- label20 ----
			label20.setText("Free");
			panel1.add(label20);
			label20.setBounds(480, 240, 80, 20);
			panel1.add(textField14);
			textField14.setBounds(480, 260, 80, 20);
			textField14.setNextFocusableComponent(textField15);

			// ------scrollPane 4 --------
			{
				scrollPane4.setViewportView(list2);
				list2.addListSelectionListener(this);
				list2.addFocusListener(this);
				list2.setNextFocusableComponent(textField8);
			}
			panel1.add(scrollPane4);
			scrollPane4.setBounds(580, 260, 150, 80);

			// ---- label21 ----
			label21.setText("Sale Price");
			panel1.add(label21);
			label21.setBounds(20, 290, 80, 20);
			panel1.add(textField15);
			textField15.setBounds(20, 310, 80, 20);

			// ---- label22 ----
			label22.setText("Whole Sale");
			panel1.add(label22);
			label22.setBounds(120, 290, 80, 20);
			panel1.add(textField16);
			textField16.setBounds(120, 310, 80, 20);

			// ---- label23 ----
			label23.setText("Online");
			panel1.add(label23);
			label23.setBounds(220, 290, 80, 20);
			panel1.add(textField17);
			textField17.setBounds(220, 310, 80, 20);

			// ---- label24 ----
			label24.setText("Vat(%)");
			panel1.add(label24);
			label24.setBounds(320, 290, 80, 20);
			panel1.add(comboBox7);
			comboBox7.setBounds(320, 310, 80, 20);
			// ---- label25 ----
			label25.setText("Total (incl. vat)");
			panel1.add(label25);
			label25.setBounds(420, 290, 80, 20);
			panel1.add(textField18);
			textField18.setBounds(420, 310, 80, 20);

			// ---- button2 ----
			button2.setText("Add");
			panel1.add(button2);
			button2.setBounds(20, 350, 100, 30);
			button2.addActionListener(this);
			button2.addKeyListener(this);

			// ---- button3 ----
			button3.setText("Edit");
			panel1.add(button3);
			button3.setBounds(140, 350, 100, 30);
			button3.addActionListener(this);

			// ---- button4 ----
			button4.setText("Remove");
			panel1.add(button4);
			button4.setBounds(260, 350, 100, 30);
			button4.addActionListener(this);

			// ---- button5 ----
			button5.setText("BarCode Generator");
			panel1.add(button5);
			button5.setBounds(380, 350, 100, 30);
			button5.addActionListener(this);

			// ---- button6 ----
			button6.setText("Warrenty Details");
			panel1.add(button6);
			button6.setBounds(500, 350, 100, 30);
			button6.addActionListener(this);

			// ---------Separator1-------
			panel1.add(separator2);
			separator2.setBounds(0, 390, 780, 5);

			tableModel1.addColumn("Product");
			tableModel1.addColumn("Unit");
			tableModel1.addColumn("Quantity");
			tableModel1.addColumn("Mrp");
			tableModel1.addColumn("Discount");
			tableModel1.addColumn("Vat (%)");
			tableModel1.addColumn("Total");
			// ------scrollPane 2 --------
			{
				scrollPane3.setViewportView(table1);
				table1.getSelectionModel().addListSelectionListener(this);
			}
			panel1.add(scrollPane3);
			scrollPane3.setBounds(20, 400, 750, 80);

			// ---- label26 ----
			label26.setText("No of days");
			panel1.add(label26);
			label26.setBounds(20, 500, 100, 20);
			panel1.add(textField19);
			textField19.setBounds(120, 500, 100, 20);

			// ---- label27 ----
			label27.setText("Transportation");
			panel1.add(label27);
			label27.setBounds(20, 530, 100, 20);
			panel1.add(textField20);
			textField20.setBounds(120, 530, 100, 20);

			// ---- label28 ----
			label28.setText("miscellaneous");
			panel1.add(label28);
			label28.setBounds(20, 560, 100, 20);
			panel1.add(textField21);
			textField21.setBounds(120, 560, 100, 20);

			// ---- label29 ----
			label29.setText("LBT (%)");
			panel1.add(label29);
			label29.setBounds(20, 590, 100, 20);
			panel1.add(textField22);
			textField22.setBounds(120, 590, 100, 20);
			// ---- label30 ----
			label30.setText("Vat (%)");
			panel1.add(label30);
			label30.setBounds(20, 620, 100, 20);
			panel1.add(comboBox8);
			comboBox8.setBounds(120, 620, 100, 20);

			// ---- label31 ----
			label31.setText("Paid Amount");
			panel1.add(label31);
			label31.setBounds(240, 500, 100, 20);
			panel1.add(textField23);
			textField23.setBounds(340, 500, 100, 20);

			// ---- label32 ----
			label32.setText("Excise (%)");
			panel1.add(label32);
			label32.setBounds(240, 530, 100, 20);
			panel1.add(textField24);
			textField24.setBounds(340, 530, 100, 20);

			// ---- label33 ----
			label33.setText("Octrai (%)");
			panel1.add(label33);
			label33.setBounds(240, 560, 100, 20);
			panel1.add(textField25);
			textField25.setBounds(340, 560, 100, 20);

			// ---- label34 ----
			label34.setText("CST (%)");
			panel1.add(label34);
			label34.setBounds(240, 590, 100, 20);
			panel1.add(textField26);
			textField26.setBounds(340, 590, 100, 20);

			// ---- label35 ----
			label35.setText("Remaning Amt");
			panel1.add(label35);
			label35.setBounds(460, 500, 100, 20);
			panel1.add(textField27);
			textField27.setBounds(560, 500, 100, 20);

			// ---- label36 ----
			label36.setText("Entry Tax(%)");
			panel1.add(label36);
			label36.setBounds(460, 530, 100, 20);
			panel1.add(textField28);
			textField28.setBounds(560, 530, 100, 20);

			// ---- label37 ----
			label37.setText("Hamali");
			panel1.add(label37);
			label37.setBounds(460, 560, 100, 20);
			panel1.add(textField29);
			textField29.setBounds(560, 560, 100, 20);

			// ---- label38 ----
			label38.setText("Discount(%)");
			panel1.add(label38);
			label38.setBounds(460, 590, 100, 20);
			panel1.add(textField30);
			textField30.setBounds(560, 590, 100, 20);

			// ---- label39 ----
			label39.setText("Total");
			panel1.add(label39);
			label39.setBounds(690, 500, 60, 20);
			// ---- label40 ----
			label40.setText("0.00");
			label40.setForeground(Color.BLUE);
			panel1.add(label40);
			label40.setBounds(690, 520, 60, 20);
			label40.setHorizontalAlignment(SwingConstants.CENTER);

			// ---- button7 ----
			button7.setText("Payment Details");
			panel1.add(button7);
			button7.setBounds(670, 560, 100, 40);
			button7.addActionListener(this);

			// ---- button8 ----
			button8.setText("Save");
			panel1.add(button8);
			button8.setBounds(290, 620, 100, 20);
			button8.addActionListener(this);

			// ---- button9 ----
			button9.setText("Refresh");
			panel1.add(button9);
			button9.setBounds(420, 620, 100, 20);
			button9.addActionListener(this);

			// ---- button10 ----
			button10.setText("Update");
			panel1.add(button10);
			button10.setBounds(560, 620, 100, 20);
			button10.addActionListener(this);

		}
		getContentPane().add(panel1);
		panel1.setBounds(0, 0, 800, 650);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setSize(800, 700);

	}

	public static void main(String[] args) {
		// new PurchaseBill();
	}

	private void newBillNo() {
		textField2.setText(String.valueOf(tableid.getNewPurchaseBillId()));
		textField2.setEnabled(false);
	}

	private void storeName() {
		ArrayList<String> storeNames = (ArrayList<String>) fieldName
				.getAllStoreName();
		for (String name : storeNames) {
			comboBox1.addItem(name);
		}
	}
	
	private void vatPercent() {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		ArrayList<Float> vatPercents = (ArrayList<Float>) fieldName
				.getVatByStartYear(year);
		for (float vat : vatPercents) {
			comboBox8.addItem(vat);
		}
	}

	/*
	 * private void rackName() { //comboBox3.removeAllItems(); int storeId =
	 * tableid.getStoreId(comboBox1.getSelectedItem().toString());
	 * ArrayList<String> rackNames = (ArrayList<String>)
	 * fieldName.getAllRackName(storeId); for (String name : rackNames) {
	 * comboBox3.addItem(name); } }
	 * 
	 * private void categoryName() { //comboBox4.removeAllItems(); int
	 * rackId=tableid.getRackId(comboBox3.getSelectedItem().toString());
	 * ArrayList<String> categoryNames = (ArrayList<String>)
	 * fieldName.getCategoryName(rackId); for (String name : categoryNames) {
	 * comboBox4.addItem(name); } }
	 * 
	 * private void brandName() { //comboBox5.removeAllItems(); int
	 * categoryId=tableid.getCategoryId(comboBox4.getSelectedItem().toString());
	 * ArrayList<String> brandNames = (ArrayList<String>)
	 * fieldName.getBrandName(categoryId); for (String name : brandNames) {
	 * comboBox5.addItem(name); } }
	 */

	private void setCurrentDate() {
		String currentDate = String.valueOf(Calendar.getInstance().get(
				Calendar.YEAR))
				+ "-"
				+ (String
						.valueOf(Calendar.getInstance().get(Calendar.MONTH) + 1))
						+ "-"
						+ String.valueOf(Calendar.getInstance().get(Calendar.DATE));
		textField4.setText(currentDate);
		textField4.setEnabled(false);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent event) {
		// TODO Auto-generated method stub

		// System.out.println(event.getKeyCode());
		if (event.getSource() == button2) {
			if (event.getKeyCode() == 10) {
				button2.doClick();
			}
		}
		if (event.getSource() == textField1) {
			String str = textField1.getText();
			distributorDisplayList = new ArrayList<>();
			if (!valid.isEmpty(str)) {
				for (DistributorModel distributor : distributorList) {
					if (distributor.getAgencyName().contains(str)) {
						distributorDisplayList.add(distributor);
					}
				}
			}
			loadList1data();
		}

		if (event.getSource() == textField6) {
			productDisplayList = new ArrayList<>();
			String tempStr = textField6.getText();
			for (ProductModel tempProduct1 : productList) {
				if (tempProduct1.getProductCode().contains(tempStr)) {
					productDisplayList.add(tempProduct1);
				}
			}
			loadList2Data(productDisplayList);
		}
		if (event.getSource() == textField7) {
			productDisplayList = new ArrayList<>();
			String tempStr = textField7.getText();
			for (ProductModel tempProduct1 : productList) {
				if (tempProduct1.getProductName().contains(tempStr)) {
					productDisplayList.add(tempProduct1);
				}
			}
			loadList2Data(productDisplayList);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	private void loadList1data() {
		listModel1.removeAllElements();
		for (DistributorModel distributor : distributorDisplayList) {
			listModel1.addElement(distributor.getAgencyName());
		}
		if (list1.getVisibleRowCount() > 0) {
			list1.setSelectedIndex(0);
		}
	}

	private void loadList2Data(ArrayList<ProductModel> productTempList) {

		listModel2.removeAllElements();
		for (ProductModel tempProduct : productTempList) {
			listModel2.addElement(tempProduct.getProductName());
		}
		if (list1.getVisibleRowCount() > 0) {
			list1.setSelectedIndex(0);
		}
	}

	private void loadTableData() {
		// TODO
		// for removing all existing rows from table
		while (tableModel1.getRowCount() > 0) {
			tableModel1.removeRow(0);
		}

		// / inserting new rows to the table

		for (PurchaseBillDetailModel billDetail : purchaseBillDetailList) {
			tableModel1.addRow(new Object[]{billDetail.getProductName(),
					billDetail.getUnit(), billDetail.getQuantity(),
					billDetail.getMRP(), billDetail.getDiscount(),
					billDetail.getVatPercent(), billDetail.getTotalCost()});

		}
	}

	@Override
	public void itemStateChanged(ItemEvent event) {
		// TODO Auto-generated method stub
		if (event.getStateChange() == ItemEvent.SELECTED) {
			if (event.getSource() == comboBox1) {
				distributorList = dbvalue.getDistributorDetail(tableid
						.getStoreId(comboBox1.getSelectedItem().toString()));
				productList = dbvalue.getProductDetail(tableid
						.getStoreId(comboBox1.getSelectedItem().toString()));

				// reset the topmost panel part
				// resetAllWindow();
			}

		}
	}

	@Override
	public void valueChanged(ListSelectionEvent event) {
		// TODO Auto-generated method stub
		if (event.getSource() == list1) {
			if(list1.getVisibleRowCount()>0 && list1.getSelectedIndex()>=0){
				distributor = distributorDisplayList.get(list1.getSelectedIndex());
				textField3.setText(distributor.getTinNo());
				textField5.setText(distributor.getMobileNo());
				textArea1.setText(distributor.getAddress());
			}
		}
		if (event.getSource() == list2 && list2.getSelectedIndex() >= 0) {
			int rackId = productDisplayList.get(list2.getSelectedIndex())
					.getRackId();
			int categoryId = productDisplayList.get(list2.getSelectedIndex())
					.getCategoryId();
			int brandId = productDisplayList.get(list2.getSelectedIndex())
					.getBrandId();

			comboBox3.removeAllItems();
			comboBox3.addItem(fieldName.getRackName(rackId));
			comboBox4.removeAllItems();
			comboBox4.addItem(fieldName.getCategoryNameByID(categoryId));
			comboBox5.removeAllItems();
			comboBox5.addItem(fieldName.getBrandNameById(brandId));
			textField6.setText(productDisplayList.get(list2.getSelectedIndex())
					.getProductCode());
			textField7.setText(productDisplayList.get(list2.getSelectedIndex())
					.getProductName());
			comboBox6.removeAllItems();
			comboBox6.addItem(productDisplayList.get(list2.getSelectedIndex())
					.getUnit());
			textField9.setText(String.valueOf(productDisplayList.get(
					list2.getSelectedIndex()).getPurchaseRate()));
			textField10.setText(String.valueOf(productDisplayList.get(
					list2.getSelectedIndex()).getMRP()));
			textField15.setText(String.valueOf(productDisplayList.get(
					list2.getSelectedIndex()).getSaleRate()));
			textField16.setText(String.valueOf(productDisplayList.get(
					list2.getSelectedIndex()).getWholesaleRate()));
			textField17.setText(String.valueOf(productDisplayList.get(
					list2.getSelectedIndex()).getOnlineRate()));
			comboBox7.removeAllItems();
			comboBox7.addItem(String.valueOf(productDisplayList.get(
					list2.getSelectedIndex()).getVatPercent()));
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if (event.getSource() == button1) {
			final JFrame f = new JFrame();
			textField4.setText(new DatePicker(f).setPickedDate());
		}
		if (event.getSource() == button2) {
			addProductToBill();
			resetProductPanel();
		}
		if (event.getSource() == button3) {
			editProductToBill();
		}
		if (event.getSource() == button4) {
			removeProductFromBill();

		}
		if (event.getSource() == button5) {

		}
		if (event.getSource() == button6) {

		}
		if (event.getSource() == button7) {
			
		}
		if (event.getSource() == button8) {
			saveBill();
		}
		if (event.getSource() == button9) {
			resetAllWindow();
		}
		if (event.getSource() == button10) {

		}

	}

	private void editProductToBill() {
		// TODO Auto-generated method stub
		resetProductPanel();
		PurchaseBillDetailModel detail = purchaseBillDetailList.get(table1.getSelectedRow());
		textField10.setText(String.valueOf(detail.getMRP()));
		comboBox7.addItem(String.valueOf(detail.getVatPercent()));
		textField9.setText(String.valueOf(detail.getPurchasePrice()));
		textField8.setText(String.valueOf(detail.getQuantity()));
		textField11.setText(String.valueOf(detail.getDiscount()));
		textField14.setText(String.valueOf(detail.getFreeProduct()));
		textField17.setText(String.valueOf(detail.getOnlineSaleRate()));
		textField16.setText(String.valueOf(detail.getWholeSalePrice()));
		textField15.setText(String.valueOf(detail.getSaleRate()));
		textField6.setText(detail.getProductCode());
		textField6.setText(detail.getProductName());
		comboBox6.addItem(detail.getUnit());
		purchaseBillDetailList.remove(table1.getSelectedRow());
		label40.setText(String.valueOf(Double.parseDouble(label40.getText())-detail.getTotalCost()));
	}

	private void saveBill() {
		// TODO Auto-generated method stub
		purchaseBill = new PurchaseBillModel();
		double totalMrp=0;
		for(PurchaseBillDetailModel detail : purchaseBillDetailList){
			totalMrp+=detail.getMRP();
		}

		double cstPercent = Double.parseDouble(textField26.getText());
		double cstAmt=(totalMrp*cstPercent)/100;
		double discountPercent = Double.parseDouble(textField30.getText());
		double discountAmt = (totalMrp*discountPercent)/100;
		double EntryTaxPercent = Double.parseDouble(textField28.getText());
		double EntryAmt = (totalMrp*EntryTaxPercent)/100;
		double excisePercent = Double.parseDouble(textField24.getText());
		double exciseAmt = (totalMrp*excisePercent)/100;
		double lbtPercent = Double.parseDouble(textField21.getText());
		double lbtAmt = (totalMrp*lbtPercent)/100;
		double octraiPercent = Double.parseDouble(textField25.getText());
		double octraiAmt = (totalMrp*octraiPercent)/100;
		double vatPercent = Double.parseDouble(comboBox8.getSelectedItem().toString());
		double vatAmt = (totalMrp*vatPercent)/100;

		purchaseBill.setBillId(0);
		purchaseBill.setAddress(textArea1.getText());
		purchaseBill.setAgencyName(textField1.getText());
		purchaseBill.setContactNo(textField5.getText());
		purchaseBill.setBillNo(textField2.getText());
		purchaseBill.setCess(0);
		purchaseBill.setCstPercent(cstPercent);
		purchaseBill.setCstAmount(cstAmt);
		purchaseBill.setDiscount(discountAmt);
		purchaseBill.setEntryTax(EntryAmt);
		purchaseBill.setExciseAmount(exciseAmt);
		purchaseBill.setExcisePercent(excisePercent);
		purchaseBill.setGrandTotal(Double.parseDouble(label40.getText()));
		purchaseBill.setHamali(Double.parseDouble(textField29.getText()));
		purchaseBill.setLbtAmount(lbtAmt);
		purchaseBill.setLbtPercent(lbtPercent);
		purchaseBill.setMiscellaneous(Double.parseDouble(textField21.getText()));
		purchaseBill.setNoOfDays(Integer.parseInt(textField19.getText()));
		purchaseBill.setOctraiAmt(octraiAmt);
		purchaseBill.setPaidAmount(Double.parseDouble(textField23.getText()));
		purchaseBill.setPaymentMode(comboBox2.getSelectedItem().toString());
		purchaseBill.setPurchaseDate(textField4.getText());
		purchaseBill.setTinNo(textField3.getText());
		purchaseBill.setTransportationAmt(Double.parseDouble(textField20.getText()));
		purchaseBill.setVatAmount(vatAmt);
		purchaseBill.setVatPercent(vatPercent);
		purchaseBill.setDistributorId(distributorDisplayList.get(list1.getSelectedIndex()).getDistributorId());
		purchaseBill.setStoreId(tableid.getStoreId(comboBox1.getSelectedItem().toString()));
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		purchaseBill.setYearId(tableid.getYearId(currentYear,currentYear+1));

		int billId=dbinsert.insertPurchaseBill(purchaseBill);

		for(PurchaseBillDetailModel detail : purchaseBillDetailList){
			detail.setPurchaseBillId(billId);
			dbinsert.insertPurchaseBillDetail(detail);
		}
		resetAllWindow();
		newBillNo();
	}

	private void removeProductFromBill() {
		// TODO Auto-generated method stub
		if(table1.getSelectedRow()>=0){
			int row = table1.getSelectedRow();
			label40.setText(String.valueOf(Double.parseDouble(label40.getText())-purchaseBillDetailList.get(row).getTotalCost()));
			purchaseBillDetailList.remove(row);
			loadTableData();
		}
	}

	private void addProductToBill() {
		// TODO Auto-generated method stub
		PurchaseBillDetailModel detail = new PurchaseBillDetailModel();

		double mrp = Double.parseDouble(textField10.getText());
		double vatPercent = Double.parseDouble(comboBox7.getSelectedItem()
				.toString());
		double vatAmount = (mrp * vatPercent) / 100;
		double purchasePrice = Double.parseDouble(textField9.getText());
		double qty = Double.parseDouble(textField8.getText());
		double discount = Double.parseDouble(textField11.getText());
		double totalAmount = ((purchasePrice * qty) - discount) + vatAmount;

		detail.setPurchaseDetailId(0);
		detail.setDiscount(discount);
		detail.setFreeProduct(Double.parseDouble(textField14.getText()));
		detail.setMRP(mrp);
		detail.setOnlineSaleRate(Double.parseDouble(textField17.getText()));
		detail.setProductCode(textField6.getText());
		detail.setProductImange("");
		detail.setProductName(textField7.getText());
		detail.setPurchasePrice(purchasePrice);
		detail.setQuantity(qty);
		detail.setSaleRate(Double.parseDouble(textField15.getText()));
		detail.setTotalCost(totalAmount);
		detail.setUnit(comboBox6.getSelectedItem().toString());
		detail.setVatAmount(vatAmount);
		detail.setVatPercent(vatPercent);
		detail.setWholeSalePrice(Double.parseDouble(textField16.getText()));
		detail.setPurchaseBillId(Integer.parseInt(textField2.getText()));
		label40.setText(String.valueOf(Double.parseDouble(label40.getText())+detail.getTotalCost()));

		purchaseBillDetailList.add(detail);
		loadTableData();
	}

	@Override
	public void focusGained(FocusEvent event) {

		// TODO Auto-generated method stub
		if (event.getSource() == list1) {
			distributor = distributorDisplayList.get(list1.getSelectedIndex());
			textField3.setText(distributor.getTinNo());
			textField5.setText(distributor.getMobileNo());
			textArea1.setText(distributor.getAddress());
		}

		if (event.getSource() == list2) {
			list2.setSelectedIndex(0);
			// System.out.println("sjdfhjdghkfjglkfjglhf");
			int rackId = productDisplayList.get(list2.getSelectedIndex())
					.getRackId();
			int categoryId = productDisplayList.get(list2.getSelectedIndex())
					.getCategoryId();
			int brandId = productDisplayList.get(list2.getSelectedIndex())
					.getBrandId();

			comboBox3.removeAllItems();
			comboBox3.addItem(fieldName.getRackName(rackId));
			comboBox4.removeAllItems();
			comboBox4.addItem(fieldName.getCategoryNameByID(categoryId));
			comboBox5.removeAllItems();
			comboBox5.addItem(fieldName.getBrandNameById(brandId));
			textField6.setText(productDisplayList.get(list2.getSelectedIndex())
					.getProductCode());
			textField7.setText(productDisplayList.get(list2.getSelectedIndex())
					.getProductName());
			comboBox6.removeAllItems();
			comboBox6.addItem(productDisplayList.get(list2.getSelectedIndex())
					.getUnit());
			textField9.setText(String.valueOf(productDisplayList.get(
					list2.getSelectedIndex()).getPurchaseRate()));
			textField10.setText(String.valueOf(productDisplayList.get(
					list2.getSelectedIndex()).getMRP()));
			textField15.setText(String.valueOf(productDisplayList.get(
					list2.getSelectedIndex()).getSaleRate()));
			textField16.setText(String.valueOf(productDisplayList.get(
					list2.getSelectedIndex()).getWholesaleRate()));
			textField17.setText(String.valueOf(productDisplayList.get(
					list2.getSelectedIndex()).getOnlineRate()));
			comboBox7.removeAllItems();
			comboBox7.addItem(String.valueOf(productDisplayList.get(
					list2.getSelectedIndex()).getVatPercent()));

		}
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub

	}

	private void resetAllWindow() {
		comboBox1.setSelectedIndex(0);
		textField1.setText("");
		distributorDisplayList = new ArrayList<>();
		loadList1data();
		textField3.setText("");
		textArea1.setText("");
		textField5.setText("");
		comboBox2.setSelectedIndex(0);
		resetProductPanel();
		purchaseBillDetailList = new ArrayList<>();
		loadTableData();
		textField19.setText("");
		textField20.setText("");
		textField21.setText("");
		textField22.setText("");
		textField23.setText("");
		textField24.setText("");
		textField25.setText("");
		textField26.setText("");
		textField27.setText("");
		textField28.setText("");
		textField29.setText("");
		textField30.setText("");
		label40.setText("0.00");
		newBillNo();
	}

	private void resetProductPanel() {
		comboBox3.removeAllItems();
		comboBox4.removeAllItems();
		comboBox5.removeAllItems();
		textField6.setText("");
		textField7.setText("");
		comboBox6.removeAllItems();
		textField8.setText("");
		textField9.setText("");
		textField10.setText("");
		textField11.setText("");
		textField12.setText("");
		textField13.setText("");
		textField14.setText("");
		productDisplayList = new ArrayList<>();
		loadList2Data(productDisplayList);
		textField15.setText("");
		textField16.setText("");
		textField17.setText("");
		textField18.setText("");
		comboBox7.removeAllItems();
	}

}
