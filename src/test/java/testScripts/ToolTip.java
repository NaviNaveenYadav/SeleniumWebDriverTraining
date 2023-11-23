package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToolTip {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/tooltip/");
				
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		
		driver.findElement(By.id("age")).sendKeys(Keys.PAGE_DOWN);
		
		Actions actions = new Actions(driver);
		
		actions.moveToElement(driver.findElement(By.id("age"))).perform();
		
		WebElement tooltip = driver.findElement(By.cssSelector("div.ui-tooltip-content"));
		System.out.println(tooltip.getText());
		
		
	}

}
