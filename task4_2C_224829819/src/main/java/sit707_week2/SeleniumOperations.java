package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumOperations {

    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void bunnings_login_page(String url) {
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");

        System.out.println("Fire up Chrome browser.");
        WebDriver driver = new ChromeDriver();
        sleep(2);

        // Navigate to Bunnings login page
        driver.get(url);

        // Wait for page to load
        sleep(2);

        try {
            // Locate email field
            WebElement emailField = driver.findElement(By.id("okta-signin-username"));
            emailField.sendKeys("invalid@email.com");

            // Locate password field
            WebElement passwordField = driver.findElement(By.id("okta-signin-password"));
            passwordField.sendKeys("incorrectPassword");

            // Locate and click the login button
            WebElement loginButton = driver.findElement(By.id("okta-signin-submit"));
            loginButton.click();

            sleep(3); // wait for page response

            // Check if still on login page (implies failed login)
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("login")) {
                System.out.println("Login failed as expected.");
            } else {
                System.out.println("Login behavior unexpected. Possibly succeeded.");
            }

        } catch (Exception e) {
            System.out.println("Error interacting with login form: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
