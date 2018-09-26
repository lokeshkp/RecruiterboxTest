package com.makemytrip.flightPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.makemytrip.flightBase.MakeMyTripBase;

public class FlightSearchResult extends MakeMyTripBase {
	

	@FindBy(xpath ="//a[contains(@class,'last active')]//span") WebElement priceSort;	
	@FindBy(xpath ="//*[@id=\\\"content\\\"]/div/div[3]/div[4]/div[2]/div[2]/div[1]/div[1]/div[2]/div/div/div[1]") WebElement selectFistFlight;	
	@FindBy(xpath ="//a[text()='Book']") WebElement Book;
	
	public void filterLowCostFilght() throws InterruptedException {
	
		//String arrowRes = driver.findElement(By.xpath("//a[contains(@class,'last active')]//span")).getAttribute("class");
		String sortRes = priceSort.getAttribute("class");
		
		if(sortRes.contains("order down_arrow")) {
			priceSort.click();
			Thread.sleep(2000);
			priceSort.click();
			
		}else {
			selectFistFlight.click();
			selectFistFlight.click();
			Book.click();
		}
	}
}
