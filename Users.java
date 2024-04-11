import java.util.*;

interface Users {
    String register(String name, String username, String password);
    boolean login(String username, String password);

    MediaItem borrowMediaItem(String title);
    void returnMediaItem(MediaItem item);
    List<MediaItem> viewBorrowedItems();
    void searchMediaItems(String keyword);

    void updateProfile(String name, String email, String password);
    void viewProfile();
}

class Staff implements Users {
    private String name;
    private String username;
    private String password;
    private List<Customer> customers;
    private List<MediaItem> availableItems;

    public Staff(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.customers = new ArrayList<>();
        this.availableItems = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    @Override
    public String register(String name, String username, String password) {
        // Staff cannot register new users
        return "Staff cannot register new users";
    }

    @Override
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    @Override
    public MediaItem borrowMediaItem(String title) {
        for (MediaItem item : availableItems) {
            if (item.getTitle().equalsIgnoreCase(title) && item.getIsAvailable()) {
                item.borrowMediaItem();
                return item;
            }
        }
        System.out.println("Item not found or not available.");
        return null;
    }

    @Override
    public void returnMediaItem(MediaItem item) {
        item.returnMediaItem();
    }

    @Override
    public List<MediaItem> viewBorrowedItems() {
        // Staff cannot view borrowed items
        return null;
    }

    @Override
    public void searchMediaItems(String keyword) {
        // Staff can implement search functionality
    }

    @Override
    public void updateProfile(String name, String email, String password) {
        this.name = name;
        this.username = email; // Assuming username is email for staff
        this.password = password;
    }

    @Override
    public void viewProfile() {
        System.out.println("Name: " + name);
        System.out.println("Username: " + username);
    }

    // Additional methods for staff
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    public void addMediaItem(MediaItem item) {
        availableItems.add(item);
    }

    public void removeMediaItem(MediaItem item) {
        availableItems.remove(item);
    }

    public void displayCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer.getName());
        }
    }

    public void lendBook(Customer customer, MediaItem item) {
        item.borrowMediaItem();
        customer.borrowedItems.add(item);
    }

    public void returnBook(Customer customer, MediaItem item) {
        item.returnMediaItem();
        customer.borrowedItems.remove(item);
        // Calculate fine if necessary
    }
}

class Customer implements Users {
    private String name;
    private String username;
    private String password;
    List<MediaItem> borrowedItems;

    public Customer(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.borrowedItems = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    @Override
    public String register(String name, String username, String password) {
        // Customers cannot register other users
        return "Customers cannot register other users";
    }

    @Override
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    @Override
    public MediaItem borrowMediaItem(String title) {
        // Customers can borrow media items
        return null;
    }

    @Override
    public void returnMediaItem(MediaItem item) {
        // Customers can return media items
    }

    @Override
    public List<MediaItem> viewBorrowedItems() {
        return borrowedItems;
    }

    @Override
    public void searchMediaItems(String keyword) {
        // Customers can search media items
    }

    @Override
    public void updateProfile(String name, String email, String password) {
        this.name = name;
        this.username = email; // Assuming username is email for customers
        this.password = password;
    }

    @Override
    public void viewProfile() {
        System.out.println("Name: " + name);
        System.out.println("Username: " + username);
    }
}
