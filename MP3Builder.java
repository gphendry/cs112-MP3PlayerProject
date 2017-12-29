/**
* MP3 File Bulider class
*
* A class for generating MP3File objects from a specified File object
*
* Author: Graham Hendry
**/

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

public class MP3Builder {

	public MP3File buildMP3(File inFile) {

		try {

			// gets all MP3 data from specified File
			AudioFile mp3Audio = AudioFileIO.read(inFile);
			Tag tag = mp3Audio.getTag();
			String title = tag.getFirst(FieldKey.TITLE);
			String artist = tag.getFirst(FieldKey.ARTIST);
			int length = mp3Audio.getAudioHeader().getTrackLength();

			return new MP3File(mp3Audio, title, artist, length);

		} catch(Exception e) {
			System.out.println("Problem reading MP3 file!");
			return null;
		}


	} 

}