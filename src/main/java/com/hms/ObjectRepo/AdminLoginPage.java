package com.hms.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {

	@FindBy(xpath = "//input[@name='username']")
	private WebElement AdminUserNameEdt;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement AdminPasswordEdt;

	@FindBy(xpath = "//button[@name='submit']")
	private WebElement SubmitBtn;

	

	public AdminLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public WebElement getAdminUserNameEdt() {
		return AdminUserNameEdt;
	}

	public WebElement getAdminPasswordEdt() {
		return AdminPasswordEdt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}

	

	public void AdminLogin(String UN, String PSD) {
		getAdminUserNameEdt().sendKeys(UN);
		getAdminPasswordEdt().sendKeys(PSD);
		getSubmitBtn().click();

	}

}
