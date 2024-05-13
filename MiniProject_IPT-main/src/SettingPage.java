import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SettingPage extends JFrame {
    public SettingPage() {
        setTitle("Settings");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel("Settings");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel);

        JButton changePasswordButton = new JButton("Change Password");
        changePasswordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open change password dialog
                JOptionPane.showMessageDialog(null, "Change Password dialog opened!");
            }
        });
        panel.add(changePasswordButton);

        JButton updateAccountButton = new JButton("Update Account Info");
        updateAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open update account info dialog
                JOptionPane.showMessageDialog(null, "Update Account Info dialog opened!");
            }
        });
        panel.add(updateAccountButton);

        JButton backButton = new JButton("Back to Dashboard");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Navigate back to the dashboard
                dispose(); // Close settings page
                DashboardPage dashboardPage = new DashboardPage();
                dashboardPage.setVisible(true);
            }
        });
        panel.add(backButton);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SettingPage().setVisible(true);
            }
        });
    }
}
