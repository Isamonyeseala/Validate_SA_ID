package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidateSaId {

    public static boolean isIdNumberValid(String id) {
        if (id == null || id.length() != 13) {
            System.out.println("Invalid: Not 13 digits");
            return false;
        }

        if (!id.matches("\\d+")) {
            System.out.println("Invalid: Contains non-digit characters");
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
                System.out.println("Date mismatch with ID: " + birthdateStr);
                return false;
            }
        } catch (DateTimeParseException e) {
            System.out.println("Invalid birthdate: " + birthdateStr);
            return false;
        }

        // Validate gender digits (SSSS)
        String genderCode = id.substring(6, 10);
        int genderValue = Integer.parseInt(genderCode);
        if (genderValue < 0 || genderValue > 9999) {
            System.out.println("Invalid gender code: " + genderCode);
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
