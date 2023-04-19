package Hibiscus;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SauceDemo {
	public static String url = "https://www.saucedemo.com/";
	WebDriver driver;

@BeforeTest
public void bt() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
}
@Test(priority = 0,dataProvider = "provideData")
public void login(String userName, String userPassword) {
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	String beforelogin = driver.getTitle();
	WebElement username = driver.findElement(By.xpath("//*[@placeholder='Username']"));
	if(username.isEnabled());
	username.sendKeys(userName);
	WebElement password = driver.findElement(By.xpath("//*[@placeholder='Password']"));
	if(password.isEnabled());
	password.sendKeys(userPassword);
	driver.findElement(By.id("login-button")).click();
	String afterlogin = driver.getTitle();
	Assert.assertEquals(afterlogin, beforelogin);
	System.out.println("titles are same");
}
@Test(priority = 1, dependsOnMethods = "login", alwaysRun = true)
public void filters() {
	driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	WebElement filter = driver.findElement(By.xpath("//*[@class='product_sort_container']"));
	filter.click();
	Select s = new Select(filter);
	s.selectByIndex(3);
	
	
}
@Test(priority = 2)
public void Select() throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	WebElement dress = driver.findElement(By.xpath("//*[@id='item_5_title_link']"));
	dress.click();
	driver.findElement(By.name("add-to-cart-sauce-labs-fleece-jacket")).click();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 driver.findElement(By.id("remove-sauce-labs-fleece-jacket")).click();
	//jacket.click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@name='back-to-products']")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("item_1_title_link")).click();
	Thread.sleep(3000);
	driver.findElement(By.name("add-to-cart-sauce-labs-bolt-t-shirt")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@class='shopping_cart_link']")).click();
	Thread.sleep(3000);
	driver.findElement(By.name("checkout")).click();
	Thread.sleep(3000);
	driver.findElement(By.name("firstName")).sendKeys("debo");
	Thread.sleep(3000);
	driver.findElement(By.name("lastName")).sendKeys("lina");
	Thread.sleep(3000);
	driver.findElement(By.name("postalCode")).sendKeys("123456");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@value='Continue']")).click();
	Thread.sleep(3000);
	driver.findElement(By.name("finish")).click();
	Thread.sleep(3000);
	driver.findElement(By.name("back-to-products")).click();
	
	JavascriptExecutor js= ((JavascriptExecutor)driver);    
    
	
	js.executeScript("window.scrollBy(0,500)");
	List<WebElement> link= driver.findElements(By.tagName("a"));
	link.size();
	System.out.println(link.size());
	for(int i =0; i<link.size();i++) {
		//System.out.println(link.get(i).getText());
		System.out.println(link.get(i).getAttribute("href"));
	}
}
@DataProvider
public Object[] provideData(){
	return new Object[][] {
		new Object[] {"standard_user","secret_sauce"}
	};
	
}
	
}