package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	public WebDriver driver;
	
    // constructor for the base page class
	public BasePage(WebDriver driver) {
		this.driver = driver;
		
		//Initializing elements on the page
		PageFactory.initElements(driver, this);
	}
}