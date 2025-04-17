package sit707_tasks;

import org.junit.Assert;
import org.junit.Test;

/**
 * SIT707 Task 3.2C - Equivalence Class Testing
 * Student Name: Devesh Shrestha
 * Student ID: 224829819
 */
public class DateUtilTest {

    // Identity checks
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

    // TC1: D1-M2-Y2 (Valid middle day in 31-day month, non-leap year)
    @Test
    public void testValidDayInNonLeapYear() {
        DateUtil date = new DateUtil(15, 3, 2023); // March 15, 2023
        date.increment();
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(3, date.getMonth());
    }

    // TC2: D2-M3-Y1 (Feb 29 valid in leap year)
    @Test
    public void testLeapYearFeb29IncrementToMarch1() {
        DateUtil date = new DateUtil(29, 2, 2020);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
    }

    // TC3: D2-M3-Y2 (Feb 29 invalid in non-leap year)
    @Test(expected = RuntimeException.class)
    public void testNonLeapYearFeb29ShouldFail() {
        new DateUtil(29, 2, 2021);
    }

    // TC4: D3-M1-Y2 (April 30 valid, goes to May 1)
    @Test
    public void testApril30IncrementToMay1() {
        DateUtil date = new DateUtil(30, 4, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(5, date.getMonth());
    }

    // TC5: D4-M1-Y2 (April 31 invalid)
    @Test(expected = RuntimeException.class)
    public void testInvalidApril31() {
        new DateUtil(31, 4, 2024);
    }

    // TC6: D4-M2-Y2 (May 31 valid → June 1)
    @Test
    public void testMay31IncrementToJune1() {
        DateUtil date = new DateUtil(31, 5, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(6, date.getMonth());
    }

    // TC7: D1-M3-Y2 (Feb 28 non-leap → March 1)
    @Test
    public void testNonLeapYearFeb28IncrementToMarch1() {
        DateUtil date = new DateUtil(28, 2, 2021);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
    }

    // TC8: Edge case: Jan 1 → Dec 31 prev year
    @Test
    public void testJanuary1DecrementToDecember31PrevYear() {
        DateUtil date = new DateUtil(1, 1, 2024);
        date.decrement();
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    // TC9: Mar 1 → Feb 29 in leap year
    @Test
    public void testMarch1DecrementToFeb29InLeapYear() {
        DateUtil date = new DateUtil(1, 3, 2020);
        date.decrement();
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(2, date.getMonth());
    }

    // TC10: Mar 1 → Feb 28 in non-leap year
    @Test
    public void testMarch1DecrementToFeb28InNonLeapYear() {
        DateUtil date = new DateUtil(1, 3, 2021);
        date.decrement();
        Assert.assertEquals(28, date.getDay());
        Assert.assertEquals(2, date.getMonth());
    }

    // TC11: Feb 30 (invalid – never exists)
    @Test(expected = RuntimeException.class)
    public void testFeb30ShouldFail() {
        new DateUtil(30, 2, 2024);
    }

    // TC12: June 15 → increment to June 16 (normal valid mid-month)
    @Test
    public void testValidMidMonthIncrement() {
        DateUtil date = new DateUtil(15, 6, 2024);
        date.increment();
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(6, date.getMonth());
    }

    // TC13: Nov 30 → increment to Dec 1 (month change)
    @Test
    public void testNovember30IncrementToDecember1() {
        DateUtil date = new DateUtil(30, 11, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(12, date.getMonth());
    }

    // TC14: Dec 31 → increment to Jan 1 of next year
    @Test
    public void testDecember31IncrementToJan1NextYear() {
        DateUtil date = new DateUtil(31, 12, 2023);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    // TC15: Jan 31 → decrement to Jan 30
    @Test
    public void testJanuary31DecrementToJanuary30() {
        DateUtil date = new DateUtil(31, 1, 2024);
        date.decrement();
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
    }
}
