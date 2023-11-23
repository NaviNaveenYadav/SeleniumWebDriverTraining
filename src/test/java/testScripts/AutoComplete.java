package testScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoComplete {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/autocomplete/");
		
		driver.switchTo().frame(0);
		driver.findElement(By.id("tags")).sendKeys(Keys.PAGE_DOWN);
		
		driver.findElement(By.id("tags")).sendKeys("C");
		
		Thread.sleep(2000);
		
		List<WebElement> autoSuggest = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
		
		for(WebElement opt : autoSuggest) {
			
			String option = opt.getText();
			System.out.println(option);
			if("BASIC".equalsIgnoreCase(option)) {
				opt.click();
				break;
			}
			
		}
		
	}

}
