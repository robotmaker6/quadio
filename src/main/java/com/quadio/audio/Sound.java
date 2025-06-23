package com.quadio.audio;
import javazoom.jl.player.Player;
import java.io.FileInputStream;
import java.io.InputStream;
public class Sound {
	private String filename;
	private Player player;
	public Sound(String filename) {
		this.filename = filename;
	}
	public void play() {
		try {
			InputStream is = new FileInputStream(filename);
			player = new Player(is);
			player.play();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void stop() {
		try {
			player.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
