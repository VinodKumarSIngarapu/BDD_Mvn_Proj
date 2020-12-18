Feature: Login Functionality

@smoke
Scenario: Successfull Login with valid credentials
	Given User Launch chrome browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login
	Then Page title should be "Dashboard / nopCommerce administration"
	When User click on Log out link
	Then Page title should be "Your store. Login"
#	And close browser
	
	
Scenario Outline: Successfull Login with valid credentials
	Given User Launch chrome browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "<email>" and Password as "<password>"
	And Click on Login
	Then Page title should be "Dashboard / nopCommerce administration"
	When User click on Log out link
	Then Page title should be "Your store. Login"
	And close browser	
	
	Examples:
	|	email					|	password		|
	|	admin@yourstore.com		|	admin			|
	|	admin1@yourstore.com	|	admin123		|