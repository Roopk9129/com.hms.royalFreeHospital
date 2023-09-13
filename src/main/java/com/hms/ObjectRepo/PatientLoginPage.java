package com.hms.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientLoginPage {

	@FindBy(xpath = "//input[@name='username']")
	private WebElement PatientUserNameEdt;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement PatientPasswordEdt;

	@FindBy(xpath = "//a[contains(text(),'Forgot Password ?')]")
	private WebElement ForgotPasswordLink;

	@FindBy(xpath = "//button[@name='submit']")
	private WebElement SubmitBtn;

	@FindBy(xpath = "//a[contains(text(),'Create an account')]")
	private WebElement CreateAnAccount;

	public PatientLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public WebElement getPatientUserNameEdt() {
		return PatientUserNameEdt;
	}

	public WebElement getPatientPasswordEdt() {
		return PatientPasswordEdt;
	}

	public WebElement getForgotPasswordLink() {
		return ForgotPasswordLink;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}

	public WebElement getCreateAnAccount() {
		return CreateAnAccount;
	}

	public void loginAsUser(String UN, String PSD) {
		getPatientUserNameEdt().sendKeys(UN);
		getPatientPasswordEdt().sendKeys(PSD);
		getSubmitBtn().click();

	}
}
