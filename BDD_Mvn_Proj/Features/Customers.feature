Feature: Customers

Background: 
	Given User Launch chrome browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login
	Then User can view Dashboard
	When User click on customers menu
	
@smoke
Scenario: Add Customer

	And Click on customers menu item
	And Click on Add new button
	Then User can view Add new customer page
	When User enter customer info
	And Click on save button
	Then User can view confirmation message "The new customer has been added successfully."
#	And close browser
	
	
Scenario: Search Customer by emailid

	When User click on customers menu
	And Click on customers menu item
	And Enter customer email
	When Click on search button
	Then User should found email in the search table
	And close browser 	
	
Scenario: Search Customer by Name

	When User click on customers menu
	And Click on customers menu item
	And Enter customer firstname
	And Enter customer lastname
	When Click on search button
	Then User should found name in the search table
	And close browser 	