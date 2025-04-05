import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {

	@Test
	public void readTestCases() throws IOException
	{
		String file = ".\\dataFiles\\TestCases.xlsx";
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int count = workbook.getNumberOfSheets();
		System.out.println(count);
		Object[][] data = null;
		for(int i =0;i<count;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("TestData"))
			{
				XSSFSheet sheet = workbook.getSheetAt(i);
				int rows = sheet.getLastRowNum();
				int cols = sheet.getRow(0).getLastCellNum();
				data =  new Object[rows][cols];
				System.out.println(rows);
				System.out.println(cols);
				for (int r =0;r<rows;r++)
				{
					XSSFRow row = sheet.getRow(r);
					for(int c=0;c<cols;c++)
					{
						XSSFCell cell = row.getCell(c);
						DataFormatter df= new DataFormatter();
						data[r][c] = df.formatCellValue(cell);
					}
					System.out.println();
				}
			}
		}
		
		
		for(Object[] dataarray:data)
		{
			System.out.println(Arrays.toString(dataarray));
		}
		
		
		workbook.close();
		fis.close();
	}
}
