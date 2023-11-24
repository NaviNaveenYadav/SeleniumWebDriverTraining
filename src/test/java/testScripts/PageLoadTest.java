package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageLoadTest {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://uitestingplayground.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.get("http://uitestingplayground.com/");
		
		//It'll throw error if the page takes more time to load rather than the specified time in "pageLoadTimeout"
		driver.findElement(By.partialLinkText("Load Delay")).click();
		
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
	}

}
