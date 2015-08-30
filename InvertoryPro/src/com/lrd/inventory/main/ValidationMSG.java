package com.lrd.inventory.main;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

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
		// TODO Auto-generated constructor stub
		String str=formatMsg(Msg);
		
		
		dialog = new JDialog();
		button=new JButton();
		label=new JLabel(str);
		panel=new JPanel();

		dialog.setLayout(null);

		//-----panel--------
		{
			panel.setLayout(null);


			panel.add(label);
			label.setBounds(20,20,260,label.getPreferredSize().height);
			//label.setMaximumSize(new Dimension(240,60));



			button.setText("OK");
			panel.add(button);
			button.setBounds(100, label.getPreferredSize().height+30, 100, 20);


			button.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent ae) 
				{
					dialog.dispose();
				}
			});
		}
		
		panel.setBorder(new LineBorder(Color.RED, 2));
		panel.setBounds(0, 0, 300, button.getY()+30);
		dialog.add(panel);
		dialog.setModal(true);
		dialog.setTitle("Warning......");
		dialog.setLocationRelativeTo(parent);
		dialog.pack();
		dialog.setSize(320, button.getY()+70);
		dialog.setVisible(true);
	}

	private String formatMsg(String msg) {
		// TODO Auto-generated method stub
		String finalStr="<html>";
		boolean linebreak;
        int chunkSize = 40;
        int stringLength = msg.length();
        for (int i = 0; i < stringLength ; i += chunkSize)
        {
            if (i + chunkSize > stringLength){
            	chunkSize = stringLength  - i;
            	linebreak=false;
            }else{
            	linebreak=true;
            }
            finalStr+=msg.substring(i, chunkSize+i);
            
            if(linebreak)
            	finalStr+="<br>";

        }
       
		finalStr+="</html>";
		return finalStr;
	}

}
