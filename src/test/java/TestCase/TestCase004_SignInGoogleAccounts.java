package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.SignInGoogleAccounts;
import TestBase.BaseClass;
import Utils.WindowHandel;

public class TestCase004_SignInGoogleAccounts extends BaseClass {
     
	// Test method to verify login page functionality
	@Test(priority=1,groups= {"regression","master"})
	public void verifyLoginPage() {
		logger.info("**** Starting TestCase004_SignInGoogleAccounts  ****");
		try {
			logger.info("Verifying loginPage");
			// Implementing window handles
			WindowHandel windowHandel = new WindowHandel(driver);
			windowHandel.windowNavigate("Sign in - Google Accounts");
			
			// Instantiate SignInGoogleAccounts object
			SignInGoogleAccounts loginPage = new SignInGoogleAccounts(driver);

			// Click on the email input button
			loginPage.setEmailInput();

			// Click on the next button displayed on the login page
			loginPage.clickNextBtn();

			// Display the error message displayed on the screen
			loginPage.handleErrorMsg();

			// Taking screenshot
			screenshot("LoginErrorMsg");
		} catch (Exception e) {
			logger.info("LoginPage verification failed!!!");
			e.printStackTrace();
			Assert.fail();
		}
		logger.info("**** Finished TestCase004_SignInGoogleAccounts  ****");
	}
}
