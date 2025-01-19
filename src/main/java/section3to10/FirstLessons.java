// Package declaration: This specifies the package in which the class resides. 
// Packages help organize your code and avoid class name conflicts.
package section3to10;

/**
 * Project Name: First Lessons
 * Description: A simple Java program to demonstrate the basics of the main method,
 *              variables, and printing output to the console.
 */

// Class definition: This is the class named "FirstLessons". It contains the main method.
public class FirstLessons {

    /**
     * The main method: This is the entry point of the Java program.
     * @param args Command-line arguments passed to the program (not used in this example).
     */
    public static void main(String[] args) {
        
        // Prints "Hello World" to the console
        System.out.println("Hello World");
        
        // Variables and Keywords
        // A variable is used to store information in memory for use during program execution.

        // Primitive Data Type: A data type that directly stores values in memory (e.g., int, double, char, etc.).
        // Syntax: <data_type> <variable_name> = <value>;

        // Declaration: Declares a variable named 'myFirstNumber' with the data type 'int'
        // Statement: The full line below is a statement that ends with a semicolon
        int myFirstNumber = 5; // 'int' is the data type, '=' is the assignment operator, '5' is the value assigned to the variable
        
        // Print the variable's value to the console
        System.out.println(myFirstNumber); // This prints the value stored in 'myFirstNumber'
    }
}