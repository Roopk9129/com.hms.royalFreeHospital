package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class UsingCmdTest {

	@Test
	public void m1() {
		WebDriver driver = null;
		String Browser = System.getProperty("browser");
		String URL = System.getProperty("url");
		String UN = System.getProperty("un");
		String PSD = System.getProperty("psd");

		// Browser config
		if (Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			System.out.println("Chrome has launched");
		} else if (Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		} else if (Browser.equalsIgnoreCase("edge")) {
			driver = new FirefoxDriver();

		} else {
			System.out.println("Invalid Browser");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);

		driver.findElement(By.xpath("//a[text()='Click Here' and @href='hms/user-login.php']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(UN);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PSD);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

}
