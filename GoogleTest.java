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
import org.openqa.selenium.JavascriptExecutor; 

public class GoogleTest {
	
	WebDriver driver =null;
	
	@BeforeMethod
	public void BeforeTest() 
	{
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
		driver =new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
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
		
				
		driver.findElement(By.name("q")).sendKeys("Test");
		driver.findElement(By.name("q")).clear();  
		
		Thread.sleep(10000);
		
	}
	
	
	
	 @Test(priority=2)
	public void Testhyperlink()
	{
		String str=driver.findElement(By.xpath("//*[@id=\"gbw\"]/div/div/div[1]/div[1]/a")).getCssValue("color");
	
		System.out.println("Color code is :"+ str);
	}  
	
	
	

	
	@Test(priority=3)
	public void TestMicbutton() throws InterruptedException
	{
		
		Thread.sleep(10000);
		Actions act = new Actions(driver);
	
		WebElement ele =  driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[3]/div[2]"));
		act.moveToElement(ele).build().perform();
		Thread.sleep(5000);
	
	} 
	
	
	
	@Test(priority=4)
	public void TestIconDimension() throws InterruptedException
	{
		int height =  driver.findElement(By.id("hplogo")).getSize().height;
		int width =  driver.findElement(By.id("hplogo")).getSize().width;
		System.out.println("Height is : " + height);
		System.out.println("Width is : " + width);
	}
	
	
	
	
	
	
	@AfterMethod
	public void AfterTest()
	{
		driver.quit();
		
	}
	
	

}
