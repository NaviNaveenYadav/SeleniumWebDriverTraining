package testScripts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.opencart.com/");
		
		Actions action = new Actions(driver);
		
		WebElement srcBox = driver.findElement(By.name("search"));
		
		//contextClick --> used for the right click
//		action.contextClick(srcBox).sendKeys("Mobile").build().perform();
		
		WebElement menu = driver.findElement(By.cssSelector("ul.navbar-nav > li.dropdown:nth-child(3)"));
		
//		action.moveToElement(menu).perform();
		
		WebElement menuItem = driver.findElement(By.xpath("//div[@class='dropdown-inner']//a[text()='Monitors (2)']"));
		
//		action.click(menuItem).perform();
		
		action.moveToElement(menu).click(menuItem).build().perform();
		
		
//		driver.navigate().to("https://stqatools.com/demo/DoubleClick.php");
//		
//		Thread.sleep(2000);
//		
//		WebElement btn = driver.findElement(By.xpath("//button[text()='Click Me / Double Click Me!']"));
//		
//		action.doubleClick(btn).perform();
//		Thread.sleep(2000);
//		action.doubleClick(btn).doubleClick(btn).build().perform();
		
		TakesScreenshot screen = (TakesScreenshot)driver;
		
		//Screenshot for the whole page
		File src = screen.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/Screenshots/" + System.currentTimeMillis() +".png";
		
		FileUtils.copyFile(src, new File(path));
		
		Thread.sleep(2000);
		
		WebElement img = driver.findElement(By.cssSelector("div.product-thumb"));
		
		action.scrollByAmount(10, 400).perform();
		action.scrollToElement(img).perform();
		
		//Screenshot for the located WebElement
		File src1 = img.getScreenshotAs(OutputType.FILE);
		String path1 = System.getProperty("user.dir")+"/Screenshots/" + System.currentTimeMillis() +".png";
		FileUtils.copyFile(src1, new File(path1));
		
	}

}
