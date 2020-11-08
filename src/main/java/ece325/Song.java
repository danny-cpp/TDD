package ece325;

import java.util.Comparator;
import java.util.Objects;

/**
 * Assignment 6: Test Driven Development <br />
 * The {@code Song} class
 *
 * @author Danh Nguyen ID:1592873
 */
public class Song {

    private String artist;
    private String title;
    private float length;

    // Fulfils @Before
    /**
     * Construct a song object that holds information of a song, including artist,
     * title, and length.
     *
     * @param artist
     * @param title
     * @param length
     */
    Song(String artist, String title, double length) {
        this.artist = artist.toLowerCase();
        this.title = title.toLowerCase();
        this.length = (float) length;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public float getLength()
    {
        return length;
    }

    /**
     * Check if the artist name is the artist of the song object
     * @param test_artist
     * @return
     */
    public boolean isArtist(String test_artist) {
        return test_artist.toLowerCase().equals(this.getArtist());
    }

    /**
     * Check if the title is the tile of the song object
     * @param test_title
     * @return
     */
    public boolean isTitle(String test_title) {
        return test_title.toLowerCase().equals(this.getTitle());
    }

    /**
     * Custom equals method
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song)) return false;
        Song song = (Song) o;
        return Float.compare(song.length, length) == 0 &&
                Objects.equals(artist, song.artist) &&
                Objects.equals(title, song.title);
    }
}

class ArtistSort implements Comparator<Song> {

    /**
     * Compares its two arguments for order.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.<p>
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the
     * first argument is less than, equal to, or greater than the
     * second.
     * @throws NullPointerException if an argument is null and this
     *                              comparator does not permit null arguments
     * @throws ClassCastException   if the arguments' types prevent them from
     *                              being compared by this comparator.
     */
    @Override
    public int compare(Song o1, Song o2) {
        if (o1 == null || o2 == null) {
            throw new NullPointerException();
        }

        if (!(o1 instanceof Song) || !(o2 instanceof Song)) {
            throw new ClassCastException();
        }

        return o1.getArtist().compareTo(o2.getArtist());
    }
}

class TitleSort implements Comparator<Song> {
    @Override
    public int compare(Song o1, Song o2) {
        if (o1 == null || o2 == null) {
            throw new NullPointerException();
        }

        if (!(o1 instanceof Song) || !(o2 instanceof Song)) {
            throw new ClassCastException();
        }

        return o1.getTitle().compareTo(o2.getTitle());
    }
}