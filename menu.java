import java.util.Scanner;

public class Menu  {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuer = true;

        // Main loop for the application
        while (continuer) {
            // Display main menu
            System.out.println("======== Convertisseur de base =====");
            System.out.println("1. Convert text to base");
            System.out.println("2. Exit");
            System.out.println("=====================================");
            System.out.print("Your choice (1-2): ");
            String choixMenu = scanner.nextLine().trim();

            // Validate menu choice
            if (!choixMenu.equals("1") && !choixMenu.equals("2")) {
                System.out.println("Invalid choice. Please enter 1 or 2.");
                continue;
            }

            // Exit program if user chooses option 2
            if (choixMenu.equals("2")) {
                break;
            }

            // Ask user to choose destination base
            System.out.println("Choose the destination base:");
            System.out.println("-h or hexadecimal - Hexadecimal");
            System.out.println("-o or octal       - Octal");
            System.out.println("-d or decimal     - Decimal");
            System.out.println("-b or binary      - Binary");
            System.out.println("-t or text        - Text");
            System.out.println("=====================================");
            System.out.print("Your choice: ");
            String base = scanner.nextLine().trim().toLowerCase();

            // Validate base input
            if (!base.matches("-[hodbt]")) {
                System.out.println("Invalid base. Try again.");
                continue;
            }

            // Ask user to enter the text
            System.out.print("Enter your text: ");
            String texte = scanner.nextLine();

            // Simulated encoding (to be implemented)
            String resultatEncode = "blabla";
            System.out.println("Encoded result: " + resultatEncode);

            // Ask if the user wants to decode the result
            if (choixOuiNon(scanner, "Do you want to decode the encoded result? y/n")) {
                // Simulated decoding (to be implemented)
                System.out.println("Decoded result: " + texte);
            }

            // Ask if the user wants to encrypt the result
            if (choixOuiNon(scanner, "Do you want to encrypt the encoded result? y/n")) {
                int cle = demanderEntier(scanner, "Enter the encryption key: ");
                // Simulated encryption (to be implemented)
                String chiffre = "blablabla";
                System.out.println("Encrypted result: " + chiffre);

                // Ask if the user wants to decrypt
                if (choixOuiNon(scanner, "Do you want to decrypt? y/n")) {
                    // Simulated decryption (to be implemented)
                    String dechiffre = "blablabla";
                    System.out.println("Decrypted result: " + dechiffre);
                }
            }

            // Ask if user wants to continue or exit
            boolean choixValide = false;
            while (!choixValide) {
                System.out.print("Do you want to perform another conversion or quit? 1-2: ");
                String choixFinal = scanner.nextLine();
                if (choixFinal.equals("1")) {
                    choixValide = true;
                } else if (choixFinal.equals("2")) {
                    continuer = false;
                    choixValide = true;
                } else {
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                }
            }
        }

        // Goodbye message
        System.out.println("Thank you for using the converter!");
        scanner.close();
    }

    // Method to ask yes/no question (returns true for 'o', false for 'n')
    public static boolean choixOuiNon(Scanner scanner, String question) {
        while (true) {
            System.out.print(question + " ");
            String reponse = scanner.nextLine().trim().toLowerCase();
            if (reponse.equals("o")) return true;
            if (reponse.equals("n")) return false;
            System.out.println("Invalid input. Type 'o' for yes or 'n' for no.");
        }
    }

    // Method to safely ask for an integer input
    public static int demanderEntier(Scanner scanner, String question) {
        while (true) {
            try {
                System.out.print(question);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer number.");
            }
        }
    }
}

