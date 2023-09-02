package Assignment;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class kayakTest {
	public static void main(String[] args) throws InterruptedException {
		// Key Values
		String UrlName = "https://www.kayak.co.in/";
		String OriginCity = "Bengaluru";
		String DestinationCity = "Delhi";
		String MonthAndYear = "September 2023";
		int date = 12;
		String ReturnMonthAndYear = "October 2023";
		int ReturnDate = 12;
		String ExpectedWinTitle = "BLR";

		// X Paths
		String RemoveHyd = "//*[name()='svg' and @class='vvTc-item-icon']";
		String Origin = "//input[@aria-label='Flight origin input']";
		String Destination = "//input[@aria-label='Flight destination input']";
		String OriginAutoSugession = "//span[@class='JyN0-name' and contains(text(),'" + OriginCity + "')]";
		String DestinationAutoSugession = "//span[@class='JyN0-name' and contains(text(),'" + DestinationCity + "')]";
		String CalenderInput = "//span[@aria-label='Start date calendar input']";
		String PreviousIcon = "(//span[@class='tUEz-icon'])[1]";
		String ChoosenDate = "//div[@class='ATGJ-monthWrapper']/descendant::div[@class='onx_ onx_-pres-mcfly onx_-double']/descendant::div[text()='"
				+ MonthAndYear
				+ "']/following-sibling::div/following::div[@class='onx_-days'][1]/descendant::div[text()='" + date
				+ "']";
		String ChooseReturnDate = "(//div[@class='ATGJ-monthWrapper']/descendant::div[@class='onx_ onx_-pres-mcfly onx_-double'])[2]/descendant::div[text()='"
				+ ReturnMonthAndYear
				+ "']/ancestor::div[@class='onx_ onx_-pres-mcfly onx_-double']/descendant::div[@class='onx_-days']/descendant::div[text()='"
				+ ReturnDate + "']";
		String SearchBtn = "//button[@aria-label='Search']";
		String OtherSort = "//div[@aria-label='Other sort' and @role='button']";
		String FilterOptions = "//li[@aria-label='Slowest']";
		String Prices = "//div[@class='f8F1-price-text']";

		// Browser Control
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(UrlName);

		// Finding WebElements
		WebElement RemoveHydCancel = driver.findElement(By.xpath(RemoveHyd));
		WebElement OriginTxtField = driver.findElement(By.xpath(Origin));
		WebElement DestinationTxtField = driver.findElement(By.xpath(Destination));
		WebElement CalenderInputEle = driver.findElement(By.xpath(CalenderInput));
		WebElement SearchBtnEle = driver.findElement(By.xpath(SearchBtn));

		// Test Script
		RemoveHydCancel.click();
		OriginTxtField.sendKeys(OriginCity);
		driver.findElement(By.xpath(OriginAutoSugession)).click();
		DestinationTxtField.sendKeys(DestinationCity);
		driver.findElement(By.xpath(DestinationAutoSugession)).click();
		CalenderInputEle.click();
		driver.findElement(By.xpath(PreviousIcon)).click();
		driver.findElement(By.xpath(ChoosenDate)).click();
		driver.findElement(By.xpath(ChooseReturnDate)).click();
		SearchBtnEle.click();
		Thread.sleep(5000);
		windowHandle(driver, ExpectedWinTitle);
		driver.findElement(By.xpath(OtherSort)).click();
		driver.findElement(By.xpath(FilterOptions)).click();
		List<WebElement> ListOfPrices = driver.findElements(By.xpath(Prices));
		for (WebElement ele : ListOfPrices) {
			String PriceTxt = ele.getText();
			String normalized = PriceTxt.replaceAll("[^a-zA-Z0-9]", "");
			int ConvertedToInt = Integer.parseInt(normalized);

			// Checking Lowest with condition
			if (ConvertedToInt < 10000) {
				System.out.println(ConvertedToInt);
			}
		}
	}

	// Window Handling
	public static void windowHandle(WebDriver drive, String WindowTit) {
		Set<String> window = drive.getWindowHandles();
		for (String win : window) {
			drive.switchTo().window(win);
			String Tit = drive.getTitle();
			if (Tit.contains(WindowTit)) {
				break;
			}
		}
	}
}
