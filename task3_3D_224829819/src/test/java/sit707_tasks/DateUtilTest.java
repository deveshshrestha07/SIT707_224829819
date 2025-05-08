package sit707_tasks;

import java.util.Random;
import org.junit.Assert;
import org.junit.Test;

public class DateUtilTest {

	@Test
	public void testStudentIdentity() {
		String studentId = "123456789"; // Replace with your actual ID
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Your Name"; // Replace with your actual name
		Assert.assertNotNull("Student name is null", studentName);
	}

	// --- JANUARY BOUNDARY TESTS ---

	@Test
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		DateUtil date = new DateUtil(31, 1, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(2, date.getMonth());
	}

	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		DateUtil date = new DateUtil(31, 1, 2024);
		date.decrement();
		Assert.assertEquals(30, date.getDay());
		Assert.assertEquals(1, date.getMonth());
	}

	@Test
	public void testNominalJanuary() {
		int randDay = 2 + new Random().nextInt(28); // Avoid edge values
		DateUtil date = new DateUtil(randDay, 1, 2024);
		date.increment();
		Assert.assertEquals(randDay + 1, date.getDay());
	}

	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
		DateUtil date = new DateUtil(1, 1, 2024);
		date.increment();
		Assert.assertEquals(2, date.getDay());
		Assert.assertEquals(1, date.getMonth());
	}

	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
		DateUtil date = new DateUtil(1, 1, 2024);
		date.decrement();
		Assert.assertEquals(31, date.getDay());
		Assert.assertEquals(12, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
	}

	// --- FEBRUARY BOUNDARY TESTS ---

	@Test
	public void testLeapYearFeb28To29() {
		DateUtil date = new DateUtil(28, 2, 2024);
		date.increment();
		Assert.assertEquals(29, date.getDay());
		Assert.assertEquals(2, date.getMonth());
	}

	@Test
	public void testLeapYearFeb29ToMarch1() {
		DateUtil date = new DateUtil(29, 2, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(3, date.getMonth());
	}

	@Test
	public void testNonLeapYearFeb28ToMarch1() {
		DateUtil date = new DateUtil(28, 2, 2023);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(3, date.getMonth());
	}

	// --- APRIL BOUNDARY TEST ---

	@Test
	public void testApril30ShouldIncrementToMay1() {
		DateUtil date = new DateUtil(30, 4, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(5, date.getMonth());
	}

	// --- DECEMBER BOUNDARY TEST ---

	@Test
	public void testDecember31ShouldIncrementToJanuary1NextYear() {
		DateUtil date = new DateUtil(31, 12, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(1, date.getMonth());
		Assert.assertEquals(2025, date.getYear());
	}

	@Test
	public void testJanuary1ShouldDecrementToDecember31PreviousYear() {
		DateUtil date = new DateUtil(1, 1, 2024);
		date.decrement();
		Assert.assertEquals(31, date.getDay());
		Assert.assertEquals(12, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
	}

	// --- EQUIVALENCE CLASS TESTING: INVALID DATES ---

	@Test(expected = RuntimeException.class)
	public void testInvalidDay_April31() {
		new DateUtil(31, 4, 2024); // April has 30 days
	}

	@Test(expected = RuntimeException.class)
	public void testInvalidMonth_TooHigh() {
		new DateUtil(15, 13, 2024);
	}

	@Test(expected = RuntimeException.class)
	public void testInvalidMonth_TooLow() {
		new DateUtil(10, 0, 2024);
	}

	@Test(expected = RuntimeException.class)
	public void testInvalidDay_Zero() {
		new DateUtil(0, 1, 2024);
	}

	@Test(expected = RuntimeException.class)
	public void testInvalidYear_Low() {
		new DateUtil(1, 1, 1600);
	}

	@Test(expected = RuntimeException.class)
	public void testInvalidDay_Negative() {
		new DateUtil(-5, 5, 2024);
	}
	// === Leap Year & Non-Leap Year Edge Tests ===

	@Test
	public void testDecrementMarch1ToFeb29_LeapYear() {
	    DateUtil date = new DateUtil(1, 3, 2024);
	    date.decrement();
	    Assert.assertEquals(29, date.getDay());
	    Assert.assertEquals(2, date.getMonth());
	}

	@Test
	public void testDecrementMarch1ToFeb28_NonLeapYear() {
	    DateUtil date = new DateUtil(1, 3, 2023);
	    date.decrement();
	    Assert.assertEquals(28, date.getDay());
	    Assert.assertEquals(2, date.getMonth());
	}

	// === Full Month Transition Tests ===

	@Test
	public void testMay31ToJune1() {
	    DateUtil date = new DateUtil(31, 5, 2024);
	    date.increment();
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	}

	@Test
	public void testJune30ToJuly1() {
	    DateUtil date = new DateUtil(30, 6, 2024);
	    date.increment();
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(7, date.getMonth());
	}

	@Test
	public void testSeptember30ToOctober1() {
	    DateUtil date = new DateUtil(30, 9, 2024);
	    date.increment();
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(10, date.getMonth());
	}

	@Test
	public void testNovember30ToDecember1() {
	    DateUtil date = new DateUtil(30, 11, 2024);
	    date.increment();
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(12, date.getMonth());
	}

	// === Year Boundary Validation ===

	@Test
	public void testValidLowerYearBoundary() {
	    DateUtil date = new DateUtil(1, 1, 1700);
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(1, date.getMonth());
	    Assert.assertEquals(1700, date.getYear());
	}

	@Test
	public void testValidUpperYearBoundary() {
	    DateUtil date = new DateUtil(31, 12, 3000);
	    Assert.assertEquals(31, date.getDay());
	    Assert.assertEquals(12, date.getMonth());
	    Assert.assertEquals(3000, date.getYear());
	}

	@Test(expected = RuntimeException.class)
	public void testInvalidYear_AboveUpperLimit() {
	    new DateUtil(1, 1, 3001);
	}

	// === Round Trip Tests ===

	@Test
	public void testIncrementThenDecrementReturnsSameDate() {
	    DateUtil date = new DateUtil(15, 8, 2024);
	    date.increment();
	    date.decrement();
	    Assert.assertEquals(15, date.getDay());
	    Assert.assertEquals(8, date.getMonth());
	    Assert.assertEquals(2024, date.getYear());
	}

	@Test
	public void testDecrementThenIncrementReturnsSameDate() {
	    DateUtil date = new DateUtil(1, 3, 2024); // Leap year, Feb has 29
	    date.decrement(); // → 29 Feb
	    date.increment(); // → back to 1 Mar
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(3, date.getMonth());
	    Assert.assertEquals(2024, date.getYear());
	}

}
