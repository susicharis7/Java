package Iterators.Iterator_Practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class Song3 {
    private String title;
    private String artist;
    private String genre;

    public Song3(String title, String artist, String genre) {
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

class TitleLengthFilterIterator implements Iterator<Song3> {
    List<Song3> playlist;
    String targetArtist;
    int currentIndex = 0;

    public TitleLengthFilterIterator(List<Song3> playlist, String targetArtist) {
        this.playlist = playlist;
        this.targetArtist = targetArtist;
    }

    @Override
    public boolean hasNext() {
        while(currentIndex < playlist.size()) {
            Song3 song = playlist.get(currentIndex);
            if(song.getArtist().equals(targetArtist) && song.getTitle().length() > 5) {
                return true;
            } currentIndex++;


        } return false;
    }

    @Override
    public Song3 next() {
        if(hasNext()) {
            return playlist.get(currentIndex++);
        } else
            throw new NoSuchElementException();
    }

}

class Main03 {
    public static void main(String[] args) {
        List<Song3> playlist = new ArrayList<>();
        playlist.add(new Song3("FRANCHISE","Travis Scott","Rap"));
        playlist.add(new Song3("EYES","Travis Scott","Rap"));
        playlist.add(new Song3("SKELETONS","Travis Scott","Rap"));
        playlist.add(new Song3("5AM","Travis Scott","Rap"));

        TitleLengthFilterIterator random = new TitleLengthFilterIterator(playlist,"Travis Scott");
        while(random.hasNext()) {
            System.out.println(random.next());
        }

    }
}