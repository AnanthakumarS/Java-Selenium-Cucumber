package com.kindred.step_definition;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.google.inject.Inject;
import com.kindred.pages.HomePage;
import com.kindred.pages.RegisterPage;
import com.kindred.runner.DriverContainer;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

/**
 * Class contains definitions related to all page interactions : (eg : click ,
 * sendkeys , etc .)
 * 
 * @author Ananth
 *
 */
public class InteractionDefinition {
	private WebDriver webDriver;
	private HomePage homePage;
	private RegisterPage registerPage;

	@Inject
	public InteractionDefinition(DriverContainer driverContainer) {
		this.webDriver = driverContainer.webDriver;
		homePage = new HomePage(webDriver);
		registerPage = new RegisterPage(webDriver);
	}

	@When("^I search with \"([^\"]*)\" game name$")
	public void searchGame(String gameName) {
		homePage.searchGame(gameName);
	}

	@When("^I click \"([^\"]*)\" button$")
	public void clickRegisterButton(String gameName) {
		homePage.clickRegisterButton();
	}

	@And("^I register$")
	public void register(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		registerPage.signUp(dataMap);
		System.out.println(dataMap.get("First_Name"));
	}

}
