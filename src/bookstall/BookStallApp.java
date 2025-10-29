package bookstall;

import bookstall.controller.LoginController;
import bookstall.model.AuthModel;
import bookstall.view.LoginPageView;

import javax.swing.SwingUtilities;

/**
 * Main entry point for the Book Stall Management System.
 * Initializes the MVC components for the Login flow.
 */
public class BookStallApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 1. Create Model (Business Logic for Auth)
            AuthModel authModel = new AuthModel();

            // 2. Create View (GUI)
            LoginPageView loginView = new LoginPageView();

            // 3. Create Controller (Links Model and View)
            new LoginController(loginView, authModel);

            // 4. Show the View
            loginView.setVisible(true);
        });
    }
}
