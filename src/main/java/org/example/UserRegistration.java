package org.example;

import java.util.ArrayList;
import java.util.List;

public class UserRegistration {

    // Custom Exception
    public static class UserRegistrationException extends Exception {
        public UserRegistrationException(String message) {
            super(message);
        }
    }

    // Method to validate first name
    public boolean validateFirstName(String firstName) throws UserRegistrationException {
        String regex = "^[A-Z][a-zA-Z]{2,}$"; // Starts with uppercase and at least 3 characters
        if (!firstName.matches(regex)) {
            throw new UserRegistrationException("Invalid First Name: Must start with an uppercase letter and have at least 3 characters.");
        }
        return true;
    }

    // Method to validate last name
    public boolean validateLastName(String lastName) throws UserRegistrationException {
        String regex = "^[A-Z][a-zA-Z]{2,}$"; // Starts with uppercase and at least 3 characters
        if (!lastName.matches(regex)) {
            throw new UserRegistrationException("Invalid Last Name: Must start with an uppercase letter and have at least 3 characters.");
        }
        return true;
    }

    // Method to validate email
    public boolean validateEmail(String email) throws UserRegistrationException {
        String regex = "^[a-zA-Z0-9]+([._+-]?[a-zA-Z0-9]+)*@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})?$";
        if (!email.matches(regex)) {
            throw new UserRegistrationException("Invalid Email: Does not follow a valid email format.");
        }
        return true;
    }

    // Method to validate mobile number
    public boolean validateMobileNumber(String mobileNumber) throws UserRegistrationException {
        String regex = "^[0-9]{1,3} [0-9]{10}$"; // Country code followed by space and 10-digit number
        if (!mobileNumber.matches(regex)) {
            throw new UserRegistrationException("Invalid Mobile Number: Must contain a country code followed by a 10-digit number.");
        }
        return true;
    }

    // Method to validate password
    public boolean validatePassword(String password) throws UserRegistrationException {
        String rule1 = ".{8,}"; // Minimum 8 characters
        String rule2 = "(?=.*[A-Z]).*"; // At least one uppercase letter
        String rule3 = "(?=.*[0-9]).*"; // At least one numeric number
        String rule4 = "(?=.*[@#$%^&+=!]).*"; // At least one special character

        if (!password.matches(rule1) ||
                !password.matches(rule2) ||
                !password.matches(rule3) ||
                !password.matches(rule4)) {
            throw new UserRegistrationException("Invalid Password: Must be at least 8 characters long, contain one uppercase letter, one numeric digit, and one special character.");
        }
        return true;
    }

    // Method to validate a list of emails
    public List<Boolean> validateEmailSamples(List<String> emails) {
        List<Boolean> results = new ArrayList<>();
        for (String email : emails) {
            try {
                results.add(validateEmail(email));
            } catch (UserRegistrationException e) {
                results.add(false);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        UserRegistration userRegistration = new UserRegistration();

        try {
            System.out.println("First Name Validation:");
            System.out.println(userRegistration.validateFirstName("John")); // Should return true
            System.out.println(userRegistration.validateFirstName("jo"));   // Should throw exception
        } catch (UserRegistrationException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Last Name Validation:");
            System.out.println(userRegistration.validateLastName("Doe"));  // Should return true
            System.out.println(userRegistration.validateLastName("do"));   // Should throw exception
        } catch (UserRegistrationException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Email Validation:");
            System.out.println(userRegistration.validateEmail("abc.xyz@bl.co.in")); // Should return true
            System.out.println(userRegistration.validateEmail("abc@.com.my"));     // Should throw exception
        } catch (UserRegistrationException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Mobile Number Validation:");
            System.out.println(userRegistration.validateMobileNumber("91 9919819801")); // Should return true
            System.out.println(userRegistration.validateMobileNumber("919919819801"));  // Should throw exception
        } catch (UserRegistrationException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Password Validation:");
            System.out.println(userRegistration.validatePassword("Abc@1234")); // Should return true
            System.out.println(userRegistration.validatePassword("abc1234")); // Should throw exception
        } catch (UserRegistrationException e) {
            System.out.println(e.getMessage());
        }

        List<String> emailSamples = List.of(
                // Valid Emails
                "abc@yahoo.com",
                "abc-100@yahoo.com",
                "abc.100@yahoo.com",
                "abc111@abc.com",
                "abc-100@abc.net",
                "abc.100@abc.com.au",
                "abc@1.com",
                "abc@gmail.com.com",
                "abc+100@gmail.com",

                // Invalid Emails
                "abc",
                "abc@.com.my",
                "abc123@gmail.a",
                "abc123@.com",
                "abc123@.com.com",
                ".abc@abc.com",
                "abc()*@gmail.com",
                "abc@%*.com",
                "abc..2002@gmail.com",
                "abc.@gmail.com",
                "abc@abc@gmail.com",
                "abc@gmail.com.1a",
                "abc@gmail.com.aa.au"
        );

        System.out.println("Email Samples Validation:");
        System.out.println(userRegistration.validateEmailSamples(emailSamples));
    }
}