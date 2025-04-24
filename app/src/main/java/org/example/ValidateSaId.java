package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidateSaId {

    public static boolean isIdNumberValid(String id) {
        // 1. Check if null or wrong length
        if (id == null || id.length() != 13) {
            return false;
        }

        // 2. Check if all characters are digits
        if (!id.matches("\\d+")) {
            return false;
        }

        // 3. Validate birthdate
        String yy = id.substring(0, 2);
        String mm = id.substring(2, 4);
        String dd = id.substring(4, 6);

        int year = Integer.parseInt(yy);
        year += (year <= 29) ? 2000 : 1900; // Assume 2000s for 00–29

        String birthdateStr = String.format("%04d-%s-%s", year, mm, dd);
        try {
            LocalDate date = LocalDate.parse(birthdateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            // Make sure day and month match original values (avoid auto-correcting invalid dates)
            if (!String.format("%02d", date.getMonthValue()).equals(mm) ||
                !String.format("%02d", date.getDayOfMonth()).equals(dd)) {
                return false;
            }

        } catch (DateTimeParseException e) {
            return false;
        }

        // 4. Validate gender digits
        String genderDigits = id.substring(6, 10);
        int genderValue = Integer.parseInt(genderDigits);
        if (genderValue < 0 || genderValue > 9999) {
            return false;
        }

        // 5. Validate citizenship digit
        char citizenship = id.charAt(10);
        if (citizenship != '0' && citizenship != '1') {
            return false;
        }

        // 6. Validate checksum using Luhn algorithm
        return isValidLuhn(id);
    }

    // Luhn checksum validation (used for Z digit)
    private static boolean isValidLuhn(String id) {
        int sum = 0;

        // Step 1: Add digits in odd positions (0-based: 0, 2, 4, ..., 10)
        for (int i = 0; i < 12; i += 2) {
            sum += Character.getNumericValue(id.charAt(i));
        }

        // Step 2: Concatenate even-position digits, multiply by 2
        StringBuilder evenDigits = new StringBuilder();
        for (int i = 1; i < 12; i += 2) {
            evenDigits.append(id.charAt(i));
        }

        int evenNumber = Integer.parseInt(evenDigits.toString()) * 2;

        // Step 3: Add digits of the result from step 2
        for (char digit : String.valueOf(evenNumber).toCharArray()) {
            sum += Character.getNumericValue(digit);
        }

        // Step 4: Calculate check digit
        int checkDigit = (10 - (sum % 10)) % 10;

        // Step 5: Compare with 13th digit (Z)
        return checkDigit == Character.getNumericValue(id.charAt(12));
    }

    public String getGreeting() {
        return "Hello from ValidateSaId!";
    }

    public static void main(String[] args) {
        System.out.println(new ValidateSaId().getGreeting());
    }
}
