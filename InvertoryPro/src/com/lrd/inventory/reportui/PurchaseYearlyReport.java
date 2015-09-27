package com.lrd.inventory.reportui;



import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PurchaseYearlyReport  extends JFrame
implements
ItemListener,
ActionListener
 {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JScrollPane scrollPane1;

	private DefaultTableModel tableModel1;
	private JTable table1;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JButton button2;
	private JButton button3;
	private JButton button1;
	private JComboBox<Object> comboBox1;
	private JComboBox<Object> comboBox2;
	private JComboBox<Object> comboBox3;

	
	public PurchaseYearlyReport() {
		// TODO Auto-generated constructor stub
		 initComponents();	
	}
	public PurchaseYearlyReport(Connection connection) {
		// TODO Auto-generated constructor stub
		 initComponents();	
	}
	// creating UI for Frame
	private void initComponents() {
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		scrollPane1 = new JScrollPane();

		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel("Select Month");
		button1 = new JButton("Search");
		button2 = new JButton("Cancel");
		button3 = new JButton("Print");
		comboBox1 = new JComboBox<Object>();
		comboBox2 = new JComboBox<Object>();
		comboBox3 = new JComboBox<Object>();
		tableModel1 = new DefaultTableModel();
		table1 = new JTable(tableModel1);
		

		// ======== this ========
		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		// ======== panel1 ========
				{
					panel1.setLayout(null);
					// ======== panel2 ========
					{
						JLabel label4 = new JLabel("Purchase Yearly Report");
						panel2.add(label4);
						label4.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
						label4.setBounds(200, 10, 300, 30);
						panel2.setLayout(null);
						
						// ---- label27 ----
						label1.setText("Select Store");
				//		label1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
						panel2.add(label1);
						label1.setBounds(20, 50, 80, 20);
						
						panel2.add(comboBox3);
						comboBox3.setBounds(100, 50, 200, 20);
						comboBox3.addItem("Select Store");
						

					}
					panel1.add(panel2);
					panel2.setBounds(0, 0, 600, 70);
					// ======== panel3 ========
					{
						panel3.setLayout(null);
						// ---- label27 ----
						
						label3.setText("Select Year");
						panel3.add(label3);
						label3.setBounds(20, 20, 80, 20);
						
						
						panel3.add(comboBox2);
						comboBox2.setBounds(100, 20, 100, 20);
						comboBox2.addItem("Select Year");
						
						// ---- button2 ----
						button1.setText("Search");
						panel3.add(button1);
						button1.setBounds(100 ,60, 80, 20);
						
						// ---- button2 ----
						button2.setText("Cancel");
						panel3.add(button2);
						button2.setBounds(200, 60, 80, 20);
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
						scrollPane1.setBounds(10, 90, 570, 390);

						
						

					}//end panel 3
					panel1.add(panel3);
					panel3.setBounds(0, 70, 600, 485);
					// ======== panel4 ========
					{
					
						panel4.setLayout(null);
					
						// ---- button2 ----
						button3.setText("Print");
						panel4.add(button3);
						button3.setBounds(200, 0, 100, 20);
					}//end panel 4
					
					panel1.add(panel4);
					panel4.setBounds(0, 560,600,30);
				}//end panel 1
				
				add(panel1);
				panel1.setBounds(0, 0, 600, 600);
		
				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				//pack();
				setVisible(true);
				//setLocation(-5, 0);
				setSize(610, 630);

	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	public static void main(String[] args){
		new PurchaseYearlyReport();
	}
}
