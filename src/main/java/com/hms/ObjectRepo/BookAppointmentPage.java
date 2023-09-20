package com.hms.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.genericUtils.WebDriver_Utils;

public class BookAppointmentPage extends WebDriver_Utils{
	@FindBy(xpath = "//select[@name='Doctorspecialization']")
	private WebElement DoctorSpecDD;
	
	@FindBy(xpath = "//select[@name='doctor']")
	private WebElement DoctorDD;
	
	@FindBy(xpath = "//input[@name='appdate']")
	private WebElement DateDD;
	
	@FindBy(xpath = "//input[@name='apptime']")
	private WebElement TimeDD;
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement SubmitBtn;

	public BookAppointmentPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getDoctorSpecDD() {
		return DoctorSpecDD;
	}

	public WebElement getDoctorDD() {
		return DoctorDD;
	}

	public WebElement getDateDD() {
		return DateDD;
	}

	public WebElement getTimeDD() {
		return TimeDD;
	}
	
	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}

	public void bookAppointment(String specname, String docName, String date, String time) {
		dropdownHandle(getDoctorSpecDD(), specname);
		dropdownHandle(getDoctorDD(), docName);
		getDoctorDD().sendKeys(date);
		getTimeDD().sendKeys(time);
		getSubmitBtn().click();
	}

}
