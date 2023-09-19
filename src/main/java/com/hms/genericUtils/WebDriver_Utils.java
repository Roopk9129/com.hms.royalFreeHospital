package com.hms.genericUtils;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.bouncycastle.jcajce.provider.asymmetric.ecgost.KeyAgreementSpi.ECVKO;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriver_Utils {
	/**
	 * This method is used to maximize the browser window
	 * 
	 * @param driver
	 */
	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to minimize the browser window
	 * 
	 * @param driver
	 */
	public void minimizeBrowser(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * This method is used for implicit wait
	 * 
	 * @param driver
	 * @param time
	 */
	public void implicitWait(WebDriver driver, int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}

	public void waitUntilUrlLoads(WebDriver driver, int duration, String expectedurl) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.urlContains(expectedurl));

	}

	/**
	 * 
	 * This method will wait until the title of the page get load
	 * 
	 * @param driver
	 * @param duration
	 * @param expectedTitle
	 * 
	 */

	public void waitUntilTitleLoads(WebDriver driver, int duration, String expectedTitle) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.titleContains(expectedTitle));

	}

	/**
	 * 
	 * This method will wait until the elementt0 be click able of the page get load
	 * 
	 * @param driver
	 * 
	 * @param duration
	 * @param element
	 * 
	 */

	public void waitUntilElementToBeClickable(WebDriver driver, int duration, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method will wait until the element to be visible in the page
	 * 
	 * @param element @ throws InterruptedException
	 */

	public void customWait(WebElement element) throws InterruptedException {

		int count = 0;
		while (count < 20) {
			try {
				element.click();
				break;
			} catch (Exception e) {
				Thread.sleep(2000);
				count++;
			}
		}
	}

	/**
	 * 
	 * This method will ignore NosuchElementexception and continues the execution
	 * 
	 * @param driver
	 * @param duration
	 * 
	 */

	public void ignoreSuchElementException(WebDriver driver, int duration) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);

	}

	/**
	 * This method is used to handle the dropdowns by index
	 * 
	 * @param element
	 * @param index
	 */
	public void dropdownHandle(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * This method is used to handle the dropdowns by Visible text
	 * 
	 * @param element
	 * @param VisibleTxt
	 */
	public void dropdownHandle(WebElement element, String VisibleTxt) {
		Select sel = new Select(element);
		sel.selectByVisibleText(VisibleTxt);
	}

	/**
	 * This method is used to handle the dropdowns by Value
	 * 
	 * @param element
	 * @param element
	 */
	public void dropdownHandle(String value, WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(value);
	}

	/**
	 * This method is used to hovering the mouse to particular webelement
	 * 
	 * @param driver
	 * @param element
	 */
	public void moveToElement(WebDriver driver, WebElement element) {
		new Actions(driver).moveToElement(element);
	}

	/**
	 * 
	 * This method is used to switch from one frame to another using index
	 * 
	 * @param driver
	 * 
	 * @param index
	 * 
	 */

	public void switchFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * 
	 * This method is used to switch from one frame to another using id
	 * 
	 * @param driver
	 * 
	 * @param id
	 * 
	 */

	public void switchFrame(WebDriver driver, String id) {
		driver.switchTo().frame(id);
	}

	/**
	 * This method is used to switch from one frame to another using id
	 * 
	 * @param driver
	 * @param element
	 */

	public void switchFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * This method is used to switch to main frame
	 * 
	 * @param driver
	 * 
	 */

	public void switchToMainFram(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * 
	 * This method is used to accept alert pop-up
	 * 
	 * @param driver
	 * @param expectedMsg
	 * 
	 */

	public void clickOnEnterKey(WebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();

	}

	/**
	 * This method is used to right click on particular webelement
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element) {
		new Actions(driver).contextClick(element);

	}

	/**
	 * This method is used to double click on particular webelement
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver, WebElement element) {
		new Actions(driver).doubleClick(element).perform();
		;
	}

	/**
	 * This method is used to accept the alert pop-up
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public void acceptAlert(WebDriver driver, String ExpectedAlertMsg, String PrintStatement, String elseMessage)
			throws InterruptedException {

		Alert ala = driver.switchTo().alert();
		if (ala.getText().equalsIgnoreCase(ExpectedAlertMsg)) {
			System.out.println(PrintStatement);
		} else {
			System.out.println(elseMessage);
		}
		Thread.sleep(2000);
		ala.accept();

	}

	public void acceptAlert(WebDriver driver) {
		Alert ala = driver.switchTo().alert();
		ala.accept();
	}
	 public String getAlertText(WebDriver driver) {
		 Alert alt = driver.switchTo().alert();
		 return alt.getText();
		 
	 }

	/**
	 * This method is used to dismiss the alert
	 * 
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method is used to handle the windows
	 * 
	 * @param driver
	 * @param ExpectedTitle
	 */
	public void windowHandles(WebDriver driver, String ExpectedTitle) {
		Set<String> wind = driver.getWindowHandles();
		for (String st : wind) {
			driver.switchTo().window(st);
			String title = driver.getTitle();
			if (title.contains(ExpectedTitle)) {
				break;
			}
		}
	}

	/**
	 * 
	 * This method is used to switch from one window to another based on url
	 * 
	 * @param driver
	 * 
	 * @param expectedURL
	 */

	public void switchWindowBasedOnUrl(WebDriver driver, String excpectedURL) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String wid = it.next();
			driver.switchTo().window(wid);
			String url = driver.getCurrentUrl();
			if (url.contains(excpectedURL)) {
				break;
			}
		}
	}

	/**
	 * This method is used to take the screenshots
	 * 
	 * @param driver
	 * @param FileName
	 * @return
	 * @throws Throwable
	 */

	public String takeScreenShot(WebDriver driver, String FileName) throws Throwable {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".//screenshots//" + FileName + ".png");
		Files.copy(src, dst);
		return FileName;
	}

	/**
	 * This method is used to scrollToParticular element
	 *
	 * @param driver
	 * @param element
	 * 
	 */
	public void scrollToParticularElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}

	/**
	 * This Method is used to drag and drop the element using element parameter
	 * 
	 * @param driver
	 * @param srcElement
	 * @param dstElement
	 */
	public void dragAndDropUsingElement(WebDriver driver, WebElement srcElement, WebElement dstElement) {
		Actions act = new Actions(driver);
		act.dragAndDrop(srcElement, srcElement).perform();

	}

	/**
	 * This Method is used to drag and drop the element using element, and off set
	 * parameter
	 * 
	 * @param driver
	 * @param x
	 * @param y
	 * @param srcElement
	 */
	public void dragAndDropUsingOffset(WebDriver driver, int x, int y, WebElement srcElement) {
		Actions act = new Actions(driver);
		act.dragAndDropBy(srcElement, x, y).perform();

	}

	/**
	 * This method is used to press the Enter Key
	 * 
	 * @throws Throwable
	 */

	public void pressEnterKey() throws Throwable {
		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_ENTER);
	}

	/**
	 * This method is used to press the Enter Key
	 * 
	 * @throws Throwable
	 */
	public void releaseEnterKey() throws Throwable {
		Robot robo = new Robot();
		robo.keyRelease(KeyEvent.VK_ENTER);
	}

}
