package page;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.Action;



public class Jquery {

	
		static {
			System.setProperty("Webdriver.chrome.driver", "./software/chromedriver.exe");
		}

		public static void main(String[] args) {
			WebDriver driver = new ChromeDriver();
			driver.get("http://jqueryui.com/droppable/");
			driver.switchTo().frame(0);
			WebElement src = driver.findElement(By.id("draggable"));
			WebElement dest = driver.findElement(By.id("droppable"));
			Actions a = new Actions(driver);
			a.dragAndDrop(src, dest);
			a.perform();

	}

}
