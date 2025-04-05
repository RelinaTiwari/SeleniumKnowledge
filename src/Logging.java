import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Logging {
	
	WebDriver driver;
	
	
	@BeforeMethod
	public void setUp()
	{
		new ChromeDriver();
		driver.get("https://freecrm.com/en");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
	}
	
	@Test(priority = 1)
	public void checkTitle()
	{
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Free CRM Software - Customer Relationship Management");
		
	}
	
	@Test(dependsOnMethods = "checkTitle")
	public void logoCheck()
	{
		Boolean string = driver.findElement(By.xpath("//div[@class='MuiBox-root mui-18l9bu3']//*[name()='svg']")).isDisplayed();
		Assert.assertTrue(string);
	}
	

}
