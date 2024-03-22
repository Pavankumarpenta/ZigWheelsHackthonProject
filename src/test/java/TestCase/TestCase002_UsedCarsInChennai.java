package TestCase;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.UsedCarsInchennai;
import TestBase.BaseClass;


public class TestCase002_UsedCarsInChennai extends BaseClass {
	// Test method to get details of used cars in Chennai
	@Test(priority=1,groups= {"regression","master"})
	public void UsedCarDetails() throws InterruptedException, IOException {
		logger.info("**** Starting TestCase002_UsedCarsInChennai  ****");
		try {
			logger.info("clicking on Used Cars and selecting Chennai");
			// Instantiate UsedCarsInchennai object
			UsedCarsInchennai usedCar = new UsedCarsInchennai(driver);
			
			//Hover and select used cars
			usedCar.selectUsedCars();
			
			//Click on the selected car
			usedCar.clickSelectedCar();

			//Click on the popular models
			usedCar.extractPopularModels();
		} catch (Exception e) {
			logger.info("Failed to click used cars!!!");
			e.printStackTrace();
			Assert.fail();
		}
		logger.info("**** Finished TestCase002_UsedCarsInChennai ****");
	}
}
