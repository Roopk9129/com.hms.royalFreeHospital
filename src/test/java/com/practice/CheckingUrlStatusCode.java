package com.practice;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckingUrlStatusCode {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get("https://www.irctc.co.in/");
		List<WebElement> anchorLinks = driver.findElements(By.tagName("//a"));
		System.out.println("Total Links are: " + anchorLinks.size());
		ArrayList<String> AL = new ArrayList<String>();

		for (int i = 0; i < anchorLinks.size(); i++) {
			String singleLink = anchorLinks.get(i).getAttribute("href");
			URL url = null;
			int statusCode = 0;
			try {
				url = new URL(singleLink);
				HttpsURLConnection HUC = (HttpsURLConnection) url.openConnection();
				statusCode = HUC.getResponseCode();
				if (statusCode >= 400) {
					AL.add(singleLink + "---> " + statusCode);
					System.out.println(singleLink + " --->" + statusCode);

				}

			} catch (Exception e) {
				AL.add(singleLink);

			}

		}

	}

}
