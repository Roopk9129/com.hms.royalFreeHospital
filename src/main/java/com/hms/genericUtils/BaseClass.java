package com.hms.genericUtils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.hms.ObjectRepo.AdminLoginPage;
import com.hms.ObjectRepo.HomePage;

public class BaseClass {
	public WebDriver driver;
	public FileUtility fUtil = new FileUtility();
	public WebDriver_Utils wUtil = new WebDriver_Utils();
	public ExcelFileUtility EUtil = new ExcelFileUtility();
	public Java_Utils jUtil = new Java_Utils();

	public boolean Adminflag = false;
	public boolean DoctorFlag = false;
	public boolean PatientFlag = false;

	public boolean UnAdminFlag = false;
	public boolean UnDoctorFlag = false;
	public boolean UnPatientFlag = false;
	HomePage HP = new HomePage(driver);

	@BeforeSuite
	public void BS() {
		System.out.println("Database connected");

	}

	@BeforeTest
	public void BT() throws Throwable {
		String brow = fUtil.propertyFileDataFetch("browsername");
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

	}

	@BeforeClass
	public void BC() throws Throwable {
		String Url = fUtil.propertyFileDataFetch("url");
		driver.get(Url);
		wUtil.implicitWait(driver, 20);

		System.out.println("BC Executed");

	}

//	@BeforeMethod
//	public void BM() throws Throwable {
//		String Url = fUtil.propertyFileDataFetch("url");
//		driver.get(Url);
//		String className = getClass().getName();
//		if (className == "com.HMS.admin.AddDoctorSpecialinzation_AdminModuleTest"
//				|| className == "com.HMS.admin.AddDoctor_AdminModuleTest") {
//			Adminflag = true;
//		} else if (className == "com.HMS.Doctor.AddPatient_DoctorModuleTest"
//				|| className == "com.HMS.Doctor.AddPatientWithMedicalHistory_DoctorModuleTest") {
//			DoctorFlag = true;
//		} else if (className == "com.HMS.User.BookAppointmentCanceltheAppointment_UserModuleTest"
//				|| className == "om.HMS.User.CancelTheAppointment_UserModuleTest") {
//			PatientFlag = true;
//
//		}
//		if (UnAdminFlag == false) {
//			UnAdminFlag = true;
//
//		} else if (UnDoctorFlag == false) {
//			UnDoctorFlag = true;
//		} else if (UnPatientFlag == false) {
//			UnPatientFlag = true;
//		}
//		System.out.println("BM");
//
//	}

	@AfterSuite
	public void AS() {
		System.out.println("AS Executed");
	}

	@AfterTest
	public void AT() {
		System.out.println("AT Executed");

	}

	@AfterClass
	public void AC() {
		System.out.println("AC Executed");

	}

//	@AfterMethod
//	public void AM() {
//		System.out.println("AM Executed");
//
//	}

}
