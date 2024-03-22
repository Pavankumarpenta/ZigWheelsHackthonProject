package PageObject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Utils.ExcelUtility;
import Utils.JavaScriptManager;

public class UpcomingBikesDetails extends BasePage {

	// Initializing utility classes for JavaScript execution and Excel operations
	JavaScriptManager javaScriptManager = new JavaScriptManager();
	Utils.ExcelUtility excelUtility = new ExcelUtility();

	public UpcomingBikesDetails(WebDriver driver) {
		super(driver);
	}

	// WebElement representing the dropdown to locate manufacturer
	@FindBy(id = "makeId")
	public WebElement locateManufacturer;

	// WebElement representing the 'View More Bikes' button
	@FindBy(xpath = "//span[@class='zw-cmn-loadMore']")
	public WebElement viewMoreBikesButton;

	// List of WebElement representing the model names of all the Honda bikes
	@FindBy(css = ".lnk-hvr.block.of-hid.h-height")
	public List<WebElement> modelName;

	// List of WebElement representing the prices of all the Honda bikes
	@FindBy(xpath = "//li[contains(@class,'modelItem')]")
	public List<WebElement> bikePrice;

    // List of WebElement representing the launch dates of all the Honda bikes
	@FindBy(css = ".clr-try.fnt-14")
	public List<WebElement> dateOfBikes;

	
	// Method to select manufacturer Honda from dropdown and click
	public void clickManufacturer() {
		locateManufacturer.click();
		Select s=new Select(locateManufacturer);
		s.selectByIndex(3);
	}

	// Method to locate and click the 'View More Bikes' button
	public void clickViewMoreButton() throws InterruptedException {
		// Scrolling to the button
		javaScriptManager.scrollIntoView(driver, viewMoreBikesButton);
		Thread.sleep(3000);
        // Clicking on the 'View More Bikes' button using JavaScript executor
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", viewMoreBikesButton);
		Thread.sleep(2000);
	}

	// Method to extract bike details and store them in Excel file
	public void bikeDetails() throws IOException {
		// Setting headers in Excel
		excelUtility.setCellData("UpcomingBike", 0, 0, "BikeName");
		excelUtility.setCellData("UpcomingBike", 0, 1, "Price");
		excelUtility.setCellData("UpcomingBike", 0, 2, "LunchDate");
		
		int row = 1;      // Initializing row counter for Excel
		for (int i = 0; i < modelName.size(); i++) {
			String bikeName = modelName.get(i).getText();// Getting bike name
			String launchDate = dateOfBikes.get(i).getText();// Getting launch date
			int price = Integer.parseInt(bikePrice.get(i).getAttribute("data-price")); // Getting bike price
			// Checking if the price is less than 400000
			if (price < 400000) {
				System.out.println(bikeName + "\n" + price + "\n" + launchDate);
				System.out.println("****************************");
				// Storing details in Excel
				excelUtility.setCellData("UpcomingBike", row, 0, bikeName);
				excelUtility.setCellData("UpcomingBike", row, 1, price + "");
				excelUtility.setCellData("UpcomingBike", row, 2, launchDate);
				row++; // Incrementing row counter
			}
		}
	}
}
