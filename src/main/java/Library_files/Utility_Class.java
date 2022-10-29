package Library_files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class Utility_Class 
{
	@Test
	public static String getdatafromPF(String Key) throws IOException
	{
		//To reach upto property file(PF)
		FileInputStream file=new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\11_June_Maven\\Property.properties");
		
		//To open PF
		Properties prop=new Properties();
		
		prop.load(file);
		
		//To fetch data
		String value1=prop.getProperty(Key);
		
		return value1;
	}
	
	@Test
	public static String getdatafromExcel(int RowIndex, int CellIndex) throws EncryptedDocumentException, IOException
	{
		//Navigate to excel sheet
		FileInputStream file=new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\11_June_Maven\\Test_Data\\11June Morning.xlsx");
		
		Sheet Sh=WorkbookFactory.create(file).getSheet("Sheet9");
		
		String value2=Sh.getRow(RowIndex).getCell(CellIndex).getStringCellValue();
		
		return value2;
	}
	
	@Test
	public static void CaptureScreenshot(WebDriver driver, int TestCaseID) throws IOException
	{
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		System.out.println(source);
		
		File destination=new File("C:\\Users\\DELL\\eclipse-workspace\\11_June_Maven\\Screenshot\\"+TestCaseID+".jpg");
		
		FileHandler.copy(source, destination);
	}

}
