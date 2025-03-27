package sit707_tasks;

import org.junit.Assert;
import org.junit.Test;

public class DateUtilTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "223423841";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Devesh Shrestha";
        Assert.assertNotNull("Student name is null", studentName);
    }

    // Previous Date Tests (1A - 13A)
   
    @Test public void test1A() {
        DateUtil date = new DateUtil(1, 6, 1994);
        date.decrement();
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(5, date.getMonth());
    }

    @Test public void test2A() {
        DateUtil date = new DateUtil(2, 6, 1994);
        date.decrement();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(6, date.getMonth());
    }

    @Test public void test3A() {
        DateUtil date = new DateUtil(15, 6, 1994);
        date.decrement();
        Assert.assertEquals(14, date.getDay());
    }

    @Test public void test4A() {
        DateUtil date = new DateUtil(30, 6, 1994);
        date.decrement();
        Assert.assertEquals(29, date.getDay());
    }
    
    @Test(expected = RuntimeException.class)
    public void testInvalidDate() {
        // Attempt to create an invalid date: 31st June 1994.
        new DateUtil(31, 6, 1994);
    }

    @Test public void test6A() {
        DateUtil date = new DateUtil(15, 1, 1994);
        date.decrement();
        Assert.assertEquals(14, date.getDay());
    }

    @Test public void test7A() {
        DateUtil date = new DateUtil(15, 2, 1994);
        date.decrement();
        Assert.assertEquals(14, date.getDay());
    }

    @Test public void test8A() {
        DateUtil date = new DateUtil(15, 11, 1994);
        date.decrement();
        Assert.assertEquals(14, date.getDay());
    }

    @Test public void test9A() {
        DateUtil date = new DateUtil(15, 12, 1994);
        date.decrement();
        Assert.assertEquals(14, date.getDay());
    }

    @Test public void test10A() {
        DateUtil date = new DateUtil(15, 6, 1700);
        date.decrement();
        Assert.assertEquals(14, date.getDay());
    }

    @Test public void test11A() {
        DateUtil date = new DateUtil(15, 6, 1701);
        date.decrement();
        Assert.assertEquals(14, date.getDay());
    }

    @Test public void test12A() {
        DateUtil date = new DateUtil(15, 6, 2023);
        date.decrement();
        Assert.assertEquals(14, date.getDay());
    }

    @Test public void test13A() {
        DateUtil date = new DateUtil(15, 6, 2024);
        date.decrement();
        Assert.assertEquals(14, date.getDay());
    }


    // Next Date Tests (1B - 13B)
  
    @Test public void test1B() {
        DateUtil date = new DateUtil(1, 6, 1994);
        date.increment();
        Assert.assertEquals(2, date.getDay());
    }

    @Test public void test2B() {
        DateUtil date = new DateUtil(2, 6, 1994);
        date.increment();
        Assert.assertEquals(3, date.getDay());
    }

    @Test public void test3B() {
        DateUtil date = new DateUtil(15, 6, 1994);
        date.increment();
        Assert.assertEquals(16, date.getDay());
    }

    @Test public void test4B() {
        DateUtil date = new DateUtil(30, 6, 1994);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(7, date.getMonth());
    }

    @Test(expected = RuntimeException.class)
    public void test5B() {
        new DateUtil(31, 6, 1994); // Invalid date
    }

    @Test public void test6B() {
        DateUtil date = new DateUtil(15, 1, 1994);
        date.increment();
        Assert.assertEquals(16, date.getDay());
    }

    @Test public void test7B() {
        DateUtil date = new DateUtil(15, 2, 1994);
        date.increment();
        Assert.assertEquals(16, date.getDay());
    }

    @Test public void test8B() {
        DateUtil date = new DateUtil(15, 11, 1994);
        date.increment();
        Assert.assertEquals(16, date.getDay());
    }

    @Test public void test9B() {
        DateUtil date = new DateUtil(15, 12, 1994);
        date.increment();
        Assert.assertEquals(16, date.getDay());
    }

    @Test public void test10B() {
        DateUtil date = new DateUtil(15, 6, 1700);
        date.increment();
        Assert.assertEquals(16, date.getDay());
    }

    @Test public void test11B() {
        DateUtil date = new DateUtil(15, 6, 1701);
        date.increment();
        Assert.assertEquals(16, date.getDay());
    }

    @Test public void test12B() {
        DateUtil date = new DateUtil(15, 6, 2023);
        date.increment();
        Assert.assertEquals(16, date.getDay());
    }

    @Test public void test13B() {
        DateUtil date = new DateUtil(15, 6, 2024);
        date.increment();
        Assert.assertEquals(16, date.getDay());
    }


    // Leap Year Tests

    @Test public void testLeapYear_Feb28() {
        DateUtil date = new DateUtil(28, 2, 2024);
        date.increment();
        Assert.assertEquals(29, date.getDay());
    }

    @Test public void testLeapYear_Feb29() {
        DateUtil date = new DateUtil(29, 2, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
    }

    @Test public void testLeapYear_March1() {
        DateUtil date = new DateUtil(1, 3, 2024);
        date.decrement();
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(2, date.getMonth());
    }
}