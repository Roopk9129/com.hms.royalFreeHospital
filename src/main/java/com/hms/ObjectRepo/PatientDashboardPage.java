package com.hms.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientDashboardPage {
	@FindBy(xpath = "//span[text()=' Book Appointment ']")
	private WebElement BookAppointmentLink;

	@FindBy(xpath = "//span[text()=' Appointment History ']")
	private WebElement AppointmentHistoryLink;

	@FindBy(xpath = "//span[text()=' Medical History ']")
	private WebElement MedicalHistoryLink;

	public PatientDashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public WebElement getBookAppointmentLink() {
		return BookAppointmentLink;
	}

	public WebElement getAppointmentHistoryLink() {
		return AppointmentHistoryLink;
	}

	public WebElement getMedicalHistoryLink() {
		return MedicalHistoryLink;
	}
	
	public void clickOnBookAppointmentLink() {
		getBookAppointmentLink().click();
	}
	public void clickOnAppointmentHistoryLink() {
		getAppointmentHistoryLink().click();
	}
	public void clickOnMedicalHistoryLink() {
		getMedicalHistoryLink().click();
	}

}
