package com.example.demo;

public class AllTestsRunner {
    public static void main(String[] args) {
        System.out.println("Running SeleniumTest...");
        SeleniumTest.main(args);

        System.out.println("\nRunning SeleniumTestTwo...");
        try {
            SeleniumTestTwo.main(args);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nRunning JsonTokener (checkjsondata.json)...");
        JsonTokener.main(args);

        System.out.println("\nAll tests completed!");
    }
}
