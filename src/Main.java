/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mphog
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login myLogin = new Login();

        System.out.println("--- REGISTER ---");
        System.out.print("Enter username: ");
        String user = scanner.nextLine();

        System.out.print("Enter password: ");
        String pass = scanner.nextLine();

        System.out.print("Enter cell phone (+27...): ");
        String cell = scanner.nextLine();

        // Register the user and print the message
        String message = myLogin.registerUser(user, pass, cell);
        System.out.println("\n" + message);

        System.out.println("--- LOGIN ---");
        System.out.print("Enter username: ");
        String loginUser = scanner.nextLine();

        System.out.print("Enter password: ");
        String loginPass = scanner.nextLine();

        // Check login and print status
        boolean success = myLogin.loginUser(loginUser, loginPass);
        System.out.println("\n" + myLogin.returnLoginStatus(success));

        scanner.close();
    }
}
