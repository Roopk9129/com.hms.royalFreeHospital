package com.hms.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppointmentHistorypage {
	@FindBy(xpath = "//td[text()='Karthi7568']/following-sibling::td/div/a")
	private WebElement CancelLink;

	public AppointmentHistorypage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public WebElement getCancelLink() {
		return CancelLink;
	}

}
