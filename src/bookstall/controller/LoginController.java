package bookstall.controller;

import bookstall.model.AuthModel;
import bookstall.view.LoginPageView;
import bookstall.view.MainAppView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller for the Login View. Handles authentication logic and
 * transitions to the main application.
 */
public class LoginController {

    private final LoginPageView view;
    private final AuthModel model;

    public LoginController(LoginPageView view, AuthModel model) {
        this.view = view;
        this.model = model;

        // Attach listener to the login button
        this.view.addLoginListener(new LoginListener());
    }

    /**
     * Inner class to handle the login button action.
     */
    private class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = view.getUsername();
            String password = view.getPassword();

            if (model.authenticate(username, password)) {
                view.showMessage("Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

                // Close login window
                view.dispose();

                // Open main GUI and launch the main controller
                SwingUtilities.invokeLater(() -> {
                    MainAppView mainAppView = new MainAppView();
                    new MainAppController(mainAppView); // Initialize main controller
                    mainAppView.setVisible(true);
                });

            } else {
                view.showMessage(
                        "Invalid Username or Password",
                        "Login Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
