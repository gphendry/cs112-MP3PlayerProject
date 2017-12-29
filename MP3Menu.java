/**
* Switch-Operated MP3 Text Menu class
*
* Class for implementing text-based menu system for MP3 music player
*
* Author: Graham Hendry
**/

import java.util.Scanner;
import java.util.ArrayList;
import javazoom.jl.player.Player;

// TODO: rework logic to use booleans rather than break statements
public class MP3Menu {

	/**
	* Data Members
	**/

	private Scanner input;

	private MP3List playlist;

	/**
	* Constructor
	**/

	public MP3Menu(MP3List playlist) {
		this.playlist = playlist;
		this.input = new Scanner(System.in);
	}

	// displays main first-level menu options
	public boolean displayMainMenu() {

		System.out.println("***~~~Music Player Main Menu~~~***");
		System.out.println("Select Option:");
		System.out.println("1. List MP3s By Song Title");
		System.out.println("2. List MP3s By Artist");
		System.out.println("3. Play MP3");
		System.out.println("4. Exit");

		int selection = input.nextInt();
		input.nextLine();



		// handles supplied user input and performs selected option
		// NOTE: All case options must have break statement at end
		switch (selection) {
			case 1:
				System.out.println("MP3s Sorted By Title:");
				playlist.sortByTitle();
				System.out.println(playlist.toString());
				return true;
			case 2:
				System.out.println("MP3s By Artist:");
				playlist.sortByArtist();
				System.out.println(playlist.toString());
				return true;
			case 3:
				System.out.println("Play Which File #? (Enter -1 to return to Menu)");
				System.out.println(playlist.toString());
				int songSelection = input.nextInt();
				input.nextLine();
				if (songSelection <= playlist.getPlaylistSize() && songSelection > 0) {
					this.displaySubmenu(songSelection, playlist);
					return true;
				} else if (songSelection == -1) {
					return true;
				}
				System.out.println("Invalid Selection!");
				return  true;
			case 4:
				this.exit();
				return false;
			// catches invalid input for menu selection
			default:
				System.out.println("Invalid Selection!");
				return true;
		}


	}

	// submenu for when a song is playing
	public void displaySubmenu(int songSelection, MP3List playlist) {

		boolean submenuDisplay = true;

		MP3Player player = new MP3Player(songSelection, playlist);

		player.playSong();

		// resets menu after options are selected
		while (submenuDisplay == true) {

			String playingArtist = playlist.getItem(songSelection - 1).getArtist();

			String playingTitle = playlist.getItem(songSelection - 1).getTitle();
			
			System.out.println("~~~***Playback Submenu***~~~");
			System.out.println("Now Playing:");
			System.out.println(playingArtist + " - " + playingTitle);
			System.out.println("Select Option:");
			System.out.println("1. Stop Playback");
			System.out.println("2. Return to Main Menu");

			int selection = input.nextInt();
			input.nextLine();

			
			switch (selection) {
				case 1:
					System.out.println("Stopping...");
					player.stopSong();
					break;
				case 2:
					System.out.println("Returning...");	
					player.stopSong();
					submenuDisplay = false;
					break;
				default:
					System.out.println("Invalid Action!");
			}

		}

	}

	private void exit() {
		System.out.println("Exiting...");
		System.exit(1);
	}

	// prints ArrayLists of Strings properly formatted
	private void printListFormatted(ArrayList<String> items) {
		for (String s : items) {
			System.out.println(s);
		}
	}



}