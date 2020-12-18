package stepDefinitions;


import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class BaseClass {
	
	public LoginPage lp;
	public AddCustomerPage acp;
	public SearchCustomerPage scp;
	
	public static Logger logger;
	public Properties configProp;
	
	
	//Created this method to generate random unique email id string
	public static String randomEmailString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}

}
