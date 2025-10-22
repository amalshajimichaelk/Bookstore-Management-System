import javax.swing.*;
import java.awt.*;
public class LoginPage {

	public static void main(String[] args) {
		JFrame mainFrame = new JFrame();
		mainFrame.setSize(500,250);
		mainFrame.setTitle("Login Window");
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		
		gbc.gridx=0;
		gbc.gridy=0;
		JLabel usernameLabel = new JLabel("Username:");
		panel.add(usernameLabel, gbc);
		
		gbc.gridx=1;
		gbc.gridy=0;
		JTextField username = new JTextField(20);
		panel.add(username, gbc);
		
		gbc.gridx=0;
		gbc.gridy=1;
		JLabel pswdLabel = new JLabel("Password:");
		panel.add(pswdLabel, gbc);
		
		gbc.gridx=1;
		gbc.gridy=1;
		JPasswordField password = new JPasswordField(20);
		panel.add(password, gbc);
		
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.gridwidth=2;
		gbc.anchor=GridBagConstraints.CENTER;
		JButton loginButton = new JButton("Login");
		panel.add(loginButton, gbc);
		
		
		mainFrame.add(panel);
		mainFrame.setResizable(false);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
		
	}

}
