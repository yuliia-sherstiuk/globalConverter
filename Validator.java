public class Validator { 

    // Vérifie que le choix du menu est bien "1" ou "2"
    public static boolean isValidMenuChoice(String input) {
        return input.equals("1") || input.equals("2");
    }

    // Vérifie que la base choisie est valide
    public static boolean isValidBase(String input) {
        return input.equals("-h") || input.equals("hexadecimal") ||
               input.equals("-o") || input.equals("octal") ||
               input.equals("-d") || input.equals("decimal") ||
               input.equals("-b") || input.equals("binary") ||
               input.equals("-t") || input.equals("text");
    }

    // Vérifie que la réponse est bien "y" ou "n"
    public static boolean isYesNo(String input) {
        return input.equals("y") || input.equals("n");
    }

    // Vérifie que la clé de substitution contient exactement 26 lettres uniques
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

    // Implémentation simple du chiffrement César
    public static String encryptCesar(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                c = (char) ((c - base + shift) % 26 + base);
            }
            result.append(c);
        }
        return result.toString();
    }

    public static String decryptCesar(String text, int shift) {
        return encryptCesar(text, 26 - (shift % 26));
    }

    // Chiffrement par substitution
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

    // Déchiffrement par substitution
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
}
