package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {

    UserRegistration userRegistration = new UserRegistration();

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
