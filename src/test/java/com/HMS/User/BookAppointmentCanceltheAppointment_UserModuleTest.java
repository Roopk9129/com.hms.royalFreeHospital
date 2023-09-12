package com.HMS.User;

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

public class BookAppointmentCanceltheAppointment_UserModuleTest {

	public static void main(String[] args) throws Throwable {
		/*
		 * @author: S Roop Kumar Click on Book 'Appointment History' from Main
		 * Navigation pane Click on 'cancel' link under Action column Click 'Ok' on
		 * alert Message
		 * 
		 */

		// Browser Control
		WebDriver driver = null;
		// Object Creation for Utility Files
		FileUtility fUtil = new FileUtility();
		WebDriver_Utils wUtil = new WebDriver_Utils();
		ExcelFileUtility EUtil = new ExcelFileUtility();
		Java_Utils jUtil = new Java_Utils();

		String brow = fUtil.propertyFileDataFetch("browsername");
		String Url = fUtil.propertyFileDataFetch("url");
		String un = fUtil.propertyFileDataFetch("userun");
		String psd = fUtil.propertyFileDataFetch("userpsd");

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

		// Key Values
		String ModuleName = "Patients";
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

		wUtil.acceptAlert(driver);
		driver.findElement(By.xpath("//span[text()=' Appointment History ']")).click();
		driver.findElement(By.xpath("(//td[text()='" + Dname + "']/following-sibling::td/div/a[text()='Cancel'])[1]"))
				.click();
		wUtil.acceptAlert(driver);

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
		}
		Thread.sleep(2000);
		driver.quit();

	}

}
