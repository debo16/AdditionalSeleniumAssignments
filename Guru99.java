package Hibiscus;

import java.security.PublicKey;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentTestInterruptedException;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Guru99 {
	public static String url = "https://demo.guru99.com/test/newtours/index.php";
	ExtentReports er;
	ExtentHtmlReporter ehr;
	ExtentTest et;
	WebDriver driver;
	
	@BeforeTest
	public void bt() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		er = new ExtentReports();
		ehr = new ExtentHtmlReporter("extent.html");
		er.attachReporter(ehr);
		et = er.createTest("Beforetest report");
		
		}
	@Test(priority = 0, alwaysRun = true)
	public void login() {
		driver.manage().window().maximize();
		et = er.createTest("report for login");
		String beforelogin = driver.getTitle();
		System.out.println(beforelogin);
		
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		WebElement username = driver.findElement(By.xpath("//*[@type='text']"));
		
		username.sendKeys("user");
		et.pass("entered username");
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		WebElement password = driver.findElement(By.xpath("//*[@type='password']"));
		password.sendKeys("user");
		et.pass("eneterd password");
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		et.info("submit is done successfully");
		String afterlogin = driver.getTitle();
		System.out.println(afterlogin);
		//Assert.assertEquals(afterlogin, beforelogin);
		SoftAssert assert1 = new SoftAssert();
		assert1.assertEquals(afterlogin, beforelogin);
		
		System.out.println("show the titles ");
//		if(afterlogin.equals(beforelogin)){
//		
//		System.out.println("same");
//		}
//		else {
//			System.out.println("not same");
//	}
	}
	@Test(priority = 1, alwaysRun = true)
	public void register() throws InterruptedException {
		et = er.createTest("report for register");
		Thread.sleep(3000);
		driver.findElement(By.linkText("REGISTER")).click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.findElement(By.name("firstName")).sendKeys("debolina");
		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
		driver.findElement(By.name("lastName")).sendKeys("ghosh");
		Thread.sleep(3000);
		driver.findElement(By.name("phone")).sendKeys("9500000100");
		Thread.sleep(3000);
		driver.findElement(By.name("userName")).sendKeys("debo123");
		Thread.sleep(6000);
		driver.findElement(By.name("address1")).sendKeys("Kolkata");
		driver.findElement(By.name("city")).sendKeys("Siliguri");
		Thread.sleep(2000);
		driver.findElement(By.name("state")).sendKeys("WB");
		Thread.sleep(2000);
		driver.findElement(By.name("postalCode")).sendKeys("000001");
		
		//Keyboard Action line 86,87
		WebElement country = driver.findElement(By.xpath("//*[@name='country']"));
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.click(country).build().perform();
		act.sendKeys(country,Keys.ARROW_DOWN).build().perform();
		act.sendKeys(country,Keys.ARROW_DOWN).build().perform();
		
		//Select s = new Select(country);    // Select method
		//s.selectByIndex(5);// country Angola
		
		//Mouse hover action(Right click line 93)
		Actions act1 = new Actions(driver);
		WebElement country1 = driver.findElement(By.xpath("//*[@name='country']"));
		act1.contextClick().click().build().perform();
		Thread.sleep(3000);
		driver.findElement(By.name("email")).sendKeys("debolina");
		driver.findElement(By.name("password")).sendKeys("debo123");
		driver.findElement(By.name("confirmPassword")).sendKeys("debo123");
		Thread.sleep(3000);
		//Mouse hover action line 100
		WebElement submit = driver.findElement(By.name("submit"));
		act1.moveToElement(submit).click().build().perform();
		Thread.sleep(3000);
		
		//er.flush();
		//driver.close();
	}
//	@Test(enabled = false)
//	public void linkpresent() {   // how to check how many links are present
//		List<WebElement> ele = driver.findElements(By.tagName("a"));
//		System.out.println(ele.size());
//		
//		for(int i = 0; i< ele.size(); i++) {
//			//System.out.println(ele.get(i).getText());
//			String workinglink = ele.get(i).getAttribute("href");
//			System.out.println(workinglink);
//			String notworkinglink = "https://demo.guru99.com/test/newtours/support.php";
//			if(workinglink.equals(notworkinglink)) {
//				System.out.println("links are under construction" + ele.get(i).getText());
//			}
//			else {
//				System.out.println("links are working" + ele.get(i).getText());
//			}
//		}
//	}
	
//	@AfterTest
//	private void close() {
//		driver.close();		
//	}


		
	}


