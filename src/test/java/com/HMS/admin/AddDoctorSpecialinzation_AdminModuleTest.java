package com.HMS.admin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hms.genericUtils.ExcelFileUtility;
import com.hms.genericUtils.FileUtility;
import com.hms.genericUtils.Java_Utils;
import com.hms.genericUtils.WebDriver_Utils;

public class AddDoctorSpecialinzation_AdminModuleTest {

	public static void main(String[] args) throws InterruptedException, Throwable {

		/*
		 * click on doctors link from Main Navigate Pane NA "Dropdown list box displayed
		 * under Doctors Doctor Specialization,Add Doctor,Mangae Doctor link should be
		 * displayed" "click on doctor specialization under Doctors link click on
		 * submit" Enter Doctor specialization:Urology Doctor specialization added
		 * successfully
		 * 
		 */
		/*
		 * Admin should be able to create Doctor Specialization
		 * 
		 * @Author: S Roop Kumar
		 */

		WebDriver driver = null;
		// Object Creation for Utility Files
		FileUtility fUtil = new FileUtility();
		WebDriver_Utils wUtil = new WebDriver_Utils();
		ExcelFileUtility EUtil = new ExcelFileUtility();
		Java_Utils jUtil = new Java_Utils();

		String brow = fUtil.propertyFileDataFetch("browsername");
		String Url = fUtil.propertyFileDataFetch("url");
		String un = fUtil.propertyFileDataFetch("adminun");
		String psd = fUtil.propertyFileDataFetch("adminpsd");

		// Browser Control
		if (brow.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			System.out.println("Chrome has launched");

		} else if (brow.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			System.out.println("Firefox has launched");

		} else {
			System.out.println("Invalid Browser name");
		}

		wUtil.maximizeBrowser(driver);
		driver.get(Url);
		wUtil.implicitWait(driver, 20);
		// Test Data from excel
		FileInputStream fi = new FileInputStream(".//src//test//resources//Admin_Module.xlsx");
		Workbook w = WorkbookFactory.create(fi);
		Sheet sh = w.getSheet("Doctor_Specialization_AdminModu");
		int lr = sh.getLastRowNum();

//		RandomInt
		int ranInt = jUtil.randomIntegerNumber(10000);

		// Key Values
		String ModuleName = "Admin Login";

		// Test Script to create ADD DOCTOR SPECIALIZATION
		driver.findElement(By.xpath("//h3[text()='" + ModuleName
				+ "']/ancestor::div[@class='listview_1_of_3 images_1_of_3']/descendant::a")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(psd, Keys.ENTER);
		driver.findElement(By.xpath("//ul[@class='main-navigation-menu']/descendant::span[text()=' Doctors ']"))
				.click();
		driver.findElement(By.xpath(
				"//ul[@class='main-navigation-menu']/descendant::span[text()=' Doctors ']/following::span[text()=' Doctor Specialization ']"))
				.click();
//		HashedMap<String, String> map = new HashedMap<>();
//		for (int i = 1; i <= lr; i++) {
//			String key = sh.getRow(i).getCell(0).getStringCellValue();
//			String value = sh.getRow(i).getCell(1).getStringCellValue();
//			map.put(key, value);
//
//		}
//		for (Entry<String, String> ss : map.entrySet()) {
//			driver.findElement(By.name(ss.getKey())).sendKeys(ss.getValue() + ranInt, Keys.ENTER);
//
//		}

		EUtil.getMultipleDataFromExcel(driver, "Doctor_Specialization_AdminModu", 1, 0, "");

		// Validation
		WebElement confirmationMessage = driver
				.findElement(By.xpath("//div[@class='panel panel-white']/descendant::p"));
		if (confirmationMessage.isDisplayed()) {
			System.out.println("DOCTOR SPECIALIZATION is created");
			System.out.println(driver.findElement(By.xpath("//div[@class='panel panel-white']/descendant::p")).getText()
					+ " --> Message is displayed successfully");

		}
		Thread.sleep(2000);
		driver.quit();

	}

}
