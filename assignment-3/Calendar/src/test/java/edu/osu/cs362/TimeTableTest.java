package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {
	//Testing the method of getApptRange
	@Test
	public void test01()  throws Throwable {
		int startHour = 13;
		int startMinute = 30;
		int startDay = 10;
		int startMonth = 4;
		int startYear = 2017;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		String title2 = "Grocery Shopping";
		String description2 = "Buying groceries";
		String titleFake = null;
		String descriptionFake = null;
		//Construct a new Appointment object with the initial data
		Appt appt1 = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);
		Appt appt2 = new Appt(startHour + 1,
				startMinute + 1,
				startDay + 1,
				startMonth + 1,
				startYear,
				title2,
				description2);
		GregorianCalendar cal = new GregorianCalendar();
		GregorianCalendar cal2 = new GregorianCalendar();
		cal.set(2017, 01, 28);
		CalDay calday = new CalDay(cal);
		TimeTable timeTest = new TimeTable();
		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.addFirst(appt1);
		appts.add(appt2);
		timeTest.getApptRange(appts, cal, cal2);



	}
	//Testing the method of deleteAppt
	@Test
	public void test02(){
		int startYear = 2017;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		Appt apptNull = null;
		Appt appt1 = new Appt(1, 1, 1, 1, startYear,	title, description);
		Appt appt2 = new Appt(1, 1, 12, 1, startYear, "Appointment 2", "Adding a test appointment");
		Appt appt3 = new Appt(2,2,12,1,startYear,"Appointment 3", "Adding a test appointment");
		Appt appt4 = new Appt(2,3,14,1,startYear, "Appointment 4", "Adding a test appointment");

		GregorianCalendar calFirst = new GregorianCalendar();
		calFirst.set(2017, 01, 01);
		GregorianCalendar calLast = new GregorianCalendar();
		calLast.set(2017, 01, 30);
		CalDay calday = new CalDay(calFirst);
		LinkedList<Appt> appts = new LinkedList<Appt>();
		TimeTable testTable = new TimeTable();
		testTable.deleteAppt(appts, null);
		appts.add(appt1);
		appts.add(appt2);
		appts.add(appt3);

		testTable.getApptRange(appts, calFirst, calLast);
		//	testTable.getApptRange(appts, calLast, calFirst);
		testTable.deleteAppt(appts, appt4);
		testTable.deleteAppt(appts, appt1);
	}

}


