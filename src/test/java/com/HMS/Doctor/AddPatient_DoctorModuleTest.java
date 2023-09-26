package com.HMS.Doctor;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hms.ObjectRepo.AddPatientPage;
import com.hms.ObjectRepo.DoctorDashboardPage;
import com.hms.ObjectRepo.DoctorLoginPage;
import com.hms.ObjectRepo.HomePage;
import com.hms.genericUtils.BaseClass;
import com.hms.genericUtils.ExcelFileUtility;

public class AddPatient_DoctorModuleTest extends BaseClass {
	@Test(dataProvider = "dpdata", groups = "SmokeTesting")
	public void addPatientDoctorModuleTest(String PatientName, String Pno, String Email, String Gender, String address,
			String age, String medicalhis) throws Throwable {

		// Object creation for object repo
		HomePage HP = new HomePage(driver);
		DoctorLoginPage DLP = new DoctorLoginPage(driver);
		DoctorDashboardPage DDP = new DoctorDashboardPage(driver);
		AddPatientPage ADP = new AddPatientPage(driver);

		// Test Script
		HP.getDoctorModule().click();
		DLP.loginAsDoctor(fUtil.propertyFileDataFetch("doctorun"), fUtil.propertyFileDataFetch("doctorpsd"));
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
		Object[][] value = EFU.dataProvider("AddPatientWithMedicalHistory_Do");
		return value;
	}

}
