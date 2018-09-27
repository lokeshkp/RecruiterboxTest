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
		
		driver.get("https://flights.makemytrip.com/makemytrip/review/R/R/E/1/0/0/BLR_DEL_27-09-2018,DEL_BLR_28-09-2018/0-false-3343-3395-true-false%7CBLR-DEL-6E-6E-2978-false-true-false-1538038800000-1538049300000-2526-0-0-598-R0IP2978-R-6EUNI:0-false-3978-4030-true-false%7CDEL-BLR-6E-6E-2624-false-true-false-1538080200000-1538090100000-3181-0-0-634-Q0IP2624-Q-6EUNI/2f62bcc0cb3%7Cc86d%7C9076%7C441d%7C2baa0bb7/odc/asyncResponsiveReview#/showTraveller");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span//input[@placeholder='First Name']")).sendKeys("Lokesh");		
		driver.findElement(By.xpath("//span//input[@placeholder='Last Name']")).sendKeys("Kondepudi");
		driver.findElement(By.xpath("//input[@placeholder='Mobile Number']")).sendKeys("9900343344");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
		

	}

}
