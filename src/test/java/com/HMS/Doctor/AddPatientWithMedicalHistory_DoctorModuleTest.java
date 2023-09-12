package com.HMS.Doctor;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
		//property file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		prop.getProperty("browsername");
		// Browser Control
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://rmgtestingserver/domain/Hospital_Management_System/");

//				RandomInt
		Random r = new Random();
		int ranInt = r.nextInt(10000);
		int TempranInt = r.nextInt(100);

		// Key Values
		String ModuleName = "Doctors Login";
		String un = "Cordiologist.Prasad@mail.com";
		String psd = "prasad123";

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
