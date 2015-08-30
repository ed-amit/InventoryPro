package com.lrd.inventory.utility;

import java.io.IOException;

public class Calculator {

	public Calculator() {
		ProcessBuilder pb=new ProcessBuilder("calc.exe");
		try {
			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
