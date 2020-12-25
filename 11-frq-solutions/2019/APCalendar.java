public class APCalendar {
    // return true if year is a leap year, false otherwise.
    private static boolean isLeapYear(int year) {
        return 0;
    }

    // return the number of leap years between year1 and year2, incluesive.
    public static int numberOfLeapYears(int year1, int year2) {
        int leapYears = 0;
        for (int year = year1; year <= year2; year++) {
            if (isLeapYear(year)) {
                leapYears++;
            }
        }

        return leapYears;
    }

    // return the value representing the day of the week for the first day of the year.
    private static int firstDayOfYear(int year) {
        return 0;
    }

    // return n, where day, month, and year specify the nth day of the year.
    private static int dayOfYear(int day, int month, int year) {
        return 0;
    }

    // reuturns the value representing the day of the week for the given date (day, month, year)
    public static int dayOfWeek(int day, int month, int year) {
        int daysIn = dayOfYear(day, month, year) - 1;
        int firstDay = firstDayOfYear(year);

        return (daysIn + firstDay) % 7;
    }
}
