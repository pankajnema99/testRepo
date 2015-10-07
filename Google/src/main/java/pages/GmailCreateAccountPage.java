package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import supportLibraries.Browser;
import supportLibraries.UtilClass;

public class GmailCreateAccountPage extends Browser {
	
	public GmailCreateAccountPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Gmail create account page objects
	@FindBy(id = "FirstName")
	public WebElement txt_FirstName;
	
	@FindBy(id = "LastName")
	public WebElement txt_LastName;
	
	@FindBy(id = "GmailAddress")
	public WebElement txt_EmailAddress;
	
	@FindBy(id = "Passwd")
	public WebElement txt_Password;
	
	@FindBy(id = "PasswdAgain")
	public WebElement txt_ConfirmPassword;
	
	@FindBy(xpath = ".//*[@id='BirthMonth']/div[1]")
	public WebElement lst_Months;
	
	@FindBy(id = "BirthDay")
	public WebElement txt_Day;
	
	@FindBy(id = "BirthYear")
	public WebElement txt_Year;
	
	@FindBy(css = "div[id='Gender']>div.goog-inline-block")
	public WebElement lst_Gender;
	
	@FindBy(id = "RecoveryPhoneNumber")
	public WebElement txt_PhoneNumber;
	
	@FindBy(id = "RecoveryEmailAddress")
	public WebElement txt_RecoveryEmail;
	
	@FindBy(id = "SkipCaptcha")
	public WebElement chk_SkipCaptcha;
	
	@FindBy(id = "TermsOfService")
	public WebElement chk_Terms;
	
	@FindBy(xpath = ".//div[@id='CountryCode']/div[1]")
	public WebElement lst_Location;
	
	@FindBy(id = "submitbutton")
	public WebElement btn_NextStep;
	
	@FindBy(id = "errormsg_0_GmailAddress")
	public WebElement err_UserName;

	
	/*** Test case Method Name: completeUserprofile
	 * 	 Functionality        : This is to complete user profile
	 *   Developed by	      : Pankaj Nema
	 *   Parameters           : NA
	 ***/
	public GmailCreateAccountPage completeUserprofile()
	{
		txt_FirstName.sendKeys(UtilClass.firstName);
		Reporter.log("The first name entered as:- "+UtilClass.firstName);
		txt_LastName.sendKeys(UtilClass.lastName);
		Reporter.log("The last name entered as:- "+UtilClass.lastName);
		txt_Password.sendKeys(UtilClass.password);
		Reporter.log("The password entered as:- "+UtilClass.password);
		txt_ConfirmPassword.sendKeys(UtilClass.confirmPassword);
		Reporter.log("The confirmation password entered as:- "+UtilClass.confirmPassword);
		selectMonth(UtilClass.month);
		txt_Day.sendKeys(UtilClass.day);
		Reporter.log("The date entered as:- "+UtilClass.day);
		txt_Year.sendKeys(UtilClass.year);
		Reporter.log("The year entered as:- "+UtilClass.year);
		selectGender(UtilClass.gender);
		txt_PhoneNumber.sendKeys(UtilClass.phone);
		Reporter.log("The phone number entered as:- "+UtilClass.phone);
		txt_RecoveryEmail.sendKeys(UtilClass.currEmail);
		Reporter.log("The current email address entered as:- "+UtilClass.currEmail);
		chk_SkipCaptcha.click();
		chk_Terms.click();
		selectLocation(UtilClass.country);
		btn_NextStep.click();
		Reporter.log("Click on the 'Next Step' button successfully");
		return new GmailCreateAccountPage();
	}
	
	/*** Test case Method Name: validateUserNameErrorMessage
	 * 	 Functionality        : This is to validate error message for user name field
	 *   Developed by	      : Pankaj Nema
	 *   Parameters           : NA
	 ***/
	public GmailCreateAccountPage validateUserNameErrorMessage()
	{
		if(err_UserName.getText().equalsIgnoreCase("You can't leave this empty."))
		{
			Assert.assertEquals(err_UserName.getText(), "You can't leave this empty.");
			Reporter.log("The error message displayed as:- "+err_UserName.getText());
		}
		else
		{	Assert.assertEquals(err_UserName.getText(), "You can't leave this empty.");
			Reporter.log("The error message displayed as:- "+err_UserName.getText());
		}
		return new GmailCreateAccountPage();
	}
	
	/*** Test case Method Name: selectMonth
	 * 	 Functionality        : This is to select month value from Common.xls
	 *   Developed by	      : Pankaj Nema
	 *   Parameters           : NA
	 ***/
	public void selectMonth(String month)
	{	lst_Months.click();
		driver.findElement(By.xpath("//span[@id='BirthMonth']/div[@class='goog-menu goog-menu-vertical']/div/div[contains(text(),'"+month+"')]")).click();
		Reporter.log("The month is selected from the list is:-"+month);
	}
	
	/*** Test case Method Name: selectGender
	 * 	 Functionality        : This is to select gender value from Common.xls
	 *   Developed by	      : Pankaj Nema
	 *   Parameters           : NA
	 ***/
	public void selectGender(String gender)
	{	lst_Gender.click();
		driver.findElement(By.xpath("//div[@id='Gender']/div[@class='goog-menu goog-menu-vertical']/div/div[contains(text(),'"+gender+"')]")).click();
		Reporter.log("The gender is selected from the list is:-"+gender);
	}
	
	/*** Test case Method Name: selectLocation
	 * 	 Functionality        : This is to select location from Common.xls
	 *   Developed by	      : Pankaj Nema
	 *   Parameters           : NA
	 ***/	
	public void selectLocation(String location)
	{	lst_Location.click();
		driver.findElement(By.xpath("//div[@id='CountryCode']/div[@class='goog-menu goog-menu-vertical']/div/div[contains(text(),'"+location+"')]")).click();
		Reporter.log("The location is selected from the list is:-"+location);
	}
}
