package com.example.demo;

public class AllTestsRunner {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Running SeleniumTest...");
        SeleniumTest.main(args);

        System.out.println("\nRunning SeleniumTestTwo...");
        SeleniumTestTwo.main(args);

        System.out.println("\nRunning JsonTokener (checkjsondata.json)...");
        JsonTokener.main(args);

        System.out.println("\nRunning XmlJsonDataTest (JSON & XML parsing)...");
        XmlDataParser.main(args);

        System.out.println("\nAll tests completed!");
    }
}
