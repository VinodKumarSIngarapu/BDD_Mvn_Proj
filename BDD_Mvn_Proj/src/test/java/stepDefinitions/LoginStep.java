package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class LoginStep extends BaseClass{
	
	WebDriver driver;
	
	SharedClass sClass;
	public LoginStep(SharedClass sClass) throws IOException{
		this.sClass=sClass;
		logger = Logger.getLogger("nopcommerce");
		PropertyConfigurator.configure("log4j.properties");
		logger.info("******Launching Browser...*****");
		driver=sClass.startBrowser();
		driver.manage().window().maximize();
	}
	
	
	
	@Given("^User Launch chrome browser$")
	public void user_Launch_chrome_browser() throws Throwable {
	   
	   lp = new LoginPage(driver);
	}

	@When("^User opens URL \"([^\"]*)\"$")
	public void user_opens_URL(String url) throws Throwable {
		logger.info("******Opening URL...*****");
	   driver.get(url);
	}

	@When("^User enters Email as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void user_enters_Email_as_and_Password_as(String email, String pwd) throws Throwable {
	   lp.setUserName(email);
	   lp.setPassword(pwd);
	}

	@When("^Click on Login$")
	public void click_on_Login() throws Throwable {
	    lp.clickLogin();
	    Thread.sleep(1000);
	}

	
	@Then("^Page title should be \"([^\"]*)\"$")
	public void page_title_should_be(String title) throws Throwable {
	    if(driver.getPageSource().contains("Login was unsuccessful.")) {
	    	driver.close();
	    	org.junit.Assert.assertTrue(false);
	    }else {
	    	org.junit.Assert.assertEquals(title, driver.getTitle());
	    	
	    }
	}

	@When("^User click on Log out link$")
	public void user_click_on_Log_out_link() throws Throwable {
	    lp.clickLogout();
	    Thread.sleep(3000);
	}

	@Then("^close browser$")
	public void close_browser() throws Throwable {
	    driver.close();
	    driver=null;
	}
	
	
	//////////////////////////
	
	
}
