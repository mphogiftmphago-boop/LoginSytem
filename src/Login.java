/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mphog
 */
/**
 * Reference for the cell phone regex:
 * I used W3Schools to learn how to check patterns in Java.
 * Link: https://www.w3schools.com/java/java_regex.asp
 */
public class Login {

    // Variables to save the user's details when they register
    String savedUsername = "";
    String savedPassword = "";
    String savedCellPhone = "";

    // Method to check the username
    public boolean checkUserName(String username) {
        // Must contain an underscore "_" AND be 5 characters or less
        if (username.contains("_") && username.length() <= 5) {
            return true;
        } else {
            return false;
        }
    }

    // Method to check the password
    public boolean checkPasswordComplexity(String password) {
        // Must be at least 8 characters long
        if (password.length() < 8) {
            return false;
        }

        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        // Loop through every letter of the password
        for (int i = 0; i < password.length(); i++) {
            char letter = password.charAt(i);

            if (Character.isUpperCase(letter)) {
                hasCapital = true;
            } else if (Character.isDigit(letter)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(letter)) {
                hasSpecial = true;
            }
        }

        // Only return true if it has ALL THREE
        if (hasCapital == true && hasNumber == true && hasSpecial == true) {
            return true;
        } else {
            return false;
        }
    }

    // Method to check the cell phone number
    public boolean checkCellPhoneNumber(String cellPhone) {
        // This regex means: Start with +27, followed by exactly 9 numbers (0-9)
        String correctFormat = "^\\+27[0-9]{9}$";

        if (cellPhone.matches(correctFormat)) {
            return true;
        } else {
            return false;
        }
    }

