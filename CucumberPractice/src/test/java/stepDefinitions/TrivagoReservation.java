package stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class TrivagoReservation extends BaseClass{
	
	Actions builder = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, 19);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	@Given("Go to https://www.trivago.com")
	public void goToHttpsWwwTrivagoCom() throws InterruptedException {
	    driver.get("https://www.trivago.com");
	   // WebElement okButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
	   // wait.until(ExpectedConditions.visibilityOf(okButton)).click();
	    Thread.sleep(2000);
	    js.executeScript("window.scrollBy(0,150)", "");
	    Thread.sleep(1000);
	}

	@Given("Type Agra in Destination and select Agra, Uttar Pradesh.")
	public void typeAgraInDestinationAndSelectAgraUttarPradesh() {
	    driver.findElement(By.xpath("//input[@id='querytext']")).sendKeys("Agra",Keys.TAB,Keys.TAB);
	    
	}

	@Given("Choose June 21 as check in and June 30 as check out")
	public void chooseMayAsCheckInAndMayAsCheckOut() throws InterruptedException {
		Thread.sleep(2000);
		WebElement calTable = driver.findElement(By.className("cal-month"));
	    driver.findElement(By.xpath("//time[@datetime='2020-06-19']")).click(); Thread.sleep(1000);
	    driver.findElement(By.xpath("//time[@datetime='2020-06-30']")).click(); Thread.sleep(1000);
    
	}

	@Given("Select Room as Family Room")
	public void selectRoomAsFamilyRoom() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Family rooms']")).click(); Thread.sleep(1000);    
	}

	@Given("Choose Number of Adults 2, Childern 1 and set Child's Age as 4")
	public void chooseNumberOfAdultsChildernAndSetChildSAgeAs() throws InterruptedException {
	    WebElement adults = driver.findElement(By.xpath("(//select[@class='df-select'])[1]"));
	    Select selectAdults = new Select(adults);
	    selectAdults.selectByVisibleText("2"); 
	    WebElement children = driver.findElement(By.xpath("(//select[@class='df-select'])[2]"));
	    Select selectChildren = new Select(children);
	    selectChildren.selectByVisibleText("1");
	    Thread.sleep(1000);
	    WebElement childrenAge = driver.findElement(By.xpath("//select[@class='df-select js-select-child-age']"));
	    Select selectChildrenAge = new Select(childrenAge);
	    selectChildrenAge.selectByVisibleText("4");
	}

	@Given("Click Confirm button and click Search")
	public void clickConfirmButtonAndClickSearch() {
	    driver.findElement(By.xpath("//span[text()='Confirm']")).click();
	    //driver.findElement(By.xpath("//span[text()='Search']")).click();
	    
	}

	@Given("Select Accommodation type as Hotels only and choose 4 stars")
	public void selectAccommodationTypeAsHotelsOnlyAndChooseStars() throws InterruptedException {
	    WebElement Accommodation = driver.findElement(By.xpath("//strong[text()='Accommodation']"));
	    builder.moveToElement(Accommodation).perform();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//label[text()='Hotels only']")).click(); Thread.sleep(1000);
	    driver.findElement(By.xpath("(//span[@class='icon-ic filter-components__starBtnIcon--b4956 icon-center'])[4]")).click(); Thread.sleep(1000);
	    driver.findElement(By.xpath("//button[text()='Done']")).click();
	    
	}

	@Given("Select Guest rating as Very good")
	public void selectGuestRatingAsVeryGood() throws InterruptedException {
	    WebElement guestRating = driver.findElement(By.xpath("//strong[text()='Guest rating']")); Thread.sleep(1000);
	    builder.moveToElement(guestRating).perform();
	    driver.findElement(By.xpath("//span[text()='Very good']")).click();
	}

	@Given("Set Hotel Location as Agra Fort and click Done")
	public void setHotelLocationAsAgraFortAndClickDone() throws InterruptedException {
	    WebElement hotelLocation = driver.findElement(By.xpath("//strong[text()='Hotel location']"));
	    builder.moveToElement(hotelLocation).perform(); Thread.sleep(1000);
	    WebElement location = driver.findElement(By.xpath("//select[@id='pois']"));
	    Select selectLocation = new Select(location);
	    selectLocation.selectByVisibleText("Agra Fort");
	    driver.findElement(By.xpath("//button[text()='Done']")).click();
	}

	@Given("In more Filters, select Air conditioning, Restaurant and WiFi and click Done")
	public void inMoreFiltersSelectAirConditioningRestaurantAndWiFiAndClickDone() throws InterruptedException {
	    WebElement moreFilters = driver.findElement(By.xpath("//span[text()='Select']"));
	    builder.moveToElement(moreFilters).perform(); Thread.sleep(1000);
	    
	    driver.findElement(By.xpath("//label[text()='Air conditioning']")).click();
	    driver.findElement(By.xpath("//label[text()='WiFi']")).click();
	    driver.findElement(By.xpath("//label[text()='Restaurant']")).click();
	    driver.findElement(By.xpath("//button[text()='Done']")).click();
	}

	@Given("Sort the result as Rating & Recommended")
	public void sortTheResultAsRatingRecommended() {
	    WebElement sortBy = driver.findElement(By.xpath("//select[@id='mf-select-sortby']"));
	    Select selectSortBy = new Select(sortBy);
	    selectSortBy.selectByVisibleText("Rating & Recommended");
	    
	}

	@Given("Print the Hotel name, Rating, Number of Reviews and Click View Deal")
	public void printTheHotelNameRatingNumberOfReviewsAndClickViewDeal() {
		WebElement contents = driver.findElement(By.xpath("(//span[@class='item-link name__copytext'])[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(contents));
	    System.out.println("Hotel Name is : "+driver.findElement(By.xpath("(//span[@class='item-link name__copytext'])[1]")).getText());
	    System.out.println("Rating is : "+driver.findElement(By.xpath("(//span[@itemprop='ratingValue'])[1]")).getText());
	    System.out.println("Number of Reviews is : "+driver.findElement(By.xpath("(//span[contains(text(),'reviews')])[1]")).getText().replaceAll("[^0-9]", ""));
	    driver.findElement(By.xpath("(//span[text()='View Deal'])[1]")).click();
	}

	@Given("Print the URL of the Page")
	public void printTheURLOfThePage() throws InterruptedException {
	    List<String> list = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(list.get(1));
	    //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Close']")))).click();
		System.out.println("Curent URL is: "+driver.getCurrentUrl());
		Thread.sleep(1000);
	}

	@Given("Print the Price of the Room and click Choose Your Room")
	public void printThePriceOfTheRoomAndClickChooseYourRoom() {
	    WebElement price = driver.findElement(By.xpath("(//div[@class='bui-price-display__value prco-text-nowrap-helper prco-inline-block-maker-helper'])[1]"));
	    System.out.println("Price in US$ = "+price.getText().replaceAll("[^0-9]", ""));
	    driver.findElement(By.xpath("(//a[@class='txp-cta bui-button bui-button--primary sr_cta_button'])[1]")).click();
	}

	@Then("Click Reserve and I'll Reserve")
	public void clickReserveAndILlReserve() throws InterruptedException {
	    driver.findElement(By.xpath("(//button[@id='hp_book_now_button'])[1]")).click();
	    WebElement Rooms = driver.findElement(By.xpath("(//select[@class='hprt-nos-select'])[1]"));
	    wait.until(ExpectedConditions.visibilityOf(Rooms));
	    Select selectRooms = new Select(Rooms);
	    selectRooms.selectByValue("1");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//div[@class='hprt-reservation-cta']")).click();
	}
}
