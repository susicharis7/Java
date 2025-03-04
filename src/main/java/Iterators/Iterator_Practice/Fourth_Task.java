package Iterators.Iterator_Practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class Song5 {
    String title;
    String artist;
    String genre;

    public Song5(String title, String artist, String genre) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Title: " + this.title + " , Genre: " + this.genre + " , Artist: " + this.artist;
    }
}

// Artist name must have 5 characters

class ArtistLengthIterator implements Iterator<Song5> {
    List<Song5> playlist;
    int minLength;
    int currentIndex = 0;

    public ArtistLengthIterator(List<Song5> playlist, int minLength) {
        this.playlist = playlist;
        this.minLength = minLength;
    }

    @Override
    public boolean hasNext() {
        while (currentIndex < playlist.size()) {
            // Song5 song = playlist.get(currentIndex);


            if (playlist.get(currentIndex).getArtist().length() > minLength) {
                return true;
            } currentIndex++;
        } return false;
    }

    @Override
    public Song5 next() {
        if (hasNext()) {
            return playlist.get(currentIndex++);
        } else
            throw new NoSuchElementException("WRONG! ");
    }
}

class Main06 {
    public static void main(String[] args) {
        List<Song5> playlist = new ArrayList<>();
        playlist.add(new Song5("FRANCHISE","Travis Scott","RAP"));
        playlist.add(new Song5("ASTROWORLD","Travis Scott","RAP"));
        playlist.add(new Song5("LTWYL","Travis Teller","POP"));
        playlist.add(new Song5("RAP DEVIL","MGK","HIPHOP/RAP"));
        playlist.add(new Song5("NOT IN LOVE","MGK","HIPHOP/RAP"));

        ArtistLengthIterator iterator = new ArtistLengthIterator(playlist,5);
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }
}

