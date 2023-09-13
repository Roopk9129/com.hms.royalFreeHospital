package com.hms.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorLoginPage {

	@FindBy(xpath = "//input[@name='username']")
	private WebElement DoctorUserNameEdt;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement DoctorPasswordEdt;

	@FindBy(xpath = "//button[@name='submit']")
	private WebElement DoctorSubmitBtn;

	@FindBy(xpath = "//a[contains(text(),'Forgot Password ?')]")
	private WebElement ForgotPasswordLink;

	public DoctorLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public WebElement getDoctorUserNameEdt() {
		return DoctorUserNameEdt;
	}

	public WebElement getDoctorPasswordEdt() {
		return DoctorPasswordEdt;
	}

	public WebElement getDoctorSubmitBtn() {
		return DoctorSubmitBtn;
	}

	public WebElement getForgotPasswordLink() {
		return ForgotPasswordLink;
	}

	public void loginAsDoctor(String UN, String PSD) {
		getDoctorUserNameEdt().sendKeys(UN);
		getDoctorPasswordEdt().sendKeys(PSD);
		getDoctorSubmitBtn().click();

	}

}
