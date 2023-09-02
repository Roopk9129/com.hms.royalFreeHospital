package Assignment;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class dummy {

	public static void main(String[] args) {
		String UrlName = "https://www.kayak.co.in/flights/BLR-DEL/2023-10-02/2023-10-09?sort=bestflight_a";

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(UrlName);
		
		System.out.println(driver.getTitle());
	}

}
