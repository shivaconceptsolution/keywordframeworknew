package executetestcase;

import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import operation.UIOperation;
import readexcelfile.ReadExcel;
import readobjectfile.ReadObject;

public class ExecuteTestCase {
	   WebDriver driver;
	   @BeforeMethod
	   public void beforeMethod() {
	   System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
	   driver = new ChromeDriver();
	   }
	   @Test
	   public void f() throws Exception {
		   
		   ReadExcel f = new ReadExcel();
		   ReadObject o = new ReadObject();
		   Properties allObjects =  o.getXYZ();
		   UIOperation op = new UIOperation(driver);
		   Sheet s = f.readExcel(System.getProperty("user.dir")+"\\","TestCaseNew.xlsx" , "KeywordFramework");
		   int rowCount = s.getLastRowNum()-s.getFirstRowNum();
		   for (int i = 1; i < rowCount+1; i++) {
			   Row row =s.getRow(i);
			   if(row.getCell(0).toString().length()==0){
				   System.out.println(row.getCell(1).toString()+"----"+ row.getCell(2).toString()+"----"+
					       row.getCell(3).toString()+"----"+ row.getCell(4).toString());
				   op.perform(allObjects, row.getCell(1).toString(), row.getCell(2).toString(),  row.getCell(3).toString(), row.getCell(4).toString());
			   }
			   else
			   {
				   System.out.println("New Testcase->"+row.getCell(0).toString() +" Started");
			   }
		   }
		   
		   
	   }
	   @AfterMethod
	   public void afterMethod() {
	   }
}
