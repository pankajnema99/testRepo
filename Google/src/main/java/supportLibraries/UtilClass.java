
package supportLibraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class UtilClass
{
	static int rowNum = 1;
	static File currDir = new File("Common.xls");
    static String path = currDir.getAbsolutePath();
	static String sheetName = "General_Data";
	public static String firstName;
	public static String lastName;
	public static String emailAddress;
	public static String password;
	public static String confirmPassword;
	public static String month;
	public static String day;
	public static String year;
	public static String gender;
	public static String phone;
	public static String currEmail;
	public static String country;

	public static String getData(String path, String sheetName, int rowNumber,int cellNumber)
	{
		String data = null;
		try {
			FileInputStream fis = new FileInputStream(new File(path));
			data = WorkbookFactory.create(fis).getSheet(sheetName)
					.getRow(rowNumber).getCell(cellNumber).getStringCellValue();
			if (data.isEmpty()) {
				data = "Data not Found.";
			}
		} catch (Exception e) {
			System.err.println("Error while getting Data.");
		}
		return data;
	}
	
	public static int getRow(String testCase)
	{	
		boolean flag = false;
		while (getData(path, sheetName, rowNum, 0) != null) 
		{	
			String [] actTCName = testCase.replace(".", "Deli").split("Deli");
			if(getData(path, sheetName, rowNum, 0).equals(actTCName[1].trim()))
			{	
				flag = true;
				break;
			}
			rowNum++;	
		}
		if(flag == true)
		{
			return rowNum;
		}
		else
		{
			return -1;
		}
	}
	
	public static String getProperties(String property)
	{
		FileReader reader = null;
		try {
			reader = new FileReader("GlobalSettings.properties");
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		}  	      
	    Properties p=new Properties();  
	    try {
			p.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	   return p.getProperty(property);		
	}
	
	public static void setCurrentTC(String testCase)
	{
		int row = getRow(testCase);
		firstName = getData(path, sheetName, row, 1);
		lastName = getData(path, sheetName, row, 2);
		emailAddress = getData(path, sheetName, row, 3);
		password = getData(path, sheetName, row, 4);
		confirmPassword = getData(path, sheetName, row, 5);
		month = getData(path, sheetName, row, 6);
		day = getData(path, sheetName, row, 7);
		year = getData(path, sheetName, row, 8);
		gender = getData(path, sheetName, row, 9);
		phone = getData(path, sheetName, row, 10);
		currEmail = getData(path, sheetName, row, 11);
		country = getData(path, sheetName, row, 12);
	}
}
