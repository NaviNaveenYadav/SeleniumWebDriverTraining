package testScripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GooglePage {

	public static void main(String[] args) {

		// https://github.com/NaviNaveenYadav/SeleniumWebDriverTraining.git
		// Token - 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
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.google.com/");
		
		WebElement srcBox = driver.findElement(By.id("APjFqb"));
		srcBox.sendKeys("Java Tutorial");
		
		List<WebElement> recomRes = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]/li//descendant::div[@class='wM6W7d']/span"));
		System.out.println(recomRes.size());
		String expText = "java tutorial pdf";
		
		for(WebElement text : recomRes) {
			String actText = text.getText();
			System.out.println(actText);
			if(expText.equals(actText)) {
				text.click();
				break;
			}
		}
		
		
//		srcBox.sendKeys(Keys.ENTER);
		
		System.out.println("Modification Done");
		
//		driver.navigate().to("https://www.selenium.dev/");
//		
//		//Css Selectors
//		
//		// ul.navbar-nav > li:nth-child(3)
//		
//		List<WebElement> items = driver.findElements(By.cssSelector("ul.navbar-nav > li:nth-child(3)"));
//		
//		for(WebElement item : items) {
//			System.out.println(item.getText());
//		}
//		
	}

}
