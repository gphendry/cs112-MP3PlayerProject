/*
* MP3 File class tester
*/

// TODO: figure out why cannot find symbol error for MP3File class is produced during compile-time

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

import javazoom.jl.player.Player;


public class MusicPlayerDriver {

	public static void main(String[] args) {
		
		try {

			if (args.length != 1) {
				//print out how the program should be used and exit
				//if the argument is not passed correctly
				System.out.println("usage: java MusicPlayerDriver <absolute path>");
				System.out.println(args[0]);
				System.exit(1);
			}

			String absPath = args[0];

			MP3ListBuilder builder = new MP3ListBuilder();

			MP3List playlist = builder.findMP3Files(absPath);


			if (playlist != null) {
				
				MP3Menu menu = new MP3Menu(playlist);

				boolean displayMainMenu = true;
				
				while (displayMainMenu == true) {
					
					displayMainMenu = menu.displayMainMenu();

				}

				System.out.println("Exiting...");
				System.exit(1);
		

			} else {
				System.out.println("No MP3 list generated!");
				System.exit(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

		
	}

}