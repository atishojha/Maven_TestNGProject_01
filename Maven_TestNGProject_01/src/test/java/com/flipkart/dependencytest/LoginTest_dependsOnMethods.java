package com.flipkart.dependencytest;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.HomePage;
import com.flipkart.qa.pages.LoginPage;
/*In TestNG, we use dependOnMethods and dependsOnGroups to implement dependency testing. If a dependent method is fail, 
  all the subsequent test methods will be skipped, NOT failed   */
public class LoginTest_dependsOnMethods extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	public LoginTest_dependsOnMethods() {
		super();
		}
@BeforeMethod
  public void setup() {
	initializzation();
	loginpage = new LoginPage();
}
 
 @Test(dependsOnMethods="loginTest",priority=3)
 public void MenfasionTest() {
/*	 driver.findElement(By.xpath("//a[@title=\"Men's Grooming\"]")).click(); 
	 String Men_title=driver.getTitle();   */
	 System.out.println("Men_title");
 }
 
 /* dependsOnMethods depends on another methods(EX:loginTest.if loginTest fail,then current method will be  skipped) */
 @Test(dependsOnMethods="MobilesTest",priority=4)
 public void WomenfasionTest() {
	 driver.findElement(By.xpath("//a[@title=\"Beauty & Grooming\"]")).click();
	 String Women_title=driver.getTitle();   
	 System.out.println("Women_title");
 }
 /* description refers to the Description of your @test annotation  */
 @Test(description="Login to your URL",priority=1)
   public void loginTest() {
	 driver.findElement(By.linkText("Login & Signup"));
     homepage= loginpage.login(prop.getProperty("userid"), prop.getProperty("password"));
     System.out.println("Login_test");
 } 
 
 @Test(groups= {"Sanit","Smoke"},priority=2)
 public void MobilesTest() {
/*	 driver.findElement(By.xpath("//ul[@class=\"QPOmNK\"]//a[@title=\"Mobiles\"]")).click();
	 String Mobiles_title=driver.getTitle(); */
	 System.out.println("Mobiles_title");
 } 
	 	 
@AfterMethod 
public void tearDown() {
	driver.quit();
 }
}
