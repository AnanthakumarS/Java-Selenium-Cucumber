package com.kindred.pages;

import java.util.Map;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalDetailsPage {
	private WebDriver webDriver;

	@FindBy(id = "firstName")
	public WebElement firstName;

	@FindBy(id = "lastName")
	public WebElement lastName;

	@FindBy(id = "email")
	public WebElement emailAddress;

	@FindBy(name = "day")
	public WebElement day;

	@FindBy(name = "month")
	public WebElement month;

	@FindBy(name = "year")
	public WebElement year;

	@FindBy(css = "[data-test-name = 'gender-1']")
	public WebElement genderMale;

	@FindBy(css = "[data-test-name = 'gender-2']")
	public WebElement genderFemale;

	@FindBy(css = "[name = 'continue-registration']")
	public WebElement continueButtton;

	public PersonalDetailsPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	/**
	 * Method to enter personal details
	 * 
	 * @param dataMap
	 */
	public void enterPersonalDetails(Map<String, String> dataMap) {
		waitforElement(firstName);
		firstName.sendKeys(dataMap.get("First_Name"));
		lastName.sendKeys(dataMap.get("Last_Name"));

		int random = new Random().nextInt(1000);
		String[] splitedEmail = dataMap.get("Email_Address").split("@");
		String strEmailAddress = splitedEmail[0] + random + "@" + splitedEmail[1];
		emailAddress.sendKeys(strEmailAddress);

		String[] dob = dataMap.get("DOB").split("-");
		new Select(day).selectByVisibleText(dob[0]);
		new Select(month).selectByVisibleText(dob[1]);
		new Select(year).selectByVisibleText(dob[2]);

		moveToElement(genderMale);
		if (dataMap.get("GENDER").equalsIgnoreCase("Male"))
			genderMale.click();
		else if (dataMap.get("GENDER").equalsIgnoreCase("Female"))
			genderFemale.click();

		moveToElement(continueButtton);
		continueButtton.click();
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
