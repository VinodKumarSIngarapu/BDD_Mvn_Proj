package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {

	public WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
	
	By lnkCustomers_menu = By.xpath("//a[@href='#']//span[contains(text(), 'Customers')]");
	By lnkCustomers_menuitem = By.xpath("//span[@class='menu-item-title'][contains(text(), 'Customers')]");
	
	By btnAddNew = By.xpath("//a[@class='btn bg-blue']");
	
	By txtEmail = By.xpath("//input[@id='Email']");
	By txtPwd = By.xpath("//input[@id='Password']");
	
	By txtCustomerRoles = By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
	By lstitemAdministrators = By.xpath("//li[contains(text(), 'Administrators')]");
	By lstitemRegistered = By.xpath("//li[contains(text(), 'Registered')]");
	By lstitemGuests = By.xpath("//li[contains(text(), 'Guests')]");
	By lstitemVendors = By.xpath("//li[contains(text(), 'Vendors')]");
	
	By drpmgVendor = By.xpath("//select[@id='VendorId']");
	By rdMaleGender = By.xpath("//input[@id='Gender_Male']");
	By rdFemaleGender = By.xpath("//input[@id='Gender_Female']");
	
	By txtFirstName = By.xpath("//input[@id='FirstName']");
	By txtLastName = By.xpath("//input[@id='LastName']");
	
	By txtDob = By.xpath("//input[@id='DateOfBirth']");
	
	By txtCompanyName = By.xpath("//input[@id='Company']");
	By txtAdminContent = By.xpath("//textarea[@id='AdminComment']");
	
	By btnSave = By.xpath("//button[@name='save']");
	
	
	//Action Methods
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	
	public void clickOnCustomersMenu() {
		driver.findElement(lnkCustomers_menu).click();
	}
	
	public void clickOnCustomersMenuItem() {
		driver.findElement(lnkCustomers_menuitem).click();
	}
	
	public void clickOnAddnew() {
		driver.findElement(btnAddNew).click();
	}
	
	public void setEmail(String email) {
		driver.findElement(txtEmail).sendKeys(email);
	}
	
	public void setPwd(String pwd) {
		driver.findElement(txtPwd).sendKeys(pwd);
	}
	
	public void setCustomerRoles(String role) throws InterruptedException {
		if(!role.equals("Vendors")) {
			driver.findElement(By.xpath("//*[@id='SelectedCustomerRoleIds_taglist']/li/span[@title='delete']")).click();
		}
		
		driver.findElement(txtCustomerRoles).click();
		
		WebElement listitem;
		
		Thread.sleep(3000);
		
		if(role.equals("Administrators")) {
			listitem = driver.findElement(lstitemAdministrators);
		}else if(role.equals("Guests")) {
			listitem = driver.findElement(lstitemGuests);
		}else if(role.equals("Registered")) {
			listitem = driver.findElement(lstitemRegistered);
		}else if(role.equals("Vendors")) {
			listitem = driver.findElement(lstitemVendors);
		}else {
			listitem = driver.findElement(lstitemGuests);
		}
		
//		listitem.click();
//		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", listitem);
	}
	
	public void setManagerOfVendor(String value) {
		Select drp = new Select(driver.findElement(drpmgVendor));
		drp.selectByVisibleText(value);
	}
	
	public void setGender(String gender) {
		if(gender.equals("Male")) {
			driver.findElement(rdMaleGender).click();
		}else if(gender.equals("Female")) {
			driver.findElement(rdFemaleGender).click();
		}else {
			driver.findElement(rdMaleGender).click(); //default
		}
	}
	
	public void setFirstName(String fname) {
		driver.findElement(txtFirstName).sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		driver.findElement(txtLastName).sendKeys(lname);
	}
	
	public void setDOB(String dob) {
		driver.findElement(txtDob).sendKeys(dob);
	}
	
	public void setCompanyName(String cname) {
		driver.findElement(txtCompanyName).sendKeys(cname);
	}
	
	public void setAdminContent(String adminCont) {
		driver.findElement(txtAdminContent).sendKeys(adminCont);
	}
	
	public void clickOnSave() {
		driver.findElement(btnSave).click();
	}
}
