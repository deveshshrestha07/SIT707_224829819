package sit707_week6;

import org.junit.Test;
import static org.junit.Assert.*;

public class WeatherAndMathUtilsTest {

	@Test
	public void testStudentName() {
	    String studentName = "Devesh Shrestha";
	    assertEquals("Devesh Shrestha", studentName);
	}

	@Test
	public void testStudentID() {
	    String studentID = "224829819";
	    assertEquals("224829819", studentID);
	}

	@Test
	public void testDangerousWindSpeedOnly() {
	    assertEquals("DANGEROUS", WeatherAndMathUtils.weatherAdvice(75.0, 2.0));
	}

	@Test
	public void testDangerousPrecipitationOnly() {
	    assertEquals("DANGEROUS", WeatherAndMathUtils.weatherAdvice(30.0, 6.5));
	}

	@Test
	public void testDangerousBothConditions() {
	    assertEquals("DANGEROUS", WeatherAndMathUtils.weatherAdvice(46.0, 5.0));
	}

	@Test
	public void testWarningWindSpeedOnly() {
	    assertEquals("WARNING", WeatherAndMathUtils.weatherAdvice(50.0, 2.0));
	}

	@Test
	public void testWarningPrecipitationOnly() {
	    assertEquals("WARNING", WeatherAndMathUtils.weatherAdvice(30.0, 4.5));
	}

	@Test
	public void testAllClearCondition() {
	    assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(30.0, 2.0));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNegativeWindSpeed() {
	    WeatherAndMathUtils.weatherAdvice(-5.0, 2.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNegativePrecipitation() {
	    WeatherAndMathUtils.weatherAdvice(10.0, -1.0);
	}


	@Test
	public void testEvenNumber() {
	    assertTrue(WeatherAndMathUtils.isEven(10));
	}

	@Test
	public void testOddNumber() {
	    assertFalse(WeatherAndMathUtils.isEven(7));
	}
	@Test
	public void testPrimeNumber() {
	    assertTrue(WeatherAndMathUtils.isPrime(13));
	}

	@Test
	public void testNonPrimeNumber() {
	    assertFalse(WeatherAndMathUtils.isPrime(10));
	}

	@Test
	public void testNegativeNumber() {
	    assertFalse(WeatherAndMathUtils.isPrime(-3));
	}

	@Test
	public void testOneIsNotPrime() {
	    assertFalse(WeatherAndMathUtils.isPrime(1));
	}

	@Test
	public void testTwoIsPrime() {
	    assertTrue(WeatherAndMathUtils.isPrime(2));
	}
	@Test
	public void testAllClearEdgeCase() {
	    assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(44.0, 3.0));
	}
	@Test
	public void testConcerningBothConditions() {
	    assertEquals("DANGEROUS", WeatherAndMathUtils.weatherAdvice(46.0, 4.5));
	}


}