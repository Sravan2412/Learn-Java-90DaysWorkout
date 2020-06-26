package stepDefinitions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Naukri extends BaseClass{
	
	WebDriverWait wait = new WebDriverWait(driver, 15);
	
	@Given("Go to naukri.com")
	public void goToNaukriCom() {
	    
	    driver.get("https://www.naukri.com");
	}

	@Given("Get the company names from each pop up window and close it")
	public void getTheCompanyNamesFromEachPopUpWindowAndCloseIt() throws InterruptedException {
	    
	    String parentWindow = driver.getWindowHandle();
	    List<String> list = new ArrayList<>(driver.getWindowHandles());
	    driver.switchTo().window(list.get(1));
	    System.out.println("The Company name of 1st opened popup: "+driver.findElement(By.xpath("(//img)[1]")).getAttribute("alt"));
	    driver.close();
	    driver.switchTo().window(list.get(2));
	    System.out.println("The Company name of 1st opened popup: "+driver.findElement(By.xpath("(//img)[1]")).getAttribute("alt"));
	    driver.close();
	    driver.switchTo().window(parentWindow);
	    Thread.sleep(2000);
	}

	@When("Now click on the upload cv button and upload some random image")
	public void nowClickOnTheUploadCvButtonAndUploadSomeRandomImage() {
	    WebElement uploadCV = driver.findElement(By.xpath("//input[@id='file_upload']"));
	    uploadCV.sendKeys("C:\\Users\\Sravan\\Desktop\\Portfolio-html-site\\images\\logos\\ministry-safe.png"); 
	    
	}

	@Then("Get the error message printed")
	public void getTheErrorMessagePrinted() {
	    System.out.println();
	    WebElement errorText = driver.findElement(By.xpath("//div[@class='error-header-desc error']"));
	    System.out.println("The error text is: "+ wait.until(ExpectedConditions.visibilityOf(errorText)).getText());
	}

}
