package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidateSaId {

    public static boolean isIdNumberValid(String id) {
        // Check length
        if (id == null || id.length() != 13) {
            return false;
        }

        // Check if all characters are digits
        if (!id.matches("\\d+")) {
            return false;
        }

        // Extract birthdate (YYMMDD)
        String yy = id.substring(0, 2);
        String mm = id.substring(2, 4);
        String dd = id.substring(4, 6);

        int year = Integer.parseInt(yy);
        year += (year <= 29) ? 2000 : 1900;

        String birthdate = String.format("%04d-%s-%s", year, mm, dd);

        try {
            LocalDate.parse(birthdate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (DateTimeParseException e) {
            return false;
        }

        return true; // More validation will follow later
    }

    public String getGreeting() {
        return "Hello from ValidateSaId!";
    }

    public static void main(String[] args) {
        System.out.println(new ValidateSaId().getGreeting());
    }
}
