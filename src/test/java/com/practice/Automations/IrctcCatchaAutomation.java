package com.practice.Automations;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

public class IrctcCatchaAutomation {

	public static void main(String[] args) throws Throwable{
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//a[@aria-label='Click here to Login in application']")).click();
		WebElement captchaFrame = driver.findElement(By.xpath("//img[@class='captcha-img']"));
		File src = captchaFrame.getScreenshotAs(OutputType.FILE);
		String path="G:\\Selenium Practice\\com.hms.royalFreeHospital\\Images\\img.png";
		FileHandler.copy(src, new File(path));
		
		ITesseract it  = new Tesseract();
		it.setDatapath("G:\\Selenium Practice\\com.hms.royalFreeHospital\\Tess4J\\tessdata");
		String OCRText = it.doOCR(new File(path));
		System.out.println(OCRText);
		String Normalized = OCRText.trim().replaceAll(" ","");
		driver.findElement(By.xpath("//input[@id='captcha']")).sendKeys(Normalized);
		
	}

}
