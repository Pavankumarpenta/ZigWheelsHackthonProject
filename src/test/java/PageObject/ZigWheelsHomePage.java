package PageObject;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


//Importing the BaseClass from TestBase package
import TestBase.BaseClass;

public class ZigWheelsHomePage extends BasePage {

	public ZigWheelsHomePage(WebDriver driver) {
		super(driver);
	}

	 // WebElement representing the 'New Bikes' element on the page
	@FindBy(xpath = "//a[normalize-space()='New Bikes']")
	public WebElement NewBikesElement;

    // WebElement representing the 'Upcoming Bikes' element on the page
	@FindBy(xpath = "//span[normalize-space()='Upcoming Bikes']")
	public WebElement upcomingBikes;

	//Method to Hover to new bikes element and perform action on the target element
	public void clickNewBikes() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(NewBikesElement).perform();
		Thread.sleep(3000);
	}
	
	//Method to click on the 'Upcoming Bikes' element
	public void selectUpcomingBikes() throws IOException {
		
		// Hover over the 'Upcoming Bikes' element
		Actions actions = new Actions(driver);
		actions.moveToElement(upcomingBikes).perform();
		
		// Take a screenshot for 'Upcoming Bikes'and perform a click using JavaScript executor
		BaseClass baseclass = new BaseClass();
		baseclass.screenshot("UpcomingBike");
//		new BaseClass().screenshot("UpcomingBike");
		
		//perform a click on 'Upcoming Bikes' using JavaScript executor
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", upcomingBikes);
	}
}
