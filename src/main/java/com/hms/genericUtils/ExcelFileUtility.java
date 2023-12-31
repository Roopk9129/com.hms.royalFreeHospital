package com.hms.genericUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Map.Entry;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class is used to read/write the data in to excel
 * 
 * @author S Roop Kumar
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

	public HashedMap<String, String> getMultipleDataFromExcel(WebDriver driver, String SheetName, int rowNum,
			int cellNum, String expectedKey) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int rowCount = sh.getLastRowNum();

		HashedMap<String, String> map = new HashedMap<>();
		for (int i = 1; i <= rowCount; i++) {
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		for (Entry<String, String> ss : map.entrySet()) {
			if (ss.getKey().contains(expectedKey)) {
				driver.findElement(By.xpath(ss.getKey()))
						.sendKeys(ss.getValue() + new Java_Utils().randomIntegerNumber(1000));

			}
		}
		return map;

	}

	public String pullMultipleDataFromSheet(String SheetName) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int LR = sh.getLastRowNum();
		short LC = sh.getRow(0).getLastCellNum();
		StringBuilder result = new StringBuilder();

		for (int i = 1; i <= LR; i++) {
			for (int j = 0; j < LC; j++) {
				String cellValue = sh.getRow(i).getCell(j).getStringCellValue();
				result.append(cellValue + "\n");
			}
		}

		return result.toString();
	}

	public Object[][] dataProvider(String SheetName) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(SheetName);
		int lr = sheet.getLastRowNum() + 1;
		int lc = sheet.getRow(0).getLastCellNum();
		Object[][] obj = new Object[lr - 1][lc];

		for (int i = 1; i < lr; i++) {
			for (int j = 0; j < lc; j++) {
				obj[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}

		return obj;
	}

}
