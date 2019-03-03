package com.kindred.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private WebDriver webDriver;

	@FindBy(css = "[title = 'Sports']")
	public WebElement sportsTab;

	@FindBy(css = "[title = 'Casino']")
	public WebElement casinoTab;

	@FindBy(css = "[title = 'Live Casino']")
	public WebElement liveCasinoTab;

	@FindBy(css = "[title = 'Bingo']")
	public WebElement bingoTab;

	@FindBy(css = "[title = 'Lottery Betting']")
	public WebElement lotteryBettingTab;

	@FindBy(css = "[title = 'Poker']")
	public WebElement pokerTab;

	@FindBy(css = "[data-test-name = 'btn-register']")
	public WebElement registerButton;

	@FindBy(className = "game-search-query")
	public WebElement searchText;

	@FindBy(className = "search-state")
	public WebElement searchButton;

	public WebElement searchResult;

	public HomePage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	public void searchGame(String gameName) {
		waitforElement(searchText);
		searchText.sendKeys(gameName);
		searchText.sendKeys(Keys.ENTER);
		searchText.sendKeys(Keys.ENTER);
	}

	public void selectGame(String gameName) {
		searchResult = webDriver.findElement(
				By.cssSelector("[class='scroll-viewport'] [class='result'] [class*='list-item'] [data-game-id* = '"
						+ gameName + "']"));
		waitforElement(searchResult);
		searchResult.click();
	}

	public void clickRegisterButton() {
		waitforElement(registerButton);
		registerButton.click();
	}

	/**
	 * Method to wait for an element
	 * 
	 * @param element
	 */
	public void waitforElement(WebElement element) {
		WebDriverWait driverWait = new WebDriverWait(webDriver, 60);
		driverWait.until(ExpectedConditions.visibilityOf(element));
	}
}
