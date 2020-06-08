package stepDefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class NykaaLorealProduct extends BaseClass{
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	
	@Given("Go to https://www.nykaa.com")
	public void goToHttpsWwwNykaaCom() {
		
		driver.get("https://nykaa.com");
	}

	@Given("Mouseover on Brands and Mouseover on Popular")
	public void mouseoverOnBrandsAndMouseoverOnPopular() throws InterruptedException {
		Thread.sleep(7000);
	    WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
	    Actions builder = new Actions(driver);
	    builder.moveToElement(brands).perform();
	    Thread.sleep(3000);
	    WebElement popular = driver.findElement(By.xpath("//a[text()='Popular']"));
	    builder.moveToElement(popular).perform();
	    Thread.sleep(3000);
	    
	   
	}

	@Given("Click L'Oreal Paris")
	public void clickLOrealParis() {
		driver.findElement(By.xpath("(//img[@src])[5]")).click();
	   
	}

	@Given("Go to the newly opened window and check the title contains L'Oreal Paris")
	public void goToTheNewlyOpenedWindowAndCheckTheTitleContainsLOrealParis() {
		List<String> list = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(list.get(1));
	    if(driver.getTitle().contains("L'Oreal Paris")) {
	    	System.out.println("Verified"); }
	    else System.out.println("Not Verified");
	    
	   
	}

	@Given("Click sort By and select customer top rated")
	public void clickSortByAndSelectCustomerTopRated() throws InterruptedException {
	    
	    js.executeScript("window.scrollBy(0,300)", "");
	    driver.findElement(By.xpath("(//span[text()='popularity'])[1]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
	    Thread.sleep(3000);
	   
	}

	@Given("Click Category and click Shampoo")
	public void clickCategoryAndClickShampoo() {
		js.executeScript("window.scrollBy(0,500)", "");
	    driver.findElement(By.xpath("//div[text()='Category']")).click();
	    driver.findElement(By.xpath("(//span[contains(text(),'Shampoo')])[1]")).click();
	}

	@Given("check whether the Filter is applied with Shampoo")
	public void checkWhetherTheFilterIsAppliedWithShampoo() {
	    if(driver.findElement(By.xpath("//ul[@class='pull-left applied-filter-lists']/li[contains(text(),'Shampoo')]")).getText().contains("Shampoo")) {
	    	System.out.println("Filter applied with Shampoo");
	    } else System.out.println("Filter not applied");
	   
	}

	@Given("Click on L'Oreal Paris Colour Protect Shampoo")
	public void clickOnLOrealParisColourProtectShampoo() {
	    driver.findElement(By.xpath("//span[contains(text(),'Paris Colour Protect Shampoo')]")).click();
	   
	}

	@Given("GO to the new window and select size as 360ml and Print the MRP of the product and Click on ADD to BAG")
	public void goToTheNewWindowAndSelectSizeAsMl() throws InterruptedException {
		List<String> list = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(list.get(2));
	    driver.findElement(By.xpath("//span[text()='360ml']")).click();
	    String price = driver.findElement(By.xpath("(//span[@class='post-card__content-price-offer'])[1]")).getText();
	    System.out.println("Price of 360ml = "+price);
	    Thread.sleep(1000);
	    WebElement addToBag = driver.findElement(By.xpath("(//div[@class='pull-left'])[1]"));
	    addToBag.click();
	    Thread.sleep(6000);
	
	}

	@Given("Go to Shopping Bag and Make quantity as 2")
	public void goToShoppingBagAndMakeQuantityAs2() throws InterruptedException {
	    driver.findElement(By.xpath("//div[@class='AddToBagbox']")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//div[@class='qty modifiable']")).click();
	    driver.findElement(By.xpath("//ul[@class='prl5 mb0']/li[2]")).click();
	    Thread.sleep(2000);
	    
	}

	@Given("Print the Grand Total amount")
	public void printTheGrandTotalAmount() {
	    String grandTotal = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
	    System.out.println("Grand Total = "+grandTotal);
	}

	@Given("Click Proceed")
	public void clickProceed() {
	    driver.findElement(By.xpath("//span[text()='Proceed']")).click();
	   
	}

	@Given("Click on Continue as Guest")
	public void clickOnContinueAsGuest() {
	    driver.findElement(By.xpath("//button[contains(text(),'CONTINUE AS GUEST')]")).click();
	   
	}

	@Then("Print the warning message --> delay in shipment")
	public void printTheWarningMessageDelayInShipment() {
	    System.out.println(driver.findElement(By.xpath("//div[@class='layout horizontal center message']")).getText());

	}
}
