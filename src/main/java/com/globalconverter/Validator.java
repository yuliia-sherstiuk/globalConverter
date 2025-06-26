package com.globalconverter;

import com.globalconverter.Cipher;

public class Validator {

    public static boolean isValidMenuChoice(String input) {
        return input.equals("1") || input.equals("2");
    }

    public static boolean isValidBase(String input) {
        return input.equals("h") || input.equals("hexadecimal") ||
               input.equals("o") || input.equals("octal") ||
               input.equals("d") || input.equals("decimal") ||
               input.equals("b") || input.equals("binary") ||
               input.equals("t") || input.equals("text");
    }

    public static boolean isYesNo(String input) {
        return input.equals("y") || input.equals("n") || input.equals("o");
    }

    public static boolean isValidSubstitutionKey(String key) {
        if (key.length() != 26) return false;

        boolean[] seen = new boolean[26];
        for (char c : key.toCharArray()) {
            if (c < 'a' || c > 'z') return false;
            int index = c - 'a';
            if (seen[index]) return false;
            seen[index] = true;
        }
        return true;
    }

    public static String encryptCesar(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                c = (char) ((c - base + shift + 26) % 26 + base);
            }
            result.append(c);
        }
        return result.toString();
    }

    public static String decryptCesar(String text, int shift) {
        return encryptCesar(text, 26 - (shift % 26));
    }

    public static String encryptSubstitution(String text, String key) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char mapped = key.charAt(Character.toLowerCase(c) - 'a');
                result.append(Character.isUpperCase(c) ? Character.toUpperCase(mapped) : mapped);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String decryptSubstitution(String text, String key) {
        char[] reverseKey = new char[26];
        for (int i = 0; i < 26; i++) {
            reverseKey[key.charAt(i) - 'a'] = (char) ('a' + i);
        }

        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char decoded = reverseKey[Character.toLowerCase(c) - 'a'];
                result.append(Character.isUpperCase(c) ? Character.toUpperCase(decoded) : decoded);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    // ✅ Convert text to specified base
    public static String encodeTextToBase(String text, String base) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            int ascii = (int) c;
            switch (base) {
                case "h":
                case "hexadecimal":
                    result.append(Integer.toHexString(ascii)).append(" ");
                    break;
                case "o":
                case "octal":
                    result.append(Integer.toOctalString(ascii)).append(" ");
                    break;
                case "d":
                case "decimal":
                    result.append(ascii).append(" ");
                    break;
                case "b":
                case "binary":
                    result.append(Integer.toBinaryString(ascii)).append(" ");
                    break;
                case "t":
                case "text":
                    result.append(c);
                    break;
                default:
                    break;
            }
        }
        return result.toString().trim();
    }

    // ✅ Convert from base back to text
    public static String decodeBaseToText(String encoded, String base) {
        if (base.equals("t") || base.equals("text")) return encoded;

        StringBuilder result = new StringBuilder();
        String[] tokens = encoded.split("\\s+");

        for (String token : tokens) {
            int ascii = switch (base) {
                case "h", "hexadecimal" -> Integer.parseInt(token, 16);
                case "o", "octal" -> Integer.parseInt(token, 8);
                case "d", "decimal" -> Integer.parseInt(token, 10);
                case "b", "binary" -> Integer.parseInt(token, 2);
                default -> -1;
            };
            result.append((char) ascii);
        }

        return result.toString();
    }

    // ✅ XOR encryption/decryption (XOR works symmetrically)
    public static String encryptXOR(String text, char key) {
        return Cipher.xorCipher(text, String.valueOf(key));
    }

    public static String decryptXOR(String text, char key) {
        return Cipher.xorCipher(text, String.valueOf(key));
    }

    // ✅ Check key for Vigenere (letters only)
    public static boolean isValidVigenereKey(String key) {
        return key != null && key.matches("[a-zA-Z]+");
    }

    public static String encryptVigenere(String text, String keyword) {
        return Cipher.vigenereEncrypt(text, keyword);
    }

    public static String decryptVigenere(String text, String keyword) {
        return Cipher.vigenereDecrypt(text, keyword);
    }
}
