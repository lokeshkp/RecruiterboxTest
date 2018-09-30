package com.makemytrip.flightPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.makemytrip.flightBase.MakeMyTripBase;
import com.makemytrip.utils.MakeMyTripUtils;

public class FlightBooking extends MakeMyTripBase{
	
	MakeMyTripUtils utils;
	
	@FindBy(xpath ="//div[@class='switchBTN']//label[contains(text(),'round trip')]") WebElement tripType;	
	@FindBy(xpath ="//input[@id='hp-widget__sfrom']") WebElement FROM;	
	@FindBy(xpath ="//input[@id='hp-widget__sTo']") WebElement TO;	
	@FindBy(xpath ="//td[contains(@class, 'ui-datepicker-today')]") WebElement depDate;	
	@FindBy(xpath ="//td[contains(@class, 'maxDate')]") WebElement retDate;	
	@FindBy(xpath ="//button[@id='searchBtn']") WebElement search;
	
	
	@FindBy(xpath ="//a[contains(@class,'last active')]//span") WebElement priceSort;	
	@FindBy(xpath ="//*[@id=\"content\"]/div/div[3]/div[4]/div[2]/div[2]/div[1]/div[1]/div[2]/div/div/div[1]") WebElement selectFistFlight;
	@FindBy(xpath ="//a[text()='Book']") WebElement Book;
	
	
	
	@FindBy(xpath ="//input[@placeholder='Enter Email Address']") WebElement email;
	@FindBy(xpath ="//a[text()='Continue as Guest']") WebElement continueAsGuest;
	@FindBy(xpath ="//span//input[@placeholder='First Name']") WebElement firstName;
	@FindBy(xpath ="//span//input[@placeholder='Last Name']") WebElement lastName;
	@FindBy(xpath ="//input[@placeholder='Mobile Number']") WebElement mobile;
	@FindBy(xpath ="//a[text()='Continue']") WebElement continueButton;
	@FindBy(xpath ="//a[text()='MALE']") WebElement gender;
	
	
	
	
	
	public FlightBooking() {
		PageFactory.initElements(driver, this);
		utils = new MakeMyTripUtils();
	}
	
	public void selectTripType() {
		tripType.click();
	}
	
	public void searchFlight(String fromValue, String toValue) throws InterruptedException {
		FROM.clear();
		FROM.sendKeys(fromValue);
		Thread.sleep(2000);
		FROM.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		TO.sendKeys(toValue);
		Thread.sleep(2000);
		TO.sendKeys(Keys.ENTER);
		depDate.click();
		Thread.sleep(2000);
		utils.selectTomorrowDate();
		search.click();
	}
	
	
	public void selectLowCostFilght() throws InterruptedException {
		
		String sortRes = priceSort.getAttribute("class");		
		if(sortRes.contains("order down_arrow")) {
			priceSort.click();
			Thread.sleep(2000);
			priceSort.click();
			
		}else {
			selectFistFlight.click();
			Thread.sleep(2000);
			selectFistFlight.click();
			Thread.sleep(2000);
			Book.click();
		}
	}

	public void fillPassengerInfo() throws InterruptedException {
		 
		JavascriptExecutor js = (JavascriptExecutor) driver; 		
		js.executeScript("arguments[0].scrollIntoView(true);",email);		
		email.sendKeys("kplokesh@abc.com");	
		Thread.sleep(15000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(continueAsGuest));		
		continueAsGuest.click();	
		firstName.sendKeys("Lokesh");	
		lastName.sendKeys("Kondepudi");	
		mobile.sendKeys("9900465757");	
		gender.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(continueButton));		
		continueButton.click();
		Thread.sleep(2000);
		continueButton.click();		
	}
	
	public void bookingSummaryTest() throws InterruptedException {
		Thread.sleep(4000);
		String pageTitle = driver.getTitle();
		Thread.sleep(2000);
		Assert.assertEquals(pageTitle, "MakeMytrip Payment : Safe and Secure");
	}
	
}
