package com.HMS.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.hms.ObjectRepo.AddDoctorSpecializationPage;
import com.hms.ObjectRepo.AdminDashboardPage;
import com.hms.ObjectRepo.AdminLoginPage;
import com.hms.ObjectRepo.HomePage;
import com.hms.genericUtils.ExcelFileUtility;
import com.hms.genericUtils.FileUtility;
import com.hms.genericUtils.Java_Utils;
import com.hms.genericUtils.WebDriver_Utils;

public class AddDoctorSpecialinzation_AdminModuleTest {
	/*
	 * Admin should be able to create Doctor Specialization
	 * 
	 * @Author: S Roop Kumar
	 */
	@Test(dataProvider = "dp")
	public void addDoctorSpecialinzation_AdminModuleTest(String value) throws Throwable {
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

		HomePage HP = new HomePage(driver);
		AddDoctorSpecializationPage ADS = new AddDoctorSpecializationPage(driver);
		AdminLoginPage ALD = new AdminLoginPage(driver);
		AdminDashboardPage ADP = new AdminDashboardPage(driver);
		
		HP.getAdminModule().click();
		ALD.AdminLogin(un, psd);
		ADP.getDoctorsLink().click();
		ADP.getDoctorSpecializationLink().click();
		ADS.getdoctorspecilizationEdt().sendKeys(value);
		ADS.getSubmitBtn().click();

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
	

	@DataProvider
	public Object[][] dp() throws Throwable {
		ExcelFileUtility Eutil = new ExcelFileUtility();
		Object[][] value = Eutil.dataProviderr("Doctor_Specialization_AdminModu");
		return value;
	}

}
