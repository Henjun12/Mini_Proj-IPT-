import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TransactionHistoryPage extends JFrame {

    public TransactionHistoryPage() {
        setTitle("Transaction History");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setBackground(Color.WHITE);

        // Title label
        JLabel titleLabel = new JLabel("Transaction History");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.DARK_GRAY);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Text area for transaction history
        JTextArea transactionTextArea = new JTextArea();
        transactionTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(transactionTextArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // South panel for back button
        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.BLACK);

        JButton backButton = createStyledButton("Back to Dashboard");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Navigate back to the dashboard
                dispose(); // Close transaction history page
                new DashboardPage().setVisible(true); // Bring up the dashboard page
            }
        });
        southPanel.add(backButton);
        mainPanel.add(southPanel, BorderLayout.SOUTH);

        // Add main panel to frame
        add(mainPanel);
    }

    // Helper method to create styled buttons
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(59, 89, 182)); // Blue
        button.setPreferredSize(new Dimension(200, 40));
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TransactionHistoryPage().setVisible(true);
            }
        });
    }
}