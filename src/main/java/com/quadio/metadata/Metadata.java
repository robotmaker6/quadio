package com.quadio.metadata;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.FieldKey;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.File;
public class Metadata {
	private String filename;
	private String title;
	private String artist;
	private String year;
	private String album;
	public Metadata(String filename) {
		this.filename = filename;
	}
	public void load() throws Exception {
		Logger.getLogger("org.jaudiotagger").setLevel(Level.WARNING);
		File file = new File(filename);
		AudioFile audioFile = AudioFileIO.read(file);
		Tag tag = audioFile.getTag();
		this.title = tag.getFirst(FieldKey.TITLE);
		this.artist = tag.getFirst(FieldKey.ARTIST);
		this.year = tag.getFirst(FieldKey.YEAR);
		this.album = tag.getFirst(FieldKey.ALBUM);
	}
	public String getField(String fieldName) throws UnknownFieldException {
		if (fieldName == null) {
			throw new UnknownFieldException("null");
		}
		
		switch (fieldName.toUpperCase()) {
		case "TITLE":
			return title;
		case "ARTIST":
			return artist;
		case "YEAR":
			return year;
		case "ALBUM":
			return album;
		default:
			throw new UnknownFieldException(fieldName);
		}
	}
}
