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
// Method to register the user and give back the correct message

    public String registerUser(String username, String password, String cellPhone) {
        String outputMessage = "";

        // Check username
        if (checkUserName(username) == false) {
            outputMessage = outputMessage + "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.\n";
        } else {
            outputMessage = outputMessage + "Username successfully captured.\n";
        }

        // Check password
        if (checkPasswordComplexity(password) == false) {
            outputMessage = outputMessage + "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.\n";
        } else {
            outputMessage = outputMessage + "Password successfully captured.\n";
        }

        // Check cell phone
        if (checkCellPhoneNumber(cellPhone) == false) {
            outputMessage = outputMessage + "Cell phone number incorrectly formatted or does not contain international code.\n";
        } else {
            outputMessage = outputMessage + "Cell phone number successfully added.\n";
        }

        // If EVERYTHING is perfect, save the details so they can log in later
        if (checkUserName(username) == true && checkPasswordComplexity(password) == true && checkCellPhoneNumber(cellPhone) == true) {
            savedUsername = username;
            savedPassword = password;
            savedCellPhone = cellPhone;
        }

        return outputMessage;
    }
