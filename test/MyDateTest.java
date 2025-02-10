import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class MyDateTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@ParameterizedTest
	@CsvFileSource(resources = "data.csv", numLinesToSkip = 1)
	void CSVFileValidTest(String day, String month, String year, String eDay, String eMonth, String eYear) {
		MyDate actualDate;
		MyDate expectedDate;
		
		MyDate mDate = new MyDate(Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year));
		expectedDate = new MyDate(Integer.parseInt(eDay), Integer.parseInt(eMonth), Integer.parseInt(eYear));
		
		MyCalendar myCalendar = new MyCalendar();
		
		actualDate = myCalendar.nextDate(mDate);
		
		assertEquals(expectedDate, actualDate);
	}
	
	
	@Test
	void testInvalidYear() {
		MyCalendar cal = new MyCalendar();
		MyDate date = new MyDate(1, 15, 2013);
		
		assertThrows(OutOfRangeDate.class, () -> cal.nextDate(date));
	}
	
	@Test
	void testInvalidMonthBefore1() {
		MyCalendar cal = new MyCalendar();
		MyDate date = new MyDate(0, 15, 2010);
		
		assertThrows(OutOfRangeDate.class, () -> cal.nextDate(date));
	}
	
	@Test
	void testInvalidMonthAfter12() {
		MyCalendar cal = new MyCalendar();
		MyDate date = new MyDate(13, 15, 2010);
		
		assertThrows(OutOfRangeDate.class, () -> cal.nextDate(date));
	}
	
	
	@Test
	void testInvalidDayBefore1() {
		MyCalendar cal = new MyCalendar();
		MyDate date = new MyDate(1, 0, 2010);
		
		assertThrows(OutOfRangeDate.class, () -> cal.nextDate(date));
	}
	
	@Test
	void testInvalidDayAfter31() {
		MyCalendar cal = new MyCalendar();
		MyDate date = new MyDate(1, 32, 2010);
		
		assertThrows(OutOfRangeDate.class, () -> cal.nextDate(date));
	}
	
	@Test
	void invalidRollOverYearOutsideCalendarRange() {
		MyCalendar cal = new MyCalendar();
		MyDate date = new MyDate(12, 31, 2012);
		
		assertThrows(OutOfRangeDate.class, () -> cal.nextDate(date));
	}
	
	@Test
	void rollOverToNextYear() {
		MyCalendar cal = new MyCalendar();
		MyDate date = new MyDate(12, 31, 2010);
		
		MyDate actual = cal.nextDate(date);
		MyDate expected = new MyDate(1, 1, 2011);
		
		assertEquals(expected, actual);	
	}
	
	
	@Test
	void months31DaysRollOver() {
		MyCalendar cal = new MyCalendar();
		MyDate date = new MyDate(1, 31, 2010);
		
		MyDate actual = cal.nextDate(date);
		MyDate expected = new MyDate(2, 1, 2010);
		
		assertEquals(expected, actual);
		
		
	}
	
	@Test
	void months30DaysRollOver() {
		MyCalendar cal = new MyCalendar();
		MyDate date = new MyDate(4, 30, 2010);
		
		MyDate actual = cal.nextDate(date);
		MyDate expected = new MyDate(5, 1, 2010);
		
		assertEquals(expected, actual);
		
	}

}
