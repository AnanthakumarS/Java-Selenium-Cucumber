package com.kindred.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GamePage {
	private WebDriver webDriver;

	@FindBy(className = "game-description")
	public WebElement gameDescriptionLabel;

	@FindBy(css = "[data-game-origin = 'PlayModeSelector']")
	public WebElement playModeSelector;

	public GamePage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(this.webDriver, this);
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
