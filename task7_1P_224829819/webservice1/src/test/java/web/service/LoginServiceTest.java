package web.service;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginServiceTest {

    private WebDriver driver;

    @Before
    public void setUp() {
    	System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");

        driver = new ChromeDriver();
    }

    private void sleep(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLoginSuccess_Ahsan() {
        driver.get("file:///Users/mac/Documents/trimester%202/sit707/7.1p/7.1P-resources/pages/login.html");
        driver.findElement(By.id("username")).sendKeys("ahsan");
        driver.findElement(By.id("password")).sendKeys("ahsan_pass");
        WebElement dobField = driver.findElement(By.id("dob"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='1990-01-01';", dobField); 
        driver.findElement(By.cssSelector("[type=submit]")).click();
        sleep(2);
        assertEquals("success", driver.getTitle());
    }
    @Test
    public void testLoginFail_WrongPassword() {
    	driver.get("file:///Users/mac/Documents/trimester%202/sit707/7.1p/7.1P-resources/pages/login.html");

        driver.findElement(By.id("username")).sendKeys("ahsan");
        driver.findElement(By.id("password")).sendKeys("wrongpass");
        driver.findElement(By.id("dob")).sendKeys("1990-01-01");
        driver.findElement(By.cssSelector("[type=submit]")).click();
        sleep(2);
        assertEquals("fail", driver.getTitle());
    }

    @Test
    public void testLoginFail_InvalidUser() {
    	driver.get("file:///Users/mac/Documents/trimester%202/sit707/7.1p/7.1P-resources/pages/login.html");
        driver.findElement(By.id("username")).sendKeys("unknown");
        driver.findElement(By.id("password")).sendKeys("pass");
        driver.findElement(By.id("dob")).sendKeys("2000-01-01");
        driver.findElement(By.cssSelector("[type=submit]")).click();
        sleep(2);
        assertEquals("fail", driver.getTitle());
    }
    @Test
    public void testLoginFail_MissingDOB() {
        driver.get("file:///Users/mac/Documents/trimester%202/sit707/7.1p/7.1P-resources/pages/login.html");

        driver.findElement(By.id("username")).sendKeys("ahsan");
        driver.findElement(By.id("password")).sendKeys("ahsan_pass");

        // Disable HTML5 validation
        WebElement form = driver.findElement(By.tagName("form"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('novalidate', 'true')", form);

        driver.findElement(By.cssSelector("[type=submit]")).click();
        sleep(2);
        assertEquals("fail", driver.getTitle());
    }

    @Test
    public void testLoginFail_EmptyUsernamePassword() {
        driver.get("file:///Users/mac/Documents/trimester%202/sit707/7.1p/7.1P-resources/pages/login.html");

        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("dob")).sendKeys("1990-01-01");

        // Disable HTML5 validation
        WebElement form = driver.findElement(By.tagName("form"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('novalidate', 'true')", form);

        driver.findElement(By.cssSelector("[type=submit]")).click();
        sleep(2);
        assertEquals("fail", driver.getTitle());
    }




    @After
    public void tearDown() {
        driver.quit();
    }
}
