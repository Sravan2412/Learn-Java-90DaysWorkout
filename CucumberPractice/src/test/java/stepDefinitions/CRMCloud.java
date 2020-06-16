package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CRMCloud extends BaseClass{
	
	Actions build = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	WebDriverWait wait = new WebDriverWait(driver, 15);
	
	@Given("Go to https://demo.crmcloud.com")
	public void goToHttpsDemoCrmcloudCom() {
	    
		driver.get("https://demo.1crmcloud.com");
	    
	}

	@Given("Give username as (.*) and password as (.*)")
	public void giveUsernameAsAdminAndPasswordAsAdmin(String data, String data1) {
	    driver.findElement(By.xpath("//input[@id='login_user']")).sendKeys(data);
	    driver.findElement(By.xpath("//input[@id='login_pass']")).sendKeys(data1);
	    
	}

	@Given("Choose theme as Claro Theme")
	public void chooseThemeAsClaroTheme() {
		WebElement theme = driver.findElement(By.xpath("//select[@id='login_theme']"));
	    Select select = new Select(theme);
	    select.selectByVisibleText("Claro Theme");
	    driver.findElement(By.xpath("//span[@class='uii uii-arrow-right']")).click();
	}

	@Given("Go to Sales and Marketing and click Sales Home")
	public void goToSalesAndMarketingAndClickSalesHome() throws InterruptedException {
		WebElement salesAndMarketing = driver.findElement(By.xpath("//div[text()='Sales & Marketing']"));
	    build.moveToElement(salesAndMarketing).perform();
	    driver.findElement(By.xpath("//div[text()='Sales Home']")).click();
	    Thread.sleep(4000);
	}

	@Given("Click Create contact")
	public void clickCreateContact() throws InterruptedException {
	    driver.findElement(By.xpath("//div[text()='Create Contact']")).click();
	    Thread.sleep(4000);
	}

	@Given("Select Title and type First name as (.*), Last Name as (.*), Email as (.*) and Phone Numbers as (.*)")
	public void selectTitleAndTypeFirstNameLastNameEmailAndPhoneNumbers(String data, String data1, String data2, String data3) {
	    driver.findElement(By.xpath("//div[@id='DetailFormsalutation-input']")).click();
	    driver.findElement(By.xpath("//div[text()='Mr.']")).click();
	    driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys(data);
	    driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(data1);
	    driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys(data2);
	    driver.findElement(By.xpath("(//input[@type='tel'])[3]")).sendKeys(data3);
	    
	    
	}

	@Given("Select Lead Source as Public Relations and Business Roles as CEO")
	public void selectLeadSourceAsPublicRelationsAndBusinessRoles() {
	    driver.findElement(By.xpath("//div[@id='DetailFormlead_source-input']")).click();
	    driver.findElement(By.xpath("//div[text()='Public Relations']")).click();
	    driver.findElement(By.xpath("//div[@id='DetailFormbusiness_role-input']")).click();
	    driver.findElement(By.xpath("//div[text()='CEO']")).click();
	    
	}

	@Given("Fill the Primary Address as (.*), City as (.*), State as (.*), Country as (.*) and Postal Code as (.*) and click Save")
	public void fillThePrimaryAddressCityStateCountryAndPostalCodeAndClickSave(String data, String data1, String data2, String data3, String data4) {
	    driver.findElement(By.xpath("//textarea[@id='DetailFormprimary_address_street-input']")).sendKeys(data);
	    driver.findElement(By.xpath("(//input[@type='text'])[11]")).sendKeys(data1);
	    driver.findElement(By.xpath("(//input[@type='text'])[12]")).sendKeys(data2);
	    driver.findElement(By.xpath("(//input[@type='text'])[13]")).sendKeys(data3);
	    driver.findElement(By.xpath("(//input[@type='text'])[14]")).sendKeys(data4);
	    driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
	}

	@Given("Click Create in Leads section")
	public void clickCreateInLeadsSection() {
		driver.findElement(By.xpath("(//span[text()='Create'])[2]")).click();
	    
	}

	@Given("Fill First name as (.*) & Last name as (.*), Status as In Process, Title as (.*) and Department as (.*)")
	public void fillFirstLastNameStatusAsInProcessTitleAsManagerAndDepartmentAsSales(String data, String data1, String data2, String data3) {
	    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@type='text'])[1]")))).sendKeys(data);
	    driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(data1);
	    driver.findElement(By.xpath("//div[@id='QuickCreateForm_0status-input']")).click();
	    driver.findElement(By.xpath("//div[text()='In Process']")).click();
	    driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys(data2);
	    driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys(data3);
	    
	}

	@Given("Select Lead as Public Relations and fill Email as (.*) and Phone Number as (.*)")
	public void selectLeadAsPublicRelationsAndFillDepartmentEmailAndPhoneNumber(String data, String data1) {
	    driver.findElement(By.xpath("//div[@id='QuickCreateForm_0lead_source-input']")).click();
	    driver.findElement(By.xpath("(//div[text()='Public Relations'])[2]")).click();
	    driver.findElement(By.xpath("//input[@type='email']")).sendKeys(data);
	    driver.findElement(By.xpath("//input[@type='tel']")).sendKeys(data1);
	
	}

	@Given("Click Save and View")
	public void clickSaveAndView() throws InterruptedException {
	    driver.findElement(By.xpath("//button[@id='QuickCreateForm_0_save_view']")).click();
	    Thread.sleep(4000);
	}

	@Given("Mouse over on Today's Activities and click Meetings")
	public void mouseOverOnTodaySActivitiesAndClickMeetings() throws InterruptedException {
	    WebElement tdysActivities = driver.findElement(By.xpath("(//a[@class='menubar-link'])[1]"));
	    build.moveToElement(tdysActivities).perform();
	    driver.findElement(By.xpath("//div[text()='Meetings']")).click(); Thread.sleep(2000);
	    
	}

	@Given("Click Create and Type Subject as (.*) and Time as tomorrow 3 p.m")
	public void typeSubjectAsProjectStatusAsPlannedAndTimeAsTomorrowPM(String data) throws InterruptedException {
	    driver.findElement(By.xpath("(//span[text()='Create'])[1]")).click();
	    Thread.sleep(4000);
	    driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys(data);
	    driver.findElement(By.xpath("//div[@id='DetailFormdate_start-input']")).click();
	    driver.findElement(By.xpath("//div[@class='active-icon uii-time uii-lg uii']")).click();
	    driver.findElement(By.xpath("(//input[@class='input-text'])[4]")).sendKeys("03:00");
	    driver.findElement(By.xpath("//div[@class='active-icon uii-accept uii-lg uii']")).click();
	    
	    
	}

	@Given("Click Add paricipants, add your created Lead name as (.*) and click Save")
	public void clickAddParicipantsAddYourCreatedLeadNameAndClickSave(String data) throws InterruptedException {
	    driver.findElement(By.xpath("//button[@name='addInvitee']")).click(); Thread.sleep(2000);
	    driver.findElement(By.xpath("(//input[@class='input-text'])[4]")).sendKeys(data);
	    Thread.sleep(4000);
	    driver.findElement(By.xpath("((//div[@class='card-header panel-subheader'])[3]/following-sibling::div/div/div)[1]")).click();
	    driver.findElement(By.xpath("//button[@id='DetailForm_save2']")).click();
	}

	@When("Click contacts under Sales and Marketing, search the lead Name and click the name from the result")
	public void clickContactsUnderSalesAndMarketingSearchTheLeadNameAndClickTheNameFromTheResult() throws InterruptedException {
		WebElement salesAndMarketing = driver.findElement(By.xpath("//div[text()='Sales & Marketing']"));
	    build.moveToElement(salesAndMarketing).perform(); Thread.sleep(2000);
	    driver.findElement(By.xpath("//div[text()='Contacts']")).click(); Thread.sleep(4000);
	    driver.findElement(By.xpath("//input[@class='input-text input-entry ']")).sendKeys("sundar pichai"); Thread.sleep(2000);
	    driver.findElement(By.xpath("(((//div[@class='card-header panel-subheader'])[2]/following-sibling::div/div)/div)[1]")).click();
	    Thread.sleep(2000);
	}

	@Then("Check whether the Meeting is assigned to the contact.")
	public void checkWeatherTheMeetingIsAssignedToTheContact() {
	    String scheduledMeetingDateAndTime = driver.findElement(By.xpath("(//span[@class='text-number'])[5]")).getText();
	    System.out.println("Scheduled Meeting Date And Time : "+scheduledMeetingDateAndTime);
	}
}

