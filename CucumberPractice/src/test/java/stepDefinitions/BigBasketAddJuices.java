package stepDefinitions;

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

public class BigBasketAddJuices extends BaseClass {
	
	Actions build = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	WebDriverWait wait = new WebDriverWait(driver,15);
	
	@Given("Go to link https://www.bigbasket.com")
	public void goToLinkHttpsWwwBigbasketCom() {   
	   driver.get("https://www.bigbasket.com");
	}
	
	@Given("click on Address")
	public void clickOnAddress() {
		WebElement address = driver.findElement(By.xpath("//span[@class='hvc']"));
		js.executeScript("arguments[0].click()", address);
	   
	}

	@Given("Select Chennai as City, (.*) as Area and click Continue")
	public void selectChennaiAsCityTNagarAsAreaAndClickContinue(String data) throws InterruptedException {
		driver.findElement(By.xpath("(//span[@class='btn btn-default form-control ui-select-toggle'])[1]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("(//a[@class='ui-select-choices-row-inner'])[5]")).click();
	    Thread.sleep(1000);
	    WebElement area = driver.findElement(By.id("areaselect"));
	    area.sendKeys(data);
	    Thread.sleep(2000);
	    area.sendKeys(Keys.DOWN,Keys.TAB);
	    Thread.sleep(1000);
	    driver.findElement(By.name("continue")).click();
	    Thread.sleep(3000);
	   
	}

	@Given("mouse over on to Shop by Category")
	public void mouseOverOnToShopByCategory() {
		WebElement shopByCategory = driver.findElement(By.xpath("//a[@class='dropdown-toggle meganav-shop']"));
		wait.until(ExpectedConditions.visibilityOf(shopByCategory)).isDisplayed();
	    build.moveToElement(shopByCategory).perform();
	   
	}

	@Given("Go to Beverages and Fruit juices & Drinks")
	public void goToBeveragesAndFruitJuicesDrinks() throws InterruptedException {
		Thread.sleep(1000);
	    WebElement beverages = driver.findElement(By.xpath("(//a[text()='Beverages'])[2]"));
	    build.moveToElement(beverages).perform(); Thread.sleep(1000);
	    WebElement fruitJuices = driver.findElement(By.xpath("(//a[text()='Fruit Juices & Drinks'])[2]"));
	    build.moveToElement(fruitJuices).perform(); Thread.sleep(1000);
	}

	@Given("Click on JUICES")
	public void clickOnJUICES() {
		driver.findElement(By.xpath("(//a[text()='Juices'])[2]")).click();
	   
	}

	@Given("click Tropicana and Real under Brand")
	public void clickTropicanaAndRealUnderBrand() throws InterruptedException {
	    WebElement real = driver.findElement(By.xpath("(//span[text()='Real'])[1]/parent::label"));
	    WebElement Tropicana = driver.findElement(By.xpath("(//span[text()='Tropicana'])[1]/parent::label"));
	    Tropicana.click(); real.click(); Thread.sleep(4000);
	}

	@Given("Check count of the products from each Brands and total count")
	public void checkCountOfTheProductsFromEachBrandsAndTotalCount() {
	    int realJuiceCount = driver.findElements(By.xpath("//h6[text()='Real']")).size();
	    int tropicanaJuiceCount = driver.findElements(By.xpath("//h6[text()='Tropicana']")).size();
	    int totalProductCount = driver.findElements(By.xpath("//div[@qa='product_name']")).size();
	    System.out.println("Real Juice Count : "+realJuiceCount);
	    System.out.println("Tropicana Juice Count : "+tropicanaJuiceCount);
	    System.out.println("Total Count : "+totalProductCount);
	    if(totalProductCount==realJuiceCount+tropicanaJuiceCount)
	    	System.out.println("Both the count matches");
	    else System.out.println("Both the count doesn't match");
	    System.out.println();
	}

	@Given("Check whether the products is availabe with Add button.")
	public void checkWhetherTheProductsIsAvailabeWithAddButton() {
	    
	   List<WebElement> productsWithAddButton = driver.findElements(By.xpath("//button[@qa='add']"));
	   List<WebElement> productsWithNotifyMeButton = driver.findElements(By.xpath("//button[@qa='NM']"));
	   
	   System.out.println("List of products name available with Add Button : ");
	   for (int i = 1; i < productsWithAddButton.size(); i++) {
		 WebElement addBtnPrdtName = driver.findElement(By.xpath("(((//button[@qa='add'])["+i+"]/ancestor::div)[12]/child::div)/a"));
		 System.out.println(addBtnPrdtName.getText());
	   } System.out.println();
		
	   System.out.println("List of products name available with Notify Me Button : ");
	   for (int j = 1; j < productsWithNotifyMeButton.size(); j++) {
	     WebElement NotifyMePrdtName = driver.findElement(By.xpath("(((//button[@qa='NM'])["+j+"]/ancestor::div)[12]/child::div)/a"));
		 System.out.println(NotifyMePrdtName.getText());
	   } System.out.println();
	}

	@Given("Add the First listed available product")
	public void addTheFirstListedAvailableProduct() throws InterruptedException {
	    driver.findElement(By.xpath("(//button[@qa='add'])[1]")).click();
	    WebElement closeBtn = driver.findElement(By.xpath("//button[@class='toast-close-button']"));
	    wait.until(ExpectedConditions.visibilityOf(closeBtn)).click();
	}

	@Given("Mouse over on My Basket print the product name. count and price.")
	public void mouseOverOnMyBasketPrintTheProductNameCountAndPrice() throws InterruptedException {
		WebElement basket = driver.findElement(By.xpath("//span[@title='Your Basket']"));
		build.moveToElement(basket).perform(); Thread.sleep(3000);
		WebElement productName = driver.findElement(By.xpath("//a[@qa='prodNameMB']"));
		WebElement count = driver.findElement(By.xpath("//input[@id='p_10000246']"));
		WebElement price = driver.findElement(By.xpath("//span[@qa='priceMB']"));
		System.out.println("Product Name : "+productName.getText());
		System.out.println("Quantity : "+count.getText());
		System.out.println("Price : "+price.getText());
		Thread.sleep(3000);
	}

	@When("Click View Basket & Checkout")
	public void clickViewBasketCheckout() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='View Basket & Checkout']")).click();
	    Thread.sleep(2000);
	   
	}

	@Then("Click the close button")
	public void clickTheCloseButton() {
		WebElement dismissBtn = driver.findElement(By.xpath("(//button[@class='close'])[1]"));
	    js.executeScript("arguments[0].click()", dismissBtn);
	   
	}

}
