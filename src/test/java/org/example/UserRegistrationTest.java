package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {

    // Create an instance of UserRegistration class
    UserRegistration userRegistration = new UserRegistration();

    // Parameterized test for email validation
    @ParameterizedTest
    @ValueSource(strings = {
            "abc@yahoo.com",         // Valid email
            "abc-100@yahoo.com",     // Valid email
            "abc.100@yahoo.com",     // Valid email
            "abc111@abc.com",        // Valid email
            "abc-100@abc.net",       // Valid email
            "abc.100@abc.com.au",    // Valid email
            "abc@1.com",             // Valid email
            "abc@gmail.com.com",     // Valid email
            "abc+100@gmail.com",     // Valid email
            "abc",                   // Invalid email - Missing '@' symbol
            "abc@.com.my",           // Invalid email - TLD starts with a dot
            "abc123@gmail.a",        // Invalid email - TLD must have at least two characters
            "abc123@.com",           // Invalid email - TLD starts with a dot
            "abc123@.com.com",       // Invalid email - TLD starts with a dot
            ".abc@abc.com",          // Invalid email - First character is a dot
            "abc()*@gmail.com",      // Invalid email - Contains invalid characters
            "abc@%*.com",            // Invalid email - TLD contains invalid characters
            "abc..2002@gmail.com",   // Invalid email - Contains double dots
            "abc.@gmail.com",        // Invalid email - Ends with a dot
            "abc@abc@gmail.com",     // Invalid email - Multiple '@' symbols
            "abc@gmail.com.1a",      // Invalid email - TLD with two characters contains a digit
            "abc@gmail.com.aa.au"    // Invalid email - Multiple TLDs are not allowed
    })
    void testEmailValidation(String email) {
        // Validate the email using the UserRegistration's validateEmail method
        boolean isValid = userRegistration.validateEmail(email);

        // Use assertion to verify the expected outcome
        if (email.matches("^(abc@yahoo.com|abc-100@yahoo.com|abc.100@yahoo.com|abc111@abc.com|abc-100@abc.net|abc.100@abc.com.au|abc@1.com|abc@gmail.com.com|abc+100@gmail.com)$")) {
            Assertions.assertTrue(isValid, email + " should be valid");
        } else {
            Assertions.assertFalse(isValid, email + " should be invalid");
        }
    }
    @Test
    void testFirstNameValidation() {
        // Happy Test Case
        assertTrue(userRegistration.validateFirstName("John"));
        // Sad Test Case
        assertFalse(userRegistration.validateFirstName("jo"));
    }

    @Test
    void testLastNameValidation() {
        // Happy Test Case
        assertTrue(userRegistration.validateLastName("Doe"));
        // Sad Test Case
        assertFalse(userRegistration.validateLastName("do"));
    }

    @Test
    void testEmailValidation() {
        // Happy Test Case
        assertTrue(userRegistration.validateEmail("abc.xyz@bl.co.in"));
        // Sad Test Case
        assertFalse(userRegistration.validateEmail("abc@.com.my"));
    }

    @Test
    void testMobileNumberValidation() {
        // Happy Test Case
        assertTrue(userRegistration.validateMobileNumber("91 9919819801"));
        // Sad Test Case
        assertFalse(userRegistration.validateMobileNumber("919919819801"));
    }

    @Test
    void testPasswordValidation() {
        // Happy Test Case
        assertTrue(userRegistration.validatePassword("Abc@1234"));
        // Sad Test Case
        assertFalse(userRegistration.validatePassword("abc1234"));
    }
}
