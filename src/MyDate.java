

/**
 * Custom date class.
 */
public class MyDate {
	private int month;
	private int day;
	private int year;
	
	/**
	 * 
	 * @param m MONTH
	 * @param d	DAY
	 * @param y	YEAR
	 */
	public MyDate (int m, int d, int y) {
		this.month = m;
		this.day = d;
		this.year = y;
	}
	
	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyDate other = (MyDate) obj;
		return day == other.day && month == other.month && year == other.year;
	}
}