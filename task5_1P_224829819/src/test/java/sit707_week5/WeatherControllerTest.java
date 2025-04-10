package sit707_week5;

import org.junit.*;
import java.util.*;

public class WeatherControllerTest {

    private static WeatherController wController;
    private static List<Double> hourlyTemperatures;

    @BeforeClass
    public static void setUpClass() {
        // Arrange: Set up shared WeatherController and cache all hourly temps
        wController = WeatherController.getInstance();
        int nHours = wController.getTotalHours();
        hourlyTemperatures = new ArrayList<>();

        for (int i = 0; i < nHours; i++) {
            double temp = wController.getTemperatureForHour(i + 1);
            hourlyTemperatures.add(temp);
        }
    }

    @AfterClass
    public static void tearDownClass() {
        // After: Clean up resources
        wController.close();
    }

    @Test
    public void testStudentIdentity() {
        // Arrange
        String studentId = "221234567"; // ✅ Replace this with your real Deakin ID

        // Assert
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        // Arrange
        String studentName = "Devesh Shrestha";

        // Assert
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testTemperatureMin() {
        System.out.println("+++ testTemperatureMin +++");

        // Act
        double expectedMin = Collections.min(hourlyTemperatures);
        double actualMin = wController.getTemperatureMinFromCache();

        // Assert
        Assert.assertEquals(expectedMin, actualMin, 0.01);
    }

    @Test
    public void testTemperatureMax() {
        System.out.println("+++ testTemperatureMax +++");

        // Act
        double expectedMax = Collections.max(hourlyTemperatures);
        double actualMax = wController.getTemperatureMaxFromCache();

        // Assert
        Assert.assertEquals(expectedMax, actualMax, 0.01);
    }

    @Test
    public void testTemperatureAverage() {
        System.out.println("+++ testTemperatureAverage +++");

        // Act
        double sum = 0.0;
        for (double temp : hourlyTemperatures) {
            sum += temp;
        }
        double expectedAvg = sum / hourlyTemperatures.size();
        double actualAvg = wController.getTemperatureAverageFromCache();

        // Assert
        Assert.assertEquals(expectedAvg, actualAvg, 0.01);
    }
}
