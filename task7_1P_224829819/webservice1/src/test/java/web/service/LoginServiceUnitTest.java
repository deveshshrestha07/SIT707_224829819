package web.service;

import static org.junit.Assert.*;
import org.junit.Test;

public class LoginServiceUnitTest {

    @Test
    public void testValidLogin_Ahsan() {
        assertTrue(LoginService.login("ahsan", "ahsan_pass", "1990-01-01"));
    }

    @Test
    public void testValidLogin_Student1() {
        assertTrue(LoginService.login("student1", "pass123", "1995-05-05"));
    }

    @Test
    public void testValidLogin_Admin() {
        assertTrue(LoginService.login("admin", "admin123", "1980-12-12"));
    }

    @Test
    public void testInvalidUsername() {
        assertFalse(LoginService.login("unknown", "pass123", "1995-05-05"));
    }

    @Test
    public void testInvalidPassword() {
        assertFalse(LoginService.login("ahsan", "wrongpass", "1990-01-01"));
    }

    @Test
    public void testInvalidDOB() {
        assertFalse(LoginService.login("ahsan", "ahsan_pass", "2000-01-01"));
    }

    @Test
    public void testNullUsername() {
        assertFalse(LoginService.login(null, "ahsan_pass", "1990-01-01"));
    }

    @Test
    public void testNullPassword() {
        assertFalse(LoginService.login("ahsan", null, "1990-01-01"));
    }

    @Test
    public void testNullDOB() {
        assertFalse(LoginService.login("ahsan", "ahsan_pass", null));
    }

    @Test
    public void testAllNullInputs() {
        assertFalse(LoginService.login(null, null, null));
    }

    @Test
    public void testEmptyUsername() {
        assertFalse(LoginService.login("", "ahsan_pass", "1990-01-01"));
    }

    @Test
    public void testEmptyPassword() {
        assertFalse(LoginService.login("ahsan", "", "1990-01-01"));
    }

    @Test
    public void testEmptyDOB() {
        assertFalse(LoginService.login("ahsan", "ahsan_pass", ""));
    }
}
