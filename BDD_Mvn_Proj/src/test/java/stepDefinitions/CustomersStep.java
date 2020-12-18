package stepDefinitions;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.*;
import junit.framework.Assert;
import pageObjects.AddCustomerPage;
import pageObjects.SearchCustomerPage;

@SuppressWarnings("deprecation")
public class CustomersStep extends BaseClass{
	
	WebDriver driver;
	
	
	public CustomersStep(SharedClass sClass) throws IOException{
		
		logger = Logger.getLogger("nopcommerce");
		PropertyConfigurator.configure("log4j.properties");
		logger.info("******Launching Browser...*****");
		driver=sClass.startBrowser();
		driver.manage().window().maximize();
	}
	
	@Then("^User can view Dashboard$")
	public void user_can_view_Dashboard() throws Throwable {
	    acp = new AddCustomerPage(driver);
	    
	    org.junit.Assert.assertEquals("Dashboard / nopCommerce administration", acp.getPageTitle());
	}

	@When("^User click on customers menu$")
	public void user_click_on_customers_menu() throws Throwable {
		Thread.sleep(3000);
	  acp.clickOnCustomersMenu();
	}

	@When("^Click on customers menu item$")
	public void click_on_customers_menu_item() throws Throwable {
		Thread.sleep(3000);
	    acp.clickOnCustomersMenuItem();
	}

	@When("^Click on Add new button$")
	public void click_on_Add_new_button() throws Throwable {
	    acp.clickOnAddnew();
	}

	@Then("^User can view Add new customer page$")
	public void user_can_view_Add_new_customer_page() throws Throwable {
		org.junit.Assert.assertEquals("Add a new customer / nopCommerce administration", acp.getPageTitle());
	}

	@When("^User enter customer info$")
	public void user_enter_customer_info() throws Throwable {
		String email = randomEmailString() + "@gmail.com";
	   acp.setEmail(email);
	   acp.setPwd("test123");
	   
	   acp.setCustomerRoles("Guest");
	   Thread.sleep(3000);
	   acp.setManagerOfVendor("Vendor 2");
	   acp.setGender("Male");
	   
	   acp.setFirstName("Vinod");
	   acp.setLastName("vinny");
	   acp.setDOB("9/27/1982");
	   acp.setCompanyName("baseQA");
	   acp.setAdminContent("This is for testing");
	}

	@When("^Click on save button$")
	public void click_on_save_button() throws Throwable {
	    acp.clickOnSave();
	}

	@Then("^User can view confirmation message \"([^\"]*)\"$")
	public void user_can_view_confirmation_message(String msg) throws Throwable {
		org.junit.Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(msg));
	}
	
	
	//Steps for Search customer by emailid and name
	
	
	@When("^Enter customer email$")
	public void enter_customer_email() throws Throwable {
	   scp = new SearchCustomerPage(driver);
	   scp.setEmail("victoria_victoria@nopCommerce.com");
	}

	@When("^Click on search button$")
	public void click_on_search_button() throws Throwable {
	    scp.clickOnSearch();
	    Thread.sleep(3000);
	}

	@Then("^User should found email in the search table$")
	public void user_should_found_email_in_the_search_table() throws Throwable {
		boolean status = scp.searchEmailInTable("victoria_victoria@nopCommerce.com");
		org.junit.Assert.assertEquals(true, status);
	}

	@When("^Enter customer firstname$")
	public void enter_customer_firstname() throws Throwable {
		scp = new SearchCustomerPage(driver);
	   scp.setFirstName("Victoria");
	}

	@When("^Enter customer lastname$")
	public void enter_customer_lastname() throws Throwable {
		scp.setLastName("Terces"); 
	}
	
	@Then("^User should found name in the search table$")
	public void user_should_found_name_in_the_search_table() throws Throwable {
	    boolean status=scp.searchNameInTable("Victoria");
	    org.junit.Assert.assertEquals(true, status);
	}

	
}
