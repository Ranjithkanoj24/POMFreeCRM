package com.freecrm.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.base.BaseTest;

public class LoginPage extends BaseTest{

	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[text()='Sign Up']")
	WebElement signupBtn;
	
	@FindBy(xpath="//img[@alt='free crm logo']")
	WebElement crmLogo;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	public String validateLoginTitle() {
		return driver.getTitle();
	}
	public boolean verifyLogo() {
		return crmLogo.isDisplayed();
	}
	public boolean verifySignupButton() {
		return signupBtn.isDisplayed();
	}
	public HomePage loginCheck(String uid, String pwd) {
		username.sendKeys(uid);
		password.sendKeys(pwd);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", loginBtn);
		return new HomePage();
	}
}
