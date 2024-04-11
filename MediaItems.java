class MediaItem {
    private String title;
    private boolean isAvailable;

    public MediaItem(String title) {
        this.title = title;
        this.isAvailable = true;
    }

    public String getTitle(){
        return title;
    }

    public boolean getIsAvailable(){
        return isAvailable;
    }

    public void borrowMediaItem(){
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is not available.");
        }
    }

    public void returnMediaItem() {
        isAvailable = true;
        System.out.println(title + " has been returned.");
    }

    public void displayInfo() {
        System.out.println("Title: " + title + ", Availability: " + isAvailable);
    }
}

class DVD extends MediaItem {
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

class VinylRecord extends MediaItem {
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

class Book extends MediaItem{
    private String author;
    private String ISBN;
    Type type;

    public Book(String title, String author, String ISBN, Type type) {
        super(title);
        this.author = author;
        this.ISBN = ISBN;
        this.type = type;
    }

    public String getAuthor(){
        return author;
    }

    public String getISBN(){
        return ISBN;
    }

    public String getType(){
        return  type.name();
    }

    @Override
    public void displayInfo(){
        System.out.println("Title: " + getTitle() + ", Author: " + getAuthor() + " , Type: " + getType() + ", ISBN:" + getISBN());
    }
}

enum Type{
    FICTION,
    NON_FICTION
}

enum FictionGenre{
    HORROR,
    MYSTERY,
    ROMANCE,
    SCIENCE_FICTION,
    THRILLER,
    FANTASY,
    HISTORY
}

enum NonFictionGenre{
    MEMOIR,
    BIOGRAPHY,
    MAGAZINES,
    SCIENCE,
    POLITICS,
    SELF_HELP,
    ECONOMICS,
    HEALTH,
    HOBBIES,
    TRAVEL,
    COOKBOOKS,
    RELIGION
}

class FictionBook extends Book{
    FictionGenre genre;

    public FictionBook(Type type, String title, String author, String ISBN, FictionGenre genre){
        super(title, author, ISBN, type);
        this.genre = genre;
    }

    public FictionGenre getFictionGenre(){
        return genre;
    }
    
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Genre: " + getFictionGenre());
    }
}

class NonFictionBook extends Book{
    NonFictionGenre genre;

    public NonFictionBook(Type type, String title, String author, String ISBN, NonFictionGenre genre){
        super(title, author, ISBN, type);
        this.genre = genre;
    }

    public NonFictionGenre getNonFictionGenre(){
        return genre;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Genre: " + getNonFictionGenre());
    }
}