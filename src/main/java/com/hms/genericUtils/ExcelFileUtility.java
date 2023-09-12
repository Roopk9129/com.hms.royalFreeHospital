package com.hms.genericUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class is used to read/write the data in to excel 
 * @author  S Roop Kumar
 */
public class ExcelFileUtility {

	/**
	 * This method is used to read/fetch the data from the excel sheets
	 * 
	 * @param SheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */

	public String readFromExcel(String SheetName, int rowNum, int cellNum) throws Throwable {
		Workbook wb = WorkbookFactory.create(new FileInputStream(IPathConstants.excelFilePath));
		return wb.getSheet(SheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();

	}

	/**
	 * 
	 * This method used to write the values in to excel
	 * 
	 * @param SheetName
	 * @param rowNum
	 * @param cellNum
	 * @param value
	 * @throws Throwable
	 */

	public void writeToExcel(String SheetName, int rowNum, int cellNum, String value) throws Throwable {
		Workbook wb = WorkbookFactory.create(new FileInputStream(IPathConstants.excelFilePath));
		wb.createSheet(SheetName).createRow(rowNum).createCell(cellNum).setCellValue(value);
		wb.write(new FileOutputStream(IPathConstants.excelFilePath));
		wb.close();

	}
	

}
