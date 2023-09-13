package com.hms.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

	@FindBy(xpath = "//input[@name='fullname']")
	private WebElement FullNameEdt;

	@FindBy(xpath = "//input[@name='emailid']")
	private WebElement EmailIDEdt;

	@FindBy(xpath = "//input[@name='mobileno']")
	private WebElement MobileNumEdt;

	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement DescriptionEdt;

	@FindBy(xpath = "//input[@name='submit']")
	private WebElement SubmitBtn;

	public ContactUsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public WebElement getFullNameEdt() {
		return FullNameEdt;
	}

	public WebElement getEmailIDEdt() {
		return EmailIDEdt;
	}

	public WebElement getMobileNumEdt() {
		return MobileNumEdt;
	}

	public WebElement getDescriptionEdt() {
		return DescriptionEdt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}

}
