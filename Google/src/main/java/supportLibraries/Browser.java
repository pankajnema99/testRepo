package supportLibraries;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Browser 
{
	static public WebDriver driver = null;
	public static void openBrowser()
	{
		driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	public static void invokeApplication()
	{
		driver.get(UtilClass.getProperties("ApplicationURL"));
	}
	public static void sync()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}



	
