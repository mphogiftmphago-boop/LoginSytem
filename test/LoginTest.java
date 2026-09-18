/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class LoginTest {

    Login testLogin = new Login();

    // --- USERNAME TESTS ---
    @Test
    public void testUsernameCorrect() {
        assertTrue(testLogin.checkUserName("kyl_1"));
    }

    @Test
    public void testUsernameIncorrect() {
        assertFalse(testLogin.checkUserName("kyle!!!!!!!"));
    }

    // --- PASSWORD TESTS ---
    @Test
    public void testPasswordCorrect() {
        assertTrue(testLogin.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testPasswordIncorrect() {
        assertFalse(testLogin.checkPasswordComplexity("password"));
    }

    // --- CELL PHONE TESTS ---
    @Test
    public void testCellPhoneCorrect() {
        assertTrue(testLogin.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testCellPhoneIncorrect() {
        assertFalse(testLogin.checkCellPhoneNumber("08966553"));
    }

    // --- LOGIN TESTS ---
    @Test
    public void testLoginSuccessful() {
        // Register first so there is data to login with
        testLogin.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(testLogin.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginFailed() {
        // Register first so there is data to login with
        testLogin.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertFalse(testLogin.loginUser("kyl_1", "wrongPassword"));
    }
}
