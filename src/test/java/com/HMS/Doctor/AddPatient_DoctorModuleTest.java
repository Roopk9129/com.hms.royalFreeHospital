package com.HMS.Doctor;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hms.ObjectRepo.AddPatientPage;
import com.hms.ObjectRepo.DoctorDashboardPage;
import com.hms.ObjectRepo.DoctorLoginPage;
import com.hms.ObjectRepo.HomePage;
import com.hms.genericUtils.BaseClass;
import com.hms.genericUtils.ExcelFileUtility;
import com.hms.genericUtils.FileUtility;
import com.hms.genericUtils.Java_Utils;
import com.hms.genericUtils.WebDriver_Utils;

public class AddPatient_DoctorModuleTest extends BaseClass {
	@Test(dataProvider = "dpdata")
	public void addPatientDoctorModuleTest(String PatientName, String Pno, String Email, String Gender, String address,
			String age, String medicalhis) throws Throwable {
		System.out.println(PatientName+Pno+Email+Gender+address+age+medicalhis);

		// Generic class Object creation
		FileUtility fUtil = new FileUtility();
		WebDriver_Utils wUtil = new WebDriver_Utils();
		ExcelFileUtility EUtil = new ExcelFileUtility();
		Java_Utils jUtil = new Java_Utils();

		String brow = fUtil.propertyFileDataFetch("browsername");
		String Url = fUtil.propertyFileDataFetch("url");
		String un = fUtil.propertyFileDataFetch("doctorun");
		String psd = fUtil.propertyFileDataFetch("doctorpsd");

		// Browser control
		wUtil.maximizeBrowser(driver);
		driver.get(Url);
		wUtil.implicitWait(driver, 20);

		

		// Object creation for object repo
		HomePage HP = new HomePage(driver);
		DoctorLoginPage DLP = new DoctorLoginPage(driver);
		DoctorDashboardPage DDP = new DoctorDashboardPage(driver);
		AddPatientPage ADP = new AddPatientPage(driver);

		// Test Script
		HP.getDoctorModule().click();
		DLP.loginAsDoctor(un, psd);
		DDP.clickOnPatient();
		DDP.clickOnAddPatient();
		ADP.getAddPatientNameEdt().sendKeys(PatientName);
		ADP.getAddPatientContactNoEdt().sendKeys(Pno);
		ADP.getAddPatientEmailIDEdt().sendKeys(Email);
		// gender condition
		if (Gender.equalsIgnoreCase("male")) {
			ADP.getMaleRadioBtn().click();
		} else if (Gender.equalsIgnoreCase("female")) {
			ADP.getFemaleRadioBtn().click();
		}
		ADP.getAddPatientAddressEdt().sendKeys(address);
		ADP.getAddPatientAgeEdt().sendKeys(age);
		ADP.getAddPatientMediacalhisEdt().sendKeys(medicalhis);
		

	}

	@DataProvider
	public Object[][] dpdata() throws Throwable {
		ExcelFileUtility EFU = new ExcelFileUtility();
		Object[][] value = EFU.dataProviderr("AddPatientWithMedicalHistory_Do");
		return value;
	}

}
