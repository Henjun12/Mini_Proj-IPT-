import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ErrorHandlingPage extends JFrame {
    private String errorMessage;

    public ErrorHandlingPage(String errorMessage) {
        this.errorMessage = errorMessage;
        setTitle("Error");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel errorLabel = new JLabel("Error:");
        panel.add(errorLabel, BorderLayout.NORTH);

        JTextArea errorTextArea = new JTextArea();
        errorTextArea.setEditable(false);
        errorTextArea.setText(errorMessage);
        panel.add(errorTextArea, BorderLayout.CENTER);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Close the error handling page
                dispose();
            }
        });
        panel.add(okButton, BorderLayout.SOUTH);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Example usage
                String errorMessage = "An error occurred while processing the transaction.";
                new ErrorHandlingPage(errorMessage).setVisible(true);
            }
        });
    }
}
