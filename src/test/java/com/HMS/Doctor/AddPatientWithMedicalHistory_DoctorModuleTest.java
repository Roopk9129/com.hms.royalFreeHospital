package com.HMS.Doctor;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.hms.genericUtils.ExcelFileUtility;
import com.hms.genericUtils.FileUtility;
import com.hms.genericUtils.Java_Utils;
import com.hms.genericUtils.WebDriver_Utils;

public class AddPatientWithMedicalHistory_DoctorModuleTest {
	/*
	 * @author: S Roop Kumar
	 * 
	 * Click on 'Patients' dropdown and select 'Add Patient' option Fill all the
	 * fields click on Add Click on 'Patients' dropdown and select 'Manage Patient'
	 * option Select particular patient and click on eye icon Click on 'Add Medical
	 * History' button Provide all the details and click on 'Submit' button Click on
	 * Submit button Click on Ok
	 * 
	 */

	public static void main(String[] args) throws Throwable {
		WebDriver driver = null;
		// Object Creation for Utility Files
		FileUtility fUtil = new FileUtility();
		WebDriver_Utils wUtil = new WebDriver_Utils();
		ExcelFileUtility EUtil = new ExcelFileUtility();
		Java_Utils jUtil = new Java_Utils();
		
		
		String brow = fUtil.propertyFileDataFetch("browsername");
		String Url = fUtil.propertyFileDataFetch("url");
		String un = fUtil.propertyFileDataFetch("doctorun");
		String psd = fUtil.propertyFileDataFetch("doctorpsd");

		// Browser Control
		if (brow.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			System.out.println("Chrome has launched");

		} else if (brow.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			System.out.println("Firefox has launched");

		} else {
			System.out.println("Invalid Browser name");
		}

		wUtil.maximizeBrowser(driver);
		driver.get(Url);
		wUtil.implicitWait(driver, 20);

//				RandomInt
		int TempranInt = jUtil.randomIntegerNumber(100);
		int ranInt = jUtil.randomIntegerNumber(10000);
		

		// Key Values
		String ModuleName = "Doctors Login";
		

		// Patient Details
		String PatientName = "Raja_" + ranInt;
		String PatientContactno = "9876543210";
		String PatientEmail = "raja123" + ranInt + "@gmail.com";
		String Gender = "male";
		String PatientAddress = "Bangalore";
		String PatientAge = "25";
		String MedicalHistory = "Blood group: A+, Body temperature: " + TempranInt;

		// Test Script
		driver.findElement(By.xpath("//h3[text()='" + ModuleName
				+ "']/ancestor::div[@class='listview_1_of_3 images_1_of_3']/descendant::a")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(psd, Keys.ENTER);
		driver.findElement(By.xpath("//span[text()=' Patients ']")).click();
		driver.findElement(
				By.xpath("//span[text()=' Patients ']/following::ul/descendant::span[text()=' Add Patient']")).click();

		driver.findElement(By.xpath("//input[@placeholder='Enter Patient Name']")).sendKeys(PatientName);
		driver.findElement(By.xpath("//input[@placeholder='Enter Patient Contact no']")).sendKeys(PatientContactno);
		driver.findElement(By.xpath("//input[@placeholder='Enter Patient Email id']")).sendKeys(PatientEmail);
		driver.findElement(
				By.xpath("//div[@class='clip-radio radio-primary']/descendant::label[@for='rg-" + Gender + "']"))
				.click();
		driver.findElement(By.xpath("//textarea[@placeholder='Enter Patient Address']")).sendKeys(PatientAddress);

		driver.findElement(By.xpath("//input[@placeholder='Enter Patient Age']")).sendKeys(PatientAge);
		driver.findElement(By.xpath("//textarea[@placeholder='Enter Patient Medical History(if any)']"))
				.sendKeys(MedicalHistory);
		driver.findElement(By.id("submit")).click();
		driver.findElement(By.xpath("//span[text()=' Patients ']")).click();

		driver.findElement(
				By.xpath("//span[text()=' Patients ']/following::ul/descendant::span[text()=' Manage Patient ']"))
				.click();

		List<WebElement> PatientNames = driver.findElements(By.xpath("//td[@class='hidden-xs']"));
		// Validation
		for (WebElement PN : PatientNames) {
			String NOTP = PN.getText();
			if (NOTP.equals(PatientName)) {
				System.out.println("Patient has been added Successfully");
				break;
			}
		}
		Thread.sleep(2000);
		driver.quit();
	}

}
