package com.kindred.runner;

import org.openqa.selenium.WebDriver;

import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class DriverContainer {
	public WebDriver webDriver;
}
