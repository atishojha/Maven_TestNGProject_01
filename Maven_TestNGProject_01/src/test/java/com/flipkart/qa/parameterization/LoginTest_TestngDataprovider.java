package com.flipkart.qa.parameterization;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.HomePage;
import com.flipkart.qa.pages.LoginPage;

public class LoginTest_TestngDataprovider extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	public LoginTest_TestngDataprovider() {
		super();
	}
@BeforeMethod
public void setup() {
	initializzation();
	loginpage = new LoginPage();
}

@DataProvider(name = "Login_Authentication")

public static Object[][] credentials() {

      return new Object[][] { 
    	  { "9732490916", "atishojha" },
    	  { "9732490916", "atishojha" },
    	  { "9732490916", "atishojha" }       };  
}
 @Test(dataProvider="Login_Authentication")
 public void loginTest(String uid,String pwd) {
	driver.findElement(By.linkText("Login & Signup"));
  	homepage= loginpage.login(uid,pwd);
 }
  
@AfterMethod 
public void tearDown() {
	driver.quit();
}
}
