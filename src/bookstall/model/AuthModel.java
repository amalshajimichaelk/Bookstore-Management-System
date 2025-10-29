    package bookstall.model;

    import javax.swing.*;
    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;

    /**
     * Handles authentication logic. Now checks against the database.
     */
    public class AuthModel {

        /**
         * Authenticates a user by checking credentials against the Users table in the database.
         * @param username The username entered by the user.
         * @param password The password entered by the user.
         * @return true if authentication is successful, false otherwise.
         */
        public boolean authenticate(String username, String password) {
            // Basic validation
            if (username == null || username.trim().isEmpty() || password == null || password.isEmpty()) {
                // Optionally show a message here, but often better handled in Controller/View
                System.err.println("Authentication failed: Username or password empty.");
                return false;
            }

            String sql = "SELECT password FROM Users WHERE username = ?";
            boolean isAuthenticated = false;

            // Use try-with-resources for Connection, PreparedStatement, and ResultSet
            try (Connection conn = DatabaseManager.getConnection(); // Get connection from DatabaseManager
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, username); // Set the username parameter safely

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        // User found, get the stored password
                        String storedPassword = rs.getString("password");

                        // Compare the provided password with the stored password
                        // IMPORTANT: In a real-world application, passwords should be securely hashed!
                        // This code assumes plain text passwords as per the initial setup.
                        // If hashing was used, you'd compare the hash of the input password
                        // with the stored hash.
                        if (password.equals(storedPassword)) {
                            isAuthenticated = true; // Passwords match
                        } else {
                             // Password doesn't match
                            System.err.println("Authentication failed for user '" + username + "': Incorrect password.");
                        }
                    } else {
                        // User not found
                        System.err.println("Authentication failed: User '" + username + "' not found.");
                    }
                }
            } catch (SQLException e) {
                // Handle database errors
                JOptionPane.showMessageDialog(null,
                        "Database error during authentication: " + e.getMessage(),
                        "Login Error",
                        JOptionPane.ERROR_MESSAGE);
                e.printStackTrace(); // Log the full error
                isAuthenticated = false; // Ensure false is returned on error
            }

            return isAuthenticated;
        }
    }
    

