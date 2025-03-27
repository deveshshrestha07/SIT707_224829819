package sit707_tasks;

public class DateUtil {

    private int day;
    private int month;
    private int year;

    public DateUtil(int day, int month, int year) {
        if (!isValidDate(day, month, year)) {
            throw new RuntimeException("Invalid date: " + day + "/" + month + "/" + year);
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void increment() {
        day++;
        if (!isValidDate(day, month, year)) {
            // Reset day and increment month
            day = 1;
            month++;
            if (month > 12) {
                month = 1;
                year++;
                if (year > 2024) {
                    throw new RuntimeException("Year out of supported range after increment.");
                }
            }
        }
    }

    public void decrement() {
        day--;
        if (day < 1) {
            // Decrement month and adjust day
            month--;
            if (month < 1) {
                month = 12;
                year--;
                if (year < 1700) {
                    throw new RuntimeException("Year out of supported range after decrement.");
                }
            }
            day = getDaysInMonth(month, year);
        }
    }

    private boolean isValidDate(int day, int month, int year) {
        if (month < 1 || month > 12) return false;
        if (year < 1700 || year > 2024) return false;
        return day >= 1 && day <= getDaysInMonth(month, year);
    }

    private int getDaysInMonth(int month, int year) {
        switch (month) {
            case 2:
                return isLeapYear(year) ? 29 : 28;
            case 4: case 6: case 9: case 11:
                return 30;
            default:
                return 31;
        }
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }
}
