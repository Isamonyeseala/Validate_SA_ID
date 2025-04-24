package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidateSaId {

    public static boolean isIdNumberValid(String id) {
        if (id == null || id.length() != 13) {
            return false;
        }

        if (!id.matches("\\d+")) {
            return false;
        }

        // Validate birthdate
        String yy = id.substring(0, 2);
        String mm = id.substring(2, 4);
        String dd = id.substring(4, 6);

        int year = Integer.parseInt(yy);
        year += (year <= 29) ? 2000 : 1900;

        String birthdateStr = String.format("%04d-%s-%s", year, mm, dd);
        try {
            LocalDate date = LocalDate.parse(birthdateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            if (!String.format("%02d", date.getDayOfMonth()).equals(dd) ||
                !String.format("%02d", date.getMonthValue()).equals(mm)) {
                return false;
            }
        } catch (DateTimeParseException e) {
            return false;
        }

        // Validate gender digits
        int genderValue = Integer.parseInt(id.substring(6, 10));
        if (genderValue < 0 || genderValue > 9999) {
            return false;
        }

        // Validate citizenship digit (0 or 1)
        char citizenship = id.charAt(10);
        if (citizenship != '0' && citizenship != '1') {
            return false;
        }

        return true;
    }

    public String getGreeting() {
        return "Hello from ValidateSaId!";
    }

    public static void main(String[] args) {
        System.out.println(new ValidateSaId().getGreeting());
    }
}
