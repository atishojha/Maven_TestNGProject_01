package com.flipkart.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.HomePage;
import com.flipkart.qa.pages.LoginPage;

public class LoginTest_FromHardcodeRecord extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	public LoginTest_FromHardcodeRecord() {
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
homepage= loginpage.login("9732490916","atishojha");
//String title= loginpage.ValidateTitle();
//Assert.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books &amp; More. Exclusive Deals!");
 }
	 
@AfterMethod 
public void tearDown() {
	driver.quit();
} 
}



