import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Main {
    static double calculate(String a, String b, double amount) {
        Map<String, Double> m = new HashMap<>();

        m.put("USD", 1.0);
        m.put("EUR", 1.20);
        m.put("GBP", 1.38);
        m.put("JPY", 0.0091);
        m.put("INR", 0.013);
        m.put("CAD", 0.79);
        m.put("AUD", 0.73);
        m.put("CHF", 1.10);
        m.put("CNY", 0.16);
        m.put("NZD", 0.68);
        m.put("BRL", 0.19);
        m.put("SGD", 0.74);
        m.put("ZAR", 0.068);
        m.put("AED", 0.27);
        m.put("SEK", 0.11);
        amount *= m.get(a);
        return amount / m.get(b);
    }

    static void converter() {
        JFrame f = new JFrame("Currency Converter");
        JPanel panel = new JPanel(new BorderLayout());

        JLabel l1, l2, l3;
        JTextField tf1, tf2, tf3;
        JButton b1, b2;
        JComboBox<String> fromCurrencyComboBox, toCurrencyComboBox;

        l1 = new JLabel("From:");
        l2 = new JLabel("To:");
        l3 = new JLabel("Convert Amount:");
        tf1 = new JTextField("0", 10);
        tf2 = new JTextField("0", 10);
        tf3 = new JTextField("0", 10);
        b1 = new JButton("Convert");
        b2 = new JButton("Close");

        Map<String, String> m = new HashMap<>();

        // Add currency code to currency name pairs to the map
        m.put("United States Dollar", "USD");
        m.put("Euro", "EUR");
        m.put("British Pound Sterling", "GBP");
        m.put("Japanese Yen", "JPY");
        m.put("Indian Rupee", "INR");
        m.put("Canadian Dollar", "CAD");
        m.put("Australian Dollar", "AUD");
        m.put("Swiss Franc", "CHF");
        m.put("Chinese Yuan", "CNY");
        m.put("New Zealand Dollar", "NZD");
        m.put("Brazilian Real", "BRL");
        m.put("Singapore Dollar", "SGD");
        m.put("South African Rand", "ZAR");
        m.put("United Arab Emirates Dirham", "AED");
        m.put("Swedish Krona", "SEK");
        String[] currencyNames = {
                "United States Dollar",
                "Euro",
                "British Pound Sterling",
                "Japanese Yen",
                "Indian Rupee",
                "Canadian Dollar",
                "Australian Dollar",
                "Swiss Franc",
                "Chinese Yuan",
                "New Zealand Dollar",
                "Brazilian Real",
                "Singapore Dollar",
                "South African Rand",
                "United Arab Emirates Dirham",
                "Swedish Krona"
        };
        fromCurrencyComboBox = new JComboBox<>(currencyNames);
        toCurrencyComboBox = new JComboBox<>(currencyNames);
        JPanel inputPanel = new JPanel(new GridBagLayout()); // Use GridBagLayout here

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);

        inputPanel.add(l1, gbc);
        gbc.gridx++;
        inputPanel.add(tf1, gbc);
        gbc.gridx++;
        inputPanel.add(fromCurrencyComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        inputPanel.add(l2, gbc);
        gbc.gridx++;
        inputPanel.add(tf2, gbc);
        gbc.gridx++;
        inputPanel.add(toCurrencyComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        inputPanel.add(l3, gbc);
        gbc.gridx++;
        inputPanel.add(tf3, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        inputPanel.add(b1, gbc);
        gbc.gridx++;
        inputPanel.add(b2, gbc);

        panel.add(inputPanel, BorderLayout.CENTER);

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        f.add(panel);
        f.setSize(400, 250);
        f.setLocationRelativeTo(null);
        f.setVisible(true);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Double amount = Double.parseDouble(tf1.getText());
                String fromCurrency = (String) fromCurrencyComboBox.getSelectedItem();
                String toCurrency = (String) toCurrencyComboBox.getSelectedItem();
                double convertedAmount = calculate(m.get(fromCurrency), m.get(toCurrency), amount);
                String formattedResult = String.format("%.2f", convertedAmount);
                tf2.setText(formattedResult);
                tf3.setText(formattedResult);
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });
    }

    public static void main(String[] args) {
        converter();
    }
}
