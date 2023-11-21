package testScripts;

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
		driver.get("https://www.google.com/");
		
		WebElement srcBox = driver.findElement(By.id("APjFqb"));
		srcBox.sendKeys("Java Tutorials");
		srcBox.sendKeys(Keys.ENTER);
		
		System.out.println("Modification Done");
	}

}
