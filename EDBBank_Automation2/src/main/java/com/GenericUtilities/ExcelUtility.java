package com.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 * This Method is used to read the data from the Excel Sheet
	 * 
	 * @param Sheetname
	 * @param rownum
	 * @param cellnum
	 * @param Value
	 * @return
	 * @throws Throwable
	 */

	public String readdatafromexcelsheet(String Sheetname, int rownum, int cellnum) throws Throwable {

		FileInputStream fis = new FileInputStream(IpathConstant.Excelpath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sht = book.getSheet(Sheetname);
		String Value = sht.getRow(rownum).getCell(cellnum).getStringCellValue();
		return Value;
	}

	/**
	 * This Method is used to read the Total row data from the Excel Sheet
	 * 
	 * @author ishaik
	 * @param Sheetname
	 * @return
	 * @throws Throwable
	 */
	public int gettotalrowcount(String Sheetname) throws Throwable {

		FileInputStream fis = new FileInputStream(IpathConstant.Excelpath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sht = book.getSheet(Sheetname);
		int rowcount = sht.getLastRowNum();
		return rowcount;
	}

	/**
	 * This Method is used to read the Total cell data from the Excel Sheet
	 * 
	 * @author ishaik
	 * @param Sheetname
	 * @return
	 * @throws Throwable
	 */
	public int gettotalcellcount(String Sheetname) throws Throwable {

		FileInputStream fis = new FileInputStream(IpathConstant.Excelpath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sht = book.getSheet(Sheetname);
		int cellcount = sht.getRow(0).getLastCellNum();
		return cellcount;
	}

	/**
	 * This Method is used to write data into the Excel Sheet
	 * 
	 * @author ishaik
	 * @param Sheetname
	 * @param rowNo
	 * @param cellNo
	 * @param data
	 * @throws Throwable
	 */
	public void writedatainexcelsheet(String Sheetname, int rowNo, int cellNo, String data) throws Throwable {

		FileInputStream fis = new FileInputStream(IpathConstant.Excelpath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sht = book.getSheet(Sheetname);
		sht.createRow(rowNo).createCell(cellNo).setCellValue(data);
		FileOutputStream fout = new FileOutputStream(IpathConstant.Excelpath);
		book.write(fout);
		book.close();
	}

	/**
	 * 
	 * @param Sheetname
	 * @param cellno
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public HashMap<String, String> readMultipleData(String Sheetname, int cellno)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IpathConstant.Excelpath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sht = book.getSheet(Sheetname);
		int rowcount = sht.getLastRowNum();

		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 0; i <= rowcount; i++) {
			String key = sht.getRow(i).getCell(cellno).getStringCellValue();
			String value = sht.getRow(i).getCell(cellno + 1).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}
//	public void Excelreaddata(String Sheetname, int rowNo, int cellNo) throws EncryptedDocumentException, IOException {
//		FileInputStream fis = new FileInputStream(IpathConstant.Excelpath);
//		Workbook book = WorkbookFactory.create(fis);
//		Sheet sht = book.getSheet(Sheetname);
//		int rowcount=sht.getLastRowNum();
//		int cellcount=sht.getRow(0).getLastCellNum();
//		
//		for(int i=0;i<rowcount;i++) {
//			for(int j=0;j<cellcount;j++) {
//				
//				[i][j]=sht.getRow(i).getCell(j).getStringCellValue();
//				
//			}
//		}
//	}
}
