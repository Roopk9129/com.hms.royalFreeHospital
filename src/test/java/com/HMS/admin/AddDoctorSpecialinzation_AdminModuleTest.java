package com.HMS.admin;


import org.testng.Assert;
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
	@Test(dataProvider = "dp", groups = "SmokeTesting")
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
		String expectedValue = value + new Java_Utils().randomIntegerNumber(100000);

		ADS.getdoctorspecilizationEdt().sendKeys(expectedValue);
		ADS.getSubmitBtn().click();

		boolean confirmationmsg = ADS.getConfirmationMessage().isDisplayed();

		Assert.assertEquals(confirmationmsg, true, "Confirmation message Successfully displayed..!");
		

//		Assert.assertEquals("Doctor Specialization added successfully !!", ADS.getConfirmationTxt(),"Confirmation message Successfully displayed..!");
//		for(WebElement ele: ADS.getListofDocSpec()) {
//			String Actual = ele.getText();
//			Assert.assertEquals(Actual, expectedValue, "Doctor Specilation Validated Successfully");
//			
//		}

		// Validation
//		WebElement confirmationMessage = driver
//				.findElement(By.xpath("//div[@class='panel panel-white']/descendant::p"));
//		if (confirmationMessage.isDisplayed()) {
//			System.out.println("DOCTOR SPECIALIZATION is created");
//			System.out.println(driver.findElement(By.xpath("//div[@class='panel panel-white']/descendant::p")).getText()
//					+ " --> Message is displayed successfully");
//		}
		ADP.getProfileIcon().click();
		Thread.sleep(1000);
		ADP.getLogOut().click();
	}

	@DataProvider
	public Object[][] dp() throws Throwable {
		ExcelFileUtility Eutil = new ExcelFileUtility();
		Object[][] value = Eutil.dataProvider("Doctor_Specialization_AdminModu");
		return value;
	}

}
