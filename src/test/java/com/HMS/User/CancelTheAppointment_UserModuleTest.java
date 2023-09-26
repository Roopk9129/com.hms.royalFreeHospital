package com.HMS.User;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hms.ObjectRepo.BookAppointmentPage;
import com.hms.ObjectRepo.HomePage;
import com.hms.ObjectRepo.PatientDashboardPage;
import com.hms.ObjectRepo.PatientLoginPage;
import com.hms.genericUtils.BaseClass;
import com.hms.genericUtils.ExcelFileUtility;

public class CancelTheAppointment_UserModuleTest extends BaseClass {
	/*
	 * @author: S Roop Kumar Click on Book 'Appointment History' from Main
	 * Navigation pane Click on 'cancel' link under Action column Click 'Ok' on
	 * alert Message
	 * 
	 */
	
	@Test(groups = "SmokeTesting")
	public void cancelTheAppointment_UserModuleTest(String specnamee, String docName, String date, String time)
			throws Throwable {

		// Object repo object creation
		HomePage HP = new HomePage(driver);
		PatientLoginPage PLP = new PatientLoginPage(driver);
		PatientDashboardPage PDP = new PatientDashboardPage(driver);
		BookAppointmentPage BAP = new BookAppointmentPage(driver);

		// test Script
		HP.getPatientModule().click();
		PLP.loginAsUser(fUtil.propertyFileDataFetch("userun"), fUtil.propertyFileDataFetch("userpsd"));
		PDP.clickOnBookAppointmentLink();
		BAP.bookAppointment(specnamee, docName, date, time);

	}

	@DataProvider
	public Object[][] dp() throws Throwable {
		ExcelFileUtility eutil = new ExcelFileUtility();
		return eutil.dataProvider("BookAppointment_PatientModule");

	}

}
