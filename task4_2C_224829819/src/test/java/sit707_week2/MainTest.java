package sit707_week2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * JUnit test cases for SIT707 Task 4.2C.
 * Includes identity checks and Selenium-based login test cases based on a decision table.
 */
public class MainTest {

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
    }

    @Test
    public void testStudentIdentity() {
        String studentId = "22489819";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Devesh Shrestha";
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testAssertTrue() {
        Assert.assertTrue("This test should pass", true);
    }

    @Test
    public void testAssertFalse() {
        Assert.assertFalse("This test should pass", false);
    }

    // Helper method for login test
    private void performLoginTest(String emailInput, String passwordInput, boolean expectLoginSuccess) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.bunnings.com.au/login");
            Thread.sleep(2000);

            WebElement email = driver.findElement(By.id("username"));
            WebElement password = driver.findElement(By.id("password"));
            WebElement loginBtn = driver.findElement(By.id("login-submit"));

            email.clear();
            email.sendKeys(emailInput);

            password.clear();
            password.sendKeys(passwordInput);

            loginBtn.click();
            Thread.sleep(3000);

            String currentUrl = driver.getCurrentUrl();
            if (expectLoginSuccess) {
                Assert.assertFalse("Expected login success but URL still contains 'login'", currentUrl.contains("login"));
            } else {
                Assert.assertTrue("Expected login failure but URL does not contain 'login'", currentUrl.contains("login"));
            }
        } catch (Exception e) {
            Assert.fail("Selenium test failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    // TC1: Valid email & valid password (expect login success) – Skip this if you don't have real credentials
    @Test
    public void testLogin_TC1_ValidEmailValidPassword() {
        performLoginTest("valid@email.com", "validPassword", false); // Change to true if you have real credentials
    }

    // TC2: Valid email & invalid password
    @Test
    public void testLogin_TC2_ValidEmailInvalidPassword() {
        performLoginTest("valid@email.com", "wrongPassword", false);
    }

    // TC3: Invalid email & valid password
    @Test
    public void testLogin_TC3_InvalidEmailValidPassword() {
        performLoginTest("invalid@email.com", "validPassword", false);
    }

    // TC4: Invalid email & invalid password
    @Test
    public void testLogin_TC4_InvalidEmailInvalidPassword() {
        performLoginTest("invalid@email.com", "wrongPassword", false);
    }

    // TC5: Empty email & any password
    @Test
    public void testLogin_TC5_EmptyEmail() {
        performLoginTest("", "somePassword", false);
    }

    // TC6: Any email & empty password
    @Test
    public void testLogin_TC6_EmptyPassword() {
        performLoginTest("someone@email.com", "", false);
    }

    // TC7: Empty email & empty password
    @Test
    public void testLogin_TC7_EmptyEmailAndPassword() {
        performLoginTest("", "", false);
    }
}
