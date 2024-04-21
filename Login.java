import java.util.*;

public class Login {
    private Map<String, String> userCredentials;

    public Login() {
        // Initialize the user credentials map
        userCredentials = new HashMap<>();
        // Add some default users (username, password)
        userCredentials.put("student1", "pass1");
        userCredentials.put("student2", "pass2");
        userCredentials.put("student3", "pass3");
        userCredentials.put("staff", "admin");
    }

    public boolean authenticate(String username, String password) {
        // Check if the username exists and the password matches
        return userCredentials.containsKey(username) && userCredentials.get(username).equals(password);
    }

    public String getUserType(String username) {
        // Determine the type of the user based on the username
        if (username.startsWith("student")) {
            return "Student";
        } else if (username.startsWith("staff")) {
            return "Staff";
        } else {
            return "Unknown";
        }
    }
}
