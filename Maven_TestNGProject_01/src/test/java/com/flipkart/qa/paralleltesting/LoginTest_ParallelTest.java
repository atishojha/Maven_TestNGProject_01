package com.flipkart.qa.paralleltesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.flipkart.qa.util.TestUtil;

public class LoginTest_ParallelTest {
		 
		 @Test
		 public void getFirefox(){
		                //System.setProperty("webdriver.gecko.driver", "geckodriver.exe path");
		 System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dell\\eclipse\\Driver\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		                System.out.println("GetFirefox Method is running on Thread : " + Thread.currentThread().getId());
		 WebDriver driver = new FirefoxDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		 driver.get("https://www.flipkart.com/");
		 driver.close();
		 }
		 
		 @Test
		 public void getChorme(){
		                //System.setProperty("webdriver.chrome.driver", "chromedriver.exe path");
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\eclipse\\Driver\\chromedriver_win32\\chromedriver.exe");
		                System.out.println("GetChrome Method is running on Thread : " + Thread.currentThread().getId());
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		 driver.get("https://www.flipkart.com/");
		 driver.close();
		 }
		 
		}

