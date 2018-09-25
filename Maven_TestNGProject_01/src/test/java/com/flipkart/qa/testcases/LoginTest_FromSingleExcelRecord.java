package com.flipkart.qa.testcases;

//Fetch Single record from Excel sheet

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.HomePage;
import com.flipkart.qa.pages.LoginPage;
import com.flipkart.qa.util.Xls_Reader;

public class LoginTest_FromSingleExcelRecord extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	public LoginTest_FromSingleExcelRecord() {
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
   Xls_Reader reader= new Xls_Reader("C:\\Users\\Dell\\eclipse-workspace\\Maven_TestNGProject_01\\src\\main\\java\\com\\flipkart\\qa\\testdata\\LoginCredential.xlsx");	
 // int RowNo=reader.getRowCount("Login_Credential");        
	String uid=reader.getCellData("Login_Credential", "Userid", 2);
	String pwd=reader.getCellData("Login_Credential", "Password", 2);
	homepage= loginpage.login(uid,pwd);
	reader.setCellData("Login_Credential", "Status", 2, "Pass");       // For Write data to Excel
 }
  
@AfterMethod 
public void tearDown() {
	driver.quit();
} 
}


