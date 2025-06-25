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
    }
}
