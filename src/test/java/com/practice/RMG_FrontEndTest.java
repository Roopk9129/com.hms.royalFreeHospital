package com.practice;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.jdbc.Driver;

public class RMG_FrontEndTest {

	public static void main(String[] args) throws Throwable {

		// Key Values
		String status = "created";
		int teamSize = 0;
		// Random Numbers
		Random r = new Random();
		int ranNum = r.nextInt(2000000);

		// Front end Values
		String UrlName = "http://rmgtestingserver:8084/";
		String UN = "rmgyantra";
		String PSD = "rmgy@9999";
		String ProgId = "TY_PROJ_" + ranNum;

		// date
		LocalDate LD = LocalDate.now();
		String str = LD.toString();

		// DataBase values
		String url = "jdbc:mysql://rmgtestingserver:3333/projects";
		String un = "root@%";
		String psd = "root";
		String query = "insert into project values(" + "'" + ProgId + "'" + "," + "'HMS_Manager_" + ranNum + "'" + ','
				+ "'" + str + "'" + ',' + "'TYSS_PROJ_HMS_" + ranNum + "'" + ',' + "'" + status + "'" + ',' + teamSize
				+ ");";

		System.out.println(query);
		Connection con = null;

		// BackEnd Validation
		Driver d = new Driver();
		DriverManager.registerDriver(d);
		con = DriverManager.getConnection(url, un, psd);
		Statement state = con.createStatement();
		int res = state.executeUpdate(query);

		if (res >= 1) {
			System.out.println("Data has been Created in database");

		} else {
			System.out.println("Data creation failed");
		}
		con.close();

		// X paths
		String UNTXTFld = "//input[@id='usernmae']";
		String UNPsdFld = "//input[@id='inputPassword']";
		String ProjectMainTab = "//a[.='Projects']";

		// Browser Control
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(UrlName);

		// finding element
		WebElement UserNameTxtField = driver.findElement(By.xpath(UNTXTFld));
		WebElement PsdTxtField = driver.findElement(By.xpath(UNPsdFld));

		// TestScript
		UserNameTxtField.sendKeys(UN);
		PsdTxtField.sendKeys(PSD, Keys.ENTER);
		driver.findElement(By.xpath(ProjectMainTab)).click();
		boolean flag = false;

		// Validation
		List<WebElement> FrontEndID = driver
				.findElements(By.xpath("//table[@class='table table-striped table-hover']/descendant::tr[*]/td[1]"));

		for (WebElement ele : FrontEndID) {
			String txt = ele.getText();

			if (txt.equals(ProgId)) {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println("Data present in FrontEnd");

		} else {
			System.out.println("Data not present in FrontEnd");
		}

	}

}
