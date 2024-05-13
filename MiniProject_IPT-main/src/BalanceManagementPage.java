import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BalanceManagementPage extends JFrame {
    public BalanceManagementPage() {
        setTitle("Balance Management");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setBackground(Color.WHITE);

        // Title label
        JLabel titleLabel = new JLabel("Balance Management");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Text area for displaying account balances
        JTextArea balanceTextArea = new JTextArea();
        balanceTextArea.setEditable(false);
        balanceTextArea.setText("Account Balances:\n\n" +
                "Savings Account: MYR 500.00\n" +
                "Checking Account: MYR 1000.00\n" +
                "Investment Account: MYR 3000.00\n");
        JScrollPane scrollPane = new JScrollPane(balanceTextArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // South panel for back button
        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.WHITE);

        JButton backButton = new JButton("Back to Dashboard");
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.BLUE);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Navigate back to the dashboard
                dispose(); // Close balance management page
                DashboardPage dashboardPage = new DashboardPage();
                dashboardPage.setVisible(true);
            }
        });

        southPanel.add(backButton);
        mainPanel.add(southPanel, BorderLayout.SOUTH);

        // Add main panel to frame
        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BalanceManagementPage().setVisible(true);
            }
        });
    }
}
