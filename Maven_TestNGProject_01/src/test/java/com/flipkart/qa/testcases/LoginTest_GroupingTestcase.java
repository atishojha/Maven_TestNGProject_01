package com.flipkart.qa.testcases;

	import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	import com.flipkart.qa.base.TestBase;
	import com.flipkart.qa.pages.HomePage;
	import com.flipkart.qa.pages.LoginPage;

	public class LoginTest_GroupingTestcase extends TestBase {
		LoginPage loginpage;
		HomePage homepage;
		public LoginTest_GroupingTestcase() {
			super();
			}
	@BeforeMethod(alwaysRun = true)
	public void setup() {
		initializzation();
		loginpage = new LoginPage();
	}
	 @Test(groups="Regression",priority=3)
	 public void LogoValidationTest() {
	   //boolean logo = loginpage.ValidateLogo();
		 boolean logo = driver.findElement(By.xpath("//img[@class='jnSYHL' and @title='Flipkart']")).isDisplayed();
		 Assert.assertTrue(logo);
	 } 
	 @Test(groups="System",priority=2)
	 public void TitleValitationTest() {
		String title= loginpage.ValidateTitle();
		Assert.assertEquals(title, "Online Shopping Site for Mobiles, Fashion, Books, Electronics, Home Appliances and More");
	 } 

	 @Test(groups= {"Sanity","Regression"},priority=1)
	 public void loginTest() {
		driver.findElement(By.linkText("Login & Signup"));
	homepage= loginpage.login(prop.getProperty("userid"), prop.getProperty("password"));
	 }  
	 @Test(groups= {"Sanity","Smoke"},priority=1)
	 public void MobilesTest() {
	/*	 driver.findElement(By.xpath("//ul[@class=\"QPOmNK\"]//a[@title=\"Mobiles\"]")).click();
		 String Mobiles_title=driver.getTitle(); */
		 System.out.println("Mobiles_title");
	 }
	 
	 @Test(groups= {"Alpha","Regression"},priority=1)
	 public void MenfasionTest() {
	/*	 driver.findElement(By.xpath("//a[@title=\"Men's Grooming\"]")).click(); 
		 String Men_title=driver.getTitle();   */
		 System.out.println("Men_title");
	 }
	 @Test(groups= {"Smoke","Functional"},priority=1)
	 public void WomenfasionTest() {
   /*		 driver.findElement(By.xpath("//a[@title=\"Beauty & Grooming\"]")).click();
		 String Women_title=driver.getTitle();   */
		 System.out.println("Women_title");
	 }
		 
	@AfterMethod(alwaysRun = true) 
	public void tearDown() {
		driver.quit();
	} 
	}




