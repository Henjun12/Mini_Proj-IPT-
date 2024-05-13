import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpPage extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public SignUpPage() {
        setTitle("Sign Up");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.GRAY);

        // Load and scale the image
        ImageIcon icon = new ImageIcon(getClass().getResource("MoneyLoan.jpeg")); // Replace "your_image_path_here.jpg" with your image path
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImage);

        // Title label with image
        JLabel titleLabel = new JLabel("Sign Up", icon, SwingConstants.CENTER);
        titleLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(Color.WHITE);

        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Center panel with GridLayout for input fields
        JPanel centerPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        centerPanel.setBackground(Color.BLACK);

        // Panel for username row
        JPanel usernamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Using FlowLayout to center components with 10px horizontal and vertical gap
        usernamePanel.setBackground(Color.BLACK);
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.WHITE);
        usernameField = new JTextField(12); // Adjusted size of text field
        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameField);
        centerPanel.add(usernamePanel);

        // Panel for password row
        JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Using FlowLayout to center components with 10px horizontal and vertical gap
        passwordPanel.setBackground(Color.BLACK);
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);
        passwordField = new JPasswordField(12); // Adjusted size of text field
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);
        centerPanel.add(passwordPanel);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // South panel for the sign up button
        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.GRAY);
        southPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setBackground(Color.BLUE);
        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    signUp();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(SignUpPage.this, "Error: " + ex.getMessage(), "Sign Up Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        southPanel.add(signUpButton);

        mainPanel.add(southPanel, BorderLayout.SOUTH);

        // Add main panel to frame
        add(mainPanel);
    }

    private void signUp() throws Exception {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Check if username is empty
        if (username.isEmpty()) {
            throw new Exception("Username cannot be empty.");
        }

        // Check if password is empty
        if (password.isEmpty()) {
            throw new Exception("Password cannot be empty.");
        }

        // Example: Perform sign up logic here (e.g., save username and password to database)
        // For demonstration purposes, simply display a message
        JOptionPane.showMessageDialog(null, "Sign up successful!");

        // Close sign up page
        dispose();

        // Open login page
        LoginPage loginPage = new LoginPage();
        loginPage.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SignUpPage().setVisible(true);
            }
        });
    }
}
