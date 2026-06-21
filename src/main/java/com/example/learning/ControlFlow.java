package com.example.learning;

/**
 * Project Name: Control Flow
 * Description: Covers decision-making (if/else, switch) and repetition (for, while, do-while)
 *              -- the two things that let a program do more than run top-to-bottom once.
 */
public class ControlFlow {

    public static void main(String[] args) {

        // ===================== IF / ELSE =====================
        // An "if" statement only runs its block when the condition inside () is true.
        int age = 20;

        if (age >= 18) {
            System.out.println("You are an adult.");
        } else {
            System.out.println("You are a minor.");
        }

        // "else if" lets you chain multiple conditions. They are checked top to bottom,
        // and only the FIRST true branch runs.
        int score = 75;

        if (score >= 90) {
            System.out.println("Grade: A");
        } else if (score >= 80) {
            System.out.println("Grade: B");
        } else if (score >= 70) {
            System.out.println("Grade: C");
        } else {
            System.out.println("Grade: F");
        }

        // Comparison operators used in conditions: == != > < >= <=
        // Logical operators combine conditions: && (and), || (or), ! (not)
        boolean hasLicense = true;
        int yearsDriving = 2;

        if (hasLicense && yearsDriving >= 1) {
            System.out.println("Allowed to drive alone.");
        }

        if (age < 16 || !hasLicense) {
            System.out.println("Not allowed to drive.");
        } else {
            System.out.println("Driving rules passed.");
        }

        // Ternary operator: a compact one-line if/else that returns a value.
        // Syntax: condition ? valueIfTrue : valueIfFalse
        String status = (age >= 18) ? "Adult" : "Minor";
        System.out.println("Status: " + status);

        // ===================== SWITCH =====================
        // "switch" picks one branch based on a single value -- cleaner than many else-ifs
        // when you're comparing the same variable against several exact values.
        int dayNumber = 3;
        String dayName;

        switch (dayNumber) {
            case 1:
                dayName = "Monday";
                break; // "break" stops it from falling into the next case.
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            default: // runs if none of the cases match.
                dayName = "Unknown";
                break;
        }
        System.out.println("Day: " + dayName);

        // Newer "arrow" switch (Java 14+) -- no break needed, no fall-through.
        String dayNameArrow = switch (dayNumber) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            default -> "Unknown";
        };
        System.out.println("Day (arrow style): " + dayNameArrow);

        // ===================== FOR LOOP =====================
        // Best when you know how many times you want to repeat something.
        // Syntax: for (initialization; condition; update)
        for (int i = 1; i <= 5; i++) {
            System.out.println("For loop count: " + i);
        }

        // Looping over an array with a regular for loop (using the index).
        int[] numbers = { 10, 20, 30, 40 };
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }

        // "for-each" loop -- simpler when you just need each value, not the index.
        for (int number : numbers) {
            System.out.println("Value: " + number);
        }

        // ===================== WHILE LOOP =====================
        // Repeats as long as the condition stays true. Good when you don't know
        // in advance how many iterations you'll need.
        int countdown = 3;
        while (countdown > 0) {
            System.out.println("Countdown: " + countdown);
            countdown--; // Forgetting this line would loop forever (infinite loop)!
        }

        // ===================== DO-WHILE LOOP =====================
        // Like "while", but checks the condition AFTER running the block once,
        // so the body always executes at least one time.
        int attempts = 0;
        do {
            attempts++;
            System.out.println("Attempt #" + attempts);
        } while (attempts < 2);

        // ===================== BREAK AND CONTINUE =====================
        // "break" exits the loop entirely. "continue" skips to the next iteration.
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                break; // stop the loop completely once i reaches 5
            }
            System.out.println("Break demo: " + i);
        }

        for (int i = 1; i <= 5; i++) {
            if (i % 2 == 0) {
                continue; // skip printing even numbers
            }
            System.out.println("Odd number: " + i);
        }
    }
}
