package edu.osu.cs362;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import java.util.Random;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS = 3000;

	public static String RandomSelectMethod(Random random) {
		String[] methodArray = new String[]{"testDelete",
		"testDeleteFake",
		"testDeleteNothing",
		"testDeleteNull",
		"testDeleteNullAppt"};

		int n = random.nextInt(methodArray.length);

		return methodArray[n];
	}


	@Test
	public void radnomtest() throws Throwable {
		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		System.out.println("Start testing...");

		for (int iteration = 0; elapsed < TestTimeout; iteration++) {
			long randomseed = 4342;
			//System.currentTimeMillis();
			//			System.out.println(" Seed:"+randomseed );
			Random random = new Random(randomseed);
			int startHour = 13;
			int startMinute = 30;
			int startDay = 10;
			int startMonth = 4;
			int startYear = 2017;
			String title = "Birthday Party";
			String description = "This is my birthday party.";

			GregorianCalendar cal = new GregorianCalendar();
			GregorianCalendar cal2 = new GregorianCalendar();
			cal.set(2017, 01, 28);
			CalDay calday = new CalDay(cal);
			TimeTable timeTest = new TimeTable();
			LinkedList<Appt> appts = new LinkedList<Appt>();

			Appt appt1 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
			Appt appt2 = new Appt(startHour + 1, startMinute + 1, startDay + 1, startMonth + 1, startYear, title, description);
			Appt apptFake = new Appt(13, 67, 52, 15, 90909043, null, null);
			appts.add(appt1);
			appts.add(appt2);
			for (int i = 0; i < NUM_TESTS; i++) {
				String methodName = TimeTableRandomTest.RandomSelectMethod(random);
				if (methodName.equals("testDelete")) {
					appts.add(appt1);
					appts.add(appt2);
					timeTest.deleteAppt(appts, appt2);
					timeTest.deleteAppt(appts, appt1);
				}
				if (methodName.equals("testDeleteFake")) {
					appts.add(apptFake);
					timeTest.deleteAppt(appts, apptFake);
				}
				if(methodName.equals("testDeleteNothing")) {
					appts.add(appt1);
					timeTest.deleteAppt(appts, appt2);
				}
				if(methodName.equals("testDeleteNull")) {
					timeTest.deleteAppt(null, appt1);
				}
				if(methodName.equals("testDeleteNullAppt")){
					timeTest.deleteAppt(appts, null);
				}

			}
			elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			if((iteration%10000)==0 && iteration!=0 )
				System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

		}
		System.out.println("Done testing...");
	}
}
