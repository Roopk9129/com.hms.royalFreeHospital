package com.hms.ObjectRepo;

import java.util.Map.Entry;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.genericUtils.WebDriver_Utils;

public class AddDoctorPage extends WebDriver_Utils {
	@FindBy(xpath = "//select[@name='Doctorspecialization']")
	private WebElement DoctorSpecializationDD;

	@FindBy(xpath = "//input[@name='docname']")
	private WebElement DoctorNameEdt;

	@FindBy(xpath = "//textarea[@name='clinicaddress']")
	private WebElement ClinicAddress;

	@FindBy(xpath = "//input[@name='docfees']")
	private WebElement DoctorConsultancyFeesEdt;

	@FindBy(xpath = "//input[@name='doccontact']")
	private WebElement DoctorContactNoEdt;

	@FindBy(xpath = "//input[@name='docemail']")
	private WebElement DoctorEmailEdt;

	@FindBy(xpath = "//input[@name='npass']")
	private WebElement DoctorPsdEdt;

	@FindBy(xpath = "//input[@name='cfpass']")
	private WebElement DoctorCfPsdEdt;

	@FindBy(id = "submit")
	private WebElement SubmitBtn;

	public AddDoctorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getDoctorSpecializationDD() {
		return DoctorSpecializationDD;
	}

	public WebElement getDoctorNameEdt() {
		return DoctorNameEdt;
	}

	public WebElement getClinicAddress() {
		return ClinicAddress;
	}

	public WebElement getDoctorConsultancyFeesEdt() {
		return DoctorConsultancyFeesEdt;
	}

	public WebElement getDoctorContactNoEdt() {
		return DoctorContactNoEdt;
	}

	public WebElement getDoctorEmailEdt() {
		return DoctorEmailEdt;
	}

	public WebElement getDoctorPsdEdt() {
		return DoctorPsdEdt;
	}

	public WebElement getDoctorCfPsdEdt() {
		return DoctorCfPsdEdt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}

	public void createDoctor(WebDriver driver, HashedMap<String, String> map) {

		for (Entry<String, String> ss : map.entrySet()) {
			driver.findElement(By.xpath(ss.getKey())).sendKeys(ss.getValue());

		}
		getSubmitBtn().click();

//		getDoctorSpecializationDD().sendKeys(Spec);
//		getDoctorNameEdt().sendKeys(Name);
//		getClinicAddress().sendKeys(address);
//		getDoctorConsultancyFeesEdt().sendKeys(fee);
//		getDoctorContactNoEdt().sendKeys(contact);
//		getDoctorEmailEdt().sendKeys(email);
//		getDoctorPsdEdt().sendKeys(psd);
//		getDoctorCfPsdEdt().sendKeys(cnfpsd);

	}

	public void addDoctor(String spec, String Name, String address, String fee, String contact, String email,
			String psd, String cnfpsd) {
		dropdownHandle(getDoctorSpecializationDD(), spec);
		getDoctorNameEdt().sendKeys(Name);
		getClinicAddress().sendKeys(address);
		getDoctorConsultancyFeesEdt().sendKeys(fee);
		getDoctorContactNoEdt().sendKeys(contact);
		getDoctorEmailEdt().sendKeys(email);
		getDoctorPsdEdt().sendKeys(psd);
		getDoctorCfPsdEdt().sendKeys(cnfpsd);
		getSubmitBtn().click();
	}

}
