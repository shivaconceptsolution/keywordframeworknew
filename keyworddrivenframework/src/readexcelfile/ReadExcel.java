package readexcelfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public Sheet readExcel(String filePath,String fileName,String sheetName) throws IOException{
		  //Create a object of File class to open xlsx file
		  File file = new File(filePath+"\\"+fileName);
		  //Create an object of FileInputStream class to read excel file
		  FileInputStream inputStream = new FileInputStream(file);
		  Workbook obj = new XSSFWorkbook(inputStream);
		  Sheet  mysheet = obj.getSheet(sheetName);
		  return mysheet; 
		  }
}
