package com.HMS.admin;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ManageDoctor_AdminModuleTest {
	/*
	 * Admin should able to Manage Doctors
	 * 
	 * @author
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
		driver.findElement(By.xpath("(//a[@class='btn btn-transparent btn-xs tooltips'])[1]")).click();

		Alert cofir = driver.switchTo().alert();
		String Message = cofir.getText();
		if (Message.equalsIgnoreCase("Are you sure you want to delete?")) {
			System.out.println(Message + " --->Alert Popup is dispalyed ");
			cofir.accept();
			WebElement DataDeletedMessage = driver.findElement(By.xpath("//p[contains(text(),'data deleted !!')]"));
			if (DataDeletedMessage.isDisplayed()) {
				System.out.println(DataDeletedMessage.getText() + " ---> Confirmation Message has been displayed");

			} else {
				System.out.println("Confirmation Message has not been displayed");
			}

		} else {
			System.out.println("Alert popup is failed to display");
		}

	}

}
