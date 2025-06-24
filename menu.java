import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("======== Base Converter ========");
            System.out.println("1. Convert text to base");
            System.out.println("2. Exit");
            System.out.println("================================");
            System.out.print("Your choice (1-2):   ");

            String menuChoice = scanner.nextLine().trim();

            if (!Validator.isValidMenuChoice(menuChoice)) {
                System.out.println("Invalid choice. Please enter 1 or 2.");
                continue;
            }

            if (menuChoice.equals("2")) {
                break;
            }

            System.out.println("================================");
            System.out.println("Choose the destination base:");
            System.out.println("-h or hexadecimal - Hexadecimal");
            System.out.println("-o or octal       - Octal");
            System.out.println("-d or decimal     - Decimal");
            System.out.println("-b or binary      - Binary");
            System.out.println("-t or text        - Text");
            System.out.println("================================");
            System.out.print("Your choice: ");
            String base = scanner.nextLine().trim().toLowerCase();

            if (!Validator.isValidBase(base)) {
                System.out.println("Invalid base. Try again.");
                continue;
            }

            System.out.print("Enter your text: ");
            String text = scanner.nextLine();

            // Placeholder for encoding
            String encodedResult = "blabla"; // Simulated encoding
            System.out.println("Encoded result: " + encodedResult);

            if (askYesNo(scanner, "Do you want to decode the encoded result? (y/n)")) {
                // Placeholder for decoding
                System.out.println("Decoded result: " + text);
            }

            // 🔐 Encryption placeholder
            if (askYesNo(scanner, "Do you want to encrypt the encoded result? (y/n)")) {
                int key = askInteger(scanner, "Enter the encryption key (integer): ");
                String encrypted = "encrypted_" + encodedResult + "_with_key_" + key; // Simulated
                System.out.println("Encrypted result: " + encrypted);

                if (askYesNo(scanner, "Do you want to decrypt it? (y/n)")) {
                    String decrypted = "decrypted_" + encrypted; // Simulated
                    System.out.println("Decrypted result: " + decrypted);
                }
            }

            boolean validChoice = false;
            while (!validChoice) {
                System.out.print("Do you want to perform another conversion or quit? (1 = Continue, 2 = Exit): ");
                String finalChoice = scanner.nextLine();
                if (Validator.isValidMenuChoice(finalChoice)) {
                    keepGoing = finalChoice.equals("1");
                    validChoice = true;
                } else {
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                }
            }
        }

        System.out.println("Thank you for using the converter!");
        scanner.close();
    }

    public static boolean askYesNo(Scanner scanner, String question) {
        while (true) {
            System.out.print(question + " ");
            String answer = scanner.nextLine().trim().toLowerCase();
            if (Validator.isYesNo(answer)) {
                return answer.equals("y");
            }
            System.out.println("Invalid input. Type 'y' for yes or 'n' for no.");
        }
    }

    public static int askInteger(Scanner scanner, String question) {
        while (true) {
            try {
                System.out.print(question);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }
}
