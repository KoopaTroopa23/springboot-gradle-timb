package com.example.learning;

import java.util.ArrayList;
import java.util.List;

public class Section17 {

    public static void main(String[] args) {

        // 🟡 BASIC ARITHMETIC AND VARIABLES

        // Declare and calculate using expressions:
        // (10 + 11) = 21, (2 * 10) = 20 → 21 + 20 = 41
        int myFirstNumber = (10 + 11) + (2 * 10);

        int mySecondNumber = 12;
        int myThirdNumber = 6;

        // Add all three numbers
        int myTotal = myFirstNumber + mySecondNumber + myThirdNumber;

        // Subtract from 1000 to get the final result
        int myLastOne = 1000 - myTotal;

        System.out.println("Final result after subtraction: " + myLastOne);

        // 🟡 PRIMITIVE DATA TYPES

        // These are the most common data types in Java:
        // Whole numbers:
        byte myByte = 100;           // 1 byte  → -128 to 127
        short myShort = 30000;       // 2 bytes → -32,768 to 32,767
        int myInt = 1_000_000;       // 4 bytes → commonly used
        long myLong = 100L;          // 8 bytes → add 'L' to indicate long

        // Decimal numbers:
        float myFloat = 5.25f;       // 4 bytes → needs 'f' at the end
        double myDouble = 5.25;      // 8 bytes → default for decimals

        // Other types:
        char myChar = 'A';           // single characters
        boolean myBoolean = true;    // true or false

        // 🟡 WRAPPER CLASSES - 
        // Java collections (like ArrayList, HashMap) can’t store primitives or null  - List, Set or Map
        // You must use wrapper classes like Integer, Double, etc.

        List<Integer> bigNumber = new ArrayList<>();       //   developers use this rather than int bigNumber = [1. 2, 3, 4] 
        bigNumber.add(8);
        bigNumber.add(9);
        bigNumber.add(null);
        bigNumber.add(11);
        System.out.println(bigNumber);
        
        // Every primitive type has a corresponding wrapper class:
        // int → Integer, byte → Byte, short → Short, etc.
        // These are used when you need objects instead of primitives (e.g. in collections)

        // 🟡 INTEGER LITERALS WITH UNDERSCORES (readability)
        int myMaxIntTest = 2_123_234_232; // Same as 2123234232
        System.out.println("Max int test value: " + myMaxIntTest);

        // 🟡 COMBINING VARIABLES
        System.out.println("Combined values: " + myMaxIntTest + " and " + myLastOne);

        // 🟡 TYPE CASTING

        // Java does math in int by default, even for byte or short variables.
        // So we need to manually cast the result back to a smaller type.
        byte myMinByteValue = -128;
        short myNewByteValue = (short) (myMinByteValue / 2); // Must cast back to short

        System.out.println("Casted short value: " + myNewByteValue);
    }
}
