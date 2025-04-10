package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

public class LoginFormTest {

    // Identity Tests
    @Test
    public void testStudentIdentity() {
        String studentId = "224829819";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Devesh Shrestha";
        Assert.assertNotNull("Student name is null", studentName);
    }

    // R1: Empty username, empty password
    @Test
    public void testR1_EmptyUsernameAndEmptyPassword() {
        LoginStatus status = LoginForm.login(null, null);
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    // R2: Empty username, wrong password
    @Test
    public void testR2_EmptyUsernameWrongPassword() {
        LoginStatus status = LoginForm.login(null, "wrongPass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    // R3: Empty username, correct password
    @Test
    public void testR3_EmptyUsernameCorrectPassword() {
        LoginStatus status = LoginForm.login(null, "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    // R4: Wrong username, empty password
    @Test
    public void testR4_WrongUsernameEmptyPassword() {
        LoginStatus status = LoginForm.login("wrongUser", null);
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Password", status.getErrorMsg());
    }

    // R5: Wrong username, wrong password
    @Test
    public void testR5_WrongUsernameWrongPassword() {
        LoginStatus status = LoginForm.login("wrongUser", "wrongPass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    // R6: Wrong username, correct password
    @Test
    public void testR6_WrongUsernameCorrectPassword() {
        LoginStatus status = LoginForm.login("wrongUser", "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    // R7: Correct username, empty password
    @Test
    public void testR7_CorrectUsernameEmptyPassword() {
        LoginStatus status = LoginForm.login("ahsan", null);
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Password", status.getErrorMsg());
    }

    // R8: Correct username, wrong password
    @Test
    public void testR8_CorrectUsernameWrongPassword() {
        LoginStatus status = LoginForm.login("ahsan", "wrongPass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    // R9: Correct login, empty validation code
    @Test
    public void testR9_CorrectLoginEmptyValidationCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());
        boolean result = LoginForm.validateCode(null);
        Assert.assertFalse(result);
    }

    // R10: Correct login, invalid validation code
    @Test
    public void testR10_CorrectLoginInvalidValidationCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());
        boolean result = LoginForm.validateCode("wrong123");
        Assert.assertFalse(result);
    }

    // R11: Correct login, correct validation code
    @Test
    public void testR11_CorrectLoginValidValidationCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());
        String validCode = status.getErrorMsg(); // returns validation code
        boolean result = LoginForm.validateCode(validCode);
        Assert.assertTrue(result);
    }
}
