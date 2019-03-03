package com.kindred.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "html:target/cucumberHtmlReport" }, features = "classpath:features", glue = {
		"com.kindred.step_definition", "com.kindred.runner" })
public class RunCukesTest {

}
