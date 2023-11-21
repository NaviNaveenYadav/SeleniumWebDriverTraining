package testScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathsAxis {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();		
		driver.get("https://demo.seleniumeasy.com/table-sort-search-demo.html");
		
		WebElement salEle = driver.findElement(By.xpath("//table[@id='example']//td[contains(text(),'B. Wagner')]//following-sibling::td[5]"));
		System.out.println("Salary of wagner guy - "+ salEle.getText());		
		//"following-sibling" used to locate the following/younger siblings
		List<WebElement> wagnerDetails = driver.findElements(By.xpath("//table[@id='example']//td[contains(text(),'B. Wagner')]//following-sibling::td"));		
		for(WebElement wagner : wagnerDetails) {
			System.out.println(wagner.getText());
		}
		
		System.out.println("-------------------------------");
		
		//"preceding-sibling" used to locate the elder siblings
		List<WebElement> sanfranciscoEmp = driver.findElements(By.xpath("//td[contains(text(),'San Francisco')]//preceding-sibling::td[2]"));		
		for(WebElement city : sanfranciscoEmp) {
			System.out.println("Employee Name - " + city.getText());
		}
		
		System.out.println("---------------");
		
		
	}

}
