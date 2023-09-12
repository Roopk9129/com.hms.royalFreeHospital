package Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class olympicsTokyo2020Medals {

	public static void main(String[] args) throws InterruptedException {
		String UrlName = "https://olympics.com/en/olympic-games/tokyo-2020/medals";
		String CountyName = "Japan";

		// BrowserConfig
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(UrlName);
//		System.out.println(driver.getTitle());

		// Xpaths
		/*String gold = "//span[text()='" + CountyName + "']/following::div[contains(@data-medal-id,'gold-medals-row')]";
		String silver = "//span[text()='" + CountyName
				+ "']/following::div[contains(@data-medal-id,'silver-medals-row')]";
		String brounze = "//span[text()='" + CountyName
				+ "']/following::div[contains(@data-medal-id,'bronze-medals-row')]";
		String total = "//span[text()='" + CountyName
				+ "']/following::div[contains(@data-medal-id,'total-medals-row')]";

		// Finding WebElelemts
		WebElement GoldMedal = driver.findElement(By.xpath(gold));
		WebElement SilverMedal = driver.findElement(By.xpath(silver));
		WebElement BrounzeMedal = driver.findElement(By.xpath(brounze));
		WebElement TotalMedals = driver.findElement(By.xpath(total));

		// Test Script
		String GoldMedalTxt = GoldMedal.getText();
		String SilverMedalTxt = SilverMedal.getText();
		String BrounzeMedalTxt = BrounzeMedal.getText();
		String TotalMedalsTxt = TotalMedals.getText();
		Thread.sleep(3000);
		// Console Output
		System.out.println("Gold Medals: " + GoldMedalTxt + "\n" + "Silver Medals: " + SilverMedalTxt + "\n"
				+ "Brounze Medals: " + BrounzeMedalTxt + "\n" + "Total Medals: " + TotalMedalsTxt);*/
		
			System.out.println("Country Name: "+CountyName);
			System.out.println("Gold Medals: "+driver.findElement(By.xpath("//span[text()='"+CountyName+"']/following::div[contains(@data-medal-id,'gold-medals-row')]")).getText());
			System.out.println("Silver Medals: "+driver.findElement(By.xpath("//span[text()='"+CountyName+"']/following::div[contains(@data-medal-id,'silver-medals-row')]")).getText());
			System.out.println("Bronze Medals: "+driver.findElement(By.xpath("//span[text()='"+CountyName+"']/following::div[contains(@data-medal-id,'bronze-medals-row')]")).getText());
			System.out.println("Total Medals: "+driver.findElement(By.xpath("//span[text()='"+CountyName+"']/following::div[contains(@data-medal-id,'total-medals-row')]")).getText());
		
		

	}

}
