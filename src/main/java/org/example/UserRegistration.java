package org.example;

// UC1: Validate First Name
public class UserRegistration {

    // Method to validate first name
    public boolean validateFirstName(String firstName) {
        String regex = "^[A-Z][a-zA-Z]{2,}$"; // Starts with uppercase and at least 3 characters
        return firstName.matches(regex);
    }

    public static void main(String[] args) {
        UserRegistration userRegistration = new UserRegistration();

        // Test the method
        System.out.println("First Name Validation:");
        System.out.println(userRegistration.validateFirstName("John")); // Should return true
        System.out.println(userRegistration.validateFirstName("jo"));   // Should return false
    }
}
