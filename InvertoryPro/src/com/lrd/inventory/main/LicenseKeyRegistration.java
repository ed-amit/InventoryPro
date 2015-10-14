package com.lrd.inventory.main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.json.*;

public class LicenseKeyRegistration extends JDialog
		implements
			KeyListener,
			ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;

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

	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;

	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	private JTextField textField7;
	private JTextField textField8;
	private JTextField textField9;
	// private JTextField textField10;
	private JTextField textField11;
	private JTextField textField12;
	private JTextField textField13;
	private JTextField textField14;

	private JTextArea textArea1;

	Validate valid;
	boolean status=false;
	
	String licenceKey="",regDate="",mac="",expDate="";
	
	String company = "", name = "", contact = "", email = "", address = "";
	String city = "", state = "", pincode = "", empId = "000000";

	public LicenseKeyRegistration(JFrame parent) {
		this.setModal(true);
		valid = new Validate();
		getMacId();
		initComponents(parent);
		
	}

	// creating UI for Frame
	private void initComponents(JFrame parent) {
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();

		textField1 = new JTextField();
		textField2 = new JTextField();
		textField3 = new JTextField();
		textField4 = new JTextField();
		textField5 = new JTextField();
		textField6 = new JTextField();
		textField7 = new JTextField();
		textField8 = new JTextField();
		textField9 = new JTextField();
		// textField10 = new JTextField();
		textField11 = new JTextField();
		textField12 = new JTextField();
		textField13 = new JTextField();
		textField14 = new JTextField();

		textArea1 = new JTextArea();

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

		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();

		// ======== this ========
		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		// ======== panel1 ========
		{
			panel1.setLayout(null);
			// ======== panel2 ========
			{
				panel2.setLayout(null);

				label1.setText("License Key Registration");
				panel2.add(label1);
				label1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
				label1.setBounds(120, 10, 300, 30);

			}
			panel1.add(panel2);
			panel2.setBounds(0, 0, 500, 50);

			// ======== panel3 ========
			{
				panel3.setLayout(null);

				// ---- label2 ----
				label2.setText("Enter License Key");
				panel3.add(label2);
				label2.setBounds(100, 50, 150, 30);

				panel3.add(textField1);
				textField1.setBounds(100, 100, 50, 20);
				textField1.addKeyListener(this);

				panel3.add(textField2);
				textField2.setBounds(160, 100, 50, 20);
				textField2.addKeyListener(this);

				panel3.add(textField3);
				textField3.setBounds(220, 100, 50, 20);
				textField3.addKeyListener(this);

				panel3.add(textField4);
				textField4.setBounds(280, 100, 50, 20);
				textField4.addKeyListener(this);

				panel3.add(textField5);
				textField5.setBounds(340, 100, 50, 20);
				textField5.addKeyListener(this);

				// ---- label3 ----
				label3.setText("Enter License Key");
				panel3.add(label3);
				label3.setBounds(100, 130, 150, 30);

				// ---- button3 ----
				button1.setText("Submit");
				panel3.add(button1);
				button1.setBounds(200, 200, 100, 20);
				button1.addActionListener(this);
			}
			panel1.add(panel3);
			panel3.setBounds(0, 70, 500, 300);

			{
				panel4.setLayout(null);
				label4.setText("Please Wait ...");
				panel4.add(label4);
				label4.setBounds(100, 50, 300, 30);

				// ---- button3 ----
				button3.setText("Next");
				panel4.add(button3);
				button3.setBounds(200, 200, 100, 20);
				button3.addActionListener(this);
				button3.setEnabled(false);

				// ---- button4 ----
				button4.setText("Finish");
				panel4.add(button4);
				button4.setBounds(350, 200, 100, 20);
				button4.addActionListener(this);
				
			}// end panel 5
			panel1.add(panel4);
			panel4.setBounds(0, 70, 500, 300);
			panel4.setVisible(false);

			// ======== panel6 ========
			{
				panel5.setLayout(null);
				// ---- label27 ----
				label5.setText("<html>Company Name <font color='red'><b>*</b></font></html>");
				panel5.add(label5);
				label5.setBounds(50, 10, 150, 20);

				panel5.add(textField6);
				textField6.setBounds(155, 10, 300, 20);

				label6.setText("<html>Person Name <font color='red'><b>*</b></font></html>");
				panel5.add(label6);
				label6.setBounds(50, 40, 150, 20);

				panel5.add(textField7);
				textField7.setBounds(155, 40, 300, 20);

				label7.setText("<html>Contact <font color='red'><b>*</b></font></html>");
				panel5.add(label7);
				label7.setBounds(50, 70, 150, 20);

				panel5.add(textField8);
				textField8.setBounds(155, 70, 300, 20);

				label8.setText("Email");
				panel5.add(label8);
				label8.setBounds(50, 100, 150, 20);

				panel5.add(textField9);
				textField9.setBounds(155, 100, 300, 20);

				label9.setText("<html>Address <font color='red'><b>*</b></font></html>");
				panel5.add(label9);
				label9.setBounds(50, 130, 150, 20);

				panel5.add(textArea1);
				textArea1.setBounds(155, 130, 300, 40);

				label10.setText("City");
				panel5.add(label10);
				label10.setBounds(50, 180, 150, 20);

				panel5.add(textField11);
				textField11.setBounds(155, 180, 300, 20);

				label11.setText("State");
				panel5.add(label11);
				label11.setBounds(50, 210, 150, 20);

				panel5.add(textField12);
				textField12.setBounds(155, 210, 150, 20);

				label12.setText("Pin");
				panel5.add(label12);
				label12.setBounds(310, 210, 50, 20);

				panel5.add(textField13);
				textField13.setBounds(360, 210, 95, 20);

				label13.setText("Employee Id");
				panel5.add(label13);
				label13.setBounds(50, 240, 150, 20);

				panel5.add(textField14);
				textField14.setBounds(155, 240, 300, 20);

				// ---- button2 ----
				button2.setText("Submit");
				panel5.add(button2);
				button2.setBounds(200, 270, 100, 20);
				button2.addActionListener(this);

			}
			panel1.add(panel5);
			panel5.setBounds(0, 70, 500, 300);
			panel5.setVisible(false);

		}// end panel 1

		add(panel1);
		panel1.setBounds(0, 0, 500, 400);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		
		setLocationRelativeTo(parent);
		setSize(500, 420);
		setTitle("LRD Technologies");
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if (event.getSource() == button1) {
			panel3.setVisible(false);
			panel4.setVisible(true);

			if (panel4.isVisible()) {
				licenceKey = textField1.getText() + textField2.getText()
						+ textField3.getText() + textField4.getText()
						+ textField5.getText();
				String url = "http://inventory.lrdtech.com/check_registration.php?key="
						+ licenceKey + "&mid=" + mac;
				//System.out.println(url);
				String netResult = getNetworkResponse(url);
				
				if (netResult.equals("success") && checkValidity()) {
					
					panel4.setVisible(false);
					panel5.setVisible(true);

				} else if (netResult.equals("success")) {
					label3.setForeground(Color.RED);
					label3.setText("Licence Key Expired..");
					panel3.setVisible(true);
					panel4.setVisible(false);
				}else if (netResult.equals("fail")) {
					label3.setForeground(Color.RED);
					label3.setText("Invalid Key...");
					panel3.setVisible(true);
					panel4.setVisible(false);
				} else {
					label4.setText("No network Connection Plz Try Again");
					System.out.println("No network connection");
				}
			}

		}

		if (event.getSource() == button2) {

			
			if (valid.isEmpty(textField7.getText())) {
				JOptionPane.showMessageDialog(this, "Please Insert your name.");
			} else if (valid.isEmpty(textField6.getText())) {
				JOptionPane.showMessageDialog(this,
						"Please Insert company name.");
			} else if (valid.isEmpty(textField8.getText())) {
				JOptionPane.showMessageDialog(this, "Please Insert Contact No");
			} else if (valid.isEmpty(textArea1.getText())) {
				JOptionPane.showMessageDialog(this, "Please Insert Address");
			} else {
				name=textField7.getText().toLowerCase();
				company=textField6.getText().toLowerCase();
				contact=textField8.getText().toLowerCase();
				if(!valid.isEmpty(textField9.getText()))
					email=textField9.getText().toLowerCase();
				address=textArea1.getText().toLowerCase();
				if(!valid.isEmpty(textField11.getText()))
					city=textField11.getText().toLowerCase();
				if(!valid.isEmpty(textField12.getText()))
					state=textField12.getText().toLowerCase();
				if(!valid.isEmpty(textField13.getText()))
					pincode=textField13.getText().toLowerCase();
				if(!valid.isEmpty(textField14.getText()))
					empId=textField14.getText().toLowerCase();
				
				
				
				name = name.replace("&", "&amp;");
				name = name.replace(" ", "%20");
				company = company.replace("&", "&amp;");
				company = company.replace(" ", "%20");
				contact = contact.replace("&", "&amp;");
				contact = contact.replace(" ", "%20");
				email = email.replace("&", "&amp;");
				email = email.replace(" ", "%20");
				address = address.replace("&", "&amp;");
				address = address.replace(" ", "%20");
				city = city.replace("&", "&amp;");
				city = city.replace(" ", "%20");
				state = state.replace("&", "&amp;");
				state = state.replace(" ", "%20");
				pincode = pincode.replace("&", "&amp;");
				pincode = pincode.replace(" ", "%20");
				empId = empId.replace("&", "&amp;");
				empId = empId.replace(" ", "%20");
				
				
				String url = "http://inventory.lrdtech.com/client_registration.php?company="
						+ company
						+ "&name="
						+ name
						+ "&contact="
						+ contact
						+ "&email="
						+ email
						+ "&address="
						+ address
						+ "&city="
						+ city
						+ "&state="
						+ state
						+ "&pincode="
						+ pincode
						+ "&mac=" + mac + "&empid=" + empId;
				System.out.println(url);
				String netResult = getNetworkResponse(url);
				if (netResult.equals("success")) {
					panel5.setVisible(false);
					panel4.setVisible(true);
					label4.setText("Congrets Registration Success.");
					writeDataToProperty();
				} else if (netResult.equals("fail")) {
					// label2.setText("Something going wrong Try Again");
					panel5.setVisible(true);
					panel4.setVisible(false);
				} else {
					label4.setText("No network Connection Plz Try Again");
				}
			}
		}
		
		if(event.getSource()==button4){
			status=true;
			this.dispose();
		}
	}
	private String getMacId() {
		try {
			InetAddress iAddress = InetAddress.getLocalHost();
			NetworkInterface nInterface = NetworkInterface
					.getByInetAddress(iAddress);

			if (nInterface == null) {
				return null;
			}

			byte[] mac = nInterface.getHardwareAddress();
			if (mac == null) {
				return null;
			}

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < mac.length; i++) {
				sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1)
						? "-"
						: ""));
			}
			this.mac = sb.toString();
			return sb.toString();
		} catch (Exception e) {
		}
		return null;

	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent event) {
		// TODO Auto-generated method stub
		if (event.getSource() == textField1) {
			String str = textField1.getText();
			if (str.length() >= 5) {
				textField2.requestFocus();
			}
		}
		if (event.getSource() == textField2) {
			String str = textField2.getText();
			if (str.length() >= 5)
				textField3.requestFocus();
		}
		if (event.getSource() == textField3) {
			String str = textField3.getText();
			if (str.length() >= 5)
				textField4.requestFocus();
		}
		if (event.getSource() == textField4) {
			String str = textField4.getText();
			if (str.length() >= 5)
				textField5.requestFocus();
		}

		if (event.getSource() == textField5) {
			String str = textField5.getText();
			if (str.length() >= 5)
				button1.requestFocus();
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	private String getNetworkResponse(String urlString) {
		URL url;
		try {
			url = new URL(urlString);
			InputStreamReader in = new InputStreamReader(url.openStream());

			JsonReader jsonReader = Json.createReader(in);
			JsonObject jsonObject = jsonReader.readObject();
			in.close();
			jsonReader.close();

			if (jsonObject.getBoolean("licence")) {
				if (jsonObject.getBoolean("detail")) {
					setUserDetail(jsonObject.getJsonObject("client"));
					regDate = jsonObject.getString("lreg");
					setExpDate();
				}
				return "success";
			} else {
				return "fail";
			}
		} catch (MalformedURLException e) {
			return "";
		} catch (IOException e) {
			return "";
		}
	}

	private void setUserDetail(JsonObject jsonObject) {

		textField7.setText(jsonObject.getString("company_name"));
		textField6.setText(jsonObject.getString("name"));
		textField8.setText(jsonObject.getString("contact"));
		textField9.setText(jsonObject.getString("email"));
		textArea1.setText(jsonObject.getString("address"));
		textField11.setText(jsonObject.getString("city"));
		textField12.setText(jsonObject.getString("state"));
		textField13.setText(jsonObject.getString("pincode"));
		textField14.setText(jsonObject.getString("emp_id"));

		// all field should be disabled

	}
	
	private void setExpDate(){
		String untildate=regDate;   
		SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd" );   
		Calendar cal = Calendar.getInstance();    
		try {
			cal.setTime( dateFormat.parse(untildate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
		cal.add( Calendar.YEAR, 1 );    
		expDate=dateFormat.format(cal.getTime());
	}
	
	private boolean checkValidity(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			System.out.println(expDate);
			Date currentDate = sdf.parse(new DatePicker().getCurrentDate());
			Date expDate = sdf.parse(this.expDate);
			if(currentDate.before(expDate))
				return true;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean getStatus(){
		return status;
	}
	
	
	private void writeDataToProperty(){
		InputStream inputStream;
		Properties regProperties = new Properties();
		File file = null;
		try {

			file = new File(System.getProperty("user.home")
					+ "/owner.properties");
			if (file.exists()) {
				inputStream = new FileInputStream(
						System.getProperty("user.home")
								+ "/owner.properties");
				regProperties.load(inputStream);
				inputStream.close();
			}
			
			
			
			
			String tempRegDate=regDate.substring(0,4)+regDate.substring(5,7)+regDate.substring(8);
			String tempExpDate=expDate.substring(0,4)+expDate.substring(5,7)+expDate.substring(8);
			
			
			
			regProperties.setProperty("company_name", company);
			regProperties.setProperty("licence_key", licenceKey);
			regProperties.setProperty("status", "1111");
			regProperties.setProperty("date_code1", tempRegDate);
			regProperties.setProperty("date_code2", tempExpDate);
			regProperties.setProperty("owner_name", name);
			regProperties.setProperty("address", address);
			regProperties.setProperty("city", city);
			regProperties.setProperty("state", state);
			regProperties.setProperty("pin", pincode);
			regProperties.setProperty("contact", contact);
			regProperties.setProperty("email", email);
			
			
			
			FileOutputStream out = new FileOutputStream(
					System.getProperty("user.home")
							+ "/owner.properties");

			regProperties.store(out, null);
			out.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
