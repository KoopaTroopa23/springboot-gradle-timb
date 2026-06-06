package com.example.demo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class SmartJsonParserTest {

    @TempDir
    Path tempDir;

    private Object invokeParseJsonFile(String path) throws Exception {
        Method method = SmartJsonParser.class.getDeclaredMethod("parseJsonFile", String.class);
        method.setAccessible(true);
        return method.invoke(null, path);
    }

    @Test
    void parseJsonFile_jsonObject_returnsJSONObject() throws Exception {
        Path jsonFile = tempDir.resolve("obj.json");
        Files.writeString(jsonFile, "{\"siteUrl\":\"http://example.com\",\"key\":\"value\"}");

        Object result = invokeParseJsonFile(jsonFile.toString());

        assertNotNull(result);
        assertInstanceOf(JSONObject.class, result);
        assertEquals("http://example.com", ((JSONObject) result).getString("siteUrl"));
    }

    @Test
    void parseJsonFile_jsonArray_returnsJSONArray() throws Exception {
        Path jsonFile = tempDir.resolve("arr.json");
        Files.writeString(jsonFile, "[{\"invalidPassword\":\"pass1\"},{\"invalidPassword\":\"pass2\"}]");

        Object result = invokeParseJsonFile(jsonFile.toString());

        assertNotNull(result);
        assertInstanceOf(JSONArray.class, result);
        assertEquals(2, ((JSONArray) result).length());
    }

    @Test
    void parseJsonFile_invalidJson_returnsNull() throws Exception {
        Path jsonFile = tempDir.resolve("bad.json");
        Files.writeString(jsonFile, "this is not json !!!");

        Object result = invokeParseJsonFile(jsonFile.toString());

        assertNull(result);
    }

    @Test
    void parseJsonFile_nonExistentFile_returnsNull() throws Exception {
        Object result = invokeParseJsonFile("/nonexistent/path/missing.json");
        assertNull(result);
    }
}
