package com.globalconverter;

public class Cipher {

    //CAESAR CIPHER
    /*
     * Encrypt text with caesar number
     * Take param:
     * text = text to encrypt
     * shift = number input
     * return -> encrypt text
     */
    public static String caesarEncrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        shift = shift % 26; 
        
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                char shifted = (char) ((c - base + shift) % 26 + base);
                result.append(shifted);
            } else {
                result.append(c); 
            }
        }
        return result.toString();
    }

    public static String caesarDecrypt(String text, int shift){
        return caesarEncrypt(text, -shift);
    }

        //SIMPLE SUBSTITUTION CIPHER
    /*
     * Encrypt text with simple substitution
     * Take param:
     * text = text to encrypt
     * key = key substitution (26 characters)
     * return -> encrypt text
     */
    private static String substitutionProcess(String text, String key, boolean encrypt){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder result = new StringBuilder();

        String source = encrypt ? alphabet : key;
        String destination = encrypt ? key : alphabet;
        
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                boolean isUpper = Character.isUpperCase(c);
                char upperC = Character.toUpperCase(c);
                int index = source.indexOf(upperC);
                
                if (index != -1) {
                    char substituted = destination.charAt(index);
                    result.append(isUpper ? substituted : Character.toLowerCase(substituted));
                } else {
                    result.append(c);
                }
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

        /*
     * Encrypt func
     */
    public static String substitutionEncrypt(String text, String key){
        return substitutionProcess(text, key, true);
    }
    
    /*
     * Decrypt func
     */
    public static String substitutionDecrypt(String text, String key){
        return substitutionProcess(text, key, false);
    }

        //XOR CIPHER
    /*
     * Encrypt and Decrypt text with xor 
     * Take param:
     * text = text to encrypt
     * key = key for xor operator
     * return -> encrypt text or decrypt text
     */

     public static String xorCipher(String text, String key){
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++){
            char textChar = text.charAt(i);
            char keyChar = key.charAt( i % key.length());

            int xored = 0;
            int a = (int) textChar;
            int b = (int) keyChar;

            for (int bit = 0; bit < 16; bit++){
                int bitA = (a >> bit) & 1;
                int bitB = (b >> bit) & 1;

                if (bitA != bitB) {
                    xored |= (1 << bit);
                }
            }
            result.append((char) xored);
        }
        return result.toString();
     }

        //VIGENERE CIPHER
    /*
     * Encrypt and Decrypt text with Vigenere
     * Take param:
     * text = text to encrypt
     * key = key for xor operator
     * return -> encrypt text or decrypt text
     */
     private static String vigenereProcess(String text, String key, boolean encrypt){
        StringBuilder result = new StringBuilder();
        String upperKey = key.toUpperCase();
        int keyIndex = 0;

        for (char c : text.toCharArray()){
            if(Character.isLetter(c)){
                Boolean isUpper = Character.isUpperCase(c);
                char base = isUpper ? 'A' : 'a';

                int shift = upperKey.charAt(keyIndex % upperKey.length()) - 'A';
                if(!encrypt) shift = -shift;
                char processed = (char) ((c - base + shift + 26)% 26 + base);
                result.append(processed);
                keyIndex++;
            } else {
                result.append(c);
            }
        }
        return result.toString();
     }

    /*
    * Encrypt func
    */
    public static String vigenereEncrypt(String text, String key){
        return vigenereProcess(text, key, true);
    }

    /*
    * Decrypt func
    */
    public static String vigenereDecrypt(String text, String key){
        return vigenereProcess(text, key, false);
    }


}
