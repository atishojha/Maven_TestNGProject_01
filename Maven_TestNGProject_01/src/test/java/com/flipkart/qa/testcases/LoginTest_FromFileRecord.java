package com.flipkart.qa.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.HomePage;
import com.flipkart.qa.pages.LoginPage;

public class LoginTest_FromFileRecord extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	public LoginTest_FromFileRecord() {
		super();
		}
@BeforeMethod
public void setup() {
	initializzation();
	loginpage = new LoginPage();
}
 
 @Test
 public void loginTest() {
	driver.findElement(By.linkText("Login & Signup"));
homepage= loginpage.login(prop.getProperty("userid"), prop.getProperty("password"));
 }
	 
@AfterMethod 
public void tearDown() {
	driver.quit();
} 
}


