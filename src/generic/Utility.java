package generic;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Utility {
	public static String getPropertyValue(String path, String key) {
		String v = "";
		try {
			Properties p = new Properties();
			p.load(new FileInputStream(path));
			v = p.getProperty(key);
		}
		catch(Exception e)
		{
			e.printStackTrace();}
			return v;
			}
			public static String getXLData(String path, String sheet,int r,int c)
	{
				String v = "";
				
	try {
		Workbook w =  WorkbookFactory.create(new FileInputStream(path));
		w.getSheet(sheet).getRow(r).getCell(c).toString();
		}
	catch(Exception e) {
		e.printStackTrace();
	}
	return v;
		
	}
			public static int getXLRowCount(String path, String sheet)
			{      int count = 0;
	
						try {
				Workbook w =  WorkbookFactory.create(new FileInputStream(path));
				count=w.getSheet(sheet).getLastRowNum();
				}
			catch(Exception e) {
				e.printStackTrace();
			}
			return count ;
}
			public static String getphoto(WebDriver driver,String folder)
			{
				Date d = new Date();
				String dateTime = d.toString().replaceAll(":", "_");
				String path = folder+"/"+dateTime+".png";
				try {
					TakesScreenshot t =(TakesScreenshot)driver;
					File src = t.getScreenshotAs(OutputType.FILE);
					File destFile = new File(path);
					FileUtils.copyFile(src, destFile);
					
				}																			
				catch(Exception e)
				{e.printStackTrace();}
				return path;
				
					
				}
			public static WebDriver openBrowser(WebDriver driver,String ip,String browser) {
				if(ip.equals("locahost")) {
					if(browser.equals("chrome")) {
						driver= new ChromeDriver();
					}
					else {
						driver= new FirefoxDriver();
					}
				}try {
					URL u = new URL("https:/"+ip+":444/wd/hub");
					DesiredCapabilities d = new DesiredCapabilities();
					d.setBrowserName(browser);
					driver = new RemoteWebDriver(u,d);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			return driver;
				
			}
				
			}
			

