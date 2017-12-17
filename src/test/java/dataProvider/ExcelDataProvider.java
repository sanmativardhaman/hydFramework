/*	This class is used to read data from the excel sheet
 * 	
 */

package dataProvider;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;



import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.EncryptedDocumentException;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelDataProvider
{

	Workbook wb;
	DataFormatter formatter;
	Cell celValue;
	
	public ExcelDataProvider()
	{
		File src=new File("./ApplicationTestData/ApplicationData.xlsx");
		formatter=new DataFormatter();
		
		try
		{
			FileInputStream fis =new FileInputStream(src);
			 wb=WorkbookFactory.create(fis);
		} 
		
		catch (Exception e)
		{
			System.out.println("excpetion message is "+e.getMessage());
			
		}
		
	}
	
	//method which returns String -used to read data from the sheet using sheet index
	
	public String getData(int sheetIndex,int row,int col)
	{
				
		celValue=wb.getSheetAt(sheetIndex).getRow(row).getCell(col);
		String data=formatter.formatCellValue(celValue);
		
		return data;
	}
	
	//method which returns String -used to read data from the sheet using sheet name
	
	public String getData(String sheetName,int row,int col)
	{
		celValue=wb.getSheet(sheetName).getRow(row).getCell(col);
		String data=formatter.formatCellValue(celValue);
		
		return data;
	}
	
}
