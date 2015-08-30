package com.lrd.inventory.utility;

import java.io.IOException;

public class NotePad {

	public NotePad() {
		ProcessBuilder pb=new ProcessBuilder("Notepad.exe");
		try {
			pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
