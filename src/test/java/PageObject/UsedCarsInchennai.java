package PageObject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import TestBase.BaseClass;
import Utils.ExcelUtility;
import Utils.JavaScriptManager;

public class UsedCarsInchennai extends BasePage {
   
	
	// Initializing utility classes for Excel operations and JavaScript execution
	ExcelUtility excelUtility = new ExcelUtility();
	JavaScriptManager javaScriptManager = new JavaScriptManager();

	public UsedCarsInchennai(WebDriver driver) {
		super(driver);
//		this.driver = driver;
	}

	 // WebElement representing the 'Used Cars' element on the page
	@FindBy(xpath = "//a[normalize-space()='Used Cars']")
	WebElement usedCarsElement;

	// WebElement representing the location option for Chennai
	@FindBy(xpath = "//span[@onclick=\"goToUrl('/used-car/Chennai')\"]")
	WebElement usedCarLocation;

	// WebElement representing the 'Popular Models' section on the page
	@FindBy(xpath = "//div[text()='Popular Models']")
	WebElement popularModelsElements;

	// List of popular models displayed on the page
	@FindBy(xpath = "//div[@class='gsc_thin_scroll']/ul/li/label")
	List<WebElement> popularModelsList;

	// Checkbox of the popular models
	@FindBy(xpath = "//ul[@class=\"zw-sr-secLev usedCarMakeModelList popularModels ml-20 mt-10\"]/li/label")
	List<WebElement> checkboxOfCars;

	// WebElement representing the 'Brand and Model' section on the page
	@FindBy(xpath = "//span[normalize-space()='Brand and Model']")
	WebElement BrandAndModel;

    // Method to hover over the 'Used Cars' element
	public void selectUsedCars() throws InterruptedException {
		javaScriptManager.scrollToTop(driver);
		Actions actions = new Actions(driver);
		actions.moveToElement(usedCarsElement).perform();
		Thread.sleep(3000);
	}

	// Method to select the location for used cars (Chennai)
	public void clickSelectedCar() throws IOException, InterruptedException {
		new BaseClass().screenshot("UsedCarLocation");

        // Clicking on the location for used cars using JavaScript executor
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", usedCarLocation);
		Thread.sleep(3000);
	}

	// Method to extract and store popular models in Excel
	public void extractPopularModels() throws IOException, InterruptedException {
		System.out.println("Total no of cars:" + checkboxOfCars.size());
		// Setting header in Excel
		excelUtility.setCellData("PopularModels", 0, 0, "PopularModelsList");
		
		// Scrolling to 'Brand and Model' section
		javaScriptManager.scrollIntoView(driver, BrandAndModel);
		
		int row = 1;
		for (WebElement model : checkboxOfCars) {
			try {
				System.out.println(model.getText());
				// Storing model names in Excel
				excelUtility.setCellData("PopularModels", row, 0, model.getText()); 
				row++;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
