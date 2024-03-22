package PageObject;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utils.ExcelUtility;

public class SignInGoogleAccounts extends BasePage {

	// Initializing utility class for Excel operations
	ExcelUtility excelUtility = new ExcelUtility();

	public SignInGoogleAccounts(WebDriver driver) {
		super(driver);
	}

	// locate the google button
	@FindBy(id = "identifierId")
	public WebElement emailInput;

	// WebElement representing the "Next" button on the login page
	@FindBy(xpath = "//span[normalize-space()='Next']")
	public WebElement nextBtn_loc;

	// WebElement representing the error message displayed
	@FindBy(xpath = "//div[text()='Couldn’t find your Google Account']")
	public WebElement errorMessage;

	// Method to set a random email address in the email input field
	public void setEmailInput() {
		emailInput.sendKeys(randomString() + "@gmail.com");
	}

    // Method to click the "Next" button
	public void clickNextBtn() throws InterruptedException {
		nextBtn_loc.click();
		Thread.sleep(5000);
	}

	//Method to extract the error message and display on the console
	public void handleErrorMsg() throws IOException {
		String errorMsg = errorMessage.getText();
		System.out.println("***********************");
		System.out.println(errorMsg);
		System.out.println("***********************");
		
		// Writing error message to Excel
		excelUtility.setCellData("LoginPage", 0, 0, errorMsg);
	}

	// Method to generate a random string to type into email input
	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
}
