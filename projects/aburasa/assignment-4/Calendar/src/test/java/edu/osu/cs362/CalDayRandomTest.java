package edu.osu.cs362;


import org.junit.Test;

import java.util.Calendar;
import java.util.Random;
import static org.junit.Assert.*;
import java.util.GregorianCalendar;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=3000;
	/**
	 * Generate Random Tests that tests CalDay Class.
	 */

	public static String RandomSelectMethod(Random random){
		String[] methodArray = new String[]{"setAppt",
				"setApptAfter",
				"setApptBefore",
				"setFakeAppt"};

		int n = random.nextInt(methodArray.length);

		return methodArray[n];
	}

	@Test
	public void radnomtest()  throws Throwable  {
		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		System.out.println("Start testing...");

		for (int iteration = 0; elapsed < TestTimeout; iteration++) {
			long randomseed = 4342;//System.currentTimeMillis();
			//			System.out.println(" Seed:"+randomseed );
			Random random = new Random(randomseed);
			int startHour=13;
			int startMinute=30;
			int startDay=10;
			int startMonth=4;
			int startYear=2017;
			String title="Birthday Party";
			String description="This is my birthday party.";
			//Construct a new Appointment object with the initial data
			Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
			Appt fakeAppt = new Appt(13, 67, 52, 15, 90909043, null, null);
			Appt apptLater = new Appt(14, 30, startDay, startMonth , startYear , title, description);
			Appt apptBefore = new Appt(12, 30, startDay, startMonth , startYear , title, description);

			Appt apptHourNeg = new Appt(-1, startMinute, startDay, startMonth, startYear, title, description);
			Appt apptMinuteNeg = new Appt(startHour, -1, startDay, startMonth, startYear, title, description);
			Appt apptDayNeg = new Appt(startHour, startMinute, -1, startMonth, startYear, title, description);
			Appt apptMonthNeg = new Appt(startHour, startMinute, startDay, -1, startYear, title, description);


			for (int i = 0; i < NUM_TESTS; i++){
				String methodName = CalDayRandomTest.RandomSelectMethod(random);
				if (methodName.equals("setAppt")){
					GregorianCalendar cal = new GregorianCalendar();
					cal.set(2017, 05, 25);
					CalDay calday = new CalDay(cal);
					calday.addAppt(appt);
				}
				if(methodName.equals("setApptAfter")){
					GregorianCalendar cal = new GregorianCalendar();
					cal.set(2017, 05, 25);
					CalDay calday = new CalDay(cal);
					calday.addAppt(appt);
					calday.addAppt(apptLater);
				}
				if(methodName.equals("setApptBefore")){
					GregorianCalendar cal = new GregorianCalendar();
					cal.set(2017, 05, 25);
					CalDay calday = new CalDay(cal);
					calday.addAppt(appt);
					calday.addAppt(apptBefore);
				}
				if(methodName.equals("setFakeAppt")){
					GregorianCalendar cal = new GregorianCalendar();
					cal.set(2017, 05, 25);
					CalDay calday = new CalDay(cal);
					calday.addAppt(fakeAppt);
				}
				if(methodName.equals("setHourNeg")) {
					GregorianCalendar cal = new GregorianCalendar();
					cal.set(2017, 05, 25);
					CalDay calday = new CalDay(cal);
					calday.addAppt(apptHourNeg);
				}
			}

			elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			if((iteration%10000)==0 && iteration!=0 )
				System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

		}


		System.out.println("Done testing...");
	}
}




