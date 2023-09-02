package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChooseMonthTest {
	public static void main(String[] args) {
		String Year="2023";
		String month ="September";
		
		String givenYear="2023";
		String givenMonth="November";
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		driver.findElement(By.xpath("//span[.='Departure']")).click();
		
		for(int i=0;Year.equalsIgnoreCase(givenYear);i++) {
			for(int j=0; Year.equalsIgnoreCase(givenMonth); j++) {
				
			}
			
			
			
		}
		
		
		
		
	}

}
