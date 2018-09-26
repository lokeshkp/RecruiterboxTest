package com.makemytrip.flightBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class MakeMyTripBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public MakeMyTripBase() {
		try {
			
			String cwd = System.getProperty("user.dir");
			String profFile = cwd + "\\src\\main\\java\\com\\makemytrip\\config\\config.properties"; 
			System.out.println(profFile);
			prop = new Properties();
			FileInputStream fis = new FileInputStream(profFile);
			prop.load(fis);			
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void browserInitilization() {
		
		/*String browserName = prop.getProperty("browser");		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/lokes/eclipse-workspace/RecruiterboxTestLOK/src/main/java/browsers/chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/lokes/eclipse-workspace/RecruiterboxTestLOK/src/main/java/browsers/geckodriver");
			driver = new FirefoxDriver();
		}*/
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
				
	}

}
