package com.hms.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientRegistrationPage {

	@FindBy(xpath = "//input[@name='full_name']")
	private WebElement FullNameEdt;

	@FindBy(xpath = "//input[@name='address']")
	private WebElement AddressEdt;

	@FindBy(xpath = "//input[@name='city']")
	private WebElement CityEdt;

	@FindBy(xpath = "//label[@for='rg-male']")
	private WebElement MaleRadioBtn;

	@FindBy(xpath = "//label[@for='rg-female']")
	private WebElement FeMaleRadioBtn;

	@FindBy(xpath = "//input[@name='email']")
	private WebElement EmailEdt;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement PasswordEdt;

	@FindBy(xpath = "//input[@name='password_again']")
	private WebElement PasswordAgainEdt;

	@FindBy(xpath = "//input[@id='agree']")
	private WebElement IAgreeChkBox;

	@FindBy(xpath = "//a[contains(text(),'Log-in')]")
	private WebElement LoginLink;

	@FindBy(xpath = "//button[@name='submit']")
	private WebElement SubmitBtn;

	public PatientRegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public WebElement getFullNameEdt() {
		return FullNameEdt;
	}

	public WebElement getAddressEdt() {
		return AddressEdt;
	}

	public WebElement getCityEdt() {
		return CityEdt;
	}

	public WebElement getMaleRadioBtn() {
		return MaleRadioBtn;
	}

	public WebElement getFeMaleRadioBtn() {
		return FeMaleRadioBtn;
	}

	public WebElement getEmailEdt() {
		return EmailEdt;
	}

	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}

	public WebElement getPasswordAgainEdt() {
		return PasswordAgainEdt;
	}

	public WebElement getIAgreeChkBox() {
		return IAgreeChkBox;
	}

	public WebElement getLoginLink() {
		return LoginLink;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}

}
