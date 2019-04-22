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
	
	@FindBy(xpath ="//div[@class='makeFlex']//li[contains(text(),'Round')]") WebElement tripType;	
	@FindBy(xpath ="//input[@id='fromCity']") WebElement FROM;
	@FindBy(xpath ="//input[@placeholder='From']") WebElement fromPlace;
	@FindBy(xpath ="//input[@placeholder='To']") WebElement toPlace;
		
	//@FindBy(xpath ="//input[@id='departure']") WebElement depDate;
	@FindBy(xpath ="//div[contains(@class, 'today')]") WebElement toDay;	
	@FindBy(xpath ="//div[contains(@class, 'reDates')]") WebElement retDate;	
	@FindBy(xpath ="//a[text()='Search']") WebElement search;
	
	
	@FindBy(xpath ="//a[contains(@class,'last active')]//span") WebElement priceSort;	
	@FindBy(xpath ="//*[@id=\"content\"]/div/div[3]/div[4]/div[2]/div[2]/div[1]/div[1]/div[2]/div/div/div[1]") WebElement selectFistFlight;
	@FindBy(xpath ="//a[text()='Book']") WebElement Book;
	
	
	
	@FindBy(xpath ="//input[@placeholder='Enter Email Address']") WebElement email;
	@FindBy(xpath ="//a[text()='Continue as Guest']") WebElement continueAsGuest;
	@FindBy(xpath ="//span//input[@placeholder='First Name']") WebElement firstName;
	@FindBy(xpath ="//span//input[@placeholder='Last Name']") WebElement lastName;
	@FindBy(xpath ="//input[@placeholder='Mobile Number']") WebElement mobile;
	@FindBy(xpath ="//a[text()='Continue']") WebElement continueButton;
	@FindBy(xpath ="//a[text()='Skip add-ons']") WebElement skipAddOns;
	@FindBy(xpath ="//a[text()='MALE']") WebElement gender;
	
	
	
	
	
	public FlightBooking() {
		PageFactory.initElements(driver, this);
		utils = new MakeMyTripUtils();
	}
	
	public void selectTripType() {
		tripType.click();
	}
	
	public void searchFlight(String fromValue, String toValue) throws InterruptedException {
		FROM.click();
		Thread.sleep(1000);
		fromPlace.sendKeys(fromValue);
		Thread.sleep(1000);
		fromPlace.sendKeys(Keys.DOWN);
		fromPlace.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		toPlace.sendKeys(toValue);
		Thread.sleep(1000);
		toPlace.sendKeys(Keys.DOWN);
		toPlace.sendKeys(Keys.ENTER);
		
		//depDate.click();
		Thread.sleep(1000);
		toDay.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(@class,'DayPicker-Month')][1]//div[contains(@class,'today') or contains(@class,'ui-datepicker-current')]/following-sibling::div[2]")).click();
		//utils.selectTomorrowDate();
		search.click();
	}
	
}
