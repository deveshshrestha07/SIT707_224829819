package sit707_week1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Devesh Shrestha
 */
public class SeleniumOperations {
	
	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void open_chrome_and_close() {
		// Step 1: Locate chrome driver folder (chromium browser) in the local drive.
		System.setProperty("webdriver.chrome.driver",  "/opt/homebrew/bin/chromedriver");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		// Sleep a while
		sleep(5);
		
		/*
		 * We will use a lot of Selenium APIs here in future 
		 * including maximise window and open a URL in chromium browser.
		 */
		
		// close chrome driver. You can comment below line to keep the browser opened.
		driver.close();
		
	}
	

	public static void open_chrome_maximize_close() {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(5);
		
		// Maximize chrome driver
		driver.manage().window().maximize();
		
		// Sleep a while
		sleep(5);
		
		// close chrome driver. You can comment below line to keep the browser opened.
		driver.close();	
	}

	
	public static void load_web_page_close_test() {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser test.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(5);
		
		// Open the URL in chromium browser.
		driver.get("https://facebook.com");
		
		// Sleep a while
		sleep(5);
		
		// close chrome driver. You can comment below line to keep the browser opened.
		driver.close();	
	}
	
	public static void open_chrome_loadpage_resize_close() {
	    
	        // A. Modify the Hello message at the beginning of the function with your student ID and full name.
	        System.out.println("Hello👋 from 224829819, Devesh Shrestha"); // Replace with your actual student ID and full name.

	        // Step 1: Locate chrome driver folder in the local drive.
	        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver"); 

	        // Step 2: Use the above chrome driver to open up a chromium browser.
	        System.out.println("Fire up chrome browser.");
	        WebDriver driver = new ChromeDriver();
	        System.out.println("Driver info: " + driver);

	        // Sleep for 2 seconds to allow the browser to start
	        sleep(2);

	        // C. Load Google page.
	        driver.get("https://www.google.com");

	        // D. Set window size manually to 640x480 and wait for 2 seconds.
	        driver.manage().window().setSize(new org.openqa.selenium.Dimension(640, 480));
	        System.out.println("Window resized to 640x480");
	        sleep(2);  

	        // E. Double window size manually to 1280x960 and wait for 2 seconds.
	        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1280, 960));
	        System.out.println("Window resized to 1280x960");
	        sleep(2);  

	        // Sleep a while before closing the browser
	        sleep(2);

	        // G. Close chrome driver.
	        driver.close();
	        System.out.println("Window closed");
	   
	}}

