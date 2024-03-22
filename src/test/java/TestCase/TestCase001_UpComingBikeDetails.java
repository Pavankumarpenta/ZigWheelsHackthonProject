package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.UpcomingBikesDetails;
import PageObject.ZigWheelsHomePage;
import TestBase.BaseClass;

public class TestCase001_UpComingBikeDetails extends BaseClass {
    
	// Test method to click on New Bikes and navigate to Upcoming Bikes
	@Test(priority=1,groups= {"smoke","regression","master"})
	public void clickNewBikes() throws InterruptedException {
		logger.info("**** Starting TestCase001_UpComingBikeDetails ****");
		try {
			logger.info("clicking on  New Bikes ");
			// Instantiate ZigWheelsHomePage object
			ZigWheelsHomePage zwg = new ZigWheelsHomePage(driver);
			// click on new bikes
			zwg.clickNewBikes();
			// Click on upcoming bikes under new bikes
			zwg.selectUpcomingBikes();
		} catch (Exception e) {
			logger.info("Failed to click New Bikes");
			e.printStackTrace();
			Assert.fail();
		}
	}
	// Test method to click on Upcoming Bikes and display bike details
	@Test( priority=2,dependsOnMethods = { "clickNewBikes" }, groups= {"smoke","regression","master"})
	public void clickUpcomingBikes() {
		try {
			logger.info("clicking on Upcoming Bikes");
			// Instantiate UpcomingBikesDetails object
			UpcomingBikesDetails upcomingBike = new UpcomingBikesDetails(driver);
			// Click on Manufacturer
			upcomingBike.clickManufacturer();
			
			// Click on the view more bikes button
			upcomingBike.clickViewMoreButton();
			
			// Displaying the details of the bikes
			upcomingBike.bikeDetails();
		} catch (Exception e) {
			logger.info("Failed to click upcoming bikes");
			e.printStackTrace();
			Assert.fail();
		}
		logger.info("**** Finished TestCase001_UpComingBikeDetails ****");
	}

}
