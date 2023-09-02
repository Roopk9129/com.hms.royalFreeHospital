package Assignment;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpiceJetTest {
	public static void main(String[] args) throws InterruptedException {
		// X paths
		String UrlName = "https://www.spicejet.com/";
		String Origin = "Banga";
		String DestinationDrop = "DE";

		String roundTripRadioButton = "//div[@data-testid='round-trip-radio-button']";
		String Source = "//div[@data-testid='to-testID-origin']/descendant::input";
		String Destination = "//div[@data-testid='to-testID-destination']/descendant::input";
		String DepatureDate = "//div[text()='Departure Date']";
		String DepatureMonth = "September ";
		String DepatureYear = "2023";
		int Depaturedate = 5;

		String ReturnMonth = "December ";
		String ReturnYear = "2023";
		int Returndate = 12;

		String Passengers = "//div[@data-testid='home-page-travellers']";
		String PassengersDropdown = "//div[@data-testid='Adult-testID-plus-one-cta']";
		int PassengerCount = 5;

		String ChooseDepatureDate = "//div[text()='" + DepatureMonth + "'and text()='" + DepatureYear
				+ "']/ancestor::div[@class='css-1dbjc4n r-1mdbw0j r-ymttw5 r-b2dl2 r-mzjzbw r-wk8lta r-tvv088']/descendant::div[text()='"
				+ Depaturedate + "']";
		String ReturnDate = "//div[text()='" + ReturnMonth + "'and text()='" + ReturnYear
				+ "']/ancestor::div[@class='css-1dbjc4n r-1mdbw0j r-ymttw5 r-b2dl2 r-mzjzbw r-wk8lta r-tvv088']/descendant::div[text()='"
				+ Returndate + "']";

		String Currency = "//div[.='Currency']";
		String CurrencyTypeTxt = "USD";
		String CurrencyType = "//div[@class='css-76zvg2 r-homxoj r-ubezar' and .='" + CurrencyTypeTxt + "']";
		String SubmitBtn = "//div[@data-testid='home-page-flight-cta']";

		// Browser Control
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(UrlName);

		// Finding Elements
		WebElement RElement = driver.findElement(By.xpath(roundTripRadioButton));
		WebElement SourceEle = driver.findElement(By.xpath(Source));
		WebElement DestinationEle = driver.findElement(By.xpath(Destination));
//		WebElement DepatureDateEle = driver.findElement(By.xpath(DepatureDate));
		WebElement PassengersEle = driver.findElement(By.xpath(Passengers));
		WebElement CurrencyEle = driver.findElement(By.xpath(Currency));
		WebElement SubmitBtnEle = driver.findElement(By.xpath(SubmitBtn));

		// Test Script
		RElement.click();
		SourceEle.sendKeys(Origin);
		DestinationEle.sendKeys(DestinationDrop);
		driver.findElement(By.xpath("//div[@class='css-76zvg2 r-cqee49 r-ubezar r-1kfrs79' and text()='Delhi']"))
				.click();
//		DepatureDateEle.click();
		driver.findElement(By.xpath(ChooseDepatureDate)).click();
		driver.findElement(By.xpath(ReturnDate)).click();
		PassengersEle.click();
		for (int i = 1; i < PassengerCount; i++) {
			driver.findElement(By.xpath(PassengersDropdown)).click();
		}
		CurrencyEle.click();
		driver.findElement(By.xpath(CurrencyType)).click();
		Thread.sleep(2000);
		SubmitBtnEle.click();

	}

}
