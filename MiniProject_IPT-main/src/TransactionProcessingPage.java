import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionProcessingPage extends JFrame {
    private JTextField amountField, nameField, rateField, yearsField;
    private JLabel monthlyPaymentLabel;
    private JTextArea transactionTextArea;
    private List<String> transactionHistory;

    public TransactionProcessingPage() {
        setTitle("Transaction Processing");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        transactionHistory = new ArrayList<>();

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.GRAY);

        JLabel titleLabel = new JLabel("Transaction Processing");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(Color.WHITE);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4, 1, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        centerPanel.setBackground(Color.BLACK);

        // Panels for labels and text fields
        JPanel[] labelPanels = new JPanel[4];
        JPanel[] textFieldPanels = new JPanel[4];

        for (int i = 0; i < 4; i++) {
            labelPanels[i] = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Right align labels
            labelPanels[i].setBackground(Color.BLACK);
            textFieldPanels[i] = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Left align text fields
            textFieldPanels[i].setBackground(Color.BLACK);
        }

        // Labels
        JLabel[] labels = {
                new JLabel("Applicant Name:"),
                new JLabel("Loan Amount (MYR):"),
                new JLabel("Interest Rate (% per annum):"),
                new JLabel("Years:")
        };

        // Text fields
        JTextField[] textFields = {
                nameField = new JTextField(15),
                amountField = new JTextField(15),
                rateField = new JTextField(15),
                yearsField = new JTextField(15)
        };

        // Add labels and text fields to corresponding panels
        for (int i = 0; i < 4; i++) {
            labelPanels[i].add(labels[i]);
            textFieldPanels[i].add(textFields[i]);
            centerPanel.add(labelPanels[i]);
            centerPanel.add(textFieldPanels[i]);
        }

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.setBackground(Color.GRAY);

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonsPanel.setBackground(Color.GRAY);

        JButton loadFundsButton = new JButton("Load Funds");
        loadFundsButton.setForeground(Color.WHITE);
        loadFundsButton.setBackground(Color.BLUE);
        loadFundsButton.addActionListener(e -> {
            String amountText = amountField.getText();
            double amount = Double.parseDouble(amountText);
            transactionHistory.add("Funds loaded: MYR " + amount);
            updateTransactionHistory();
            JOptionPane.showMessageDialog(null, "Funds loaded successfully: MYR " + amount);
            amountField.setText("");
        });
        buttonsPanel.add(loadFundsButton);

        JButton calculateButton = new JButton("Calculate Monthly Payment");
        calculateButton.setForeground(Color.WHITE);
        calculateButton.setBackground(Color.BLUE);
        calculateButton.addActionListener(e -> calculateMonthlyPayment());
        buttonsPanel.add(calculateButton);

        JButton backButton = new JButton("Back");
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.BLUE);
        backButton.addActionListener(e -> {
            // Close the current TransactionProcessingPage
            dispose();

            // Open the DashboardPage
            DashboardPage dashboardPage = new DashboardPage();
            dashboardPage.setVisible(true);
        });
        buttonsPanel.add(backButton);

        southPanel.add(buttonsPanel, BorderLayout.CENTER);

        mainPanel.add(southPanel, BorderLayout.SOUTH);

        JPanel eastPanel = new JPanel(new BorderLayout());
        monthlyPaymentLabel = new JLabel("");
        monthlyPaymentLabel.setForeground(Color.WHITE);
        eastPanel.add(monthlyPaymentLabel, BorderLayout.NORTH);

        transactionTextArea = new JTextArea();
        transactionTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(transactionTextArea);
        eastPanel.add(scrollPane, BorderLayout.CENTER);

        mainPanel.add(eastPanel, BorderLayout.EAST);

        add(mainPanel);
    }

    private void calculateMonthlyPayment() {
        String name = nameField.getText();
        double amount = Double.parseDouble(amountField.getText());
        double rate = Double.parseDouble(rateField.getText());
        int years = Integer.parseInt(yearsField.getText());

        double monthlyInterestRate = rate / 12 / 100;
        int numberOfPayments = years * 12;
        double monthlyPayment = (amount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));

        monthlyPaymentLabel.setText("Monthly Payment (MYR): MYR " + String.format("%.2f", monthlyPayment));
        transactionHistory.add("Monthly Payment Calculated: MYR " + String.format("%.2f", monthlyPayment));
        updateTransactionHistory();
    }

    private void updateTransactionHistory() {
        StringBuilder sb = new StringBuilder();
        for (String transaction : transactionHistory) {
            sb.append(transaction).append("\n");
        }
        transactionTextArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TransactionProcessingPage().setVisible(true));
    }
}
