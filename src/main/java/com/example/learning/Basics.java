// This line declares that the class is part of the "section15" package.
// Packages help organize your code and prevent naming conflicts.
package com.example.learning;

// This defines a public class named "Basics".
// In Java, every application must have at least one class definition.
public class Basics {

    // The main method is the entry point of any standalone Java application.
    // Java starts running your program from here.
    public static void main(String[] args) {

        // This line prints a string message to the console.
        // "System.out.println" is a built-in method to output text.
        // "This is Java" is a string literal (a fixed sequence of characters inside double quotes).
        System.out.println("This is Java");

        // A keyword is a reserved word in Java that has a special meaning.
        // Examples include: int, class, public, static, void, etc.
        // You cannot use keywords as variable names.

        // A data type defines the kind of data a variable can hold.
        // "int" is a data type for whole numbers (integers).
        // "myFirstNumber" is a variable name (you choose it).
        int myFirstNumber = 5;  // This declares an integer variable and assigns it the value 5

        // This prints the value stored in the variable "myFirstNumber"
        System.out.println(myFirstNumber);

        // Here we declare another integer variable.
        // It adds 5 to the value of "myFirstNumber" and stores the result in "mySecondNumber".
        int mySecondNumber = myFirstNumber + 5;

        // This prints the value of "mySecondNumber" (which is 10)
        System.out.println(mySecondNumber);

        // An expression is any valid combination of variables, values, and operators
        // that evaluates (calculates) to a single result.
        // Example: myFirstNumber + 5 is an expression, and its result is 10.

        int myThirdNumber = (10 + 5) + (10 * 5);
        System.out.println(myThirdNumber);

        int myFourthNumber = (10 + 20) + (20 - 5);
        System.out.println(myFourthNumber);
        
        
      
    }
}
