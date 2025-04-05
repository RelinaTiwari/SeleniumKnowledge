import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class FileDownload {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		//things will be defined as key value pair
		Map<String, Object> chromePref = new HashMap<String, Object>();
		String downloadFolder = "C:\\Automation Testing\\eclipse\\Eclipse\\workspace\\SeleniumKnowledge";
		chromePref.put("download.default_directory", downloadFolder);
		chromePref.put("download.prompt_for_download" , false);
		chromePref.put("plugins.plugins_disabled", new String[] {"Chrome PDF Viewer"});
		chromePref.put("plugins.always_open_pdf_externally" , true);
		options.setExperimentalOption("prefs", chromePref);
		
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://sourceforge.net/p/sevenzip/discussion/45797/thread/b95432c7ac/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
		WebElement zipfile = driver.findElement(By.xpath("//div//a[contains(text(),'https://7-zip.org/a/7z2409-x64.exe')]"));
		zipfile.click();
		
		Thread.sleep(5000);
		
	}

}
