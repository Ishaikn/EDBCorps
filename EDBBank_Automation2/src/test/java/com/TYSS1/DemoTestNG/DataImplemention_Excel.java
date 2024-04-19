package com.TYSS1.DemoTestNG;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.IpathConstant;

public class DataImplemention_Excel {

	@DataProvider
	public Object[][] exceldata() throws Throwable {

		FileInputStream fis = new FileInputStream(IpathConstant.Excelpath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sht = book.getSheet("Sheet1");
		int rowcount = sht.getLastRowNum();
		int cellcount = sht.getRow(0).getLastCellNum();
		//	int rowcount1=sht.getPhysicalNumberOfRows();
		//	int cellcount1=sht.getRow(0).getPhysicalNumberOfCells();
		Object[][] obj = new Object[rowcount][cellcount];
		for (int i = 0; i < rowcount; i++) {
			for (int j = 0; j < cellcount; j++) {

				obj[i][j] = sht.getRow(i).getCell(j).getStringCellValue();

			}
		}
		return obj;
	}

}
