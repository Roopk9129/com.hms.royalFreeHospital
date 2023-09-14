package com.hms.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.genericUtils.ExcelFileUtility;
import com.hms.genericUtils.WebDriver_Utils;

public class AddDoctorSpecializationPage extends WebDriver_Utils {

	@FindBy(xpath = "//input[@name='doctorspecilization']")
	private WebElement doctorspecilizationEdt;

	@FindBy(xpath = "//button[@name='submit']")
	private WebElement SubmitBtn;

	public AddDoctorSpecializationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getdoctorspecilizationEdt() {
		return doctorspecilizationEdt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}

	public void addSpecilization(String SpecName) {
		getdoctorspecilizationEdt().sendKeys(SpecName);
		getSubmitBtn().click();
	}
}
