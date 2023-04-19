package Hibiscus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Guru99RadioButoon {
	public static String url = "https://demo.guru99.com/test/newtours/index.php";
	WebDriver driver;
	@BeforeTest
	public void bt() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		}
	@Test(priority = 0)
	public void login() {
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		String beforelogin = driver.getTitle();
		System.out.println(beforelogin);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		WebElement username = driver.findElement(By.xpath("//*[@type='text']"));
		
		username.sendKeys("user");
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		WebElement password = driver.findElement(By.xpath("//*[@type='password']"));
		password.sendKeys("user");
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
	}
	@Test(priority = 1)
	public void Flight() {
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Flights")).click();
		WebElement radio = driver.findElement(By.xpath("//*[@value='oneway']"));
		radio.click();
		WebElement passenger = driver.findElement(By.xpath("//*[@name='passCount']"));
		Select s = new Select(passenger);
		s.selectByIndex(1);
		WebElement departingFrom = driver.findElement(By.name("fromPort"));
		Select s1 = new Select(departingFrom);
		s1.selectByIndex(3);  //NewYork
		WebElement month = driver.findElement(By.name("fromPort"));
		Select s2 = new Select(month);
		s2.selectByIndex(6); //july
		WebElement date = driver.findElement(By.name("fromDay"));
		Select s3 = new Select(date);
		s3.selectByIndex(4);//5
		driver.quit();
		

}
}