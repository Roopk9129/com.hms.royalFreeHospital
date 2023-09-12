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

public class AddDoctor_AdminModuleTest {
	/*
	 * Admin should be able to Add Doctor
	 * 
	 * @Author: S Roop Kumar
	 */

	public static void main(String[] args) throws InterruptedException, Throwable {
		WebDriver driver = null;
		// property file data fetch
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String brow = prop.getProperty("browsername");
		String Url = prop.getProperty("url");
		String un = prop.getProperty("adminun");
		String psd = prop.getProperty("adminpsd");

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

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(Url);

		// RandomInt
		Random r = new Random();
		int ranInt = r.nextInt(10000);

		// Key Values
		String ModuleName = "Admin Login";

		String doctorSpec = "Urology";
		String DoctorName = "Karthi" + ranInt;
		String DoctorClinicAddress = "1/115 venkatampatti,Dharmapuri";
		String DoctorConsultancyFees = "500";
		String DoctorContactno = "6382121323";
		String DoctorEmail = "chc.harikarthi" + ranInt + "@gmail.com";
		String Password = "Santha@2475";
		String ConfirmPassword = "Santha@2475";

		// Test Data from excel
		FileInputStream fi = new FileInputStream(".//src//test//resources//Admin_Module.xlsx");
		Workbook w = WorkbookFactory.create(fi);
		Sheet sh = w.getSheet("Doctor_Details__AdminModule");
		int lr = sh.getLastRowNum();

		// Test Script to create ADD DOCTOR SPECIALIZATION
		driver.findElement(By.xpath("//h3[text()='" + ModuleName
				+ "']/ancestor::div[@class='listview_1_of_3 images_1_of_3']/descendant::a")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(psd, Keys.ENTER);
		driver.findElement(By.xpath("//ul[@class='main-navigation-menu']/descendant::span[text()=' Doctors ']"))
				.click();
		driver.findElement(By.xpath(
				"//ul[@class='main-navigation-menu']/descendant::span[text()=' Doctors ']/following::span[text()=' Add Doctor']"))
				.click();
		WebElement DoctorspecializationDropDown = driver
				.findElement(By.xpath("//select[@name='Doctorspecialization']"));

		DoctorspecializationDropDown.click();

		driver.findElement(By.xpath("//option[contains(text(),'" + doctorSpec + "')]")).click();

		HashedMap<String, String> map = new HashedMap<>();

		for (int i = 1; i <= lr; i++) {
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		for (Entry<String, String> ss : map.entrySet()) {
			if (ss.getKey().equals("doctorname")) {
				driver.findElement(By.xpath(
						"//label[@for='" + ss.getKey() + "']/following::input[@placeholder='Enter Doctor Name']"))
						.sendKeys(ss.getValue() + "_" + ranInt);
			} else if (ss.getKey().equals("clinicaddress")) {
				driver.findElement(By.xpath("//textarea[@name='" + ss.getKey() + "']")).sendKeys(ss.getValue());

			} else if (ss.getKey().equals("Enter Doctor Contact no")) {
				driver.findElement(
						By.xpath("//label[@for='fess']/following::input[@placeholder='" + ss.getKey() + "']"))
						.sendKeys(ss.getValue());

			} else if (ss.getKey().equals("Enter Doctor Consultancy Fees")) {
				driver.findElement(
						By.xpath("//label[@for='fess']/following::input[@placeholder='" + ss.getKey() + "']"))
						.sendKeys(ss.getValue());
			}else if (ss.getKey().equals("Enter Doctor Email id")) {
				driver.findElement(
						By.xpath("//label[@for='fess']/following::input[@placeholder='" + ss.getKey() + "']"))
						.sendKeys(ss.getValue());
			}

			driver.findElement(
					By.xpath("//label[@for='fess']/following::input[@placeholder='Enter Doctor Consultancy Fees']"))
					.sendKeys(DoctorConsultancyFees);

			driver.findElement(By.xpath("//label[@for='fess']/following::input[@placeholder='Enter Doctor Email id']"))
					.sendKeys(DoctorEmail);
			driver.findElement(By.xpath("//label[@for='fess']/following::input[@placeholder='New Password']"))
					.sendKeys(Password);
			driver.findElement(By.xpath("//label[@for='fess']/following::input[@placeholder='Confirm Password']"))
					.sendKeys(ConfirmPassword, Keys.ENTER);

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
}
