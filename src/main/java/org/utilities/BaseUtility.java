package org.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseUtility {
	public WebDriver startUp(String browserName) {
		WebDriver driver=null;
		if(browserName.equalsIgnoreCase("ch") ||
				browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"./drivers/chromedriver.exe");
			driver = new ChromeDriver();	//upcasting
		} else if(browserName.equalsIgnoreCase("ff") ||
				browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"./drivers/geckodriver.exe");
			driver = new FirefoxDriver();	//upcasting
		} else if(browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",
					"./drivers/msedgedriver.exe");
			driver = new EdgeDriver();	//upcasting
		} else {
			System.out.println("Invalid browser name!");
		}
		//upto selenium 3
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//selenium 4 onwards
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
//		driver.manage().window().setSize(new Dimension(250, 250));
//		driver.manage().window().minimize();	//selenium 4 onwards
//		driver.get(url);
		
		return driver;
	}
	public void waitForVisibilityOfWebElementByType(WebDriver driver,int time,String locatorType, String value) {
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(time));
		switch(locatorType) {
			case "xpath":wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
			break;
			case "css":wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(value)));
			break;
			case "id":wt.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
			break;
		}
	}
	public void waitForVisibilityOfWebElement(WebDriver driver,int time,WebElement ele) {
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(time));
		wt.until(ExpectedConditions.visibilityOf(ele));
	}
	public void clickByJS(WebElement ele, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("arguments[0].click();", ele);
	}
	public void scrollTillElementByJS(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", ele);
	}
	public void scrollByPageDown(WebDriver driver, int num) {
		for(int i=1; i<=num; i++) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.PAGE_DOWN);
		}
	}
	public boolean isAlertPresent(WebDriver driver, int time) {
		try {
			WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(time));
			wt.until(ExpectedConditions.alertIsPresent());
			return true;
		} catch(NoAlertPresentException e) {
			return false;
		}
	}
	public void clickByJS(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ele);
	}
	public void waitForUrlContains(WebDriver driver,int time,String urlPart) {
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(time));
		wt.until(ExpectedConditions.urlContains(urlPart));
	}
}