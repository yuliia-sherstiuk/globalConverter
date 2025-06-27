//Validator.java
package com.globalconverter;



public class Validator {
    // Instance of Converter class to handle conversion operations
    private static final Converter conv = new Converter();
    
    // Validates if the input is a valid menu choice
    public static boolean isValidMenuChoice(String input) {
        return input.equals("1") || input.equals("2");

    }
    // Validatas if the input is a valid base for conversion
    public static boolean isValidBase(String input) {
        return input.matches("h|hexadecimal|o|octal|d|decimal|b|binary|t|text");
    }

    // Validates of the input is a valid yes/no response
    public static boolean isYesNo(String input) {
        return input.equals("y") || input.equals("n") || input.equals("o");
    }

     // Validates if the substitution key is valid (26 unique lowercase letters)
    public static boolean isValidSubstitutionKey(String key) {
        if (key.length() != 26) return false;
        boolean[] seen = new boolean[26];
        for (char c : key.toLowerCase().toCharArray()) {
            if (c < 'a' || c > 'z') return false;
            if (seen[c - 'a']) return false;
            seen[c - 'a'] = true;
        }
        return true;
    }

    // Validates if the Viganara is valid ( only letters)
    public static boolean isValidVigenereKey(String key) {
        return key != null && key.matches("[a-zA-Z]+");
    }
    
    // Encodes the given text to the specified base
    public static String encodeTextToBase(String text, String base) {
        return switch (base) {
            case "h", "hexadecimal" -> conv.textToHexString(text);
            case "o", "octal"       -> conv.textToOctalString(text);
            case "d", "decimal"     -> conv.textToAsciiString(text);
            case "b", "binary"      -> conv.textToBinaryString(text);
            case "t", "text"        -> text;
            default -> throw new IllegalArgumentException("Unsupported base: " + base);
        };
    }
    // Decodes the given encoded string from the specified base back to text
    public static String decodeBaseToText(String encoded, String base) {
        return switch (base) {
            case "h", "hexadecimal" -> conv.hexToTextString(encoded);
            case "o", "octal"       -> conv.octalToTextString(encoded);
            case "d", "decimal"     -> conv.asciiToTextString(encoded);
            case "b", "binary"      -> conv.binaryToTextString(encoded);
            case "t", "text"        -> encoded;
            default -> throw new IllegalArgumentException("Unsupported base: " + base);
        };
    }

    // Encrypts the given text using the Caesar cipher with the specified shift
    public static String encryptCesar(String text, int shift) {
        return Cipher.caesarEncrypt(text, shift);
    }

    // Decrypts the given text using the Caesar cipher with the specified shift
    public static String decryptCesar(String text, int shift) {
        return Cipher.caesarDecrypt(text, shift);
    }

    // Encrypts the given text using the XOR cipher with the specified key
    public static String encryptXOR(String text, char key) {
        return Cipher.xorCipher(text, String.valueOf(key));
    }

    // Decrypts the given text using the XOR cipher with the specified key
    public static String decryptXOR(String text, char key) {
        return Cipher.xorCipher(text, String.valueOf(key));
    }

    // Encrypts the given text using the Vigenère cipher with the specified keyword
    public static String encryptVigenere(String text, String keyword) {
        return Cipher.vigenereEncrypt(text, keyword);
    }

    // Decrypts the given text using the Vigenère cipher with the specified keyword
    public static String decryptVigenere(String text, String keyword) {
        return Cipher.vigenereDecrypt(text, keyword);
    }

    // Encrypts the given text using the Substitution cipher with the specified key
    public static String encryptSubstitution(String text, String key) {
        text = text.toLowerCase();
        key = key.toLowerCase();
        StringBuilder result = new StringBuilder();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for (char c : text.toCharArray()) {
            int index = alphabet.indexOf(c);
            if (index != -1) {
                result.append(key.charAt(index));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    // Decrypts the given text using the Substitution cipher with the specified key
    public static String decryptSubstitution(String text, String key) {
        text = text.toLowerCase();
        key = key.toLowerCase();
        StringBuilder result = new StringBuilder();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for (char c : text.toCharArray()) {
            int index = key.indexOf(c);
            if (index != -1) {
                result.append(alphabet.charAt(index));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}

