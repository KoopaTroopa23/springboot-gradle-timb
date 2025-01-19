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

        // Expression is the code segment that is on the right of the equals sign in an assignment or declartion statement
        
        
        
        // Declaration: Declares a variable named 'myFirstNumber' with the data type 'int'
        // Statement: The full line below is a statement that ends with a semicolon
        int myFirstNumber = 5; // 'int' is the data type, '=' is the assignment operator, '5' is the value assigned to the variable
       
        // Reassign a new value to the variable
        myFirstNumber = 10; // The variable's value is now updated to 10.


        // Add 5 to the current value of the variable and reassign it
        myFirstNumber = 10 + 5; // The variable's value is now 15 (10 + 5).

        // Perform a more complex calculation and reassign the result to the variable
//        myFirstNumber = (10 + 5) + (2 + 10); // The variable's value is now 27. (15 + 12).
        // variable  operator  literal value   operator  literal value               total is 27 which is Value
        //					=	expression
        
        // Print the variable's value to the console
        System.out.println(myFirstNumber); // This prints the value stored in 'myFirstNumber'
        
     // Declare and initialize the second variable
        int mySecondNumber = 12; // 'mySecondNumber' is assigned the literal value 12.

        // Declare and initialize the third variable
        int myThirdNumber = 6; // 'myThirdNumber' is assigned the literal value 6.

        // Print the value of mySecondNumber to the console
        System.out.println(mySecondNumber); // Outputs: 12

        // Print the value of myThirdNumber to the console
        System.out.println(myThirdNumber); // Outputs: 6

        // Calculate the total of myFirstNumber, mySecondNumber, and myThirdNumber
        int myTotal = myFirstNumber + mySecondNumber + myThirdNumber; 
        // 'myTotal' now holds the sum of these variables: (myFirstNumber + 12 + 6)

        // Print the value of myTotal to the console
        System.out.println(myTotal); // Outputs the sum of all three variables.

        // Calculate the difference between 1000 and myTotal
        int myLastOne = 1000 - (myTotal); 
        // 'myLastOne' holds the result of subtracting 'myTotal' from 1000.

        // Print the value of myLastOne to the console
        System.out.println(myLastOne); // Outputs the result of (1000 - myTotal).

        
    }
    
    
    
    
    
    
    
    
    
    
}