package com.flipkart.qa.attributetest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.HomePage;
import com.flipkart.qa.pages.LoginPage;

public class LoginTest_TestAttribute extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	public LoginTest_TestAttribute() {
		super();
		}
/* alwaysRun refers to a method always runs even if the parameters on which the method depends, fails. 
  If set to true, this test method will always run. */
@BeforeMethod
  public void setup() {
	initializzation();
	loginpage = new LoginPage();
}

/* invocationCount refers to the number of times a method should be invoked. It will work as a loop.
 * invocationTimeOut refers to the maximum number of milliseconds that the total number of invocations on this 
 * test method should take.This annotation will be ignored if the attribute invocationCount is not specified on this method.
 * Basically invocationTimeOut=Time taken per invocation * Number of invocations.*/
 @Test(invocationCount=3,invocationTimeOut=300,priority=5)
   public void LogoValidationTest() {
   //boolean logo = loginpage.ValidateLogo();
	 boolean logo = driver.findElement(By.xpath("//img[@class='jnSYHL' and @title='Flipkart']")).isDisplayed();
	 Assert.assertTrue(logo);
 }  
 
 /* dependsOnGroups depends on another Groups(EX:Smoke.if Smoke group fail,then current @test annotation will be  
  * skipped but not failed) */
 @Test(dependsOnGroups="Smoke",priority=4)
 public void MenfasionTest() {
/*	 driver.findElement(By.xpath("//a[@title=\"Men's Grooming\"]")).click(); 
	 String Men_title=driver.getTitle();   */
	 System.out.println("Men_title");
 }
 
 /* dependsOnMethods depends on another methods(EX:loginTest.if loginTest fail,then current method will be  skipped)
  * timeOut & invocationTimeout almost same.invocationTimeOut is working along with invocationCount,but timeOut is working without it.*/
 @Test(dependsOnMethods="loginTest",timeOut=300,priority=3)
   public void TitleValitationTest() {
	 String title= loginpage.ValidateTitle();
	//Assert.assertEquals(title, "Online Shopping Site for Mobiles, Fashion, Books, Electronics, Home Appliances and More");
 //	 Assert.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Exclusive Offers!");
	System.out.println("Login_title");
 } 
 

 /* description refers to the Description of your @test annotation  */
 @Test(description="Login to your URL",priority=1)
   public void loginTest() {
	 driver.findElement(By.linkText("Login & Signup"));
     homepage= loginpage.login(prop.getProperty("userid"), prop.getProperty("password"));
     System.out.println("Login_test");
 } 
 
 @Test(groups= {"Sanity","Smoke"},priority=2)
 public void MobilesTest() {
/*	 driver.findElement(By.xpath("//ul[@class=\"QPOmNK\"]//a[@title=\"Mobiles\"]")).click();
	 String Mobiles_title=driver.getTitle(); */
	 System.out.println("Mobiles_title");
 }

 @Test//(enabled=false)  // enabled=false is uesd for completely abort from the @Test annotation
 public void SkipExceptionTest() {
	 throw new SkipException("Skipping - it is not ready for testing");
 }
 
/*expectedException with @Test annotation specify the type of exceptions that are expected to be thrown when executing 
 * the test methods and "Passed" even exception. If exception not matched, then @test annotation will be "Fail"	*/
 @Test(expectedExceptions = ArithmeticException.class,priority=6)
	public void Expected_exception(){
		int e = 1/0;
	}  
	 
@AfterMethod 
public void tearDown() {
	driver.quit();
 }
}
