package com.kindred.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TermsAndConditionsPage {
	private WebDriver webDriver;

	@FindBy(css = "[data-test-name='directMarketing-true']")
	public WebElement acceptButton;

	@FindBy(name = "termsAndConditionsAcceptDate")
	public WebElement termsAndConditionsAcceptDate;

	@FindBy(name = "submit-registration")
	public WebElement joinButton;

	@FindBy(css = "[name = 'continue-registration']")
	public WebElement continueButtton;

	public TermsAndConditionsPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	/**
	 * Method to accept terms
	 * 
	 * @param element
	 */
	public void confirmTerms() {
		waitforElement(acceptButton);
		acceptButton.click();
		termsAndConditionsAcceptDate.click();

		waitforElement(joinButton);
		moveToElement(joinButton);
		joinButton.click();
	}

	/**
	 * Method to wait for an element
	 * 
	 * @param element
	 */
	public void waitforElement(WebElement element) {
		try {
			WebDriverWait driverWait = new WebDriverWait(webDriver, 60);
			driverWait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
		}
	}

	/**
	 * Method to move to an element
	 * 
	 * @param element
	 */
	public void moveToElement(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) webDriver;
		executor.executeScript(
				"scroll(" + element.getLocation().getX() + "," + (element.getLocation().getY() - 170) + ")");
	}
}
