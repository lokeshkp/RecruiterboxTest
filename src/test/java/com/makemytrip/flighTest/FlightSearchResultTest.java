package com.makemytrip.flighTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.makemytrip.flightBase.MakeMyTripBase;

public class FlightSearchResultTest extends MakeMyTripBase {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		String cwd = System.getProperty("user.dir");
		String profFile = cwd + "\\src\\main\\java\\com\\makemytrip\\config\\config.properties"; 
		System.out.println(profFile);
		prop = new Properties();
		FileInputStream fis = new FileInputStream(profFile);
		prop.load(fis);
		
		System.setProperty("webdriver.chrome.driver", "/Users/lokes/eclipse-workspace/RecruiterboxTestLOK/src/main/java/browsers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://flights.makemytrip.com/makemytrip/review/R/R/E/1/0/0/BLR_DEL_26-09-2018,DEL_BLR_27-09-2018/0-false-5938-5990-true-false%7CBLR-DEL-6E-6E-2484-false-true-false-1537984800000-1537995000000-4997-0-0-722-N0IP2484-N-6EUNI:0-false-4493-4545-true-false%7CDEL-BLR-6E-6E-2977-false-true-false-1538068200000-1538078100000-3672-0-0-658-P0IP2977-P-6EUNI/1471c3c0c71%7C5a25%7Cb7a4%7C59ea%7C2d865cd4/odc/asyncResponsiveReview#/review");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter Email Address']")).sendKeys("kplokesh@abc.com");
		
		//String privacyPolicy = driver.findElement(By.xpath("//span[contains(@class, 'checkbox_state')]")).getAttribute("class");
		
		driver.findElement(By.xpath("//a[text()='Continue as Guest']")).click();
		
		/*
		try {
			String val = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			driver.findElement(By.xpath("//span[contains(@class, 'checkbox_state')]")).click();
			driver.findElement(By.xpath("//a[text()='Continue as Guest']")).click();
		}catch(Exception e) {
			e.getStackTrace();
		}*/
		
		driver.findElement(By.xpath("//span//input[@placeholder='First Name']")).sendKeys("Lokesh");		
		driver.findElement(By.xpath("//span//input[@placeholder='Last Name']")).sendKeys("Kondepudi");
		driver.findElement(By.xpath("//input[@placeholder='Mobile Number']")).sendKeys("9900343344");
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
		

	}

}
