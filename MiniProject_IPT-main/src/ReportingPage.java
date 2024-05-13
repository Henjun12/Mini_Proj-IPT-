import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ReportingPage extends JFrame {
    public ReportingPage() {
        setTitle("Reporting");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel("Reporting");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel, BorderLayout.NORTH);

        JTextArea reportTextArea = new JTextArea();
        reportTextArea.setEditable(false);
        reportTextArea.setText("Transaction Report:\n\n" +
                "1. Transaction Type: Deposit, Amount: MYR 200.00\n" +
                "2. Transaction Type: Withdrawal, Amount: MYR 50.00\n" +
                "3. Transaction Type: Transfer, Amount: MYR 100.00\n");
        JScrollPane scrollPane = new JScrollPane(reportTextArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back to Dashboard");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Navigate back to the dashboard
                dispose(); // Close reporting page
                DashboardPage dashboardPage = new DashboardPage();
                dashboardPage.setVisible(true);
            }
        });
        panel.add(backButton, BorderLayout.SOUTH);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ReportingPage().setVisible(true);
            }
        });
    }
}
