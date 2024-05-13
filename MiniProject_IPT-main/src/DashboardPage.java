import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DashboardPage extends JFrame {
    public DashboardPage() {
        setTitle("Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        // Title label
        JLabel titleLabel = new JLabel("Dashboard");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.DARK_GRAY);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Center panel with GridLayout for buttons
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 10, 10)); // Changed to accommodate the new button
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        buttonPanel.setBackground(Color.BLACK);

        // Load Funds button
        JButton loadFundsButton = createStyledButton("Load Funds");
        loadFundsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open transaction processing page
                TransactionProcessingPage processingPage = new TransactionProcessingPage();
                processingPage.setVisible(true);
                dispose(); // Close dashboard page
            }
        });
        buttonPanel.add(loadFundsButton);

        // View Transactions button
        JButton viewTransactionsButton = createStyledButton("View Transactions");
        viewTransactionsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open transaction history page
                TransactionHistoryPage historyPage = new TransactionHistoryPage();
                historyPage.setVisible(true);
                dispose(); // Close dashboard page
            }
        });
        buttonPanel.add(viewTransactionsButton);

        // Logout button
        JButton logoutButton = createStyledButton("Logout");
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform logout action
                JOptionPane.showMessageDialog(null, "Logged out successfully!");
                dispose(); // Close dashboard page
                LoginPage loginPage = new LoginPage();
                loginPage.setVisible(true);
            }
        });
        buttonPanel.add(logoutButton);

        // Settings button
        JButton settingsButton = createStyledButton("Settings");
        settingsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open settings page
                SettingPage settingsPage = new SettingPage();
                settingsPage.setVisible(true);
                dispose(); // Close dashboard page
            }
        });
        buttonPanel.add(settingsButton);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Add main panel to frame
        add(mainPanel);
    }

    // Helper method to create styled buttons
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(59, 89, 182)); // Blue
        button.setPreferredSize(new Dimension(150, 40));
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DashboardPage().setVisible(true);
            }
        });
    }
}
