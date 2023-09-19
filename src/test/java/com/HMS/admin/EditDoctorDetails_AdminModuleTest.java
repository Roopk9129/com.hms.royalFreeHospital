package com.HMS.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hms.ObjectRepo.AdminDashboardPage;
import com.hms.ObjectRepo.EditDoctorDetailsPage;
import com.hms.ObjectRepo.ManageDoctorPage;
import com.hms.genericUtils.BaseClass;
import com.hms.genericUtils.ExcelFileUtility;
import com.hms.genericUtils.FileUtility;
import com.hms.genericUtils.Java_Utils;
import com.hms.genericUtils.WebDriver_Utils;

public class EditDoctorDetails_AdminModuleTest extends BaseClass{
	/*
	 * Admin should able to edit Doctor details
	 * 
	 * @Author S Roop Kumar
	 */
	@Test
	public void editDoctorDetails_AdminModuleTest() throws Throwable {

		// object creation
		AdminDashboardPage ADP = new AdminDashboardPage(driver);
		ManageDoctorPage MDP = new ManageDoctorPage(driver);
		EditDoctorDetailsPage EDP = new EditDoctorDetailsPage(driver);

		ADP.clickOnDoctors();
		ADP.clickOnManageDoctor();
		MDP.getEditIcon().click();

//		driver.findElement(By.xpath("//ul[@class='main-navigation-menu']/descendant::span[text()=' Doctors ']"))
//				.click();
//		driver.findElement(By.xpath(
//				"//ul[@class='main-navigation-menu']/descendant::span[text()=' Doctors ']/following::span[text()=' Manage Doctors ']"))
//				.click();
//		driver.findElement(By.xpath("(//a[@tooltip='Edit'])[1]")).click();
//		WebElement DoctorspecializationDropDown = driver
//				.findElement(By.xpath("//select[@name='Doctorspecialization']"));
//		DoctorspecializationDropDown.click();
//		driver.findElement(By.xpath("//option[contains(text(),'" + doctorSpec + "')]")).click();
//
//		WebElement Doctor_Name = driver.findElement(By.xpath("//input[@name='docname']"));
//		WebElement Doctor_Clinic_Address = driver.findElement(By.xpath("//textarea[@name='clinicaddress']"));
//		WebElement Doctor_Consultancy_Fees = driver.findElement(By.xpath("//input[@name='docfees']"));
//		WebElement Doctor_Contact_no = driver.findElement(By.xpath("//input[@name='doccontact']"));
//		WebElement SubBtn = driver.findElement(By.xpath("//button[@name='submit']"));

//		Doctor_Name.clear();
//		Doctor_Clinic_Address.clear();
//		Doctor_Consultancy_Fees.clear();
//		Doctor_Contact_no.clear();
//
//		Doctor_Name.sendKeys(DoctorName);
//		Doctor_Clinic_Address.sendKeys(DoctorClinicAddress);
//		Doctor_Consultancy_Fees.sendKeys(DoctorConsultancyFees);
//		Doctor_Contact_no.sendKeys(DoctorContactno);
//		SubBtn.click();

		WebElement confirmationMsg = driver.findElement(
				By.xpath("//div[@class='col-md-12']/descendant::h5[contains(text(),'updated Successfully')]"));
		if (confirmationMsg.isDisplayed()) {
			System.out.println("Confirmation Message is Dispalyed");
			String confirmationTxt = confirmationMsg.getText();

			if (confirmationTxt.equalsIgnoreCase("Doctor Details updated Successfully")) {
				System.out.println("Doctor Details updated Successfully");

			}
		}

	}

	ExcelFileUtility eutil = new ExcelFileUtility();

	@DataProvider
	public void dp() throws Throwable {
		eutil.dataProviderr("");

	}

}
