Cucumber-Selenium Project
=================

selenium-cucumber : Automated scenarion Using Java , Selenium , Cucumber

selenium-cucumber is a behavior driven development (BDD) approach to write automation test script to test Web.
It enables you to write and execute automated acceptance/unit tests.
It is cross-platform, open source and free.
Automate your test cases with minimal coding.
[More Details](http://seleniumcucumber.info/)

Installation / Pre-requistes 
-------------
* Java >= 1.8
* Maven >= 3
* Make sure you installed maven and configured in Environment variable (Windows and mac)

Writing a test
--------------

The cucumber features goes in the `src/test/resources/features` package and should have the ".feature" extension.

You can start out by looking at `features/Home.feature`. 

Writing a step definition
--------------------------

I have categorized step definitions into 3 parts : 
1. Navigation - (Given) Class contains only related to navigation methods , eg : navigate to URLs
2. Interaction - (When) Class contains only related to interaction methods , eg : click , sendKeys , etc
3. Verification -(Then) Class contains only related to assertions

Running test
--------------

Go to your project directory from terminal and hit following commands
* mvn clean
* mvn clean install (To execute all scenrios)
* mvn clean install -Dcucumber-options = "--tags @product_tab"

Using canned tests in your project
----------------------------------

In your TestRunner class add a glue option:

```
package com.kindred.step_definition;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	plugin = {"html:target/cucumberHtmlReport"},
	features = "classpath:features",
	glue = {"com.kindred.step_definition" , "com.kindred.runner"}
)

public class RunCukeTest {
}
```

Result : 
--------------
Once the execution is done  , please refer html reports at  : /$Project/target/cucumberHtmlReport folder
