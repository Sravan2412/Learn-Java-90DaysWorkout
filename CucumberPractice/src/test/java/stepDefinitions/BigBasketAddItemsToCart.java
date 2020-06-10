package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BigBasketAddItemsToCart extends BaseClass{
	
	Actions build = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, 15);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	TakesScreenshot scrShot = (TakesScreenshot)driver;

	@Given("Go to https://www.bigbasket.com")
	public void goToHttpsWwwBigbasketCom() throws InterruptedException {
	    driver.get("https://www.bigbasket.com");
	    
	    // Setting Chennai as city at an initial stage itself
	    WebElement address = driver.findElement(By.xpath("//span[@class='hvc']"));
		js.executeScript("arguments[0].click()", address);
		driver.findElement(By.xpath("(//span[@class='btn btn-default form-control ui-select-toggle'])[1]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("(//a[@class='ui-select-choices-row-inner'])[5]")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//button[text()='Continue']")).click();
	    Thread.sleep(3000);
	}

	@Given("mouse over on  Shop by Category")
	public void mouseOverOnShopByCategory() {
	    WebElement shopByCategory = driver.findElement(By.xpath("//a[@class='dropdown-toggle meganav-shop']"));
	    build.moveToElement(shopByCategory).perform();
	}

	@Given("Go to FOODGRAINS, OIL & MASALA and RICE & RICE PRODUCTS")
	public void goToFOODGRAINSOILMASALAAndRICERICEPRODUCTS() throws InterruptedException {
		Thread.sleep(2000);
	    WebElement foodGrains = driver.findElement(By.xpath("(//a[text()='Foodgrains, Oil & Masala'])[2]"));
	    build.moveToElement(foodGrains).perform(); Thread.sleep(2000);
	    WebElement products = driver.findElement(By.xpath("(//a[text()='Rice & Rice Products'])[2]"));
	    build.moveToElement(products).perform(); Thread.sleep(2000);
	}

	@Given("Click on BOILED & STEAM RICE")
	public void clickOnBOILEDSTEAMRICE() {
	    driver.findElement(By.xpath("(//a[text()='Boiled & Steam Rice'])[2]")).click();
	    
	}

	@Given("Get the URL of the page and check with site navigation link\\(HOME > FOODGRAINS, OIL & MASALA> RICE & RICE PRODUCTS> BOILED & STEAM RICE)")
	public void getTheURLOfThePageAndCheckWithSiteNavigationLinkHOMEFOODGRAINSOILMASALARICERICEPRODUCTSBOILEDSTEAMRICE() throws InterruptedException {
	    String currentUrl = driver.getCurrentUrl().replaceAll("[^a-z]", "");
	    List<WebElement> navigation = driver.findElements(By.xpath("//div[@style='display: inline;']"));
	    String text = " ";
	    for (WebElement eachNavigation : navigation) {
			text = eachNavigation.getText();
		}
	    String navigationInLowercase = text.toLowerCase().replaceAll("[^a-z]", "");
	    if(currentUrl.contains(navigationInLowercase)) {
	    	System.out.println("Site Navigation link is syncing with URL of the page");
	    } else { System.out.println("Site Navigation link is not syncing with URL of the page");  }
	    Thread.sleep(1000);
	    System.out.println();
	}

	@Given("Choose the Brand as bb Royal")
	public void chooseTheBrandAsBbRoyal() {
		js.executeScript("window.scrollBy(0,200)", "");
	    driver.findElement(By.xpath("(//span[text()='bb Royal'])[1]")).click();
	    
	}

	@Given("Go to Ponni Boiled Rice and select {int}kg bag from Dropdown")
	public void goToPonniBoiledRiceAndSelectKgBagFromDropdown(Integer int1) throws InterruptedException {
		Thread.sleep(3000);
	    WebElement dropdown = driver.findElement(By.xpath("(//span[@data-bind='label'])[1]"));
	    wait.until(ExpectedConditions.visibilityOf(dropdown)).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("(//span[text()='10 kg'])[3]")).click();
	    
	}

	@Given("Click Add button")
	public void clickAddButton() {
	    driver.findElement(By.xpath("(//button[@class='btn btn-add col-xs-9'])[1]")).click();
	    js.executeScript("window.scrollBy(0,-200)", "");
	}

	@Given("Go to search box and type Dal")
	public void goToSearchBoxAndTypeDal() throws InterruptedException {
	    WebElement searchBar = driver.findElement(By.xpath("//input[@qa='searchBar']"));
	    wait.until(ExpectedConditions.visibilityOf(searchBar)).sendKeys("Dal");
	    Thread.sleep(3000);
	}

	@Given("Add Toor\\/Arhar Dal two kg and set Qty {int} from the list")
	public void addToorArharDalKgAndSetQtyFromTheList(Integer int1) throws InterruptedException {
		WebElement qty = driver.findElement(By.xpath("//div[@id='search-found']/div[1]/div[1]/div[1]/div[1]/ul[1]/li[8]/div[1]/div[7]/div[1]/input[1]"));
	    qty.clear();
	    qty.sendKeys(String.valueOf(int1));
	    driver.findElement(By.xpath("//div[@id='search-found']/div[1]/div[1]/div[1]/div[1]/ul[1]/li[8]/div[1]/div[8]/button[1]/span[1]")).click();
	    Thread.sleep(2000);
	    build.moveToElement(driver.findElement(By.xpath("(//span[text()='bb Royal'])[1]"))).perform();
	}

	@Given("click Address")
	public void clickAddress() {
	   js.executeScript("window.scrollBy(0,-300)", "");
	   WebElement address = driver.findElement(By.xpath("//span[@class='hvc']"));
	   js.executeScript("arguments[0].click()", address);
	   
	}

	@Given("Select CHennai as City, Alandur-600016,Chennai as Area  and click Continue")
	public void selectCHennaiAsCityAlandurChennaiAsAreaAndClickContinue() throws InterruptedException {
	    driver.findElement(By.xpath("(//span[@class='btn btn-default form-control ui-select-toggle'])[1]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("(//a[@class='ui-select-choices-row-inner'])[5]")).click();
	    WebElement area = driver.findElement(By.id("areaselect"));
	    area.sendKeys("Alandur");
	    Thread.sleep(2000);
	    area.sendKeys(Keys.DOWN,Keys.TAB);
	    Thread.sleep(1000);
	    driver.findElement(By.name("continue")).click();
	}

	@Given("Mouse over on My Basket take a screen shot")
	public void mouseOverOnMyBasketTakeAScreenShot() throws IOException, InterruptedException {
	    WebElement myBasket = driver.findElement(By.className("basket-content"));
	    wait.until(ExpectedConditions.visibilityOf(myBasket)).getText();
	    build.moveToElement(myBasket).perform();
	    Thread.sleep(2000);
	    File source = scrShot.getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(source, new File("./Screenshots/Screen.png"));
	    System.out.println("The Screenshot is taken successfully");
	    Thread.sleep(2000);
	    
	}

	@When("Click View Basket and Checkout")
	public void clickViewBasketAndCheckout() throws InterruptedException {
	    driver.findElement(By.xpath("//button[text()='View Basket & Checkout']")).click();
	    Thread.sleep(2000);
	}

	@Then("Click the close button and close the browser")
	public void clickTheCloseButtonAndCloseTheBrowser() {
		
	    WebElement dismissBtn = driver.findElement(By.xpath("(//button[@class='close'])[1]"));
	    js.executeScript("arguments[0].click()", dismissBtn);
	}
	
}
