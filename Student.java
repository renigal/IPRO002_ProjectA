import java.util.*;

interface User {
    String getName();
    String getType();
}

public class Student implements User{
    private String name;
    private Map<String, MediaItem> borrowedItems;

    public Student(String name){
        this.name = name;
        this.borrowedItems = new HashMap<>();
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public String getType(){
        return "Student";
    }

    public void borrowMediaItem(MediaItem mediaItem, Map<String, MediaItem> mediaItems) {
        if (mediaItems.containsKey(mediaItem.getTitle())) {
            MediaItem item = mediaItems.get(mediaItem.getTitle());
            if (item.getIsAvailable()) {
                if (mediaItem instanceof Book) {
                    Book book = (Book) mediaItem;
                    book.borrowMediaItem();
                } else if (mediaItem instanceof DVD) {
                    DVD dvd = (DVD) mediaItem;
                    dvd.borrowMediaItem();
                } else if (mediaItem instanceof VinylRecord) {
                    VinylRecord vinylRecord = (VinylRecord) mediaItem;
                    vinylRecord.borrowMediaItem();
                }
                borrowedItems.put(mediaItem.getTitle(), mediaItem);
                System.out.println(name + " has borrowed the media item: " + mediaItem.getTitle());
            } else {
                System.out.println("Sorry, " + mediaItem.getTitle() + " is not available for borrowing.");
            }
        } else {
            System.out.println("The media item " + mediaItem.getTitle() + " is not available in the library.");
        }
    }

    public void returnMediaItem(String title) {
        if (borrowedItems.containsKey(title)) {
            MediaItem item = borrowedItems.get(title);
            item.returnMediaItem();
            borrowedItems.remove(title);
            System.out.println(name + " has returned the media item: " + title);
        } else {
            System.out.println("You have not borrowed the media item: " + title);
        }
    }

    public void searchMediaItems(List<MediaItem> mediaItems) {
        System.out.println("Available Media Items:");
        List<MediaItem> availableItems = new ArrayList<>();
    
        // Filter available items
        for (MediaItem item : mediaItems) {
          if (item.getIsAvailable()) {
            availableItems.add(item);
          }
        }
    
        // Sort available items by title
        Collections.sort(availableItems, (item1, item2) -> item1.getTitle().compareTo(item2.getTitle()));
    
        // Display available items
        if (availableItems.isEmpty()) {
          System.out.println("No media items are currently available for borrowing.");
        } else {
          for (MediaItem item : availableItems) {
            System.out.println("- " + item.getTitle());
          }
        }
      }
}