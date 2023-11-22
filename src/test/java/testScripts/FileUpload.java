package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		
		WebElement addFile = driver.findElement(By.xpath("//input[@type='file']"));
		
		String strPath = System.getProperty("user.dir") + "//Vegeta.png";
		
		addFile.sendKeys(strPath);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Start upload']")).click();
	}

}
