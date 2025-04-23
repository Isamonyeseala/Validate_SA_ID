package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidateSaIdTest {

    @Test
    void appHasAGreeting() {
        ValidateSaId classUnderTest = new ValidateSaId();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }

    @Test
    public void testTooShortIdNumber() {
        assertFalse(ValidateSaId.isIdNumberValid("2001014")); // too short
    }

    @Test
    public void testTooLongIdNumber() {
        assertFalse(ValidateSaId.isIdNumberValid("20010148000861")); // too long
    }

    @Test
    public void testValidLengthIdNumber() {
        assertTrue(ValidateSaId.isIdNumberValid("2001014800086")); // correct length
    }

    @Test
    public void testIdWithNonNumericCharacters() {
        assertFalse(ValidateSaId.isIdNumberValid("20010A4800086")); // contains 'A'
        assertFalse(ValidateSaId.isIdNumberValid("ABCDEFGHIJKLM")); // all letters
        assertFalse(ValidateSaId.isIdNumberValid("20010148000@6")); // special char
    }
}
