package com.hms.ObjectRepo;

import java.util.List;

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
	
	@FindBy(xpath = "//div[@class='panel panel-white']/descendant::p")
	private WebElement ConfirmationMessage;
	
	@FindBy(xpath="//tbody/tr/td[2]")
	private List<WebElement> ListofDocSpec;

	public AddDoctorSpecializationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getdoctorspecilizationEdt() {
		return doctorspecilizationEdt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}

	public WebElement getDoctorspecilizationEdt() {
		return doctorspecilizationEdt;
	}

	public WebElement getConfirmationMessage() {
		return ConfirmationMessage;
	}
	

	public List<WebElement> getListofDocSpec() {
		return ListofDocSpec;
	}

	public void addSpecilization(String SpecName) {
		getdoctorspecilizationEdt().sendKeys(SpecName);
		getSubmitBtn().click();
	}
	
	public String getConfirmationTxt() {
		return getConfirmationMessage().getText();
	}
}
