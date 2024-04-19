import java.util.*;

public class Staff implements User{
    private String name;

    @Override
    public String getName(){
        return name;
    }

    @Override
    public String getType(){
        return "Staff";
    }

    public void addMediaItem(MediaItem item, Map<String, MediaItem> mediaItems){
        if (mediaItems.containsKey(item.getTitle())){
            System.out.println(item.getTitle() + " already exists in the library.");
        } else {
            mediaItems.put(item.getTitle(), item);
            System.out.println(item.getTitle() + " has been added to the library.");
        }
    }

    public void removeMediaItem(String title, Map<String, MediaItem> mediaItems){
        if (mediaItems.containsKey(title)){
            MediaItem item = mediaItems.remove(title);
            System.out.println(title + " has been removed from library.");
        } else {
            System.out.println(title+ " is not available in the library.");
        }
    }

    public void listAllMediaItems(Map<String, MediaItem> mediaItems) {
        System.out.println("List of all Media Items:");
        for (Map.Entry<String, MediaItem> entry : mediaItems.entrySet()) {
            MediaItem item = entry.getValue();
            String availability = item.getIsAvailable() ? "Available" : "Borrowed";
            System.out.println("- " + item.getTitle() + " (" + availability + ")");
        }
    }
}