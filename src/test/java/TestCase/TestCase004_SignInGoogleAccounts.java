package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.SignInGoogleAccounts;
import TestBase.BaseClass;
import Utils.WindowHandel;

public class TestCase004_SignInGoogleAccounts extends BaseClass {

	@Test(priority=1,groups= {"regression","master"})
	public void verifyLoginPage() {
		logger.info("**** Starting TC_004_LoginPage ****");
		try {
			logger.info("Verifying loginPage");
			// Implementing window handles
			WindowHandel windowHandel = new WindowHandel(driver);
			windowHandel.windowNavigate("Sign in - Google Accounts");

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
		logger.info("**** Finished TC_004_LoginPage ****");
	}
}
