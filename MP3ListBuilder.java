/**
* MP3 File List Builder class
* 
* A class for building a list of MP3File objects recursively 
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

public class MP3ListBuilder {
	
	// Recursively builds a list of MP3File objects from a given directory
	public static MP3List findMP3Files(String directory) {

		File path = new File(directory);

		// returns an MP3List if the given path is valid
		if (path.exists()) {
			MP3List result = new MP3List();
			findMP3Files(path, result);
			return result;
		} else {
			return null;
		}



	}

	// private helper method
	private static void findMP3Files(File input, MP3List result) {

		MP3Builder builder = new MP3Builder();


		// checks if input is both file and .mp3 file
		if (input.isFile()) {

			String filename = input.getName();

			String extension = "";

			// gets extension of file and checks if it is a .mp3 file
			if (filename.contains(".")) {
				extension = filename.substring(filename.lastIndexOf('.'), filename.length());

				// analyzes .mp3 files found and adds them to list
				if (extension.equals(".mp3")) {
					
					MP3File newFile = builder.buildMP3(input);

					result.addMP3File(newFile);

				}
			}

		} else {

			File[] children = input.listFiles();

			if (children != null) {
				for (File f : children) {
					findMP3Files(f, result);
				}
			}
		}
		
	}
}