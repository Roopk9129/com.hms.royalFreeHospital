package com.HMS.User;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookAppointmentCanceltheAppointment_UserModuleTest {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * @author: S Roop Kumar 
		 * Click on Book 'Appointment History' from Main
		 * Navigation pane Click on 'cancel' link under Action column Click 'Ok' on
		 * alert Message
		 * 
		 */

		// Browser Control
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://rmgtestingserver/domain/Hospital_Management_System/");

		// Key Values
		String ModuleName = "Patients";
		String un = "23rdsep@gmail.com";
		String psd = "9876543210";
		String doctorSpec = "Urology";
		String Dname = "Karthi7568";
		String Date = "2023-09-22";

		// Test Script
		driver.findElement(By.xpath("//h3[text()='" + ModuleName
				+ "']/ancestor::div[@class='listview_1_of_3 images_1_of_3']/descendant::a")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(psd, Keys.ENTER);
		driver.findElement(By.xpath("//span[text()=' Book Appointment ']")).click();
		driver.findElement(By.xpath("//select[@name='Doctorspecialization']")).click();
		driver.findElement(By.xpath("//option[contains(text(),'" + doctorSpec + "')]")).click();
		driver.findElement(By.xpath("//select[@id='doctor']/descendant::option[text()='" + Dname + "']")).click();
		driver.findElement(By.xpath("//input[@name='appdate']")).sendKeys(Date);
		driver.findElement(By.xpath("//button[@name='submit']")).click();

		Alert a = driver.switchTo().alert();
		a.accept();
		driver.findElement(By.xpath("//span[text()=' Appointment History ']")).click();
		driver.findElement(By.xpath("(//td[text()='" + Dname + "']/following-sibling::td/div/a[text()='Cancel'])[1]"))
				.click();
		a.accept();

		WebElement ConfMsg = driver.findElement(By.xpath("//p[contains(text(),'Your appointment canceled !!')]"));

		if (ConfMsg.isDisplayed()) {
			System.out.println("Confirmation message is displayed");
		} else {
			System.out.println("Confirmation message is not displayed");
		}
		if (ConfMsg.getText().equals("Your appointment canceled !!")) {
			System.out.println("Appointment is successfully cancelled");

		} else {
			System.out.println("Appointment is failed to cancel");
		}Thread.sleep(2000);
		driver.quit();

	}

}
