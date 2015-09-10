package com.lrd.inventory.main;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class PromptDailog {

	public PromptDailog() {
		// TODO Auto-generated constructor stub
		JDialog.setDefaultLookAndFeelDecorated(true);
	}

	public boolean getUserResponse() {
		int response = JOptionPane.showConfirmDialog(null,
				"Do you want to continue?", "Confirm",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (response == JOptionPane.YES_OPTION) {
			//System.out.println("Yes button clicked");
			return true;
		}
		
		return false;
	}
	
}
