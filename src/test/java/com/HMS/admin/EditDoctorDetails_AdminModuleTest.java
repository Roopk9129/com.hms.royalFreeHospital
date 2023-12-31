package com.HMS.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.hms.ObjectRepo.AdminDashboardPage;
import com.hms.ObjectRepo.AdminLoginPage;
import com.hms.ObjectRepo.EditDoctorDetailsPage;
import com.hms.ObjectRepo.HomePage;
import com.hms.ObjectRepo.ManageDoctorPage;
import com.hms.genericUtils.BaseClass;
import com.hms.genericUtils.ExcelFileUtility;


public class EditDoctorDetails_AdminModuleTest extends BaseClass {
	/*
	 * Admin should able to edit Doctor details
	 * 
	 * @Author S Roop Kumar
	 */
	@Test(dataProvider = "dp", groups = "SmokeTesting")
	public void editDoctorDetails_AdminModuleTest(String Dname, String Address, String fee, String contact)
			throws Throwable {

		// object creation
		HomePage HP = new HomePage(driver);
		AdminLoginPage ALP = new AdminLoginPage(driver);
		AdminDashboardPage ADP = new AdminDashboardPage(driver);
		ManageDoctorPage MDP = new ManageDoctorPage(driver);
		EditDoctorDetailsPage EDDP = new EditDoctorDetailsPage(driver);

		HP.clickOnAdminLogin();
		ALP.AdminLogin(fUtil.propertyFileDataFetch("adminun"), fUtil.propertyFileDataFetch("adminpsd"));
		ADP.clickOnDoctors();
		ADP.clickOnManageDoctor();
		MDP.getEditIcon().click();

		EDDP.EditDoctorDetails(Dname, Address, fee, contact);

		WebElement confirmationMsg = driver.findElement(
				By.xpath("//div[@class='col-md-12']/descendant::h5[contains(text(),'updated Successfully')]"));
		if (confirmationMsg.isDisplayed()) {
			System.out.println("Confirmation Message is Dispalyed");
			String confirmationTxt = confirmationMsg.getText();

			if (confirmationTxt.equalsIgnoreCase("Doctor Details updated Successfully")) {
				System.out.println("Doctor Details updated Successfully");

			}
		}
		ADP.getProfileIcon().click();
		Thread.sleep(1000);
		ADP.getLogOut().click();

	}

	ExcelFileUtility eutil = new ExcelFileUtility();

	@DataProvider
	public Object[][] dp() throws Throwable {
		return eutil.dataProvider("editDoctorDetails_AdminModuleTe");

	}

}
