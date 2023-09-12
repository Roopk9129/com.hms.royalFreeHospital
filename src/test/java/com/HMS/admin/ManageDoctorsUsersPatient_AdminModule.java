package com.HMS.admin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ManageDoctorsUsersPatient_AdminModule {
	/*
	 * @Author S Roop Kumar
	 * 
	 * System Test Case
	 * 
	 * click on Manage doctor click on edit icon in Manage doctors list page edit
	 * Doctor contact number click on users drop down from Main navigation Pane
	 * click on Manage user click on delete icon click on ok click on Patient drop
	 * down from Main navigation Pane click on Manage Patient click on view patient
	 * icon
	 * 
	 */

	public static void main(String[] args) {
		// Browser Control
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://rmgtestingserver/domain/Hospital_Management_System/");

		// Key Values
		String ModuleName = "Admin Login";
		String un = "admin";
		String psd = "Test@12345";

		// Test Script
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

		WebElement Doctor_Contact_no = driver.findElement(By.xpath("//input[@name='doccontact']"));

	}

}
