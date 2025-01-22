// Package declaration: This specifies the package in which the class resides. 
// Packages help organize your code and avoid class name conflicts.
package section3to10;

// Import statement: Includes the ArrayList class for potential use.
import java.util.ArrayList;

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
        
        // Prints "Hello World" to the console.
        // This is often the first program a beginner writes to ensure the setup works correctly.
        System.out.println("Hello World");
        
        // Variables and Keywords
        // A variable is used to store information in memory for use during program execution.

        // Primitive Data Type: A data type that directly stores values in memory (e.g., int, double, char, etc.).
        // Syntax: <data_type> <variable_name> = <value>;

        // Expression: The code segment that is on the right of the equals sign in an assignment or declaration statement.
        
        // Declaration: Declares a variable named 'myFirstNumber' with the data type 'int'
        // Statement: The full line below is a statement that ends with a semicolon.
        int myFirstNumber = 5; // 'int' is the data type, '=' is the assignment operator, '5' is the value assigned to the variable.
       
        // Reassign a new value to the variable.
        myFirstNumber = 10; // The variable's value is now updated to 10.

        // Add 5 to the current value of the variable and reassign it.
        myFirstNumber = 10 + 5; // The variable's value is now 15 (10 + 5).

        // Perform a more complex calculation and reassign the result to the variable.
        myFirstNumber = (10 + 5) + (2 + 10); // The variable's value is now 27. (15 + 12).
        // variable  operator  literal value   operator  literal value               total is 27 which is Value
        //          =   expression
        
        // Print the variable's value to the console.
        System.out.println(myFirstNumber); // This prints the value stored in 'myFirstNumber'.
        
        // Declare and initialize the second variable.
        int mySecondNumber = 12; // 'mySecondNumber' is assigned the literal value 12.

        // Declare and initialize the third variable.
        int myThirdNumber = 6; // 'myThirdNumber' is assigned the literal value 6.

        // Print the value of mySecondNumber to the console.
        System.out.println(mySecondNumber); // Outputs: 12.

        // Print the value of myThirdNumber to the console.
        System.out.println(myThirdNumber); // Outputs: 6.

        // Calculate the total of myFirstNumber, mySecondNumber, and myThirdNumber.
        int myTotal = myFirstNumber + mySecondNumber + myThirdNumber; 
        // 'myTotal' now holds the sum of these variables: (myFirstNumber + 12 + 6).

        // Print the value of myTotal to the console.
        System.out.println(myTotal); // Outputs the sum of all three variables.

        // Calculate the difference between 1000 and myTotal.
        int myLastOne = 1000 - (myTotal); 
        // 'myLastOne' holds the result of subtracting 'myTotal' from 1000.

        // Print the value of myLastOne to the console.
        System.out.println(myLastOne); // Outputs the result of (1000 - myTotal).

        // Data types - byte, short, int, long, float, double, boolean, char.
        // Class - A blueprint or template for creating objects. It defines the properties (data) and behaviors (actions) that an object can have.
        // An object is an instance of a class (like a real-world thing created using the blueprint).
        // Wrapper Class - A special class in Java that lets you turn a simple value (like a number or true/false value) into an object.
        
        // Declare a large integer with underscores for readability.
        int num = 5_24_25; // Underscores help make large numbers easier to read.
        Integer wrappedNum = Integer.valueOf(num); // Wrapper Class object. Capital I in Integer.
        System.out.println(wrappedNum); // Prints the wrapped value.

        // Demonstrating overflow and underflow: When values exceed the range of the data type.
        long myLongValue = 100L; // Use capital L so it is not mistaken for 1001.
        System.out.println(myLongValue); // Outputs: 100.
        
        // Declaring multiple variables in one line.
        short firstShort = 1; int firstInteger = 2; // Two separate declarations written on the same line.
        System.out.println(firstShort + firstInteger); // Outputs: 3.
        
        // Casting - Changing one type of data into another.
        
        // Declare and initialize a variable for the minimum byte value.
        int myMinByteValue = 1234; // Changed to 'int' because 12341233 is too large for a byte.

        // Perform casting when assigning to a byte.
        byte myNewByteValue = (byte) (myMinByteValue / 2); 
        // Cast to 'byte' because 'myMinByteValue / 2' produces an 'int' by default. 
        // Casting forces it into the 'byte' range (-128 to 127). This may cause overflow or data loss.

        short myNewShortValue = 1000; // Declare and initialize 'myNewShortValue'.
        myNewShortValue = (short) (myNewShortValue / 2); 
        // Cast to 'short' because the division produces an 'int' by default.

        // Print the sum of two casted values.
        System.out.println(myNewByteValue + myNewShortValue); // Outputs the sum.

        // Demonstrating calculations with mixed types.
        byte byteNumber = 50;
        short shortNumber = 60;
        int intNumber = 3422;
        long longNumber = 23;

        // Total sum. Smaller types are automatically promoted to long.
        long totalSum = byteNumber + shortNumber + intNumber + longNumber;
        System.out.println(totalSum + 50_000 * 2); // Outputs the total sum + additional calculations.

        // Floats - Used for precision in calculations.
        float myFloatValue = 5.75f; // 'f' indicates a float literal.
        System.out.println(myFloatValue); // Outputs: 5.75.

        double myDoubleValue = 5.75; // Double is more precise than float.
        System.out.println(myDoubleValue); // Outputs: 5.75.

        // Comparing precision of float and double.
        float floatDivision = 5f / 3f; // Division using float values.
        double doubleDivision = 5.0 / 3.0; // Division using double values.

        // Print results of the division.
        System.out.println(floatDivision); // Outputs less precise result.
        System.out.println(doubleDivision); // Outputs more precise result.

        // float - is less precise  - simple calculations
        // Key takeaway: Use double for better precision in most calculations. - Both are used for decimals
        
        myFloatValue = 5f;
        myDoubleValue = 6d;
        
        
        Float myOtherFloatValue = (float) 5.25f;
        System.out.println(myOtherFloatValue);
        
        // INT AND DOUBLE are the Most common used
        
  // Char and boolean Primitive Data Types
        
        char myChar = 'D';         //  Holds on 1 character and must be single quote  -  String holds many  
        							// store key presses , loop alphabet
        System.out.println(myChar);
        
        // Unicode    - symbol.cc/en/unicode-table  - 3 ways to store a char value:  D, \u0044 and 68
        
        char myUnicode = '\u0044';
        
        System.out.println(myUnicode);
        
        char myIntchar = 68;
        
        System.out.println(myIntchar);
        
   // Boolean Data Types  - All 8 of Java Primitive Data Type byte, short, long, int, double, float, char, boolean
        
        
         boolean myTrueBooleanValue = true;
         
         boolean myFalseBooleanValue = false;
         
         System.out.println(myTrueBooleanValue + " " + myFalseBooleanValue);

        
    // MOST USED PRIMITIVE DATA TYPE:    INT, DOUBLE and BOOLEAN
    // Classes in Class are custom data types.    
        
    // String is a class that contains a seq of char
        
        String myString = "This is a string";
        
        String mySecondString = "I wish i had \u00241,000,000.00";
        
        System.out.println("mystring is equal to " + " myString " + " mySecondString ");
        
        int myInt = 50;
        String lastString = "10";
        System.out.println(lastString + myInt);
        
        double doubleNumber = 120.47; lastString = lastString + doubleNumber;
        System.out.println(doubleNumber + lastString);
        
     // Strings are immuntable - cannot be changed   but StringBuilder class is mutable meaning it can be changed
     /// Both are classes    
        
  // Operators - perform specific operations in one, two or, three operands
        
        // Operand = any object manipulated by operator
        
    // Expression - Combining variable, literals, method return values and operators
        
        
        int result = 1 + 2;  // 1 + 2 = 3
 // p data type  variable  assignment operator   operand   operator   operand
        
        int previousResult = result; 
        
        result = result -1; // 3 - 1 = 2
        
        System.out.println("previousResult = " + previousResult);
        
        
        char firstChar = 'A'; char secondChar = 'B';
        System.out.println(firstChar + secondChar);
       System.out.println("" + firstChar + secondChar);
        		//     empty string ""
        
       result = result * 10;    // 2 * 10 = 20
       result = result / 4;  	// 20 / 4 = 5
       
       // REMAINDER OPERATOR = remainder or modulos   %
       
       result = result % 3;  // the remainder of (5 % 3) = 2
       
       
       System.out.println(result);
       
       //  {}
       
       int resulta = 1;
       resulta = resulta + 1;
       System.out.println("result = " + result);
       
       // Different way to add or increment
       //  Post fix icrement Operator  result++;
       // Compound Assignment Operator   result+=1;
       
       
       int resultb = 1;
       resultb++;    // Increment Operator
       System.out.println("result = " + resultb);
       
       int resultc = 1;
       int resultd = 1;
       int resulte = 1;
       
       resultc--;  // Decrement Operator
       
       resultd -= 1; // Compound Operator
       
       resulte += 1; // Compound Operator
       
       System.out.println("resultc = " + resultc + " resultd = " + resultd + " resulte = " + resulte);
       
       
       // Test
       int resultf = 10;
       resultf-=2;
       System.out.println("resultf = " + resultf);
       
       int resultg = 10;
       resultg -= 5.5;
       System.out.println("resultg = " + resultg);
       
       double resulth = 10;
       resulth -= 5.5;
       System.out.println("resulth = " + resulth);
       
       double resulti = 10;
       resulti *= 5.5;
       System.out.println("resulti = " + resulti);
       
       double resultj = 10;
       resultj /= 5.5;
       System.out.println("resultj = " + resultj);
       
       
    }
}
