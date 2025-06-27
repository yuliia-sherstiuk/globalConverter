package com.globalconverter;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepGoing = true;

        //Main loop to keep the program running until the user chooses to exit
        while (keepGoing) {
            System.out.println("======== Base Converter ========");
            System.out.println("1. Convert text to base");
            System.out.println("2. Exit");
            System.out.println("================================");
            System.out.print("Your choice (1-2): ");
            String menuChoice = scanner.nextLine().trim();

            // Validate user's menu choice input
            if (!Validator.isValidMenuChoice(menuChoice)) {
                System.out.println("Invalid choice. Please enter 1 or 2.");
                continue;
            }

            // Exit the program if the user chooses to do so
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

            // Validate user's base choice input
            if (!Validator.isValidBase(base)) {
                System.out.println("Invalid base. Try again.");
                continue;
            }

            System.out.print("Enter your text: ");
            String text = scanner.nextLine();

            // 🔄 Conversion of text to chosen base
            String encodedResult = Validator.encodeTextToBase(text, base);
            System.out.println("Encoded result: " + encodedResult);

            // 🔁 Decode base back to text
            if (askYesNo(scanner, "Do you want to decode the encoded result? (y/n)")) {
                String decodedResult = Validator.decodeBaseToText(encodedResult, base);
                System.out.println("Decoded result: " + decodedResult);
            }

            // 🔐 Option to encrypt the text using various methods
            if (askYesNo(scanner, "Do you want to encrypt the text? (y/n)")) {
                String method;
                do {
                    System.out.println("1 - Caesar");
                    System.out.println("2 - Simple Substitution");
                    System.out.println("3 - XOR");
                    System.out.println("4 - Vigenere");

                    System.out.print("Choose a method (1 - 4): ");
                    method = scanner.nextLine().trim();

                   
                } while (!method.matches("[1-4]"));  

                String toEncrypt = text; 
                String encrypted = null;

                //Enncryption using the Ceasar cipher method
                if (method.equals("1")) {
                   
                    int key = askInteger(scanner, "Enter the encryption key (integer): ");
                    encrypted = Validator.encryptCesar(toEncrypt, key);
                    System.out.println("Encrypted text (Caesar): " + encrypted);

                    if (askYesNo(scanner, "Do you want to decrypt the text? (y/n)")) {
                        String decrypted = Validator.decryptCesar(encrypted, key);
                        System.out.println("Decrypted text (Caesar): " + decrypted);
                    }

                //Enncryption using the Simple Substitution cipher method
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

                //Enncryption using the XOR cipher method
                } else if (method.equals("3")) {
                    
                    String xorKeyStr;
                    do {
                        System.out.print("Enter XOR key (single character): ");
                        xorKeyStr = scanner.nextLine();

                        if (xorKeyStr.length() != 1) {
                            System.out.println("Invalid key. Please enter exactly one character.");
                        }
                    } while (xorKeyStr.length() != 1);

                    char xorKey = xorKeyStr.charAt(0);
                    encrypted = Validator.encryptXOR(toEncrypt, xorKey);
                    System.out.println("Encrypted text (XOR): " + encrypted);

                    if (askYesNo(scanner, "Do you want to decrypt the text? (y/n)")) {
                        String decrypted = Validator.decryptXOR(encrypted, xorKey);
                        System.out.println("Decrypted text (XOR): " + decrypted);
                    }

                //Enncryption using the Vigenere cipher method
                } else if (method.equals("4")) {
                    
                    String keyword;
                    do {
                        System.out.print("Enter Vigenere keyword: ");
                        keyword = scanner.nextLine().trim();

                        if (!keyword.matches("[a-zA-Z]+")) {
                            System.out.println("Invalid keyword. Please use letters only (A-Z or a-z).");
                        }
                    } while (!keyword.matches("[a-zA-Z]+"));  

                    encrypted = Validator.encryptVigenere(toEncrypt, keyword);
                    System.out.println("Encrypted text (Vigenere): " + encrypted);

                    if (askYesNo(scanner, "Do you want to decrypt the text? (y/n)")) {
                        String decrypted = Validator.decryptVigenere(encrypted, keyword);
                        System.out.println("Decrypted text (Vigenere): " + decrypted);
                    }
                }
            }

            // Ask the user if they want to perform another conversion
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

    //Helper method to ask a yes/no question and validate the response
    public static boolean askYesNo(Scanner scanner, String question) {
        while (true) {
            System.out.print(question + " ");
            String answer = scanner.nextLine().trim().toLowerCase();
            if (Validator.isYesNo(answer)) {
                return answer.equals("y") || answer.equals("o"); 
            }
            System.out.println("Invalid input. Type 'y' for yes or 'n' for no.");
        }
    }

   //Helper method to ask for an integer input and validate the response
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
