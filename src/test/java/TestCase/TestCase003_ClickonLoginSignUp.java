package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.ClickonLoginSignup;
import TestBase.BaseClass;

public class TestCase003_ClickonLoginSignUp extends BaseClass {

	@Test(priority=1,groups= {"smoke","regression","master"})
	public void verifyLoginPage() {
		logger.info("**** Starting TC_003_LoginSignup ****");
		try {
			logger.info("Verifying login/SignUp");
			ClickonLoginSignup loginSignupPage = new ClickonLoginSignup(driver);
			
			// click on the Zigwheels link to navigate back
			loginSignupPage.clickZigwheels();
			
			// Click on the Login/Signup button
			loginSignupPage.clickLoginSignUp();
			// Taking screenshot
			screenshot("LoginSignUpCard");
			
			// Select the google button
			loginSignupPage.selectGoogleButton();
		} catch (Exception e) {
			logger.info("Verifying login/SignUp failed!!");
			e.printStackTrace();
			Assert.fail();
		}
		logger.info("**** Finished TC_003_LoginSignup ****");
	}
}
