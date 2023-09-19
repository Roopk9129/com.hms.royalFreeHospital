package com.HMS.admin;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.hms.ObjectRepo.AddDoctorPage;
import com.hms.ObjectRepo.AdminDashboardPage;
import com.hms.ObjectRepo.AdminLoginPage;
import com.hms.ObjectRepo.HomePage;
import com.hms.genericUtils.BaseClass;
import com.hms.genericUtils.ExcelFileUtility;

public class AddDoctor_AdminModuleTest extends BaseClass {
	/*
	 * Admin should be able to Add Doctor
	 * 
	 * @Author: S Roop Kumar
	 */
	@Test(dataProvider = "dpp")
	public void addDoctor_AdminModuleTest(String Dspec, String Dname, String address, String fee, String phno,
			String Email, String psd, String cnfpsd) throws Throwable {
		// Object repo
		HomePage HP = new HomePage(driver);
		AdminLoginPage ALP = new AdminLoginPage(driver);
		AdminDashboardPage ADP = new AdminDashboardPage(driver);
		AddDoctorPage ADPP = new AddDoctorPage(driver);

		HP.clickOnAdminLogin();
		ALP.AdminLogin(fUtil.propertyFileDataFetch("adminun"), fUtil.propertyFileDataFetch("adminpsd"));
		ADP.clickOnDoctors();
		ADP.clickOnAddDoctor();
		// Append Random number to email
		String[] afterSplit = Email.split("@");
		String str = afterSplit[0] + jUtil.randomIntegerNumber(100000) + "@" + afterSplit[1];

		ADPP.addDoctor(Dspec, Dname, address, fee, phno, str, psd, cnfpsd);

		String alerttext = wUtil.getAlertText(driver);
		// validation
		if (alerttext.equalsIgnoreCase("Doctor info added Successfully")) {
			System.out.println("Alert Message Popped up successfully");
			System.out.println(alerttext + " --> Message Displayed Successfully");
			wUtil.acceptAlert(driver);
		}

	}

	@DataProvider(name = "dpp")
	public Object[][] dp() throws Throwable {
		ExcelFileUtility EFU = new ExcelFileUtility();
		return EFU.dataProviderr("Doctor_Details_AdminModule");

	}

}
