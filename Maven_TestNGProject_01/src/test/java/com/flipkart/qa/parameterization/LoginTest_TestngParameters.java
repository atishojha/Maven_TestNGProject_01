package com.flipkart.qa.parameterization;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.HomePage;
import com.flipkart.qa.pages.LoginPage;

public class LoginTest_TestngParameters extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	public LoginTest_TestngParameters() {
		super();
		}
@BeforeMethod
public void setup() {
	initializzation();
	loginpage = new LoginPage();
}
 @Test
 @Parameters({ "uid", "pwd" })
 public void loginTest(String uid,String pwd) {
	driver.findElement(By.linkText("Login & Signup"));
  	homepage= loginpage.login(uid,pwd);
 }
  
@AfterMethod 
public void tearDown() {
	driver.quit();
}
}
