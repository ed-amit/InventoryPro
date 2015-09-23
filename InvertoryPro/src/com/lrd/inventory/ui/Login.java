package com.lrd.inventory.ui;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;

import javax.swing.*;

import com.lrd.inventory.database.DatabaseConnection;
import com.lrd.inventory.database.GetDBValue;
import com.lrd.inventory.main.Validate;

/**
 * @author dharmendra singh
 */
public class Login extends JFrame implements ActionListener{
	
	private static final int FRAME_HEIGHT=300;
	private static final int FRAME_WIDTH=400;

	// Variables declaration 
	private JPanel panel1;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JButton button1;
	private JButton button2;
	private JTextField textField1;
	private JPasswordField passwordField1;
	//  End of variables declaration  
	private static final long serialVersionUID = 1L;


	Connection connection = null;


	public Login() {
		initComponents();
		connection = new DatabaseConnection().getConnection();

	}



	private void initComponents() {
		// Component initialization 
		panel1 = new JPanel();
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		button1 = new JButton();
		button2 = new JButton();
		textField1 = new JTextField();
		passwordField1 = new JPasswordField();



		//======== this ========
		setBackground(new Color(204, 255, 255));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setForeground(Color.white);
		Container contentPane = getContentPane();
		contentPane.setLayout(null);


		//======== panel1 ========
		{
			panel1.setBorder(UIManager.getBorder("TitledBorder.border"));
			panel1.setLayout(null);

			//---- label1 ----
			label1.setText("User Login");
			label1.setFont(new Font("Dialog", Font.BOLD|Font.ITALIC, 15));
			panel1.add(label1);
			label1.setBounds(150,10,100,30);

			//---- label2 ----
			label2.setText("User Name");
			panel1.add(label2);
			label2.setBounds(50, 90, 100, 25);

			//---- label3 ----
			label3.setText("password");
			panel1.add(label3);
			label3.setBounds(50, 150, 100, 25);

			//---- button1 ----
			button1.setText("Login");
			panel1.add(button1);
			button1.setBounds(80, 250, 100, 25);

			//---- button2 ----
			button2.setText("Cancel");
			button2.addActionListener(this);
			panel1.add(button2);
			button2.setBounds(220, 250, 100, 25);
			panel1.add(textField1);
			textField1.setBounds(150, 90, 200, 25);
			panel1.add(passwordField1);
			passwordField1.setBounds(150, 150, 200, 25);

		}
		contentPane.add(panel1);
		panel1.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);


		contentPane.setSize(FRAME_WIDTH, FRAME_HEIGHT);


		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setUndecorated(true);
		setVisible(true);
		setLocationRelativeTo(null);
	}



	public static void main(String[] args){

		new Login();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="Cancel"){
			dispose();
		}
		if(e.getActionCommand()=="Login"){
			String userName = textField1.getText();
			String password = passwordField1.getText();
			if(!new Validate().isEmpty(userName) &&
					 new Validate().isEmpty(password)){
				new GetDBValue(connection).checkLogin(userName,password);
			}
		}
	}
}
