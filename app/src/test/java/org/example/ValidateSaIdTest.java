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
        assertFalse(ValidateSaId.isIdNumberValid("9913324800086"));
        assertFalse(ValidateSaId.isIdNumberValid("9902314800086"));
        assertTrue(ValidateSaId.isIdNumberValid("9202204800086"));
    }

    @Test
    public void testInvalidGenderDigits() {
        assertFalse(ValidateSaId.isIdNumberValid("920220A000086")); // contains letter
        assertFalse(ValidateSaId.isIdNumberValid("92022099999A6")); // too long, has letter
        assertFalse(ValidateSaId.isIdNumberValid("920220-100086")); // invalid char
    }

    @Test
    public void testGenderRange() {
        assertTrue(ValidateSaId.isIdNumberValid("9202200000086")); // Female: 0000
        assertTrue(ValidateSaId.isIdNumberValid("9202204999086")); // Female: 4999
        assertTrue(ValidateSaId.isIdNumberValid("9202205000086")); // Male: 5000
        assertTrue(ValidateSaId.isIdNumberValid("9202209999086")); // Male: 9999
    }
}
