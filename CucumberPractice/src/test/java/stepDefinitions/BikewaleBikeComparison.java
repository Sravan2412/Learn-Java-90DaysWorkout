package stepDefinitions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BikewaleBikeComparison extends BaseClass {
	
	Actions builder = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	WebDriverWait wait = new WebDriverWait(driver, 15);
	
	@Given("Go to https://www.bikewale.com")
	public void goToHttpsWwwBikewaleCom() {
	    driver.get("https://www.bikewale.com");
	}

	@Given("Go to menu and click new bikes")
	public void goToMenuAndClickNewBikes() throws InterruptedException {
	   WebElement menu = driver.findElement(By.xpath("//span[@class='navbarBtn nav-icon']"));
	   js.executeScript("arguments[0].click()", menu); Thread.sleep(2000);
	   WebElement newBike = driver.findElement(By.xpath("//span[text()='New Bikes']"));
	   js.executeScript("arguments[0].click()", newBike); Thread.sleep(1000);
	}

	@Given("Click New Bikes Then compare bikes")
	public void clickNewBikesThenCompareBikes() {
	    driver.findElement(By.xpath("//a[text()='Compare Bikes']")).click();
	    
	}

	@Given("Add first bike as Royal Enfield and model as Thunderbird 350")
	public void addFirstBikeAsRoyalEnfieldAndModelAsThunderbird() throws InterruptedException {
	    WebElement add1 = driver.findElement(By.xpath("(//span[@class='add-icon'])[1]"));
	    js.executeScript("arguments[0].click()", add1);
	     Thread.sleep(2000);
	    driver.findElement(By.xpath("//div[@class='chosen-container chosen-container-single']")).click();
	    driver.findElement(By.xpath("//li[text()='Royal Enfield']")).click();
	    driver.findElement(By.xpath("(//div[@class='chosen-container chosen-container-single'])[2]")).click();
	    driver.findElement(By.xpath("//li[text()='Thunderbird 350']")).click();
	}

	@Given("Add second bike Jawa, model as 42 and version Dual Channel ABS - BS VI")
	public void addSecondBikeJawaModelAsAndVersionDualChannelABSBSVI() throws InterruptedException {
		 driver.findElement(By.xpath("(//span[@class='add-icon'])[2]")).click(); Thread.sleep(2000);
		 driver.findElement(By.xpath("(//div[@class='chosen-container chosen-container-single'])[4]")).click();
	  // driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("Jawa");
		 driver.findElement(By.xpath("(//li[text()='Jawa'])[2]")).click();
		 driver.findElement(By.xpath("(//div[@class='chosen-container chosen-container-single'])[5]")).click();
		 driver.findElement(By.xpath("//li[text()='42']")).click();
		 driver.findElement(By.xpath("(//div[@class='chosen-container chosen-container-single'])[6]")).click();
		 driver.findElement(By.xpath("//li[text()='Dual Channel ABS - BS VI']")).click();
	    
	}

	@Given("Add bike brand Kawasaki model as Ninja 300")
	public void addBikeBrandKawasakiModelAsNinja() throws InterruptedException {
		driver.findElement(By.xpath("(//span[@class='add-icon'])[3]")).click(); Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='chosen-container chosen-container-single'])[7]")).click();
		driver.findElement(By.xpath("(//li[text()='Kawasaki'])[3]")).click();
	    driver.findElement(By.xpath("(//div[@class='chosen-container chosen-container-single'])[8]")).click();
		driver.findElement(By.xpath("//li[text()='Ninja 300']")).click(); Thread.sleep(3000);
	}

	@When("click compare")
	public void clickCompare() {
	    
	    driver.findElement(By.xpath("//button[text()='Compare now']")).click();
	}

	@Then("Find and print the maximum overall rating of all the bikes and find the max")
	public void findAndPrintTheMaximumOverallRatingOfAllTheBikesAndFindTheMax() {
	    List<WebElement> overallRatingOfAllBikes = driver.findElementsByXPath("//span[@class='font20 font-bold']");
	    List<WebElement> allTheBikeNames = driver.findElementsByXPath("//a[@class='item-target-link underline-none ']/p");
	    Map<String, String> map = new LinkedHashMap<>();
	    
	    System.out.println("Overall Rating of all the bikes with respected Bike names : ");
	    for (int i = 0; i < overallRatingOfAllBikes.size(); i++) {
			map.put(allTheBikeNames.get(i).getText(), overallRatingOfAllBikes.get(i).getText());
		}
	    map.entrySet().forEach(result->System.out.println("Bike name :"+result.getKey()+" --> "+"Overall rating :"+result.getValue()));
	    System.out.println();
	    List<Double> allRatings = new ArrayList<Double>();
	    for (int i = 0; i < overallRatingOfAllBikes.size(); i++) {
	    	allRatings.add(Double.parseDouble(overallRatingOfAllBikes.get(i).getText()));
	    }
	    System.out.println("All the Ratings:"+allRatings);
	    Collections.sort(allRatings);  System.out.println();
	    System.out.println("The Max Rating:"+Collections.max(allRatings));
		}
	}

