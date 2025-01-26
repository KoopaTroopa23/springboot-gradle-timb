package com.example.demo;

import org.json.JSONObject;
import java.io.FileReader;
import java.io.IOException;

public class JsonTokener {

    public static void main(String[] args) {
        // The path to your JSON file in src/main/resources/testdata/ 
        String jsonFilePath = "src/main/resources/testdata/checkjsondata.json";

        try (FileReader reader = new FileReader(jsonFilePath)) {
            // 1. Create an org.json.JSONTokener from the FileReader
            org.json.JSONTokener tokener = new org.json.JSONTokener(reader);
            
            // 2. Parse that tokener into a JSONObject
            JSONObject jsonObject = new JSONObject(tokener);

            // 3. Extract fields from the JSON
            String siteUrl          = jsonObject.optString("siteUrl", "https://the-internet.herokuapp.com");
            String invalidUsername  = jsonObject.optString("invalidUsername", "defaultUser");
            String invalidPassword  = jsonObject.optString("invalidPassword", "defaultPass");
            String emailAddress     = jsonObject.optString("email", "someemail@example.com");

            // Print them out
            System.out.println("Parsed from JSON (" + jsonFilePath + "):");
            System.out.println("  siteUrl:          " + siteUrl);
            System.out.println("  invalidUsername:  " + invalidUsername);
            System.out.println("  invalidPassword:  " + invalidPassword);
            System.out.println("  emailAddress:     " + emailAddress);

            // TODO: If you wish, use these fields in Selenium tests here
            // WebDriver driver = new ChromeDriver();
            // driver.get(siteUrl);
            // ... etc.

        } catch (IOException e) {
            System.err.println("Failed to read JSON file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
