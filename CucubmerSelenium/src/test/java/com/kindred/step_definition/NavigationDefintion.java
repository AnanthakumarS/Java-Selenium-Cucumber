package com.kindred.step_definition;

import org.openqa.selenium.WebDriver;

import com.google.inject.Inject;
import com.kindred.runner.DriverContainer;

import cucumber.api.java.en.Given;

/**
 * Class contains definitions related to all navigations : (eg : get , windows
 * and frame navigation)
 * 
 * @author Ananth
 *
 */
public class NavigationDefintion {

	private WebDriver webDriver;

	@Inject
	public NavigationDefintion(DriverContainer driverContainer) {
		this.webDriver = driverContainer.webDriver;
	}

	@Given("^I navigate to \"([^\"]*)\"$")
	public void openURL(String url) {
		webDriver.get(url);
	}
}
