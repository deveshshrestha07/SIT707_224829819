package sit707_week2;

/**
 * Entry point for running Selenium-based functional test.
 * This version targets the Bunnings login page.
 */
public class Main {
    public static void main(String[] args) {
        // Run Bunnings login test directly
        SeleniumOperations.bunnings_login_page("https://www.bunnings.com.au/login?redirectUri=https%3A%2F%2Flogin.bunnings.com.au%2Foauth2%2Fv1%2Fauthorize%2Fredirect%3Fokta_key%3D1GknV_1d1rbmLrHv_CfT1qfJtVUhidBdiMjqrwrqGIU&login_hint={%22auth%22:{%22operation%22:%22retail_login%22,%22redirectUri%22:%22https://www.bunnings.com.au/login%22}}");
    }
}
