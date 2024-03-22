package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.ClickonLoginSignup;
import TestBase.BaseClass;

public class TestCase003_ClickonLoginSignUp extends BaseClass {
    
	// Test method to verify login/signup functionality
	@Test(priority=1,groups= {"smoke","regression","master"})
	public void verifyLoginPage() {
		logger.info("**** Starting TestCase003_ClickonLoginSignUp  ****");
		try {
			logger.info("Verifying login/SignUp");
			 // Instantiate ClickonLoginSignup object
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
		logger.info("**** Finished TestCase003_ClickonLoginSignUp  ****");
	}
}
