package Iterators.Iterator_Practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class Song2 {
    private String title;
    private String artist;
    private String genre;

    public Song2(String title, String artist, String genre) {
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

class MultiCriteriaFilterIterator implements Iterator<Song2> {
    List<Song2> playlist;
    String targetGenre;
    String targetArtist;
    int currentIndex = 0;


    public MultiCriteriaFilterIterator(List<Song2> playlist, String targetGenre, String targetArtist) {
        this.playlist = playlist;
        this.targetGenre = targetGenre;
        this.targetArtist = targetArtist;
    }

    @Override
    public boolean hasNext() {
        while(currentIndex < playlist.size()) {
            if (playlist.get(currentIndex).getGenre().equals(targetGenre) && playlist.get(currentIndex).getArtist().equals(targetArtist)) {
                return true;
            } currentIndex++;
        } return false;
    }

    @Override
    public Song2 next() {
        if (hasNext()) {
            return playlist.get(currentIndex++);
        } else
            throw new NoSuchElementException();
    }

}
class Main02 {
    public static void main(String[] args) {
        List<Song2> playlist = new ArrayList<>();
        Song2 firstSong = new Song2("Ljubav","Divlja Jagoda","Chill");
        Song2 secondSong = new Song2("Bol","Divlja Jagoda","Chill");
        Song2 thirdSong = new Song2("Bol","Bijelo Dugme","Chill");
        Song2 fourthSong = new Song2("Love the way you lie","Eminem","Rap");

        playlist.add(firstSong);
        playlist.add(secondSong);
        playlist.add(thirdSong);
        playlist.add(fourthSong);

        MultiCriteriaFilterIterator first = new MultiCriteriaFilterIterator(playlist,"Chill","Divlja Jagoda");
        while(first.hasNext()) {
            System.out.println(first.next());
        }
    }
}
