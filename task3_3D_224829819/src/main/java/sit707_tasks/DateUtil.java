package sit707_tasks;

public class DateUtil {

	private static String[] MONTHS = new String[] {
		"January", "February", "March", "April", "May", "June", 
		"July", "August", "September", "October", "November", "December"
	};

	private int day, month, year;

	public DateUtil(int day, int month, int year) {
		if (month < 1 || month > 12)
			throw new RuntimeException("Invalid month: " + month + " (must be 1–12)");

		if (year < 1700 || year > 3000)
			throw new RuntimeException("Invalid year: " + year + " (allowed range 1700–3000)");

		int maxDays = monthDuration(month, year);
		if (day < 1 || day > maxDays)
			throw new RuntimeException("Invalid day: " + day + " for month " + month + " (max: " + maxDays + ")");

		this.day = day;
		this.month = month;
		this.year = year;
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

	public void increment() {
		if (day < monthDuration(month, year)) {
			day++;
		} else if (month < 12) {
			day = 1;
			month++;
		} else {
			day = 1;
			month = 1;
			year++;
		}
	}

	public void decrement() {
		if (day > 1) {
			day--;
		} else if (month > 1) {
			month--;
			day = monthDuration(month, year);
		} else {
			month = 12;
			year--;
			day = monthDuration(month, year);
		}
	}

	public static int monthDuration(int month, int year) {
		switch (month) {
			case 2:
				return isLeapYear(year) ? 29 : 28;
			case 4: case 6: case 9: case 11:
				return 30;
			default:
				return 31;
		}
	}

	public static boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}

	@Override
	public String toString() {
		return day + " " + MONTHS[month - 1] + " " + year;
	}
}
