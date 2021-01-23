package smokeTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTML.Tag;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GoogleTest {
	
	WebDriver driver =null;
	
	@BeforeMethod
	public void BeforeTest() 
	{
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
		driver =new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		
	}
	
	
	
	@Test (priority=1)
	public void TestGoogle() throws InterruptedException
	{
		
			
		driver.findElement(By.name("q")).sendKeys("Selenium");
		Thread.sleep(1000);
		
		driver.navigate().refresh();
				
		Thread.sleep(1000);
		
		driver.findElement(By.name("q")).sendKeys("TestNG");
		driver.get("https://www.google.com");
		Thread.sleep(1000);
		
		driver.findElement(By.name("q")).sendKeys("India");
		Thread.sleep(1000);
		driver.findElement(By.name("q")).sendKeys(Keys.F5);  //F5 is not working
		
		Thread.sleep(1000);
		driver.findElement(By.name("q")).sendKeys("Test");
		driver.findElement(By.name("q")).sendKeys(Keys.CLEAR);  //CLEAR is not working
		
		Thread.sleep(10000);
		
	}
	
	
	 @Test(priority=2)
	public void Testhyperlink()
	{
		String str=driver.findElement(By.className("NKcBbd")).getCssValue("color");
	
		System.out.println("Color code is :"+ str);
	}  
	
	
	
	
	/*
	@Test(priority=3)
	public void TestMicbutton() throws InterruptedException
	{
		Actions act = new Actions(driver);
	
				
		driver.findElement(By.id("realbox-microphone"));
		driver.findElement(By.className("microphone-icon mouse-navigation"));
	
		Thread.sleep(10000);
		
		act.click();
		
		
	} */
	
	
	
	@AfterMethod
	public void AfterTest()
	{
		driver.quit();
		
	}
	
	

}
