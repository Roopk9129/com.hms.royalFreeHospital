package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MakeMyTripTest {
	public static void main(String[] args) throws InterruptedException {
		int date=6;
		String monthAndYear = "January 2024";
		int x = 0, y = 40;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get("https://www.makemytrip.com/");

		// Handling ad's and login popup
		Actions act = new Actions(driver);
		Thread.sleep(3000);
		act.moveByOffset(x, y).click().perform();
		Thread.sleep(3000);
		act.moveByOffset(x, y).click().perform();
		
		
		driver.findElement(By.xpath("//div[contains(@class,'fsw_inputBox dates inactiveWidget')]")).click();
		Thread.sleep(2000);
		String actual ="//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Months']/descendant::div[@class='DayPicker-Month']/preceding::div[@class='DayPicker-Body']/following::p[text()='"+date+"']";
		for(;;) {
			try {
				driver.findElement(By.xpath(actual)).click();
				break;
			}catch(Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
				
			}
			
		}
		

	}

}
