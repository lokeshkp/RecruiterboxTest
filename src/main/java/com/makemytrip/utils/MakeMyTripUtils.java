package com.makemytrip.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.makemytrip.flightBase.MakeMyTripBase;

public class MakeMyTripUtils extends MakeMyTripBase{

	public MakeMyTripUtils() {
		super();
	}
	
	public void selectTomorrowDate() throws InterruptedException {
		driver.findElement(By.id("hp-widget__return")).click();
		 
		Date date = new Date();
		Calendar c = Calendar.getInstance();
 
		c.setTime(date);
		c.add(Calendar.DATE, 1);
 
		String strMonth = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
		//System.out.println(strMonth);
 
		String tommorowsDate = new SimpleDateFormat("MM/dd/yyyy").format(c.getTime());
		//System.out.println(tommorowsDate);
 
		Thread.sleep(2000);
 
		String strUIMonth = driver.findElements(By.xpath("//div[contains(@class,'dateFilter')][2]/div[contains(@class,'ui-datepicker-multi')]//span[contains(@class,'month')]")).get(0).getText();
 
		if (strMonth.equalsIgnoreCase(strUIMonth)) {
 
			/**
			 * Used 'following-sibling' to click on tomorrow's day (Edge-Cases)
			 */
			if (driver.findElements(By.xpath("//div[contains(@class,'dateFilter')][2]//td[contains(@class,'ui-datepicker-today') or contains(@class,'ui-datepicker-current')]/following-sibling::td[1]/a")).size() != 0) {
 
				/**
				 * Add this code to handle 'StaleElementReferenceException'
				 */
				boolean result = false;
				do {
					try {
						driver.findElement(By.xpath("//div[contains(@class,'dateFilter')][2]//td[contains(@class,'ui-datepicker-today') or contains(@class,'ui-datepicker-current')]/following-sibling::td[1]/a")).click();
					} catch (Exception e) {
						result = true;
					}
				} while (result);
			} else {
				/**
				 * If today's date show in the last colomn of calender
				 */
				List<WebElement> lstDate = driver.findElements(By.xpath("//div[contains(@class,'dateFilter')][1]/div[contains(@class,'ui-datepicker-multi')]/div[2]//a[@class='ui-state-default']"));
				for (int i = 0; i < lstDate.size(); i++) {
 
					// Get the day from the date
					if (lstDate.get(i).getText().trim()
							.equalsIgnoreCase((new SimpleDateFormat("d")).format(c.getTime()))) {
						lstDate.get(i).click();
					}
				}
			}
		} else {
			/**
			 * When given date is the ladt day of the month
			 */
			List<WebElement> lstDate = driver.findElements(By.xpath("//div[contains(@class,'dateFilter')][2]/div[contains(@class,'ui-datepicker-multi')]/div[2]//a[@class='ui-state-default']"));
			for (int i = 0; i < lstDate.size(); i++) {
				if (lstDate.get(i).getText().trim().equalsIgnoreCase("1")) {
					lstDate.get(i).click();
				}
			}
		}
	}	
}
