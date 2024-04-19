public class DVD extends MediaItem {
    private String director;
    private String yearReleased;

    public DVD(String title, String  director, String yearReleased){
        super(title);
        this.director = director;
        this.yearReleased = yearReleased;
    }

    public String getDirector(){
        return director;
    }

    public String getReleaseYear(){
        return yearReleased;
    }

    @Override
    public void displayInfo(){
        System.out.println("Title: " + getTitle() + ", Director: " + getDirector() + ", Release Year: " + getReleaseYear());
    }
}