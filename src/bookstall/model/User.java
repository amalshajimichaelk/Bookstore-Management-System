package bookstall.model;

/**
 * Model class for a User, mirroring the Users SQL table structure (used for login).
 */
public class User {
    private String username;
    private String password; // In a real app, this would be hashed.

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    // Standard getters and setters

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
