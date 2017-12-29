/**
* MP3 File List class
*
* A class containing an ArrayList of MP3File objects and several methods to operate on the list
*
* Author: Graham Hendry
**/

import java.util.ArrayList;
import java.util.Collections;
import org.jaudiotagger.audio.AudioFile;

public class MP3List {

	/**
	* Data Members
	**/

	private ArrayList<MP3File> mp3Files;

	/**
	* Constructor
	**/

	public MP3List() {
		this.mp3Files = new ArrayList<MP3File>();
	}

	/**
	* Class Methods
	**/

	// adds a new MP3File object to the list
	public void addMP3File(MP3File newFile) {
		mp3Files.add(newFile);
	}

	// sorts MP3 file list using MP3File default compareTo method
	public void sortMP3Files() {
		Collections.sort(mp3Files);
	}

	// returns ArrayList of all MP3s in the list sorted by song title
	// TODO: Replace with sorting algorithm that returns usable data structure of MP3Files
	public void sortByTitle() {

		Collections.sort(mp3Files, MP3File.byTitle);
		
	}

	// returns ArrayList of all MP3s in the list sorted by artist
	// TODO: Replace with sorting algorithm that returns usable data structure of MP3Files
	public void sortByArtist() {

		Collections.sort(mp3Files, MP3File.byArtist);

	}

	// Gets a selected AudioFile object from the file list
	public AudioFile getSelectionAudio(int selection) {
		if (selection <= mp3Files.size() && selection > 0) {
			return mp3Files.get(selection - 1).getAudio();
		}

		System.out.println("Invalid song selection");
		return null;
	}

	// returns a specific MP3File object from the list
	public MP3File getItem(int selection) {
		return this.mp3Files.get(selection);
	}

	// returns size of MP3 playlist
	public int getPlaylistSize() {
		return this.mp3Files.size();
	}

	// toString method
	public String toString() {
		String result = "";

		for (int i = 0; i < mp3Files.size(); i++) {
			result += "\t" + (i+1) + ". "+ mp3Files.get(i).toString() + "\n";
		}

		return result;

	}



}