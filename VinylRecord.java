public class VinylRecord extends MediaItem {
    private String artist;
    private int numberOfTracks;

    public VinylRecord(String title, String artist, int numberOfTracks){
        super(title);
        this.artist = artist;
        this.numberOfTracks = numberOfTracks;
    }

    public String getArtist(){
        return artist;
    }

    public int getNumberOfTracks(){
        return numberOfTracks;
    }

    @Override
    public void displayInfo(){
        System.out.println("Title: " + getTitle() + ", Artist: " + getArtist() + ", Number of Tracks: " + getNumberOfTracks());
    }
}