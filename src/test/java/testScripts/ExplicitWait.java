package testScripts;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://uitestingplayground.com/ajax");
		
		WebElement ajaxBtn =  driver.findElement(By.id("ajaxButton"));
		ajaxBtn.click();
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='content']/p")));
		
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(20))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);
		
		
		
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//div[@id='content']")), "Data loaded with AJAX get request."));
		
		String text =  driver.findElement(By.xpath("//div[@id='content']/p")).getText();
		
		System.out.println(text);
		
		
	}

}
