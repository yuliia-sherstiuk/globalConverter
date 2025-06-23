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
}
