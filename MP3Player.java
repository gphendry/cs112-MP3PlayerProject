/**
* MP3 File Player class
* 
* A class for controlling playback of MP3 files 
*
* Author: Graham Hendry
**/

import java.util.ArrayList;

import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MP3Player {

	/**
	* Data Members
	**/

	private int songChoice;

	private MP3List playlist;

	private Player player;

	/**
	* Constructor
	**/

	public MP3Player(int songChoice, MP3List playlist) {

		try {
			this.songChoice = songChoice;
			this.playlist = playlist;
			this.player = new Player(new FileInputStream(playlist.getSelectionAudio(songChoice).getFile()));
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	// plays the selected MP3 File
	public void playSong() {


		Thread t = new Thread() {

			public void run() {

				try {
					player.play();

				}catch(Exception e) {
					e.printStackTrace();
				}

			}
			
		};

		t.start();


	}

	public void stopSong() {
		player.close();
	}

}

