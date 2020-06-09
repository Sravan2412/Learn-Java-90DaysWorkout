package stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class AjioShopping extends BaseClass{
	
	Actions builder = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	WebDriverWait wait = new WebDriverWait(driver, 15);
	
	@Given("Go to https:\\/\\/www.ajio.com\\/shop\\/women")
	public void goToHttpsWwwAjioComShopWomen() {
	    driver.get("https://www.ajio.com/shop/women");
	    
	}

	@Given("Mouseover on Women, CATEGORIES and click on Kurtas")
	public void mouseoverOnWomenCATEGORIESAndClickOnKurtas() throws InterruptedException {
	    WebElement women = driver.findElement(By.xpath("(//a[text()='WOMEN'])[1]"));
	    builder.moveToElement(women).perform(); Thread.sleep(1000);
	    driver.findElement(By.xpath("(//a[text()='Kurtas'])[2]")).click();
	    
	}

	@Given("Click on Brands and choose Ajio")
	public void clickOnBrandsAndChooseAjio() throws InterruptedException {
	    driver.findElement(By.xpath("//span[text()='brands']")).click();
	    driver.findElement(By.xpath("//label[contains(text(),'AJIO')]")).click();
	    Thread.sleep(2000);
	}

	@Given("Check all the results are Ajio")
	public void checkAllTheResultsAreAjio() {
	    List<WebElement> brandName = driver.findElements(By.xpath("//div[@class='brand']"));
	    for (WebElement EachBrandName : brandName) {
			System.out.println(EachBrandName.getText());
		}   
	}

	@Given("Set Sort by the result as Discount")
	public void setSortByTheResultAsDiscount() {
	    WebElement sortBy = driver.findElement(By.xpath("//select"));
	    Select select = new Select(sortBy);
	    select.selectByVisibleText("Discount");
	    
	}

	@Given("Select the Color and click ADD TO BAG")
	public void selectTheColorAndClickADDTOBAG() throws InterruptedException {
	    js.executeScript("window.scrollBy(0,600)", "");
	    Thread.sleep(3000);
	    WebElement colors = driver.findElement(By.xpath("(//span[@class='facet-left-pane-label'])[7]"));
	    wait.until(ExpectedConditions.elementToBeClickable(colors)).click();
	    driver.findElement(By.xpath("//label[contains(text(),'Yellow')]")).click();
	    WebElement Ajio = driver.findElement(By.xpath("(//div[@class='brand'])[1]"));
	    wait.until(ExpectedConditions.visibilityOf(Ajio)).click();
	    List<String> list = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(list.get(1));
	    
	    WebElement addToCart = driver.findElement(By.xpath("//div[@class='pdp-addtocart-button']"));
	    wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();
	    Thread.sleep(2000);
	}

	@Given("Verify the error message Select your size to know your estimated delivery date")
	public void verifyTheErrorMessageSelectYourSizeToKnowYourEstimatedDeliveryDate() throws InterruptedException {
	    WebElement firstErrMsg = driver.findElement(By.xpath("//span[text()='Please select a size']"));
	    System.out.println("After Clicking Add to cart error message is : "+firstErrMsg.getText());
	    WebElement defaultErrorMsg = driver.findElement(By.xpath("//span[@class='edd-pincode-msg-details']"));
	    System.out.println("The default error message displayed is : "+defaultErrorMsg.getText());
	    Thread.sleep(2000);
	}

	@Given("Select size and click ADD TO BAG")
	public void selectSizeAndClickADDTOBAG() {
	    driver.findElement(By.xpath("(//div[@class='size-swatch'])[4]")).click();
	    driver.findElement(By.xpath("//div[@class='btn-gold']")).click();
	    
	}

	@Given("click on Enter pin-code to know estimated delivery date")
	public void clickOnEnterPinCodeToKnowEstimatedDeliveryDate() throws InterruptedException {
	  //js.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(6000);
		WebElement pincode = driver.findElement(By.xpath("//span[@class='edd-pincode-msg-details edd-pincode-msg-details-pointer edd-pincode-msg-details-text-color']"));
	    js.executeScript("arguments[0].click()", pincode);
	    
	}

	@Given("Enter the pincode as 603103 and click Confirm pincode")
	public void enterThePincodeAsAndClickConfirmPincode() {
	    driver.findElement(By.name("pincode")).sendKeys("603103");
	    driver.findElement(By.xpath("//button[@class='edd-pincode-modal-submit-btn']")).click();
	}

	@Given("Print the message and click Go to Bag")
	public void printTheMessageAndClickGoToBag() {
		
	    WebElement firstSuccessMessage = driver.findElement(By.xpath("//ul[@class='edd-message-success-details']"));
	    WebElement secondSuccessMessage = driver.findElement(By.xpath("//span[@class='edd-message-success-details-note']"));
	    wait.until(ExpectedConditions.visibilityOf(firstSuccessMessage)).isDisplayed();
	    System.out.println("The 1st success message is : "+firstSuccessMessage.getText());
	    System.out.println("The 2nd success message is : "+secondSuccessMessage.getText());
	    driver.findElement(By.xpath("//div[@class='btn-cart']")).click();
	}

	@Then("Click on Proceed to Shipping and close the browser")
	public void clickOnProceedToShippingAndCloseTheBrowser() {
		
		WebElement orderSummary = driver.findElement(By.id("orderSummary"));
		System.out.println(orderSummary.getText()+"/t");
	    driver.findElement(By.xpath("//button[@class='rilrtl-button button shipping-button']")).click();
	    
	}
}
