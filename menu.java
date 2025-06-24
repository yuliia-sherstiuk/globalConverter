//Menu.java
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
            System.out.print("Your choice (1-2): ");
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
            System.out.println("- h or hexadecimal");
            System.out.println("- o or octal");
            System.out.println("- d or decimal");
            System.out.println("- b or binary");
            System.out.println("- t or text (no conversion)");
            System.out.println("================================");
            System.out.print("Your choice: ");
            String base = scanner.nextLine().trim().toLowerCase();

            if (!Validator.isValidBase(base)) {
                System.out.println("Invalid base. Try again.");
                continue;
            }

            System.out.print("Enter your text: ");
            String text = scanner.nextLine();

            // 🔄 Conversion of text to chosen base
            String encodedResult = Validator.encodeTextToBase(text, base);
            System.out.println("Encoded result: " + encodedResult);

            // 🔐 Encryption logic
            if (askYesNo(scanner, "Do you want to encrypt the text? (y/n)")) {
                String method;
                do {
                    System.out.println("1 - Caesar");
                    System.out.println("2 - Simple Substitution");
                    System.out.print("Choose a method (1 or 2): ");
                    method = scanner.nextLine().trim();
                } while (!method.equals("1") && !method.equals("2"));

                String toEncrypt = encodedResult;
                String encrypted = null;

                if (method.equals("1")) {
                    int key = askInteger(scanner, "Enter the encryption key (integer): ");
                    encrypted = Validator.encryptCesar(toEncrypt, key);
                    System.out.println("Encrypted text (Caesar): " + encrypted);

                    if (askYesNo(scanner, "Do you want to decrypt the text? (y/n)")) {
                        String decrypted = Validator.decryptCesar(encrypted, key);
                        System.out.println("Decrypted text (Caesar): " + decrypted);
                    }
                } else if (method.equals("2")) {
                    String key;
                    do {
                        System.out.print("Enter the substitution key (26 unique lowercase letters): ");
                        key = scanner.nextLine().trim();
                        if (!Validator.isValidSubstitutionKey(key)) {
                            System.out.println("Invalid key, please try again.");
                        }
                    } while (!Validator.isValidSubstitutionKey(key));

                    encrypted = Validator.encryptSubstitution(toEncrypt, key);
                    System.out.println("Encrypted text (Substitution): " + encrypted);

                    if (askYesNo(scanner, "Do you want to decrypt the text? (y/n)")) {
                        String decrypted = Validator.decryptSubstitution(encrypted, key);
                        System.out.println("Decrypted text (Substitution): " + decrypted);
                    }
                }
            }

            // 🔁 Decode base back to text
            if (askYesNo(scanner, "Do you want to decode the encoded result? (y/n)")) {
                String decodedResult = Validator.decodeBaseToText(encodedResult, base);
                System.out.println("Decoded result: " + decodedResult);
            }

            // 🔁 Repeat or exit
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
                return answer.equals("y") || answer.equals("o"); // 'o' for 'oui'
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
