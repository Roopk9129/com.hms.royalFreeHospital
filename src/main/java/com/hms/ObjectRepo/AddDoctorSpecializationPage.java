package com.hms.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddDoctorSpecializationPage {
	
	@FindBy(xpath = "//input[@name='doctorspecilization']")
	private WebElement BetweenwdatesreportsLink;
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement SubmitBtn;
	
	@FindBy(xpath="//select[@name='Doctorspecialization']")
	private WebElement DoctorSpecializationDD;
	
	@FindBy(xpath="//input[@name='docname']")
	private WebElement DoctorNameEdt;
	
	@FindBy(xpath="//textarea[@name='clinicaddress']")
	private WebElement ClinicAddress;
	
	@FindBy(xpath="//input[@name='docfees']")
	private WebElement DoctorConsultancyFeesEdt;
	
	@FindBy(xpath="//input[@name='doccontact']")
	private WebElement DoctorContactNoEdt;
	
	@FindBy(xpath="//input[@name='docemail']")
	private WebElement DoctorEmailEdt;
	
	@FindBy(xpath="//input[@name='npass']")
	private WebElement DoctorPsdEdt;
	
	@FindBy(xpath="//input[@name='cfpass']")
	private WebElement DoctorCfPsdEdt;
	
	public AddDoctorSpecializationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
