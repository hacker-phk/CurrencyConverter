import java.util.Scanner;

public class test {
    void display() {

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define exchange rates (e.g., USD to other currencies)
        double[] exchangeRates = {
                1.0, // USD to USD (1:1)
                0.85, // USD to EUR
                110.53, // USD to JPY
                0.73, // USD to GBP
                1.37, // USD to AUD
                1.26, // USD to CAD
                0.92, // USD to CHF
                6.45, // USD to CNY
                8.47, // USD to SEK
                1.47 // USD to NZD
        };

        String[] currencyNames = {
                "USD",
                "EUR",
                "JPY",
                "GBP",
                "AUD",
                "CAD",
                "CHF",
                "CNY",
                "SEK",
                "NZD"
        };

        // Welcome message and menu
        System.out.println("Welcome to Currency Converter!");
        System.out.println("Select a currency to convert to:");

        for (int i = 0; i < exchangeRates.length; i++) {
            System.out.println((i + 1) + ". " + currencyNames[i] + " - " + exchangeRates[i]);
        }

        System.out.print("Enter your choice from (1-" + exchangeRates.length + "): ");
        int choice1 = scanner.nextInt();
        System.out.print("Enter your choice to (1-" + exchangeRates.length + "): ");
        int choice2 = scanner.nextInt();

        if (choice1 >= 1 && choice1 <= exchangeRates.length) {
            System.out.print("Enter the amount in USD: ");
            double amountInUSD = scanner.nextDouble();

            double convertedAmount = (exchangeRates[choice1 - 1] * amountInUSD) / exchangeRates[choice2 - 1];
            System.out.println(
                    "Converted amount from: " + amountInUSD +""+ currencyNames[choice1 - 1] + "    to " + convertedAmount
                            + currencyNames[choice2 - 1]);
        } else {
            System.out.println("Invalid choice. Please select a valid option.");
        }

        scanner.close();
    }
}
