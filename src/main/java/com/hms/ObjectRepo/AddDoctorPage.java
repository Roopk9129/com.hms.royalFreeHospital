package com.hms.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddDoctorPage {
	@FindBy(xpath = "//select[@name='Doctorspecialization']")
	private WebElement DoctorSpecializationDD;

	@FindBy(xpath = "//input[@name='docname']")
	private WebElement DoctorNameEdt;

	@FindBy(xpath = "//textarea[@name='clinicaddress']")
	private WebElement ClinicAddress;

	@FindBy(xpath = "//input[@name='docfees']")
	private WebElement DoctorConsultancyFeesEdt;

	@FindBy(xpath = "//input[@name='doccontact']")
	private WebElement DoctorContactNoEdt;

	@FindBy(xpath = "//input[@name='docemail']")
	private WebElement DoctorEmailEdt;

	@FindBy(xpath = "//input[@name='npass']")
	private WebElement DoctorPsdEdt;

	@FindBy(xpath = "//input[@name='cfpass']")
	private WebElement DoctorCfPsdEdt;

	public AddDoctorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getDoctorSpecializationDD() {
		return DoctorSpecializationDD;
	}

	public WebElement getDoctorNameEdt() {
		return DoctorNameEdt;
	}

	public WebElement getClinicAddress() {
		return ClinicAddress;
	}

	public WebElement getDoctorConsultancyFeesEdt() {
		return DoctorConsultancyFeesEdt;
	}

	public WebElement getDoctorContactNoEdt() {
		return DoctorContactNoEdt;
	}

	public WebElement getDoctorEmailEdt() {
		return DoctorEmailEdt;
	}

	public WebElement getDoctorPsdEdt() {
		return DoctorPsdEdt;
	}

	public WebElement getDoctorCfPsdEdt() {
		return DoctorCfPsdEdt;
	}
	
}
