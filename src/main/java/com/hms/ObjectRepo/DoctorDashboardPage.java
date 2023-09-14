package com.hms.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorDashboardPage {
	@FindBy(xpath = "//ul[@class='main-navigation-menu']/descendant::span[text()=' Dashboard ']")
	private WebElement DashboardLink;

	@FindBy(xpath = "//ul[@class='main-navigation-menu']/descendant::span[text()=' Appointment History ']")
	private WebElement AppointmentHistoryLink;

	@FindBy(xpath = "//ul[@class='main-navigation-menu']/descendant::span[text()=' Patients ']")
	private WebElement PatientsLink;

	@FindBy(xpath = "//ul[@class='main-navigation-menu']/descendant::span[text()=' Search ']")
	private WebElement SearchLink;

	public DoctorDashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getDashboardLink() {
		return DashboardLink;
	}

	public WebElement getAppointmentHistoryLink() {
		return AppointmentHistoryLink;
	}

	public WebElement getPatientsLink() {
		return PatientsLink;
	}

	public WebElement getSearchLink() {
		return SearchLink;
	}

	// Business Library
	public void clickOnDashboard() {
		getDashboardLink().click();
	}

	public void clickOnAppointmentHistory() {
		getAppointmentHistoryLink().click();
	}

	public void clickOnPatient() {
		getPatientsLink().click();
	}

	public void clickOnSearch() {
		getSearchLink().click();
	}

}
