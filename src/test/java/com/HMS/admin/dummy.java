package com.HMS.admin;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class dummy  {
	@Test
	public void dum() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("H:\\14-09\\User _ Book Appointment.html");
		
	
		WebElement spec = driver.findElement(By.xpath("//select[@name='Doctorspecialization']"));
		Select sel = new Select(spec);
		sel.selectByVisibleText("Urology_6694");
//		List<WebElement> allop = sel.getOptions();
//		for(WebElement al:allop) {
//			System.out.println(al.getText());
//			
//		}
	}
	

}
