package Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProKabaddiTest {

	public static void main(String[] args) {

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
		String TotalMatchesWon = "//div[@class='table-row-wrap']/descendant::div[@class='team-name']/p[text()='" + Team
				+ "']/following::div[@class='table-data matches-won']";
		String TotalMatchesLost = "//div[@class='table-row-wrap']/descendant::div[@class='team-name']/p[text()='" + Team
				+ "']/following::div[@class='table-data matches-lost']";
		String TotalMatchesDraw = "//div[@class='table-row-wrap']/descendant::div[@class='team-name']/p[text()='" + Team
				+ "']/following::div[@class='table-data matches-draw']";
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

		//printing in console
		System.out.println();
		System.out.println("The Data of " + Team + " :");
		System.out.println();
		System.out.println("Total Matches Played: " + Played + "\n" + "Total Mathes Won: " + Won + "\n"
				+ "Total Matches Lost: " + Lost + "\n" + "Total Matches Draw: " + Draw + "\n" + "Score Difference: "
				+ ScDiff + "\n" + "Form: \n" + Formtxt + "\n" + "Total Points: " + Points);
	}

}
