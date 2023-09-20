package com.HMS.admin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import com.hms.ObjectRepo.AdminDashboardPage;
import com.hms.ObjectRepo.AdminLoginPage;
import com.hms.ObjectRepo.HomePage;
import com.hms.ObjectRepo.ManageDoctorPage;
import com.hms.genericUtils.BaseClass;

public class DeleteDoctor_AdminModuleTest extends BaseClass {
	/*
	 * Admin should able to Manage Doctors
	 * 
	 * @author
	 * 
	 */
	@Test(groups = "SmokeTesting")
	public void deleteDoctor_AdminModuleTest() throws Throwable {
		// object creation for repo
		HomePage HP = new HomePage(driver);
		AdminLoginPage ALP = new AdminLoginPage(driver);
		AdminDashboardPage ADP = new AdminDashboardPage(driver);
		ManageDoctorPage MDP = new ManageDoctorPage(driver);

		HP.clickOnAdminLogin();
		ALP.AdminLogin(fUtil.propertyFileDataFetch("adminun"), fUtil.propertyFileDataFetch("adminpsd"));
		ADP.clickOnDoctors();
		ADP.clickOnManageDoctor();
		MDP.deleteDoctor();

		Alert cofir = driver.switchTo().alert();
		String Message = cofir.getText();
		if (Message.equalsIgnoreCase("Are you sure you want to delete?")) {
			System.out.println(Message + " --->Alert Popup is dispalyed ");
			cofir.accept();
			WebElement DataDeletedMessage = driver.findElement(By.xpath("//p[contains(text(),'data deleted !!')]"));
			if (DataDeletedMessage.isDisplayed()) {
				System.out.println(DataDeletedMessage.getText() + " ---> Confirmation Message has been displayed");

			} else {
				System.out.println("Confirmation Message has not been displayed");
			}
		} else {
			System.out.println("Alert popup is failed to display");
		}

	}

}
