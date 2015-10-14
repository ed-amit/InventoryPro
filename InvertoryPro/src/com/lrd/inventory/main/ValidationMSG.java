package com.lrd.inventory.main;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ValidationMSG {

	
	JDialog dialog;
	JButton button ;
	JLabel label ;
	JPanel panel ;
	/**
	 * 
	 * @param parentFrame
	 * @param Msg To Show
	 */
	public ValidationMSG(JFrame parent , String Msg) {
		JDialog.setDefaultLookAndFeelDecorated(true);
		JOptionPane.showMessageDialog (parent, Msg);
		
	}

}
