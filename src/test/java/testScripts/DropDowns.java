package testScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DropDowns {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		
		//To run in different browser version (Not yet downloaded by User) , need to use the below method and has to provide the required version
//		options.setBrowserVersion("115");
		
//		options.addArguments("--headless");
		
		//The below line will disabled the image loading
		options.addArguments("--blink-settings=imagesEnabled=false");
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		driver.get("https://demo.opencart.com/");
		
		Thread.sleep(5000);
		
		driver.get("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
		
		WebElement dropdown = driver.findElement(By.id("select-demo"));
		
		System.out.println("\"Single Dropdown\"");
		
		Select drpDwn = new Select(dropdown);
		drpDwn.selectByIndex(1);
		System.out.println(drpDwn.getFirstSelectedOption().getText());
		drpDwn.selectByValue("Monday");
		System.out.println(drpDwn.getFirstSelectedOption().getText());
		drpDwn.selectByVisibleText("Friday");
		System.out.println(drpDwn.getFirstSelectedOption().getText());
		
		System.out.println("\"Multi Dropdown\"");
		Select muldrpdwn = new Select(driver.findElement(By.id("multi-select")));
		
		if(muldrpdwn.isMultiple()) {
			muldrpdwn.selectByIndex(1);
			muldrpdwn.selectByValue("New York");
			muldrpdwn.selectByVisibleText("Washington");
		}
		
		List<WebElement> items = muldrpdwn.getAllSelectedOptions();
		System.out.println("Total selected count = " + items.size());
		
		for(WebElement item : items) {
			System.out.println(item.getText());
		}
		
		System.out.println("--------------------------");
		
		
		driver.navigate().to("https://www.flipkart.com/");
		
		driver.findElement(By.name("q")).sendKeys("iPhone");
		
		Thread.sleep(2000);
		
		List<WebElement> carts = driver.findElements(By.xpath("//div[contains(@class,'_2VHNef')]"));
		
		for(WebElement cart : carts) {
			System.out.println(cart.getText());
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
