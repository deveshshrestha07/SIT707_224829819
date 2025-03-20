package sit707_week2;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
 
/**
* This class demonstrates Selenium locator and interaction APIs to identify HTML elements,
* fill registration forms, simulate button clicks, and take screenshots.
* 
* References:
* Selenium Locators: https://www.selenium.dev/documentation/webdriver/elements/locators/ 
* Selenium Interactions: https://www.selenium.dev/documentation/webdriver/elements/interactions/
* 
* Assignment: Test a registration page using Selenium.
* 
* Author: Devesh Shrestha
*/
public class SeleniumOperations {
 
    // Helper method for pausing execution
    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 
    // Officeworks registration page automation
    public static void officeworks_registration_page(String url) {
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
 
        System.out.println("Launching Officeworks registration page...");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
 
        driver.get(url);
        sleep(2);
 
        // --- filling input fields ---
        WebElement firstName = driver.findElement(By.id("firstname"));
        firstName.sendKeys("Devesh");
 
        WebElement lastName = driver.findElement(By.id("lastname"));
        lastName.sendKeys("Shrestha");
        WebElement phoneNumber = driver.findElement(By.id("phoneNumber"));
        phoneNumber.sendKeys("0403479964");
 
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("deveshshrestha10@gmail.com");
 
        // Using a weak password to trigger validation error
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("DeakinUni@123");
        WebElement confirmPassword = driver.findElement(By.id("confirmPassword"));
        confirmPassword.sendKeys("DeakinUni@124"); // mismatched
 
        WebElement createAccountButton = driver.findElement(By.xpath("//button[@data-testid='account-action-btn']"));
        createAccountButton.click();
 
        sleep(2);

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Please enter the same value again')]")));
        } catch (Exception e) {
            System.out.println("Taking Screenshot");
        }
 
        // --- Take a screenshot ---
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(screenshot.toPath(), new File("officeworks_registration.png").toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot saved as officeworks_registration.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
 
        driver.quit();
        System.out.println("Quitting Officework");
    }
 
    //  Pool and Spa Warehouse registration page automation
    public static void poolandspa_registration_page(String url) {
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
 
        System.out.println("Launching Pool and Spa Warehouse registration page...");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
 
        driver.get(url);
        sleep(2);
 
        // filling input fields ---
        WebElement firstName = driver.findElement(By.id("firstname"));
        firstName.sendKeys("Devesh");
 
        WebElement lastName = driver.findElement(By.id("lastname"));
        lastName.sendKeys("Shrestha");
 
        WebElement email = driver.findElement(By.id("email_address"));
        email.sendKeys("deveshshrestha10@gmail.com");
 
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("abcd@123");
 
        WebElement confirmPassword = driver.findElement(By.id("password-confirmation"));
        confirmPassword.sendKeys("abcd@34"); // mismatched
 
        WebElement showPasswordCheckbox = driver.findElement(By.id("show-password"));
        if (!showPasswordCheckbox.isSelected()) {
            showPasswordCheckbox.click();
        }
 
        // Click the Create Account button
        WebElement createAccountButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='action submit primary']")));
        createAccountButton.click();
 
        // --- Wait for the error message to appear ---
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Please enter the same value again')]")));
 
        sleep(2);
 
        // --- Take a screenshot after error appears ---
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(screenshot.toPath(), new File("poolandspa_registration.png").toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot saved as poolandspa_registration.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
 
        driver.quit();
        System.out.println("Quitting Pool and Spa");
        
    }
}
