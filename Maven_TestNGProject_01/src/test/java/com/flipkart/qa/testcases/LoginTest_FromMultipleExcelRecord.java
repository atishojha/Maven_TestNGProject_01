package com.flipkart.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.util.TestUtil;
import com.flipkart.qa.util.Xls_Reader;

public class LoginTest_FromMultipleExcelRecord extends TestBase {
	public static void main(String[] args) {
		Xls_Reader reader= new Xls_Reader("C:\\Users\\Dell\\eclipse-workspace\\Maven_TestNGProject_01\\src\\main\\java\\com\\flipkart\\qa\\testdata\\LoginCredential.xlsx");	
	    int RowNo=reader.getRowCount("Login_Credential");
  for(int i=2;i<=RowNo;i++) {
	   System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\eclipse\\Driver\\chromedriver_win32\\chromedriver.exe");
	   driver = new ChromeDriver();	
	   driver.get("https://www.flipkart.com/");
	   String uid=reader.getCellData("Login_Credential", "Userid", i);         // For Read Excel data
		String pwd=reader.getCellData("Login_Credential", "Password", i);     // For Read Excel data
	   
		driver.findElement(By.linkText("Login & Signup"));
		
		WebElement user_id = driver.findElement(By.xpath("//div[@class='_39M2dM']//input[@type='text' and @class='_2zrpKA']"));
		user_id.sendKeys(uid);
		
		WebElement password = driver.findElement(By.xpath("//div[@class='_39M2dM']//input[@type='password' and @class='_2zrpKA _3v41xv']"));
		password.sendKeys(pwd);
		
		WebElement user_submit=driver.findElement(By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c' and @type='submit']//span[contains(text(), 'Login')]"));
		user_submit.click();
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		reader.setCellData("Login_Credential", "Status", i, "Pass");       // For Write data to Excel
	    driver.quit();
	    }
}
}

