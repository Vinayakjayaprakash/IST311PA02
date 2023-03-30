import java.util.ArrayList;

public class Album implements Comparable<Album> {

    int albumID;
    ArrayList<String> artistNames;
    String albumTitle;
    int numberOfSongs;

    public Album(int albumID, String title, int numSongs) {
        this.albumID = albumID;
        this.albumTitle = title;
        this.artistNames = new ArrayList<String>();
        this.numberOfSongs = numSongs;
    }
}
