package com.flipkart.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.qa.base.TestBase;

public class LoginPage extends TestBase {

// page factory or Object Repository(OR)	
 
  @FindBy(linkText="Login & Signup") 
   // @FindBy(xpath="//a[@href=\"/account/login?ret=/\" and contains(text(),'Login & Signup')]")
   WebElement user_login;

  @FindBy(xpath="//div[@class='_39M2dM']//input[@type='text' and @class='_2zrpKA']")
  WebElement user_id;
  
  @FindBy(xpath="//div[@class='_39M2dM']//input[@type='password' and @class='_2zrpKA _3v41xv']")
  WebElement user_password;
	
  @FindBy(xpath="//button[@class='_2AkmmA _1LctnI _7UHT_c' and @type='submit']//span[contains(text(), 'Login')]")
  WebElement user_submit;
  
  @FindBy(xpath="//a[@class=\"_21JmK0 _1__46T\"and span[contains(text(),'Forgot?')]]")
  WebElement password_forgot;
  
  @FindBy(xpath="//span[contains(text(),'New to Flipkart? Sign up')]")
  WebElement user_signup;
 // boolean b = driver.findElement(By.xpath("//img[@class='jnSYHL' and @title='Flipkart']"))
  @FindBy(xpath="//img[@class='jnSYHL' and @title='Flipkart']")
	WebElement logo;
	
public LoginPage() {
	PageFactory.initElements(driver, this);
}

public HomePage login(String username, String pwd) {
//user_login.click();
user_id.sendKeys(username);
user_password.sendKeys(pwd);
user_submit.click();
return new HomePage();
} 

/*public boolean ValidateLogo() {
	return logo.isDisplayed();
} */

public String ValidateTitle() {
	return driver.getTitle();	
}

}


