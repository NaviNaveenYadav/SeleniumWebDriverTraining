package testScripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.seleniumeasy.com/javascript-alert-box-demo.html");
		
		WebElement alertBox = driver.findElement(By.xpath("(//div[@class='panel-body'])[2]//button"));
		alertBox.click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		//Handling Confirmation Alert
		
		WebElement confirmAlertBox = driver.findElement(By.xpath("(//div[@class='panel-body'])[3]//button"));
		confirmAlertBox.click();
		System.out.println(alert.getText());
		alert.accept();
		System.out.println(driver.findElement(By.xpath("//p[@id='confirm-demo']")).getText());
		confirmAlertBox.click();
		alert.dismiss();
		System.out.println(driver.findElement(By.xpath("//p[@id='confirm-demo']")).getText());
		
		//Prompt Alert
		WebElement promptAlertBox = driver.findElement(By.xpath("//button[contains(text(),'Prompt')]"));
		promptAlertBox.click();
		System.out.println(alert.getText());
		alert.sendKeys("Naveen");
		alert.accept();
		System.out.println(driver.findElement(By.id("prompt-demo")).getText());
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
