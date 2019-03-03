package com.kindred.pages;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressPage {
	private WebDriver webDriver;

	@FindBy(css = "[data-type='manual']")
	public WebElement enterManuallyLink;

	@FindBy(id = "street")
	public WebElement streetAndNumber;

	@FindBy(id = "postalCode")
	public WebElement postCode;

	@FindBy(id = "city")
	public WebElement city;

	@FindBy(css = "[class='number-field'] [class*='form-textbox'] [name='phoneNumber']")
	public WebElement phoneNumber;

	@FindBy(css = "[name = 'continue-registration']")
	public WebElement continueButtton;

	public AddressPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	/**
	 * Method to enter address details
	 * 
	 * @param element
	 */
	public void enterAddress(Map<String, String> dataMap) {
		try {
			Thread.sleep(3000);
			if (enterManuallyLink.isDisplayed())
				enterManuallyLink.click();
		} catch (Exception e) {
		}

		waitforElement(streetAndNumber);
		moveToElement(streetAndNumber);
		streetAndNumber.sendKeys(dataMap.get("Street"));
		postCode.sendKeys(dataMap.get("PostCode"));
		city.sendKeys(dataMap.get("City"));

		moveToElement(phoneNumber);
		phoneNumber.sendKeys(dataMap.get("MobileNumber"));

		waitforElement(continueButtton);
		moveToElement(continueButtton);
		jClick(continueButtton);
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

	public void jClick(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) webDriver;
		executor.executeScript("arguments[0].click();", element);
	}
}
