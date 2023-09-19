package com.HMS.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.hms.ObjectRepo.AddDoctorSpecializationPage;
import com.hms.ObjectRepo.AdminDashboardPage;
import com.hms.ObjectRepo.AdminLoginPage;
import com.hms.ObjectRepo.HomePage;
import com.hms.genericUtils.BaseClass;
import com.hms.genericUtils.ExcelFileUtility;
import com.hms.genericUtils.Java_Utils;

public class AddDoctorSpecialinzation_AdminModuleTest extends BaseClass {
	/*
	 * Admin should be able to create Doctor Specialization
	 * 
	 * @Author: S Roop Kumar
	 */
	@Test(dataProvider = "dp")
	public void addDoctorSpecialinzation_AdminModuleTest(String value) throws Throwable {

		HomePage HP = new HomePage(driver);
		AddDoctorSpecializationPage ADS = new AddDoctorSpecializationPage(driver);
		AdminLoginPage ALP = new AdminLoginPage(driver);
		AdminDashboardPage ADP = new AdminDashboardPage(driver);
		HP.clickOnAdminLogin();
		ALP.AdminLogin(fUtil.propertyFileDataFetch("adminun"), fUtil.propertyFileDataFetch("adminpsd"));
		ADP.clickOnDoctors();

		ADP.getDoctorsLink().click();
		ADP.getDoctorSpecializationLink().click();

		ADS.getdoctorspecilizationEdt().sendKeys(value + new Java_Utils().randomIntegerNumber(10000));
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
