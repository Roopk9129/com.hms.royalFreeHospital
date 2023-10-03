package mock;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class EmiCaluculater {
	@Test
	public void emiCaluculater() {
		WebDriver cd = new ChromeDriver();
		cd.manage().window().maximize();
		cd.get("https://emicalculator.net/");
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement hover = cd.findElement(By.xpath("(//*[name()='path' and @class='highcharts-point'])[2]"));
		JavascriptExecutor js = (JavascriptExecutor) cd;
		js.executeScript("arguments[0].scrollIntoView()", hover);
		Actions act = new Actions(cd);
		act.moveToElement(hover).perform();
		act.moveByOffset(251, 31).perform();
		String text1 = cd.findElement(By.xpath("//*[name()='g'][@class='highcharts-label highcharts-tooltip highcharts-color-undefined']")).getText();
		System.out.println(text1);
	}

}
