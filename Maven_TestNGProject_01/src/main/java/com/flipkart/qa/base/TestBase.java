package com.flipkart.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.flipkart.qa.util.TestUtil;
public class TestBase {
public static WebDriver driver;
public static Properties prop;

public TestBase() {	
try {
	prop=new Properties();
	FileInputStream ip=new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\Maven_TestNGProject_01\\src\\main\\java\\com\\flipkart\\qa\\config\\config.properties");
	prop.load(ip);	
} catch(FileNotFoundException e) {
	e.printStackTrace();
}catch(IOException e) {  
	e.printStackTrace();
}
catch(NullPointerException e) {  
	e.printStackTrace();
}
}
public static void initializzation() {
	String Browser = prop.getProperty("browser");
	System.out.println(Browser);
		if(Browser.equals("firefox")){
		//System.out.println(Browser);
		    System.setProperty("webdriver.gecko.driver","C:\\Users\\Dell\\eclipse\\Driver\\geckodriver-v0.21.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		   }else/* if(Browser.equals("firefox")) */{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\eclipse\\Driver\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
	      }
   driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));  	
  }
}




