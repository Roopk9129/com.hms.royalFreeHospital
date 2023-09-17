package com.hms.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPatientPage {
	@FindBy(xpath = "//input[@placeholder='Enter Patient Name']")
	private WebElement AddPatientEdt;

	@FindBy(xpath = "//input[@placeholder='Enter Patient Contact no']")
	private WebElement AddPatientContactNoEdt;

	@FindBy(xpath = "//input[@placeholder='Enter Patient Email id']")
	private WebElement AddPatientEmailIDEdt;

	@FindBy(xpath = "//label[@for='rg-male']")
	private WebElement MaleRadioBtn;

	@FindBy(xpath = "//label[@for='rg-female']")
	private WebElement FemaleRadioBtn;

	@FindBy(xpath = "//textarea[@placeholder='Enter Patient Address']")
	private WebElement AddPatientAddressEdt;

	@FindBy(xpath = "//input[@placeholder='Enter Patient Age']")
	private WebElement AddPatientAgeEdt;

	@FindBy(xpath = "//textarea[@placeholder='Enter Patient Medical History(if any)']")
	private WebElement AddPatientMediacalhisEdt;

	@FindBy(id = "submit")
	private WebElement AddBtn;

	public AddPatientPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public WebElement getAddPatientEdt() {
		return AddPatientEdt;
	}

	public WebElement getAddPatientContactNoEdt() {
		return AddPatientContactNoEdt;
	}

	public WebElement getAddPatientEmailIDEdt() {
		return AddPatientEmailIDEdt;
	}

	public WebElement getMaleRadioBtn() {
		return MaleRadioBtn;
	}

	public WebElement getFemaleRadioBtn() {
		return FemaleRadioBtn;
	}

	public WebElement getAddPatientAddressEdt() {
		return AddPatientAddressEdt;
	}

	public WebElement getAddPatientAgeEdt() {
		return AddPatientAgeEdt;
	}

	public WebElement getAddPatientMediacalhisEdt() {
		return AddPatientMediacalhisEdt;
	}

	public WebElement getAddBtn() {
		return AddBtn;
	}

	public void addPatient(String PatientName, String PatientPhoneNo, String Email, String address, String age,
			String MedicalHis) {
		
		getAddPatientEdt().sendKeys(PatientName);
		getAddPatientContactNoEdt().sendKeys(PatientPhoneNo);
		getAddPatientEmailIDEdt().sendKeys(Email);
		getAddPatientAddressEdt().sendKeys(address);
		getAddPatientAgeEdt().sendKeys(age);
		getAddPatientMediacalhisEdt().sendKeys(MedicalHis);
		getAddBtn().click();
	}

}
