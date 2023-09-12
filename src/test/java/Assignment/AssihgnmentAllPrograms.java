package Assignment;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssihgnmentAllPrograms {

	public static void main(String[] args) throws Throwable {
		System.out.println(
				"Choose program for Excecution: \n 1. SpiceJet Program \n 2. Kayak Program \n 3. ICC-ODD Rankings Program \n 4. ProKabaddi Program \n 5. Olampic Tokyo 2020 Medals Program \n 6. Amazon Program \n \n Enter the S.no: ");
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();

		if (x == 1) {
			System.out.println("You had Choosen SpiceJet Program");
			Thread.sleep(1500);
			System.out.println("Wait... Program is being Excecuted...");
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
//			WebElement DepatureDateEle = driver.findElement(By.xpath(DepatureDate));
			WebElement PassengersEle = driver.findElement(By.xpath(Passengers));
			WebElement CurrencyEle = driver.findElement(By.xpath(Currency));
			WebElement SubmitBtnEle = driver.findElement(By.xpath(SubmitBtn));

			// Test Script
			RElement.click();
			SourceEle.sendKeys(Origin);
			DestinationEle.sendKeys(DestinationDrop);
			driver.findElement(By.xpath("//div[@class='css-76zvg2 r-cqee49 r-ubezar r-1kfrs79' and text()='Delhi']"))
					.click();
//			DepatureDateEle.click();
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

		} else if (x == 2) {
			System.out.println("You had Choosen Kayak Program");
			Thread.sleep(1500);
			System.out.println("Wait... Program is being Excecuted...");

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
			String DestinationAutoSugession = "//span[@class='JyN0-name' and contains(text(),'" + DestinationCity
					+ "')]";
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
			Thread.sleep(1000);
			List<WebElement> ListOfPrices = driver.findElements(By.xpath(Prices));
			for (WebElement ele : ListOfPrices) {
				String PriceTxt = ele.getText();
				String normalized = PriceTxt.replaceAll("[^a-zA-Z0-9]", "");
				int ConvertedToInt = Integer.parseInt(normalized);
				Thread.sleep(1000);

				// Checking Lowest with condition
				if (ConvertedToInt < 25000) {
					System.out.println(ConvertedToInt);
				}
			}

		} else if (x == 3) {
			System.out.println("You had Choosen ICC-ODD Rankings Program");
			Thread.sleep(1500);
			System.out.println("Wait... Program is being Excecuted...");

			String UrlName = "https://www.icc-cricket.com/rankings/womens/team-rankings/odi";

			// xpaths
//			String MatchesCount = "//table/tbody/tr[*]/td[3][@class='table-body__cell u-center-text' and text()<40]";
			String CountryNames = "//table/tbody/tr[*]/td[3][@class='table-body__cell u-center-text' and text()<40]/preceding-sibling::td/following-sibling::td/descendant::span[@class='u-hide-phablet']";

			// Browser config
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(UrlName);

			// Finding Element
//			List<WebElement> MatchesCounts = driver.findElements(By.xpath(MatchesCount));
			List<WebElement> CountryNamesEle = driver.findElements(By.xpath(CountryNames));
			String CountryNamesTxt = null;
			for (WebElement elem : CountryNamesEle) {
				CountryNamesTxt = elem.getText();
				System.out.println(CountryNamesTxt);
			}

		} else if (x == 4) {
			System.out.println("You had Choosen ProKabaddi Program");
			Thread.sleep(1500);
			System.out.println("Wait... Program is being Excecuted...");

			// key values
			String UrlName = "https://www.prokabaddi.com/standings";
			String Team = "Puneri Paltan";

			// Browser config
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(UrlName);

			// xpath
			String TotalMatchesPlayed = "//div[@class='table-row-wrap']/descendant::div[@class='team-name']/p[text()='"
					+ Team + "']/following::div[@class='table-data matches-play']";
			String TotalMatchesWon = "//div[@class='table-row-wrap']/descendant::div[@class='team-name']/p[text()='"
					+ Team + "']/following::div[@class='table-data matches-won']";
			String TotalMatchesLost = "//div[@class='table-row-wrap']/descendant::div[@class='team-name']/p[text()='"
					+ Team + "']/following::div[@class='table-data matches-lost']";
			String TotalMatchesDraw = "//div[@class='table-row-wrap']/descendant::div[@class='team-name']/p[text()='"
					+ Team + "']/following::div[@class='table-data matches-draw']";
			String ScoreDiff = "//div[@class='table-row-wrap']/descendant::div[@class='team-name']/p[text()='" + Team
					+ "']/following::div[@class='table-data score-diff']";
			String Form = "//div[@class='table-row-wrap']/descendant::div[@class='team-name']/p[text()='" + Team
					+ "']/following::div[@class='table-data form']";
			String Pts = "//div[@class='table-row-wrap']/descendant::div[@class='team-name']/p[text()='Jaipur Pink Panthers']/following::div[@class='table-data points']";

			// Finding Elements
			WebElement played = driver.findElement(By.xpath(TotalMatchesPlayed));
			WebElement won = driver.findElement(By.xpath(TotalMatchesWon));
			WebElement lost = driver.findElement(By.xpath(TotalMatchesLost));
			WebElement draw = driver.findElement(By.xpath(TotalMatchesDraw));
			WebElement scoreDiff = driver.findElement(By.xpath(ScoreDiff));
			WebElement form = driver.findElement(By.xpath(Form));
			WebElement points = driver.findElement(By.xpath(Pts));

			// Test Script
			String Played = played.getText();
			String Won = won.getText();
			String Lost = lost.getText();
			String Draw = draw.getText();
			String ScDiff = scoreDiff.getText();
			String Formtxt = form.getText();
			String Points = points.getText();

			// printing in console
			System.out.println();
			System.out.println("The Data of " + Team + " :");
			System.out.println();
			System.out.println("Total Matches Played: " + Played + "\n" + "Total Mathes Won: " + Won + "\n"
					+ "Total Matches Lost: " + Lost + "\n" + "Total Matches Draw: " + Draw + "\n" + "Score Difference: "
					+ ScDiff + "\n" + "Form: \n" + Formtxt + "\n" + "Total Points: " + Points);

		} else if (x == 5) {
			System.out.println("You had Choosen Olampic Tokyo 2020 Medals Program");
			Thread.sleep(1500);
			System.out.println("Wait... Program is being Excecuted...");

			String UrlName = "https://olympics.com/en/olympic-games/tokyo-2020/medals";
			String CountyName = "Japan";

			// BrowserConfig
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(UrlName);
//			System.out.println(driver.getTitle());

			// Xpaths
			/*
			 * String gold = "//span[text()='" + CountyName +
			 * "']/following::div[contains(@data-medal-id,'gold-medals-row')]"; String
			 * silver = "//span[text()='" + CountyName +
			 * "']/following::div[contains(@data-medal-id,'silver-medals-row')]"; String
			 * brounze = "//span[text()='" + CountyName +
			 * "']/following::div[contains(@data-medal-id,'bronze-medals-row')]"; String
			 * total = "//span[text()='" + CountyName +
			 * "']/following::div[contains(@data-medal-id,'total-medals-row')]";
			 * 
			 * // Finding WebElelemts WebElement GoldMedal =
			 * driver.findElement(By.xpath(gold)); WebElement SilverMedal =
			 * driver.findElement(By.xpath(silver)); WebElement BrounzeMedal =
			 * driver.findElement(By.xpath(brounze)); WebElement TotalMedals =
			 * driver.findElement(By.xpath(total));
			 * 
			 * // Test Script String GoldMedalTxt = GoldMedal.getText(); String
			 * SilverMedalTxt = SilverMedal.getText(); String BrounzeMedalTxt =
			 * BrounzeMedal.getText(); String TotalMedalsTxt = TotalMedals.getText();
			 * Thread.sleep(3000); // Console Output System.out.println("Gold Medals: " +
			 * GoldMedalTxt + "\n" + "Silver Medals: " + SilverMedalTxt + "\n" +
			 * "Brounze Medals: " + BrounzeMedalTxt + "\n" + "Total Medals: " +
			 * TotalMedalsTxt);
			 */

			System.out.println("Country Name: " + CountyName);
			System.out
					.println(
							"Gold Medals: " + driver
									.findElement(By.xpath("//span[text()='" + CountyName
											+ "']/following::div[contains(@data-medal-id,'gold-medals-row')]"))
									.getText());
			System.out
					.println(
							"Silver Medals: " + driver
									.findElement(By.xpath("//span[text()='" + CountyName
											+ "']/following::div[contains(@data-medal-id,'silver-medals-row')]"))
									.getText());
			System.out
					.println(
							"Bronze Medals: " + driver
									.findElement(By.xpath("//span[text()='" + CountyName
											+ "']/following::div[contains(@data-medal-id,'bronze-medals-row')]"))
									.getText());
			System.out
					.println(
							"Total Medals: " + driver
									.findElement(By.xpath("//span[text()='" + CountyName
											+ "']/following::div[contains(@data-medal-id,'total-medals-row')]"))
									.getText());

		} else if (x == 6) {
			System.out.println("You had Choosen Amazon Program");
			Thread.sleep(1500);
			System.out.println("Wait... Program is being Excecuted...");

			// Amazon prg
			String UrlName = "https://www.amazon.in/";
			String BrandName = "Samsung";
			int price = 20000;

			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(UrlName);

			String CaptchaElement = "//input[@id='captchacharacters']";
//			Boolean CaptchaElementEle = driver.findElement(By.xpath(CaptchaElement)).isDisplayed();

//			for (; CaptchaElementEle;) {
//				driver.navigate().refresh();
			//
//			}
			driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Phones", Keys.ENTER);
			driver.findElement(By.xpath(
					"//span[@class='a-size-base a-color-base']/ancestor::div[@id='brandsRefinements']/descendant::span[text()='"
							+ BrandName + "']"))
					.click();
			List<WebElement> PT = driver.findElements(By.xpath(
					"//div[@class='a-section a-spacing-none a-spacing-top-micro puis-price-instructions-style']//span[@class='a-price-whole'][number(translate(text(),'₹,',''))<20000]/preceding::span[@class='a-size-medium a-color-base a-text-normal']"));
			List<WebElement> RawPrices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
			for (WebElement ele : RawPrices) {
				String PriceTXT = ele.getText();
				String NormalizedTXT = PriceTXT.replaceAll("[^a-zA-Z0-9]", "");
				int convertedNum = Integer.parseInt(NormalizedTXT);
				if (convertedNum <= price) {
					System.out.println(convertedNum);
					sc.close();

//					for (WebElement elem : PT) {
//					String PTTxt = elem.getText();
//						
//						System.out.println(PTTxt);
//					}

				}

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
