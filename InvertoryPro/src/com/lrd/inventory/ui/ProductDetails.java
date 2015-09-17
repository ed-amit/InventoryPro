package com.lrd.inventory.ui;

import java.sql.Connection;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.lrd.inventory.database.GetDBValue;
import com.lrd.inventory.database.SpecificFieldValue;
import com.lrd.inventory.model.ProductModel;

public class ProductDetails {

	private JPanel infoPanel;
	private JScrollPane scrollPane;
	private DefaultTableModel tableModel;
	private JTable table;

	public ProductDetails(int productId, Connection connection) {
		// TODO Auto-generated constructor stub
		JDialog.setDefaultLookAndFeelDecorated(true);

		infoPanel = new JPanel();
		scrollPane = new JScrollPane();
		tableModel = new DefaultTableModel();
		table = new JTable(tableModel);
		{
			tableModel.addColumn("Property");
			tableModel.addColumn("Values");
			// ======== scrollPane2 ========
			{
				scrollPane.setViewportView(table);
			}
			infoPanel.add(scrollPane);
			scrollPane.setBounds(0, 0, 300, 300);
			ProductModel product = new GetDBValue(connection).getProductDetailById(productId);
			
			String rackName = new SpecificFieldValue(connection).getRackName(product.getRackId());
			String categoryName = new SpecificFieldValue(connection).getCategoryNameByID(product.getCategoryId());
			String brandName = new SpecificFieldValue(connection).getBrandNameById(product.getBrandId());
			String storeName = new SpecificFieldValue(connection).getStoreName(product.getStoreId());
			
			tableModel.addRow(new Object[]{"Product Code",product.getProductCode()});
			tableModel.addRow(new Object[]{"Product Name",product.getProductName()});
			tableModel.addRow(new Object[]{"Product Description",product.getProductDesc()});
			tableModel.addRow(new Object[]{"Rack Name",rackName});
			tableModel.addRow(new Object[]{"Category Name",categoryName});
			tableModel.addRow(new Object[]{"Brand Name",brandName});
			tableModel.addRow(new Object[]{"Unit",product.getUnit()});
			tableModel.addRow(new Object[]{"Quantity",product.getQuantity()});
			tableModel.addRow(new Object[]{"Purchase Rate",product.getPurchaseRate()});
			tableModel.addRow(new Object[]{"MRP",product.getMRP()});
			tableModel.addRow(new Object[]{"Sale Rate",product.getSaleRate()});
			tableModel.addRow(new Object[]{"Whole Sale Rate",product.getWholesaleRate()});
			tableModel.addRow(new Object[]{"Online Sale Rate",product.getOnlineRate()});
			tableModel.addRow(new Object[]{"Vat Percent",product.getVatPercent()});
			tableModel.addRow(new Object[]{"Low Level Qty",product.getLowQuantity()});
			tableModel.addRow(new Object[]{"Store Name",storeName});
			
			
		}

		JOptionPane.showConfirmDialog(null, infoPanel, "Information",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
	}

}
