import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFile {

	public static void main(String[] args) throws AWTException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://enhancv.com/resources/resume-checker/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement uploadButton = driver.findElement(By.xpath("//div[contains(@class,'Upload')]//button[text()='Upload Your Resume']"));
		//using SendKeys
		//uploadButton.sendKeys("C:\\Users\\Relina Tiwari\\OneDrive\\Desktop\\Switch Preperation\\Resume");
		
		//using Robot class
		uploadButton.click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", uploadButton);
		
		//copy to clipboard
		StringSelection selection = new StringSelection("C:\\Users\\Relina Tiwari\\OneDrive\\Desktop\\Switch Preperation\\Resume");
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
	    
	    Thread.sleep(5000);
	    
	    //paste to filepath in clipboard
	    Robot rb = new Robot();
	    rb.keyPress(KeyEvent.VK_CONTROL);
	    rb.keyPress(KeyEvent.VK_V);
	    rb.keyRelease(KeyEvent.VK_V);
	    rb.keyRelease(KeyEvent.VK_CONTROL);
	    
	    Thread.sleep(5000);
	    
	    //paste to filepath
	    rb.keyPress(KeyEvent.VK_ENTER);
	    rb.keyRelease(KeyEvent.VK_ENTER);

	}

}
