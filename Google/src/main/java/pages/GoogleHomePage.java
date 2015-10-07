package pages;

import org.openqa.selenium.By;
import supportLibraries.Browser;

public class GoogleHomePage extends Browser {

	/*** Test case Method Name: clickToLink
	 * 	 Functionality        : This is to click on the specific link
	 *   Developed by	      : Pankaj Nema
	 *   Parameters           : NA
	 ***/
	public GmailLoginPage clickToLink(String link)
	{
		driver.findElement(By.linkText(link)).click();
		sync();
		return new GmailLoginPage();
	}
}
