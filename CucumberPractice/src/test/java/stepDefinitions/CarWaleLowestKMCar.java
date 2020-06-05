package stepDefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CarWaleLowestKMCar {
	
	public ChromeDriver driver;
	
	@Given("Go to https://www.carwale.com/")
	public void goToHttpsWwwCarwaleCom() {
	    
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.carwale.com");
	    WebElement closeChatFrame = driver.findElement(By.id("verloop-iframe"));
	    driver.switchTo().frame(closeChatFrame);
	    WebElement closeLiveChat = driver.findElement(By.xpath("//div[@class='close js-close-livechat']"));
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.visibilityOf(closeLiveChat)).click();
	    driver.switchTo().parentFrame();
	}

	@Given("Click on Used")
	public void clickOnUsed() throws InterruptedException {
	   
	   driver.findElement(By.xpath("//li[@data-tabs='usedCars']")).click();
	   Thread.sleep(2000);
	}

	@Given("Select the City as Chennai")
	public void selectTheCityAsChennai() throws InterruptedException {
		
	    WebElement cityTextField = driver.findElement(By.xpath("//input[@id='usedCarsList']"));
	    cityTextField.sendKeys("Chennai");
	    Thread.sleep(2000);
	    cityTextField.sendKeys(Keys.TAB);
	    Thread.sleep(2000);
	   
	}

	@Given("Select budget min 9L and max 12L and Click Search")
	public void selectBudgetMinLAndMaxLAndClickSearch() throws InterruptedException {
	    
		driver.findElement(By.id("minInput")).sendKeys("9",Keys.TAB,"12", Keys.TAB);
		driver.findElement(By.id("btnFindCar")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//a[@class='nomoreTips cur-pointer'])[1]")).click();
	   
	}

	@Given("Select Cars with Photos under Only Show Cars With")
	public void selectCarsWithPhotosUnderOnlyShowCarsWith() throws InterruptedException {
	    driver.findElement(By.name("CarsWithPhotos")).click();
	    Thread.sleep(2000);
	}

	@Given("Select Manufacturer as BMW --> 3-Series")
	public void selectManufacturerAsBMW() throws InterruptedException {
	    driver.findElement(By.xpath("//li[@data-manufacture-en='BMW']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//span[text()='3-Series']")).click();
	    
	}

	@Given("Select Fuel Type as Diesel")
	public void selectFuelTypeAsDiesel() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		WebElement fuelType = driver.findElement(By.xpath("//h3[text()[normalize-space()='Fuel Type']]"));
		fuelType.click();
	    Thread.sleep(2000);
	    driver.findElement(By.name("Diesel")).click();
	    Thread.sleep(2000);
	    
	}

	@Given("Select Best Match as KM: Low to High")
	public void selectBestMatchAs() {
		WebElement sort = driver.findElement(By.id("sort"));
	    Select select = new Select(sort);
	    sort.click();
	    select.selectByVisibleText("KM: Low to High");
	   
	}

	@Given("Validate the Cars are listed with KMs Low to High")
	public void validateTheCarsAreListedWithKMsLowToHigh() throws InterruptedException {
	    List<WebElement> listOfKMs = driver.findElements(By.xpath("//span[@class='slkms vehicle-data__item']"));
	    for (int i = 0; i < listOfKMs.size(); i++) {
			System.out.println(listOfKMs.get(i).getText());
		}
	    Thread.sleep(2000);
	}

	@Given("Add the least KM ran car to Wishlist")
	public void addTheLeastKMRanCarToWishlist() throws InterruptedException {
	    driver.findElement(By.xpath("(//span[@class='shortlist-icon--inactive shortlist'])[1]")).click();
	    Thread.sleep(2000);
	   
	}

	@Given("Go to Wishlist and Click on More Details")
	public void goToWishlistAndClickOnMoreDetails() throws InterruptedException {
	    WebElement img = driver.findElement(By.xpath("(//img[@class='lazy car-item__image'])[1]"));
	    Actions builder = new Actions(driver);
	    builder.moveToElement(img).perform();
	    WebElement wishListBtn = driver.findElement(By.xpath("//li[text()='& Compare']"));
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.visibilityOf(wishListBtn)).click();
	    Thread.sleep(2000);
	    String parentHandle = driver.getWindowHandle();
	    driver.findElement(By.linkText("More details »")).click();
	    Thread.sleep(2000);
	    List<String> list = new ArrayList<>(driver.getWindowHandles());
	    driver.switchTo().window(list.get(1));
	}

	@When("Print all the details under Overview in the Same way as displayed in application")
	public void printAllTheDetailsUnderOverviewInTheSameWayAsDisplayedInApplication() throws InterruptedException {
		
		System.out.println(driver.getTitle());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)", "");
	    WebElement table = driver.findElement(By.xpath("(//ul)[22]"));
	    List<WebElement> allRows = table.findElements(By.tagName("li"));
	    int rowsCount = allRows.size();
	    for (int i = 0; i < rowsCount; i++) {
			WebElement firstRow = allRows.get(i);
			List<WebElement> allColumn = firstRow.findElements(By.tagName("div"));
			System.out.println(allColumn.get(0).getText()+" --> "+allColumn.get(1).getText());
		}
	}
		

	@Then("Close the browser")
	public void closeTheBrowser() {
	    driver.quit();
	   
	}
}
