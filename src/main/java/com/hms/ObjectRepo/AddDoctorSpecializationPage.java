package com.hms.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddDoctorSpecializationPage {
	
	@FindBy(xpath = "//input[@name='doctorspecilization']")
	private WebElement BetweenwdatesreportsLink;
	
	
	
	
	
	
	
	
	public AddDoctorSpecializationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
