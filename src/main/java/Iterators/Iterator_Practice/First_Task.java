package Iterators.Iterator_Practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class Songs {
    private String title;
    private String artist;
    private String genre;

    public Songs(String title, String artist, String genre) {
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
        return "Title: " + this.title + " , Artist: " + this.artist + " , Genre: " + this.genre;
    }


}

class ArtistFilterIterator implements Iterator<Songs> {
    List<Songs> playlist;
    String targetArtist;
    int currentIndex = 0;

    public ArtistFilterIterator(List<Songs> playlist, String targetArtist) {
        this.playlist = playlist;
        this.targetArtist = targetArtist;
    }

    @Override
    public boolean hasNext() {
        while(currentIndex < playlist.size()) {
            if (playlist.get(currentIndex).getArtist().equals(targetArtist)) {
                return true;
            } currentIndex++;

        } return false;
    }

    @Override
    public Songs next() {
        if (hasNext()) {
            return playlist.get(currentIndex++);
        } else
            throw new NoSuchElementException();
    }

}

class Main01 {
    public static void main(String[] args) {
        List<Songs> playlist = new ArrayList<>();
        playlist.add(new Songs("Song 1","Eminem","Rap"));
        playlist.add(new Songs("Song 2", "Eminem","Rap"));
        playlist.add(new Songs("Song 3", "Eminem","Rap"));
        playlist.add(new Songs("Song 4", "Eminem2","Rap"));
        playlist.add(new Songs("Song 5", "Eminem2","Rap"));

        ArtistFilterIterator first = new ArtistFilterIterator(playlist,"Eminem");

        while(first.hasNext()) {
            System.out.println(first.next());
        }
    }
}
