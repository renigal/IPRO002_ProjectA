import java.util.*;

// public class Library {
//     private ArrayList<MediaItem> mediaItems;

//     public Library(){
//         this.mediaItems = new ArrayList<>();
//     }

//     public void addMediaItem(MediaItem mediaItem){
//         mediaItems.add(mediaItem);
//     }

//     public void checkOutMediaItem(String title){
//         for (MediaItem mediaItem : mediaItems){
//             if (mediaItem.getTitle().equals(title)){
//                 mediaItem.checkOutMediaItem();
//                 return;
//             }
//         }
//         System.out.println(title + " is not found in the library.");
//     }

//     public void returnMediaItem(String title){
//         for (MediaItem mediaItem : mediaItems){
//             if (mediaItem.getTitle().equals(title)){
//                 mediaItem.returnMediaItem();
//                 return;
//             }
//         }
//         System.out.println(title + " is not found in the library.");
//     }
    
//     public void displayAllMediaItems(){
//         for (MediaItem mediaItem : mediaItems) {
//             mediaItem.displayInfo();
//         }
//     }
// }