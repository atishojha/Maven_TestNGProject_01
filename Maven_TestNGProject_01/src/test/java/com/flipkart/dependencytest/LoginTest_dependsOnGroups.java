package com.flipkart.dependencytest;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.HomePage;
import com.flipkart.qa.pages.LoginPage;
/*
 In TestNG, we use dependOnMethods and dependsOnGroups to implement dependency testing. If a dependent method is fail, 
 all the subsequent test methods will be skipped, NOT failed  */
public class LoginTest_dependsOnGroups extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	public LoginTest_dependsOnGroups() {
		super();
		}

@BeforeMethod
  public void setup() {
	initializzation();
	loginpage = new LoginPage();
}
 
/*dependsOnGroups depends on another Groups(EX:Smoke..if anyone @Test annotation of Smoke groups fail,then current @test annotation will be 
 skipped but not failed.i.e all the @test annotation of Smoke group have to be passed otherwise @Test of dependsOnGroup will be Skipped) */
 @Test(dependsOnGroups="Smoke",priority=4)
 public void MenfasionTest() {
/*	 driver.findElement(By.xpath("//a[@title=\"Men's Grooming\"]")).click(); 
	 String Men_title=driver.getTitle();   */
	 System.out.println("Men_title");
 }

 @Test(priority=1)
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
 

 @Test(groups= {"Smoke","Functional"},priority=3)
 public void WomenfasionTest() {
		 driver.findElement(By.xpath("//a[@title=\"Beauty & Grooming\"]")).click();
	 String Women_title=driver.getTitle();   
	 System.out.println("Women_title");
 } 
	 
	 
@AfterMethod 
public void tearDown() {
	driver.quit();
 }
}
