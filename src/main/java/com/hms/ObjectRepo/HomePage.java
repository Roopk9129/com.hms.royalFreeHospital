package com.hms.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(xpath = "//h3[text()='Admin Login']/ancestor::div[@class='listview_1_of_3 images_1_of_3']/descendant::a")
	private WebElement AdminModule;

	@FindBy(xpath = "//h3[text()='Doctors Login']/ancestor::div[@class='listview_1_of_3 images_1_of_3']/descendant::a")
	private WebElement DoctorModule;

	@FindBy(xpath = "//h3[text()='Patients']/ancestor::div[@class='listview_1_of_3 images_1_of_3']/descendant::a")
	private WebElement PatientModule;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public WebElement getAdminModule() {
		return AdminModule;
	}

	public WebElement getDoctorModule() {
		return DoctorModule;
	}

	public WebElement getPatientModule() {
		return PatientModule;
	}

}
