package com.lrd.inventory.ui;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.lrd.inventory.database.ConnectionTester;

public class SettingSingleUser extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public final static String DRIVER = "driver";
	public final static String URL1 = "url1";
	public final static String SERVER = "server";
	public final static String PORT = "port";
	public final static String DATABASE = "database_name";
	public final static String USER = "user";
	public final static String PASSWORD = "password";
	public final static String TABLE_PREFIX = "tableprefix";

	private JPanel panel1;
	private JPanel panel2;
	private JLabel label1;
	private JPanel panel3;
	private JLabel label2;
	private JTextField textField1;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label8;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JLabel label7;
	private JTextField textField6;

	boolean status;
	Properties db_properties;

	public SettingSingleUser() {
		// TODO Auto-generated constructor stub
		initComponents();
		getpropetyvalue();
		//textField1.setEnabled(false);
	}

	private void initComponents() {
		panel1 = new JPanel();
		panel2 = new JPanel();
		label1 = new JLabel();
		panel3 = new JPanel();
		label2 = new JLabel();
		textField1 = new JTextField();
		label3 = new JLabel();
		label4 = new JLabel();
		label5 = new JLabel();
		label6 = new JLabel();
		textField2 = new JTextField();
		textField3 = new JTextField();
		textField4 = new JTextField();
		textField5 = new JTextField();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		label7 = new JLabel();
		label8 = new JLabel();
		textField6 = new JTextField();

		// ======== this ========
		setLayout(null);

		// ======== panel1 ========
		{
			panel1.setLayout(null);

			// ======== panel2 ========
			{
				panel2.setLayout(null);

				// ---- label1 ----
				label1.setText("MySql Database Connection");
				label1.setFont(label1.getFont().deriveFont(
						label1.getFont().getSize() + 15f));

				panel2.add(label1);
				label1.setBounds(new Rectangle(new Point(145, 10), label1
						.getPreferredSize()));
			}
			panel1.add(panel2);
			panel2.setBounds(0, 0, 650, 60);

			// ======== panel3 ========
			{
				panel3.setLayout(null);

				// ---- label2 ----
				label2.setText("Server Name Or IP Address");
				// label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize()
				// + 3f));
				label2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				panel3.add(label2);
				label2.setBounds(30, 50, 200, label2.getPreferredSize().height);
				panel3.add(textField1);
				textField1.setBounds(250, 50, 200,
						textField1.getPreferredSize().height);

				// ---- label3 ----
				label3.setText("Port No");
				// label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize()
				// + 3f));
				label3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				panel3.add(label3);
				label3.setBounds(30, 100, 200, label3.getPreferredSize().height);

				// ---- label4 ----
				label4.setText("Database Name");
				// label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize()
				// + 3f));
				label4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				panel3.add(label4);
				label4.setBounds(30, 150, 200, label4.getPreferredSize().height);

				// ---- label5 ----
				label5.setText("User Name");
				// label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize()
				// + 3f));
				label5.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				panel3.add(label5);
				label5.setBounds(30, 200, 200, label5.getPreferredSize().height);

				// ---- label6 ----
				label6.setText("Password");
				// label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize()
				// + 3f));
				label6.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				panel3.add(label6);
				label6.setBounds(30, 250, 200, label6.getPreferredSize().height);
				panel3.add(textField2);
				textField2.setBounds(250, 100, 200,
						textField2.getPreferredSize().height);
				panel3.add(textField3);
				textField3.setBounds(250, 150, 200,
						textField3.getPreferredSize().height);
				panel3.add(textField4);
				textField4.setBounds(250, 200, 200,
						textField4.getPreferredSize().height);
				panel3.add(textField5);
				textField5.setBounds(250, 250, 200,
						textField5.getPreferredSize().height);

				// ---- button1 ----
				button1.setText("Test Connection");
				panel3.add(button1);
				button1.setBounds(150, 370, 115, 40);
				button1.addActionListener(this);

				// ---- button2 ----
				button2.setText("Clear");
				panel3.add(button2);
				button2.setBounds(295, 370, 100, 40);
				button2.addActionListener(this);

				// ---- button3 ----
				button3.setText("Exit");
				panel3.add(button3);
				button3.setBounds(425, 370, 100, 40);
				button3.addActionListener(this);

				// ---- label7 ----
				label7.setText("Table Prefix");
				// label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize()
				// + 3f));
				label7.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				panel3.add(label7);
				label7.setBounds(30, 300, 200, label7.getPreferredSize().height);
				panel3.add(textField6);
				textField6.setBounds(250, 300, 200,
						textField6.getPreferredSize().height);
				textField6.setEnabled(false);

				panel3.add(label8);
				label8.setBounds(30, 330, 300, 20);
			}
			panel1.add(panel3);
			panel3.setBounds(0, 60, 650, 465);
		}
		add(panel1);
		panel1.setBounds(0, 0, 650, 525);

		setTitle("Configure Connection");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setSize(650, 530);
		setLocationRelativeTo(getOwner());
		setVisible(true);

	}

	private void getpropetyvalue() {
		db_properties = new Properties();
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(System.getProperty("user.home")+"/DB_Variables.properties");
			db_properties.load(inputStream);
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		textField1.setText(db_properties.getProperty(SERVER));
		textField2.setText(db_properties.getProperty(PORT));
		textField3.setText(db_properties.getProperty(DATABASE));
		textField4.setText(db_properties.getProperty(USER));
		textField5.setText(db_properties.getProperty(PASSWORD));
		textField6.setText(db_properties.getProperty(TABLE_PREFIX));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == button2) {
			// textField1.setText("");
			textField2.setText("");
			textField3.setText("");
			textField4.setText("");
			textField5.setText("");
			// textField6.setText("");
			label8.setText("");
		}

		if (e.getSource() == button3) {
			if (status == true) {
				new MasterHome("");
				this.dispose();
			}
			
		}

		if (e.getSource() == button1) {
			String[] str = new String[9];
			str[0] = db_properties.getProperty("driver");
			str[1] = db_properties.getProperty("url1");
			str[2] = textField1.getText();
			str[3] = textField2.getText();
			str[4] = textField3.getText();
			str[5] = textField4.getText();
			str[6] = textField5.getText();
			str[7] = textField6.getText();
			str[8] = db_properties.getProperty("url2");

			db_properties.setProperty(SERVER, str[2]);
			db_properties.setProperty(PORT, str[3]);
			db_properties.setProperty(DATABASE, str[4]);
			db_properties.setProperty(USER, str[5]);
			db_properties.setProperty(PASSWORD, str[6]);
			db_properties.setProperty(TABLE_PREFIX, str[7]);

			if (!new ConnectionTester().testConnection(db_properties)) {
				textField1.setText(db_properties.getProperty(SERVER));
				textField2.setText(db_properties.getProperty(PORT));
				textField3.setText(db_properties.getProperty(DATABASE));
				textField4.setText(db_properties.getProperty(USER));
				textField5.setText(db_properties.getProperty(PASSWORD));
				textField6.setText(db_properties.getProperty(TABLE_PREFIX));
				label8.setForeground(Color.RED);
				label8.setText("Connection Fail !!!");
				status = false;
				button3.setEnabled(false);
			} else {
				try {
					FileOutputStream out = new FileOutputStream(
							System.getProperty("user.home")+"/DB_Variables.properties");

					db_properties.store(out, null);
					out.close();
					label8.setForeground(Color.GREEN.darker());
					label8.setText("Connection Success !!!");
					status = true;
					button3.setEnabled(true);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}


}
