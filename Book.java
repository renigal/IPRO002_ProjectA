public class Book extends MediaItem{
    private String author;
    private String ISBN;
    BookType type;

    public Book(String title, String author, String ISBN, BookType type) {
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

enum BookType{
    FICTION,
    NON_FICTION
}