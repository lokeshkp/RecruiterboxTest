package com.makemytrip.flighTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.makemytrip.flightBase.MakeMyTripBase;
import com.makemytrip.flightPages.FlightBooking;

public class FlightBookingTest extends MakeMyTripBase {
	
	FlightBooking flight;
	
	public FlightBookingTest() {
		super();
	}
	
	@BeforeClass
	public void BaseTest() {
		browserInitilization();
		flight = new FlightBooking();
	}
	
	@Test()
	public void searchFlightsTest() throws InterruptedException {
		flight.selectTripType();
		flight.searchFlight("MAA", "RJA");
		
	}
	

	
	@AfterClass
	public void tearDown() {
		System.out.println("Hurry We are in Booking Page...");
		driver.quit();
	}
	
	
}