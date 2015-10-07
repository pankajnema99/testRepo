package pages;

import org.openqa.selenium.By;
import supportLibraries.Browser;

public class GmailLoginPage extends Browser {

	
	/*** Test case Method Name: clickToLink
	 * 	 Functionality        : This is to click on the specific link
	 *   Developed by	      : Pankaj Nema
	 *   Parameters           : NA
	 ***/
	public GmailCreateAccountPage clickToLink(String link)
	{
		driver.findElement(By.linkText(link)).click();
		sync();
		return new GmailCreateAccountPage();
	}
}
