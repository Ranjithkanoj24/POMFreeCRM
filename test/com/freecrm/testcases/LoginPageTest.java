package com.freecrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.base.BaseTest;
import com.freecrm.pages.HomePage;
import com.freecrm.pages.LoginPage;

public class LoginPageTest extends BaseTest {

	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		BaseTest.initialization();
		loginPage = new LoginPage();	
	}

	@Test(priority = 1)
	public void validateLoginTitleTest() {
		String title = loginPage.validateLoginTitle();
		Assert.assertEquals(title, "Free CRM in the cloud software boosts sales");
	}

	@Test(priority = 2)
	public void verifyLogoTest() {
		boolean result = loginPage.verifyLogo();
		Assert.assertEquals(result, true, "The logo is displayed");
	}

	@Test(priority = 3)
	public void verifySignupButtonTest() {
		boolean result = loginPage.verifySignupButton();
		Assert.assertEquals(result, true, "The Signup button is displayed");
	}

	@Test(priority = 4)
	public void loginCheckTest() {
		homePage = loginPage.loginCheck(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println(homePage);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
