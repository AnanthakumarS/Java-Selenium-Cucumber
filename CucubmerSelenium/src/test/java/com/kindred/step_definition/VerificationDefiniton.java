package com.kindred.step_definition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.google.inject.Inject;
import com.kindred.pages.GamePage;
import com.kindred.pages.HomePage;
import com.kindred.runner.DriverContainer;

import cucumber.api.java.en.Then;

/**
 * Class contains definitions related to all verifications : (eg : All
 * assertions)
 * 
 * @author Ananth
 *
 */
public class VerificationDefiniton {

	private GamePage gamePage;
	private HomePage homePage;
	private WebDriver webDriver;

	@Inject
	public VerificationDefiniton(DriverContainer driverContainer) {
		this.webDriver = driverContainer.webDriver;
		gamePage = new GamePage(webDriver);
		homePage = new HomePage(webDriver);
	}

	@Then("^I should see \"([^\"]*)\" game page$")
	public void verifyGamePage(String gameName) {
		gamePage.waitforElement(gamePage.gameDescriptionLabel);
		Assert.assertTrue(gamePage.gameDescriptionLabel.isDisplayed());
		Assert.assertTrue(gamePage.gameDescriptionLabel.getText().contains(gameName));
	}

	@Then("^I should see \"([^\"]*)\" tab$")
	public void verifyProductNavigation(String gameName) {
		homePage.waitforElement(homePage.sportsTab);
		Assert.assertTrue(homePage.sportsTab.isDisplayed());
		Assert.assertTrue(homePage.casinoTab.isDisplayed());
		Assert.assertTrue(homePage.liveCasinoTab.isDisplayed());
		Assert.assertTrue(homePage.bingoTab.isDisplayed());
		Assert.assertTrue(homePage.lotteryBettingTab.isDisplayed());
		Assert.assertTrue(homePage.pokerTab.isDisplayed());
	}
}
