package sit707_week5;

import org.junit.Assert;
import org.junit.Test;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class WeatherControllerTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "224829819";  // Replace with your actual ID
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Devesh Shrestha";  // Replace with your full name
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testTemperatureMin() {
        System.out.println("+++ testTemperatureMin +++");
        WeatherController controller = WeatherController.getInstance();
        int nHours = controller.getTotalHours();
        double minTemperature = 1000;
        for (int i = 0; i < nHours; i++) {
            double temp = controller.getTemperatureForHour(i + 1);
            if (minTemperature > temp) minTemperature = temp;
        }
        Assert.assertEquals(minTemperature, controller.getTemperatureMinFromCache(), 0.001);
        controller.close();
    }

    @Test
    public void testTemperatureMax() {
        System.out.println("+++ testTemperatureMax +++");
        WeatherController controller = WeatherController.getInstance();
        int nHours = controller.getTotalHours();
        double maxTemperature = -1;
        for (int i = 0; i < nHours; i++) {
            double temp = controller.getTemperatureForHour(i + 1);
            if (maxTemperature < temp) maxTemperature = temp;
        }
        Assert.assertEquals(maxTemperature, controller.getTemperatureMaxFromCache(), 0.001);
        controller.close();
    }

    @Test
    public void testTemperatureAverage() {
        System.out.println("+++ testTemperatureAverage +++");
        WeatherController controller = WeatherController.getInstance();
        int nHours = controller.getTotalHours();
        double sum = 0;
        for (int i = 0; i < nHours; i++) {
            sum += controller.getTemperatureForHour(i + 1);
        }
        double average = sum / nHours;
        Assert.assertEquals(average, controller.getTemperatureAverageFromCache(), 0.001);
        controller.close();
    }

    @Test
    public void testTemperaturePersist() {
        System.out.println("+++ testTemperaturePersist +++");
        WeatherController controller = WeatherController.getInstance();
        LocalDateTime fixedTime = LocalDateTime.of(2023, 10, 1, 14, 30, 0);
        Clock fixedClock = Clock.fixed(fixedTime.atZone(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
        controller.setClock(fixedClock);
        String persistedTime = controller.persistTemperature(2, 19.5);
        String expectedTime = fixedTime.format(DateTimeFormatter.ofPattern("H:m:s"));
        Assert.assertEquals(expectedTime, persistedTime);
        controller.close();
    }

    @Test
    public void testPersistedTimeFormat() {
        WeatherController controller = WeatherController.getInstance();
        LocalDateTime fixedTime = LocalDateTime.of(2023, 12, 1, 9, 15, 45);
        Clock fixedClock = Clock.fixed(fixedTime.atZone(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
        controller.setClock(fixedClock);
        String persistedTime = controller.persistTemperature(1, 25.0);
        Assert.assertTrue(persistedTime.matches("\\d{1,2}:\\d{1,2}:\\d{1,2}"));
        controller.close();
    }

    @Test
    public void testTemperatureOutOfRangeHour() {
        WeatherController controller = WeatherController.getInstance();
        double temp = controller.getTemperatureForHour(100);  // invalid hour
        Assert.assertTrue(temp >= 1 && temp <= 30);
        controller.close();
    }

    @Test
    public void testControllerSingleton() {
        WeatherController c1 = WeatherController.getInstance();
        WeatherController c2 = WeatherController.getInstance();
        Assert.assertSame(c1, c2);
        c1.close();
    }

    @Test
    public void testGetTemperatureForHourValidRange() {
        WeatherController controller = WeatherController.getInstance();
        for (int hour = 1; hour <= controller.getTotalHours(); hour++) {
            double temp = controller.getTemperatureForHour(hour);
            Assert.assertTrue(temp >= 1 && temp <= 30);
        }
        controller.close();
    }

    @Test
    public void testCloseResetsControllerInstance() {
        WeatherController c1 = WeatherController.getInstance();
        c1.close();
        WeatherController c2 = WeatherController.getInstance();
        Assert.assertNotSame(c1, c2);
        c2.close();
    }

    @Test
    public void testPersistTemperatureMultipleCallsFixedClock() {
        WeatherController controller = WeatherController.getInstance();
        LocalDateTime fixedTime = LocalDateTime.of(2024, 5, 1, 12, 0, 0);
        Clock fixedClock = Clock.fixed(fixedTime.atZone(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
        controller.setClock(fixedClock);
        String t1 = controller.persistTemperature(1, 18.5);
        String t2 = controller.persistTemperature(2, 21.0);
        Assert.assertEquals(t1, t2);
        controller.close();
    }

    @Test
    public void testTemperatureAveragePrecision() {
        WeatherController controller = WeatherController.getInstance();
        int nHours = controller.getTotalHours();
        double sum = 0;
        for (int i = 1; i <= nHours; i++) {
            sum += controller.getTemperatureForHour(i);
        }
        double expectedAvg = sum / nHours;
        Assert.assertEquals(expectedAvg, controller.getTemperatureAverageFromCache(), 0.001);
        controller.close();
    }

    @Test
    public void testGetTotalHoursIsConstant() {
        WeatherController controller = WeatherController.getInstance();
        Assert.assertEquals(WeatherController.HOURS_PER_DAY, controller.getTotalHours());
        controller.close();
    }

    @Test
    public void testClockSetToNullFallback() {
        WeatherController controller = WeatherController.getInstance();
        controller.setClock(null);  // should fallback to system clock
        String time = controller.persistTemperature(1, 25.0);
        Assert.assertNotNull("Time should still be generated", time);
        controller.close();
    }
}
