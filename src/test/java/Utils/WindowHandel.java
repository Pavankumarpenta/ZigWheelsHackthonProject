package Utils;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import PageObject.BasePage;

public class WindowHandel extends BasePage {
	public WindowHandel(WebDriver driver) {
		super(driver);
	}
	
    // Method to implement window handling and navigate to a window with specified title 
	public boolean windowNavigate(String WebsiteTitle) {
		Set<String> window = driver.getWindowHandles();
		for(String id : window) {
			driver.switchTo().window(id);
			String title = driver.getTitle();     // Getting title of the current window
			if(title.equals(WebsiteTitle)) {     // If title matches the specified title
				return true; // Return true indicating navigation successful
			}
		}
		return false;  // Return false indicating navigation failed

	}
}
