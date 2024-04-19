enum FictionGenre{
    HORROR,
    MYSTERY,
    ROMANCE,
    SCIENCE_FICTION,
    THRILLER,
    FANTASY,
    HISTORY
}

public class FictionBook extends Book{
    FictionGenre genre;

    public FictionBook(BookType type, String title, String author, String ISBN, FictionGenre genre){
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