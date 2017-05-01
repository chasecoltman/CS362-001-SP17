package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	//Tests the creation of the Gregorian Calendar and verifies that values are set
	 @Test
	  public void test01()  throws Throwable  {
			int day = 28;
		 	int month = 4;
		 	int year = 2017;
			GregorianCalendar cal = new GregorianCalendar();
			cal.set(year, month, day);
			CalDay calday = new CalDay(cal);

	 		assertEquals(28, calday.getDay());
			assertEquals(4, calday.getMonth());
			assertEquals(2017, calday.getYear());
	 }
	@Test
	public void test02() 	throws Throwable {
	 	GregorianCalendar cal = new GregorianCalendar();
		cal.set(2017, 01, 28);
		CalDay calday = new CalDay(cal);
		int daysDifference = 0;
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		int startHour=13;
		int startMinute=30;
		int startDay=10;
		int startMonth=4;
		int startYear=2017;
		String title="Birthday Party";
		String description="This is my birthday party.";
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		calday.addAppt(appt);
		assertEquals(calday.getSizeAppts(), 1);
		assertNotNull(calday.getAppts());
		assertTrue(calday.isValid());
		assertNotEquals(calday.toString(), "01/01/1111");
	}
	@Test
	public void test03(){
	 	GregorianCalendar cal = new GregorianCalendar();
	 	CalDay calday = new CalDay();
		assertFalse(calday.isValid());


	}
}
