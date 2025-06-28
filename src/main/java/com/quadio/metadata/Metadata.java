package com.quadio.metadata;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Metadata {
    private final String filename;
    private AudioFile audioFile;
    private Tag tag;
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
        audioFile = AudioFileIO.read(file);
        tag = audioFile.getTagOrCreateAndSetDefault();
        title  = tag.getFirst(FieldKey.TITLE);
        artist = tag.getFirst(FieldKey.ARTIST);
        year   = tag.getFirst(FieldKey.YEAR);
        album  = tag.getFirst(FieldKey.ALBUM);
    }
    public String getField(Field f) throws UnknownFieldException {
        switch (f) {
            case TITLE:  return title;
            case ARTIST: return artist;
            case YEAR:   return year;
            case ALBUM:  return album;
            default:     throw new UnknownFieldException(f.name());
        }
    }
    public void setField(Field f, String value) throws UnknownFieldException, Exception {
        FieldKey key;

        switch (f) {
            case TITLE:  title  = value; key = FieldKey.TITLE;  break;
            case ARTIST: artist = value; key = FieldKey.ARTIST; break;
            case YEAR:   year   = value; key = FieldKey.YEAR;   break;
            case ALBUM:  album  = value; key = FieldKey.ALBUM;  break;
            default: throw new UnknownFieldException(f.name());
        }

        tag.setField(key, value);
    }
    public void save() throws Exception {
        AudioFileIO.write(audioFile);
    }
}
