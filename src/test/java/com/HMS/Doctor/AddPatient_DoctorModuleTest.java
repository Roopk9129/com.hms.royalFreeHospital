package com.HMS.Doctor;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hms.ObjectRepo.AddPatientPage;
import com.hms.ObjectRepo.DoctorDashboardPage;
import com.hms.genericUtils.ExcelFileUtility;
import com.hms.genericUtils.FileUtility;
import com.hms.genericUtils.WebDriver_Utils;

public class AddPatient_DoctorModuleTest {
	@Test(dataProvider = "dpdata")
	public void addPatient_DoctorModuleTest(String PatientName, String Pno, String Email, String address, String age,
			String medicalhis) throws Throwable {
		WebDriver driver = null;
		// Object Creation for Utility Files
		FileUtility fUtil = new FileUtility();
		WebDriver_Utils wUtil = new WebDriver_Utils();

		String brow = fUtil.propertyFileDataFetch("browsername");
		String Url = fUtil.propertyFileDataFetch("url");
		String un = fUtil.propertyFileDataFetch("doctorun");
		String psd = fUtil.propertyFileDataFetch("doctorpsd");

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
//		int ranInt = jUtil.randomIntegerNumber(10000);
//		int TempranInt = jUtil.randomIntegerNumber(100);

		// Key Values
		String ModuleName = "Doctors Login";

		// Patient Details
//		String PatientName = "Raja_" + ranInt;
//		String PatientContactno = "9876543210";
//		String PatientEmail = "raja123" + ranInt + "@gmail.com";
//		String Gender = "male";
//		String PatientAddress = "Bangalore";
//		String PatientAge = "25";
//		String MedicalHistory = "Blood group: A+, Body temperature: " + TempranInt;

		// Test Script
		driver.findElement(By.xpath("//h3[text()='" + ModuleName
				+ "']/ancestor::div[@class='listview_1_of_3 images_1_of_3']/descendant::a")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(psd, Keys.ENTER);

		// Object creation for object repo
		DoctorDashboardPage DDP = new DoctorDashboardPage(driver);
		AddPatientPage ADP = new AddPatientPage(driver);

		DDP.clickOnPatient();
		DDP.clickOnAddPatient();
		ADP.addPatient(PatientName, Pno, Email, address, age, medicalhis);

//		driver.findElement(By.xpath("//span[text()=' Patients ']")).click();
//		driver.findElement(
//				By.xpath("//span[text()=' Patients ']/following::ul/descendant::span[text()=' Add Patient']")).click();

//		HashedMap<String, String> map = new HashedMap<>();
//
//		for (int i = 1; i <= lr; i++) {
//			String key = sh.getRow(i).getCell(0).getStringCellValue();
//			String value = sh.getRow(i).getCell(1).getStringCellValue();
//			map.put(key, value);
//		}
//
//		for (Entry<String, String> ss : map.entrySet()) {
//			if(ss.getKey().equals("doctorname")) {
//				driver.findElement(By.xpath(ss.getKey())).sendKeys(ss.getValue());
//				
//			}
//			
//
//		}

//		driver.findElement(By.xpath("//input[@placeholder='Enter Patient Name']")).sendKeys(PatientName);
//		driver.findElement(By.xpath("//input[@placeholder='Enter Patient Contact no']")).sendKeys(PatientContactno);
//		driver.findElement(By.xpath("//input[@placeholder='Enter Patient Email id']")).sendKeys(PatientEmail);
//		driver.findElement(
//				By.xpath("//div[@class='clip-radio radio-primary']/descendant::label[@for='rg-" + Gender + "']"))
//				.click();
//		driver.findElement(By.xpath("//textarea[@placeholder='Enter Patient Address']")).sendKeys(PatientAddress);
//
//		driver.findElement(By.xpath("//input[@placeholder='Enter Patient Age']")).sendKeys(PatientAge);
//		driver.findElement(By.xpath("//textarea[@placeholder='Enter Patient Medical History(if any)']"))
//				.sendKeys(MedicalHistory);
//		driver.findElement(By.id("submit")).click();
//		driver.findElement(By.xpath("//span[text()=' Patients ']")).click();
//
//		driver.findElement(
//				By.xpath("//span[text()=' Patients ']/following::ul/descendant::span[text()=' Manage Patient ']"))
//				.click();

//		List<WebElement> PatientNames = driver.findElements(By.xpath("//td[@class='hidden-xs']"));
		// Validation
//		for (WebElement PN : PatientNames) {
//			String NOTP = PN.getText();
//			if (NOTP.equals(PatientName)) {
//				System.out.println("Patient has been added Successfully");
//				break;
//			}
//		}
		Thread.sleep(2000);
		driver.quit();
	}
	ExcelFileUtility EFU = new ExcelFileUtility();
	@DataProvider
	public Object[][] dpdata() throws Throwable {
		Object[][] value = EFU.dataProviderr("Sheet1");
		return value;
	}

}
