package week1.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class AutoPortalCar {
	  static ChromeDriver driver;
		
		public static void main(String[] args) throws InterruptedException {
			
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver = new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://autoportal.com/");
		driver.findElement(By.xpath("//div[@class='maincity-in field']")).click();
		WebElement city = driver.findElement(By.id("ac_user_city"));
		city.sendKeys("Chennai");   Thread.sleep(2000);
		city.sendKeys(Keys.DOWN, Keys.ENTER);
		driver.findElement(By.xpath("(//span[@class='red_but'])[1]")).click();  Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@name='brand']")).click();
		driver.findElement(By.xpath("//option[text()='Renault']")).click();
		driver.findElement(By.xpath("//select[@name='model']")).click();
		driver.findElement(By.xpath("//option[text()='Arkana']")).click();
		driver.findElement(By.xpath("//input[@value='Find new cars']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='nm_price-launch-date']//div[1]")).getText());
	}}
