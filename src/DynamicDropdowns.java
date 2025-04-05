import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdowns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://practice.expandtesting.com/dynamic-table");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String Value = "";
		
		
		List<WebElement> table = driver.findElements(By.xpath("//div/table[@class = 'table table-striped']//tbody/tr"));
		int rows = table.size();
		for (int i = 1; i<=rows ; i++)
		{
			WebElement forChrome = driver.findElement(By.xpath("//div/table[@class = 'table table-striped']//tbody/tr["+i+"]/td[1]"));
			if(forChrome.getText().equalsIgnoreCase("Chrome"))
			{
				 Value = driver.findElement(By.xpath("//td[contains(normalize-space(),'Chrome')]//following-sibling ::td[contains(text(),'%')]")).getText();
			}
		}
		
		
		System.out.println(Value);
		
		
		driver.close();

	}

}
