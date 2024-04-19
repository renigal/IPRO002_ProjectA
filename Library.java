import java.util.*;

public class Library {
    public static void main(String[] args) {
        // Creating media items
        DVD dvd = new DVD("Inception", "Christopher Nolan", "2010");
        VinylRecord vinylRecord = new VinylRecord("Abbey Road", "The Beatles", 17);
        FictionBook fictionBook = new FictionBook(BookType.FICTION, "Harry Potter", "J.K. Rowling", "9780545582889", FictionGenre.FANTASY);
        NonFictionBook nonFictionBook = new NonFictionBook(BookType.NON_FICTION, "Sapiens: A Brief History of Humankind", "Yuval Noah Harari", "9780062316097", NonFictionGenre.HISTORY);

        // Creating a list of books
        List<Book> books = new ArrayList<>();
        books.add(fictionBook);
        books.add(nonFictionBook);

        // Creating a student
        Student student = new Student("John");

        // Borrowing media items
        student.borrowMediaItem(dvd, getMediaItemsMap(dvd));
        student.borrowMediaItem(vinylRecord, getMediaItemsMap(vinylRecord));
        student.borrowMediaItem(fictionBook, getMediaItemsMap(fictionBook));
        student.borrowMediaItem(nonFictionBook, getMediaItemsMap(nonFictionBook));

        // Returning a media item
        student.returnMediaItem("Harry Potter");

        // Searching for books in a specific genre
        student.searchBookGenre(books, FictionGenre.FANTASY, NonFictionGenre.HISTORY);
    }

    // Utility method to create a map with the media item
    private static Map<String, MediaItem> getMediaItemsMap(MediaItem item) {
        Map<String, MediaItem> map = new HashMap<>();
        map.put(item.getTitle(), item);
        return map;
    }
}
