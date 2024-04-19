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
    RELIGION,
    HISTORY
}

public class NonFictionBook extends Book{
    NonFictionGenre genre;

    public NonFictionBook(BookType type, String title, String author, String ISBN, NonFictionGenre genre){
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
