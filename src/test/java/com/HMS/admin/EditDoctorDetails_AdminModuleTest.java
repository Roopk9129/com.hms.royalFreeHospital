package com.HMS.admin;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditDoctorDetails_AdminModuleTest {
	/*
	 * Admin should able to edit Doctor details
	 * 
	 * @Author S Roop Kumar
	 */

	public static void main(String[] args) {
		// Browser Control
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://rmgtestingserver/domain/Hospital_Management_System/");

		// RandomInt
		Random r = new Random();
		int ranInt = r.nextInt(10000);

		// Key Values
		String ModuleName = "Admin Login";
		String un = "admin";
		String psd = "Test@12345";
		String doctorSpec = "Urology";
		String DoctorName = "Karthi" + ranInt;
		String DoctorClinicAddress = "Doctor Clinic Address:1/115 venkatampatti,Dharmapuri";
		String DoctorConsultancyFees = "500";
		String DoctorContactno = "6382121323";

		// Test Script to create ADD DOCTOR SPECIALIZATION
		driver.findElement(By.xpath("//h3[text()='" + ModuleName
				+ "']/ancestor::div[@class='listview_1_of_3 images_1_of_3']/descendant::a")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(psd, Keys.ENTER);
		driver.findElement(By.xpath("//ul[@class='main-navigation-menu']/descendant::span[text()=' Doctors ']"))
				.click();
		driver.findElement(By.xpath(
				"//ul[@class='main-navigation-menu']/descendant::span[text()=' Doctors ']/following::span[text()=' Manage Doctors ']"))
				.click();
		driver.findElement(By.xpath("(//a[@tooltip='Edit'])[1]")).click();
		WebElement DoctorspecializationDropDown = driver
				.findElement(By.xpath("//select[@name='Doctorspecialization']"));
		DoctorspecializationDropDown.click();
		driver.findElement(By.xpath("//option[contains(text(),'" + doctorSpec + "')]")).click();

		WebElement Doctor_Name = driver.findElement(By.xpath("//input[@name='docname']"));
		WebElement Doctor_Clinic_Address = driver.findElement(By.xpath("//textarea[@name='clinicaddress']"));
		WebElement Doctor_Consultancy_Fees = driver.findElement(By.xpath("//input[@name='docfees']"));
		WebElement Doctor_Contact_no = driver.findElement(By.xpath("//input[@name='doccontact']"));
		WebElement SubBtn = driver.findElement(By.xpath("//button[@name='submit']"));

		Doctor_Name.clear();
		Doctor_Clinic_Address.clear();
		Doctor_Consultancy_Fees.clear();
		Doctor_Contact_no.clear();

		Doctor_Name.sendKeys(DoctorName);
		Doctor_Clinic_Address.sendKeys(DoctorClinicAddress);
		Doctor_Consultancy_Fees.sendKeys(DoctorConsultancyFees);
		Doctor_Contact_no.sendKeys(DoctorContactno);
		SubBtn.click();

		WebElement confirmationMsg = driver.findElement(
				By.xpath("//div[@class='col-md-12']/descendant::h5[contains(text(),'updated Successfully')]"));
		if (confirmationMsg.isDisplayed()) {
			System.out.println("Confirmation Message is Dispalyed");
			String confirmationTxt = confirmationMsg.getText();

			if (confirmationTxt.equalsIgnoreCase("Doctor Details updated Successfully")) {
				System.out.println("Doctor Details updated Successfully");

			}
		}

	}

}
