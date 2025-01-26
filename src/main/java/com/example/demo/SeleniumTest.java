package com.example.demo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;  // Added so Keys.ENTER works
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;

public class SeleniumTest {

    public static void main(String[] args) {
        // ------------------------------------------------------------------
        // 1) ChromeDriver path (Update if necessary)
        // ------------------------------------------------------------------
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        String driverPath = "src/main/resources/drivers/chromedriver.exe";
        if (!Files.exists(Paths.get(driverPath))) {
            System.err.println("Error: chromedriver not found at " + driverPath);
            return;
        }
        // Setting property again with driverPath
        System.setProperty("webdriver.chrome.driver", driverPath);

        // 2) Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // --------------------------------------------------------------
            // 3) Open the main page
            // --------------------------------------------------------------
            driver.get("https://the-internet.herokuapp.com/");
            System.out.println("Page Title: " + driver.getTitle());

            // Up to 10s wait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Pause so you can see the page
            Thread.sleep(2000);

            // --------------------------------------------------------------
            // 4) Add/Remove Elements
            // --------------------------------------------------------------
            driver.findElement(By.linkText("Add/Remove Elements")).click();
            Thread.sleep(1000);

            WebElement addButton = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Add Element']"))
            );
            addButton.click();
            Thread.sleep(1000);
            addButton.click();
            System.out.println("Added two elements.");
            Thread.sleep(1000);

            // Remove one element
            List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
            if (!deleteButtons.isEmpty()) {
                deleteButtons.get(0).click();
                System.out.println("Deleted one element. Remaining: " + (deleteButtons.size() - 1));
            }
            Thread.sleep(1000);

            // Return to main page
            driver.get("https://the-internet.herokuapp.com/");
            Thread.sleep(1000);

            // --------------------------------------------------------------
            // 5) Checkboxes
            // --------------------------------------------------------------
            driver.findElement(By.linkText("Checkboxes")).click();
            Thread.sleep(1000);

            WebElement checkbox1 = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//form[@id='checkboxes']/input[1]"))
            );
            WebElement checkbox2 = driver.findElement(
                By.xpath("//form[@id='checkboxes']/input[2]")
            );

            // Check first box if unchecked
            if (!checkbox1.isSelected()) {
                checkbox1.click();
                System.out.println("First checkbox checked.");
            }
            Thread.sleep(1000);

            // Uncheck second box if checked
            if (checkbox2.isSelected()) {
                checkbox2.click();
                System.out.println("Second checkbox unchecked.");
            }
            Thread.sleep(1000);

            // Return to main page
            driver.get("https://the-internet.herokuapp.com/");
            Thread.sleep(1000);

            // --------------------------------------------------------------
            // 6) Dropdown
            // --------------------------------------------------------------
            driver.findElement(By.linkText("Dropdown")).click();
            Thread.sleep(1000);

            WebElement dropdown = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("dropdown"))
            );
            new Select(dropdown).selectByVisibleText("Option 1");
            System.out.println("Dropdown option selected: Option 1");
            Thread.sleep(1000);

            driver.get("https://the-internet.herokuapp.com/");
            Thread.sleep(1000);

            // --------------------------------------------------------------
            // 7) Inputs (type a number)
            // --------------------------------------------------------------
            driver.findElement(By.linkText("Inputs")).click();
            Thread.sleep(1000);

            WebElement numberInput = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.tagName("input"))
            );
            numberInput.clear();
            numberInput.sendKeys("12345");
            System.out.println("Entered '12345' into the input field.");
            Thread.sleep(1000);

            // Return to main page
            driver.get("https://the-internet.herokuapp.com/");
            Thread.sleep(1000);

            // --------------------------------------------------------------
            // 8) Form Authentication (invalid credentials)
            // --------------------------------------------------------------
            driver.findElement(By.linkText("Form Authentication")).click();
            Thread.sleep(1000);

            WebElement usernameField = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("username"))
            );
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.tagName("button"));

            usernameField.sendKeys("invalidUser");
            passwordField.sendKeys("invalidPass");
            loginButton.click();
            Thread.sleep(1000);

            WebElement errorMsg = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("flash"))
            );
            System.out.println("Form Auth error message: " + errorMsg.getText());
            Thread.sleep(1000);

            // Return to main page
            driver.get("https://the-internet.herokuapp.com/");
            Thread.sleep(1000);

            // --------------------------------------------------------------
            // 9) JavaScript Alerts
            // --------------------------------------------------------------
            driver.findElement(By.linkText("JavaScript Alerts")).click();
            Thread.sleep(1000);

            WebElement alertButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click for JS Alert']"))
            );
            alertButton.click();
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert message: " + alert.getText());
            alert.accept();
            Thread.sleep(1000);

            // Return to main page
            driver.get("https://the-internet.herokuapp.com/");
            Thread.sleep(1000);

            // --------------------------------------------------------------
            // 10) Hovers
            // --------------------------------------------------------------
            driver.findElement(By.linkText("Hovers")).click();
            Thread.sleep(1000);

            Actions actions = new Actions(driver);
            WebElement firstFigure = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='figure'])[1]"))
            );
            actions.moveToElement(firstFigure).perform();
            Thread.sleep(1000);

            WebElement caption = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("(//div[@class='figcaption'])[1]/h5"))
            );
            System.out.println("Hovered caption text: " + caption.getText());
            Thread.sleep(1000);

            // Return to main page
            driver.get("https://the-internet.herokuapp.com/");
            Thread.sleep(1000);

            // --------------------------------------------------------------
            // 11) Key Presses
            // --------------------------------------------------------------
            driver.findElement(By.linkText("Key Presses")).click();
            Thread.sleep(1000);

            WebElement keyInput = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("target"))
            );
            keyInput.sendKeys(Keys.ENTER);
            Thread.sleep(1000);

            WebElement resultText = driver.findElement(By.id("result"));
            System.out.println("Key Presses result: " + resultText.getText());
            Thread.sleep(1000);

            // Return to main page
            driver.get("https://the-internet.herokuapp.com/");
            Thread.sleep(1000);

            // --------------------------------------------------------------
            // 12) Forgot Password
            // --------------------------------------------------------------
            driver.findElement(By.linkText("Forgot Password")).click();
            Thread.sleep(1000);

            WebElement emailField = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("email"))
            );
            emailField.sendKeys("someemail@example.com");
            driver.findElement(By.id("form_submit")).click();
            Thread.sleep(1000);

            System.out.println("Forgot Password submitted.");
            Thread.sleep(1000);

            // Return to main page
            driver.get("https://the-internet.herokuapp.com/");
            Thread.sleep(1000);

            // --------------------------------------------------------------
            // 13) File Upload (optional test)
            // --------------------------------------------------------------
            driver.findElement(By.linkText("File Upload")).click();
            Thread.sleep(1000);

            // Wait for the file input and upload a file named "some-file.txt"
            WebElement fileInput = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("file-upload"))
            );
            // Make sure "some-file.txt" actually exists in your project or specify another path
            fileInput.sendKeys("some-file.txt");
            driver.findElement(By.id("file-submit")).click();
            Thread.sleep(1000);

            try {
                WebElement uploadedMsg = driver.findElement(By.id("uploaded-files"));
                System.out.println("Uploaded file text: " + uploadedMsg.getText());
            } catch (NoSuchElementException e) {
                System.out.println("Could not confirm file upload: " + e.getMessage());
            }
            Thread.sleep(1000);

            // Return to main page
            driver.get("https://the-internet.herokuapp.com/");
            Thread.sleep(1000);

            // --------------------------------------------------------------
            // 14) File Download (optional test)
            // --------------------------------------------------------------
            driver.findElement(By.linkText("File Download")).click();
            Thread.sleep(1000);

            // This page has multiple links to files. We'll just click the first file link.
            List<WebElement> files = driver.findElements(By.cssSelector(".example a"));
            if (!files.isEmpty()) {
                System.out.println("Downloading: " + files.get(0).getText());
                files.get(0).click();
            } else {
                System.out.println("No files found to download.");
            }
            Thread.sleep(2000);

            // Return to main page
            driver.get("https://the-internet.herokuapp.com/");
            Thread.sleep(1000);

            // --------------------------------------------------------------
            // 15) Visit all links on the main page
            // --------------------------------------------------------------
            List<WebElement> allLinks = driver.findElements(By.tagName("a"));
            System.out.println("Number of links on the main page: " + allLinks.size());

            // Loop through each link, open it, print the title, then go back
            for (int i = 0; i < allLinks.size(); i++) {
                allLinks = driver.findElements(By.tagName("a")); // re-collect
                WebElement link = allLinks.get(i);

                String linkText = link.getText();
                String href = link.getAttribute("href");
                if (href == null || href.isBlank()) {
                    System.out.println("Skipping blank/anchor link: " + linkText);
                    continue;
                }

                System.out.println("Navigating to link #" + (i + 1) +
                    " [" + linkText + "] => " + href);
                driver.navigate().to(href);
                Thread.sleep(1500);

                System.out.println("Page Title now: " + driver.getTitle());
                driver.navigate().back();
                Thread.sleep(1500);
            }

        } catch (NoSuchElementException e) {
            System.err.println("Element not found: " + e.getMessage());
        } catch (TimeoutException e) {
            System.err.println("Timeout waiting for an element: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            // --------------------------------------------------------------
            // 16) Close the browser
            // --------------------------------------------------------------
            driver.quit();
        }
    }
}
