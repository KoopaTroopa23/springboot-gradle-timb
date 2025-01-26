package com.example.demo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.io.IOException;

public class SmartJsonParser {

    public static void main(String[] args) {
        String jsonFilePath = "src/main/resources/testdata/checkjsondata.json"; // adjust as needed

        Object parsed = parseJsonFile(jsonFilePath);
        if (parsed == null) {
            System.out.println("Failed to parse JSON or it was neither an array nor an object.");
            return;
        }

        // Detect type
        if (parsed instanceof JSONObject) {
            JSONObject obj = (JSONObject) parsed;
            System.out.println("Parsed a JSON Object with keys: " + obj.keySet());
            // Example: detect if it has certain fields
            if (obj.has("siteUrl")) {
                System.out.println("siteUrl = " + obj.getString("siteUrl"));
            }
        } else if (parsed instanceof JSONArray) {
            JSONArray arr = (JSONArray) parsed;
            System.out.println("Parsed a JSON Array. Length: " + arr.length());

            // For demonstration, loop over each element and see if it’s an object
            for (int i = 0; i < arr.length(); i++) {
                if (arr.get(i) instanceof JSONObject) {
                    JSONObject item = arr.getJSONObject(i);
                    System.out.println("Array item " + i + " has keys: " + item.keySet());
                    // Example key check
                    if (item.has("invalidPassword")) {
                        System.out.println("invalidPassword = " + item.getString("invalidPassword"));
                    }
                } else {
                    System.out.println("Array item " + i + " is not an object: " + arr.get(i));
                }
            }
        }

        // If we got here, we parsed successfully and printed out some info
        System.out.println("Done parsing JSON.");
    }

    /**
     * Tries to parse the given file as either a JSON object or array.
     * Returns a JSONObject, JSONArray, or null if neither.
     */
    private static Object parseJsonFile(String path) {
        try (FileReader reader = new FileReader(path)) {
            JSONTokener tokener = new JSONTokener(reader);

            // Peek the first non-whitespace character
            char first = tokener.nextClean();
            tokener.back(); // Rewind one character so we can parse from the start

            if (first == '{') {
                // Parse as object
                return new JSONObject(tokener);
            } else if (first == '[') {
                // Parse as array
                return new JSONArray(tokener);
            } else {
                System.err.println("Error: JSON must begin with '{' or '[' but found '" + first + "'");
                return null;
            }
        } catch (IOException e) {
            System.err.println("I/O error reading file: " + e.getMessage());
            return null;
        } catch (JSONException e) {
            System.err.println("JSON parse error: " + e.getMessage());
            return null;
        }
    }
}
