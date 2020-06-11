package stepDefinitions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShopcluesAddingShoesToCart extends BaseClass {
	
	Actions build = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	WebDriverWait wait = new WebDriverWait(driver, 15);
	
	@Given("Go to https://www.shopclues.com")
	public void goToHttpsWwwShopcluesCom() {
	    driver.get("https://www.shopclues.com");
	   
	}

	@Given("Mouseover on men and click Casual Shoes")
	public void mouseoverOnWomenAndClickCasualShoes() {
	    driver.findElement(By.xpath("(//button[contains(text(),'Allow')])[1]")).click();
	    WebElement men = driver.findElement(By.xpath("//a[text()='MEN']"));
	    build.moveToElement(men).perform();
	    WebElement casShoes = driver.findElement(By.xpath("(//a[text()='Casual Shoes'])[2]"));
	    js.executeScript("arguments[0].click()", casShoes);
	}

	@Given("Select Color as Black")
	public void selectColorAsBlack() throws InterruptedException {
	    List<String> list = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(list.get(1));
	    js.executeScript("window.scrollBy(0,1500)", "");
	    WebElement color = driver.findElement(By.xpath("//label[@for='Black']"));
	    wait.until(ExpectedConditions.visibilityOf(color)).getText();
	    js.executeScript("arguments[0].click()", color);
	    Thread.sleep(1000);
	}

	@Given("Check whether the product name contains the word black")
	public void checkWhetherTheProductNameContainsTheWordBlack() throws InterruptedException {
	    List<WebElement> pdNames = driver.findElements(By.xpath("//span[@class='prod_name ' or @class='prod_name  mii ']"));
	    System.out.println(pdNames.size());
	    for (WebElement eachName : pdNames) {
			if(eachName.getText().toLowerCase().contains("black")) {
				System.out.println("Product name contains the word black");
			} else { System.out.println("Product name doesn't contains the word black");           }
		} System.out.println();
	}

	@Given("If so, add the product name and price in to Map")
	public void ifSoAddTheProductNameAndPriceInToMap() throws InterruptedException {
		List<WebElement> pdNames = driver.findElements(By.xpath("//span[@class='prod_name ' or @class='prod_name  mii ']"));
	    List<WebElement> pdPrices = driver.findElements(By.xpath("//span[@class='p_price']"));
	    Map<String, String> map = new LinkedHashMap<String, String>();
	    for (int i = 0; i < pdNames.size(); i++) {
	    	for (int j = 0; j < pdPrices.size(); j++) {
	    	map.put(pdNames.get(i).getText(), pdPrices.get(j).getText());
	    	
		}} map.entrySet().forEach(result->{
    		System.out.println(result.getKey()+" --> "+result.getValue());
		    					  });
		System.out.println();
		Thread.sleep(1000);
	}

	@Given("Check Display the count of shoes which are more than 500 rupees")
	public void checkDisplayTheCountOfShoesWhichAreMoreThanRupees() throws InterruptedException {
	    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[@for='Rs. 500 - Rs. 999']")))).click();  Thread.sleep(1000);
	    driver.findElement(By.xpath("//label[@for='Rs. 1000 - Rs. 1999']")).click();  Thread.sleep(1000);
	    driver.findElement(By.xpath("//label[@for='Rs. 2000 and Above']")).click(); Thread.sleep(2000);
	   
	}

	@Given("Click the highest price of the shoe")
	public void clickTheHighestPriceOfTheShoe() throws InterruptedException {
	    WebElement sortByHighPrice = driver.findElement(By.xpath("//a[text()='High Price']"));
	    js.executeScript("arguments[0].click()", sortByHighPrice);
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("(//span[@class='prod_name '])[1]")).click();
	}

	@Given("Get the current page URL and check with the product ID")
	public void getTheCurrentPageURLAndCheckWithTheProductID() {
		List<String> list = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(list.get(2));
	    String currentUrl = driver.getCurrentUrl();
	    String productID = driver.findElement(By.xpath("//span[@class='pID']")).getText().replaceAll("[^0-9]", "");
	    if(currentUrl.contains(productID)) {
	    	System.out.println("Current url matches with the Product ID");
	    } else { System.out.println("Current url is not matches with the Product ID");      }
	   System.out.println();
	}

	@Given("Copy the offercode")
	public void copyTheOffercode() throws InterruptedException {
	    String offerCode = driver.findElement(By.xpath("(//div[@class='coupons_code'])[1]")).getText();
	    Thread.sleep(2000);
	}

	@Given("Select size, color and click ADD TO CART")
	public void selectSizeColorAndClickADDTOCART() throws InterruptedException {
	    driver.findElement(By.xpath("//span[@class='variant var ']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[@id='add_cart']")).click();
	    Thread.sleep(1000);
	}

	@When("Mouse over on Shopping cart and click View Cart")
	public void mouseOverOnShoppingCartAndClickViewCart() {
	    WebElement cart = driver.findElement(By.xpath("//a[@class='cart_ic']"));
	    build.moveToElement(cart).perform();
	    driver.findElement(By.xpath("//a[@class='btn orange-white btn_effect']")).click();
	}

	@Then("Type Pincode as 600078 click Submit and Place Order")
	public void typePincodeAsClickSubmitAndPlaceOrder() throws InterruptedException {
	    driver.findElement(By.xpath("//input[@id='pin_code_popup']")).sendKeys("600078");
	    driver.findElement(By.xpath("//input[@id='get_pincode_popup']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//div[@class='btn orange']")).click();
	   
	}
}
