package com.hms.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditDoctorDetailsPage {
	@FindBy(xpath = "//select[@name='Doctorspecialization']")
	private WebElement DoctorSpecDD;

	@FindBy(xpath = "//input[@name='docname']")
	private WebElement DoctorNameEdt;

	@FindBy(xpath = "//textarea[@name='clinicaddress']")
	private WebElement DoctorAddressEdt;

	@FindBy(xpath = "//input[@name='docfees']")
	private WebElement ConsultationFeeEdt;

	@FindBy(xpath = "//input[@name='doccontact']")
	private WebElement DoctorContactNoEet;

	@FindBy(xpath = "//button[@name='submit']")
	private WebElement UpdateBtn;

	public EditDoctorDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public WebElement getDoctorSpecDD() {
		return DoctorSpecDD;
	}

	public WebElement getDoctorNameEdt() {
		return DoctorNameEdt;
	}

	public WebElement getDoctorAddressEdt() {
		return DoctorAddressEdt;
	}

	public WebElement getConsultationFeeEdt() {
		return ConsultationFeeEdt;
	}

	public WebElement getDoctorContactNoEet() {
		return DoctorContactNoEet;
	}

	public WebElement getUpdateBtn() {
		return UpdateBtn;
	}

	public void EditDoctorDetails(String name, String Addess, String consulFees, String ContactNo) {
		getDoctorNameEdt().clear();
		getDoctorAddressEdt().clear();
		getConsultationFeeEdt().clear();
		getDoctorContactNoEet().clear();
		getDoctorNameEdt().sendKeys(name);
		getDoctorAddressEdt().sendKeys(Addess);
		getConsultationFeeEdt().sendKeys(consulFees);
		getDoctorContactNoEet().sendKeys(ContactNo);
		getUpdateBtn().click();

	}

}
