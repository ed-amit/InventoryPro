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
import com.lrd.inventory.main.PromptDailog;
import com.lrd.inventory.main.Validate;
import com.lrd.inventory.main.ValidationMSG;
import com.lrd.inventory.model.BillDetailModel;
import com.lrd.inventory.model.ChallanDetailModel;
import com.lrd.inventory.model.ChallanModel;
import com.lrd.inventory.model.OtherChargesModel;
import com.lrd.inventory.model.SaleOrderDetailModel;
import com.lrd.inventory.model.SaleOrderModel;
import com.lrd.inventory.model.SaleQuotationDetailModel;
import com.lrd.inventory.model.SaleQuotationModel;
import com.lrd.inventory.model.SalesBillModel;
import com.lrd.inventory.model.PaymentModel;
import com.lrd.inventory.model.CreditorModel;
import com.lrd.inventory.model.ProductModel;
import com.lrd.inventory.model.SalesBillDetailModel;
import com.lrd.inventory.print.PrintBill;

/**
 * @author dharmendra singh
 */
public class SalesBill extends JFrame
		implements
			ItemListener,
			KeyListener,
			ActionListener,
			ListSelectionListener,
			FocusListener {

	private static final long serialVersionUID = 1L;
	// Variables declaration -

	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private JPanel panel6;
	private JPanel panel7;
	private JPanel panel8;
	private JPanel panel9;
	private JPanel panel10;
	private JPanel panel11;

	private JScrollPane scrollPane1;
	private JScrollPane scrollPane2;
	private JScrollPane scrollPane3;
	private JScrollPane scrollPane4;

	private DefaultTableModel tableModel1;
	private JTable table1;
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

	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;

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
	private JTextField textField23;

	private JTextArea textArea1;

	ButtonGroup bg;
	private JRadioButton radioButton1;
	private JRadioButton radioButton2;
	private JRadioButton radioButton3;
	private JRadioButton radioButton4;

	private JComboBox<Object> comboBox1;
	private JComboBox<Object> comboBox2;
	private JComboBox<Object> comboBox3;
	private JComboBox<Object> comboBox4;
	private JComboBox<Object> comboBox5;
	private JComboBox<Object> comboBox6;
	private JComboBox<Object> comboBox7;
	private JComboBox<Object> comboBox8;
	private JComboBox<Object> comboBox9;

	private JCheckBox checkBox1;
	private JCheckBox checkBox2;
	private JCheckBox checkBox3;

	private DefaultListModel<String> listModel;
	private JList<String> list1;
	private DefaultTableModel tableModel2;
	private JTable table2;
	private JSeparator separator1;
	// End of variables declaration

	private int WIDTH;
	private int HEIGHT;
	private String userName;

	Connection connection = null;

	SpecificFieldValue fieldName = null;
	TableId tableid = null;
	DatabaseInsert dbinsert = null;
	Validate valid = null;
	GetDBValue dbValue = null;

	ArrayList<ProductModel> productList = null;
	ArrayList<ProductModel> productDisplayList = null;

	ArrayList<BillDetailModel> billDetailList = null;
	ArrayList<OtherChargesModel> OtherChargesList = null;
	ArrayList<CreditorModel> creditors;

	int itemCount = 0;
	double netAmount = 0;
	double totalAmount = 0;

	// constructor for class
	public SalesBill(Connection connection, String userName, int billType) {
		this.connection = connection;
		this.userName = userName;
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		WIDTH = screenSize.width;
		HEIGHT = screenSize.height;
		fieldName = new SpecificFieldValue(connection);
		tableid = new TableId(connection);
		dbinsert = new DatabaseInsert(connection);
		valid = new Validate();
		dbValue = new GetDBValue(connection);
		billDetailList = new ArrayList<>();
		OtherChargesList = new ArrayList<>();
		initComponents();
		storeName();
		productList = dbValue.getProductDetail(tableid.getStoreId(comboBox2
				.getSelectedItem().toString()));
		vatPercent();
		unitName();
		creditors = dbValue.getCreditorDetail(tableid.getStoreId(comboBox2
				.getSelectedItem().toString()));
		creditCustomerName();
		comboBox3.setSelectedIndex(billType);
		textField10.requestFocus();

	}

	// creating UI for Frame
	private void initComponents() {
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		panel6 = new JPanel();
		panel7 = new JPanel();
		panel8 = new JPanel();
		panel9 = new JPanel();
		panel10 = new JPanel();
		panel11 = new JPanel();

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

		scrollPane1 = new JScrollPane();
		scrollPane2 = new JScrollPane();
		scrollPane3 = new JScrollPane();
		scrollPane4 = new JScrollPane();

		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		button5 = new JButton();
		button6 = new JButton();

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
		textField23 = new JTextField();

		textArea1 = new JTextArea();

		bg = new ButtonGroup();
		radioButton1 = new JRadioButton();
		radioButton2 = new JRadioButton();
		radioButton3 = new JRadioButton();
		radioButton4 = new JRadioButton();

		comboBox1 = new JComboBox<Object>();
		comboBox2 = new JComboBox<Object>();
		comboBox3 = new JComboBox<Object>();
		comboBox4 = new JComboBox<Object>();
		comboBox5 = new JComboBox<Object>();
		comboBox6 = new JComboBox<Object>();
		comboBox7 = new JComboBox<Object>();
		comboBox8 = new JComboBox<Object>();
		comboBox9 = new JComboBox<Object>();

		checkBox1 = new JCheckBox();
		checkBox2 = new JCheckBox();
		checkBox3 = new JCheckBox();

		listModel = new DefaultListModel<>();
		list1 = new JList<String>(listModel);

		tableModel1 = new DefaultTableModel();
		table1 = new JTable(tableModel1);
		tableModel2 = new DefaultTableModel();
		table2 = new JTable(tableModel2);
		separator1 = new JSeparator();

		// ======== this ========
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		// ======== panel1 ========
		{
			panel1.setLayout(null);
			// panel1.setBackground(Color.GREEN);

			// ======== panel2 ========
			{
				panel2.setLayout(null);

				// ---- label27 ----
				label27.setText("Ferm Name");
				label27.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
				panel2.add(label27);
				label27.setBounds(30, 20, 400, 50);

				// ---- label26 ----
				label26.setText("Generate Bill");
				label26.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 30));
				panel2.add(label26);
				label26.setBounds(WIDTH / 2 - 100, 20, 200, 50);

				// ---- label11 ----
				label11.setText("User Name  :  ");
				panel2.add(label11);
				label11.setBounds(WIDTH - 220, 10, 100, 20);

				// ---- label13 ----
				label13.setText("Test User");
				panel2.add(label13);
				label13.setBounds(WIDTH - 120, 10, 100, 20);

				// ---- label12 ----
				label12.setText("Date            :");
				panel2.add(label12);
				label12.setBounds(WIDTH - 220, 40, 100, 20);

				panel2.add(textField8);
				textField8.setBounds(WIDTH - 120, 40, 100, 20);
				textField8.setText(new DatePicker().getCurrentDate());
				// textField8.setEnabled(false);
				textField8.setFocusable(false);

			}
			panel1.add(panel2);
			panel2.setBounds(0, 0, WIDTH, 70);

			panel1.add(separator1);
			separator1.setBounds(0, 70, WIDTH, 5);

			// ======== panel3
			// ========================================================
			{
				panel3.setLayout(null);
				// panel3.setBackground(Color.GREEN);

				tableModel1.addColumn("Sr.");
				tableModel1.addColumn("Code");
				tableModel1.addColumn("Name");
				tableModel1.addColumn("Qty");
				tableModel1.addColumn("Unit");
				tableModel1.addColumn("MRP");
				// ======== scrollPane1 ========
				{
					scrollPane1.setViewportView(table1);
				}
				panel3.add(scrollPane1);
				scrollPane1.setBounds(5, 5, 395, 370);

				// ---- label1 ----
				label1.setText("Total Item   :   ");
				panel3.add(label1);
				label1.setBounds(5, 375, 100, 20);

				// ---- label2 ----
				label2.setText("0");
				label2.setForeground(new Color(0, 0, 255));
				panel3.add(label2);
				label2.setBounds(105, 375, 100, 20);

			}
			panel1.add(panel3);
			panel3.setBounds(0, 70, 400, 400);
			// ===========end of panel3
			// ==============================================

			// ======== panel4
			// ===========================================================
			{
				panel4.setBorder(UIManager.getBorder("TitledBorder.border"));
				panel4.setLayout(null);

				// ---- label3 ----
				label3.setText("Net Amount");
				panel4.add(label3);
				label3.setBounds(10, 10, 100, 20);

				panel4.add(textField1);
				textField1.setBounds(110, 10, 80, 20);

				// ---- label4 ----
				label4.setText("Vat %");
				panel4.add(label4);
				label4.setBounds(10, 40, 100, 20);

				panel4.add(comboBox1);
				comboBox1.setBounds(110, 40, 80, 20);
				comboBox1.addItemListener(this);

				// ---- label5 ----
				label5.setText("Total Amount");
				panel4.add(label5);
				label5.setBounds(10, 70, 100, 20);

				panel4.add(textField2);
				textField2.setBounds(110, 70, 80, 20);

				// ---- label6 ----
				label6.setText("Credit Amount");
				panel4.add(label6);
				label6.setBounds(10, 100, 100, 20);

				panel4.add(textField3);
				textField3.setBounds(110, 100, 80, 20);

				// ---- label7 ----
				label7.setText("Debit Amount");
				panel4.add(label7);
				label7.setBounds(10, 130, 100, 20);

				panel4.add(textField4);
				textField4.setBounds(110, 130, 80, 20);
				textField4.addKeyListener(this);

				// ---- label8 ----
				label8.setText("Total Vat");
				panel4.add(label8);
				label8.setBounds(220, 10, 80, 20);

				panel4.add(textField5);
				textField5.setBounds(300, 10, 80, 20);

				// ---- label9 ----
				label9.setText("Discount (Rs)");
				panel4.add(label9);
				label9.setBounds(220, 40, 80, 20);

				panel4.add(textField6);
				textField6.setBounds(300, 40, 80, 20);
				textField6.addKeyListener(this);

				// ---- label10 ----
				label10.setText("%");
				panel4.add(label10);
				label10.setBounds(280, 70, 20, 20);

				panel4.add(textField7);
				textField7.setBounds(300, 70, 80, 20);
				textField7.addKeyListener(this);

			}
			panel1.add(panel4);
			panel4.setBounds(5, 470, 395, 160);
			// ===============End of panel4============================

			// ======== panel5 =====================================
			{
				panel5.setBorder(UIManager.getBorder("TitledBorder.border"));
				panel5.setLayout(null);

				// ---- label14 ----
				label14.setText("Store Name");
				panel5.add(label14);
				label14.setBounds(10, 5, 100, 20);

				panel5.add(comboBox2);
				comboBox2.setBounds(110, 5, 390, 20);
				comboBox2.addItemListener(this);

				panel5.add(comboBox3);
				comboBox3.setBounds(10, 30, 250, 20);
				comboBox3.addItem("Sale Bill");
				comboBox3.addItem("Challan");
				comboBox3.addItem("Sale Order");
				comboBox3.addItem("Sale Quotation");
				comboBox3.addItemListener(this);

				// ---- label19 ----
				label19.setText("bill No.");
				panel5.add(label19);
				label19.setBounds(320, 30, 80, 20);

				panel5.add(textField9);
				textField9.setBounds(400, 30, 100, 20);
				textField9.setEnabled(false);
				// textField9.setText("345");///////need to be change

				// ---- label15 ----
				label15.setText("Customer Type");
				panel5.add(label15);
				label15.setBounds(10, 55, 100, 20);

				// ---- radioButton1 ----
				radioButton1.setText("General Customer");
				panel5.add(radioButton1);
				radioButton1.setBounds(110, 55, 150, 20);
				radioButton1.setSelected(true);
				bg.add(radioButton1);
				radioButton1.addItemListener(this);

				// ---- radioButton2 ----
				radioButton2.setText("Credit Customer");
				panel5.add(radioButton2);
				radioButton2.setBounds(110, 80, 150, 20);
				bg.add(radioButton2);
				radioButton2.addItemListener(this);

				panel5.add(comboBox4);
				comboBox4.setBounds(270, 80, 230, 20);
				comboBox4.setEnabled(false);
				comboBox4.addItemListener(this);

				// ---- label16 ----
				label16.setText("Customer Name");
				panel5.add(label16);
				label16.setBounds(10, 105, 100, 20);

				panel5.add(textField10);
				textField10.setBounds(110, 105, 150, 20);

				// ---- label20 ----
				label20.setText("Address");
				panel5.add(label20);
				label20.setBounds(270, 105, 80, 20);

				// ======== scrollPane2 ========
				{
					scrollPane2.setViewportView(textArea1);
				}
				panel5.add(scrollPane2);
				scrollPane2.setBounds(350, 105, 150, 45);

				// ---- label17 ----
				label17.setText("Mobile No");
				panel5.add(label17);
				label17.setBounds(10, 130, 100, 20);

				panel5.add(textField11);
				textField11.setBounds(110, 130, 150, 20);

				// ---- label18 ----
				label18.setText("Credit Balance");
				panel5.add(label18);
				label18.setBounds(10, 155, 100, 20);

				panel5.add(textField12);
				textField12.setBounds(110, 155, 150, 20);

				// ---- label21 ----
				label21.setText("Debit Balance");
				panel5.add(label21);
				label21.setBounds(270, 155, 80, 20);

				panel5.add(textField13);
				textField13.setBounds(350, 155, 150, 20);

				// ---- label22 ----
				label22.setText("Sale Type");
				panel5.add(label22);
				label22.setBounds(550, 5, 80, 20);

				panel5.add(comboBox5);
				comboBox5.setBounds(630, 5, 150, 20);
				comboBox5.setEnabled(false);

				// ---- label23 ----
				label23.setText("Payment");
				panel5.add(label23);
				label23.setBounds(550, 30, 80, 20);

				panel5.add(comboBox6);
				comboBox6.setBounds(630, 30, 150, 20);
				comboBox6.addItem("Cash");
				comboBox6.addItem("Bank");
				comboBox6.addItem("Credit");
				comboBox6.addItemListener(this);

				// ---- label24 ----
				label24.setText("Bank Name");
				panel5.add(label24);
				label24.setBounds(550, 55, 80, 20);

				panel5.add(textField14);
				textField14.setBounds(630, 55, 150, 20);
				textField14.setEnabled(false);

				// ---- label25 ----
				label25.setText("Code");
				panel5.add(label25);
				label25.setBounds(550, 80, 80, 20);

				panel5.add(textField15);
				textField15.setBounds(630, 80, 150, 20);
				textField15.setEnabled(false);

				// ---- checkBox1 ----
				checkBox1.setText("Home Delivery");
				panel5.add(checkBox1);
				checkBox1.setBounds(630, 105, 150, 20);

			}
			panel1.add(panel5);
			panel5.setBounds(WIDTH - 800, 75, 790, 190);
			// ===========end of panel5=================================

			// ======== panel6 ========================================
			{
				panel6.setBorder(UIManager.getBorder("TitledBorder.border"));
				panel6.setLayout(null);

				// ---- label28 ----
				label28.setText("Product Code");
				panel6.add(label28);
				label28.setBounds(10, 5, 100, 20);

				panel6.add(textField16);
				textField16.setBounds(110, 5, 150, 20);
				textField16.addKeyListener(this);

				// ---- label34 ----
				label34.setText("Product Name");
				panel6.add(label34);
				label34.setBounds(270, 5, 80, 20);

				panel6.add(textField21);
				textField21.setBounds(350, 5, 150, 20);
				textField21.addKeyListener(this);

				// ---- label29 ----
				label29.setText("Batch No");
				panel6.add(label29);
				label29.setBounds(10, 30, 100, 20);

				panel6.add(textField17);
				textField17.setBounds(110, 30, 150, 20);

				// ---- checkBox2 ----
				checkBox2.setText("Use Batch No");
				panel6.add(checkBox2);
				checkBox2.setBounds(350, 30, 150, 20);

				// ---- label30 ----
				label30.setText("Unit");
				panel6.add(label30);
				label30.setBounds(10, 55, 100, 20);

				panel6.add(comboBox7);
				comboBox7.setBounds(110, 55, 150, 20);

				// ---- label35 ----
				label35.setText("Vat");
				panel6.add(label35);
				label35.setBounds(270, 55, 80, 20);

				panel6.add(comboBox9);
				comboBox9.setBounds(350, 55, 150, 20);
				comboBox9.addItem("0.0");

				// ---- label31 ----
				label31.setText("Quantity");
				panel6.add(label31);
				label31.setBounds(10, 80, 100, 20);

				panel6.add(textField18);
				textField18.setBounds(110, 80, 150, 20);

				// ---- label36 ----
				label36.setText("Rate");
				panel6.add(label36);
				label36.setBounds(270, 80, 100, 20);

				panel6.add(textField23);
				textField23.setBounds(350, 80, 150, 20);

				// ---- label32 ----
				label32.setText("Discount      (Rs)");
				panel6.add(label32);
				label32.setBounds(10, 105, 100, 20);

				panel6.add(textField19);
				textField19.setBounds(110, 105, 85, 20);
				textField19.addKeyListener(this);
				panel6.add(textField20);
				textField20.setBounds(200, 105, 50, 20);
				textField20.addKeyListener(this);

				// ---- label33 ----
				label33.setText("%");
				panel6.add(label33);
				label33.setBounds(250, 105, 10, 20);

				ButtonGroup bg = new ButtonGroup();
				// ---- radioButton3 ----
				radioButton3.setText("Incl Vat");
				panel6.add(radioButton3);
				radioButton3.setBounds(300, 105, 100, 20);
				radioButton3.setSelected(true);
				bg.add(radioButton3);

				// ---- radioButton4 ----
				radioButton4.setText("Excl Vat");
				panel6.add(radioButton4);
				radioButton4.setBounds(400, 105, 100, 20);
				bg.add(radioButton4);

				// ======== scrollPane3 ========
				{
					scrollPane3.setViewportView(list1);
				}
				panel6.add(scrollPane3);
				scrollPane3.setBounds(510, 5, 275, 120);
				// list1.addMouseListener(this);
				list1.addListSelectionListener(this);
				list1.addKeyListener(this);
				list1.addKeyListener(this);

			}
			panel1.add(panel6);
			panel6.setBounds(WIDTH - 800, 270, 790, 150);
			// =======end of panel6==================================

			// ======== panel7 =======================================
			{
				panel7.setBorder(UIManager.getBorder("TitledBorder.border"));
				panel7.setLayout(null);

				// ---- button2 ----
				button2.setText("Other Charges");
				panel7.add(button2);
				button2.setBounds(50, 10, 350, 30);

				// ======== scrollPane4 ========
				{
					scrollPane4.setViewportView(table2);
				}
				panel7.add(scrollPane4);
				scrollPane4.setBounds(15, 45, 420, 80);

			}
			panel1.add(panel7);
			panel7.setBounds(WIDTH - 800, 425, 450, 130);
			// ==============end of panel7===================================

			// ======== panel8 ==============================================
			{
				panel8.setBorder(UIManager.getBorder("TitledBorder.border"));
				panel8.setLayout(null);

				// ---- label37 ----
				label37.setText("Bill Format : ");
				panel8.add(label37);
				label37.setBounds(10, 10, 100, 20);

				panel8.add(comboBox8);
				comboBox8.setBounds(110, 10, 200, 20);
				comboBox8.addItem("With MRP and Vat");

				// ---- checkBox3 ----
				checkBox3.setText("Set Default");
				panel8.add(checkBox3);
				checkBox3.setBounds(110, 35, 200, 20);

				// ---- button3 ----
				button3.setText("Edit");
				panel8.add(button3);
				button3.setBounds(10, 60, 70, 60);
				button3.addActionListener(this);

				// ---- button4 ----
				button4.setText("Add");
				panel8.add(button4);
				button4.setBounds(90, 60, 70, 60);
				button4.addActionListener(this);

				// ---- button5 ----
				button5.setText("Print");
				panel8.add(button5);
				button5.setBounds(170, 60, 70, 60);
				button5.addActionListener(this);

				// ---- button6 ----
				button6.setText("Delete");
				panel8.add(button6);
				button6.setBounds(250, 60, 70, 60);
				button6.addActionListener(this);

			}
			panel1.add(panel8);
			panel8.setBounds(WIDTH - 345, 425, 335, 130);
			// ========end of
			// panel8=============================================

			// ======== panel9
			// ==================================================
			{
				panel9.setBorder(UIManager.getBorder("TitledBorder.border"));
				panel9.setLayout(null);

			}
			panel1.add(panel9);
			panel9.setBounds(WIDTH - 800, 565, 590, 100);
			// ===========end of panel 9=====================================

			// ======== panel10 ==============================================
			{
				panel10.setBorder(UIManager.getBorder("TitledBorder.border"));
				panel10.setLayout(null);

				// ======== panel11 ========
				{
					panel11.setBackground(new Color(204, 255, 255));
					panel11.setLayout(null);

					// ---- label38 ----
					label38.setText("Calculator        :    F3");
					panel11.add(label38);
					label38.setBounds(new Rectangle(new Point(10, 5), label38
							.getPreferredSize()));

					// ---- label39 ----
					label39.setText("Product             :    F4");
					panel11.add(label39);
					label39.setBounds(new Rectangle(new Point(10, 25), label39
							.getPreferredSize()));

					// ---- label40 ----
					label40.setText("Product List     :    F5");
					panel11.add(label40);
					label40.setBounds(new Rectangle(new Point(10, 45), label40
							.getPreferredSize()));

					// ---- label41 ----
					label41.setText("Vat %                  :     F6");
					panel11.add(label41);
					label41.setBounds(new Rectangle(new Point(10, 65), label41
							.getPreferredSize()));

				}
				panel10.add(panel11);
				panel11.setBounds(5, 5, 180, 90);

			}
			panel1.add(panel10);
			panel10.setBounds(WIDTH - 200, 565, 190, 100);
			// ==========end of panel 10 =================================

		}
		contentPane.add(panel1);
		panel1.setBounds(0, 0, WIDTH, HEIGHT);
		// ============end of panel1 ====================================

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
		setLocation(-5, 0);
		setSize(WIDTH + 10, HEIGHT);
	}

	private void storeName() {
		ArrayList<String> storeNames = (ArrayList<String>) fieldName
				.getAllStoreName();
		for (String name : storeNames) {
			comboBox2.addItem(name);
		}
	}

	private void vatPercent() {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		ArrayList<Float> vatPercents = (ArrayList<Float>) fieldName
				.getVatByStartYear(year);
		for (float vat : vatPercents) {
			comboBox1.addItem(String.valueOf(vat));
		}
	}

	private void unitName() {
		ArrayList<String> unitNames = (ArrayList<String>) fieldName
				.getUnitName();
		for (String name : unitNames) {
			comboBox7.addItem(name);
		}
	}

	private void creditCustomerName() {
		comboBox4.addItem("--select--");
		for (CreditorModel creditor : creditors) {
			comboBox4.addItem(creditor.getName());
		}
	}

	@Override
	public void itemStateChanged(ItemEvent event) {

		if (event.getStateChange() == ItemEvent.SELECTED) {
			if (event.getItem() == "Sale Bill") {
				label19.setText("Bill No.");
				textField9.setText(fieldName.getNewBillNo(tableid
						.getStoreId(comboBox2.getSelectedItem().toString())));

			}
			if (event.getItem() == "Challan") {
				label19.setText("Challan No.");
				textField9.setText(fieldName.getNewChallanNo(tableid
						.getStoreId(comboBox2.getSelectedItem().toString())));
			}
			if (event.getItem() == "Sale Order") {
				label19.setText("Order No.");
				textField9.setText(fieldName.getNewSaleOrderNo(tableid
						.getStoreId(comboBox2.getSelectedItem().toString())));
			}
			if (event.getItem() == "Sale Quotation") {
				label19.setText("Quotation No");
				textField9.setText(fieldName.getNewSaleQuotationNo(tableid
						.getStoreId(comboBox2.getSelectedItem().toString())));
			}
			if (event.getItem() == "Cash") {
				textField14.setEnabled(false);
				textField15.setEnabled(false);
			}
			if (event.getItem() == "Bank") {
				textField14.setEnabled(true);
				textField15.setEnabled(true);
			}

			if (event.getSource() == comboBox2) {
				productList = dbValue.getProductDetail(tableid
						.getStoreId(comboBox2.getSelectedItem().toString()));
				creditors = dbValue.getCreditorDetail(tableid
						.getStoreId(comboBox2.getSelectedItem().toString()));
				creditCustomerName();
				billDetailList = new ArrayList<>();
				resetAll();
			}

			// this condition used to calculate bill vat and add it to net
			// amount
			if (event.getSource() == comboBox1) {
				calculateNetAmount(0, "add");
			}

			if (event.getSource() == radioButton2) {
				comboBox4.setEnabled(true);
			}

			// this reset all customer detail when general customer selected
			if (event.getSource() == radioButton1) {
				comboBox4.setEnabled(false);

				textField10.setText("");
				textArea1.setText("");
				textField11.setText("");
				textField12.setText("");
				textField12.setEnabled(false);
				textField13.setText("");
				textField13.setEditable(false);

			}

			// this section set creditors detail to customer detail panel when
			// item changed in combobox
			if (event.getSource() == comboBox4) {
				int fleg = 0;
				String tempstr = comboBox4.getSelectedItem().toString();
				for (CreditorModel creditor : creditors) {
					if (creditor.getName().equals(tempstr)) {
						textField10.setText(creditor.getName());
						textArea1.setText(creditor.getAddress());
						textField11.setText(creditor.getContactNo());
						textField12.setText(String.valueOf(creditor
								.getCreditAmt()));
						textField13.setText(String.valueOf(creditor
								.getDebitAmt()));
						fleg = 1;
					}
				}
				if (fleg == 0) {
					textField10.setText("");
					textArea1.setText("");
					textField11.setText("");
					textField12.setText("");
					textField12.setEnabled(false);
					textField13.setText("");
					textField13.setEditable(false);
				}

			}

		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String temp = event.getActionCommand();
		String saleType = comboBox3.getSelectedItem().toString();
		switch (temp) {
			case "Add" :
				addToBill();
				break;

			case "Print" :
				if (table1.getRowCount() <= 0) {
					new ValidationMSG(this,
							"Please add some product to the list for print");
				} else if (valid.isEmpty(textField10.getText())) {
					new ValidationMSG(this, "Please insert customer name");
				} else if (valid.isEmpty(textField11.getText())) {
					new ValidationMSG(this, "Please insert customer mobile no");
				} else {
					if (saleType.equals("Sale Bill")) {
						saveAndPrintSalesBill();
					} else if (saleType.equals("Challan")) {
						saveAndPrintChallan();
					} else if (saleType.equals("Sale Order")) {
						saveAndPrintSaleOrder();
					} else if (saleType.equals("Sale Quotation")) {
						saveAndPrintSaleQuotation();
					}
				}
				break;

			case "Edit" :
				if (table1.getSelectedRowCount() != 1) {
					new ValidationMSG(this,
							"Please Select A Product from table and then click on Edit");
				} else {
					editToBill();
				}
				break;

			case "Delete" :
				if (new PromptDailog().getUserResponse()) {
					deleteFromBill();
				}
				break;

			case "Other Charges" :
				otherCharges();
				break;

			default :

		}

	}

	// / this method is used for add product to the bill
	private void addToBill() {
		boolean status = true;
		if (valid.isEmpty(textField16.getText())) {
			status = false;
			new ValidationMSG(this, "Please insert product code");
		} else if (valid.isEmpty(textField21.getText())) {
			status = false;
			new ValidationMSG(this, "Please insert product Name");
		} else if (valid.isEmpty(textField18.getText())) {
			status = false;
			new ValidationMSG(this, "Please insert product Quantity");
		} else if (valid.isEmpty(textField23.getText())) {
			status = false;
			new ValidationMSG(this, "Please select product from List");
		}

		if (status) {
			BillDetailModel billDetail = new BillDetailModel();

			double vatPercent = 0, vatAmt = 0, discountPer = 0, discountAmt = 0, rate = 0;

			if (!valid.isEmpty(textField23.getText()))
				rate = Double.parseDouble(textField23.getText());
			vatPercent = Double.parseDouble(comboBox9.getSelectedItem()
					.toString());
			vatAmt = rate * (vatPercent / 100);
			if (!valid.isEmpty(textField20.getText()))
				discountPer = Double.parseDouble(textField20.getText());
			if (!valid.isEmpty(textField19.getText()))
				discountAmt = Double.parseDouble(textField19.getText());

			double qty = Double.parseDouble(textField18.getText());
			calculateNetAmount((rate - discountAmt) * qty, "add");
			// System.out.println("Rate =  " + rate + "  qty = " + qty);

			billDetail.setProductQuantity(qty);
			billDetail.setProductRate(rate);
			billDetail.setMrp(productDisplayList.get(list1.getSelectedIndex())
					.getMRP());
			billDetail.setPurchaseRate(productDisplayList.get(
					list1.getSelectedIndex()).getPurchaseRate());
			billDetail.setSubTotal((rate - discountAmt) * qty);
			billDetail.setVatPercent(vatPercent);
			billDetail.setVatAmt(vatAmt);
			billDetail.setDiscountPercent(discountPer);
			billDetail.setDiscountAmt(discountAmt);
			if (!valid.isEmpty(textField17.getText()))
				billDetail.setBatchNo(textField17.getText());
			billDetail.setCategoryName(fieldName.getCategoryName(textField21
					.getText()));
			billDetail.setProductCode(textField16.getText());
			billDetail.setProductName(textField21.getText());
			billDetail.setProductType("");
			billDetail.setProductUnit(comboBox7.getSelectedItem().toString());
			billDetail.setWarrantyStartDate(new DatePicker().getCurrentDate());
			billDetail.setWarrantyEndDate(new DatePicker().getCurrentDate());

			billDetailList.add(billDetail);
			loadTableData();
			itemCount++;
			label2.setText(String.valueOf(itemCount));
			productPanelReset();
		}

	}

	private void editToBill() {
		BillDetailModel billDetail = billDetailList
				.get(table1.getSelectedRow());
		textField23.setText(String.valueOf(billDetail.getMrp()));
		comboBox9.addItem(String.valueOf(billDetail.getVatPercent()));
		comboBox9.setSelectedItem(String.valueOf(billDetail.getVatPercent()));
		textField20.setText(String.valueOf(billDetail.getDiscountPercent()));
		textField19.setText(String.valueOf(billDetail.getDiscountAmt()));
		textField18.setText(String.valueOf(billDetail.getProductQuantity()));
		textField17.setText(billDetail.getBatchNo());
		textField16.setText(billDetail.getProductCode());
		textField21.setText(billDetail.getProductName());
		comboBox7.addItem(billDetail.getProductUnit());
		comboBox7.setSelectedItem(billDetail.getProductUnit());
		billDetailList.remove(table1.getSelectedRow());
		calculateNetAmount(
				(billDetail.getProductRate() - billDetail.getDiscountAmt())
						* billDetail.getProductQuantity(), "less");
		loadTableData();
		itemCount--;
		label2.setText(String.valueOf(itemCount));
	}

	private void deleteFromBill() {
		BillDetailModel billDetail = billDetailList
				.get(table1.getSelectedRow());
		calculateNetAmount(
				(billDetail.getProductRate() - billDetail.getDiscountAmt())
						* billDetail.getProductQuantity(), "less");
		billDetailList.remove(table1.getSelectedRow());
		loadTableData();
		itemCount--;
		label2.setText(String.valueOf(itemCount));
		productPanelReset();
	}

	private void otherCharges() {

	}

	// / this section calculate net and total amount for bill and show it to UI
	private void calculateNetAmount(double rate, String operation) {
		if (operation.equals("add")) {
			netAmount += rate;
		} else if (operation.equals("less")) {
			netAmount -= rate;
		}
		// ////System.out.println("netamt = "+netAmount);
		textField1.setText(String.format("%.2f", netAmount));

		double vatper = Double.parseDouble(comboBox1.getSelectedItem()
				.toString());
		double totalVatAmt = netAmount * (vatper / 100);
		textField5.setText(String.format("%.2f", totalVatAmt));

		if (!valid.isEmpty(textField6.getText())) {
			double discountAmt = Double.parseDouble(textField6.getText());
			totalAmount = netAmount - discountAmt + totalVatAmt;
		} else {
			totalAmount = netAmount + totalVatAmt;
		}
		textField3.setText(String.format("%.2f", totalAmount));
		textField2.setText(String.format("%.2f", totalAmount));

	}

	// Method for reset product Panel
	private void productPanelReset() {
		textField16.setText("");
		textField16.requestFocus();
		textField17.setText("");
		textField19.setText("");
		textField20.setText("");
		textField21.setText("");
		textField18.setText("");
		textField23.setText("");
		if (comboBox7.getItemCount() > 0)
			comboBox7.setSelectedIndex(0);
		if (comboBox9.getItemCount() > 0)
			comboBox9.setSelectedIndex(0);
		listModel.removeAllElements();
	}

	// / method for reset all fields of UI and generate new bill no
	private void resetAll() {

		while (tableModel1.getRowCount() > 0) {
			tableModel1.removeRow(0);
		}
		label2.setText("0");
		textField1.setText("");
		textField2.setText("");
		textField3.setText("");
		textField4.setText("");
		textField5.setText("");
		textField6.setText("");
		textField7.setText("");
		if (comboBox3.getSelectedIndex() == 0) {
			textField9.setText(fieldName.getNewBillNo(tableid
					.getStoreId(comboBox2.getSelectedItem().toString())));
		} else if (comboBox3.getSelectedIndex() == 1) {
			textField9.setText(fieldName.getNewChallanNo(tableid
					.getStoreId(comboBox2.getSelectedItem().toString())));
		} else if (comboBox3.getSelectedIndex() == 2) {
			textField9.setText(fieldName.getNewSaleOrderNo(tableid
					.getStoreId(comboBox2.getSelectedItem().toString())));
		} else if (comboBox3.getSelectedIndex() == 3) {
			textField9.setText(fieldName.getNewSaleQuotationNo(tableid
					.getStoreId(comboBox2.getSelectedItem().toString())));
		}
		radioButton1.setSelected(true);
		comboBox4.setSelectedIndex(0);
		textField10.setText("");
		textField11.setText("");
		textField12.setText("");
		textField13.setText("");
		textArea1.setText("");
		comboBox6.setSelectedIndex(0);
		checkBox1.setSelected(false);
		textField14.setText("");
		textField15.setText("");
		productPanelReset();
		while (tableModel2.getRowCount() > 0) {
			tableModel2.removeRow(0);
		}
		if (!checkBox3.isSelected()) {
			comboBox8.setSelectedIndex(0);
		}

		netAmount = 0;
		totalAmount = 0;
		itemCount = 0;
		billDetailList = new ArrayList<>();
		productDisplayList = new ArrayList<>();

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

	@Override
	public void keyReleased(KeyEvent event) {
		if (!(event.getKeyChar() == 27 || event.getKeyChar() == 6)) {

			// / this block is for searching product according to product code
			if (event.getSource() == textField16) {
				productDisplayList = new ArrayList<>();
				String tempStr = textField16.getText();
				for (ProductModel tempProduct1 : productList) {
					if ((tempProduct1.getProductCode().toLowerCase())
							.contains(tempStr.toLowerCase())) {
						productDisplayList.add(tempProduct1);
					}
				}
				loadListData(productDisplayList);
			}
			// / this block is for searching product according to product Name
			if (event.getSource() == textField21) {
				productDisplayList = new ArrayList<>();
				String tempStr = textField21.getText();
				for (ProductModel tempProduct1 : productList) {
					if ((tempProduct1.getProductName().toLowerCase())
							.contains(tempStr.toLowerCase())) {
						productDisplayList.add(tempProduct1);
					}
				}
				loadListData(productDisplayList);
			}

			// //this calculate discount percent from the discountAmount for
			// perticular product
			if (event.getSource() == textField19) {
				if (!valid.isEmpty(textField19.getText())
						&& !valid.isEmpty(textField23.getText())) {
					double discountAmt = Double.parseDouble(textField19
							.getText());
					double mrp = Double.parseDouble(textField23.getText());
					double discountPercent = (discountAmt * 100) / mrp;
					textField20.setText(String.format("%.2f", discountPercent));
				} else {
					textField20.setText("");
				}
			}
			// //this calculate discount Amount from the discountPercent for
			// perticular product
			if (event.getSource() == textField20) {
				if (!valid.isEmpty(textField20.getText())
						&& !valid.isEmpty(textField23.getText())) {
					double discountPercent = Double.parseDouble(textField20
							.getText());
					double mrp = Double.parseDouble(textField23.getText());
					double discountAmt = mrp * (discountPercent / 100);
					textField19.setText(String.format("%.2f", discountAmt));
				} else {
					textField19.setText("");
				}

			}

			// //this calculate discount percent from the discountAmount for
			// Whole bill
			if (event.getSource() == textField6) {
				if (!valid.isEmpty(textField6.getText())) {
					double discountAmt = Double.parseDouble(textField6
							.getText());
					double discountPercent = (discountAmt * 100) / netAmount;
					textField7.setText(String.format("%.2f", discountPercent));
				} else {
					textField7.setText("");
				}
				calculateNetAmount(0, "add");

			}
			// //this calculate discount Amount from the discountPercent for
			// whole bill
			if (event.getSource() == textField7) {
				if (!valid.isEmpty(textField7.getText())) {
					double discountPercent = Double.parseDouble(textField7
							.getText());
					double discountAmt = netAmount * (discountPercent / 100);
					textField6.setText(String.format("%.2f", discountAmt));
				} else {
					textField6.setText("");
				}
				calculateNetAmount(0, "add");

			}

			// this block set credit amount for the whole bill when user types
			// debit amount
			if (event.getSource() == textField4) {
				double creditAmt = 0;
				if (!valid.isEmpty(textField4.getText())) {
					creditAmt = totalAmount
							- Double.parseDouble(textField4.getText());
				} else {
					creditAmt = totalAmount;
				}
				textField3.setText(String.format("%.2f", creditAmt));
			}
		}// End of editing section

		if (event.getSource() == list1 && event.getKeyCode() == 10) {
			textField18.requestFocus();
		}

	} // end of key release Method

	/**
	 * this method is used to show product name in list
	 * 
	 * @param productTempList
	 */
	private void loadListData(ArrayList<ProductModel> productTempList) {

		listModel.removeAllElements();
		for (ProductModel tempProduct : productTempList) {
			listModel.addElement(tempProduct.getProductName());
		}
		/*
		 * if (list1.getVisibleRowCount() > 0) { list1.setSelectedIndex(0); }
		 */
	}

	private void loadTableData() {
		// for removing all existing rows from table
		while (tableModel1.getRowCount() > 0) {
			tableModel1.removeRow(0);
		}

		// / inserting new rows to the table
		int i = 1;
		for (BillDetailModel billDetail : billDetailList) {
			tableModel1.addRow(new Object[]{i, billDetail.getProductCode(),
					billDetail.getProductName(),
					billDetail.getProductQuantity(),
					billDetail.getProductUnit(), billDetail.getMrp()});
			i++;
		}

	}

	/*
	 * @Override public void mouseClicked(MouseEvent arg0) { }
	 * 
	 * @Override public void mouseEntered(MouseEvent arg0) { }
	 * 
	 * @Override public void mouseExited(MouseEvent arg0) { }
	 * 
	 * @Override public void mousePressed(MouseEvent arg0) { }
	 * 
	 * @Override public void mouseReleased(MouseEvent arg0) { for (ProductModel
	 * prod : productList) { if
	 * (prod.getProductName().equals(list1.getSelectedValue())) {
	 * textField16.setText(prod.getProductCode());
	 * textField21.setText(prod.getProductName());
	 * comboBox7.setSelectedItem(prod.getUnit());
	 * textField23.setText(String.format("%.2f", prod.getSaleRate()));
	 * textField23.setEnabled(false); } } }
	 */

	/**
	 * 
	 * @param bill_id
	 */
	private PaymentModel setBillPaymentModel(int bill_id) {
		PaymentModel salesBillPayment = new PaymentModel();
		salesBillPayment.setPaymentId(0);
		salesBillPayment.setBankName(textField14.getText());
		salesBillPayment.setCode(textField15.getText());
		salesBillPayment.setDescription("");
		if (!valid.isEmpty(textField4.getText()))
			salesBillPayment
					.setPaidAmt(Double.parseDouble(textField4.getText()));
		salesBillPayment.setStoreId(tableid.getStoreId(comboBox2
				.getSelectedItem().toString()));
		salesBillPayment.setPaymentDate(textField8.getText());
		salesBillPayment.setPaymentMode(comboBox6.getSelectedItem().toString());
		salesBillPayment.setRefId(bill_id);

		return salesBillPayment;
	}

	/**
	 * this method is used to save all sale bill details and also print the sale
	 * bill.
	 */
	private void saveAndPrintSalesBill() {

		// 1. for saving general bill info
		SalesBillModel saleBill = setSalesBillModel();
		int bill_id = dbinsert.insertSalesBill(saleBill);

		// 2. for saving bill payment details
		PaymentModel payment = setBillPaymentModel(bill_id);
		dbinsert.insertSalesBillPayment(payment);

		// 3. for saving bill payment details
		for (OtherChargesModel otherCharge : OtherChargesList) {
			dbinsert.insertSalesOtherCharges(otherCharge);
		}

		// 4. for saving saling product details and deducting product quantity
		// from database
		for (BillDetailModel tempBillDetail : billDetailList) {
			SalesBillDetailModel tempSalesBillDetail = new SalesBillDetailModel(
					tempBillDetail);
			tempSalesBillDetail.setBillId(bill_id);
			dbinsert.insertSalesBillDetail(tempSalesBillDetail);
			for (ProductModel tempProduct : productList) {

				// this condition is for deduct product quantity from database
				if (tempProduct.getProductCode().equals(
						tempSalesBillDetail.getProductCode())
						&& tempProduct.getProductName().equals(
								tempSalesBillDetail.getProductName())) {
					double Quantity = tempSalesBillDetail.getProductQuantity();
					int id = tempProduct.getProductId();
					dbinsert.updateProductLess(id, Quantity);
				}
			}
		}

		new PrintBill().printSaleBill(saleBill, billDetailList,
				OtherChargesList, payment);

		resetAll();

	} // end of saveAndPrint block

	/**
	 * this method is used to save all sale Challan details and also print the
	 * sale Challan.
	 */
	private void saveAndPrintChallan() {
		// 1. for saving general bill info
		ChallanModel challan = setChallanModel();
		int challan_id = dbinsert.insertChallan(challan);

		// 2. for saving bill payment details
		PaymentModel payment = setBillPaymentModel(challan_id);
		dbinsert.insertChallanPayment(payment);

		// 3. for saving bill payment details
		for (OtherChargesModel otherCharge : OtherChargesList) {
			dbinsert.insertChallanOtherCharges(otherCharge);
		}

		// 4. for saving saling product details and deducting product quantity
		// from database
		for (BillDetailModel tempBillDetail : billDetailList) {
			ChallanDetailModel tempChallanDetail = new ChallanDetailModel(
					tempBillDetail);
			tempChallanDetail.setChallanId(challan_id);
			dbinsert.insertChallanDetail(tempChallanDetail);
			for (ProductModel tempProduct : productList) {

				// this condition is for deduct product quantity from database
				if (tempProduct.getProductCode().equals(
						tempChallanDetail.getProductCode())
						&& tempProduct.getProductName().equals(
								tempChallanDetail.getProductName())) {
					double Quantity = tempChallanDetail.getProductQuantity();
					int id = tempProduct.getProductId();
					dbinsert.updateProductLess(id, Quantity);
				}
			}
		}

		// PrintSalesBillMethod();
		new PrintBill().printChallan(challan, billDetailList, OtherChargesList,
				payment);

		resetAll();

	} // end of saveAndPrint block

	/**
	 * this method is used to save all sale Order details and also print the
	 * sale Order.
	 */
	private void saveAndPrintSaleOrder() {
		// 1. for saving general bill info
		SaleOrderModel saleOrder = setSalesOrderModel();
		int order_id = dbinsert.insertSalesOrder(saleOrder);

		// 2. for saving bill payment details
		PaymentModel payment = setBillPaymentModel(order_id);
		dbinsert.insertSalesOrderPayment(payment);

		// 3. for saving bill payment details
		for (OtherChargesModel otherCharge : OtherChargesList) {
			dbinsert.insertSalesOrderOtherCharges(otherCharge);
		}

		// 4. for saving saling product details and deducting product quantity
		// from database
		for (BillDetailModel tempBillDetail : billDetailList) {
			SaleOrderDetailModel tempSalesOrderDetail = new SaleOrderDetailModel(
					tempBillDetail);
			tempSalesOrderDetail.setOrderId(order_id);
			dbinsert.insertSalesOrderDetail(tempSalesOrderDetail);
			for (ProductModel tempProduct : productList) {

				// this condition is for deduct product quantity from database
				if (tempProduct.getProductCode().equals(
						tempSalesOrderDetail.getProductCode())
						&& tempProduct.getProductName().equals(
								tempSalesOrderDetail.getProductName())) {
					double Quantity = tempSalesOrderDetail.getProductQuantity();
					int id = tempProduct.getProductId();
					dbinsert.updateProductLess(id, Quantity);
				}
			}
		}

		// PrintSalesBillMethod();
		new PrintBill().printSaleOrder(saleOrder, billDetailList,
				OtherChargesList, payment);
		resetAll();

	} // end of saveAndPrint block

	/**
	 * this method is used to save all sale Quotation details and also print the
	 * sale Quotation.
	 */
	private void saveAndPrintSaleQuotation() {
		// 1. for saving general bill info
		SaleQuotationModel saleQuotation = setSalesQuotationModel();
		int quotation_id = dbinsert.insertSalesQuotation(saleQuotation);

		// 2. for saving bill payment details
		
		// dbinsert.insertSalesPayment(setBillPaymentModel(bill_id));

		// 3. for saving bill payment details
		for (OtherChargesModel otherCharge : OtherChargesList) {
			dbinsert.insertQuotationOtherCharges(otherCharge);
		}

		// 4. for saving saling product details and deducting product quantity
		// from database
		for (BillDetailModel tempBillDetail : billDetailList) {
			SaleQuotationDetailModel tempSalesQuotationDetail = new SaleQuotationDetailModel(
					tempBillDetail);
			tempSalesQuotationDetail.setQuotationId(quotation_id);
			dbinsert.insertSalesQuotationDetail(tempSalesQuotationDetail);
		}

		// PrintSalesBillMethod();
		new PrintBill().printSaleQuotation(saleQuotation, billDetailList, OtherChargesList);

		resetAll();

	} // end of saveAndPrint block

	// /set general bill details
	private SalesBillModel setSalesBillModel() {

		SalesBillModel salesBill = new SalesBillModel();
		salesBill.setBillId(0);
		salesBill.setCounter(1);
		salesBill.setFirmId(1);
		salesBill.setChallanNo(1);
		salesBill.setStoreId(tableid.getStoreId(comboBox2.getSelectedItem()
				.toString()));
		int year = Calendar.getInstance().get(Calendar.YEAR);
		salesBill.setYearId(tableid.getYearId(year, year + 1));
		if (checkBox1.isSelected()) {
			salesBill.setHomeDelivery(1);
		}
		if (!valid.isEmpty(textField6.getText()))
			salesBill.setDiscount(Double.parseDouble(textField6.getText()));
		salesBill.setTotalAmt(totalAmount);
		salesBill.setBillVatPercent(Double.parseDouble(comboBox1
				.getSelectedItem().toString()));
		if (!valid.isEmpty(textField5.getText()))
			salesBill.setBillVatAmt(Double.parseDouble(textField5.getText()));
		salesBill.setBillNo(textField9.getText());
		salesBill.setBillDate(textField8.getText());
		salesBill.setCustomerName(textField10.getText());
		if (!valid.isEmpty(textArea1.getText()))
			salesBill.setCustomerAddress(textArea1.getText());
		if (radioButton1.isSelected()) {
			salesBill.setCustomerType("General Customer");
		} else {
			salesBill.setCustomerType("Credit Customer");
		}
		salesBill.setMobileNo(textField11.getText());
		salesBill.setNarration("");
		salesBill.setUserName(this.userName);
		salesBill.setPrefix(fieldName.getBillPrefix(tableid
				.getStoreId(comboBox2.getSelectedItem().toString())));

		return salesBill;
	}

	// /set general bill details
	private ChallanModel setChallanModel() {

		ChallanModel challan = new ChallanModel();
		challan.setChallanId(0);
		challan.setCounter(1);
		challan.setFirmId(1);
		// challan.setChallanNo(1);
		challan.setStoreId(tableid.getStoreId(comboBox2.getSelectedItem()
				.toString()));
		int year = Calendar.getInstance().get(Calendar.YEAR);
		challan.setYearId(tableid.getYearId(year, year + 1));
		if (checkBox1.isSelected()) {
			challan.setHomeDelivery(1);
		}
		if (!valid.isEmpty(textField6.getText()))
			challan.setDiscount(Double.parseDouble(textField6.getText()));
		challan.setTotalAmt(totalAmount);
		challan.setChallanVatPercent(Double.parseDouble(comboBox1
				.getSelectedItem().toString()));
		if (!valid.isEmpty(textField5.getText()))
			challan.setChallanVatAmt(Double.parseDouble(textField5.getText()));
		challan.setChallanNo(textField9.getText());
		challan.setChallanDate(textField8.getText());
		challan.setCustomerName(textField10.getText());
		if (!valid.isEmpty(textArea1.getText()))
			challan.setCustomerAddress(textArea1.getText());
		if (radioButton1.isSelected()) {
			challan.setCustomerType("General Customer");
		} else {
			challan.setCustomerType("Credit Customer");
		}
		challan.setMobileNo(textField11.getText());
		challan.setNarration("");
		challan.setUserName(this.userName);
		challan.setPrefix(fieldName.getChallanPrefix(tableid
				.getStoreId(comboBox2.getSelectedItem().toString())));

		return challan;
	}

	// /set general bill details
	private SaleOrderModel setSalesOrderModel() {

		SaleOrderModel saleOrder = new SaleOrderModel();
		saleOrder.setOrderId(0);
		saleOrder.setCounter(1);
		saleOrder.setFirmId(1);
		saleOrder.setNumberOfDays(0);// ****************************************************************************************************
		// saleOrder.setChallanNo(1);
		saleOrder.setStoreId(tableid.getStoreId(comboBox2.getSelectedItem()
				.toString()));
		int year = Calendar.getInstance().get(Calendar.YEAR);
		saleOrder.setYearId(tableid.getYearId(year, year + 1));
		if (checkBox1.isSelected()) {
			saleOrder.setHomeDelivery(1);
		}
		if (!valid.isEmpty(textField6.getText()))
			saleOrder.setDiscount(Double.parseDouble(textField6.getText()));
		saleOrder.setTotalAmt(totalAmount);
		saleOrder.setOrderVatPercent(Double.parseDouble(comboBox1
				.getSelectedItem().toString()));
		if (!valid.isEmpty(textField5.getText()))
			saleOrder.setOrderVatAmt(Double.parseDouble(textField5.getText()));
		saleOrder.setOrderNo(textField9.getText());
		saleOrder.setOrderDate(textField8.getText());
		saleOrder.setCustomerName(textField10.getText());
		if (!valid.isEmpty(textArea1.getText()))
			saleOrder.setCustomerAddress(textArea1.getText());
		if (radioButton1.isSelected()) {
			saleOrder.setCustomerType("General Customer");
		} else {
			saleOrder.setCustomerType("Credit Customer");
		}
		saleOrder.setMobileNo(textField11.getText());
		saleOrder.setNarration("");
		saleOrder.setUserName(this.userName);
		saleOrder.setStatus("Pending");

		return saleOrder;
	}

	// /set general bill details
	private SaleQuotationModel setSalesQuotationModel() {

		SaleQuotationModel saleQuotation = new SaleQuotationModel();
		saleQuotation.setQuotationId(0);
		saleQuotation.setCounter(1);
		saleQuotation.setFirmId(1);
		// saleQuotation.setChallanNo(1);
		saleQuotation.setStoreId(tableid.getStoreId(comboBox2.getSelectedItem()
				.toString()));
		int year = Calendar.getInstance().get(Calendar.YEAR);
		saleQuotation.setYearId(tableid.getYearId(year, year + 1));
		if (checkBox1.isSelected()) {
			saleQuotation.setHomeDelivery(1);
		}
		if (!valid.isEmpty(textField6.getText()))
			saleQuotation.setDiscount(Double.parseDouble(textField6.getText()));
		saleQuotation.setTotalAmt(totalAmount);
		saleQuotation.setQuotationVatPercent(Double.parseDouble(comboBox1
				.getSelectedItem().toString()));
		if (!valid.isEmpty(textField5.getText()))
			saleQuotation.setQuotationVatAmt(Double.parseDouble(textField5
					.getText()));
		// saleQuotation.setBillNo(textField9.getText());
		saleQuotation.setQuotationDate(textField8.getText());
		saleQuotation.setCustomerName(textField10.getText());
		if (!valid.isEmpty(textArea1.getText()))
			saleQuotation.setCustomerAddress(textArea1.getText());
		if (radioButton1.isSelected()) {
			saleQuotation.setCustomerType("General Customer");
		} else {
			saleQuotation.setCustomerType("Credit Customer");
		}
		saleQuotation.setMobileNo(textField11.getText());
		saleQuotation.setNarration("");
		saleQuotation.setUserName(this.userName);

		return saleQuotation;
	}

	@Override
	public void valueChanged(ListSelectionEvent event) {
		// TODO Auto-generated method stub
		if (event.getSource() == list1) {
			for (ProductModel prod : productList) {
				if (prod.getProductName().equals(list1.getSelectedValue())) {
					textField16.setText(prod.getProductCode());
					textField21.setText(prod.getProductName());
					comboBox7.setSelectedItem(prod.getUnit());
					comboBox9.removeAllItems();
					comboBox9.addItem(String.valueOf(prod.getVatPercent()));
					textField23.setText(String.format("%.2f",
							prod.getSaleRate()));
					textField23.setEnabled(false);
				}
			}
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == list1)
			list1.setSelectedIndex(0);
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}
}
