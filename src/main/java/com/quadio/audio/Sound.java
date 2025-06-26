package com.quadio.audio;
import javazoom.jl.player.Player;
import java.io.FileInputStream;
import java.io.InputStream;
public class Sound {
	private String filename;
	private Player player;
	private boolean isPlaying;
	public Sound(String filename) {
		this.filename = filename;
	}
	public void play() {
		try {
			InputStream is = new FileInputStream(filename);
			player = new Player(is);
			player.play();
			isPlaying = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void stop() {
		try {
			player.close();
			isPlaying = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean playing() {
		return isPlaying;
	}
}
