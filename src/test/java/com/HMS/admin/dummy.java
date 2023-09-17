package com.HMS.admin;

import java.time.Duration;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.hms.ObjectRepo.AddDoctorPage;
import com.hms.genericUtils.ExcelFileUtility;

public class dummy {
@Test
	public void main() throws Throwable {
//		ExcelFileUtility EUtil = new ExcelFileUtility();
//		WebDriver driver=new ChromeDriver();
//				HashedMap<String, String> stri = EUtil.getMultipleDataFromExcel(driver, "Doctor_Details__AdminModule", 1, 0, "getDoctorNameEdt()");
//		System.out.println(stri);
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("H:\\14-09\\Admin _ Add Doctor.html");
		AddDoctorPage ADPE = new AddDoctorPage(driver);
		ExcelFileUtility eut = new ExcelFileUtility();
//		ADPE.getDoctorSpecializationDD().click();
		String data = eut.pullMultipleDataFromSheet("Doctor_Details__AdminModule");
		ADPE.getDoctorNameEdt().sendKeys(data);
		
		
		
		

	}

}
