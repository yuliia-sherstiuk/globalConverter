package com.globalconverter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

public class CipherTest {

    @Nested
    @DisplayName("Caesar Cipher Tests")
    class CaesarCipherTests{

        @Test
        @DisplayName("Encrypt simple text with positive shift")
        void testCaesarEncryptPositiveShift(){
            String plaintext = "HELLO";
            int shift = 3;
            String expected = "KHOOR";
            String actual = Cipher.caesarEncrypt(plaintext, shift);
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Encrypted text with mixed case")
        void testCaesarEncryptMixedCase(){
            String plaintext = "Hello World";
            int shift = 5;
            String expected = "Mjqqt Btwqi";
            String actual = Cipher.caesarEncrypt(plaintext, shift);
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Decrypt simple text")
        void testCaesarDecrypt(){
            String ciphertext = "KHOOR";
            int shift = 3;
            String expected = "HELLO";
            String actual = Cipher.caesarDecrypt(ciphertext, shift);
            assertEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("Substitution Cipher Tests")
    class SubstitutionCipherTests {
        private final String standardKey =  "ZYXWVUTSRQPONMLKJIHGFEDCBA";

        @Test
        @DisplayName("Encrypt simple test")
        void testSubstitutionEncrypt(){
            String plaintext = "HELLO";
            String expected = "SVOOL";
            String actual = Cipher.substitutionEncrypt(plaintext, standardKey);
            assertEquals(expected, actual);
        }
    }
}
