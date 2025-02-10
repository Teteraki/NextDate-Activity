
public class MyCalendar {
	private static final int[] MONTH_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // Days per month in a non-leap year.
	
	/**
	 * Takes the current date and moves to the next.
	 * @param date
	 * @return next date
	 */
	public MyDate nextDate(MyDate date) {
		// Get the values.
		int month = date.getMonth();
		int day = date.getDay();
		int year = date.getYear();
		
		checkIfValidDate(month, day, year);
		
		day++; // Increase day by 1, then handle if it rolls to next month or year.
		if (day > daysInMonth(month, year)) {
			day = 1;
			month++;
		} if (month > 12) {
			month = 1;
			year++;
		}
		
		checkIfValidDate(month, day, year);
		MyDate result = new MyDate(month, day, year);
		
		
		
		
		return new MyDate(month, day, year);
	}
	
	/**
	 * Check if the year is a regular or century leap year.
	 * @param year
	 * @return true or false
	 */
	private boolean isLeapYear(int year) {
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				return true;
			}
			return true;
		}
		return false;
	}
	

	private int daysInMonth(int month, int year) {
		int days = MONTH_DAYS[month - 1]; // Minus 1 so we get correct array element.
		if (month == 2 && isLeapYear(year)){
			days = 29;
		}
		
		return days;
		
	}
	
	
	private void checkIfValidDate(int month, int day, int year) {
		if (year < 1812 || year > 2012) {
            throw new OutOfRangeDate("Year must be between 1812 and 2012.");
        }
        if (month < 1 || month > 12) {
            throw new OutOfRangeDate("Month must be between 1 and 12.");
        }
        
        int daysInMonth = daysInMonth(month, year);
        
        if (day < 1 || day > daysInMonth) {
            throw new OutOfRangeDate("Day must be between 1 and " + daysInMonth + " for month " + month);
        }
	}
}
