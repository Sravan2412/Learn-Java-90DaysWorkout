package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SheinAddingJeansToCart extends BaseClass {
	
	Actions build = new  Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, 15);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	@Given("open https://www.shein.in")
	public void openHttpsWwwSheinIn() {    
	    driver.get("https://www.shein.in");
	}

	@Given("Mouseover on Clothing and click Jeans")
	public void mouseoverOnClothingAndClickJeans() throws InterruptedException {
		Thread.sleep(4000);
	    WebElement closeSignin = driver.findElement(By.xpath("(//i[@class='iconfont icon-close she-close'])[19]"));
	    closeSignin.click();
	    WebElement curve = driver.findElement(By.xpath("(//a[@title='PLUS + CURVE'])[1]"));
	    build.moveToElement(curve).perform();
	    WebElement clothing = driver.findElement(By.xpath("//span[text()='CLOTHING']"));
	    build.moveToElement(clothing).perform(); 
	    js.executeScript("arguments[0].click()", driver.findElement(By.xpath("(//a[@title='Jeans'])[1]")));
	   // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[@title='Jeans'])[1]")))).click();
	    
	}

	@Given("choose Black under Jeans product count")
	public void chooseBlackUnderJeansProductCount() throws InterruptedException {
		Thread.sleep(3000);
	    wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[text()='Black']")))).click();
	    
	}

	@Given("check size as medium")
	public void checkSizeAsMedium() throws InterruptedException {
	    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[@class='filter-title leftnav-first-title'])[3]")))).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//a[@data-attr-value_id='417']")).click();
	    
	}

	@Given("check whether the color is black")
	public void checkWhetherTheColorIsBlack() {
		WebElement color = driver.findElement(By.xpath("//span[text()='Black']"));
		System.out.println(color.getText());
		if(color.getText().contains("Black")) System.out.println("Filter is selected with black color");
		else System.out.println("Filter is not selected with black color");
	    
	}

	@Given("Click first item to Add to Bag")
	public void clickFirstItemToAddToBag() {
		js.executeScript("window.scrollBy(0,200)", "");
		WebElement firstResultantImg = driver.findElement(By.xpath("(//img[@alt='Foldover Waist Raw Hem Ripped Jeans'])[1]"));
		build.moveToElement(firstResultantImg).perform();
	    driver.findElement(By.xpath("(//button[normalize-space(text())='+ Add to Bag'])[1]")).click();
	    
	}

	@Given("Click the size as M and click Submit")
	public void clickTheSizeAsMAbdClickSubmit() throws InterruptedException {
		WebElement sizeOfJean = driver.findElement(By.xpath("(//span[@class='opt-real   '])[3]"));
	    wait.until(ExpectedConditions.visibilityOf(sizeOfJean)).click(); Thread.sleep(2000);
	    driver.findElement(By.xpath("(//button[normalize-space(text())='Submit'])[1]")).click();
	    
	}

	@When("Click view Bag")
	public void clickViewBag() {
	    driver.findElement(By.xpath("//a[text()='view bag']")).click();
	    
	}

	@Then("Check the size is Medium or not.")
	public void checkTheSizeIsMediumOrNot() {
	    
	    WebElement size = driver.findElement(By.xpath("//em[contains(text(),'M')]"));
	    if(size.getText().equals("M"))  System.out.println("Yes the size is Medium");
	    else System.out.println("No the size is not Medium");
	}

}
