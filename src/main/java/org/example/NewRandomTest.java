package org.example;

import java.util.Scanner;

import java.util.InputMismatchException;
/*
Name: Anh-Thien Nguyen

Student ID: 202660307

Date: 1/12/24

This program is developed in java that is interactive, enabling input to explore different methods for generating random numbers and characters.
The application gives options for generating random integers within specified ranges, lowercase characters randomly, characters within user-defined ranges,
characters based on a starting character and an integer, and random special characters excluding letters and digits.

The program begins by presenting a menu with numbered options (1 to 5) corresponding to different random generation methods. Entering '0' exits the program.

Case 1 (nextInt(int low, int high)) prompts the user to input a low and high range, then generates and prints 30 random integers within that range.
Case 2 (nextChar()) generates and prints 30 random lowercase characters from 'a' to 'z'.
Case 3 (nextChar(char from, char to)) asks the user to input two characters defining a range and generates 30 random characters within that range.
Case 4 (nextChar(char from, int i)) requires a starting character and a positive integer as input. It then generates and prints 30 random characters based on the provided starting character and integer.
Case 5 (nextSpecialChar()) generates and prints 30 random special characters (non-alphanumeric) by excluding letters and digits. The program uses a do-while loop to ensure that special characters generated in option 5 are not letters or digits.

Exception handling is implemented to catch invalid inputs (non-numeric inputs for choices and non-integer inputs for numeric options).

The code is well-indented, following Java conventions, which makes it easy to read and understand the program's structure. The indentation enhances code efficiency.
*/

public class NewRandomTest { 
    static String[] methods = {"nextInt(int low, int high)", "nextChar()", "nextChar(char from, char to)", "nextChar(char from, int range)", "nextSpecialChar()"}; //create array methods
    static String[] errorMsgs = {"Invalid choice. Please enter a number between 0 and 5.", "Invalid input. Please enter a valid integer."}; // create array for error messages
    static int howManyTests = 30; // create integer for 30 tests
    static NewRandom newRandom = new NewRandom(); // create NewRandom object
    static Scanner input = new Scanner(System.in); // create scanner object called input

    public static void main(String[] args) {
        boolean run = true; // created boolean field to end run when choice == 0
        while (run) {
            showMenu();
            int choice = getChoice();
            if (choice >= 0 && choice < methods.length) {
                testMethod(choice);
            } else if (choice == methods.length) {
                run = false;
                System.out.println("Goodbye!");
            } else {
                System.out.println(errorMsgs[0]);
            }
        }
    }

    private static void showMenu() {
        System.out.println("\nWhich method would you like to test?");
        for (int i = 0; i < methods.length; i++) {
            System.out.println(i + ". " + methods[i]);
        }
        System.out.println(methods.length + ". Quit");
    }

    private static int getChoice() {
        while (true) { // Keep asking for input until a valid integer is entered
            try {
                int choice = input.nextInt(); // Tries to read an integer input
                input.nextLine(); // Clears the input buffer
                return choice; // Returns the valid integer
            } catch (InputMismatchException e) {
                input.nextLine(); // Clears the invalid input from the scanner
                System.out.println(errorMsgs[1]); // Prints the error message for invalid input
                // No need to return -1 here, as the loop will continue asking for input
            }
        }
    }



    private static void testMethod(int index) {
        if (index == 0) {
            testNextInt(); // apply method testNextInt
        } else if (index == 1) {
            testNextChar();  // apply method testNextChar
        } else if (index == 2) {
            testNextCharRange();  // apply method testNextCharRange
        } else if (index == 3) {
            testNextCharWithRange(); // apply method testNextWithRange
        } else if (index == 4) {
            testNextSpecialChar(); // apply method testNextSpecialChar
        }
    }

    private static void testNextInt() {
        System.out.println("input a int from:");
        int low = input.nextInt(); // answer becomes int low
        System.out.println("input a in to:");
        int high = input.nextInt(); // answer becomes int high
        System.out.println("\nResult of nextInt(" + low + ", " + high + "):");
        for (int i = 0; i < howManyTests; i++) { // for 30 times, print random from int low to int high
            System.out.print(newRandom.nextInt(low, high) + " ");
        }
        System.out.println();
    }

    private static void testNextChar() {
        System.out.println("\nResult of nextChar():");
        for (int i = 0; i < howManyTests; i++) { // for 30 times, print random char
            System.out.print(newRandom.nextChar() + " ");
        }
        System.out.println();
    }

    private static void testNextCharRange() {
        System.out.println("input a char from:");
        char start = input.next().charAt(0); // answer becomes char start
        System.out.println("input a char to:");
        char end = input.next().charAt(0); // answer becomes char end
        System.out.println("\nResult of nextChar(" + start + ", " + end + "):");
        for (int i = 0; i < howManyTests; i++) { // for 30 times, print random from char start to char end
            System.out.print(newRandom.nextChar(start, end) + " ");
        }
        System.out.println();
    }

    private static void testNextCharWithRange() {
        System.out.println("input a char from:");
        char start = input.next().charAt(0); // answer becomes char start
        System.out.println("input an integer:");
        int range = input.nextInt(); // answer becomes the range
        System.out.println("\nResult of nextChar(" + start + ", " + range + "):");
        for (int i = 0; i < howManyTests; i++) {
            System.out.print(newRandom.nextChar(start, range) + " ");
        }
        System.out.println();
    }

    private static void testNextSpecialChar() {
        System.out.println("\nResult of nextSpecialChar():");
        for (int i = 0; i < howManyTests; i++) { // for 30 times, prints random special char
            System.out.print(newRandom.nextSpecialChar() + " ");
        }
        System.out.println();
    }
}
