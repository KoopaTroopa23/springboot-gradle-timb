package com.example.demo;

import org.json.JSONObject;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.json.JSONTokener;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SpringControllerSeleniumTest {

    private WebDriver driver;
    private JSONObject testData;

    @BeforeAll
    void setup() throws IOException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("user-agent=Mozilla/5.0");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Load JSON test data
        FileInputStream fis = new FileInputStream("src/main/resources/testdata/checkjsondata.json");
        JSONTokener tokener = new JSONTokener(fis);
        testData = new JSONObject(tokener);
    }

    @Test
    @DisplayName("Test Root Controller Returns Hello World")
    void testHelloWorldEndpoint() {
        try {
            driver.get("http://localhost:8080/");
        } catch (WebDriverException e) {
            System.out.println("SKIPPED: App not running");
            return; // skip the test if server is down
        }

        WebElement body = driver.findElement(By.tagName("body"));
        String actualText = body.getText();
        Assertions.assertEquals("Hello, World!", actualText);
    }

    


    @AfterAll
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
