import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Main {
    static void converter() {
        JFrame f = new JFrame("Currency Converter");
        JPanel panel = new JPanel(new BorderLayout());

        JLabel l1, l2, l3;
        JTextField tf1, tf2;
        JButton b1, b3;
        JComboBox<String> fromCurrencyComboBox, toCurrencyComboBox;

        l1 = new JLabel("Amount:");
        l2 = new JLabel("Converted:");
        l3 = new JLabel("Convert From:");
        tf1 = new JTextField("0", 10);
        tf2 = new JTextField("0", 10);
        b1 = new JButton("Convert");
        b3 = new JButton("Close");

        String[] currencies = { "Rupees", "Dollars", "Euros", "Pounds", "Yen" };

        fromCurrencyComboBox = new JComboBox<>(currencies);
        toCurrencyComboBox = new JComboBox<>(currencies);

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(l1);
        inputPanel.add(tf1);
        inputPanel.add(l3);
        inputPanel.add(fromCurrencyComboBox);
        inputPanel.add(l2);
        inputPanel.add(tf2);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(b1);
        buttonPanel.add(b3);

        panel.add(inputPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        f.add(panel);
        f.setSize(400, 200);
        f.setLocationRelativeTo(null);
        f.setVisible(true);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Double amount = Double.parseDouble(tf1.getText());
                String fromCurrency = (String) fromCurrencyComboBox.getSelectedItem();
                String toCurrency = (String) toCurrencyComboBox.getSelectedItem();
                double convertedAmount = 0;

                // Conversion rates (you can adjust these as needed)
                double rupeesToDollarsRate = 65.25;
                double dollarsToRupeesRate = 1 / rupeesToDollarsRate;
                double eurosToDollarsRate = 1.20;
                // Add more conversion rates as needed

                if (fromCurrency.equals("Rupees") && toCurrency.equals("Dollars")) {
                    convertedAmount = amount * rupeesToDollarsRate;
                } else if (fromCurrency.equals("Dollars") && toCurrency.equals("Rupees")) {
                    convertedAmount = amount * dollarsToRupeesRate;
                } else if (fromCurrency.equals("Euros") && toCurrency.equals("Dollars")) {
                    convertedAmount = amount * eurosToDollarsRate;
                } // Add more conversion cases as needed

                String formattedResult = String.format("%.2f", convertedAmount);
                tf2.setText(formattedResult);
            }
        });

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });
    }

    public static void main(String[] args) {
        converter();
    }
}
