package stepDefinitions;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JustDialFlightTicketReservation extends BaseClass {
	
	Actions builder = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	@SuppressWarnings("deprecation")
	WebDriverWait wait = new WebDriverWait(driver, 15);
	
	int totalPrice;
	
	@Given("https://www.justdial.com")
	public void httpsWwwJustdialCom() {
	    driver.get("https://www.justdial.com");
	    
	}

	@Given("Cick on Air Tickets")
	public void cickOnAirTickets() {
	    driver.findElement(By.xpath("//span[@id='hotkeys_text_4']")).click();
	    
	}

	@Given("Type Chennai and choose Chennai, IN - Chennai Airport \\(MAA) as Leaving From")
	public void typeChennaiAndChooseChennaiINChennaiAirportMAAAsLeavingFrom() throws InterruptedException {  
	    WebElement departure = driver.findElement(By.id("departure"));
	    departure.sendKeys("Chennai"); Thread.sleep(2000);
	    departure.sendKeys(Keys.ENTER); Thread.sleep(1000);
	}

	@Given("Type Toronto and select Toronto, CA - Toronto City Centre Airport \\(YTZ) as Going To")
	public void typeTorontoAndSelectTorontoCATorontoCityCentreAirportYTZAsGoingTo() throws InterruptedException {
		WebElement arrival = driver.findElement(By.id("arrival"));
	    arrival.sendKeys("Toronto"); Thread.sleep(2000);
	    arrival.sendKeys(Keys.ARROW_DOWN,Keys.ENTER); Thread.sleep(1000);
	    
	}

	@Given("Set Departure as 2020, July 22")
	public void setDepartureAsJuly() throws InterruptedException {
	    WebElement nextArrowBtnInCalendar = driver.findElement(By.xpath("//a[@title='Next']"));
	    js.executeScript("arguments[0].click()", nextArrowBtnInCalendar); Thread.sleep(1000);
	    driver.findElement(By.xpath("//a[text()='22']")).click();
	    
	}

	@Given("Add Adult 2, Children 1 click and Search")
	public void addAdultChildrenClickAndSearch() {
	    driver.findElement(By.xpath("(//span[@class='plus'])[1]")).click();
	    driver.findElement(By.xpath("(//span[@class='plus'])[2]")).click();
	    driver.findElement(By.xpath("//input[@value='SEARCH']")).click();
	    
	}

	@Given("Select Air Canada from multi-airline itineraries")
	public void selectAirCanadaFromMultiAirlineItineraries() throws InterruptedException {
	    WebElement AirCanada = driver.findElement(By.xpath("//label[text()='Air Canada(AC)']"));
	    wait.until(ExpectedConditions.visibilityOf(AirCanada)).getText();
	    js.executeScript("arguments[0].click()", AirCanada); Thread.sleep(2000);
	}

	@Given("Click on Price to sort the result")
	public void clickOnPriceToSortTheResult() throws InterruptedException {
	    driver.findElement(By.xpath("//a[normalize-space(text())='Price']")).click();
	    Thread.sleep(2000);
	}

	@Given("Click on +Details of first result under Price")
	public void clickOnDetailsOfFirstResultUnderPrice() throws InterruptedException {
	    
	    WebElement plusDetails = driver.findElement(By.xpath("//a[@id='resTD1']"));
	    js.executeScript("arguments[0].click()", plusDetails); Thread.sleep(2000);
	}

	@Given("Capture the Flight Arrival times.")
	public void captureTheFlightArrivalTimes() {
		HashMap<String, String> map = new HashMap<String, String>();
		
		List<WebElement> ArrivalTime = driver.findElements(By.xpath("(//tbody)[8]/tr/td[6]"));
		List<WebElement> ArrivalDates = driver.findElements(By.xpath("//tr[@class='childText']/td[4]/span"));
		
		for (int i = 0; i < ArrivalTime.size(); i++) {
			map.put(ArrivalTime.get(i).getText(), ArrivalDates.get(i).getText());
		}
		System.out.println("Arrival time with respective dates as below :- ");
		map.entrySet().forEach(result->System.out.println("Arrival time: "+result.getKey()+" --> "+"Arrival date: "+result.getValue()));
		System.out.println();
	}

	@Given("Capture the total price and Click on Book")
	public void captureTheTotalPriceInAListAndClickOnBook() throws InterruptedException {
	    totalPrice = Integer.parseInt(driver.findElement(By.xpath("((//li[@class='detHead']/following::li)[9]/div)[1]")).getText().replaceAll("[^0-9]", ""));
	    System.out.println("Total price in Rupees : "+totalPrice);
	    System.out.println();
	    //Thread.sleep(4000);
	    driver.findElement(By.xpath("(//a[text()='BOOK'])[1]")).click();
	}

	@When("Capture the Airport name base on the list of time")
	public void captureTheAirportNameBaseOnTheListOfTime() throws InterruptedException {
		HashMap<String, String> map = new HashMap<String, String>();
		List<WebElement> ArrivalTime = driver.findElements(By.xpath("(//tbody)[3]/tr/td[6]"));
		List<WebElement> ArrivalAirports = driver.findElements(By.xpath("//tr[@class='childText']/td[4]"));
		for (int i = 0; i < ArrivalTime.size(); i++) {
			map.put(ArrivalTime.get(i).getText(), ArrivalAirports.get(i).getText());
		}
		System.out.println("Arrival time with respective Airport name and Date as below :- ");
		map.entrySet().forEach(result->System.out.println("Arrival time: "+result.getKey()+" --> "+"Airport name and Date: "+result.getValue()+"\n"));
		System.out.println();
		// Thread.sleep(4000);
	}

	@Then("Capture the total fare and print the difference amount from previous total price")
	public void captureTheTotalFareAndPrintTheDifferenceAmountFromPreviousTotalPrice() {
		
	    int totalFare = Integer.parseInt(driver.findElement(By.id("totalFare")).getText().replaceAll("[^0-9]", ""));
	    System.out.println("Total fare in Rupees : "+totalFare);
	    System.out.println();
	    System.out.println("The difference amount in Rupees : "+(totalFare-totalPrice));
	    System.out.println();
	}
}
