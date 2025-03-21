import java.util.Scanner;

public class SimpleCurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Hardcoded exchange rates (Modify as needed)
        double usdToInr = 82.5;
        double eurToInr = 90.0;
        double usdToEur = 0.92;

        System.out.println("Select base currency: (1) USD, (2) EUR, (3) INR");
        int baseChoice = scanner.nextInt();

        System.out.println("Select target currency: (1) USD, (2) EUR, (3) INR");
        int targetChoice = scanner.nextInt();

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        double convertedAmount = 0;
        String targetCurrency = "";

        // Currency conversion logic
        if (baseChoice == 1 && targetChoice == 3) { // USD to INR
            convertedAmount = amount * usdToInr;
            targetCurrency = "INR";
        } else if (baseChoice == 3 && targetChoice == 1) { // INR to USD
            convertedAmount = amount / usdToInr;
            targetCurrency = "USD";
        } else if (baseChoice == 2 && targetChoice == 3) { // EUR to INR
            convertedAmount = amount * eurToInr;
            targetCurrency = "INR";
        } else if (baseChoice == 3 && targetChoice == 2) { // INR to EUR
            convertedAmount = amount / eurToInr;
            targetCurrency = "EUR";
        } else if (baseChoice == 1 && targetChoice == 2) { // USD to EUR
            convertedAmount = amount * usdToEur;
            targetCurrency = "EUR";
        } else if (baseChoice == 2 && targetChoice == 1) { // EUR to USD
            convertedAmount = amount / usdToEur;
            targetCurrency = "USD";
        } else {
            System.out.println("Invalid selection. Please try again.");
            return;
        }

        System.out.printf("Converted Amount: %.2f %s\n", convertedAmount, targetCurrency);
        scanner.close();
    }
}
