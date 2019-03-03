Feature: Search Feature 
	As a user i want to check search game functionality

@seach_game 
Scenario: 
	Given I navigate to "https://www.unibet.com/softgames" 
	When I search with "Action Bank" game name 
	Then I should see "Action Bank" game page