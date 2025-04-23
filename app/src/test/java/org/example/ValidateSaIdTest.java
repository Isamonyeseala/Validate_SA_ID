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
        assertFalse(ValidateSaId.isIdNumberValid("2001014"));
    }

    @Test
    public void testTooLongIdNumber() {
        assertFalse(ValidateSaId.isIdNumberValid("20010148000861"));
    }

    @Test
    public void testValidLengthIdNumber() {
        assertTrue(ValidateSaId.isIdNumberValid("2001014800086"));
    }

    @Test
    public void testIdWithNonNumericCharacters() {
        assertFalse(ValidateSaId.isIdNumberValid("20010A4800086"));
        assertFalse(ValidateSaId.isIdNumberValid("ABCDEFGHIJKLM"));
        assertFalse(ValidateSaId.isIdNumberValid("20010148000@6"));
    }

    @Test
    public void testInvalidBirthdateMonthDay() {
        assertFalse(ValidateSaId.isIdNumberValid("9913324800086")); // Invalid: 33rd month
        assertFalse(ValidateSaId.isIdNumberValid("9902314800086")); // Invalid: Feb 31
        assertTrue(ValidateSaId.isIdNumberValid("9202204800086")); // Valid: Feb 20, 1992
    }
}
