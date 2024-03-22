package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClickonLoginSignup extends BasePage{
	public ClickonLoginSignup(WebDriver driver) {
		super(driver);
	}

	// WebElement representing Zigwheels link
	@FindBy(xpath="//a[@class='zw i-b mt-10 pt-2 zw-srch-logo']")
	public WebElement zigwheels;
	
	// WebElement representing Login/SignUp Button
	@FindBy(xpath = "//div[@id='des_lIcon']")
	public WebElement loginSignUpButton;
	
	// WebElement representing Login with Google Button
	@FindBy(xpath="//div[@class='lgn-sc c-p txt-l pl-30 pr-30 googleSignIn']")
	public WebElement loginWithGoogleButton;
	
	 // Method to click on Zigwheels link
	public void clickZigwheels() {
		zigwheels.click();
	}
	
	// Method to click on Login/SignUp button 
	public void clickLoginSignUp() {
		loginSignUpButton.click();
	}
	
	// Method to click on Sign in with Google button
	public void selectGoogleButton() {
		loginWithGoogleButton.click();
	}
	
}
