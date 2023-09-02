package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChooseMonthAndYearTest {

	public static void main(String[] args) {
		String MonthAndYear = "January 2024";
		int date = 5;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		driver.findElement(By.xpath("//span[.='Departure']")).click();

		String Actual = "//div[text()='" + MonthAndYear
				+ "']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()= '" + date + "' ]";
		String nextArrow = "//span[@aria-label='Next Month']";

		for (;;) {
			try {
				driver.findElement(By.xpath(Actual)).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath(nextArrow)).click();
			}

		}
		driver.findElement(By.xpath("//span[text()='Done']")).click();

	}

}
