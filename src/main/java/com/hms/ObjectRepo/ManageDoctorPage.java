package com.hms.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageDoctorPage {
	
	@FindBy(xpath="//td[text()='Dermatologist']/following-sibling::td/descendant::a[@tooltip='Edit']")
	private WebElement EditIcon;
	
	@FindBy(xpath="(//a[@tooltip='Remove'])[1]")
	private WebElement RemoveIcon;
	
	public ManageDoctorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	public WebElement getEditIcon() {
		return EditIcon;
	}

	public WebElement getRemoveIcon() {
		return RemoveIcon;
	}
	//Business Libraries
	public void deleteDoctor() {
		getRemoveIcon().click();
		
	}

}
