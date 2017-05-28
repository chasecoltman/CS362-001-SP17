package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
    //Testing accessor functions
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=13;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=4;
		 int startYear=2017;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(13, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(10, appt.getStartDay());
		 assertEquals(04, appt.getStartMonth());
		 assertEquals(2017, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }

	 //Testing getValid for all options
	@Test
	public void test02(){
		int startHourFalse=100;
		int startDayFalse = 100;
		int startMonthFalse = 100;
		int startMinuteFalse = 100;
		int startMonth = 1;
		int startHour = 1;
		int startMinute = 1;
		int startDay = 1;
		int startYear=2017;
		String title="Birthday Party";
		String description="This is my birthday party.";
		Appt fakeHour = new Appt(startHourFalse, startMinute, startDay, startMonth, startYear, title, description);
		Appt fakeMinute = new Appt(startHour, startMinuteFalse, startDay, startMonth, startYear, title, description);
		Appt fakeDay = new Appt(startHour, startMinute, startDayFalse, startMonth, startYear, title, description);
		Appt fakeMonth = new Appt(startHour, startMinute, startDay, startMonthFalse, startYear, title, description);
		assertFalse(fakeHour.getValid());
		assertFalse(fakeMinute.getValid());
		assertFalse(fakeMonth.getValid());
		assertFalse(fakeDay.getValid());
	}


	//Testing the mutator functions
	@Test
	public void test03(){
		int startHour=13;
		int startMinute=30;
		int startDay=10;
		int startMonth=4;
		int startYear=2017;
		String title="Birthday Party";
		String description="This is my birthday party.";
		String titleFake = null;
		String descriptionFake = null;
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);

		appt.setStartDay(12);
		appt.setStartMonth(12);
		appt.setStartHour(12);
		appt.setStartMinute(12);
		appt.setStartYear(1990);
		appt.setDescription(titleFake);
		appt.setTitle(descriptionFake);
		assertEquals(appt.getStartDay(), 12);
		assertEquals(appt.getStartMonth(), 12);
		assertEquals(appt.getStartHour(), 12);
		assertEquals(appt.getStartMinute(), 12);
		assertEquals(appt.getStartYear(), 1990);
		assertEquals(appt.getDescription(), "");
		assertEquals(appt.getTitle(), "");

	}
}
