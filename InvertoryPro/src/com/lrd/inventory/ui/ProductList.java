/*
 * Created by JFormDesigner on Sat May 30 11:06:50 IST 2015
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

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.lrd.inventory.database.DatabaseDelete;
import com.lrd.inventory.database.GetDBValue;
import com.lrd.inventory.database.SpecificFieldValue;
import com.lrd.inventory.database.TableId;
import com.lrd.inventory.main.Validate;
import com.lrd.inventory.main.ValidationMSG;
import com.lrd.inventory.model.ProductModel;

/**
 * @author dharmendra singh
 */
public class ProductList extends JFrame
		implements
			ActionListener,
			KeyListener,
			ItemListener {

	private static final long serialVersionUID = 1L;

	// Variables declaration
	private JLabel label1;
	private JLabel label2;
	private JComboBox<Object> comboBox1;
	private JTextField textField1;
	private JButton button3;
	private JButton button4;
	private JLabel label5;
	private JScrollPane scrollPane1;
	private DefaultTableModel tableModel;
	private JTable table1;
	private JSeparator separator1;
	private JLabel label3;
	// End of variables declaration

	Connection connection = null;
	// ProductModel product = null;
	ArrayList<ProductModel> productList = null;
	ArrayList<ProductModel> productDisplayList = null;
	TableId tableid = null;
	GetDBValue dbvalue = null;
	SpecificFieldValue fieldName = null;
	Validate valid = null;

	int selectedIndex = 0;

	public ProductList(Connection connection) {
		this.connection = connection;
		// productList = new ArrayList<>();
		tableid = new TableId(connection);
		dbvalue = new GetDBValue(connection);
		fieldName = new SpecificFieldValue(connection);
		valid = new Validate();
		initComponents();
		storeName();
		productList = dbvalue.getProductDetail(tableid.getStoreId(comboBox1
				.getSelectedItem().toString()));
		productDisplayList = productList;
		loadTableData(productDisplayList);
	}

	private void initComponents() {

		label1 = new JLabel();
		label2 = new JLabel();
		comboBox1 = new JComboBox<Object>();
		textField1 = new JTextField();
		button3 = new JButton();
		button4 = new JButton();
		label5 = new JLabel();
		scrollPane1 = new JScrollPane();
		tableModel = new DefaultTableModel();
		table1 = new JTable(tableModel);
		separator1 = new JSeparator();
		label3 = new JLabel();

		// ======== this ========
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		// ---- label1 ----
		label1.setText("Store Name");
		contentPane.add(label1);
		label1.setBounds(new Rectangle(new Point(50, 100), label1
				.getPreferredSize()));

		contentPane.add(comboBox1);
		comboBox1.setBounds(150, 100, 200, comboBox1.getPreferredSize().height);
		comboBox1.addItemListener(this);

		// ---- label2 ----
		label2.setText("Product Name");
		contentPane.add(label2);
		label2.setBounds(new Rectangle(new Point(50, 150), label2
				.getPreferredSize()));

		contentPane.add(textField1);
		textField1.setBounds(150, 150, 200,
				textField1.getPreferredSize().height);
		textField1.addKeyListener(this);

		// ---- button3 ----
		button3.setText("Refresh");
		contentPane.add(button3);
		button3.setBounds(375, 150, 100, 30);
		button3.addActionListener(this);

		// ---- button4 ----
		button4.setText("Delete");
		contentPane.add(button4);
		button4.setBounds(495, 150, 100, 30);
		button4.addActionListener(this);

		// ---- label5 ----
		label5.setText(" Product List");
		contentPane.add(label5);
		label5.setBounds(new Rectangle(new Point(250, 15), label5
				.getPreferredSize()));

		tableModel.addColumn("Product Code");
		tableModel.addColumn("Product Name");
		tableModel.addColumn("Unit");
		tableModel.addColumn("Quantity");
		tableModel.addColumn("Sale Rate");
		tableModel.addColumn("Vat Percent");
		// ======== scrollPane1 ========
		{
			scrollPane1.setViewportView(table1);
			table1.addKeyListener(this);
		}
		contentPane.add(scrollPane1);
		scrollPane1.setBounds(35, 200, 580, 420);
		contentPane.add(separator1);
		separator1.setBounds(45, 60, 555, 7);

		// ---- label3 ----
		label3.setText("( Note : To View Product Details Select Product from above Table & Press \"Enter\" .)");
		contentPane.add(label3);
		label3.setBounds(new Rectangle(new Point(40, 630), label3
				.getPreferredSize()));

		pack();
		setVisible(true);
		setLocation(200, 10);
		setSize(650, 700);

	}

	private void storeName() {
		ArrayList<String> storeNames = (ArrayList<String>) fieldName
				.getAllStoreName();
		for (String name : storeNames) {
			comboBox1.addItem(name);
		}
	}

	private void loadTableData(ArrayList<ProductModel> tempProList) {

		while (tableModel.getRowCount() > 0) {
			tableModel.removeRow(0);
		}

		for (ProductModel tempProduct : tempProList) {
			tableModel.addRow(new Object[]{tempProduct.getProductCode(),
					tempProduct.getProductName(), tempProduct.getUnit(),
					tempProduct.getQuantity(), tempProduct.getSaleRate(),
					tempProduct.getVatPercent()});
		}
	}

	@Override
	public void keyPressed(KeyEvent event) {
		if (event.getSource() == table1) {
			if (event.getKeyChar() == 10) {
				if (table1.getSelectedRowCount() == 1) {
					int id = productDisplayList.get(table1.getSelectedRow())
							.getProductId();
					
					new ProductDetails(id, this.connection);
					try {
						table1.setRowSelectionInterval(table1.getSelectedRow() - 1,
								table1.getSelectedRow() - 1);
					} catch (Exception e) {
						// e.printStackTrace();
					}
				} else {
					new ValidationMSG(this,
							"please select single row to view product details");
				}
			}
		}
	}
	@Override
	public void keyTyped(KeyEvent event) {
	}

	@Override
	public void keyReleased(KeyEvent event) {
		if (event.getSource() == textField1) {
			if (!(event.getKeyChar() == 27 || event.getKeyChar() == 6)) {
				productDisplayList = new ArrayList<>();
				if (!(valid.isEmpty(textField1.getText()))) {
					for (ProductModel tempProduct : productList) {
						if (tempProduct.getProductName().toLowerCase().contains(
								textField1.getText().toLowerCase())) {
							productDisplayList.add(tempProduct);
						}
					}
					loadTableData(productDisplayList);
				} else {
					productDisplayList = productList;
					loadTableData(productDisplayList);
				}
			}
		}

	}

	@Override
	public void itemStateChanged(ItemEvent event) {
		if (event.getStateChange() == ItemEvent.SELECTED) {
			if (event.getSource() == comboBox1) {
				productDisplayList = new ArrayList<>();
				productList = dbvalue.getProductDetail(tableid
						.getStoreId(comboBox1.getSelectedItem().toString()));
				productDisplayList = productList;
				loadTableData(productDisplayList);
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == button3) {
			productList = dbvalue.getProductDetail(tableid
					.getStoreId(comboBox1.getSelectedItem().toString()));
			productDisplayList = productList;
			loadTableData(productDisplayList);
			textField1.setText("");
		}

		if (event.getSource() == button4) {
			boolean status = true;
			if (table1.getSelectedRowCount() != 1) {
				status = false;
				new ValidationMSG(this,
						"Please Select A Row from Table Then Click");
			}
			if (status) {
				int id = productDisplayList.get(table1.getSelectedRow())
						.getProductId();
				new DatabaseDelete(connection).deleteProductVat(id);
				new DatabaseDelete(connection).deleteProduct(id);
				productList = dbvalue.getProductDetail(tableid
						.getStoreId(comboBox1.getSelectedItem().toString()));
				productDisplayList = productList;
				loadTableData(productDisplayList);
			}
		}

	}

}
