package stepDefinition;

import java.io.IOException;

import TestBase.BaseClass;
import TestCase.TestCase001_UpComingBikeDetails;
import TestCase.TestCase002_UsedCarsInChennai;
import TestCase.TestCase003_ClickonLoginSignUp;
import TestCase.TestCase004_SignInGoogleAccounts;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDef {
	BaseClass bs = new BaseClass();

	@Given("load the browser and ZigsWheel Page")
	public void load_the_browser_and_zigs_wheel_page() {
		try {
			bs.invokeBrowser("Windows", "chrome");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	@Then("Click on New Bikes and Upcoming bike select hond and get the details of Bikes")
	public void click_on_new_bikes_and_upcoming_bike_select_hond_and_get_the_details_of_bikes() {
		TestCase001_UpComingBikeDetails tc1 = new TestCase001_UpComingBikeDetails();
		try {
			tc1.clickNewBikes();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		tc1.clickUpcomingBikes();
	}

	@Then("Click on Used Cars and select models and Get the model details")
	public void click_on_used_cars_and_select_models_and_get_the_model_details() {
		TestCase002_UsedCarsInChennai tc2 = new TestCase002_UsedCarsInChennai();
		try {
			tc2.UsedCarDetails();
		} catch (InterruptedException e) {

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Then("Login\\/signUp to google and give invalid details and capture error message")
	public void login_sign_up_to_google_and_give_invalid_details_and_capture_error_message() {
		TestCase003_ClickonLoginSignUp tc3 = new TestCase003_ClickonLoginSignUp();
		TestCase004_SignInGoogleAccounts tc4 = new TestCase004_SignInGoogleAccounts();
		tc3.verifyLoginPage();
		tc4.verifyLoginPage();
	}

	@Then("Close the Browser")
	public void close_the_browser() {
		bs.tearDown();
	}

}