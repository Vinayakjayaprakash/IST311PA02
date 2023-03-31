import java.util.ArrayList;

public class Album implements Comparable<Album> {

    int albumID;
    ArrayList<String> artistNames;
    String albumTitle;
    int numberOfSongs;

    public Album(int albumID,String artistNames, String title, int numSongs) {
        this.albumID = albumID;
        this.albumTitle = title;
        this.artistNames = new ArrayList<String>();
        this.numberOfSongs = numSongs;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(albumID).append(": ").append(numberOfSongs).append("--[");
        for (int i = 0; i < artistNames.size(); i++) {
            sb.append(artistNames.get(i));
            if (i != artistNames.size() - 1) {
                sb.append("]");
            }
        }
        return sb.toString();
    }
    public void addArtists(String artistNames){
        this.artistNames.add(artistNames);
    }
    @Override
    public int compareTo(Album album1){
        if(this.numberOfSongs == album1.numberOfSongs)
            return 0;
        else return -1;
    }
}
