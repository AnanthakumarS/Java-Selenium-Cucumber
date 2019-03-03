package com.kindred.pages;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecurityQuestionsPage {
	private WebDriver webDriver;

	@FindBy(name = "password")
	public WebElement password;

	@FindBy(id = "securityQuestion")
	public WebElement securityQuestion;

	@FindBy(id = "securityAnswer")
	public WebElement securityAnswer;

	@FindBy(css = "[name = 'continue-registration']")
	public WebElement continueButtton;

	public SecurityQuestionsPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	/**
	 * Method to enter security questions
	 * 
	 * @param element
	 */
	public void enterSecurtiyQuestions(Map<String, String> dataMap) {
		waitforElement(password);
		password.sendKeys(dataMap.get("Password"));

		moveToElement(securityQuestion);
		new Select(securityQuestion).selectByVisibleText(dataMap.get("SecurityQuestion"));

		securityAnswer.sendKeys(dataMap.get("SecurityAnswer"));

		waitforElement(continueButtton);
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
