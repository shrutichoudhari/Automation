package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class script {
	static {
		System.setProperty("Webdriver.chrome.driver", "./software/chromedriver.exe");
	}

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Shruti/Desktop/page1.html");
		driver.switchTo().frame(0);
		driver.findElement(By.id("t2")).sendKeys("a");
		driver.switchTo().parentFrame();
		driver.findElement(By.id("t1")).sendKeys("a");
		driver.switchTo().frame("f1");
		driver.findElement(By.id("t2")).sendKeys("b");
		driver.switchTo().parentFrame();
		driver.findElement(By.id("t1")).sendKeys("b");
		  
	 WebElement e = driver.findElement(By.id("f1"));
	 driver.switchTo().frame(e);
	 driver.findElement(By.id("t2")).sendKeys("c");
	 driver.switchTo().defaultContent();
	 driver.findElement(By.id("t1")).sendKeys("a");
	 
		
		

	}

}
