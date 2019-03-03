package com.kindred.pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;

public class RegisterPage {
	private WebDriver webDriver;
	private PersonalDetailsPage personalDetailsPage;
	private AddressPage addressPage;
	private SecurityQuestionsPage securityPage;
	private TermsAndConditionsPage termsPage;

	public RegisterPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	/**
	 * Method to signup
	 * 
	 * @param dataMap
	 */
	public void signUp(Map<String, String> dataMap) {
		personalDetailsPage = new PersonalDetailsPage(webDriver);
		personalDetailsPage.enterPersonalDetails(dataMap);

		addressPage = new AddressPage(webDriver);
		addressPage.enterAddress(dataMap);

		securityPage = new SecurityQuestionsPage(webDriver);
		securityPage.enterSecurtiyQuestions(dataMap);

		termsPage = new TermsAndConditionsPage(webDriver);
		termsPage.confirmTerms();
	}
}
