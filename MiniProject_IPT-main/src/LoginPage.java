import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginPage() {
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.BLACK);

        // Load and scale the image
        ImageIcon icon = new ImageIcon(getClass().getResource("MoneyLoan.jpeg")); // Replace "your_image_path_here.jpg" with your image path
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImage);

        // Title label with image
        JLabel titleLabel = new JLabel("Money Loan Management System", icon, SwingConstants.CENTER);
        titleLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(Color.WHITE);

        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Center panel with GridBagLayout for input fields
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        centerPanel.setBackground(Color.GRAY);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.LINE_END;

        // Username label and field
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(usernameLabel, gbc);

        usernameField = new JTextField(15); // Normal-sized text field
        gbc.gridx = 1;
        gbc.gridy = 0;
        centerPanel.add(usernameField, gbc);

        // Password label and field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        centerPanel.add(passwordLabel, gbc);

        passwordField = new JPasswordField(15); // Normal-sized text field
        gbc.gridx = 1;
        gbc.gridy = 1;
        centerPanel.add(passwordField, gbc);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // South panel for the buttons
        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.BLACK);
        southPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton loginButton = new JButton("Login");
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(Color.BLUE);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform login action
                // For now, let's navigate to the dashboard page
                dispose(); // Close the login page
                DashboardPage dashboardPage = new DashboardPage();
                dashboardPage.setVisible(true); // Show the dashboard page
            }
        });
        southPanel.add(loginButton);

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setBackground(Color.BLUE);
        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform sign up action
                // Navigate to the sign-up page
                dispose(); // Close the login page
                SignUpPage signUpPage = new SignUpPage();
                signUpPage.setVisible(true); // Show the sign-up page
            }
        });
        southPanel.add(signUpButton);

        mainPanel.add(southPanel, BorderLayout.SOUTH);

        // Add main panel to frame
        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }
}
