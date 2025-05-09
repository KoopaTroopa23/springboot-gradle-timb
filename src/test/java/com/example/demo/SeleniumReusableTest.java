package com.example.demo;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SeleniumReusableTest {

    private WebDriver driver;
    private final Random random = new Random();

    @BeforeAll
    void setupClass() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/136.0.0.0 Safari/537.36");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Create screenshots directory if it doesn’t exist
        new File("screenshots").mkdirs();
    }

    @BeforeEach
    void setupTest() throws InterruptedException {
        driver.manage().deleteAllCookies();
        randomDelay(2, 4);
    }

    @Test
    @DisplayName("DuckDuckGo: Search Test")
    void testDuckDuckGoSearch() throws InterruptedException {
        try {
            driver.get("https://duckduckgo.com");
            WebElement searchBox = driver.findElement(By.name("q"));
            typeLikeHuman(searchBox, "Selenium Java Reusable Test");
            searchBox.sendKeys(Keys.ENTER);
            randomDelay(3, 6);

            Assertions.assertTrue(driver.getTitle().toLowerCase().contains("selenium"));
        } catch (Exception e) {
            takeScreenshot("testDuckDuckGoSearch");
            throw e;
        }
    }

    @Test
    @DisplayName("Example.com: Basic Load Test")
    void testExampleDotComLoads() throws InterruptedException {
        try {
            driver.get("https://example.com");
            randomDelay(2, 4);

            WebElement heading = driver.findElement(By.tagName("h1"));
            Assertions.assertEquals("Example Domain", heading.getText());
        } catch (Exception e) {
            takeScreenshot("testExampleDotComLoads");
            throw e;
        }
    }

    @AfterEach
    void afterTest() throws InterruptedException {
        randomDelay(1, 2);
        System.out.println("Test completed.");
    }

    @AfterAll
    void teardownClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    // ========== Utility Methods ==========

    private void typeLikeHuman(WebElement element, String text) throws InterruptedException {
        for (char c : text.toCharArray()) {
            element.sendKeys(String.valueOf(c));
            Thread.sleep(100 + random.nextInt(150)); // Simulate typing
        }
    }

    private void randomDelay(int minSeconds, int maxSeconds) throws InterruptedException {
        int delay = minSeconds + random.nextInt(maxSeconds - minSeconds + 1);
        Thread.sleep(delay * 1000L);
    }

    private void takeScreenshot(String testName) {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File src = screenshot.getScreenshotAs(OutputType.FILE);
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            Files.copy(src.toPath(), Paths.get("screenshots", testName + "_" + timestamp + ".png"));
            System.out.println("❗ Screenshot saved for " + testName);
        } catch (IOException e) {
            System.err.println("⚠ Failed to take screenshot: " + e.getMessage());
        }
    }
}
