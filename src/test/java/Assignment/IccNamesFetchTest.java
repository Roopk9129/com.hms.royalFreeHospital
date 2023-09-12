package Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IccNamesFetchTest {

	public static void main(String[] args) {

		String UrlName = "https://www.icc-cricket.com/rankings/womens/team-rankings/odi";

		// xpaths
//		String MatchesCount = "//table/tbody/tr[*]/td[3][@class='table-body__cell u-center-text' and text()<40]";
		String CountryNames = "//table/tbody/tr[*]/td[3][@class='table-body__cell u-center-text' and text()<40]/preceding-sibling::td/following-sibling::td/descendant::span[@class='u-hide-phablet']";

		// Browser config
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(UrlName);

		// Finding Element
//		List<WebElement> MatchesCounts = driver.findElements(By.xpath(MatchesCount));
		List<WebElement> CountryNamesEle = driver.findElements(By.xpath(CountryNames));
		String CountryNamesTxt = null;
		for (WebElement elem : CountryNamesEle) {
			CountryNamesTxt = elem.getText();
			System.out.println(CountryNamesTxt);
		}

	}

}
