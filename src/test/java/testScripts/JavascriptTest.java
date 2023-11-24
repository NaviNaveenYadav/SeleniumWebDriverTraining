package testScripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptTest {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.opencart.com/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		String titleTxt = (String)js.executeScript("return document.title");
		System.out.println(titleTxt);
		
		WebElement searchBox = (WebElement)js.executeScript("return document.getElementsByName('search')[0]");
		searchBox.sendKeys("Phone");
		
		js.executeScript("window.scrollBy(10,500)");
		
//		js.executeScript("window.scrollBy(10,document.body.scrollHeight)");
		
		
	}

}
