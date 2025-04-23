package org.example;

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

        // Valid so far, future checks (like birthdate, gender, etc.) will go here
        return true;
    }

    public String getGreeting() {
        return "Hello from ValidateSaId!";
    }

    public static void main(String[] args) {
        System.out.println(new ValidateSaId().getGreeting());
    }
}
