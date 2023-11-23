package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOM {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://watir.com/examples/shadow_dom.html");
		
		//To locate the WebElements which are under the shadow Dom, first need to find the ShadowDom (Shadow Host) and then 
		// have to use the "getShadowRoot()" method to get the root of the shadow
		// and then using that ShadowRoot will find the WebElements.
		
		WebElement shadowHost = driver.findElement(By.cssSelector("div#shadow_host"));		
		SearchContext context = shadowHost.getShadowRoot();		
		WebElement shadowContext = context.findElement(By.cssSelector("span.info"));		
		System.out.println("Shadow Dom Content : " + shadowContext.getText());	
		
		// Nested ShadowDOM
		WebElement innerShadowHost = context.findElement(By.id("nested_shadow_host"));		
		SearchContext innerContext = innerShadowHost.getShadowRoot();		
		WebElement innerShadowContext = innerContext.findElement(By.id("nested_shadow_content"));		
		System.out.println("The Nested Shadow Context : " + innerShadowContext.getText());
			
		
		
		
	}

}
