package ece325;

import java.util.HashSet;
import java.util.Set;

/**
 * Assignment 6: Test Driven Development <br />
 * The {@code Playlist} class
 *
 * @author Danh Nguyen ID:1592873
 */
// @SuppressWarnings("serial")
public class Playlist<E extends Song> extends java.util.ArrayList<E> {
    /**
     * Iterator object of playlist class. Traverse through songs
     */
    java.util.Iterator<E> itr = this.iterator();       // Generic Iterator; Use it whenever you need it!

    private String playlist_name;

    // Fulfils @Before
    /**
     * Create playlist object that is a collection of song and its subclasses.
     * @param playlist_name
     */
    Playlist(String playlist_name) {
        this.playlist_name = playlist_name;
    }

    public String getTitle() {
        return playlist_name;
    }

    /**
     * Adding song object to the playlist.
     * @param song
     */
    public <T extends Song> boolean addtoPlist(T song) {
        if (song == null) {
            return false;
        }
        if (this.contains(song)) {
            return false;
        }
        this.add((E)song);
        return true;
    }

    /**
     * Remove a particular song object in the playlist
     * @param song
     * @return
     */
    public boolean removeFromPlist(E song) {
        if (song == null) {
            return false;
        }
        if (!this.contains(song)) {
            return false;
        }
        this.remove(song);
        return true;
    }

    public <E extends Song> E getSong(int song_number) {
        E retrieved_song = (E) this.get(song_number);
        return retrieved_song;
    }

    /**
     * Check if the title match the playlist's
     * @param test_title
     * @return
     */
    public boolean hasTitle(String test_title) {
        return test_title.equals(this.getTitle());
    }

    /**
     * Find if there is a particular artist in the song playlist
     * @param artist_name
     * @return
     */
    public boolean hasArtist(String artist_name) {
        for (E s: this) {
            if (s.getArtist().equals(artist_name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return the number of songs (unique only) in the playlist
     * @return
     */
    public int numberOfSongs() {
        Set <E> song_set = new HashSet<E>(this);
        return song_set.size();
    }

    /**
     * Return the number of artists (unique only) in the playlist
     * @return
     */
    public int numberOfArtists() {
        Set <String> artist_set = new HashSet<String>();
        for (E s: this) {
            artist_set.add(s.getArtist());
        }
        return artist_set.size();
    }

    /**
     * Return the number of songs (unique only) in the playlist
     * @return
     */
    public int numberOfTitles() {
        Set <String> title_set = new HashSet<String>();
        for (E s: this) {
            title_set.add(s.getTitle());
        }
        return title_set.size();
    }

    public double playTime() {
        double total_time = 0;
        for (E s: this) {
            total_time += s.getLength();
        }
        return total_time;
    }

    /**
     * Return the index of the chosen song object
     * @param song
     * @param <E>
     * @return
     */
    public <E extends Song> int findSong(E song) {
        return this.indexOf(song);
    }

    /**
     * Sort the playlist by artist name
     *
     */
    public void sortByArtist() {
        this.sort(new ArtistSort());
    }

    /**
     * Sort the playlist by song title
     *
     */
    public void sortByTitle() {
        this.sort(new TitleSort());
    }
}
