package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class RmgYantra {

	public static void main(String[] args) throws Throwable {
		// DataBase values
		String url = "jdbc:mysql://rmgtestingserver:3333/projects";
		String un = "root@%";
		String psd = "root";
		String query = "SELECT * FROM PROJECT";
		Connection con = null;

		// Key values
		String UrlName = "http://rmgtestingserver:8084/";
		String UN = "rmgyantra";
		String PSD = "rmgy@9999";

		// X paths
		String UNTXTFld = "//input[@id='usernmae']";
		String UNPsdFld = "//input[@id='inputPassword']";
		String ProjectMainTab = "//a[.='Projects']";

		// Random Numbers
		Random r = new Random();
		int ranNum = r.nextInt(20000);

		// Input Values
		String ProjectName = "TYSS_PROJ_HMS_" + ranNum;
		String ProjectManager = "HMS_Manager_" + ranNum;
		String ProjectStatus = "Created";

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
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(ProjectName);
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys(ProjectManager);
		WebElement ProjectStatusDropDown = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		Select sel = new Select(ProjectStatusDropDown);
		sel.selectByVisibleText(ProjectStatus);
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();

		// BackEnd Validation
		Driver d = new Driver();
		DriverManager.registerDriver(d);
		con = DriverManager.getConnection(url, un, psd);
		Statement state = con.createStatement();
		ResultSet res = state.executeQuery(query);
		Boolean flag = false;

		while (res.next()) {
			String ActualRes = res.getString(4);
			if (ActualRes.equalsIgnoreCase(ProjectName)) {
				flag = true;
				break;

			}

		}
		if (flag) {
			System.out.println(ProjectName + " Project is created in Database");

		} else {
			System.out.println(ProjectName + " Project is not created in Database");

		}
	}

}
