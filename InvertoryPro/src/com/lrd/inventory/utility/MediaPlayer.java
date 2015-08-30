package com.lrd.inventory.utility;

import java.io.IOException;
import java.util.Map;

public class MediaPlayer {

	public MediaPlayer() {
		int flag=0;
		ProcessBuilder pb=new ProcessBuilder();
		Map<String, String> env = pb.environment();
		String path1 = env.get("ProgramFiles");
		String path2 = env.get("ProgramFiles(x86)");

		pb=new ProcessBuilder(path1+"/Windows Media Player/wmplayer.exe");
		try {pb.start();	flag=1;} catch (IOException e) {	e.printStackTrace(); }

		if(flag==0){
			pb=new ProcessBuilder(path2+"/Windows Media Player/wmplayer.exe");
			try {pb.start();	flag=1;} catch (IOException e) {	e.printStackTrace(); }
		}
	}

	public static void main(String[] args){
		new MediaPlayer();
	}

}
