package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

abstract public class BaseTest implements IAutoConst {
	public WebDriver driver;
	public String url = Utility.getPropertyValue(CONFIG_PATH,"URL");
	String ITO =  Utility.getPropertyValue(CONFIG_PATH,"ITO");
	public long duration = Long.parseLong(ITO);
	
	static {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
	}
	@Parameters({"ip","browser"})
	@BeforeMethod
	public void openBrowser(WebDriver driver,String ip,String browser) {
		driver = Utility.openBrowser(driver, ip, browser);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(duration,TimeUnit.SECONDS );
		driver.get(ITO);
	}
	@AfterMethod
	public void closeBrowser(){
		Utility.getphoto(driver, PHOTO_PATH);
		driver.close();
		
	}
	
	
	
	

}
