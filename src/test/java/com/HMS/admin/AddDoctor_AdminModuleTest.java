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
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hms.ObjectRepo.AddDoctorPage;
import com.hms.ObjectRepo.AdminDashboardPage;
import com.hms.ObjectRepo.AdminLoginPage;
import com.hms.genericUtils.ExcelFileUtility;
import com.hms.genericUtils.FileUtility;
import com.hms.genericUtils.Java_Utils;
import com.hms.genericUtils.WebDriver_Utils;

public class AddDoctor_AdminModuleTest {
	/*
	 * Admin should be able to Add Doctor
	 * 
	 * @Author: S Roop Kumar
	 */

	public static void main(String[] args) throws InterruptedException, Throwable {
		WebDriver driver = null;
		// Object Creation for Utility Files
		FileUtility fUtil = new FileUtility();
		WebDriver_Utils wUtil = new WebDriver_Utils();
		ExcelFileUtility EUtil = new ExcelFileUtility();
		Java_Utils jUtil = new Java_Utils();
		// Object Creation for Object repo
		AdminLoginPage ALP = new AdminLoginPage(driver);
		AdminDashboardPage ADP = new AdminDashboardPage(driver);
		AddDoctorPage ADPE = new AddDoctorPage(driver);

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
		// RandomInt
		int ranInt = jUtil.randomIntegerNumber(10000);

		// Key Values
		String doctorSpec = EUtil.readFromExcel("Doctor_Details__AdminModule", 1, 0);
		String DoctorName = EUtil.readFromExcel("Doctor_Details__AdminModule", 2, 0);
		String DoctorClinicAddress = EUtil.readFromExcel("Doctor_Details__AdminModule", 3, 0);
		String DoctorConsultancyFees = EUtil.readFromExcel("Doctor_Details__AdminModule", 4, 0);
		String DoctorContactno = EUtil.readFromExcel("Doctor_Details__AdminModule", 5, 0);
		String DoctorEmail = EUtil.readFromExcel("Doctor_Details__AdminModule", 6, 0);
		String Password = EUtil.readFromExcel("Doctor_Details__AdminModule", 7, 0);
		String ConfirmPassword = EUtil.readFromExcel("Doctor_Details__AdminModule", 8, 0);

		// Test Script
		ALP.AdminLogin(un, psd);
		ADP.clickOnDoctors();
		ADP.clickOnAddDoctor();
		HashedMap<String, String> map = EUtil.getMultipleDataFromExcel(driver, "Doctor_Details__AdminModule", 1, 0, "");
		ADPE.createDoctor(driver, map);
//		HashedMap<String, String> data = EUtil.getMultipleDataFromExcel(driver, "Doctor_Details__AdminModule", 1, 0, "");

				
//		ADPE.createDoctor(doctorSpec, DoctorName + ranInt, DoctorClinicAddress, DoctorConsultancyFees, DoctorContactno,
//				DoctorEmail, Password, ConfirmPassword);

//		WebElement DoctorspecializationDropDown = driver
//				.findElement(By.xpath("//select[@name='Doctorspecialization']"));
//
//		DoctorspecializationDropDown.click();

//		driver.findElement(By.xpath("//option[contains(text(),'" + doctorSpec + "')]")).click();

		Alert confirmation = driver.switchTo().alert();
		String alerttext = confirmation.getText();
		// validation
		if (alerttext.equalsIgnoreCase("Doctor info added Successfully")) {
			System.out.println("Alert Message Popped up successfully");
			System.out.println(alerttext + " --> Message Displayed Successfully");
			confirmation.accept();
		}
		Thread.sleep(2000);
		driver.quit();

	}

}
