package sit707_week5;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Random;

public class WeatherController {

    public static final int HOURS_PER_DAY = 3;

    private static WeatherController instance;

    // Clock instance for controllable time (used for testing)
    private Clock clock = Clock.systemDefaultZone(); // default system clock

    public void setClock(Clock clock) {
        if (clock != null) {
            this.clock = clock;
        } else {
            this.clock = Clock.systemDefaultZone(); // fallback to default clock
        }
    }


    public static WeatherController getInstance() {
        if (instance == null) {
            instance = new WeatherController();
        }
        return instance;
    }

    private static double[] todaysHourlyTemperature = new double[HOURS_PER_DAY];

    private WeatherController() {
        System.out.println("Creating new weather controller.");

        sleep(2 + new Random().nextInt(5));

        Random random = new Random();
        for (int i = 0; i < HOURS_PER_DAY; i++) {
            todaysHourlyTemperature[i] = 1 + random.nextInt(30);
        }
        System.out.println(Arrays.toString(todaysHourlyTemperature));
    }

    public void close() {
        System.out.println("Closing weather controller.");
        instance = null;

        sleep(2 + new Random().nextInt(5));
    }

    public double getTemperatureMinFromCache() {
        double minVal = 1000;
        for (double val : todaysHourlyTemperature) {
            if (minVal > val) minVal = val;
        }
        return minVal;
    }

    public double getTemperatureMaxFromCache() {
        double maxVal = -1;
        for (double val : todaysHourlyTemperature) {
            if (maxVal < val) maxVal = val;
        }
        return maxVal;
    }

    public double getTemperatureAverageFromCache() {
        double sumVal = 0;
        for (double val : todaysHourlyTemperature) {
            sumVal += val;
        }
        return sumVal / todaysHourlyTemperature.length;
    }

    public double getTemperatureForHour(int hour) {
        sleep(1 + new Random().nextInt(5));

        if (hour > todaysHourlyTemperature.length) {
            hour = 1 + new Random().nextInt(todaysHourlyTemperature.length);
        }

        return todaysHourlyTemperature[hour - 1];
    }

    public String persistTemperature(int hour, double temperature) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("H:m:s");
        String savedTime = LocalDateTime.now(clock).format(dtf);
        System.out.println("Temperature: " + temperature + " of hour: " + hour + ", saved at " + savedTime);

        sleep(1 + new Random().nextInt(2));

        return savedTime;
    }

    public int getTotalHours() {
        return todaysHourlyTemperature.length;
    }

    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
