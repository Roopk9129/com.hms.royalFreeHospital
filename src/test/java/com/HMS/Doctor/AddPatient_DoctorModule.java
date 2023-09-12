package com.HMS.Doctor;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddPatient_DoctorModule {

	public static void main(String[] args) throws Throwable {
		// Browser Control
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://rmgtestingserver/domain/Hospital_Management_System/");

		// RandomInt
		Random r = new Random();
		int ranInt = r.nextInt(10000);
		int TempranInt = r.nextInt(100);

		// Key Values
		String ModuleName = "Doctors Login";
		String un = "Cordiologist.Prasad@mail.com";
		String psd = "prasad123";

		// Test Data from excel
		FileInputStream fi = new FileInputStream(".//src//test//resources//Admin_Module.xlsx");
		Workbook w = WorkbookFactory.create(fi);
		Sheet sh = w.getSheet("Doctor_Details__AdminModule");
		int lr = sh.getLastRowNum();

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

		HashedMap<String, String> map = new HashedMap<>();

		for (int i = 1; i <= lr; i++) {
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}

		for (Entry<String, String> ss : map.entrySet()) {
			if(ss.getKey().equals("doctorname")) {
				driver.findElement(By.xpath(ss.getKey())).sendKeys(ss.getValue());
				
			}
			

		}
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
		driver.close();
	}

}