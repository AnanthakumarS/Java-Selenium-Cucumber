package com.kindred.runner;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.inject.Inject;
import com.kindred.utilities.ConfigProperties;
import com.kindred.utilities.Constants.BROWSERS;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CucumberHooks {
	protected DesiredCapabilities capabilities;

	@Inject
	DriverContainer driverContainer;

	@Before
	public void beforeEveryTest(Scenario scenario) throws Exception {
		switch (BROWSERS.valueOf(ConfigProperties.getBROWSER())) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + File.separator + "driver" + File.separator + "chromedriver.exe");
			capabilities = DesiredCapabilities.chrome();

			ChromeOptions options = new ChromeOptions();
			options.addArguments("test-type");

			// Chrome mobile Emulator capabilities
			Map<String, String> mobileEmulation = new HashMap<String, String>();
			mobileEmulation.put("deviceName", "Apple iPhone 6 Plus");

			Map<String, Object> chromeOptions = new HashMap<String, Object>();
			chromeOptions.put("mobileEmulation", mobileEmulation);

			capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);

			driverContainer.webDriver = new ChromeDriver(capabilities);
			driverContainer.webDriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
			break;
		case FF:
			System.out.println("To do for firefox browser");
			break;
		default:
			break;
		}
	}

	@After
	public void afterEveryTest(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) driverContainer.webDriver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
		try {
			if (driverContainer.webDriver != null)
				driverContainer.webDriver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
