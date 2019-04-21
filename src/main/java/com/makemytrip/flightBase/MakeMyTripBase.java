package com.makemytrip.flightBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class MakeMyTripBase {
	
	public static WebDriver driver;
	public static Properties prop;
	private static String cwd;
	
	public MakeMyTripBase() {
		try {
			
			cwd = System.getProperty("user.dir");
			String profFile = cwd + "/src/main/java/com/makemytrip/config/config.properties"; 
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
		
		String browserName = prop.getProperty("browser");	
		cwd = System.getProperty("user.dir");
		if(browserName.equals("chrome")) {
			
			 //ChromeOptions options = new ChromeOptions();
			 //options.addArguments("--disable-features=VizDisplayCompositor");
			
			System.setProperty("webdriver.chrome.driver", cwd+"/src/main/java/browsers/chromedriver");
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", cwd+"/src/main/java/browsers/geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver", cwd+"/src/main/java/browsers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		//WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
				
	}

}
