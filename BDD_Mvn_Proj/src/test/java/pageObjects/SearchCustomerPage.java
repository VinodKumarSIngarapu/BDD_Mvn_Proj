package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {

	public WebDriver driver;
	public WaitHelper whelper;
	
	public SearchCustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		whelper = new WaitHelper(driver);
	}
	
	@FindBy(id="SearchEmail")
	@CacheLookup
	WebElement txtSearchEmail;
	
	@FindBy(id="SearchFirstName")
	@CacheLookup
	WebElement txtSearchFName;
	
	@FindBy(id="SearchLastName")
	@CacheLookup
	WebElement txtSearchLName;
	
	@FindBy(id="SearchMonthOfBirth")
	@CacheLookup
	WebElement drpDOBMonth;
	
	@FindBy(id="SearchDayOfBirth")
	@CacheLookup
	WebElement drpDOBDay;
	
	@FindBy(id="SearchCompany")
	@CacheLookup
	WebElement txtSearchComp;
	
	@FindBy(xpath="//div[@class='k-multiselect-wrap k-floatwrap']")
	@CacheLookup
	WebElement txtCustomerRoles;
	
	@FindBy(xpath="//li[contains(text(), 'Administrators')]")
	@CacheLookup
	WebElement lstitemAdministrators;
	
	@FindBy(xpath="//li[contains(text(), 'Registered')]")
	@CacheLookup
	WebElement lstitemRegistered;
	
	@FindBy(xpath="//li[contains(text(), 'Guests')]")
	@CacheLookup
	WebElement lstitemGuests;
	
	@FindBy(xpath="//li[contains(text(), 'Vendors')]")
	@CacheLookup
	WebElement lstitemVendors;
	
	@FindBy(id="search-customers")
	@CacheLookup
	WebElement btnSearch;
	
	@FindBy(xpath="//table[@role='grid']")
	@CacheLookup
	WebElement tblSearchResults;
	
	@FindBy(xpath="//table[@id='customers-grid']")
	@CacheLookup
	WebElement table;
	
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr")
	@CacheLookup
	List<WebElement> tableRows;
	
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr/td")
	@CacheLookup
	List<WebElement> tableColumns;
	
	public void setEmail(String email) {
		whelper.waitForElement(txtSearchEmail, 30);
		txtSearchEmail.clear();
		txtSearchEmail.sendKeys(email);
	}
	
	public void setFirstName(String fname) {
		whelper.waitForElement(txtSearchFName, 30);
		txtSearchFName.clear();
		txtSearchFName.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		whelper.waitForElement(txtSearchLName, 30);
		txtSearchLName.clear();
		txtSearchLName.sendKeys(lname);
	}
	
	public void clickOnSearch() {
		btnSearch.click();
		whelper.waitForElement(table, 30);
	}
	
	public int getNoOfRows() {
		whelper.waitForElement(table, 30);
		return (tableRows.size());
	}
	
	public int getNoOfColumns() {
		return (tableColumns.size());
	}
	
	public boolean searchEmailInTable(String email) {
		boolean flag=false;
		System.out.println("email::::"+email);
		whelper.waitForElement(table, 30);
		for(int i=1;i<=getNoOfRows();i++) {
			String emailid = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println("emailid:::"+emailid);
			if(emailid.trim().equalsIgnoreCase(email)) {
				flag=true;
			}
		}
		return flag;
	}
	
	public boolean searchNameInTable(String name) {
		boolean flag=false;
		System.out.println("name::::"+name);
		whelper.waitForElement(table, 30);
		for(int i=1;i<=getNoOfRows();i++) {
			String tname = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
			System.out.println("tname::::::::::"+tname);
			if(tname.trim().contains(name)) {
				flag=true;
			}
		}
		return flag;
	}
}
