package mock;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GetAttributeValue {
	@Test
	public void getAttributeValue() {
		WebDriver cd = new ChromeDriver();

		cd.manage().window().maximize();
		cd.get("https://www.amazon.in/ANNI-DESIGNER-Straight-Tbh-Blue_L_Blue_Large/dp/B0C3QNM5VM/ref=sr_1_8?crid=29B3W78U8Z8KH&keywords=kurta&qid=1696325816&sprefix=kurth%2Caps%2C283&sr=8-8");
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		List<WebElement> fds = cd.findElements(By.xpath("(//*[name()='path' and @class='highcharts-point'])[2]"));
		
		for(WebElement ele : fds) {
			System.out.println(ele.getAttribute("alt"));
			
		}

	}

}
