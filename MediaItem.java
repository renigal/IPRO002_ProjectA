public abstract class MediaItem {
    private String title;
    protected boolean isAvailable;

    public MediaItem(String title) {
        this.title = title;
        this.isAvailable = true;
    }

    // Getter method to retrieve the title of the media item
    public String getTitle(){
        return title;
    }

    // Getter method to retrieve the availability status of the media item
    public boolean getIsAvailable(){
        return isAvailable;
    }

    // Method to borrow the media item
    public void borrowMediaItem(){
        // Check if the media item is available
        if (isAvailable) {
            // If available, mark it as borrowed and notify the user
            isAvailable = false;
            System.out.println(title + " has been borrowed.");
        } else {
            // If not available, notify the user that it's not available for borrowing
            System.out.println(title + " is not available.");
        }
    }

    // Method to return the media item
    public void returnMediaItem(){
        // Mark the media item as available
        isAvailable = true;
        // Notify the user that the item has been returned
        System.out.println(title + " has been returned.");
    }
    
    // Method to display information about the media item
    public void displayInfo(){
        // Display the title and availability status of the media item
        System.out.println("Title: " + title + ", Availability: " + isAvailable);
    }
}
