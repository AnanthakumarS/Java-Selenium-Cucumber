Feature: Search Feature 
	As a user i want to check search game functionality

@register 
Scenario: 
	Given I navigate to "https://www.unibet.com/softgames" 
	And I click "Register" button 
	And  I register 
		|	Key 			| 	Value 				|
		| 	First_Name 		| 	Ananth				| 
		|	Last_Name 		|	Sakravarthi 		|
		| 	Email_Address 	| 	ananth_test@gmail.com|
		| 	DOB 			|  	1-July-1987 		|	
		| 	GENDER 			| 	Male 				| 
		| 	Street 			| 	1 church road		|
		| 	PostCode 		| 	E12 6AGd			|
		| 	City 			| 	London				|
		| 	MobileNumber 	| 	01234567890			|
		| 	Password 		| 	Offshor1@			|
		| 	SecurityQuestion| 	My first car?		|
		| 	SecurityAnswer 	| 	iduA				|