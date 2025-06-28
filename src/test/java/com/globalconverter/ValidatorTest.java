package com.globalconverter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {

    @Nested
    @DisplayName("Menu Choice Validation")
    class MenuChoiceTest {
        @Test
        void testValidChoices() {
            assertTrue(Validator.isValidMenuChoice("1"));
            assertTrue(Validator.isValidMenuChoice("2"));
        }

        @Test
        void testInvalidChoices() {
            assertFalse(Validator.isValidMenuChoice("3"));
            assertFalse(Validator.isValidMenuChoice("abc"));
        }
    }

    @Nested
    @DisplayName("Base Validation")
    class BaseValidationTest {
        @Test
        void testValidBases() {
            assertTrue(Validator.isValidBase("b"));
            assertTrue(Validator.isValidBase("binary"));
            assertTrue(Validator.isValidBase("h"));
            assertTrue(Validator.isValidBase("hexadecimal"));
            assertTrue(Validator.isValidBase("o"));
            assertTrue(Validator.isValidBase("octal"));
            assertTrue(Validator.isValidBase("d"));
            assertTrue(Validator.isValidBase("decimal"));
            assertTrue(Validator.isValidBase("t"));
            assertTrue(Validator.isValidBase("text"));
        }

        @Test
        void testInvalidBases() {
            assertFalse(Validator.isValidBase("x"));
            assertFalse(Validator.isValidBase("123"));
            assertFalse(Validator.isValidBase(""));
        }
    }

    @Nested
    @DisplayName("Yes/No Validation")
    class YesNoTest {
        @Test
        void testValidYesNo() {
            assertTrue(Validator.isYesNo("y"));
            assertTrue(Validator.isYesNo("n"));
            assertTrue(Validator.isYesNo("o"));
        }

        @Test
        void testInvalidYesNo() {
            assertFalse(Validator.isYesNo("yes"));
            assertFalse(Validator.isYesNo("no"));
            assertFalse(Validator.isYesNo("1"));
        }
    }

    @Nested
    @DisplayName("Substitution Key Validation")
    class SubstitutionKeyTest {
        @Test
        void testValidKey() {
            String key = "phqgiumeaylnofdxjkrcvstzwb";
            assertTrue(Validator.isValidSubstitutionKey(key));
        }

        @Test
        void testInvalidKeyWrongLength() {
            assertFalse(Validator.isValidSubstitutionKey("abc"));
        }

        @Test
        void testInvalidKeyDuplicateLetters() {
            assertFalse(Validator.isValidSubstitutionKey("aaaaaaaaaaaaaaaaaaaaaaaaaa"));
        }

        @Test
        void testInvalidKeyUppercaseLetters() {
            assertFalse(Validator.isValidSubstitutionKey("PHQGIUMEAYLNOFDXJKRCVSTZWB"));
        }
    }

    @Nested
    @DisplayName("Vigenere Key Validation")
    class VigenereKeyTest {
        @Test
        void testValidKey() {
            assertTrue(Validator.isValidVigenereKey("KEY"));
            assertTrue(Validator.isValidVigenereKey("key"));
        }

        @Test
        void testInvalidKey() {
            assertFalse(Validator.isValidVigenereKey("KEY123"));
            assertFalse(Validator.isValidVigenereKey(""));
            assertFalse(Validator.isValidVigenereKey(null));
        }
    }
}
