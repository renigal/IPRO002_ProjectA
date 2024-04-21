import java.util.*;

public class LibraryInterface {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Map<String, MediaItem> library = new HashMap<>();

        // Sample Library
        // Create sample media items and add them to the library
        MediaItem book1 = new FictionBook(BookType.FICTION, "The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", FictionGenre.ROMANCE);
        MediaItem book2 = new NonFictionBook(BookType.NON_FICTION, "Sapiens: A Brief History of Humankind", "Yuval Noah Harari", "9780062316097", NonFictionGenre.HISTORY);
        MediaItem dvd1 = new DVD("Inception", "Christopher Nolan", "2010");
        MediaItem vinyl1 = new VinylRecord("Abbey Road", "The Beatles", 17);
        MediaItem vinyl2= new VinylRecord("Push Ups", "Drake", 1);

        // Add sample media items to the library
        library.put(book1.getTitle(), book1);
        library.put(book2.getTitle(), book2);
        library.put(dvd1.getTitle(), dvd1);
        library.put(vinyl1.getTitle(), vinyl1);
        library.put(vinyl2.getTitle(), vinyl2);

        Login loginManager = new Login();
    

        boolean loggedIn = false;
        String userType = "";
        String quitCommand = "QUIT";

        do{
            try{
                System.out.println("--------------------- Welcome to  the Library ---------------------");
                System.out.println("------------------ Please login to use the System ------------------");
                System.out.println("------------------- Type 'QUIT' anytime to leave -------------------");
                System.out.print("Please enter Username: ");
                String username = scanner.next();

                if (username.equals(quitCommand)){
                    System.out.println("Exiting program... Goodbye");
                    return;
                }

                System.out.print("Please enter password: ");
                String password = scanner.next();

                if (password.equals(quitCommand)){
                    System.out.println("Exiting program... Goodbye");
                    return;
                }
                
                if (loginManager.authenticate(username, password)){
                    loggedIn = true;
                    
                    userType = loginManager.getUserType(username);
                    System.out.println("------------------------- Login Successful -------------------------");

                    if (userType.equals("Student")){
                        Student student = new Student(username,library);
                        displayStudentMenu(scanner, student, library);
                    } else if (userType.equals("Staff")){
                        Staff staff = new Staff(username);
                        displayStaffMenu(scanner,staff, library);
                    }
                } else {
                    System.out.println("Invalid username or password. Please try again.");
                }

            } catch (InputMismatchException e){
                System.out.println("Invalid input. Please enter a valid username and password.");
            }
        } while (!loggedIn);
    }

    private static void displayStudentMenu(Scanner scanner, Student student, Map<String, MediaItem> library){
        int choice =0;
        do{
            try{
                System.out.println("----- Student Menu -----");
                System.out.println("1. Borrow Media Item");
                System.out.println("2. Return Media Item");
                System.out.println("3. View Available Media Items");
                System.out.println("4. View Borrowed Items");
                System.out.println("5. Display Media Item Details");
                System.out.println("6. Logout");
                System.out.print("Please enter choice: ");
                choice = scanner.nextInt();

                switch(choice){
                    case 1:
                        System.out.println("Enter a media to borrow:");
                        scanner.nextLine();
                        String mediaName = scanner.nextLine();
                        student.borrowMediaItem(mediaName);
                        break;
                    case 2:
                        System.out.println("Enter a title to return:");
                        String mediaTitle = scanner.nextLine();
                        scanner.nextLine();
                        student.returnMediaItem(mediaTitle);
                        break;
                    case 3:
                        student.viewAvailableMediaItems(library);
                        break;
                    case 4:
                        student.displayBorrowedItems();
                        break;
                    case 5:
                        System.out.println("Enter media name: ");
                        String media = scanner.nextLine();
                        scanner.nextLine();
                        student.viewMediaItemDetails(media, library);
                        break;
                    case 6:
                        System.out.println("Logging out...");
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
        
            }catch (InputMismatchException e){
                System.out.println("Invalid input! Please enter a number.");
            }
        } while (choice != 6);
    }

    private static void displayStaffMenu(Scanner scanner, Staff staff, Map<String, MediaItem> library){
        int option = 0;
    
        do {
            try {
                System.out.println("----- Staff Menu -----");
                System.out.println("1. Add Media Item");
                System.out.println("2. Remove Media Item");
                System.out.println("3. List all Media Items");
                System.out.println("4. Display Media Item Details");
                System.out.println("5. Logout");
                System.out.println("Please enter choice: ");
                option = scanner.nextInt();
                scanner.nextLine(); // Consume newline
    
                switch (option) {
                    case 1:
                        addMediaItemMenu(scanner, staff, library);
                        break;
                    case 2:
                        System.out.println("Enter media item name to remove:");
                        String title = scanner.nextLine();
                        staff.removeMediaItem(title, library);
                        break;
                    case 3:
                        staff.listAllMediaItems(library);
                        break;
                    case 4:
                        System.out.println("Enter media name: ");
                        String media = scanner.nextLine();
                        staff.viewMediaItemDetails(media, library);
                        break;
                    case 5:
                        System.out.println("Logging out...");
                        break;
                    default:
                        System.out.println("Invalid Input! Please enter a number.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number!");
                scanner.nextLine(); // Consume newline
            }
        } while (option != 5);
    }

    private static void addMediaItemMenu(Scanner scanner, Staff staff, Map<String, MediaItem> library){
        int action;

        System.out.println("\nAdd Media Item:");
        System.out.println("1. Add Fiction Book");
        System.out.println("2. Add Non-Fiction Book");
        System.out.println("3. Add DVD");
        System.out.println("4. Add Vinyl Record");
        System.out.println("5. Back to Staff Menu");
        System.out.println("Enter choice:");

        action = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (action){
            case 1:
                addFictionBook(scanner, staff, library); // Add fiction book
                break;
            case 2:
                addNonFictionBook(scanner, staff, library); // Add non-fiction book
                break;
            case 3:
                addDVD(scanner, staff, library); // Add DVD
                break;
            case 4:
                addVinyl(scanner, staff, library); // Add vinyl record
                break;
            case 5:
                System.out.println("Returning to Staff Menu...");
                break;
            default:
                System.out.println("Invalid Choice!");
        }
    }

    // Method to add a fiction book by staff
    private static void addFictionBook(Scanner scanner, Staff staff, Map<String, MediaItem> library){
        System.out.println("Enter title:");
        String title = scanner.nextLine();

        System.out.println("Enter author:");
        String author = scanner.nextLine();

        System.out.println("Enter ISBN:");
        String isbn = scanner.nextLine();

        // Display a prompt to select a genre and enumerate the available fiction genres along with their index.
        System.out.println("Select Genre:");
        // The index is incremented by 1 to start from 1 instead of 0 for user-friendly display.
        // Each genre is displayed with its corresponding index followed by a period and the genre name.
        for (FictionGenre genre : FictionGenre.values()) {
            System.out.println(genre.ordinal() + 1 + ". " + genre);
        }
        int genreChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // This line retrieves the NonFictionGenre enum constant corresponding to the user's choice.
        // NonFictionGenre.values() returns an array containing all the enum constants of NonFictionGenre,
        // and genreChoice - 1 is used to index the array based on the user's input,
        // adjusting for zero-based indexing.
        FictionGenre genre = FictionGenre.values()[genreChoice - 1];

        staff.addMediaItem(title, author, isbn, genre, library); // Add fiction book
    }

    // Method to add a non-fiction book by staff
    private static void addNonFictionBook(Scanner scanner, Staff staff, Map<String, MediaItem> library){
        System.out.println("Enter title:");
        String title = scanner.nextLine();

        System.out.println("Enter author:");
        String author = scanner.nextLine();

        System.out.println("Enter ISBN:");
        String isbn = scanner.nextLine();

        // Display a prompt to select a genre and enumerate the available fiction genres along with their index.
        System.out.println("Select Genre:");
        // The index is incremented by 1 to start from 1 instead of 0 for user-friendly display.
        // Each genre is displayed with its corresponding index followed by a period and the genre name.
        for (NonFictionGenre genre : NonFictionGenre.values()) {
            System.out.println(genre.ordinal() + 1 + ". " + genre);
        }
        int genreChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // This line retrieves the NonFictionGenre enum constant corresponding to the user's choice.
        // NonFictionGenre.values() returns an array containing all the enum constants of NonFictionGenre,
        // and genreChoice - 1 is used to index the array based on the user's input,
        // adjusting for zero-based indexing.
        NonFictionGenre genre = NonFictionGenre.values()[genreChoice - 1];

        staff.addMediaItem(title, author, isbn, genre, library); // Add non-fiction book
    }

    // Method to add a DVD by staff
    private static void addDVD(Scanner scanner, Staff staff, Map<String, MediaItem> library) {
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Director: ");
        String director = scanner.nextLine();

        System.out.print("Enter Release Year: ");
        String yearReleased = scanner.nextLine();

        staff.addMediaItem(title, director, yearReleased, library); // Add DVD
    }

    // Method to add a vinyl record by staff
    private static void addVinyl(Scanner scanner, Staff staff, Map<String, MediaItem> library){
        System.out.println("Enter Title:");
        String title = scanner.nextLine();

        System.out.println("Enter Artist:");
        String artist = scanner.nextLine();

        System.out.println("Enter the Number of Tracks:");
        int numoftracks = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        staff.addMediaItem(title, artist, numoftracks, library); // Add vinyl record
    }
}
