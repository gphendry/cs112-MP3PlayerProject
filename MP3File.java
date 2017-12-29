/**
* MP3 File class
* 
* A class that represents a single MP3 audio file and all of its data 
*
* Author: Graham Hendry
**/


import org.jaudiotagger.audio.AudioFile;

import java.util.Comparator;

public class MP3File implements Comparable<MP3File> {

	/**
	* Data members
	**/

	private AudioFile mp3Audio;

	private String songTitle;

	private String artist;

	private int songLength;

	/**
	* Constructor
	**/

	public MP3File(AudioFile mp3Audio, String songTitle, String artist, int songLength) {

		this.mp3Audio = mp3Audio;
		this.songTitle = songTitle;
		this.artist = artist;
		this.songLength = songLength;

	}

	/**
	* Get/Set methods
	**/

	public AudioFile getAudio() {
		return this.mp3Audio;
	}

	public String getTitle() {
		return this.songTitle;
	}

	public String getArtist() {
		return this.artist;
	}

	public int getLength() {
		return this.songLength;
	}

	/**
	* toString Method
	**/

	public String toString() {
		String result = "";

		result += "Song Title: " + songTitle;
		result += " - Artist: " + artist;
		result += " - Song Length: " + songLength + " seconds";

		return result;
	}

	/**
	* compareTo method
	**/

	public int compareTo(MP3File other) {
		if (this.artist.equals(other.getArtist())) {
			return this.songTitle.compareTo(other.getTitle());
		}

		return this.artist.compareTo(other.getArtist());
	}

	// Comparator for sorting MP3File objects by song title
	public static Comparator<MP3File> byTitle = new Comparator<MP3File>() {

		public int compare(MP3File f1, MP3File f2) {

			String title1 = f1.getTitle();

			String title2 = f2.getTitle();

			return title1.compareTo(title2);
			
		}
	};

	// Comparator for sorting MP3File objects by artist
	public static Comparator<MP3File> byArtist = new Comparator<MP3File>() {

		public int compare(MP3File f1, MP3File f2) {

			String artist1 = f1.getArtist();

			String artist2 = f2.getArtist();

			return artist1.compareTo(artist2);

		}
	};



}