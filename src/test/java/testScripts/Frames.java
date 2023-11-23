package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Frames {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		
		System.out.println("Title - " + driver.findElement(By.xpath("//label/span")).getText());
		
		//From Main page to "frame1"
		driver.switchTo().frame("frame1");
		WebElement inpBox = driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input"));
		inpBox.sendKeys("Naveen");
		
		
		//from "frame1" to "frame3"
		driver.switchTo().frame("frame3");
		driver.findElement(By.id("a")).click();
		
		//from "frame3" to "frame1"
		driver.switchTo().parentFrame();
		inpBox.clear();
		inpBox.sendKeys("Welcome Back Naveen...");
		
		driver.switchTo().defaultContent();
		System.out.println("Title - " + driver.findElement(By.xpath("//label/span")).getText());
		
		//from Main page to the "frame2"
		driver.switchTo().frame("frame2");
		
		WebElement animals = driver.findElement(By.id("animals"));
		Select drp = new Select(animals);
		drp.selectByVisibleText("Avatar");
		
		driver.switchTo().defaultContent();
		
		
		
		
		
		
		
	}

}
