package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class SeleniumTestTwo {
    public static void main(String[] args) throws InterruptedException {
        // Set the path to ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Open a website that might have a CAPTCHA
            String url = "https://example.com"; // Replace with the actual URL you want to test
            driver.get(url);
            System.out.println("Opened URL: " + url);

            // Wait for the page to load
            Thread.sleep(2000);

            // Detect CAPTCHA (common elements to look for)
            boolean isCaptchaPresent = false;
            try {
                WebElement captchaElement = driver.findElement(By.xpath("//iframe[contains(@title, 'reCAPTCHA')]"));
                if (captchaElement.isDisplayed()) {
                    isCaptchaPresent = true;
                }
            } catch (Exception e) {
                isCaptchaPresent = false;
            }

            // Output the result
            if (isCaptchaPresent) {
                System.out.println("CAPTCHA detected: 'I'm not a robot' is present on the page.");
            } else {
                System.out.println("No CAPTCHA detected.");
            }

        } finally {
            // Close the browser
            Thread.sleep(3000); // Wait for 3 seconds before closing
            driver.quit();
        }
    }
}
