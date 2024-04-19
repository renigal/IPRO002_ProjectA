public class MediaItem {
    private String title;
    protected boolean isAvailable;

    public MediaItem(String title) {
        this.title = title;
        this.isAvailable = true;
    }

    public MediaItem(){
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
    
    public void displayInfo(){
        System.out.println("Title: " + title + ", Availability: " + isAvailable);
    }
}