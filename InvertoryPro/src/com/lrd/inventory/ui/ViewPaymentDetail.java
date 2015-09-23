package com.lrd.inventory.ui;

import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.lrd.inventory.model.PaymentModel;

public class ViewPaymentDetail {

	private JPanel infoPanel;
	private JScrollPane scrollPane;
	private DefaultTableModel tableModel;
	private JTable table;

	public ViewPaymentDetail(ArrayList<PaymentModel> paymentList) {
		// TODO Auto-generated constructor stub
		JDialog.setDefaultLookAndFeelDecorated(true);

		infoPanel = new JPanel();
		scrollPane = new JScrollPane();
		tableModel = new DefaultTableModel();
		table = new JTable(tableModel);
		{
			tableModel.addColumn("Bank Name");
			tableModel.addColumn("Cheque No");
			tableModel.addColumn("Paid Amount");
			tableModel.addColumn("Payment Date");
			tableModel.addColumn("Payment Mode");

			// ======== scrollPane2 ========
			{
				scrollPane.setViewportView(table);
			}
			infoPanel.add(scrollPane);
			scrollPane.setBounds(0, 0, 300, 300);
			
				for (PaymentModel payment : paymentList) {

					tableModel
							.addRow(new Object[]{payment.getBankName(),
									payment.getCode(), payment.getPaidAmt(),
									payment.getPaymentDate(),
									payment.getPaymentMode()});
				}
			

		}

		JOptionPane.showConfirmDialog(null, infoPanel, "Information",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
	}

}
