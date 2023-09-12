package Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest {

	public static void main(String[] args) {
		String UrlName = "https://www.amazon.in/";
		String BrandName = "Samsung";
		int price = 20000;

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(UrlName);

		String CaptchaElement = "//input[@id='captchacharacters']";
//		Boolean CaptchaElementEle = driver.findElement(By.xpath(CaptchaElement)).isDisplayed();

//		for (; CaptchaElementEle;) {
//			driver.navigate().refresh();
//
//		}
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

//				for (WebElement elem : PT) {
//				String PTTxt = elem.getText();
//					
//					System.out.println(PTTxt);
//				}

			}

		}
	}
}
