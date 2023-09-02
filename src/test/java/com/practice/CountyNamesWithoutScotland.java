package com.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CountyNamesWithoutScotland {

	public static void main(String[] args) {
		String UrlName = "https://www.icc-cricket.com/";
		String exceptCountryName = "England";

		// Xpaths
		String Rankings = "//div[@class='main-navigation__header u-hide-desktop']/descendant::div[@class='main-navigation__desktop-navigation']/descendant::ul[@class='linked-list js-dynamic-list']/descendant::button[contains(text(),'Rankings')]";
		String MensteamRankings = "//div[@class='main-navigation__header u-hide-desktop']/descendant::a[@href='/rankings/mens/team-rankings']";
		String CountryNames = "//tbody/tr[*]/td[2]";

		// Browser Control
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get(UrlName);

		// Finding Elements
		WebElement RankingsEle = driver.findElement(By.xpath(Rankings));
		WebElement MensteamRankingsEle = driver.findElement(By.xpath(MensteamRankings));
		List<WebElement> CountryNamesEle = driver.findElements(By.xpath(CountryNames));

		Actions act = new Actions(driver);

		act.moveToElement(RankingsEle).perform();
		MensteamRankingsEle.click();
//		boolean flag = false;

		for (WebElement ele : CountryNamesEle) {

			String CountryNameTxt = ele.getText();
			System.out.println(CountryNameTxt);
		}

//			if (CountryNameTxt.equalsIgnoreCase(exceptCountryName)) {
//				flag = true;
//				break;

//			}

	}
//		if (!flag) {
//			System.out.println(exceptCountryName + " Not present");
//
//		} else {
//			System.out.println(exceptCountryName + "  present");
//
//		}

}
