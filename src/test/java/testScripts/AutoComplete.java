package testScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoComplete {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/autocomplete/");
		
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		
		driver.findElement(By.id("tags")).sendKeys("C");
		
		List<WebElement> autoSuggest = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
		
		for(WebElement opt : autoSuggest) {
			
			String option = opt.getText();
			
			if("BASIC".equalsIgnoreCase(option)) {
				opt.click();
				break;
			}
			
		}
		
	}

}
