package org.example;

public class ValidateSaId {

    public static boolean isIdNumberValid(String id) {
        // Check if the ID is null or not exactly 13 characters
        if (id == null || id.length() != 13) {
            return false;
        }

        // Further validations will come later (e.g., numeric-only, date, gender, etc.)
        return true;
    }

    public String getGreeting() {
        return "Hello from ValidateSaId!";
    }

    public static void main(String[] args) {
        System.out.println(new ValidateSaId().getGreeting());
    }
}
