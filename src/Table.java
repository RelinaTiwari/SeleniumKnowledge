import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Table {
	
	@Test
	public void testTable(){
		WebDriver driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//table = //table[@id = 'customers']
		driver.findElement(By.xpath("//table[@id = 'customers']//tr/td[text()='FlipKart']/following-sibling::td/a[text()='Know More']")).click();
		
	}

	
	
}
