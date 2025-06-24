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
    public static String substitutionEncrypt(String text, String key){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder result = new StringBuilder();
        
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                boolean isUpper = Character.isUpperCase(c);
                char upperC = Character.toUpperCase(c);
                int index = alphabet.indexOf(upperC);
                
                if (index != -1) {
                    char substituted = key.charAt(index);
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
     * Decrypt func
     */

     public static String substitutionDecrypt(String text, String key){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if(Character.isLetter(c)){
                boolean isUpper = Character.isUpperCase(c);
                char upperC = Character.toUpperCase(c);
                int index = key.indexOf(upperC);

                if (index != -1){
                    char original = alphabet.charAt(index);
                    result.append(isUpper ? original: Character.toLowerCase(original));
                } else {
                    result.append(c);
                }
            } else {
                result.append(c);
            }
        }
        return result.toString();
     }


}
