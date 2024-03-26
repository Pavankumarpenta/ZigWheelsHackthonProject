package TestBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {
public static WebDriver driver;
	public static Logger logger;     // Declaring Logger objects
	
	// Method to initialize the browser based on parameters passed
	@BeforeTest(groups={"smoke","regression","master"})
	@Parameters({"os", "browser"})

    // Loading configuration properties from config file
	public void invokeBrowser(String os, String browser) throws IOException {
		FileReader fileReader = new FileReader(".//src/test/resources/config.properties");
		Properties properties = new Properties();
		properties.load(fileReader);
		
		// Initializing logger using log4j2
		logger = LogManager.getLogger(this.getClass());
		
        // Setting up browser based on input parameter
		if(browser.equalsIgnoreCase("chrome")) {			
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}else {
			System.out.println("No Matching Browser");
			return;
		}
        // Configuring driver settings
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(properties.getProperty("Url"));
		driver.manage().window().maximize();
	}
	
    // Method to close the browser after test execution
	@AfterTest(groups={"smoke","regression","master"})
	public void tearDown() {
		driver.quit();
	}
	
	
	// Method to capture screenshot
	public String screenshot(String name) throws IOException {
		// Generating timestamp for unique file name
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		
		// Capturing screenshot using Selenium TakesScreenshot interface
		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        // Defining path for storing screenshot
		String path = System.getProperty("user.dir")+"\\ScreenShots\\"+name+" " +timeStamp+".png";
		File targetLocation = new File(path);
		// Saving screenshot file
		FileUtils.copyFile(file, targetLocation);
		return path;
	}
}