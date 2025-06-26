//Validator.java
package com.globalconverter;



public class Validator {

    private static final Converter conv = new Converter();

    public static boolean isValidMenuChoice(String input) {
        return input.equals("1") || input.equals("2");
    }

    public static boolean isValidBase(String input) {
        return input.matches("h|hexadecimal|o|octal|d|decimal|b|binary|t|text");
    }

    public static boolean isYesNo(String input) {
        return input.equals("y") || input.equals("n") || input.equals("o");
    }

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

    public static boolean isValidVigenereKey(String key) {
        return key != null && key.matches("[a-zA-Z]+");
    }

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

    public static String encryptCesar(String text, int shift) {
        return Cipher.caesarEncrypt(text, shift);
    }

    public static String decryptCesar(String text, int shift) {
        return Cipher.caesarDecrypt(text, shift);
    }

    public static String encryptXOR(String text, char key) {
        return Cipher.xorCipher(text, String.valueOf(key));
    }

    public static String decryptXOR(String text, char key) {
        return Cipher.xorCipher(text, String.valueOf(key));
    }

    public static String encryptVigenere(String text, String keyword) {
        return Cipher.vigenereEncrypt(text, keyword);
    }

    public static String decryptVigenere(String text, String keyword) {
        return Cipher.vigenereDecrypt(text, keyword);
    }


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

