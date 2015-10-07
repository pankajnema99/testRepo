package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GoogleHomePage;
import supportLibraries.Browser;
import supportLibraries.UtilClass;

public class TC001_Validate_User_Name_Error extends Browser
{
	@BeforeMethod
	public void beforeMethod() 
	{
		class Local {};
		String currentTCName = Local.class.getEnclosingClass().getName();
		UtilClass.setCurrentTC(currentTCName);
		Browser.openBrowser();
		Browser.invokeApplication();
	}

	@Test
	public void validateErrorMessage()
	{
		GoogleHomePage googleHomePage = new GoogleHomePage();
		googleHomePage.clickToLink("Gmail")
					  .clickToLink("Create account")
					  .completeUserprofile()
					  .validateUserNameErrorMessage();
	}

	@AfterMethod
	public void afterMethod() 
	{
		driver.quit();
	}
}
