package testScripts;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://stqatools.com/demo/Windows.php");
		
		String parentWin = driver.getWindowHandle();
		System.out.println("Parent Window ID - " + parentWin);
		
		WebElement newTabCTA = driver.findElement(By.xpath("//button[contains(text(),'new Tab')]"));		
		newTabCTA.click();
		
		System.out.println("Page Title - " + driver.getTitle());
		
		Set<String> tabs = driver.getWindowHandles();		
		for(String child : tabs) {			
			System.out.println(child);
			if(!child.equalsIgnoreCase(parentWin)) {
				driver.switchTo().window(child);
				System.out.println("Child Window Title - " + driver.getTitle() );
				System.out.println(driver.findElement(By.xpath("//ul[@id='primary-menu']//span[text()='Java']")).getText());
			}						
		}		
		driver.close();
		driver.switchTo().window(parentWin);
		System.out.println("Parent Window Title - " + driver.getTitle());
		
		WebElement newWinCTA = driver.findElement(By.xpath("//button[contains(text(),'open new Window')]"));
		newWinCTA.click();
		
		Set<String> tabs1 = driver.getWindowHandles();		
		for(String child : tabs1) {			
			System.out.println(child);
			if(!child.equalsIgnoreCase(parentWin)) {
				driver.switchTo().window(child);
				System.out.println("Child Window Title - " + driver.getTitle() );				
			}		
		}				
		
		driver.close();
		driver.switchTo().window(parentWin);
		driver.switchTo().newWindow(WindowType.TAB);
//		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.navigate().to("http://watir.com/examples/shadow_dom.html");
		System.out.println("Page Title - " + driver.getTitle());
//		driver.quit();	
	}
}
