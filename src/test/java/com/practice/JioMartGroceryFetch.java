package com.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JioMartGroceryFetch {

	public static void main(String[] args) {
		// KeyValues
		String UrlName = "https://www.jiomart.com/";
		String ProductCatagory = "Groceries";
		String subNames = "Fruits & Vegetables";
		// Browser Control
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(UrlName);

		String MainPane = "//a[text()='" + ProductCatagory + "']";

		// finding element
		WebElement Groceries = driver.findElement(By.xpath(MainPane));

		Actions act = new Actions(driver);
		act.moveToElement(Groceries).perform();

		WebElement FandF = driver.findElement(By.xpath("//a[text()='" + subNames + "']"));
		act.moveToElement(FandF).perform();

		List<WebElement> subList = driver.findElements(
				By.xpath("//a[text()='Fruits & Vegetables']/ancestor::li[@id='nav_sub_cat_219']/descendant::li"));

		for (WebElement ele : subList) {
			String txt = ele.getText();
			System.out.println(txt);

		}

	}

}
